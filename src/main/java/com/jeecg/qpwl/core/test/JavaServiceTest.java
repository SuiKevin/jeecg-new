package com.jeecg.qpwl.core.test;

import com.jeecg.qpwl.core.FlowResult;
import com.jeecg.qpwl.core.JavaTaskInf;
import com.jeecg.qpwl.orderflow.entity.TFlowTaskEntity;

public class JavaServiceTest implements JavaTaskInf{

	@Override
	public FlowResult execute(TFlowTaskEntity taskInfo, Object param) {
		System.out.println("自动java服务执行成功");
		return FlowResult.buildSuccess(null);
	}

}
