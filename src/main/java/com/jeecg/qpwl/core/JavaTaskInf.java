package com.jeecg.qpwl.core;

import com.jeecg.qpwl.orderflow.entity.TFlowTaskEntity;

public interface JavaTaskInf {
	/**
	 * java服务需要继承的接口
	 * @param param
	 * @return
	 */
	public FlowResult execute(TFlowTaskEntity taskInfo,Object param);
}
