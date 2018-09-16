<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>职位描述</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:datagrid  pagination="false"  name="jobdescriptionList" title=""  actionUrl="jobdescriptionController.do?datagrid&parmObj=${paramObj}" idField="id" checkbox="true" showRefresh="false"  fit="true"  queryMode="group" onLoadSuccess="initCheck">
   <t:dgCol title="职位ID"  hidden="true" field="jobid"  queryMode="group"  width="20"></t:dgCol>
   <t:dgCol title="职位名称"  field="jobdescname"  query="true"  queryMode="single"  width="200"></t:dgCol>
   <t:dgCol title="职位描述ID"  hidden="true" field="jobdesccode"  queryMode="group"  width="20"></t:dgCol>
</t:datagrid>
</body>
</html>
<script type="text/javascript">
function initCheck(data){
	debugger;
	var paramObj = '${paramObj}';
	paramObj = JSON.parse(paramObj);
	var ids = paramObj.ids;
	var idArr = ids.split(",");
	for(var i=0;i<idArr.length;i++){
		if(idArr[i]!=""){
			$("#roleList").datagrid("selectRecord",idArr[i]);
		}
	}
}
</script>