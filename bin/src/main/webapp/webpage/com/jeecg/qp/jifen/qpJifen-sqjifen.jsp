<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>授权积分管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
 
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="qpJifenController.do?addjifen" >
					<input id="id" name="id" type="hidden" value="${qpJifenPage.id }"/>
		            <table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					
					<tr>
						<td align="right">
							<label class="Validform_label">
								账户已用积分:
							</label>
						</td>
						<td class="value">
						    <input id="sqPointUsed" readonly="readonly" name="sqPointUsed" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${qpJifenPage.sqPointUsed}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">已用积分</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								当前可用积分:
							</label>
						</td>
						<td class="value">
						    <input id="sqPoint" readonly="readonly" name="sqPoint" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${qpJifenPage.sqPoint}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">授权积分</label>
						</td>
					</tr>
					
					
					<tr>
						<td align="right">
							<label class="Validform_label">积分调整类型: </label>
						</td>
						<td class="value">
						    <t:dictSelect field="operflag" defaultVal="addpoint" typeGroupCode="jifen"  title="调整类型" datatype="*"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">请选择</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								调整积分数量:
							</label>
						</td>
						<td class="value">
						    <input id="addpoint" name="addpoint" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='0'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">请输入数字</label>
						</td>
					</tr>
				 
				
			</table>
		</t:formvalid>
		  <table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				 
					<tr>
					<td align="right">
						 规则说明：
					</td>
					<td class="value">
					             此功能为系统管理员功能，只有财务人员才可以操作授权积分，为付费用户授权积分。
					</td>
				</tr>
				
			</table>
 </body>
  <script src = "webpage/com/jeecg/qp/jifen/qpJifen.js"></script>		
