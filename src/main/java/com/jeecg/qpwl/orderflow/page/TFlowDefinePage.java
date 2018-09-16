
package com.jeecg.qpwl.orderflow.page;
import com.jeecg.qpwl.orderflow.entity.TFlowDefineEntity;
import com.jeecg.qpwl.orderflow.entity.TFlowTaskEntity;

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
 * @Description: 流程定义表
 * @author onlineGenerator
 * @date 2017-12-23 12:57:18
 * @version V1.0   
 *
 */
public class TFlowDefinePage implements java.io.Serializable {
	/**主键*/
	private java.lang.Integer id;
	/**流程编码*/
    @Excel(name="流程编码")
	private java.lang.String flowCode;
	/**流程名称*/
    @Excel(name="流程名称")
	private java.lang.String flowName;
	/**创建日期*/
    @Excel(name="创建日期",format = "yyyy-MM-dd")
	private java.util.Date createDate;
	/**流程状态*/
    @Excel(name="流程状态")
	private java.lang.String flowState;
	/**版本号*/
    @Excel(name="版本号")
	private java.lang.String version;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  主键
	 */
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
	 *@return: java.lang.String  流程编码
	 */
	public java.lang.String getFlowCode(){
		return this.flowCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程编码
	 */
	public void setFlowCode(java.lang.String flowCode){
		this.flowCode = flowCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程名称
	 */
	public java.lang.String getFlowName(){
		return this.flowName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程名称
	 */
	public void setFlowName(java.lang.String flowName){
		this.flowName = flowName;
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
	 *@return: java.lang.String  流程状态
	 */
	public java.lang.String getFlowState(){
		return this.flowState;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setFlowState(java.lang.String flowState){
		this.flowState = flowState;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  版本号
	 */
	public java.lang.String getVersion(){
		return this.version;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  版本号
	 */
	public void setVersion(java.lang.String version){
		this.version = version;
	}

	/**保存-环节管理*/
    @ExcelCollection(name="环节管理")
	private List<TFlowTaskEntity> tFlowTaskList = new ArrayList<TFlowTaskEntity>();
		public List<TFlowTaskEntity> getTFlowTaskList() {
		return tFlowTaskList;
		}
		public void setTFlowTaskList(List<TFlowTaskEntity> tFlowTaskList) {
		this.tFlowTaskList = tFlowTaskList;
		}
}
