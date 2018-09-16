package com.jeecg.qpwl.order.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 在途工单
 * @author onlineGenerator
 * @date 2017-12-24 21:50:07
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_order_ing", schema = "")
@SuppressWarnings("serial")
public class TOrderIngEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**简历ID*/
	private java.lang.String resumeId;
	/**流程实例ID*/
	private java.lang.String processInstanceId;
	/**创建日期*/
	private java.util.Date createDate;
	/**创建人ID*/
	private java.lang.String createUserId;
	/**创建人名称*/
	private java.lang.String createUserName;
	/**求职意向*/
	private java.lang.String qzjob;

	/**企业名称*/
	 @Excel(name="入职企业",width=15)
	private java.lang.String businessName;
	/**姓名*/
    @Excel(name="姓名",width=15)
	private java.lang.String name;
	/**性别*/
    @Excel(name="性别",width=15)
	private java.lang.String sex;
	/**年龄*/
    @Excel(name="年龄",width=15,dicCode="bpm_status")
	private java.lang.Integer age;
	/**工作经验*/
	private java.lang.String gzjy;
	/**目前职位*/
	private java.lang.String mqjob;
    @Excel(name="身份证号",width=15)
    private java.lang.String sfzh;
    
    @Excel(name="联系电话",width=15)
    private java.lang.String mobile;

	/**邀约门店*/
	private java.lang.String inviteStore;
	/**邀约门店名称*/
	@Excel(name="邀约门店",width=15)
	private java.lang.String mdName;
	/**邀约门店地址*/
	@Excel(name="门店地址",width=15)
	private java.lang.String mdAddress;
	/**邀约门店电话*/
	@Excel(name="门店电话",width=15)
	private java.lang.String mdMobile;
    
    /**当前环节*/
    @Transient
    private java.lang.String taskName;
	/**邀约结果*/

	private java.lang.String inviteResult;
	/**预约面试时间*/
	private java.lang.String inviteDate;
	/**邀约备注*/
	private java.lang.String inviteRemarks;
	/**职位名称*/
	private java.lang.String positionName;
	/**面试结论*/
	private java.lang.String interviewResult;
	/**不通过原因*/
	private java.lang.String interviewReason;
	/**预约接送时间*/
	private java.lang.String interviewPickDate;
	/**审核时间*/
	private java.lang.String examineDate;
	/**审核结论*/
	private java.lang.String examineResult;
	/**审核备注*/
	private java.lang.String examineRemarks;
	/**接送时间*/
	private java.lang.String pickDate;
	/**接送结论*/
	private java.lang.String pickResult;
	/**体检结果*/
	private java.lang.String workTijianResult;
	/**复试结果*/
	private java.lang.String workFushiResult;
	/**是否签订劳动合同*/
	private java.lang.String workHetongResult;
	/**复试是否通过*/
	private java.lang.String ruzhiFushiResult;
	/**是否签订劳动合同*/
	private java.lang.String ruzhiHetongResult;
	/**体检结果*/
	private java.lang.String ruzhiTijianResult;
	/**培训结果*/
	private java.lang.String ruzhiPeixunResult;
	/**是否住宿*/
	private java.lang.String ruzhiZhusuResult;
	/**是否上岗*/
	private java.lang.String ruzhiShanggangResult;
	/**是否在职*/
	private java.lang.String chargeZaizhiResult;
	/**是否收款*/
	private java.lang.String chargeShoukuanResult;
	/**收款金额*/
	private java.lang.String chargeJine;
	/**收款时间*/
	private java.lang.String chargeDate;
	/**是否结算代理费*/
	private java.lang.String chargeDlfResult;
	/**代理费金额*/
	private java.lang.String chargeDailifei;
	
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
	 *@return: java.lang.String  流程实例ID
	 */
	@Column(name ="PROCESS_INSTANCE_ID",nullable=true,length=50)
	public java.lang.String getProcessInstanceId(){
		return this.processInstanceId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程实例ID
	 */
	public void setProcessInstanceId(java.lang.String processInstanceId){
		this.processInstanceId = processInstanceId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人ID
	 */
	@Column(name ="CREATE_USER_ID",nullable=true,length=100)
	public java.lang.String getCreateUserId(){
		return this.createUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人ID
	 */
	public void setCreateUserId(java.lang.String createUserId){
		this.createUserId = createUserId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	@Column(name ="CREATE_USER_NAME",nullable=true,length=100)
	public java.lang.String getCreateUserName(){
		return this.createUserName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateUserName(java.lang.String createUserName){
		this.createUserName = createUserName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  求职意向
	 */
	@Column(name ="QZJOB",nullable=true,length=200)
	public java.lang.String getQzjob(){
		return this.qzjob;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  求职意向
	 */
	public void setQzjob(java.lang.String qzjob){
		this.qzjob = qzjob;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="NAME",nullable=true,length=100)
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
	@Column(name ="SEX",nullable=true,length=50)
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
	@Column(name ="AGE",nullable=true,length=3)
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
	 *@return: java.lang.String  工作经验
	 */
	@Column(name ="GZJY",nullable=true,length=50)
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
	 *@return: java.lang.String  目前职位
	 */
	@Column(name ="MQJOB",nullable=true,length=100)
	public java.lang.String getMqjob(){
		return this.mqjob;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  目前职位
	 */
	public void setMqjob(java.lang.String mqjob){
		this.mqjob = mqjob;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邀约结果
	 */
	@Column(name ="INVITE_RESULT",nullable=true,length=50)
	public java.lang.String getInviteResult(){
		return this.inviteResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邀约结果
	 */
	public void setInviteResult(java.lang.String inviteResult){
		this.inviteResult = inviteResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邀约门店
	 */
	@Column(name ="INVITE_STORE",nullable=true,length=50)
	public java.lang.String getInviteStore(){
		return this.inviteStore;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邀约门店
	 */
	public void setInviteStore(java.lang.String inviteStore){
		this.inviteStore = inviteStore;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  预约面试时间
	 */
	@Column(name ="INVITE_DATE",nullable=true,length=50)
	public java.lang.String getInviteDate(){
		return this.inviteDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  预约面试时间
	 */
	public void setInviteDate(java.lang.String inviteDate){
		this.inviteDate = inviteDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邀约备注
	 */
	@Column(name ="INVITE_REMARKS",nullable=true,length=50)
	public java.lang.String getInviteRemarks(){
		return this.inviteRemarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邀约备注
	 */
	public void setInviteRemarks(java.lang.String inviteRemarks){
		this.inviteRemarks = inviteRemarks;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  企业名称
	 */
	@Column(name ="BUSINESS_NAME",nullable=true,length=50)
	public java.lang.String getBusinessName(){
		return this.businessName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  企业名称
	 */
	public void setBusinessName(java.lang.String businessName){
		this.businessName = businessName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位名称
	 */
	@Column(name ="POSITION_NAME",nullable=true,length=50)
	public java.lang.String getPositionName(){
		return this.positionName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位名称
	 */
	public void setPositionName(java.lang.String positionName){
		this.positionName = positionName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  面试结论
	 */
	@Column(name ="INTERVIEW_RESULT",nullable=true,length=50)
	public java.lang.String getInterviewResult(){
		return this.interviewResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  面试结论
	 */
	public void setInterviewResult(java.lang.String interviewResult){
		this.interviewResult = interviewResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  不通过原因
	 */
	@Column(name ="INTERVIEW_REASON",nullable=true,length=50)
	public java.lang.String getInterviewReason(){
		return this.interviewReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  不通过原因
	 */
	public void setInterviewReason(java.lang.String interviewReason){
		this.interviewReason = interviewReason;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  预约接送时间
	 */
	@Column(name ="INTERVIEW_PICK_DATE",nullable=true,length=50)
	public java.lang.String getInterviewPickDate(){
		return this.interviewPickDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  预约接送时间
	 */
	public void setInterviewPickDate(java.lang.String interviewPickDate){
		this.interviewPickDate = interviewPickDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核时间
	 */
	@Column(name ="EXAMINE_DATE",nullable=true,length=32)
	public java.lang.String getExamineDate(){
		return this.examineDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核时间
	 */
	public void setExamineDate(java.lang.String examineDate){
		this.examineDate = examineDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核结论
	 */
	@Column(name ="EXAMINE_RESULT",nullable=true,length=32)
	public java.lang.String getExamineResult(){
		return this.examineResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核结论
	 */
	public void setExamineResult(java.lang.String examineResult){
		this.examineResult = examineResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核备注
	 */
	@Column(name ="EXAMINE_REMARKS",nullable=true,length=32)
	public java.lang.String getExamineRemarks(){
		return this.examineRemarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核备注
	 */
	public void setExamineRemarks(java.lang.String examineRemarks){
		this.examineRemarks = examineRemarks;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  接送时间
	 */
	@Column(name ="PICK_DATE",nullable=true,length=32)
	public java.lang.String getPickDate(){
		return this.pickDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  接送时间
	 */
	public void setPickDate(java.lang.String pickDate){
		this.pickDate = pickDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  接送结论
	 */
	@Column(name ="PICK_RESULT",nullable=true,length=32)
	public java.lang.String getPickResult(){
		return this.pickResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  接送结论
	 */
	public void setPickResult(java.lang.String pickResult){
		this.pickResult = pickResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  体检结果
	 */
	@Column(name ="WORK_TIJIAN_RESULT",nullable=true,length=32)
	public java.lang.String getWorkTijianResult(){
		return this.workTijianResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  体检结果
	 */
	public void setWorkTijianResult(java.lang.String workTijianResult){
		this.workTijianResult = workTijianResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  复试结果
	 */
	@Column(name ="WORK_FUSHI_RESULT",nullable=true,length=32)
	public java.lang.String getWorkFushiResult(){
		return this.workFushiResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  复试结果
	 */
	public void setWorkFushiResult(java.lang.String workFushiResult){
		this.workFushiResult = workFushiResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否签订劳动合同
	 */
	@Column(name ="WORK_HETONG_RESULT",nullable=true,length=32)
	public java.lang.String getWorkHetongResult(){
		return this.workHetongResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否签订劳动合同
	 */
	public void setWorkHetongResult(java.lang.String workHetongResult){
		this.workHetongResult = workHetongResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  复试是否通过
	 */
	@Column(name ="RUZHI_FUSHI_RESULT",nullable=true,length=32)
	public java.lang.String getRuzhiFushiResult(){
		return this.ruzhiFushiResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  复试是否通过
	 */
	public void setRuzhiFushiResult(java.lang.String ruzhiFushiResult){
		this.ruzhiFushiResult = ruzhiFushiResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否签订劳动合同
	 */
	@Column(name ="RUZHI_HETONG_RESULT",nullable=true,length=32)
	public java.lang.String getRuzhiHetongResult(){
		return this.ruzhiHetongResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否签订劳动合同
	 */
	public void setRuzhiHetongResult(java.lang.String ruzhiHetongResult){
		this.ruzhiHetongResult = ruzhiHetongResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  体检结果
	 */
	@Column(name ="RUZHI_TIJIAN_RESULT",nullable=true,length=32)
	public java.lang.String getRuzhiTijianResult(){
		return this.ruzhiTijianResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  体检结果
	 */
	public void setRuzhiTijianResult(java.lang.String ruzhiTijianResult){
		this.ruzhiTijianResult = ruzhiTijianResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  培训结果
	 */
	@Column(name ="RUZHI_PEIXUN_RESULT",nullable=true,length=32)
	public java.lang.String getRuzhiPeixunResult(){
		return this.ruzhiPeixunResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  培训结果
	 */
	public void setRuzhiPeixunResult(java.lang.String ruzhiPeixunResult){
		this.ruzhiPeixunResult = ruzhiPeixunResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否住宿
	 */
	@Column(name ="RUZHI_ZHUSU_RESULT",nullable=true,length=32)
	public java.lang.String getRuzhiZhusuResult(){
		return this.ruzhiZhusuResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否住宿
	 */
	public void setRuzhiZhusuResult(java.lang.String ruzhiZhusuResult){
		this.ruzhiZhusuResult = ruzhiZhusuResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否上岗
	 */
	@Column(name ="RUZHI_SHANGGANG_RESULT",nullable=true,length=32)
	public java.lang.String getRuzhiShanggangResult(){
		return this.ruzhiShanggangResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否上岗
	 */
	public void setRuzhiShanggangResult(java.lang.String ruzhiShanggangResult){
		this.ruzhiShanggangResult = ruzhiShanggangResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否在职
	 */
	@Column(name ="CHARGE_ZAIZHI_RESULT",nullable=true,length=32)
	public java.lang.String getChargeZaizhiResult(){
		return this.chargeZaizhiResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否在职
	 */
	public void setChargeZaizhiResult(java.lang.String chargeZaizhiResult){
		this.chargeZaizhiResult = chargeZaizhiResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否收款
	 */
	@Column(name ="CHARGE_SHOUKUAN_RESULT",nullable=true,length=32)
	public java.lang.String getChargeShoukuanResult(){
		return this.chargeShoukuanResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否收款
	 */
	public void setChargeShoukuanResult(java.lang.String chargeShoukuanResult){
		this.chargeShoukuanResult = chargeShoukuanResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收款金额
	 */
	@Column(name ="CHARGE_JINE",nullable=true,length=32)
	public java.lang.String getChargeJine(){
		return this.chargeJine;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款金额
	 */
	public void setChargeJine(java.lang.String chargeJine){
		this.chargeJine = chargeJine;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收款时间
	 */
	@Column(name ="CHARGE_DATE",nullable=true,length=32)
	public java.lang.String getChargeDate(){
		return this.chargeDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款时间
	 */
	public void setChargeDate(java.lang.String chargeDate){
		this.chargeDate = chargeDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否结算代理费
	 */
	@Column(name ="CHARGE_DLF_RESULT",nullable=true,length=32)
	public java.lang.String getChargeDlfResult(){
		return this.chargeDlfResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否结算代理费
	 */
	public void setChargeDlfResult(java.lang.String chargeDlfResult){
		this.chargeDlfResult = chargeDlfResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代理费金额
	 */
	@Column(name ="CHARGE_DAILIFEI",nullable=true,length=32)
	public java.lang.String getChargeDailifei(){
		return this.chargeDailifei;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代理费金额
	 */
	public void setChargeDailifei(java.lang.String chargeDailifei){
		this.chargeDailifei = chargeDailifei;
	}
	
	@Transient
	public java.lang.String getTaskName() {
		return taskName;
	}

	public void setTaskName(java.lang.String taskName) {
		this.taskName = taskName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	@Transient
	public java.lang.String getMobile() {
		return mobile;
	}
	
	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}
	@Transient
	public java.lang.String getSfzh() {
		return sfzh;
	}

	public void setSfzh(java.lang.String sfzh) {
		this.sfzh = sfzh;
	}
	@Transient
	public java.lang.String getMdName() {
		return mdName;
	}

	public void setMdName(java.lang.String mdName) {
		this.mdName = mdName;
	}
	@Transient
	public java.lang.String getMdAddress() {
		return mdAddress;
	}

	public void setMdAddress(java.lang.String mdAddress) {
		this.mdAddress = mdAddress;
	}
	@Transient
	public java.lang.String getMdMobile() {
		return mdMobile;
	}

	public void setMdMobile(java.lang.String mdMobile) {
		this.mdMobile = mdMobile;
	}
	
}
