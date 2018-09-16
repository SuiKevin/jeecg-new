package com.jeecg.qp.jobtype.service;
import com.jeecg.qp.jobtype.entity.QpJobtypeEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface QpJobtypeServiceI extends CommonService{
	
 	public void delete(QpJobtypeEntity entity) throws Exception;
 	
 	public Serializable save(QpJobtypeEntity entity) throws Exception;
 	
 	public void saveOrUpdate(QpJobtypeEntity entity) throws Exception;
 	
}
