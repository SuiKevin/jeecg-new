<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>在途工单</title>
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
							<label>${tOrderIngPage.inviteResult}</label>
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
			<table style="width: 99%;" cellpadding="0" cellspacing="1" class="formtable">
			<tr>
						<td align="right">
							<label class="Validform_label">
								面试结论:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="interviewResult" type="list"  datatype="*"  typeGroupCode="msjg"   defaultVal="${tOrderIngPage.interviewResult}" hasLabel="false"  title="面试结论" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">面试结论</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								不通过原因:
							</label>
						</td>
						<td class="value">
							<t:dictSelect field="interviewReason" type="list"  datatype="*"  typeGroupCode="msbtgyy"   defaultVal="${tOrderIngPage.interviewReason}" hasLabel="false"  title="不通过原因" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">不通过原因</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								预约接送时间:
							</label>
						</td>
						<td class="value">
									  <input id="interviewPickDate" name="interviewPickDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  datatype="*"  ignore="checked" value='${tOrderIngPage.interviewPickDate}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">预约接送时间</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
				
					<tr>
						<td align="right">
							<label class="Validform_label">
								面试备注:
							</label>
						</td>
						<td class="value"  colspan="3" >
						  	<textarea  style="width:99%;height: 100px;" class="inputxt" rows="6"    ignore="ignore" ></textarea>
						</td>
					</tr>
			</table>
			<br/>
			<div style="text-align:right;margin-right: 5%;"><input class="btn" type="submit" value="提交" style="height:30px;width:100px !important;border-radius:5px"></div>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/qpwl/order2/tOrderIng.js"></script>		
