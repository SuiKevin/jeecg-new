package com.jeecg.qpwl.orderflow.entity;
import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 在途工单
 * @author onlineGenerator
 * @date 2017-12-24 15:35:51
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_flow_example", schema = "")
@SuppressWarnings("serial")
public class TFlowExampleEntity implements java.io.Serializable {
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
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	
	@Column(name ="ID",nullable=false,length=36)
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
	
	@Column(name ="INSTANCE_ID",nullable=true,length=50)
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
	
	@Column(name ="FLOW_ID",nullable=true,length=50)
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
	
	@Column(name ="CREATE_DATE",nullable=true,length=20)
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
	
	@Column(name ="CURRECT_TASK",nullable=true,length=50)
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
	
	@Column(name ="PARTY_TYPE",nullable=true,length=50)
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
	
	@Column(name ="PARTY_ID",nullable=true,length=20)
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
	
	@Column(name ="INSTANCE_PARAMS",nullable=true,length=2000)
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
	
	@Column(name ="TASK_PARAMS",nullable=true,length=50)
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
	
	@Column(name ="CURRENT_TASK_NAME",nullable=true,length=32)
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
	
}
