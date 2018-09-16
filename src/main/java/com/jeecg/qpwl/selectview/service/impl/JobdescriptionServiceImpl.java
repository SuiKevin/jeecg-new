package com.jeecg.qpwl.selectview.service.impl;
import com.jeecg.qpwl.selectview.service.JobdescriptionServiceI;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.jeecg.qpwl.selectview.controller.SelectViewController;
import com.jeecg.qpwl.selectview.entity.CityEntity;
import com.jeecg.qpwl.selectview.entity.JobdescriptionEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;

@Service("jobdescriptionService")
@Transactional
public class JobdescriptionServiceImpl extends CommonServiceImpl implements JobdescriptionServiceI {

	@Autowired
	private SystemService systemService;
	
	public void queryALL(DataGrid dataGrid,JSONObject paramObj){
		StringBuffer qrySQL = new StringBuffer();
		qrySQL.append("select c.jobdesccode,c.jobdescname from jobdescription c where where 1=1 ");
		if(SelectViewController.roleTemp != null && SelectViewController.roleTemp.containsKey(ResourceUtil.getSessionUser().getId())){
			qrySQL.append(" and c.jobid = '"+SelectViewController.roleTemp.get(ResourceUtil.getSessionUser().getId()+"jobid")+"'");
		}else{
			qrySQL.append(" and c.jobid = 'sssss'");
		}
		if(!ResourceUtil.getSessionUser().getUserName().equals("admin")){//超级管理员不受权限控制
			//查询人员授权的职位详情
			StringBuffer provinceBuffer = new StringBuffer();
			provinceBuffer.append("( ");
			TSDepart depart = this.systemService.get(TSDepart.class, ResourceUtil.getSessionUser().getDepartid());
			String provinces[] = depart.getCityid().split(",");
			for(int i=0;i<provinces.length;i++){
				provinceBuffer.append("'"+provinces[i]+"',");
			}
			provinceBuffer.append("'')");
			qrySQL.append(" and c.CityID in " + provinceBuffer.toString());
		}
		System.out.println(qrySQL.toString());
		super.findDataGridForJdbc( dataGrid,qrySQL.toString(), CityEntity.class);
	}
	
 	public void delete(JobdescriptionEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(JobdescriptionEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(JobdescriptionEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(JobdescriptionEntity t) throws Exception{
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
	private void doUpdateBus(JobdescriptionEntity t) throws Exception{
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
	private void doDelBus(JobdescriptionEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(JobdescriptionEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("jobid", t.getJobid());
		map.put("jobdescname", t.getJobdescname());
		map.put("jobdesccode", t.getJobdesccode());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,JobdescriptionEntity t){
 		sql  = sql.replace("#{jobid}",String.valueOf(t.getJobid()));
 		sql  = sql.replace("#{jobdescname}",String.valueOf(t.getJobdescname()));
 		sql  = sql.replace("#{jobdesccode}",String.valueOf(t.getJobdesccode()));
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
					javaInter.execute("jobdescription",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}