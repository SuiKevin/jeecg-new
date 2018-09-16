package com.jeecg.qpwl.talentpool.service;
import com.jeecg.qpwl.core.FlowResult;
import com.jeecg.qpwl.talentpool.entity.JianliOnlineEntity;
import com.jeecg.qpwl.talentpool.entity.JinaliZhengshuEntity;
import com.jeecg.qpwl.talentpool.entity.JianliJiaoyuEntity;
import com.jeecg.qpwl.talentpool.entity.JianliJingyanEntity;

import java.util.List;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface JianliOnlineServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(JianliOnlineEntity jianliOnline,
	        List<JinaliZhengshuEntity> jinaliZhengshuList,List<JianliJiaoyuEntity> jianliJiaoyuList,List<JianliJingyanEntity> jianliJingyanList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(JianliOnlineEntity jianliOnline,
	        List<JinaliZhengshuEntity> jinaliZhengshuList,List<JianliJiaoyuEntity> jianliJiaoyuList,List<JianliJingyanEntity> jianliJingyanList);
	public void delMain (JianliOnlineEntity jianliOnline);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(JianliOnlineEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(JianliOnlineEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(JianliOnlineEntity t);
 	
 	public void qryAll(DataGrid dataGrid,JSONObject paramObj)throws Exception;
 	/**
 	 * 获取联系方式
 	 * @param jianliOnline
 	 * @return
 	 */
 	public FlowResult qryPhoneNo(JianliOnlineEntity jianliOnline)throws Exception;
}
