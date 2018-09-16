<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>积分管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  function update(){
	  alert(1);
  }
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="qpJifenController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${qpJifenPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								授权积分:
							</label>
						</td>
						<td class="value">
						     	 <input id="sqPoint" name="sqPoint" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${qpJifenPage.sqPoint}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">授权积分</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								已用积分:
							</label>
						</td>
						<td class="value">
						     	 <input id="sqPointUsed" name="sqPointUsed" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${qpJifenPage.sqPointUsed}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">已用积分</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								每日限制用量:
							</label>
						</td>
						<td class="value">
						    <input id="pointDayLimit" name="pointDayLimit" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${qpJifenPage.pointDayLimit}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">每日限制用量</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								当日用量:
							</label>
						</td>
						<td class="value">
						    <input id="pointDayUsed" readonly="readonly"  name="pointDayUsed" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${qpJifenPage.pointDayUsed}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">当日用量</label>
						</td>
					</tr>
					
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/qp/jifen/qpJifen.js"></script>		
