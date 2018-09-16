package com.jeecg.qpwl.selectview.service;
import java.io.Serializable;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import com.jeecg.qpwl.selectview.entity.TownEntity;

public interface TownServiceI extends CommonService{
	
 	public void delete(TownEntity entity) throws Exception;
 	
 	public Serializable save(TownEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TownEntity entity) throws Exception;
 	
 	public void queryALL(DataGrid dataGrid,JSONObject paramObj);
}
