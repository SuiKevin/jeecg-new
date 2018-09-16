<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>招聘企业信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="qpZpcompanyController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${qpZpcompanyPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							公司名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="zpCompany" name="zpCompany" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公司名称</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							招聘岗位:
						</label>
					</td>
					<td class="value">
					     	 <input id="zpJob" name="zpJob" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">招聘岗位</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							招聘人数:
						</label>
					</td>
					<td class="value">
					     	 <input id="zpPersonnum" name="zpPersonnum" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">招聘人数</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							学历:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="edu" type="list"  typeGroupCode="edu"  defaultVal="${qpZpcompanyPage.edu}" hasLabel="false"  title="学历" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">学历</label>
						</td>
				</tr>
				
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							公司介绍:
						</label>
					</td>
					<td class="value" >
						  	 <textarea style="width:400px;height:150px" class="inputxt" rows="6" id="companyInfo" name="companyInfo"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公司介绍</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							职位描述:
						</label>
					</td>
					<td class="value" >
						  	 <textarea style="width:400px;height:180px;" class="inputxt" rows="6" id="jobInfo" name="jobInfo"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">职位描述</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							经验要求:
						</label>
					</td>
					<td class="value" >
						  	 <textarea style="width:400px;height:80px;" class="inputxt" rows="6" id="jingyan" name="jingyan"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">经验要求</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							地址:
						</label>
					</td>
					<td class="value" >
						  	 <textarea style="width:400px;height:80px;" class="inputxt" rows="6" id="address" name="address"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">地址</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							薪资待遇:
						</label>
					</td>
					<td class="value" >
						  	 <textarea style="width:400px;height:80px;" class="inputxt" rows="6" id="money" name="money"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">薪资待遇</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/qp/company/qpZpcompany.js"></script>		
