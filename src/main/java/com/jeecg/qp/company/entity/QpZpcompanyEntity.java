package com.jeecg.qp.company.entity;

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
 * @Description: 招聘企业信息
 * @author onlineGenerator
 * @date 2018-01-02 17:27:47
 * @version V1.0   
 *
 */
@Entity
@Table(name = "qp_zpcompany", schema = "")
@SuppressWarnings("serial")
public class QpZpcompanyEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**公司名称*/
	@Excel(name="公司名称",width=15)
	private java.lang.String zpCompany;
	/**公司介绍*/
	@Excel(name="公司介绍",width=15)
	private java.lang.String companyInfo;
	/**招聘岗位*/
	@Excel(name="招聘岗位",width=15)
	private java.lang.String zpJob;
	/**招聘人数*/
	@Excel(name="招聘人数",width=15)
	private java.lang.String zpPersonnum;
	/**学历*/
	@Excel(name="学历",width=15,dicCode="edu")
	private java.lang.String edu;
	/**职位描述*/
	@Excel(name="职位描述",width=15)
	private java.lang.String jobInfo;
	/**经验要求*/
	@Excel(name="经验要求",width=15)
	private java.lang.String jingyan;
	/**地址*/
	@Excel(name="地址",width=15)
	private java.lang.String address;
	/**薪资待遇*/
	@Excel(name="薪资待遇",width=15)
	private java.lang.String money;
	
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
	 *@return: java.lang.String  公司名称
	 */

	@Column(name ="ZP_COMPANY",nullable=true,length=200)
	public java.lang.String getZpCompany(){
		return this.zpCompany;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司名称
	 */
	public void setZpCompany(java.lang.String zpCompany){
		this.zpCompany = zpCompany;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司介绍
	 */

	@Column(name ="COMPANY_INFO",nullable=true,length=1000)
	public java.lang.String getCompanyInfo(){
		return this.companyInfo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司介绍
	 */
	public void setCompanyInfo(java.lang.String companyInfo){
		this.companyInfo = companyInfo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  招聘岗位
	 */

	@Column(name ="ZP_JOB",nullable=true,length=200)
	public java.lang.String getZpJob(){
		return this.zpJob;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘岗位
	 */
	public void setZpJob(java.lang.String zpJob){
		this.zpJob = zpJob;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  招聘人数
	 */

	@Column(name ="ZP_PERSONNUM",nullable=true,length=60)
	public java.lang.String getZpPersonnum(){
		return this.zpPersonnum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘人数
	 */
	public void setZpPersonnum(java.lang.String zpPersonnum){
		this.zpPersonnum = zpPersonnum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学历
	 */

	@Column(name ="EDU",nullable=true,length=60)
	public java.lang.String getEdu(){
		return this.edu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历
	 */
	public void setEdu(java.lang.String edu){
		this.edu = edu;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位描述
	 */

	@Column(name ="JOB_INFO",nullable=true,length=1000)
	public java.lang.String getJobInfo(){
		return this.jobInfo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位描述
	 */
	public void setJobInfo(java.lang.String jobInfo){
		this.jobInfo = jobInfo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  经验要求
	 */

	@Column(name ="JINGYAN",nullable=true,length=200)
	public java.lang.String getJingyan(){
		return this.jingyan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  经验要求
	 */
	public void setJingyan(java.lang.String jingyan){
		this.jingyan = jingyan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地址
	 */

	@Column(name ="ADDRESS",nullable=true,length=100)
	public java.lang.String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地址
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  薪资待遇
	 */

	@Column(name ="MONEY",nullable=true,length=200)
	public java.lang.String getMoney(){
		return this.money;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  薪资待遇
	 */
	public void setMoney(java.lang.String money){
		this.money = money;
	}
}
