<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>区县选择</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:datagrid  pagination="false"  name="townList" title=""  actionUrl="townController.do?datagrid&parmObj=${paramObj}" idField="townid" checkbox="true" showRefresh="false"  fit="true"  queryMode="group" onLoadSuccess="initCheck">
   <t:dgCol title="城市ID"  hidden="true" field="townid"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="城市名称"  field="townname"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="城市编码" hidden="true" field="citycode"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="省份ID"  hidden="true" field="provinceid"  queryMode="group"  width="120"></t:dgCol>
</t:datagrid>
</body>
</html>
<script type="text/javascript">
function initCheck(data){
	// debugger;
    var paramObj = unescape('${paramObj}');
	paramObj = JSON.parse(paramObj);
	var ids = paramObj.ids;
	var idArr = ids.split(",");
	for(var i=0;i<idArr.length;i++){
		if(idArr[i]!=""){
			$("#townList").datagrid("selectRecord",idArr[i]);
		}
	}
}
</script>