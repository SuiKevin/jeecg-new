package com.jeecg.qpwl.orderflow.service;
import com.jeecg.qpwl.orderflow.entity.TFlowExampleEntity;
import com.jeecg.qpwl.orderflow.entity.TFlowExecuteHistoryEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface TFlowExampleServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(TFlowExampleEntity tFlowExample,
	        List<TFlowExecuteHistoryEntity> tFlowExecuteHistoryList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(TFlowExampleEntity tFlowExample,
	        List<TFlowExecuteHistoryEntity> tFlowExecuteHistoryList);
	public void delMain (TFlowExampleEntity tFlowExample);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(TFlowExampleEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(TFlowExampleEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(TFlowExampleEntity t);
}
