package com.jeecg.qpwl.orderflow.service.impl;
import com.jeecg.qpwl.orderflow.service.TFlowDefineServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.qpwl.orderflow.entity.TFlowDefineEntity;
import com.jeecg.qpwl.orderflow.entity.TFlowTaskEntity;

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


@Service("tFlowDefineService")
@Transactional
public class TFlowDefineServiceImpl extends CommonServiceImpl implements TFlowDefineServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((TFlowDefineEntity)entity);
 	}
 	
	
	public void addMain(TFlowDefineEntity tFlowDefine,
	        List<TFlowTaskEntity> tFlowTaskList){
			//保存主信息
			this.save(tFlowDefine);
		
			/**保存-环节管理*/
			for(TFlowTaskEntity tFlowTask:tFlowTaskList){
				//外键设置
				tFlowTask.setFlowId(tFlowDefine.getId());
				this.save(tFlowTask);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(tFlowDefine);
	}

	
	public void updateMain(TFlowDefineEntity tFlowDefine,
	        List<TFlowTaskEntity> tFlowTaskList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(tFlowDefine.getId())){
			try {
				TFlowDefineEntity temp = findUniqueByProperty(TFlowDefineEntity.class, "id", tFlowDefine.getId());
				MyBeanUtils.copyBeanNotNull2Bean(tFlowDefine, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(tFlowDefine);
		}
		//===================================================================================
		//获取参数
		Object id0 = tFlowDefine.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-环节管理
	    String hql0 = "from TFlowTaskEntity where 1 = 1 AND fLOW_ID = ? ";
	    List<TFlowTaskEntity> tFlowTaskOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-环节管理
		if(tFlowTaskList!=null&&tFlowTaskList.size()>0){
		for(TFlowTaskEntity oldE:tFlowTaskOldList){
			boolean isUpdate = false;
				for(TFlowTaskEntity sendE:tFlowTaskList){
					//需要更新的明细数据-环节管理
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-环节管理
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-环节管理
			for(TFlowTaskEntity tFlowTask:tFlowTaskList){
				if(oConvertUtils.isEmpty(tFlowTask.getId())){
					//外键设置
					tFlowTask.setFlowId(tFlowDefine.getId());
					this.save(tFlowTask);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(tFlowDefine);
	}

	
	public void delMain(TFlowDefineEntity tFlowDefine) {
		//删除主表信息
		this.delete(tFlowDefine);
		//===================================================================================
		//获取参数
		Object id0 = tFlowDefine.getId();
		//===================================================================================
		//删除-环节管理
	    String hql0 = "from TFlowTaskEntity where 1 = 1 AND fLOW_ID = ? ";
	    List<TFlowTaskEntity> tFlowTaskOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(tFlowTaskOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(TFlowDefineEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(TFlowDefineEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(TFlowDefineEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,TFlowDefineEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{flow_code}",String.valueOf(t.getFlowCode()));
 		sql  = sql.replace("#{flow_name}",String.valueOf(t.getFlowName()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{flow_state}",String.valueOf(t.getFlowState()));
 		sql  = sql.replace("#{version}",String.valueOf(t.getVersion()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}