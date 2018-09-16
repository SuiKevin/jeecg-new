package com.jeecg.qpwl.order.service;
import java.io.Serializable;
import java.util.List;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import com.jeecg.qpwl.core.FlowResult;
import com.jeecg.qpwl.order.entity.TOrderIngEntity;

public interface TOrderIngServiceI extends CommonService{
	
 	public void delete(TOrderIngEntity entity) throws Exception;
 	
 	public Serializable save(TOrderIngEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TOrderIngEntity entity) throws Exception;
 	
 	public void qryAll(DataGrid dataGrid,JSONObject paramObj)throws Exception;
 	
 	public List<TOrderIngEntity> qryAllJieSong(JSONObject paramObj)throws Exception;
 	
 	public FlowResult idCradReWrite(JSONObject idCardInfo);
 	
}
