package com.jeecg.qpwl.selectview.service;
import java.io.Serializable;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import com.jeecg.qpwl.selectview.entity.ProvinceEntity;

public interface ProvinceServiceI extends CommonService{
	
	public void queryALL(DataGrid dataGrid,JSONObject paramObj);
	
 	public void delete(ProvinceEntity entity) throws Exception;
 	
 	public Serializable save(ProvinceEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ProvinceEntity entity) throws Exception;
 	
}
