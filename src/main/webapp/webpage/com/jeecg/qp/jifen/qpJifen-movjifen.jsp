<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>转移积分管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
 
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="qpJifenController.do?movjifen" >
			  <input id="id" name="id" type="hidden" value="${qpJifenPage.id }"/>
		      <table style="width: 400px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
					    <td align="right">
							<label class="Validform_label">
								我的积分:
							</label>
						</td>
						<td class="value">
						    <input id="mypoint" name="mypoint" readonly="readonly" type="text" style="width: 120px" class="inputxt"  value="${mypoint}" />
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								转移积分:
							</label>
						</td>
						<td class="value">
						    <input id="addpoint" name="addpoint" type="text" style="width: 120px" class="inputxt"  datatype="n"  ignore="ignore"  value='0'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">请输入数字</label>
						</td>
					</tr>		
					<tr>
						<td align="right">
							 积分规则：
						</td>
						<td class="value">
						           当A账户增加积分时，你的账户会自动扣除积分
						</td>
					</tr>		
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/qp/jifen/qpJifen.js"></script>		
