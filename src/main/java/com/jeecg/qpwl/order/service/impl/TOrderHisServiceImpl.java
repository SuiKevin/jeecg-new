package com.jeecg.qpwl.order.service.impl;
import com.jeecg.qpwl.order.service.TOrderHisServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.qpwl.order.entity.TOrderHisEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("tOrderHisService")
@Transactional
public class TOrderHisServiceImpl extends CommonServiceImpl implements TOrderHisServiceI {

	
 	public void delete(TOrderHisEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(TOrderHisEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TOrderHisEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(TOrderHisEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(TOrderHisEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(TOrderHisEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(TOrderHisEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("resume_id", t.getResumeId());
		map.put("process_instance_id", t.getProcessInstanceId());
		map.put("create_date", t.getCreateDate());
		map.put("create_user_id", t.getCreateUserId());
		map.put("create_user_name", t.getCreateUserName());
		map.put("qzjob", t.getQzjob());
		map.put("name", t.getName());
		map.put("sex", t.getSex());
		map.put("age", t.getAge());
		map.put("gzjy", t.getGzjy());
		map.put("mqjob", t.getMqjob());
		map.put("invite_result", t.getInviteResult());
		map.put("invite_store", t.getInviteStore());
		map.put("invite_date", t.getInviteDate());
		map.put("invite_remarks", t.getInviteRemarks());
		map.put("business_name", t.getBusinessName());
		map.put("position_name", t.getPositionName());
		map.put("interview_result", t.getInterviewResult());
		map.put("interview_reason", t.getInterviewReason());
		map.put("interview_pick_date", t.getInterviewPickDate());
		map.put("examine_date", t.getExamineDate());
		map.put("examine_result", t.getExamineResult());
		map.put("examine_remarks", t.getExamineRemarks());
		map.put("pick_date", t.getPickDate());
		map.put("pick_result", t.getPickResult());
		map.put("work_tijian_result", t.getWorkTijianResult());
		map.put("work_fushi_result", t.getWorkFushiResult());
		map.put("work_hetong_result", t.getWorkHetongResult());
		map.put("ruzhi_fushi_result", t.getRuzhiFushiResult());
		map.put("ruzhi_hetong_result", t.getRuzhiHetongResult());
		map.put("ruzhi_tijian_result", t.getRuzhiTijianResult());
		map.put("ruzhi_peixun_result", t.getRuzhiPeixunResult());
		map.put("ruzhi_zhusu_result", t.getRuzhiZhusuResult());
		map.put("ruzhi_shanggang_result", t.getRuzhiShanggangResult());
		map.put("charge_zaizhi_result", t.getChargeZaizhiResult());
		map.put("charge_shoukuan_result", t.getChargeShoukuanResult());
		map.put("charge_jine", t.getChargeJine());
		map.put("charge_date", t.getChargeDate());
		map.put("charge_dlf_result", t.getChargeDlfResult());
		map.put("charge_dailifei", t.getChargeDailifei());
		map.put("flow_hj", t.getFlowHj());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,TOrderHisEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{resume_id}",String.valueOf(t.getResumeId()));
 		sql  = sql.replace("#{process_instance_id}",String.valueOf(t.getProcessInstanceId()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{create_user_id}",String.valueOf(t.getCreateUserId()));
 		sql  = sql.replace("#{create_user_name}",String.valueOf(t.getCreateUserName()));
 		sql  = sql.replace("#{qzjob}",String.valueOf(t.getQzjob()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{age}",String.valueOf(t.getAge()));
 		sql  = sql.replace("#{gzjy}",String.valueOf(t.getGzjy()));
 		sql  = sql.replace("#{mqjob}",String.valueOf(t.getMqjob()));
 		sql  = sql.replace("#{invite_result}",String.valueOf(t.getInviteResult()));
 		sql  = sql.replace("#{invite_store}",String.valueOf(t.getInviteStore()));
 		sql  = sql.replace("#{invite_date}",String.valueOf(t.getInviteDate()));
 		sql  = sql.replace("#{invite_remarks}",String.valueOf(t.getInviteRemarks()));
 		sql  = sql.replace("#{business_name}",String.valueOf(t.getBusinessName()));
 		sql  = sql.replace("#{position_name}",String.valueOf(t.getPositionName()));
 		sql  = sql.replace("#{interview_result}",String.valueOf(t.getInterviewResult()));
 		sql  = sql.replace("#{interview_reason}",String.valueOf(t.getInterviewReason()));
 		sql  = sql.replace("#{interview_pick_date}",String.valueOf(t.getInterviewPickDate()));
 		sql  = sql.replace("#{examine_date}",String.valueOf(t.getExamineDate()));
 		sql  = sql.replace("#{examine_result}",String.valueOf(t.getExamineResult()));
 		sql  = sql.replace("#{examine_remarks}",String.valueOf(t.getExamineRemarks()));
 		sql  = sql.replace("#{pick_date}",String.valueOf(t.getPickDate()));
 		sql  = sql.replace("#{pick_result}",String.valueOf(t.getPickResult()));
 		sql  = sql.replace("#{work_tijian_result}",String.valueOf(t.getWorkTijianResult()));
 		sql  = sql.replace("#{work_fushi_result}",String.valueOf(t.getWorkFushiResult()));
 		sql  = sql.replace("#{work_hetong_result}",String.valueOf(t.getWorkHetongResult()));
 		sql  = sql.replace("#{ruzhi_fushi_result}",String.valueOf(t.getRuzhiFushiResult()));
 		sql  = sql.replace("#{ruzhi_hetong_result}",String.valueOf(t.getRuzhiHetongResult()));
 		sql  = sql.replace("#{ruzhi_tijian_result}",String.valueOf(t.getRuzhiTijianResult()));
 		sql  = sql.replace("#{ruzhi_peixun_result}",String.valueOf(t.getRuzhiPeixunResult()));
 		sql  = sql.replace("#{ruzhi_zhusu_result}",String.valueOf(t.getRuzhiZhusuResult()));
 		sql  = sql.replace("#{ruzhi_shanggang_result}",String.valueOf(t.getRuzhiShanggangResult()));
 		sql  = sql.replace("#{charge_zaizhi_result}",String.valueOf(t.getChargeZaizhiResult()));
 		sql  = sql.replace("#{charge_shoukuan_result}",String.valueOf(t.getChargeShoukuanResult()));
 		sql  = sql.replace("#{charge_jine}",String.valueOf(t.getChargeJine()));
 		sql  = sql.replace("#{charge_date}",String.valueOf(t.getChargeDate()));
 		sql  = sql.replace("#{charge_dlf_result}",String.valueOf(t.getChargeDlfResult()));
 		sql  = sql.replace("#{charge_dailifei}",String.valueOf(t.getChargeDailifei()));
 		sql  = sql.replace("#{flow_hj}",String.valueOf(t.getFlowHj()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute("t_order_his",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}