package com.jeecg.qpwl.selectview.entity;

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
 * @Description: 职位描述
 * @author onlineGenerator
 * @date 2018-01-08 19:47:47
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jobdescription", schema = "")
@SuppressWarnings("serial")
public class JobdescriptionEntity implements java.io.Serializable {
	/**职位ID*/
	@Excel(name="职位ID",width=15)
	private java.lang.String jobid;
	/**职位名称*/
	@Excel(name="职位名称",width=15)
	private java.lang.String jobdescname;
	/**职位描述ID*/
	@Excel(name="职位描述ID",width=15)
	private java.lang.String jobdesccode;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  职位ID
	 */

	@Column(name ="JOBID",nullable=true,length=10)
	public java.lang.String getJobid(){
		return this.jobid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  职位ID
	 */
	public void setJobid(java.lang.String jobid){
		this.jobid = jobid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位名称
	 */

	@Column(name ="JOBDESCNAME",nullable=true,length=150)
	public java.lang.String getJobdescname(){
		return this.jobdescname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位名称
	 */
	public void setJobdescname(java.lang.String jobdescname){
		this.jobdescname = jobdescname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位描述ID
	 */
	@Id
	@Column(name ="JOBDESCCODE",nullable=true,length=150)
	public java.lang.String getJobdesccode(){
		return this.jobdesccode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位描述ID
	 */
	public void setJobdesccode(java.lang.String jobdesccode){
		this.jobdesccode = jobdesccode;
	}
}
