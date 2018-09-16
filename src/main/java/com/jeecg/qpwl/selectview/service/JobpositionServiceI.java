package com.jeecg.qpwl.selectview.service;
import com.jeecg.qpwl.selectview.entity.JobpositionEntity;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface JobpositionServiceI extends CommonService{
	
 	public void delete(JobpositionEntity entity) throws Exception;
 	
 	public Serializable save(JobpositionEntity entity) throws Exception;
 	
 	public void saveOrUpdate(JobpositionEntity entity) throws Exception;
 	
 	public void queryALL(DataGrid dataGrid,JSONObject paramObj);
}
