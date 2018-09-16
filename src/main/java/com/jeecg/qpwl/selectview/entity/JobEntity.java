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
 * @Description: 职位小类
 * @author onlineGenerator
 * @date 2018-01-08 19:47:41
 * @version V1.0   
 *
 */
@Entity
@Table(name = "job", schema = "")
@SuppressWarnings("serial")
public class JobEntity implements java.io.Serializable {
	/**职位ID*/
	@Excel(name="职位ID",width=15)
	private java.lang.String jobid;
	/**职位名称*/
	@Excel(name="职位名称",width=15)
	private java.lang.String jobname;
	/**职位编码*/
	@Excel(name="职位编码",width=15)
	private java.lang.String jobcode;
	/**职位大类ID*/
	@Excel(name="职位大类ID",width=15)
	private java.lang.String positionid;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位ID
	 */
	@Id
	@Column(name ="JOBID",nullable=true,length=10)
	public java.lang.String getJobid(){
		return this.jobid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位ID
	 */
	public void setJobid(java.lang.String jobid){
		this.jobid = jobid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位名称
	 */

	@Column(name ="JOBNAME",nullable=true,length=150)
	public java.lang.String getJobname(){
		return this.jobname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位名称
	 */
	public void setJobname(java.lang.String jobname){
		this.jobname = jobname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位编码
	 */

	@Column(name ="JOBCODE",nullable=true,length=150)
	public java.lang.String getJobcode(){
		return this.jobcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位编码
	 */
	public void setJobcode(java.lang.String jobcode){
		this.jobcode = jobcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位大类ID
	 */

	@Column(name ="POSITIONID",nullable=true,length=10)
	public java.lang.String getPositionid(){
		return this.positionid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位大类ID
	 */
	public void setPositionid(java.lang.String positionid){
		this.positionid = positionid;
	}
}
