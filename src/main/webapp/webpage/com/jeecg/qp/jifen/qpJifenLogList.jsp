<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="qpJifenLogList" checkbox="false" pagination="true" fitColumns="true" title="积分日志管理" actionUrl="qpJifenLogController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作人"  field="operUser"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作日期"  field="operDate"  formatter="yyyy-MM-dd hh:mm:ss"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作事件"  field="operEvent"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="被操作用户"  field="beioperUser"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作积分"  field="beioperJifen"  queryMode="single"  width="120"></t:dgCol>
   <t:dgToolBar title="查看" icon="icon-search" url="qpJifenLogController.do?goUpdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/qp/jifen/qpJifenLogList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'qpJifenLogController.do?upload', "qpJifenLogList");
}

//导出
function ExportXls() {
	JeecgExcelExport("qpJifenLogController.do?exportXls","qpJifenLogList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("qpJifenLogController.do?exportXlsByT","qpJifenLogList");
}

 </script>