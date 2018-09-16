package com.jeecg.qp.jifen.service;
import com.jeecg.qp.jifen.entity.QpJifenLogEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface QpJifenLogServiceI extends CommonService{
	
 	public void delete(QpJifenLogEntity entity) throws Exception;
 	
 	public Serializable save(QpJifenLogEntity entity) throws Exception;
 	
 	public void saveOrUpdate(QpJifenLogEntity entity) throws Exception;
 	
}
