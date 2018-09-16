
package com.jeecg.qpwl.talentpool.page;
import com.jeecg.qpwl.talentpool.entity.JianliBusinessEntity;
import com.jeecg.qpwl.talentpool.entity.JianliBusinessJiaoyuEntity;
import com.jeecg.qpwl.talentpool.entity.JianliBusinessJingyanEntity;
import com.jeecg.qpwl.talentpool.entity.JianliXiaofenEntity;
import com.jeecg.qpwl.talentpool.entity.JinaliBusinessZhengshuEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;

/**   
 * @Title: Entity
 * @Description: 企业人才库
 * @author onlineGenerator
 * @date 2018-01-03 15:03:15
 * @version V1.0   
 *
 */
public class JianliBusinessPage implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**网站类型*/
    @Excel(name="网站类型")
	private java.lang.String website;
	/**省份*/
    @Excel(name="省份")
	private java.lang.String province;
	/**城市*/
    @Excel(name="城市")
	private java.lang.String city;
	/**区县*/
    @Excel(name="区县")
	private java.lang.String town;
	/**职位大类*/
    @Excel(name="职位大类")
	private java.lang.String jobtype1;
	/**职位小类*/
    @Excel(name="职位小类")
	private java.lang.String jobtype2;
	/**职位详情*/
    @Excel(name="职位详情")
	private java.lang.String jobtype3;
	/**姓名*/
    @Excel(name="姓名")
	private java.lang.String name;
	/**性别*/
    @Excel(name="性别")
	private java.lang.String sex;
	/**年龄*/
    @Excel(name="年龄")
	private java.lang.Integer age;
	/**联系电话*/
    @Excel(name="联系电话")
	private java.lang.String mobile;
	/**电子邮件*/
    @Excel(name="电子邮件")
	private java.lang.String email;
	/**学历*/
    @Excel(name="学历")
	private java.lang.String xueli;
	/**工作经验*/
    @Excel(name="工作经验")
	private java.lang.String gzjy;
	/**籍贯*/
    @Excel(name="籍贯")
	private java.lang.String jg;
	/**先居地*/
    @Excel(name="先居地")
	private java.lang.String xjzd;
	/**期望职位*/
    @Excel(name="期望职位")
	private java.lang.String qwzw;
	/**目前职位*/
    @Excel(name="目前职位")
	private java.lang.String mqzw;
	/**期望薪资*/
    @Excel(name="期望薪资")
	private java.lang.String qwxz;
	/**期望工作地*/
    @Excel(name="期望工作地")
	private java.lang.String qwgzd;
	/**个人标签*/
    @Excel(name="个人标签")
	private java.lang.String grbq;
	/**自我评价*/
    @Excel(name="自我评价")
	private javax.xml.soap.Text zwpj;
	/**详细工作经验*/
    @Excel(name="详细工作经验")
	private java.lang.String xxgzjy;
	/**教育经历*/
    @Excel(name="教育经历")
	private java.lang.String jyjl;
	/**获得证书*/
    @Excel(name="获得证书")
	private java.lang.String hdzs;
	/**更新时间*/
    @Excel(name="更新时间",format = "yyyy-MM-dd")
	private java.util.Date gxsj;
	/**被浏览*/
    @Excel(name="被浏览")
	private java.lang.String bllcs;
	/**查看过*/
    @Excel(name="查看过")
	private java.lang.String bckg;
	/**主动申请*/
    @Excel(name="主动申请")
	private java.lang.String zdsq;
	/**对他感兴趣*/
    @Excel(name="对他感兴趣")
	private java.lang.String dtgxq;
	/**被下载*/
    @Excel(name="被下载")
	private java.lang.String bxzcs;
	/**收到邀请*/
    @Excel(name="收到邀请")
	private java.lang.String sdyq;
	/**录入时间*/
    @Excel(name="录入时间",format = "yyyy-MM-dd")
	private java.util.Date lrsj;
	/**证件照片*/
    @Excel(name="证件照片")
	private java.lang.String zjzp;
	/**录入方式*/
    @Excel(name="录入方式")
	private java.lang.String lrfs;
	/**录入网点*/
    @Excel(name="录入网点")
	private java.lang.String lrwd;
	/**录入人员*/
    @Excel(name="录入人员")
	private java.lang.String lrry;
	/**身份证号*/
    @Excel(name="身份证号")
	private java.lang.String sfzh;
	/**民族*/
    @Excel(name="民族")
	private java.lang.String mz;
	/**出生日期*/
    @Excel(name="出生日期")
	private java.lang.String csrq;
	/**住址*/
    @Excel(name="住址")
	private java.lang.String address;
	/**签发机关*/
    @Excel(name="签发机关")
	private java.lang.String fzjg;
	/**有效期*/
    @Excel(name="有效期")
	private java.lang.String yxq;
	/**身份录入时间*/
    @Excel(name="身份录入时间",format = "yyyy-MM-dd")
	private java.util.Date sflrsj;
	/**身份证录入网点*/
    @Excel(name="身份证录入网点")
	private java.lang.String sfzlrwd;
	/**身份证录入人员*/
    @Excel(name="身份证录入人员")
	private java.lang.String sfzlrry;
	/**身份证是否有磁*/
    @Excel(name="身份证是否有磁")
	private java.lang.String sfzsfyc;
	/**婚姻状况*/
    @Excel(name="婚姻状况")
	private java.lang.String hyzk;
	/**政治面貌*/
    @Excel(name="政治面貌")
	private java.lang.String zzmm;
	/**健康状况*/
    @Excel(name="健康状况")
	private java.lang.String jkzk;
	/**病史详情*/
    @Excel(name="病史详情")
	private java.lang.String bsxq;
	/**户口性质*/
    @Excel(name="户口性质")
	private java.lang.String hkxz;
	/**犯罪记录*/
    @Excel(name="犯罪记录")
	private java.lang.String fzjl;
	/**劳动关系*/
    @Excel(name="劳动关系")
	private java.lang.String ldgx;
	/**离职原因*/
    @Excel(name="离职原因")
	private java.lang.String lzyy;
	/**背景录入网点*/
    @Excel(name="背景录入网点")
	private java.lang.String bjlrwd;
	/**背景录入人员*/
    @Excel(name="背景录入人员")
	private java.lang.String bjlrry;
	/**背景录入日期*/
    @Excel(name="背景录入日期")
	private java.lang.String bjlrrq;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
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
	 *@return: java.lang.String  网站类型
	 */
	public java.lang.String getWebsite(){
		return this.website;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  网站类型
	 */
	public void setWebsite(java.lang.String website){
		this.website = website;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  省份
	 */
	public java.lang.String getProvince(){
		return this.province;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  省份
	 */
	public void setProvince(java.lang.String province){
		this.province = province;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  城市
	 */
	public java.lang.String getCity(){
		return this.city;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  城市
	 */
	public void setCity(java.lang.String city){
		this.city = city;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  区县
	 */
	public java.lang.String getTown(){
		return this.town;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  区县
	 */
	public void setTown(java.lang.String town){
		this.town = town;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位大类
	 */
	public java.lang.String getJobtype1(){
		return this.jobtype1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位大类
	 */
	public void setJobtype1(java.lang.String jobtype1){
		this.jobtype1 = jobtype1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位小类
	 */
	public java.lang.String getJobtype2(){
		return this.jobtype2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位小类
	 */
	public void setJobtype2(java.lang.String jobtype2){
		this.jobtype2 = jobtype2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位详情
	 */
	public java.lang.String getJobtype3(){
		return this.jobtype3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位详情
	 */
	public void setJobtype3(java.lang.String jobtype3){
		this.jobtype3 = jobtype3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  年龄
	 */
	public java.lang.Integer getAge(){
		return this.age;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  年龄
	 */
	public void setAge(java.lang.Integer age){
		this.age = age;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	public java.lang.String getMobile(){
		return this.mobile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setMobile(java.lang.String mobile){
		this.mobile = mobile;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电子邮件
	 */
	public java.lang.String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电子邮件
	 */
	public void setEmail(java.lang.String email){
		this.email = email;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学历
	 */
	public java.lang.String getXueli(){
		return this.xueli;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历
	 */
	public void setXueli(java.lang.String xueli){
		this.xueli = xueli;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作经验
	 */
	public java.lang.String getGzjy(){
		return this.gzjy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作经验
	 */
	public void setGzjy(java.lang.String gzjy){
		this.gzjy = gzjy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  籍贯
	 */
	public java.lang.String getJg(){
		return this.jg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  籍贯
	 */
	public void setJg(java.lang.String jg){
		this.jg = jg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  先居地
	 */
	public java.lang.String getXjzd(){
		return this.xjzd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  先居地
	 */
	public void setXjzd(java.lang.String xjzd){
		this.xjzd = xjzd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  期望职位
	 */
	public java.lang.String getQwzw(){
		return this.qwzw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  期望职位
	 */
	public void setQwzw(java.lang.String qwzw){
		this.qwzw = qwzw;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  目前职位
	 */
	public java.lang.String getMqzw(){
		return this.mqzw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  目前职位
	 */
	public void setMqzw(java.lang.String mqzw){
		this.mqzw = mqzw;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  期望薪资
	 */
	public java.lang.String getQwxz(){
		return this.qwxz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  期望薪资
	 */
	public void setQwxz(java.lang.String qwxz){
		this.qwxz = qwxz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  期望工作地
	 */
	public java.lang.String getQwgzd(){
		return this.qwgzd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  期望工作地
	 */
	public void setQwgzd(java.lang.String qwgzd){
		this.qwgzd = qwgzd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  个人标签
	 */
	public java.lang.String getGrbq(){
		return this.grbq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  个人标签
	 */
	public void setGrbq(java.lang.String grbq){
		this.grbq = grbq;
	}
	/**
	 *方法: 取得javax.xml.soap.Text
	 *@return: javax.xml.soap.Text  自我评价
	 */
	public javax.xml.soap.Text getZwpj(){
		return this.zwpj;
	}

	/**
	 *方法: 设置javax.xml.soap.Text
	 *@param: javax.xml.soap.Text  自我评价
	 */
	public void setZwpj(javax.xml.soap.Text zwpj){
		this.zwpj = zwpj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  详细工作经验
	 */
	public java.lang.String getXxgzjy(){
		return this.xxgzjy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  详细工作经验
	 */
	public void setXxgzjy(java.lang.String xxgzjy){
		this.xxgzjy = xxgzjy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  教育经历
	 */
	public java.lang.String getJyjl(){
		return this.jyjl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  教育经历
	 */
	public void setJyjl(java.lang.String jyjl){
		this.jyjl = jyjl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  获得证书
	 */
	public java.lang.String getHdzs(){
		return this.hdzs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  获得证书
	 */
	public void setHdzs(java.lang.String hdzs){
		this.hdzs = hdzs;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新时间
	 */
	public java.util.Date getGxsj(){
		return this.gxsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新时间
	 */
	public void setGxsj(java.util.Date gxsj){
		this.gxsj = gxsj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  被浏览
	 */
	public java.lang.String getBllcs(){
		return this.bllcs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  被浏览
	 */
	public void setBllcs(java.lang.String bllcs){
		this.bllcs = bllcs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  查看过
	 */
	public java.lang.String getBckg(){
		return this.bckg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  查看过
	 */
	public void setBckg(java.lang.String bckg){
		this.bckg = bckg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主动申请
	 */
	public java.lang.String getZdsq(){
		return this.zdsq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主动申请
	 */
	public void setZdsq(java.lang.String zdsq){
		this.zdsq = zdsq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  对他感兴趣
	 */
	public java.lang.String getDtgxq(){
		return this.dtgxq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  对他感兴趣
	 */
	public void setDtgxq(java.lang.String dtgxq){
		this.dtgxq = dtgxq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  被下载
	 */
	public java.lang.String getBxzcs(){
		return this.bxzcs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  被下载
	 */
	public void setBxzcs(java.lang.String bxzcs){
		this.bxzcs = bxzcs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收到邀请
	 */
	public java.lang.String getSdyq(){
		return this.sdyq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收到邀请
	 */
	public void setSdyq(java.lang.String sdyq){
		this.sdyq = sdyq;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  录入时间
	 */
	public java.util.Date getLrsj(){
		return this.lrsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  录入时间
	 */
	public void setLrsj(java.util.Date lrsj){
		this.lrsj = lrsj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件照片
	 */
	public java.lang.String getZjzp(){
		return this.zjzp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件照片
	 */
	public void setZjzp(java.lang.String zjzp){
		this.zjzp = zjzp;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  录入方式
	 */
	public java.lang.String getLrfs(){
		return this.lrfs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  录入方式
	 */
	public void setLrfs(java.lang.String lrfs){
		this.lrfs = lrfs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  录入网点
	 */
	public java.lang.String getLrwd(){
		return this.lrwd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  录入网点
	 */
	public void setLrwd(java.lang.String lrwd){
		this.lrwd = lrwd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  录入人员
	 */
	public java.lang.String getLrry(){
		return this.lrry;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  录入人员
	 */
	public void setLrry(java.lang.String lrry){
		this.lrry = lrry;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */
	public java.lang.String getSfzh(){
		return this.sfzh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setSfzh(java.lang.String sfzh){
		this.sfzh = sfzh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  民族
	 */
	public java.lang.String getMz(){
		return this.mz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  民族
	 */
	public void setMz(java.lang.String mz){
		this.mz = mz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出生日期
	 */
	public java.lang.String getCsrq(){
		return this.csrq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出生日期
	 */
	public void setCsrq(java.lang.String csrq){
		this.csrq = csrq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  住址
	 */
	public java.lang.String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  住址
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  签发机关
	 */
	public java.lang.String getFzjg(){
		return this.fzjg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  签发机关
	 */
	public void setFzjg(java.lang.String fzjg){
		this.fzjg = fzjg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  有效期
	 */
	public java.lang.String getYxq(){
		return this.yxq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  有效期
	 */
	public void setYxq(java.lang.String yxq){
		this.yxq = yxq;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  身份录入时间
	 */
	public java.util.Date getSflrsj(){
		return this.sflrsj;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  身份录入时间
	 */
	public void setSflrsj(java.util.Date sflrsj){
		this.sflrsj = sflrsj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证录入网点
	 */
	public java.lang.String getSfzlrwd(){
		return this.sfzlrwd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证录入网点
	 */
	public void setSfzlrwd(java.lang.String sfzlrwd){
		this.sfzlrwd = sfzlrwd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证录入人员
	 */
	public java.lang.String getSfzlrry(){
		return this.sfzlrry;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证录入人员
	 */
	public void setSfzlrry(java.lang.String sfzlrry){
		this.sfzlrry = sfzlrry;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证是否有磁
	 */
	public java.lang.String getSfzsfyc(){
		return this.sfzsfyc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证是否有磁
	 */
	public void setSfzsfyc(java.lang.String sfzsfyc){
		this.sfzsfyc = sfzsfyc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  婚姻状况
	 */
	public java.lang.String getHyzk(){
		return this.hyzk;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  婚姻状况
	 */
	public void setHyzk(java.lang.String hyzk){
		this.hyzk = hyzk;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  政治面貌
	 */
	public java.lang.String getZzmm(){
		return this.zzmm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  政治面貌
	 */
	public void setZzmm(java.lang.String zzmm){
		this.zzmm = zzmm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  健康状况
	 */
	public java.lang.String getJkzk(){
		return this.jkzk;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  健康状况
	 */
	public void setJkzk(java.lang.String jkzk){
		this.jkzk = jkzk;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  病史详情
	 */
	public java.lang.String getBsxq(){
		return this.bsxq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  病史详情
	 */
	public void setBsxq(java.lang.String bsxq){
		this.bsxq = bsxq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户口性质
	 */
	public java.lang.String getHkxz(){
		return this.hkxz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户口性质
	 */
	public void setHkxz(java.lang.String hkxz){
		this.hkxz = hkxz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  犯罪记录
	 */
	public java.lang.String getFzjl(){
		return this.fzjl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  犯罪记录
	 */
	public void setFzjl(java.lang.String fzjl){
		this.fzjl = fzjl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  劳动关系
	 */
	public java.lang.String getLdgx(){
		return this.ldgx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  劳动关系
	 */
	public void setLdgx(java.lang.String ldgx){
		this.ldgx = ldgx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  离职原因
	 */
	public java.lang.String getLzyy(){
		return this.lzyy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  离职原因
	 */
	public void setLzyy(java.lang.String lzyy){
		this.lzyy = lzyy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  背景录入网点
	 */
	public java.lang.String getBjlrwd(){
		return this.bjlrwd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  背景录入网点
	 */
	public void setBjlrwd(java.lang.String bjlrwd){
		this.bjlrwd = bjlrwd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  背景录入人员
	 */
	public java.lang.String getBjlrry(){
		return this.bjlrry;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  背景录入人员
	 */
	public void setBjlrry(java.lang.String bjlrry){
		this.bjlrry = bjlrry;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  背景录入日期
	 */
	public java.lang.String getBjlrrq(){
		return this.bjlrrq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  背景录入日期
	 */
	public void setBjlrrq(java.lang.String bjlrrq){
		this.bjlrrq = bjlrrq;
	}

	/**保存-学历教育*/
    @ExcelCollection(name="学历教育")
	private List<JianliBusinessJiaoyuEntity> jianliBusinessJiaoyuList = new ArrayList<JianliBusinessJiaoyuEntity>();
		public List<JianliBusinessJiaoyuEntity> getJianliBusinessJiaoyuList() {
		return jianliBusinessJiaoyuList;
		}
		public void setJianliBusinessJiaoyuList(List<JianliBusinessJiaoyuEntity> jianliBusinessJiaoyuList) {
		this.jianliBusinessJiaoyuList = jianliBusinessJiaoyuList;
		}
	/**保存-工作经验*/
    @ExcelCollection(name="工作经验")
	private List<JianliBusinessJingyanEntity> jianliBusinessJingyanList = new ArrayList<JianliBusinessJingyanEntity>();
		public List<JianliBusinessJingyanEntity> getJianliBusinessJingyanList() {
		return jianliBusinessJingyanList;
		}
		public void setJianliBusinessJingyanList(List<JianliBusinessJingyanEntity> jianliBusinessJingyanList) {
		this.jianliBusinessJingyanList = jianliBusinessJingyanList;
		}
		/**保存-获取证书*/
		@ExcelCollection(name="获取证书")
		private List<JinaliBusinessZhengshuEntity> jinaliBusinessZhengshuList = new ArrayList<JinaliBusinessZhengshuEntity>();
		public List<JinaliBusinessZhengshuEntity> getJinaliBusinessZhengshuList() {
		return jinaliBusinessZhengshuList;
		}
		public void setJinaliBusinessZhengshuList(List<JinaliBusinessZhengshuEntity> jinaliBusinessZhengshuList) {
		this.jinaliBusinessZhengshuList = jinaliBusinessZhengshuList;
		}
		/**保存-积分消费情况*/
		@ExcelCollection(name="积分消费情况")
		private List<JianliXiaofenEntity> jianliXiaofenList = new ArrayList<JianliXiaofenEntity>();
		public List<JianliXiaofenEntity> getJianliXiaofenList() {
			return jianliXiaofenList;
		}
		public void setJianliXiaofenList(List<JianliXiaofenEntity> jianliXiaofenList) {
			this.jianliXiaofenList = jianliXiaofenList;
		}
}
