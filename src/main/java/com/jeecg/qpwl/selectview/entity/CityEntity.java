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
 * @Description: 城市
 * @author onlineGenerator
 * @date 2018-01-08 10:53:43
 * @version V1.0   
 *
 */
@Entity
@Table(name = "city", schema = "")
@SuppressWarnings("serial")
public class CityEntity implements java.io.Serializable {
	/**城市ID*/
	@Excel(name="城市ID",width=15)
	private java.lang.String cityid;
	/**城市名称*/
	@Excel(name="城市名称",width=15)
	private java.lang.String cityname;
	/**城市编码*/
	@Excel(name="城市编码",width=15)
	private java.lang.String citycode;
	/**省份ID*/
	@Excel(name="省份ID",width=15)
	private java.lang.String provinceid;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  城市ID
	 */
	@Id
	@Column(name ="CITYID",nullable=false,length=15)
	public java.lang.String getCityid(){
		return this.cityid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  城市ID
	 */
	public void setCityid(java.lang.String cityid){
		this.cityid = cityid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  城市名称
	 */

	@Column(name ="CITYNAME",nullable=false,length=50)
	public java.lang.String getCityname(){
		return this.cityname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  城市名称
	 */
	public void setCityname(java.lang.String cityname){
		this.cityname = cityname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  城市编码
	 */

	@Column(name ="CITYCODE",nullable=false,length=50)
	public java.lang.String getCitycode(){
		return this.citycode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  城市编码
	 */
	public void setCitycode(java.lang.String citycode){
		this.citycode = citycode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  省份ID
	 */

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
}
