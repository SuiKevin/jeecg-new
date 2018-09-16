package com.jeecg.qp.jifen.entity;

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
 * @Description: 积分日志管理
 * @author onlineGenerator
 * @date 2018-01-09 17:10:38
 * @version V1.0   
 *
 */
@Entity
@Table(name = "qp_jifen_log", schema = "")
@SuppressWarnings("serial")
public class QpJifenLogEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**操作人*/
	@Excel(name="操作人",width=15)
	private java.lang.String operUser;
	/**操作日期*/
	@Excel(name="操作日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date operDate;
	/**操作事件*/
	@Excel(name="操作事件",width=15)
	private java.lang.String operEvent;
	/**被操作用户*/
	@Excel(name="被操作用户",width=15)
	private java.lang.String beioperUser;
	/**被操作积分*/
	@Excel(name="被操作积分",width=15)
	private java.lang.String beioperJifen;
	
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
	 *@return: java.lang.String  操作人
	 */

	@Column(name ="OPER_USER",nullable=true,length=32)
	public java.lang.String getOperUser(){
		return this.operUser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  操作人
	 */
	public void setOperUser(java.lang.String operUser){
		this.operUser = operUser;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  操作日期
	 */

	@Column(name ="OPER_DATE",nullable=true,length=32)
	public java.util.Date getOperDate(){
		return this.operDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  操作日期
	 */
	public void setOperDate(java.util.Date operDate){
		this.operDate = operDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  操作事件
	 */

	@Column(name ="OPER_EVENT",nullable=true,length=32)
	public java.lang.String getOperEvent(){
		return this.operEvent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  操作事件
	 */
	public void setOperEvent(java.lang.String operEvent){
		this.operEvent = operEvent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  被操作用户
	 */

	@Column(name ="BEIOPER_USER",nullable=true,length=32)
	public java.lang.String getBeioperUser(){
		return this.beioperUser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  被操作用户
	 */
	public void setBeioperUser(java.lang.String beioperUser){
		this.beioperUser = beioperUser;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  被操作积分
	 */

	@Column(name ="BEIOPER_JIFEN",nullable=true,length=32)
	public java.lang.String getBeioperJifen(){
		return this.beioperJifen;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  被操作积分
	 */
	public void setBeioperJifen(java.lang.String beioperJifen){
		this.beioperJifen = beioperJifen;
	}
}
