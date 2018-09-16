<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>上岗</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="/plug-in/bootstrap/css/buttons.css"></script>
  
  <style>
  	.div_bg_card{
	background:#ffffff;
	box-shadow:0 1px 8px 0 rgba(221,221,221,0.50);
	width:100%;
	min-height:40px;
	overflow: hidden;
	-webkit-user-select:text;
	}
  </style>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tOrderIngController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${tOrderIngPage.id }"/>
		<h2>求职者信息</h2>
		<div class="div_bg_card">
		<table style="width: 99%;" cellpadding="0" cellspacing="1" class="formtable">
		<tr style="height: 50px;">
						<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">
								姓名:
							</label>
						</td>
						<td class="value" style="width: 20%">
						    <label>${tOrderIngPage.name}</label>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</td>
						<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">
								性别:
							</label>
						</td>
						<td class="value" style="width: 20%";>
						     <label>${tOrderIngPage.sex}</label>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
						</td>
						<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">
								年龄:
							</label>
						</td>
						<td class="value" style="width: 20%";>
						    <label>${tOrderIngPage.age}</label>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">年龄</label>
						</td>
					</tr>
					<tr style="height: 50px;">
						<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">
								求职意向:
							</label>
						</td>
						<td class="value" style="width: 20%";>
						 	<label>${tOrderIngPage.qzjob}</label>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">求职意向</label>
						</td>
						<td class="value" align="right" style="width: 13%";>
							<label class="Validform_label">
								工作经验:
							</label>
						</td>
						<td class="value" style="width: 20%";>
						     <label>${tOrderIngPage.gzjy}</label>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">工作经验</label>
						</td>
						<td class="value" align="right" style="width: 13%";>
							<label class="Validform_label">
								目前职位:
							</label>
						</td>
						<td class="value" style="width: 20%";>
						     <label>${tOrderIngPage.mqjob}</label>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">目前职位</label>
						</td>
					</tr>
					<tr style="height: 50px;">
						<td class="value" align="right" style="width: 13%";>
							<label class="Validform_label">
								简历ID:
							</label>
						</td>
						<td class="value" style="width: 20%";>
						    <label>${tOrderIngPage.resumeId}</label>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">简历ID</label>
						</td>
						<td class="value" align="right" style="width: 13%";>
							<label class="Validform_label">
								流程实例ID:
							</label>
						</td>
						<td class="value" style="width: 20%";>
							<label>${tOrderIngPage.processInstanceId}</label>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">流程实例ID</label>
						</td>
						<td class="value" align="right" style="width: 13%";>
							<label class="Validform_label">
								创建日期:
							</label>
						</td>
						<td class="value" style="width: 20%";>
							<label>${tOrderIngPage.createDate}</label>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建日期</label>
						</td>
					</tr>
				</table>
				</div>
				<br/>
				<hr>
				<h2>邀约结果</h2>
				<div class="div_bg_card">
				<table style="width: 99%;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">
								邀约结果:
							</label>
						</td>
						<td class="value" style="width: 20%">
							<label class="Validform_label">${tOrderIngPage.inviteResult}</label>
						</td>
						<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">
								邀约门店:
							</label>
						</td>
						<td class="value" style="width: 20%"><label style="display: none;">${tOrderIngPage.inviteStore}</label><label>${tOrderIngPage.mdName}</label></td>
						<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">预约面试时间:</label>
						</td>
						<td class="value" style="width: 20%"><label>${tOrderIngPage.inviteDate}</label></td>
					</tr>
					<tr>
						
						<td class="value" align="right" align="right" align="right" style="width: 13%">
							<label class="Validform_label">
								企业名称:
							</label>
						</td>
						<td class="value" style="width: 20%"><label>${tOrderIngPage.businessName}</label></td>
						<td class="value" align="right" align="right" style="width: 13%">
							<label class="Validform_label">
								职位名称:
							</label>
						</td>
						<td class="value" style="width: 20%"><label>${tOrderIngPage.positionName}</label></td>
						<td class="value" align="right" align="right" style="width: 13%">
							<label class="Validform_label">邀约备注:</label>
						</td>
						<td class="value" style="width: 20%"><label>${tOrderIngPage.inviteRemarks}</label></td>
					</tr>

			</table>
				</div>
				<br/>
			<hr/>
			面试结果
			<div class="div_bg_card">
			<table style="width: 99%;" cellpadding="0" cellspacing="1" class="formtable">
					<tr style="height: 30px;">
						<td class="value" align="right" style="width: 13%" >
							<label class="Validform_label">
								面试结论:
							</label>
						</td>
						<td class="value" style="width: 20%">
							<t:dictSelect field="interviewResult" type="list" readonly="readonly"  typeGroupCode="msjg"   defaultVal="${tOrderIngPage.interviewResult}" hasLabel="false"  title="面试结论" ></t:dictSelect></td>
						<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">
								不通过原因:
							</label>
						</td>
						<td class="value" style="width: 20%">
							<t:dictSelect field="interviewReason" type="list" readonly="readonly"  typeGroupCode="msbtgyy"   defaultVal="${tOrderIngPage.interviewReason}" hasLabel="false"  title="不通过原因" ></t:dictSelect>  
						</td>
						<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">
								预约接送时间:
							</label>
						</td>
						<td class="value" style="width: 20%"><label>${tOrderIngPage.interviewPickDate}</label></td>
					</tr>
			</table>
			</div>
			<br/>
			<hr/>
			审核结果
			<div class="div_bg_card">
			<table style="width: 99%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
						<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">
								审核结论:
							</label>
						</td>
						<td class="value" style="width: 20%">
							<t:dictSelect field="examineResult" type="list"  readonly="readonly"  typeGroupCode="msjg"   defaultVal="${tOrderIngPage.examineResult}" hasLabel="false"  title="审核结论" ></t:dictSelect>
						</td>
						<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">
								审核时间:
							</label>
						</td>
						<td class="value" style="width: 20%"><label>${tOrderIngPage.examineDate}</label></td>
						<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">
								审核备注:
							</label>
						</td>
						<td class="value" style="width: 20%"><label>${tOrderIngPage.examineRemarks}</label></td>
					</tr>
			</table>
			</div>
			<br/>
			<hr/>
			接送结果
			<div class="div_bg_card">
			<table style="width: 99%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">
								接送结果:
							</label>
						</td>
						<td class="value" style="width: 20%">
							<t:dictSelect field="pickResult" type="list"  readonly="readonly"  typeGroupCode="jsjg"   defaultVal="${tOrderIngPage.pickResult}" hasLabel="false"  title="接送结论" ></t:dictSelect>
						</td>
						<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">
								接送时间:
							</label>
						</td>
						<td class="value" style="width: 20%"><label>${tOrderIngPage.pickDate}</label></td>
						<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value" style="width: 20%"><label></label></td>
				</tr>
			</table>
			<br/>
			<hr/>
			上岗结果
			<div class="div_bg_card">
			<table style="width: 99%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td class="value" align="right" style="width: 10%">
							<label class="Validform_label">
								复试结果:
							</label>
						</td>
						<td class="value" style="width: 20%">
							<t:dictSelect field="workFushiResult" type="list"  readonly="readonly"  typeGroupCode="fsjg"   defaultVal="${tOrderIngPage.workFushiResult}" hasLabel="false"  title="复试结果" ></t:dictSelect>     
						</td>
						<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">
								是否签订劳动合同:
							</label>
						</td>
						<td class="value" style="width: 20%">
							<t:dictSelect field="workHetongResult" type="list"  readonly="readonly"  typeGroupCode="sftdht"   defaultVal="${tOrderIngPage.workHetongResult}" hasLabel="false"  title="是否签订劳动合同" ></t:dictSelect>     
						</td>
						<td class="value" align="right" style="width: 10%">
							<label class="Validform_label">
								体检结果:
							</label>
						</td>
						<td class="value" style="width: 20%">
							<t:dictSelect field="workTijianResult" type="list"  readonly="readonly"  typeGroupCode="tjjg"   defaultVal="${tOrderIngPage.workTijianResult}" hasLabel="false"  title="体检结果" ></t:dictSelect>
						</td>
					</tr>
			</table>
			</div>
			<br/>
			<hr>
			入职结果
			<div class="div_bg_card">
			<table style="width: 99%;" cellpadding="0" cellspacing="1" class="formtable">
									<tr>
						<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">
								复试是否通过:
							</label>
						</td>
						<td class="value" style="width: 20%">
								<t:dictSelect field="ruzhiFushiResult" type="list"  readonly="readonly"  typeGroupCode="fsjg"   defaultVal="${tOrderIngPage.ruzhiFushiResult}" hasLabel="false"  title="复试是否通过" ></t:dictSelect>     
						</td>
						<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">
								是否签订劳动合同:
							</label>
						</td>
						<td class="value" style="width: 20%">
							<t:dictSelect field="ruzhiHetongResult" type="list"  readonly="readonly"  typeGroupCode="sftdht"   defaultVal="${tOrderIngPage.ruzhiHetongResult}" hasLabel="false"  title="是否签订劳动合同" ></t:dictSelect>     
						<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">
								体检结果:
							</label>
						</td>
						<td class="value" style="width: 20%">
							<t:dictSelect field="ruzhiTijianResult" type="list"  readonly="readonly"  typeGroupCode="tjjg"   defaultVal="${tOrderIngPage.ruzhiTijianResult}" hasLabel="false"  title="体检结果" ></t:dictSelect>     
						</td>
					</tr>
					<tr>

						<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">
								培训结果:
							</label>
						</td>
						<td class="value">
							<t:dictSelect field="ruzhiPeixunResult" type="list"  readonly="readonly"  typeGroupCode="yesorno"   defaultVal="${tOrderIngPage.ruzhiPeixunResult}" hasLabel="false"  title="培训结果" ></t:dictSelect>     
						</td>
						<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">
								是否住宿:
							</label>
						</td>
						<td class="value" align="right" style="width: 13%">
							<t:dictSelect field="ruzhiZhusuResult" type="list"  readonly="readonly"  typeGroupCode="yesorno"   defaultVal="${tOrderIngPage.ruzhiZhusuResult}" hasLabel="false"  title="是否住宿" ></t:dictSelect>     
						</td>
						<td class="value" align="right" style="width: 13%">
							<label class="Validform_label">
								是否上岗:
							</label>
						</td>
						<td class="value">
							<t:dictSelect field="ruzhiShanggangResult" type="list"  readonly="readonly"  typeGroupCode="yesorno"   defaultVal="${tOrderIngPage.ruzhiShanggangResult}" hasLabel="false"  title="是否上岗" ></t:dictSelect>     
						</td>
					</tr>
			</table>
			</div>
			<br/>
			<hr/>
			收款结果
			<table style="width: 99%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
						<td align="right">
							<label class="Validform_label">
								是否在职:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="chargeZaizhiResult" type="radio"  datatype="*"  typeGroupCode="yesorno"   defaultVal="${tOrderIngPage.chargeZaizhiResult}" hasLabel="false"  title="是否在职" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否在职</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								是否收款:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="chargeShoukuanResult" type="radio"  datatype="*"  typeGroupCode="yesorno"   defaultVal="${tOrderIngPage.chargeShoukuanResult}" hasLabel="false"  title="是否收款" ></t:dictSelect>     
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
						     	 <input id="chargeJine" name="chargeJine" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="checked"  value='${tOrderIngPage.chargeJine}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收款金额</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								收款时间:
							</label>
						</td>
						<td class="value">
									  <input id="chargeDate" name="chargeDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  datatype="*"  ignore="checked" value='<fmt:formatDate value='${tOrderIngPage.chargeDate}' type="date" pattern="yyyy-MM-dd"/>'/>
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
									<t:dictSelect field="chargeDlfResult" type="radio"  datatype="*"  typeGroupCode="yesorno"   defaultVal="${tOrderIngPage.chargeDlfResult}" hasLabel="false"  title="是否结算代理费" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否结算代理费</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								代理费金额:
							</label>
						</td>
						<td class="value">
						     	 <input id="chargeDailifei" name="chargeDailifei" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="checked"  value='${tOrderIngPage.chargeDailifei}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">代理费金额</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								收款备注:
							</label>
						</td>
						<td class="value"  colspan="3" >
						  	 	<textarea id="examineRemarks" style="width:99%;height:80px" class="inputxt" rows="6" name="examineRemarks"  datatype="*"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收款备注</label>
						</td>
					</tr>
			</table>
			<br/>
			<div style="text-align:right;margin-right: 5%;"><input class="btn" type="submit" value="提交" style="height:30px;width:100px !important;border-radius:5px"></div>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/qpwl/order2/tOrderIng.js"></script>		
