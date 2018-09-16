package com.jeecg.qpwl.core;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.web.system.pojo.base.TSUser;

public interface ProcessEngineI extends CommonService{
	/**
	 * 
	 * 描述：流程部署
	 * 作者：lyj
	 * Dec 21, 2017
	 */
	public FlowResult flowDeploy();
	/**
	 * 
	 * 描述：启动流程
	 * 作者：lyj
	 * Dec 21, 2017
	 */
	public FlowResult startFlow(String flowCode,TSUser user);
	/**
	 * 
	 * 描述：启动流程,带全局参数
	 * 作者：lyj
	 * Dec 21, 2017
	 */
	public FlowResult startFlow(String flowCode,TSUser user,JSONObject param);
}
