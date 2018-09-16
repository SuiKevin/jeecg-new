package com.jeecg.qpwl.selectview.service;
import java.io.Serializable;

import org.jeecgframework.core.common.service.CommonService;

import com.jeecg.qpwl.selectview.entity.StreetEntity;

public interface StreetServiceI extends CommonService{
	
 	public void delete(StreetEntity entity) throws Exception;
 	
 	public Serializable save(StreetEntity entity) throws Exception;
 	
 	public void saveOrUpdate(StreetEntity entity) throws Exception;
 	
}
