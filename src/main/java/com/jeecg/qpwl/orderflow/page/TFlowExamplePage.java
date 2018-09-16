
package com.jeecg.qpwl.orderflow.page;
import com.jeecg.qpwl.orderflow.entity.TFlowExampleEntity;
import com.jeecg.qpwl.orderflow.entity.TFlowExecuteHistoryEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;

/**   
 * @Title: Entity
 * @Description: 在途工单
 * @author onlineGenerator
 * @date 2017-12-24 15:35:51
 * @version V1.0   
 *
 */
public class TFlowExamplePage implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**流程实例ID*/
	private java.lang.String instanceId;
	/**流程ID*/
	private java.lang.String flowId;
	/**创建日期*/
	private java.util.Date createDate;
	/**当前环节编码*/
	private java.lang.String currectTask;
	/**执行者类型*/
	private java.lang.String partyType;
	/**执行者*/
	private java.lang.String partyId;
	/**参数*/
	private java.lang.String instanceParams;
	/**当前环节参数*/
	private java.lang.String taskParams;
	/**当前环节名称*/
	private java.lang.String currentTaskName;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程实例ID
	 */
	public java.lang.String getInstanceId(){
		return this.instanceId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程实例ID
	 */
	public void setInstanceId(java.lang.String instanceId){
		this.instanceId = instanceId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程ID
	 */
	public java.lang.String getFlowId(){
		return this.flowId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程ID
	 */
	public void setFlowId(java.lang.String flowId){
		this.flowId = flowId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  当前环节编码
	 */
	public java.lang.String getCurrectTask(){
		return this.currectTask;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  当前环节编码
	 */
	public void setCurrectTask(java.lang.String currectTask){
		this.currectTask = currectTask;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  执行者类型
	 */
	public java.lang.String getPartyType(){
		return this.partyType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  执行者类型
	 */
	public void setPartyType(java.lang.String partyType){
		this.partyType = partyType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  执行者
	 */
	public java.lang.String getPartyId(){
		return this.partyId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  执行者
	 */
	public void setPartyId(java.lang.String partyId){
		this.partyId = partyId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参数
	 */
	public java.lang.String getInstanceParams(){
		return this.instanceParams;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参数
	 */
	public void setInstanceParams(java.lang.String instanceParams){
		this.instanceParams = instanceParams;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  当前环节参数
	 */
	public java.lang.String getTaskParams(){
		return this.taskParams;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  当前环节参数
	 */
	public void setTaskParams(java.lang.String taskParams){
		this.taskParams = taskParams;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  当前环节名称
	 */
	public java.lang.String getCurrentTaskName(){
		return this.currentTaskName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  当前环节名称
	 */
	public void setCurrentTaskName(java.lang.String currentTaskName){
		this.currentTaskName = currentTaskName;
	}

	/**保存-历史环节*/
    @ExcelCollection(name="历史环节")
	private List<TFlowExecuteHistoryEntity> tFlowExecuteHistoryList = new ArrayList<TFlowExecuteHistoryEntity>();
		public List<TFlowExecuteHistoryEntity> getTFlowExecuteHistoryList() {
		return tFlowExecuteHistoryList;
		}
		public void setTFlowExecuteHistoryList(List<TFlowExecuteHistoryEntity> tFlowExecuteHistoryList) {
		this.tFlowExecuteHistoryList = tFlowExecuteHistoryList;
		}
}
