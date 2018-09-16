package com.jeecg.qpwl.core;

import net.sf.json.JSONObject;

public class FlowResult {
	private int resultCode;//0:成功  1：失败
	private String resultMsg;//错误描述
	private JSONObject resultData;
	
	public static FlowResult buildSuccess(JSONObject resultData1){
		FlowResult result = new FlowResult();
		result.setResultCode(0);
		result.setResultMsg("操作成功");
		result.setResultData(resultData1);
		return result;
		
	}
	
	public static FlowResult buildFailed(int code,String msg){
		FlowResult result = new FlowResult();
		result.setResultCode(code);
		result.setResultMsg(msg);
		return result;
	}
	
	
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public JSONObject getResultData() {
		return resultData;
	}
	public void setResultData(JSONObject resultData) {
		this.resultData = resultData;
	}
	
}
