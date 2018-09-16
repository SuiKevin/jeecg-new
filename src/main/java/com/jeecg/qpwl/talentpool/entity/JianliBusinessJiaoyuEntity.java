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
 * @Description: 学历教育
 * @author onlineGenerator
 * @date 2018-01-03 15:03:14
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jianli_business_jiaoyu", schema = "")
@SuppressWarnings("serial")
public class JianliBusinessJiaoyuEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**简历ID*/
	private java.lang.String resumeId;
	/**学校*/
    @Excel(name="学校",width=15)
	private java.lang.String xuexiao;
	/**专业*/
    @Excel(name="专业",width=15)
	private java.lang.String zhuanye;
	/**毕业时间*/
    @Excel(name="毕业时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date bysj;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  简历ID
	 */
	
	@Column(name ="RESUME_ID",nullable=true,length=40)
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
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学校
	 */
	
	@Column(name ="XUEXIAO",nullable=true,length=50)
	public java.lang.String getXuexiao(){
		return this.xuexiao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校
	 */
	public void setXuexiao(java.lang.String xuexiao){
		this.xuexiao = xuexiao;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专业
	 */
	
	@Column(name ="ZHUANYE",nullable=true,length=20)
	public java.lang.String getZhuanye(){
		return this.zhuanye;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专业
	 */
	public void setZhuanye(java.lang.String zhuanye){
		this.zhuanye = zhuanye;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  毕业时间
	 */
	
	@Column(name ="BYSJ",nullable=true)
	public java.util.Date getBysj(){
		return this.bysj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  毕业时间
	 */
	public void setBysj(java.util.Date bysj){
		this.bysj = bysj;
	}
	
}
