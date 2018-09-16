package com.jeecg.qpwl.orderflow.service;
import com.jeecg.qpwl.orderflow.entity.TFlowDefineEntity;
import com.jeecg.qpwl.orderflow.entity.TFlowTaskEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface TFlowDefineServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(TFlowDefineEntity tFlowDefine,
	        List<TFlowTaskEntity> tFlowTaskList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(TFlowDefineEntity tFlowDefine,
	        List<TFlowTaskEntity> tFlowTaskList);
	public void delMain (TFlowDefineEntity tFlowDefine);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(TFlowDefineEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(TFlowDefineEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(TFlowDefineEntity t);
}
