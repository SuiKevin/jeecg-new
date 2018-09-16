<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tFlowDefineList" checkbox="true" fitColumns="true" title="流程定义表" actionUrl="tFlowDefineController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="20"></t:dgCol>
   <t:dgCol title="流程编码"  field="flowCode"  query="true"  queryMode="single"  width="60"></t:dgCol>
   <t:dgCol title="流程名称"  field="flowName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="40"></t:dgCol>
   <t:dgCol title="流程状态"  field="flowState"  query="true"  queryMode="single"  dictionary="flow_state"  width="40"></t:dgCol>
   <t:dgCol title="版本号"  field="version"  queryMode="single"  width="40"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="起流程(空跑)"  message="确定起流程吗" url="tFlowDefineController.do?doStartFlow&id={id}&flowCode={flowCode}"  urlclass="ace_button" urlfont="fa-bullseye" urlStyle="background-color:#00B2EE;"/>
   <t:dgDelOpt title="起流程(挂工单)"  message="确定起流程吗" url="tFlowDefineController.do?doStartFlowParam&id={id}&flowCode={flowCode}"  urlclass="ace_button" urlfont="fa-bullseye" urlStyle="background-color:#00CD00;"/>
   <t:dgToolBar title="录入" icon="icon-add" url="tFlowDefineController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tFlowDefineController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="tFlowDefineController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tFlowDefineController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/qpwl/orderflow/tFlowDefineList.js"></script>
 <script type="text/javascript">
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tFlowDefineController.do?upload', "tFlowDefineList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tFlowDefineController.do?exportXls","tFlowDefineList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tFlowDefineController.do?exportXlsByT","tFlowDefineList");
}
 </script>