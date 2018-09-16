package com.jeecg.qp.jifen.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.web.system.pojo.base.TSUser;

/**   
 * @Title: Entity
 * @Description: 积分管理
 * @author onlineGenerator
 * @date 2017-12-29 11:52:31
 * @version V1.0   
 *
 */
@Entity
@Table(name = "qp_jifen", schema = "")
@SuppressWarnings("serial")
public class QpJifenEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新日期*/
	private java.util.Date updateDate;
	/**授权积分*/
	@Excel(name="授权积分",width=15)
	private java.lang.Integer sqPoint;
	/**已用积分*/
	@Excel(name="已用积分",width=15)
	private java.lang.Integer sqPointUsed;
	/**每日限制用量*/
	@Excel(name="每日限制用量",width=15)
	private java.lang.Integer pointDayLimit;
	/**当日用量*/
	@Excel(name="当日用量",width=15)
	private java.lang.Integer pointDayUsed;
	
	private java.lang.String operflag;
	private java.lang.Integer addpoint;
	private java.lang.String  owndeparts;
	
	@Transient
	public java.lang.String getOwndeparts() {
		return owndeparts;
	}

	public void setOwndeparts(java.lang.String owndeparts) {
		this.owndeparts = owndeparts;
	}

	private TSUser tsuser;
	
	@OneToOne(cascade=CascadeType.REFRESH,optional=true)
	@JoinColumn(name="id")//注释本表中指向另一个表的外键。
	@NotFound(action=NotFoundAction.IGNORE)
	public TSUser getTsuser() {
		return tsuser;
	}

	public void setTsuser(TSUser tsuser) {
		this.tsuser = tsuser;
	}

	@Transient
	public java.lang.String getOperflag() {
		return operflag;
	}

	public void setOperflag(java.lang.String operflag) {
		this.operflag = operflag;
	}
	@Transient
	public java.lang.Integer getAddpoint() {
		return addpoint;
	}

	public void setAddpoint(java.lang.Integer addpoint) {
		this.addpoint = addpoint;
	}

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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */

	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
 
 
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  授权积分
	 */

	@Column(name ="SQ_POINT",nullable=true,length=9)
	public java.lang.Integer getSqPoint(){
		return this.sqPoint;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  授权积分
	 */
	public void setSqPoint(java.lang.Integer sqPoint){
		this.sqPoint = sqPoint;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  已用积分
	 */

	@Column(name ="SQ_POINT_USED",nullable=true,length=9)
	public java.lang.Integer getSqPointUsed(){
		return this.sqPointUsed;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  已用积分
	 */
	public void setSqPointUsed(java.lang.Integer sqPointUsed){
		this.sqPointUsed = sqPointUsed;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  每日限制用量
	 */

	@Column(name ="POINT_DAY_LIMIT",nullable=true,length=9)
	public java.lang.Integer getPointDayLimit(){
		return this.pointDayLimit;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  每日限制用量
	 */
	public void setPointDayLimit(java.lang.Integer pointDayLimit){
		this.pointDayLimit = pointDayLimit;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  当日用量
	 */

	@Column(name ="POINT_DAY_USED",nullable=true,length=9)
	public java.lang.Integer getPointDayUsed(){
		return this.pointDayUsed;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  当日用量
	 */
	public void setPointDayUsed(java.lang.Integer pointDayUsed){
		this.pointDayUsed = pointDayUsed;
	}
}
