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
 * @Description: 省份
 * @author onlineGenerator
 * @date 2018-01-08 10:53:50
 * @version V1.0   
 *
 */
@Entity
@Table(name = "province", schema = "")
@SuppressWarnings("serial")
public class ProvinceEntity implements java.io.Serializable {
	/**省份ID*/
	@Excel(name="省份ID",width=15)
	private java.lang.String provinceid;
	/**省份名称*/
	@Excel(name="省份名称",width=15)
	private java.lang.String provincename;
	/**省份编码*/
	@Excel(name="省份编码",width=15)
	private java.lang.String provincecode;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  省份ID
	 */
	@Id
	@Column(name ="PROVINCEID",nullable=false,length=15)
	public java.lang.String getProvinceid(){
		return this.provinceid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  省份ID
	 */
	public void setProvinceid(java.lang.String provinceid){
		this.provinceid = provinceid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  省份名称
	 */

	@Column(name ="PROVINCENAME",nullable=false,length=50)
	public java.lang.String getProvincename(){
		return this.provincename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  省份名称
	 */
	public void setProvincename(java.lang.String provincename){
		this.provincename = provincename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  省份编码
	 */

	@Column(name ="PROVINCECODE",nullable=true,length=50)
	public java.lang.String getProvincecode(){
		return this.provincecode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  省份编码
	 */
	public void setProvincecode(java.lang.String provincecode){
		this.provincecode = provincecode;
	}
}
