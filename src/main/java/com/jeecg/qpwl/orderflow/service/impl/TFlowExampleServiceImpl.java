package com.jeecg.qpwl.orderflow.service.impl;
import com.jeecg.qpwl.orderflow.service.TFlowExampleServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.qpwl.orderflow.entity.TFlowExampleEntity;
import com.jeecg.qpwl.orderflow.entity.TFlowExecuteHistoryEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import java.util.ArrayList;
import java.util.UUID;
import java.io.Serializable;


@Service("tFlowExampleService")
@Transactional
public class TFlowExampleServiceImpl extends CommonServiceImpl implements TFlowExampleServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((TFlowExampleEntity)entity);
 	}
	
	public void addMain(TFlowExampleEntity tFlowExample,
	        List<TFlowExecuteHistoryEntity> tFlowExecuteHistoryList){
			//保存主信息
			this.save(tFlowExample);
		
			/**保存-历史环节*/
			for(TFlowExecuteHistoryEntity tFlowExecuteHistory:tFlowExecuteHistoryList){
				//外键设置
				tFlowExecuteHistory.setInstanceId(tFlowExample.getId());
				this.save(tFlowExecuteHistory);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(tFlowExample);
	}

	
	public void updateMain(TFlowExampleEntity tFlowExample,
	        List<TFlowExecuteHistoryEntity> tFlowExecuteHistoryList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(tFlowExample.getId())){
			try {
				TFlowExampleEntity temp = findUniqueByProperty(TFlowExampleEntity.class, "id", tFlowExample.getId());
				MyBeanUtils.copyBeanNotNull2Bean(tFlowExample, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(tFlowExample);
		}
		//===================================================================================
		//获取参数
		Object id0 = tFlowExample.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-历史环节
	    String hql0 = "from TFlowExecuteHistoryEntity where 1 = 1 AND iNSTANCE_ID = ? ";
	    List<TFlowExecuteHistoryEntity> tFlowExecuteHistoryOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-历史环节
		if(tFlowExecuteHistoryList!=null&&tFlowExecuteHistoryList.size()>0){
		for(TFlowExecuteHistoryEntity oldE:tFlowExecuteHistoryOldList){
			boolean isUpdate = false;
				for(TFlowExecuteHistoryEntity sendE:tFlowExecuteHistoryList){
					//需要更新的明细数据-历史环节
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-历史环节
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-历史环节
			for(TFlowExecuteHistoryEntity tFlowExecuteHistory:tFlowExecuteHistoryList){
				if(oConvertUtils.isEmpty(tFlowExecuteHistory.getId())){
					//外键设置
					tFlowExecuteHistory.setInstanceId(tFlowExample.getId());
					this.save(tFlowExecuteHistory);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(tFlowExample);
	}

	
	public void delMain(TFlowExampleEntity tFlowExample) {
		//删除主表信息
		this.delete(tFlowExample);
		//===================================================================================
		//获取参数
		Object id0 = tFlowExample.getId();
		//===================================================================================
		//删除-历史环节
	    String hql0 = "from TFlowExecuteHistoryEntity where 1 = 1 AND iNSTANCE_ID = ? ";
	    List<TFlowExecuteHistoryEntity> tFlowExecuteHistoryOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(tFlowExecuteHistoryOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(TFlowExampleEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(TFlowExampleEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(TFlowExampleEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,TFlowExampleEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{instance_id}",String.valueOf(t.getInstanceId()));
 		sql  = sql.replace("#{flow_id}",String.valueOf(t.getFlowId()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{currect_task}",String.valueOf(t.getCurrectTask()));
 		sql  = sql.replace("#{party_type}",String.valueOf(t.getPartyType()));
 		sql  = sql.replace("#{party_id}",String.valueOf(t.getPartyId()));
 		sql  = sql.replace("#{instance_params}",String.valueOf(t.getInstanceParams()));
 		sql  = sql.replace("#{task_params}",String.valueOf(t.getTaskParams()));
 		sql  = sql.replace("#{current_task_name}",String.valueOf(t.getCurrentTaskName()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}