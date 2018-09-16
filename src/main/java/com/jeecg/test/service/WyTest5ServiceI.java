package com.jeecg.test.service;
import com.jeecg.test.entity.WyTest5Entity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WyTest5ServiceI extends CommonService{
	
 	public void delete(WyTest5Entity entity) throws Exception;
 	
 	public Serializable save(WyTest5Entity entity) throws Exception;
 	
 	public void saveOrUpdate(WyTest5Entity entity) throws Exception;
 	
}
