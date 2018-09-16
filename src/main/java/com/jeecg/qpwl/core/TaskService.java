package com.jeecg.qpwl.core;

import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.jeecg.qpwl.orderflow.entity.TFlowExampleEntity;
import com.jeecg.qpwl.orderflow.entity.TFlowExecuteHistoryEntity;
import com.jeecg.qpwl.orderflow.entity.TFlowTaskEntity;

/**
 * 任务管理器
 * @author liuya
 *
 */
@Service("taskService")
public class TaskService extends CommonServiceImpl implements TaskServiceI{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 完成任务
	 * @param taskId
	 * @param paramObj
	 */
	public FlowResult complete(String instanceId,TSUser user,Object paramObj){
		FlowResult result = null;
		try{
			//获取流程实例信息
			List<TFlowExampleEntity> tFlowExampleList = super.findByProperty(TFlowExampleEntity.class, "instanceId", instanceId);
			if(tFlowExampleList.size()>0){
				//获取当前环节信息
				List<TFlowTaskEntity> tFlowTaskList = super.findByProperty(TFlowTaskEntity.class, "taskCode", tFlowExampleList.get(0).getCurrectTask());
				if(tFlowTaskList.size() >0){
					tFlowTaskList.get(0).setParams(paramObj.toString());//设置环节参数
					FlowResult nextReuslt = qryNextTask(null,tFlowTaskList.get(0),user,instanceId);
					if(nextReuslt.getResultCode() == 1000){//流程结束
						return nextReuslt;
					}else if(nextReuslt.getResultCode() == 0){//流程没有结束，且找到下一环节
						TFlowTaskEntity nextTaskEntity = (TFlowTaskEntity) JSONObject.toBean(nextReuslt.getResultData(),TFlowTaskEntity.class);
						//获取派单规则
						result = qryPartyIds(nextTaskEntity,user,new JSONObject());
						if(result.getResultCode() == 0){
							//更新流程实例表
							tFlowExampleList.get(0).setCurrectTask(nextTaskEntity.getTaskCode());
							tFlowExampleList.get(0).setCurrentTaskName(nextTaskEntity.getTaskName());
							tFlowExampleList.get(0).setTaskParams("");
							tFlowExampleList.get(0).setPartyId(result.getResultData().optString("partyIds", user.getId()));
							tFlowExampleList.get(0).setPartyType(nextTaskEntity.getPartyType());
							super.updateEntitie(tFlowExampleList.get(0));
							return FlowResult.buildSuccess(null);
						}else{
							return result;
						}
					}else {
						return nextReuslt;
					}
				}else {
					return FlowResult.buildFailed(1, "流程下一节点不存在");
				}
			}else{
				return FlowResult.buildFailed(1, "完成任务失败,流程实例ID不存在");
			}
		}catch(Exception ex){
			return FlowResult.buildFailed(1, "任务执行失败:"+ex.toString());
		}
	}
	
	
	/**
	 * 认领任务
	 * @param taskId
	 * @param paramObj
	 */
	public FlowResult Claim(String taskId,Object paramObj){
		FlowResult result = null;
		try{
		}catch(Exception ex){
			
		}
		return result;
	}
	
	/**
	 * 流程跳转到下一人工环节
	 * @param TFlowExecuteHistoryEntity 上一环节信息（连接线用来跟新上一环节结果)
	 * @param tFlowTask 当前环节信息
	 * @param user 执行者信息
	 * @param instanceId 流程实例ID
	 * @return
	 */
	private FlowResult qryNextTask(TFlowExecuteHistoryEntity phis,TFlowTaskEntity tFlowTask,TSUser user,String instanceId) {
		if ("userTask".equals(tFlowTask.getTaskType())) {// 用户任务
			//插入历史记录表
			TFlowExecuteHistoryEntity his = new TFlowExecuteHistoryEntity();
			his.setInstanceId(instanceId);
			his.setCreateDate(new Date());
			his.setExecutorId(user.getId());
			his.setExecutorName(user.getRealName());
			his.setTaskCode(tFlowTask.getTaskCode());
			his.setTaskName(tFlowTask.getTaskName());
			his.setTaskResult("");
			his.setTaskRemark("");
			//查下一环节
			List<TFlowTaskEntity> nextTask = super.findByProperty(TFlowTaskEntity.class, "taskCode", tFlowTask.getNextTask());
			if(nextTask.size()>0){
				nextTask.get(0).setParams(tFlowTask.getParams());//将参数传递给连接线，用来作为连接线的判断条件
				return qryNextTask(his,nextTask.get(0),user,instanceId);
			}else{
				phis.setTaskResult("流程执行失败，根据条件找不到流程下一环节");
				super.save(phis);
				return FlowResult.buildFailed(1, "下一环节不存在");
			}
		} else if ("ifTask".equals(tFlowTask.getTaskType())) {// 排它网关
			//获取IF网关表达式
			/**
			 * 表达式样例
			 * IF[java表达式]{"line_note":"备注","next_task":"下一环节"}  ENDIF
			 */
			String expression = tFlowTask.getTaskExpression();
			JSONObject  paramObject = ("".equals(tFlowTask.getParams()) || null == tFlowTask.getParams())?new JSONObject():JSONObject.fromObject(tFlowTask.getParams());
			String next_task = "";//下一环节编码
			if(expression == null || "".equals(expression)){//说明不需要判断,则直接更新结果为成功
				phis.setTaskResult("执行成功");
				super.save(phis);
				next_task = tFlowTask.getNextTask();
				//查下一环节
				List<TFlowTaskEntity> nextTask = super.findByProperty(TFlowTaskEntity.class, "taskCode", next_task);
				if(nextTask.size() >0 ){
					//更新任务结果
					phis.setTaskResult("操作完成");
					super.save(phis);
					//判断下一环节时人工任务  还是自动任务，如果是自动任务则由程序调用。如果人工任务则返回等待人工操作
					String taskType = nextTask.get(0).getTaskType();
					if("userTask".equals(taskType)){
						return FlowResult.buildSuccess(JSONObject.fromObject(nextTask.get(0)));
					}else{
						//如果非人工任务，继续传递参数给后面的节点
						nextTask.get(0).setParams(tFlowTask.getParams());
						return qryNextTask(null,nextTask.get(0),user,instanceId);
					}
				}else{
					//更新结论
					phis.setTaskResult("流程执行失败，根据条件找不到流程下一环节");
					super.save(phis);
					return FlowResult.buildFailed(1, tFlowTask.getTaskName()+"环节对应的下一节点不存在");
				}
			}else{
				String nextTaskStr =  DynamicExceuteUtils.IFSourceException(expression,paramObject);
				if(nextTaskStr == null || "".equals(nextTaskStr)){
					//更新执行记录
					phis.setTaskResult("流程执行失败，根据条件找不到流程下一环节");
					super.save(phis);
					//跟新流程实例状态（10E)
					return FlowResult.buildFailed(1, "流程执行失败，根据条件找不到流程下一环节");
				}else{
					JSONObject nextObj = JSONObject.fromObject(nextTaskStr);
					//查找下一环节
					List<TFlowTaskEntity> tFlowTaskList = super.findByProperty(TFlowTaskEntity.class, "taskCode", nextObj.optString("next_task"));
					if(tFlowTaskList.size() > 0){
						//更新任务结果
						phis.setTaskResult(nextObj.optString("line_note","操作成功"));
						super.save(phis);
						//判断下一环节时人工任务  还是自动任务，如果是自动任务则由程序调用。如果人工任务则返回等待人工操作
						String taskType = tFlowTaskList.get(0).getTaskType();
						if("userTask".equals(taskType)){
							//如果非人工任务，继续传递参数给后面的节点
							tFlowTaskList.get(0).setParams(tFlowTask.getParams());
							return FlowResult.buildSuccess(JSONObject.fromObject(tFlowTaskList.get(0)));
						}else{
							return qryNextTask(null,tFlowTaskList.get(0),user,instanceId);
						}
					}else{
						return FlowResult.buildFailed(1, "流程执行失败，根据条件找不到流程下一环节");
					}
				}
			}
			
		} else if ("javaTask".equals(tFlowTask.getTaskType())) {// java服务任务
			//调用java程序
			try{
				JavaTaskInf javaTaskInf = (JavaTaskInf)Class.forName(tFlowTask.getTaskClasspath()).newInstance();
				FlowResult jataResult = javaTaskInf.execute(tFlowTask,JSONObject.fromObject(tFlowTask.getParams()));
				//更新执行结果
				//插入历史记录表
				TFlowExecuteHistoryEntity his = new TFlowExecuteHistoryEntity();
				his.setInstanceId(instanceId);
				his.setCreateDate(new Date());
				his.setExecutorId("");
				his.setExecutorName("系统自动执行");
				his.setTaskCode(tFlowTask.getTaskCode());
				his.setTaskName(tFlowTask.getTaskName());
				his.setTaskResult(jataResult.getResultMsg());
				super.save(his);
				if(jataResult.getResultCode() != 0){
					return jataResult;
				}else{
					//查下一环节
					List<TFlowTaskEntity> nextTask = super.findByProperty(TFlowTaskEntity.class, "taskCode", tFlowTask.getNextTask());
					if(nextTask.size()>0){
						nextTask.get(0).setParams(tFlowTask.getParams());//将参数传递给连接线，用来作为连接线的判断条件
						return qryNextTask(his,nextTask.get(0),user,instanceId);
					}else{
						phis.setTaskResult("流程执行失败，根据条件找不到流程下一环节");
						super.save(phis);
						return FlowResult.buildFailed(1, "下一环节不存在");
					}
					
				}
			}catch(Exception ex){
				return FlowResult.buildFailed(1,tFlowTask.getTaskName()+"环节类路径配置不正确,请联系管理员修改");
			}
		} else if ("endTask".equals(tFlowTask.getTaskType())) {// 结束节点
			//更新执行结果
			TFlowExecuteHistoryEntity his = new TFlowExecuteHistoryEntity();
			his.setInstanceId(instanceId);
			his.setCreateDate(new Date());
			his.setExecutorId("");
			his.setExecutorName("系统自动执行");
			his.setTaskCode(tFlowTask.getTaskCode());
			his.setTaskName(tFlowTask.getTaskName());
			his.setTaskResult("流程完成");
			super.save(his);
			//删除在线流程
			super.updateBySqlString("delete from t_flow_example where INSTANCE_ID = '"+instanceId+"'");
			return FlowResult.buildFailed(1000, "流程结束");
		}else if ("andTask".equals(tFlowTask.getTaskType())) {// 并发网关
			//暂未开发
			return FlowResult.buildFailed(1, "暂时不支持并发网关");
		} else if ("jobTask".equals(tFlowTask.getTaskType())) {// 定时任务
			//暂未开发
			return FlowResult.buildFailed(1, "暂时不支持定时任务");
		}
		return FlowResult.buildFailed(1, "任务类型不存在");
	}
	
	/**
	 * 插入当前环节
	 * @return
	 */
	private FlowResult instCurrectTask(){
		return null;
	}
	
	/**
	 * 获取执行者信息
	 * @return
	 */
	private FlowResult qryPartyIds(){
		return null;
	}
	
	/**
	 * 完成用户任务
	 * @return
	 */
	private FlowResult completeUserTask(){
		//获取下一流程信息
		
		return null;
	}
	
	/**
	 * 完成用户任务
	 * @return
	 */
	private FlowResult javaTask(){
		return null;
	}
	
	
	/**
	 * 执行排它网关
	 * @return
	 */
	private FlowResult ifTask(){
		return null;
	}
	
	/**
	 * 执行排它网关
	 * @return
	 */
	private FlowResult andTask(){
		return null;
	}
	/**
	 * 定时任务
	 * @return
	 */
	private FlowResult jobTask(){
		return null;
	}
	
	/**
	 * 派单规则
	 * @param taskEntity 当前环节
	 * @param flowParam 流程参数
	 * @return
	 */
	private FlowResult qryPartyIds(TFlowTaskEntity taskEntity,TSUser user,JSONObject flowParam){
		StringBuffer partyIds = new StringBuffer();
		if("MYSTA".equals(taskEntity.getPartyType())){//派单给流程发起者
			partyIds.append(user.getId());
		}else if("JOB".equals(taskEntity.getPartyType())){//派单给指定的岗位
			//查询组织下岗位对应的人员信息
			List<Map<String,Object>> resultList = jdbcTemplate.queryForList("select tu.userid as \"userid\" from t_s_role_user tu where tu.roleid in ("+taskEntity.getPartyIds()+") and tu.userid  in (select tt.user_id from t_s_user_org tt where tt.org_id =?)",new Object[]{ResourceUtil.getSessionUser().getCurrentDepart().getId()});
			StringBuffer strBuffer = new StringBuffer();
			if(resultList.size()<1){
				for(Map _map:resultList){
					strBuffer.append(_map.get("userid")+",");
				}
			}else{
				return FlowResult.buildFailed(1, "流程进入下一环节失败,当前组织下没有找到指定岗位的人员");
			}
		}else if("ORG".equals(taskEntity.getPartyType())){//派给指定的组织
			List<Map<String,Object>> resultList = jdbcTemplate.queryForList("select tu.user_id as userid from t_s_user_org tu where tu.org_id in ? ",new Object[]{taskEntity.getPartyIds()});
			if(resultList.size()<1){
				for(Map _map:resultList){
					partyIds.append(_map.get("userid")+",");
				}
			}else{
				return FlowResult.buildFailed(1, "流程进入下一环节失败,工单派发到的组织下没有人员。");
			}
		}else if("STA".equals(taskEntity.getPartyType())){//派给指定的人
			partyIds.append(taskEntity.getPartyIds());
		}else{
			return FlowResult.buildFailed(1, "起流程失败，没有找到指定的派单策略");
		}
		JSONObject resultDat = new JSONObject();
		resultDat.put("partyIds", partyIds.toString());
		return FlowResult.buildSuccess(resultDat);
	}
}
