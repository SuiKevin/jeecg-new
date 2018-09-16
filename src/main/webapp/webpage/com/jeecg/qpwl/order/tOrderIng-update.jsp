<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>在途工单</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tOrderIngController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${tOrderIngPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								简历ID:
							</label>
						</td>
						<td class="value">
						     	 <input id="resumeId" name="resumeId" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="ignore"  value='${tOrderIngPage.resumeId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">简历ID</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								流程实例ID:
							</label>
						</td>
						<td class="value">
						     	 <input id="processInstanceId" name="processInstanceId" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="ignore"  value='${tOrderIngPage.processInstanceId}'/>
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
									  <input id="createDate" name="createDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  datatype="*"  ignore="ignore" value='<fmt:formatDate value='${tOrderIngPage.createDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建日期</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								创建人ID:
							</label>
						</td>
						<td class="value">
						     	 <input id="createUserId" name="createUserId" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="ignore"  value='${tOrderIngPage.createUserId}'/>
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
						     	 <input id="createUserName" name="createUserName" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="ignore"  value='${tOrderIngPage.createUserName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								求职意向:
							</label>
						</td>
						<td class="value">
									  <input id="qzjob" name="qzjob" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  datatype="*"  ignore="ignore" value='<fmt:formatDate value='${tOrderIngPage.qzjob}' type="date" pattern="yyyy-MM-dd"/>'/>
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
						     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="ignore"  value='${tOrderIngPage.name}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								性别:
							</label>
						</td>
						<td class="value">
						     	 <input id="sex" name="sex" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="ignore"  value='${tOrderIngPage.sex}'/>
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
						     	 <input id="age" name="age" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="ignore"  value='${tOrderIngPage.age}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">年龄</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								工作经验:
							</label>
						</td>
						<td class="value">
						     	 <input id="gzjy" name="gzjy" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="ignore"  value='${tOrderIngPage.gzjy}'/>
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
						     	 <input id="mqjob" name="mqjob" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="ignore"  value='${tOrderIngPage.mqjob}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">目前职位</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								邀约结果:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="inviteResult" type="list"  datatype="*"  typeGroupCode="yyjg"   defaultVal="${tOrderIngPage.inviteResult}" hasLabel="false"  title="邀约结果" ></t:dictSelect>     
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
						     	 <input id="inviteStore" name="inviteStore" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="ignore"  value='${tOrderIngPage.inviteStore}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">邀约门店</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								预约面试时间:
							</label>
						</td>
						<td class="value">
									   <input id="inviteDate" name="inviteDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  datatype="*"  ignore="ignore"  value='<fmt:formatDate value='${tOrderIngPage.inviteDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">预约面试时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								企业名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="businessName" name="businessName" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="ignore"  value='${tOrderIngPage.businessName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">企业名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								职位名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="positionName" name="positionName" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="ignore"  value='${tOrderIngPage.positionName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">职位名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								面试结论:
							</label>
						</td>
						<td class="value">
						     	 <input id="interviewResult" name="interviewResult" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked"  value='${tOrderIngPage.interviewResult}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">面试结论</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								不通过原因:
							</label>
						</td>
						<td class="value">
						     	 <input id="interviewReason" name="interviewReason" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked"  value='${tOrderIngPage.interviewReason}'/>
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
						     	 <input id="interviewPickDate" name="interviewPickDate" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked"  value='${tOrderIngPage.interviewPickDate}'/>
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
								邀约备注:
							</label>
						</td>
						<td class="value"  colspan="3" >
						  	 	<textarea id="inviteRemarks" style="width:600px;" class="inputxt" rows="6" name="inviteRemarks"  datatype="*"  ignore="ignore" >${tOrderIngPage.inviteRemarks}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">邀约备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/qpwl/order2/tOrderIng.js"></script>		
