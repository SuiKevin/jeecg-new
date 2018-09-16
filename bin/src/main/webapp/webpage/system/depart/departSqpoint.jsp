<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>部门信息</title>
<t:base type="jquery,easyui,tools"></t:base>
<script type="text/javascript">
	$(function() {
		 
	});
</script>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:formvalid formid="formobj" layout="div" dialog="true" action="systemController.do?saveDepartPoint">
	<input id="id" name="id" type="hidden" value="${depart.id }">
	<input id="pid" name="TSPDepart.id" type="hidden" value="${depart.TSPDepart.id}">
	<fieldset class="step">
        <div class="form">
            <label class="Validform_label"> <t:mutiLang langKey="common.department.name"/>: </label>
            <input name="departname" class="inputxt" readonly="readonly" type="text" value="${depart.departname }"  datatype="s1-20">
            <span class="Validform_checktip"><t:mutiLang langKey="departmentname.rang1to20"/></span>
        </div>
        <div class="form">
            <label class="Validform_label">已经使用积分: </label>
            <input name="sqpointused" readonly="readonly" class="inputxt" value="${depart.sqpointused }">
        </div>     
        <div class="form">
            <label class="Validform_label">当前积分: </label>
            <input name="sqpoint" readonly="readonly" class="inputxt" value="${depart.sqpoint}">
        </div>
        
        <div class="form">
            <label class="Validform_label">调整类型: </label>
            <t:dictSelect field="operflag" defaultVal="addpoint" typeGroupCode="jifen"  title="调整类型" datatype="*"></t:dictSelect>
        </div>
        <div class="form">
            <label class="Validform_label">调整积分: </label>
            <input name="sqpointadd" class="inputxt" value="${depart.sqpointadd}" datatype="n1-4">
        </div>
	</fieldset>
</t:formvalid>
</body>
</html>
