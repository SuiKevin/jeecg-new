package com.jeecg.qpwl.talentpool.service;
import java.util.List;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import com.jeecg.qpwl.core.FlowResult;
import com.jeecg.qpwl.talentpool.entity.JianliBusinessEntity;
import com.jeecg.qpwl.talentpool.entity.JianliBusinessJiaoyuEntity;
import com.jeecg.qpwl.talentpool.entity.JianliBusinessJingyanEntity;
import com.jeecg.qpwl.talentpool.entity.JinaliBusinessZhengshuEntity;

public interface JianliBusinessServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(JianliBusinessEntity jianliBusiness,
	        List<JianliBusinessJiaoyuEntity> jianliBusinessJiaoyuList,List<JianliBusinessJingyanEntity> jianliBusinessJingyanList,List<JinaliBusinessZhengshuEntity> jinaliBusinessZhengshuList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(JianliBusinessEntity jianliBusiness,
	        List<JianliBusinessJiaoyuEntity> jianliBusinessJiaoyuList,List<JianliBusinessJingyanEntity> jianliBusinessJingyanList,List<JinaliBusinessZhengshuEntity> jinaliBusinessZhengshuList);
	public void delMain (JianliBusinessEntity jianliBusiness);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(JianliBusinessEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(JianliBusinessEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(JianliBusinessEntity t);
 	
 	public void qryAll(DataGrid dataGrid,JSONObject paramObj)throws Exception;
 	/**
 	 * 获取联系方式
 	 * @param jianliOnline
 	 * @return
 	 */
 	public FlowResult qryPhoneNo(JianliBusinessEntity jianliOnline);
}
