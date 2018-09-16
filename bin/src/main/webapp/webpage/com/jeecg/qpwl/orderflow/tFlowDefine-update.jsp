<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>流程定义表</title>
    <style>
  .ui-button {
  	  display: inline-block;
	  padding: 2px 2px;
	  margin-bottom: 0;
	  font-size: 8px;
	  font-weight: normal;
	  line-height: 1.42857143;
	  text-align: center;
	  white-space: nowrap;
	  vertical-align: middle;
	  -ms-touch-action: manipulation;
      touch-action: manipulation;
	  cursor: pointer;
	  -webkit-user-select: none;
      -moz-user-select: none;
      -ms-user-select: none;
      user-select: none;
	  background-image: none;
	  border: 1px solid transparent;
	  border-radius: 4px;
  }
  </style>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
  });
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="tFlowDefineController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${tFlowDefinePage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">流程编码:</label>
			</td>
			<td class="value">
		     	 <input id="flowCode" name="flowCode" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked"  value='${tFlowDefinePage.flowCode}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">流程编码</label>
			</td>
			<td align="right">
				<label class="Validform_label">流程名称:</label>
			</td>
			<td class="value">
		     	 <input id="flowName" name="flowName" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked"  value='${tFlowDefinePage.flowName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">流程名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">创建日期:</label>
			</td>
			<td class="value">
					  <input id="createDate" name="createDate" type="text" style="width: 150px"   ignore="ignore"  value='<fmt:formatDate value='${tFlowDefinePage.createDate}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">创建日期</label>
			</td>
			<td align="right">
				<label class="Validform_label">流程状态:</label>
			</td>
			<td class="value">
					<t:dictSelect field="flowState" type="list"   typeGroupCode="flow_state"  defaultVal="${tFlowDefinePage.flowState}" hasLabel="false"  title="流程状态"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">流程状态</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">版本号:</label>
			</td>
			<td class="value">
		     	 <input id="version" name="version" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tFlowDefinePage.version}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">版本号</label>
			</td>
		</tr>
	
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="tFlowDefineController.do?tFlowTaskList&id=${tFlowDefinePage.id}" icon="icon-search" title="环节管理" id="tFlowTask"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_tFlowTask_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="tFlowTaskList[#index#].taskCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">环节编码</label>
				  </td>
				  <td align="left">
					  		<input name="tFlowTaskList[#index#].taskName" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">环节名称</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="tFlowTaskList[#index#].taskType" type="list"   typeGroupCode="task_type"  defaultVal="" hasLabel="false"  title="环节类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">环节类型</label>
				  </td>
				  <td align="left">
					  		<input name="tFlowTaskList[#index#].nextTask" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">下一环节</label>
				  </td>
				  <td align="left">
					  		<input name="tFlowTaskList[#index#].taskIndex" maxlength="50" type="text" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">环节顺序</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="tFlowTaskList[#index#].partyType" type="list"   typeGroupCode="party_type"  defaultVal="" hasLabel="false"  title="派单类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">派单类型</label>
				  </td>
				  <td align="left">
					       	<input name="tFlowTaskList[#index#].partyIds" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">执行人</label>
				  </td>
				  <td align="left">
					       	<input name="tFlowTaskList[#index#].taskForm" maxlength="200" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">表单</label>
				  </td>
				  <td align="left">
					       	<input name="tFlowTaskList[#index#].taskClasspath" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">自动环节对应的服务</label>
				  </td>
				  <td align="left">
					       	<input name="tFlowTaskList[#index#].taskExpression" maxlength="2000" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">网关表达式</label>
				  </td>
				  <td align="left">
					       	<input name="tFlowTaskList[#index#].params" maxlength="2000" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">参数</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/jeecg/qpwl/orderflow/tFlowDefine.js"></script>	
