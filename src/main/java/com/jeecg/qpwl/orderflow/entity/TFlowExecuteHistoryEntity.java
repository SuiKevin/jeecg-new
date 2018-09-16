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
 * @Description: 历史环节
 * @author onlineGenerator
 * @date 2017-12-24 15:35:51
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_flow_execute_history", schema = "")
@SuppressWarnings("serial")
public class TFlowExecuteHistoryEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**流程实例ID*/
    @Excel(name="流程实例ID",width=15)
	private java.lang.String instanceId;
	/**创建日期*/
    @Excel(name="创建日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date createDate;
	/**环节编码*/
	private java.lang.String taskCode;
	/**环节名称*/
    @Excel(name="环节名称",width=15)
	private java.lang.String taskName;
	/**执行人ID*/
	private java.lang.String executorId;
	/**执行人*/
    @Excel(name="执行人",width=15)
	private java.lang.String executorName;
	/**执行结论*/
    @Excel(name="执行结论",width=15)
	private java.lang.String taskResult;
	/**备注*/
    @Excel(name="备注",width=15)
	private java.lang.String taskRemark;
	
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
	 *@return: java.lang.String  执行人ID
	 */
	
	@Column(name ="EXECUTOR_ID",nullable=true,length=50)
	public java.lang.String getExecutorId(){
		return this.executorId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  执行人ID
	 */
	public void setExecutorId(java.lang.String executorId){
		this.executorId = executorId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  执行人
	 */
	
	@Column(name ="EXECUTOR_NAME",nullable=true,length=50)
	public java.lang.String getExecutorName(){
		return this.executorName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  执行人
	 */
	public void setExecutorName(java.lang.String executorName){
		this.executorName = executorName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  执行结论
	 */
	
	@Column(name ="TASK_RESULT",nullable=true,length=1000)
	public java.lang.String getTaskResult(){
		return this.taskResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  执行结论
	 */
	public void setTaskResult(java.lang.String taskResult){
		this.taskResult = taskResult;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	
	@Column(name ="TASK_REMARK",nullable=true,length=1000)
	public java.lang.String getTaskRemark(){
		return this.taskRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setTaskRemark(java.lang.String taskRemark){
		this.taskRemark = taskRemark;
	}
	
}
