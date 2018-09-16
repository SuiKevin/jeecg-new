package com.jeecg.qp.jobtype.entity;
 

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
 * @Description: 简历职位管理
 * @author onlineGenerator
 * @date 2017-12-30 20:31:43
 * @version V1.0   
 *
 */
@Entity
@Table(name = "qp_jobtype", schema = "")
@SuppressWarnings("serial")
public class QpJobtypeEntity implements java.io.Serializable {
	/**主键*/

	private java.lang.String id;
	/**可查看的职位编码*/
    @Excel(name="可查看的职位编码",width=15)
		
	private java.lang.String jobtypeCode;
	/**可查看的职位名称*/
    @Excel(name="可查看的职位名称",width=15)
		
	private java.lang.String jobtypeName;
    private java.lang.String positionid;
    private java.lang.String positionname;
    private java.lang.String jobtype1;
    private java.lang.String jobid;
    private java.lang.String jobtype2;
    private java.lang.String jobdesccode;
    private java.lang.String jobtype3;
   
    

    public java.lang.String getJobdesccode() {
		return jobdesccode;
	}

	public void setJobdesccode(java.lang.String jobdesccode) {
		this.jobdesccode = jobdesccode;
	}

	public java.lang.String getJobtype3() {
		return jobtype3;
	}

	public void setJobtype3(java.lang.String jobtype3) {
		this.jobtype3 = jobtype3;
	}

	@Column(name ="positionid")
    public java.lang.String getPositionid() {
		return positionid;
	}
    
    @Column(name ="jobtype1")
	public java.lang.String getJobtype1() {
		return jobtype1;
	}

	public void setJobtype1(java.lang.String jobtype1) {
		this.jobtype1 = jobtype1;
	}
	@Column(name ="jobid")
	public java.lang.String getJobid() {
		return jobid;
	}

	public void setJobid(java.lang.String jobid) {
		this.jobid = jobid;
	}
	@Column(name ="jobtype2")
	public java.lang.String getJobtype2() {
		return jobtype2;
	}

	public void setJobtype2(java.lang.String jobtype2) {
		this.jobtype2 = jobtype2;
	}

	public void setPositionid(java.lang.String positionid) {
		this.positionid = positionid;
	}
	@Transient
	public java.lang.String getPositionname() {
		return positionname;
	}

	public void setPositionname(java.lang.String positionname) {
		this.positionname = positionname;
	}

	private TSUser tsuser;

    private java.lang.String  owndeparts;
     
	@OneToOne(cascade=CascadeType.MERGE,optional=true)
	@JoinColumn(name="id")//注释本表中指向另一个表的外键。
	@NotFound(action=NotFoundAction.IGNORE)
	public TSUser getTsuser() {
		return tsuser;
	}

	public void setTsuser(TSUser tsuser) {
		this.tsuser = tsuser;
	}
    
	
	@Transient
	public java.lang.String getOwndeparts() {
		return owndeparts;
	}

	public void setOwndeparts(java.lang.String owndeparts) {
		this.owndeparts = owndeparts;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  可查看的职位编码
	 */
	@Column(name ="JOBTYPE_CODE",nullable=true,length=320)
	public java.lang.String getJobtypeCode(){
		return this.jobtypeCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  可查看的职位编码
	 */
	public void setJobtypeCode(java.lang.String jobtypeCode){
		this.jobtypeCode = jobtypeCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  可查看的职位名称
	 */
	@Column(name ="JOBTYPE_NAME",nullable=true,length=320)
	public java.lang.String getJobtypeName(){
		return this.jobtypeName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  可查看的职位名称
	 */
	public void setJobtypeName(java.lang.String jobtypeName){
		this.jobtypeName = jobtypeName;
	}
}
