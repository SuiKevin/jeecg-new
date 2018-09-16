package com.jeecg.qpwl.core;

import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.web.system.pojo.base.TSUser;

public interface TaskServiceI extends CommonService{
	/**
	 * 完成任务
	 * @param instanceId 流程实例
	 * @param user 用户信息
	 * @param paramObj 参数列表
	 * @return
	 */
	FlowResult complete(String instanceId,TSUser user,Object paramObj);
	
	
	/**
	 * 认领任务
	 * @param taskId
	 * @param paramObj
	 */
	public FlowResult Claim(String taskId,Object paramObj);	
}
