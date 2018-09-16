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
 * @Description: 职位大类
 * @author onlineGenerator
 * @date 2018-01-08 19:46:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jobPosition", schema = "")
@SuppressWarnings("serial")
public class JobpositionEntity implements java.io.Serializable {
	/**职位ID*/
	@Excel(name="职位ID",width=15)
	private java.lang.String positionid;
	/**职位名称*/
	@Excel(name="职位名称",width=15)
	private java.lang.String positionname;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位ID
	 */
	@Id
	@Column(name ="POSITIONID",nullable=true,length=10)
	public java.lang.String getPositionid(){
		return this.positionid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位ID
	 */
	public void setPositionid(java.lang.String positionid){
		this.positionid = positionid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位名称
	 */

	@Column(name ="POSITIONNAME",nullable=true)
	public java.lang.String getPositionname(){
		return this.positionname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位名称
	 */
	public void setPositionname(java.lang.String positionname){
		this.positionname = positionname;
	}
}
