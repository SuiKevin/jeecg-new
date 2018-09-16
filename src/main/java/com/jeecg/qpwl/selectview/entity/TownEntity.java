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
 * @Description: 区县
 * @author onlineGenerator
 * @date 2018-01-08 10:53:20
 * @version V1.0   
 *
 */
@Entity
@Table(name = "town", schema = "")
@SuppressWarnings("serial")
public class TownEntity implements java.io.Serializable {
	/**区县ID*/
	@Excel(name="区县ID",width=15)
	private java.lang.String townid;
	/**区县名称*/
	@Excel(name="区县名称",width=15)
	private java.lang.String townname;
	/**区县编码*/
	@Excel(name="区县编码",width=15)
	private java.lang.String towncode;
	/**城市ID*/
	@Excel(name="城市ID",width=15)
	private java.lang.String cityid;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  区县ID
	 */
	@Id
	@Column(name ="TOWNID",nullable=true,length=45)
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  区县名称
	 */

	@Column(name ="TOWNNAME",nullable=true,length=150)
	public java.lang.String getTownname(){
		return this.townname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  区县名称
	 */
	public void setTownname(java.lang.String townname){
		this.townname = townname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  区县编码
	 */

	@Column(name ="TOWNCODE",nullable=true,length=150)
	public java.lang.String getTowncode(){
		return this.towncode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  区县编码
	 */
	public void setTowncode(java.lang.String towncode){
		this.towncode = towncode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  城市ID
	 */

	@Column(name ="CITYID",nullable=true,length=45)
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
}
