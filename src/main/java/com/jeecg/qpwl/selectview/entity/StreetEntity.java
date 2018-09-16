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
 * @Description: 城镇
 * @author onlineGenerator
 * @date 2018-01-08 10:53:36
 * @version V1.0   
 *
 */
@Entity
@Table(name = "street", schema = "")
@SuppressWarnings("serial")
public class StreetEntity implements java.io.Serializable {
	/**城镇ID*/
	@Excel(name="城镇ID",width=15)
	private java.lang.String streetid;
	/**城镇名称*/
	@Excel(name="城镇名称",width=15)
	private java.lang.String streetname;
	/**城镇编码*/
	@Excel(name="城镇编码",width=15)
	private java.lang.String streetcode;
	/**区县ID*/
	@Excel(name="区县ID",width=15)
	private java.lang.String townid;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  城镇ID
	 */
	@Id
	@Column(name ="STREETID",nullable=true,length=60)
	public java.lang.String getStreetid(){
		return this.streetid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  城镇ID
	 */
	public void setStreetid(java.lang.String streetid){
		this.streetid = streetid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  城镇名称
	 */

	@Column(name ="STREETNAME",nullable=true,length=90)
	public java.lang.String getStreetname(){
		return this.streetname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  城镇名称
	 */
	public void setStreetname(java.lang.String streetname){
		this.streetname = streetname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  城镇编码
	 */

	@Column(name ="STREETCODE",nullable=true,length=150)
	public java.lang.String getStreetcode(){
		return this.streetcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  城镇编码
	 */
	public void setStreetcode(java.lang.String streetcode){
		this.streetcode = streetcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  区县ID
	 */

	@Column(name ="TOWNID",nullable=true,length=150)
	public java.lang.String getTownid(){
		return this.townid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  区县ID
	 */
	public void setTownid(java.lang.String townid){
		this.townid = townid;
	}
}
