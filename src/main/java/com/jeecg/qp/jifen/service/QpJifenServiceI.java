package com.jeecg.qp.jifen.service;
import com.jeecg.qp.jifen.entity.QpJifenEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface QpJifenServiceI extends CommonService{
	
 	public void delete(QpJifenEntity entity) throws Exception;
 	
 	public Serializable save(QpJifenEntity entity) throws Exception;
 	
 	public void saveOrUpdate(QpJifenEntity entity) throws Exception;
 	
}
