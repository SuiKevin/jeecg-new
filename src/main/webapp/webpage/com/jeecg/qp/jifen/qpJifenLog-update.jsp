<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>积分日志管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="qpJifenLogController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${qpJifenLogPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								操作人:
							</label>
						</td>
						<td class="value">
						     	 <input id="operUser" name="operUser" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${qpJifenLogPage.operUser}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">操作人</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								操作日期:
							</label>
						</td>
						<td class="value">
									   <input id="operDate" name="operDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  value='<fmt:formatDate value='${qpJifenLogPage.operDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">操作日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								操作事件:
							</label>
						</td>
						<td class="value">
						     	 <input id="operEvent" name="operEvent" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${qpJifenLogPage.operEvent}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">操作事件</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								被操作用户:
							</label>
						</td>
						<td class="value">
						     	 <input id="beioperUser" name="beioperUser" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${qpJifenLogPage.beioperUser}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">被操作用户</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								被操作积分:
							</label>
						</td>
						<td class="value">
						     	 <input id="beioperJifen" name="beioperJifen" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${qpJifenLogPage.beioperJifen}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">被操作积分</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/qp/jifen/qpJifenLog.js"></script>		
