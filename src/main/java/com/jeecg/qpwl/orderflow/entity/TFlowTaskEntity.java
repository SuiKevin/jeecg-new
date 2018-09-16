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
 * @Description: 环节管理
 * @author onlineGenerator
 * @date 2017-12-23 12:57:17
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_flow_task", schema = "")
@SuppressWarnings("serial")
public class TFlowTaskEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.Integer id;
	/**环节编码*/
    @Excel(name="环节编码",width=15)
	private java.lang.String taskCode;
	/**环节名称*/
    @Excel(name="环节名称",width=15)
	private java.lang.String taskName;
	/**环节类型*/
    @Excel(name="环节类型",width=15,dicCode="task_type")
	private java.lang.String taskType;
	/**下一环节*/
    @Excel(name="下一环节",width=15)
	private java.lang.String nextTask;
	/**环节顺序*/
    @Excel(name="环节顺序",width=15)
	private java.lang.Integer taskIndex;
	/**派单类型*/
    @Excel(name="派单类型",width=15,dicCode="party_type")
	private java.lang.String partyType;
	/**执行人*/
    @Excel(name="执行人",width=15,dictTable ="user_select",dicCode ="userId",dicText ="realname")
	private java.lang.String partyIds;
	/**表单*/
    @Excel(name="表单",width=15)
	private java.lang.String taskForm;
	/**自动环节对应的服务*/
    @Excel(name="自动环节对应的服务",width=15)
	private java.lang.String taskClasspath;
	/**网关表达式*/
    @Excel(name="网关表达式",width=15)
	private java.lang.String taskExpression;
	/**参数*/
    @Excel(name="参数",width=15)
	private java.lang.String params;
	/**流程id*/
	private java.lang.Integer flowId;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name ="ID",nullable=false,length=20)
	public java.lang.Integer getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  主键
	 */
	public void setId(java.lang.Integer id){
		this.id = id;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  环节编码
	 */
	
	@Column(name ="TASK_CODE",nullable=true,length=50)
	public java.lang.String getTaskCode(){
		return this.taskCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  环节编码
	 */
	public void setTaskCode(java.lang.String taskCode){
		this.taskCode = taskCode;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  环节名称
	 */
	
	@Column(name ="TASK_NAME",nullable=true,length=100)
	public java.lang.String getTaskName(){
		return this.taskName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  环节名称
	 */
	public void setTaskName(java.lang.String taskName){
		this.taskName = taskName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  环节类型
	 */
	
	@Column(name ="TASK_TYPE",nullable=true,length=20)
	public java.lang.String getTaskType(){
		return this.taskType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  环节类型
	 */
	public void setTaskType(java.lang.String taskType){
		this.taskType = taskType;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  下一环节
	 */
	
	@Column(name ="NEXT_TASK",nullable=true,length=50)
	public java.lang.String getNextTask(){
		return this.nextTask;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  下一环节
	 */
	public void setNextTask(java.lang.String nextTask){
		this.nextTask = nextTask;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  环节顺序
	 */
	
	@Column(name ="TASK_INDEX",nullable=true,length=50)
	public java.lang.Integer getTaskIndex(){
		return this.taskIndex;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  环节顺序
	 */
	public void setTaskIndex(java.lang.Integer taskIndex){
		this.taskIndex = taskIndex;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  派单类型
	 */
	
	@Column(name ="PARTY_TYPE",nullable=true,length=20)
	public java.lang.String getPartyType(){
		return this.partyType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  派单类型
	 */
	public void setPartyType(java.lang.String partyType){
		this.partyType = partyType;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  执行人
	 */
	
	@Column(name ="PARTY_IDS",nullable=true,length=100)
	public java.lang.String getPartyIds(){
		return this.partyIds;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  执行人
	 */
	public void setPartyIds(java.lang.String partyIds){
		this.partyIds = partyIds;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  表单
	 */
	
	@Column(name ="TASK_FORM",nullable=true,length=200)
	public java.lang.String getTaskForm(){
		return this.taskForm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  表单
	 */
	public void setTaskForm(java.lang.String taskForm){
		this.taskForm = taskForm;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  自动环节对应的服务
	 */
	
	@Column(name ="TASK_CLASSPATH",nullable=true,length=100)
	public java.lang.String getTaskClasspath(){
		return this.taskClasspath;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  自动环节对应的服务
	 */
	public void setTaskClasspath(java.lang.String taskClasspath){
		this.taskClasspath = taskClasspath;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  网关表达式
	 */
	
	@Column(name ="TASK_EXPRESSION",nullable=true,length=2000)
	public java.lang.String getTaskExpression(){
		return this.taskExpression;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  网关表达式
	 */
	public void setTaskExpression(java.lang.String taskExpression){
		this.taskExpression = taskExpression;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参数
	 */
	
	@Column(name ="PARAMS",nullable=true,length=2000)
	public java.lang.String getParams(){
		return this.params;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参数
	 */
	public void setParams(java.lang.String params){
		this.params = params;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  流程id
	 */
	
	@Column(name ="FLOW_ID",nullable=false,length=32)
	public java.lang.Integer getFlowId(){
		return this.flowId;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  流程id
	 */
	public void setFlowId(java.lang.Integer flowId){
		this.flowId = flowId;
	}
	
}
