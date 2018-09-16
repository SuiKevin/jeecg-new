package com.jeecg.qpwl.talentpool.entity;
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
 * @Description: 积分消费情况
 * @author onlineGenerator
 * @date 2018-01-02 14:59:25
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jianli_xiaofen", schema = "")
@SuppressWarnings("serial")
public class JianliXiaofenEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**简历ID*/
    @Excel(name="简历ID",width=15)
	private java.lang.String resumeId;
	/**部门ID*/
    @Excel(name="部门ID",width=15)
	private java.lang.String departId;
	/**部门名称*/
    @Excel(name="部门名称",width=15,format = "yyyy-MM-dd")
	private java.util.Date departName;
	/**人员ID*/
    @Excel(name="人员ID",width=15)
	private java.lang.String userId;
	/**人员名称*/
    @Excel(name="人员名称",width=15)
	private java.lang.String userName;
	/**更新日期*/
    @Excel(name="更新日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date updateDate;
	/**联系电话*/
    @Excel(name="联系电话",width=15)
	private java.lang.String mobile;
	
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
	 *@return: java.lang.String  简历ID
	 */
	
	@Column(name ="RESUME_ID",nullable=true,length=50)
	public java.lang.String getResumeId(){
		return this.resumeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简历ID
	 */
	public void setResumeId(java.lang.String resumeId){
		this.resumeId = resumeId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  部门ID
	 */
	
	@Column(name ="DEPART_ID",nullable=true,length=50)
	public java.lang.String getDepartId(){
		return this.departId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  部门ID
	 */
	public void setDepartId(java.lang.String departId){
		this.departId = departId;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  部门名称
	 */
	
	@Column(name ="DEPART_NAME",nullable=true,length=20)
	public java.util.Date getDepartName(){
		return this.departName;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  部门名称
	 */
	public void setDepartName(java.util.Date departName){
		this.departName = departName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  人员ID
	 */
	
	@Column(name ="USER_ID",nullable=true,length=50)
	public java.lang.String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人员ID
	 */
	public void setUserId(java.lang.String userId){
		this.userId = userId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  人员名称
	 */
	
	@Column(name ="USER_NAME",nullable=true,length=50)
	public java.lang.String getUserName(){
		return this.userName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人员名称
	 */
	public void setUserName(java.lang.String userName){
		this.userName = userName;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	
	@Column(name ="MOBILE",nullable=true,length=32)
	public java.lang.String getMobile(){
		return this.mobile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setMobile(java.lang.String mobile){
		this.mobile = mobile;
	}
	
}
