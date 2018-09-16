package com.jeecg.qp.test3.service;
import com.jeecg.qp.test3.entity.Wy003Entity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface Wy003ServiceI extends CommonService{
	
 	public void delete(Wy003Entity entity) throws Exception;
 	
 	public Serializable save(Wy003Entity entity) throws Exception;
 	
 	public void saveOrUpdate(Wy003Entity entity) throws Exception;
 	
}
