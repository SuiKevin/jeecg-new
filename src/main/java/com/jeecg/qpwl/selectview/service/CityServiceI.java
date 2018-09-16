package com.jeecg.qpwl.selectview.service;
import java.io.Serializable;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import com.jeecg.qpwl.selectview.entity.CityEntity;

public interface CityServiceI extends CommonService{
	public void queryALL(DataGrid dataGrid,JSONObject paramObj);
	
 	public void delete(CityEntity entity) throws Exception;
 	
 	public Serializable save(CityEntity entity) throws Exception;
 	
 	public void saveOrUpdate(CityEntity entity) throws Exception;
}
