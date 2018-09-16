package com.jeecg.qpwl.comInf;

import org.jeecgframework.web.system.pojo.base.TSUser;

import com.jeecg.qpwl.core.FlowResult;
import com.jeecg.qpwl.talentpool.entity.JianliOnlineEntity;

public interface ComonInf {
	
	/**
	 * 判断积分是否够用,以及是否达到当日上线
	 * @param user
	 * @return
	 */
	public FlowResult chekJf(TSUser user);
	
	/**
	 * 参看简历，每次消费一个积分
	 * @param user 用户信息
	 * @return resultCode(0:成功  1:积分不足  2:当日查看简历量已达到上限，不能查看)
	 */
	public FlowResult lookPhoneNo(TSUser user);
	
	
	/**
	 * 调用58接口购买积分
	 * @param user 用户信息
	 * @param jianliOnline 简历信息
	 * @return resultCode(0:成功  1:积分不足  2:当日查看简历量已达到上限，不能查看,3:购买中  4:购买失败)
	 */
	public FlowResult bayPhoneNo(TSUser user,JianliOnlineEntity jianliOnline);
}
