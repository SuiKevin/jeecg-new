<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>历史工单</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tOrderHisController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${tOrderHisPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							简历ID:
						</label>
					</td>
					<td class="value">
					     	 <input id="resumeId" name="resumeId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">简历ID</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							流程实例ID:
						</label>
					</td>
					<td class="value">
					     	 <input id="processInstanceId" name="processInstanceId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">流程实例ID</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							创建日期:
						</label>
					</td>
					<td class="value">
							   <input id="createDate" name="createDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建日期</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							创建人ID:
						</label>
					</td>
					<td class="value">
					     	 <input id="createUserId" name="createUserId" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人ID</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							创建人名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="createUserName" name="createUserName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							求职意向:
						</label>
					</td>
					<td class="value">
					     	 <input id="qzjob" name="qzjob" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">求职意向</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td class="value">
					     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							性别:
						</label>
					</td>
					<td class="value">
					     	 <input id="sex" name="sex" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							年龄:
						</label>
					</td>
					<td class="value">
					     	 <input id="age" name="age" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">年龄</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							工作经验:
						</label>
					</td>
					<td class="value">
					     	 <input id="gzjy" name="gzjy" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">工作经验</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							目前职位:
						</label>
					</td>
					<td class="value">
					     	 <input id="mqjob" name="mqjob" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">目前职位</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							邀约结果:
						</label>
					</td>
					<td class="value">
					     	 <input id="inviteResult" name="inviteResult" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">邀约结果</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							邀约门店:
						</label>
					</td>
					<td class="value">
					     	 <input id="inviteStore" name="inviteStore" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">邀约门店</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							预约面试时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="inviteDate" name="inviteDate" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">预约面试时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							邀约备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="inviteRemarks" name="inviteRemarks" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">邀约备注</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							企业名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="businessName" name="businessName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">企业名称</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							职位名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="positionName" name="positionName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">职位名称</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							面试结论:
						</label>
					</td>
					<td class="value">
					     	 <input id="interviewResult" name="interviewResult" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">面试结论</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							不通过原因:
						</label>
					</td>
					<td class="value">
					     	 <input id="interviewReason" name="interviewReason" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">不通过原因</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							预约接送时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="interviewPickDate" name="interviewPickDate" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">预约接送时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							审核时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="examineDate" name="examineDate" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">审核时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							审核结论:
						</label>
					</td>
					<td class="value">
					     	 <input id="examineResult" name="examineResult" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">审核结论</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							审核备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="examineRemarks" name="examineRemarks" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">审核备注</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							接送时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="pickDate" name="pickDate" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">接送时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							接送结论:
						</label>
					</td>
					<td class="value">
					     	 <input id="pickResult" name="pickResult" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">接送结论</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							体检结果:
						</label>
					</td>
					<td class="value">
					     	 <input id="workTijianResult" name="workTijianResult" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">体检结果</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							复试结果:
						</label>
					</td>
					<td class="value">
					     	 <input id="workFushiResult" name="workFushiResult" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">复试结果</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							是否签订劳动合同:
						</label>
					</td>
					<td class="value">
					     	 <input id="workHetongResult" name="workHetongResult" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否签订劳动合同</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							复试是否通过:
						</label>
					</td>
					<td class="value">
					     	 <input id="ruzhiFushiResult" name="ruzhiFushiResult" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">复试是否通过</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							是否签订劳动合同:
						</label>
					</td>
					<td class="value">
					     	 <input id="ruzhiHetongResult" name="ruzhiHetongResult" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否签订劳动合同</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							体检结果:
						</label>
					</td>
					<td class="value">
					     	 <input id="ruzhiTijianResult" name="ruzhiTijianResult" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">体检结果</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							培训结果:
						</label>
					</td>
					<td class="value">
					     	 <input id="ruzhiPeixunResult" name="ruzhiPeixunResult" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">培训结果</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否住宿:
						</label>
					</td>
					<td class="value">
					     	 <input id="ruzhiZhusuResult" name="ruzhiZhusuResult" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否住宿</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							是否上岗:
						</label>
					</td>
					<td class="value">
					     	 <input id="ruzhiShanggangResult" name="ruzhiShanggangResult" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否上岗</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否在职:
						</label>
					</td>
					<td class="value">
					     	 <input id="chargeZaizhiResult" name="chargeZaizhiResult" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否在职</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							是否收款:
						</label>
					</td>
					<td class="value">
					     	 <input id="chargeShoukuanResult" name="chargeShoukuanResult" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否收款</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							收款金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="chargeJine" name="chargeJine" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收款金额</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							收款时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="chargeDate" name="chargeDate" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收款时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否结算代理费:
						</label>
					</td>
					<td class="value">
					     	 <input id="chargeDlfResult" name="chargeDlfResult" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否结算代理费</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							代理费金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="chargeDailifei" name="chargeDailifei" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">代理费金额</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							当前环节:
						</label>
					</td>
					<td class="value">
					     	 <input id="flowHj" name="flowHj" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">当前环节</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/qpwl/order/tOrderHis.js"></script>		
