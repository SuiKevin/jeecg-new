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
 * @Description: 获取证书
 * @author onlineGenerator
 * @date 2017-12-29 18:04:42
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jinali_zhengshu", schema = "")
@SuppressWarnings("serial")
public class JinaliZhengshuEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**证书*/
    @Excel(name="证书",width=15)
	private java.lang.String zhengshu;
	/**获证日期*/
    @Excel(name="获证日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date hqrq;
	/**简历ID*/
	private java.lang.String resumeId;
	
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
	 *@return: java.lang.String  证书
	 */
	
	@Column(name ="ZHENGSHU",nullable=true,length=50)
	public java.lang.String getZhengshu(){
		return this.zhengshu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证书
	 */
	public void setZhengshu(java.lang.String zhengshu){
		this.zhengshu = zhengshu;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  获证日期
	 */
	
	@Column(name ="HQRQ",nullable=true,length=20)
	public java.util.Date getHqrq(){
		return this.hqrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  获证日期
	 */
	public void setHqrq(java.util.Date hqrq){
		this.hqrq = hqrq;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  简历ID
	 */
	
	@Column(name ="RESUME_ID",nullable=true,length=32)
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
	
}
