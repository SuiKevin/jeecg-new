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
 * @Description: 工作经验
 * @author onlineGenerator
 * @date 2018-01-03 15:03:14
 * @version V1.0   
 *
 */
@Entity
@Table(name = "jianli_business_jingyan", schema = "")
@SuppressWarnings("serial")
public class JianliBusinessJingyanEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**简历ID*/
	private java.lang.String resumeId;
	/**工作单位*/
    @Excel(name="工作单位",width=15)
	private java.lang.String gzdw;
	/**开始日期*/
    @Excel(name="开始日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date kssj;
	/**结束日期*/
    @Excel(name="结束日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date jsrq;
	/**薪资水平*/
    @Excel(name="薪资水平",width=15)
	private java.lang.String xzsp;
	/**工作职责*/
    @Excel(name="工作职责",width=15)
	private java.lang.String gzzz;
	/**在职职位*/
    @Excel(name="在职职位",width=15)
	private java.lang.String zzzw;
	
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
	 *@return: java.lang.String  简历ID
	 */
	
	@Column(name ="RESUME_ID",nullable=true,length=50)
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
	 *@return: java.lang.String  工作单位
	 */
	
	@Column(name ="GZDW",nullable=true,length=100)
	public java.lang.String getGzdw(){
		return this.gzdw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作单位
	 */
	public void setGzdw(java.lang.String gzdw){
		this.gzdw = gzdw;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开始日期
	 */
	
	@Column(name ="KSSJ",nullable=true)
	public java.util.Date getKssj(){
		return this.kssj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开始日期
	 */
	public void setKssj(java.util.Date kssj){
		this.kssj = kssj;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  结束日期
	 */
	
	@Column(name ="JSRQ",nullable=true)
	public java.util.Date getJsrq(){
		return this.jsrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  结束日期
	 */
	public void setJsrq(java.util.Date jsrq){
		this.jsrq = jsrq;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  薪资水平
	 */
	
	@Column(name ="XZSP",nullable=true,length=50)
	public java.lang.String getXzsp(){
		return this.xzsp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  薪资水平
	 */
	public void setXzsp(java.lang.String xzsp){
		this.xzsp = xzsp;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作职责
	 */
	
	@Column(name ="GZZZ",nullable=true,length=4000)
	public java.lang.String getGzzz(){
		return this.gzzz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作职责
	 */
	public void setGzzz(java.lang.String gzzz){
		this.gzzz = gzzz;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  在职职位
	 */
	
	@Column(name ="ZZZW",nullable=true,length=100)
	public java.lang.String getZzzw(){
		return this.zzzw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  在职职位
	 */
	public void setZzzw(java.lang.String zzzw){
		this.zzzw = zzzw;
	}
	
}
