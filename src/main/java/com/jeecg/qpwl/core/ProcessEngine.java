package com.jeecg.qpwl.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.jeecg.qpwl.orderflow.entity.TFlowDefineEntity;
import com.jeecg.qpwl.orderflow.entity.TFlowExampleEntity;




@Service("processEngine")
public class ProcessEngine extends CommonServiceImpl implements ProcessEngineI{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 流程模板定义
	 */
	private List<TFlowDefineEntity> flowDefineList = new ArrayList<TFlowDefineEntity>();
	
	
	/**
	 * 描述：流程部署
	 * 作者：lyj
	 * Dec 21, 2017
	 */
	public FlowResult flowDeploy(){
		FlowResult result = null;
		return result;
	}
	/**
	 * 
	 * 描述：启动流程
	 * 作者：lyj
	 * Dec 21, 2017
	 */
	public FlowResult startFlow(String flowCode,TSUser user){
		try {
			String flowId = jdbcTemplate.queryForObject("select tf.id as \"flow_id\" from t_flow_define tf where tf.flow_code='"+flowCode+"' ",String.class);
			// 加载流程节点,并判断流程是否有开始节点
			Map resultMap = jdbcTemplate.queryForMap("select * from t_flow_task tt where tt.task_code in(select tt.next_task from t_flow_task tt where tt.flow_id=? and tt.task_type='startTask')",new Object[] { flowId });
			if (resultMap != null & resultMap.get("next_task") != null
					&& !"".equals(resultMap.get("next_task"))) {
				String  instance_id = UUID.randomUUID().toString().replaceAll("-", "");
				TFlowExampleEntity tFlowExample = new TFlowExampleEntity();
				tFlowExample.setCreateDate(new Date());
				tFlowExample
						.setCurrectTask((String) resultMap.get("task_code"));
				tFlowExample.setCurrentTaskName((String) resultMap
						.get("task_name"));
				tFlowExample.setFlowId(resultMap.get("flow_id").toString());
				tFlowExample.setInstanceId(instance_id);
				tFlowExample.setTaskParams("");
				// 调用派单策略,生成派单信息
				FlowResult result = qryPartyIds(resultMap, tFlowExample,user);
				if (result.getResultCode() != 0) {
					return result;
				}
				super.save(tFlowExample);//生成流程实例
				JSONObject resultData = new JSONObject();
				resultData.put("instance_id", instance_id);
				return FlowResult.buildSuccess(resultData);
			} else {
				return FlowResult.buildFailed(1, "流程配置有问题，没有找到开始节点或者下一节点");
			}
		} catch (Exception e) {
			return FlowResult.buildFailed(1, "起流程失败"+e.toString());
		}
	}
	
	/**
	 * 
	 * 描述：启动流程,带全局参数
	 * 作者：lyj
	 * Dec 21, 2017
	 */
	public FlowResult startFlow(String flowCode,TSUser user,JSONObject param){
		try {
			String flowId = jdbcTemplate.queryForObject("select tf.id as \"flow_id\" from t_flow_define tf where tf.flow_code='"+flowCode+"' ",String.class);
			// 加载流程节点,并判断流程是否有开始节点
			Map resultMap = jdbcTemplate.queryForMap("select * from t_flow_task tt where tt.task_code in(select tt.next_task from t_flow_task tt where tt.flow_id=? and tt.task_type='startTask')",new Object[] { flowId });
			if (resultMap != null & resultMap.get("next_task") != null
					&& !"".equals(resultMap.get("next_task"))) {
				String  instance_id = UUID.randomUUID().toString().replaceAll("-", "");
				TFlowExampleEntity tFlowExample = new TFlowExampleEntity();
				tFlowExample.setCreateDate(new Date());
				tFlowExample
						.setCurrectTask((String) resultMap.get("task_code"));
				tFlowExample.setCurrentTaskName((String) resultMap
						.get("task_name"));
				tFlowExample.setFlowId(resultMap.get("flow_id").toString());
				tFlowExample.setInstanceId(instance_id);
				tFlowExample.setInstanceParams(param.toString());
				tFlowExample.setTaskParams("");
				// 调用派单策略,生成派单信息
				FlowResult result = qryPartyIds(resultMap, tFlowExample,user);
				if (result.getResultCode() != 0) {
					return result;
				}
				super.save(tFlowExample);//生成流程实例
				JSONObject resultData = new JSONObject();
				resultData.put("instance_id", instance_id);
				return FlowResult.buildSuccess(resultData);
			} else {
				return FlowResult.buildFailed(1, "流程配置有问题，没有找到开始节点或者下一节点");
			}
		} catch (Exception e) {
			return FlowResult.buildFailed(1, "起流程失败"+e.toString());
		}
	}
	
	/**
	 * 派单类型
	 * @param taskMap
	 * @param tFlowExample
	 * @return
	 */
	private FlowResult qryPartyIds(Map taskMap,TFlowExampleEntity tFlowExample,TSUser user){
		if("MYSTA".equals(taskMap.get("party_type"))){//派单给流程发起者
			tFlowExample.setPartyId(user.getId());
			tFlowExample.setPartyType("MYSTA");
		}else if("JOB".equals(taskMap.get("party_type"))){//派单给指定的岗位
			//查询组织下岗位对应的人员信息
			List<Map<String,Object>> resultList = jdbcTemplate.queryForList("select tu.userid as \"userid\" from t_s_role_user tu where tu.roleid in ( select tr.org_id from t_s_role_org tr where tr.org_id=? and tr.org_id=?)",new Object[]{});
			tFlowExample.setPartyType("JOB");
			StringBuffer strBuffer = new StringBuffer();
			for(Map _map:resultList){
				strBuffer.append(_map.get("userid")+",");
			}
			tFlowExample.setPartyId(strBuffer.toString());		
		}else if("ORG".equals(taskMap.get("party_type"))){//派给指定的组织
			tFlowExample.setPartyType("ORG");
			List<Map<String,Object>> resultList = jdbcTemplate.queryForList("select tu.user_id from t_s_user_org tu where tu.org_id=? ",new Object[]{taskMap.get("party_ids")});
			StringBuffer strBuffer = new StringBuffer();
			for(Map _map:resultList){
				strBuffer.append(_map.get("userid")+",");
			}
			tFlowExample.setPartyId(strBuffer.toString());
		}else if("STA".equals(taskMap.get("party_type"))){//派给指定的人
			tFlowExample.setPartyId(taskMap.get("party_ids").toString());
			tFlowExample.setPartyType("STA");
		}else{
			return FlowResult.buildFailed(1, "起流程失败，没有找到指定的派单策略");
		}
		return FlowResult.buildSuccess(null);
	}
	

}
