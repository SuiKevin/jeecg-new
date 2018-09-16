package com.jeecg.qpwl.order.service;
import com.jeecg.qpwl.order.entity.TOrderHisEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TOrderHisServiceI extends CommonService{
	
 	public void delete(TOrderHisEntity entity) throws Exception;
 	public Serializable save(TOrderHisEntity entity) throws Exception;
 	public void saveOrUpdate(TOrderHisEntity entity) throws Exception;
 	
}
