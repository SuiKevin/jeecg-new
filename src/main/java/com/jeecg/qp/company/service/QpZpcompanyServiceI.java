package com.jeecg.qp.company.service;
import com.jeecg.qp.company.entity.QpZpcompanyEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface QpZpcompanyServiceI extends CommonService{
	
 	public void delete(QpZpcompanyEntity entity) throws Exception;
 	
 	public Serializable save(QpZpcompanyEntity entity) throws Exception;
 	
 	public void saveOrUpdate(QpZpcompanyEntity entity) throws Exception;
 	
}
