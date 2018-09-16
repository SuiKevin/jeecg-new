package com.jeecg.qpwl.selectview.service.impl;
import com.jeecg.qpwl.selectview.service.JobServiceI;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.jeecg.qpwl.selectview.controller.SelectViewController;
import com.jeecg.qpwl.selectview.entity.CityEntity;
import com.jeecg.qpwl.selectview.entity.JobEntity;

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

@Service("jobService")
@Transactional
public class JobServiceImpl extends CommonServiceImpl implements JobServiceI {

	@Autowired
	private SystemService systemService;
	
	public void queryALL(DataGrid dataGrid,JSONObject paramObj){
		StringBuffer qrySQL = new StringBuffer();
		qrySQL.append("select c.CityID as cityid,c.CityName as cityname,c.ProvinceID as provinceid,c.CityCode as citycode from city c where 1=1 ");
		if(SelectViewController.roleTemp != null && SelectViewController.roleTemp.containsKey(ResourceUtil.getSessionUser().getId()+"province")){
			qrySQL.append(" and c.ProvinceID = '"+SelectViewController.roleTemp.get(ResourceUtil.getSessionUser().getId()+"province")+"'");
		}else{
			qrySQL.append(" and c.ProvinceID = 'ssss'");
		}
		if(!ResourceUtil.getSessionUser().getUserName().equals("admin")){//超级管理员不受权限控制
			//查找组织对应的省份
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
	
 	public void delete(JobEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(JobEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(JobEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(JobEntity t) throws Exception{
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
	private void doUpdateBus(JobEntity t) throws Exception{
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
	private void doDelBus(JobEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(JobEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("jobid", t.getJobid());
		map.put("jobname", t.getJobname());
		map.put("jobcode", t.getJobcode());
		map.put("positionid", t.getPositionid());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,JobEntity t){
 		sql  = sql.replace("#{jobid}",String.valueOf(t.getJobid()));
 		sql  = sql.replace("#{jobname}",String.valueOf(t.getJobname()));
 		sql  = sql.replace("#{jobcode}",String.valueOf(t.getJobcode()));
 		sql  = sql.replace("#{positionid}",String.valueOf(t.getPositionid()));
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
					javaInter.execute("job",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}