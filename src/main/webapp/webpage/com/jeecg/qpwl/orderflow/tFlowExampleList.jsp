<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tFlowExampleList" checkbox="true" fitColumns="true" title="在途工单" actionUrl="tFlowExampleController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程实例ID"  field="instanceId"  query="true"  queryMode="single"  width="140"></t:dgCol>
   <t:dgCol title="流程ID"  field="flowId"  queryMode="single"  width="40"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  query="true"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="当前环节编码"  field="currectTask"  hidden="true"  queryMode="single"  width="60"></t:dgCol>
   <t:dgCol title="执行者类型"  field="partyType"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="执行者"  field="partyId"   query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="参数"  field="instanceParams"  queryMode="single"  width="60"></t:dgCol>
   <t:dgCol title="当前环节参数"  field="taskParams"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="当前环节名称"  field="currentTaskName"  query="true"  queryMode="single"  width="40"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tFlowExampleController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o" urlStyle="background-color: red;" />
   <t:dgFunOpt funname="delCgForm(id,instanceId)" title="完成任务" urlclass="ace_button" urlfont="fa-check" urlStyle="background-color: #00B2EE;"></t:dgFunOpt>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="tFlowExampleController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tFlowExampleController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/qpwl/orderflow/tFlowExampleList.js"></script>		
 <script type="text/javascript">
function delCgForm(myID,myIns){//测试
	createdialog('提示', '该操作导致工单直接跳转到下一流程,请确实人否这样做', "tFlowExampleController.do?doComplete&id="+myID+"&instanceId="+myIns,"完成任务");
}
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tFlowExampleController.do?upload', "tFlowExampleList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tFlowExampleController.do?exportXls","tFlowExampleList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tFlowExampleController.do?exportXlsByT","tFlowExampleList");
}
 </script>