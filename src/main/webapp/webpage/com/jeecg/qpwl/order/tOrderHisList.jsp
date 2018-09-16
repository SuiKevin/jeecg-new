<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tOrderHisList" checkbox="true" pagination="true" fitColumns="true" title="历史工单" actionUrl="tOrderHisController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="简历ID"  field="resumeId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="流程实例ID"  field="processInstanceId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"   queryMode="group"  width="60"></t:dgCol>
   <t:dgCol title="创建人ID"  field="createUserId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createUserName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="求职意向"  field="qzjob"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="name"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex"  queryMode="group"  width="60"></t:dgCol>
   <t:dgCol title="年龄"  field="age"  queryMode="group"  width="60"></t:dgCol>
   <t:dgCol title="工作经验"  field="gzjy"  queryMode="group"  width="60"></t:dgCol>
   <t:dgCol title="目前职位"  field="mqjob"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="邀约结果"  field="inviteResult"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="邀约门店"  field="inviteStore"  hidden="true"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="预约面试时间"  field="inviteDate"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="邀约备注"  field="inviteRemarks"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="企业名称"  field="businessName"  hidden="true"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="职位名称"  field="positionName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="面试结论"  field="interviewResult"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="不通过原因"  field="interviewReason"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="预约接送时间"  field="interviewPickDate"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="审核时间"  field="examineDate"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="审核结论"  field="examineResult"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="审核备注"  field="examineRemarks"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="接送时间"  field="pickDate"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="接送结论"  field="pickResult"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="体检结果"  field="workTijianResult"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="复试结果"  field="workFushiResult"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否签订劳动合同"  field="workHetongResult"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="复试是否通过"  field="ruzhiFushiResult"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否签订劳动合同"  field="ruzhiHetongResult"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="体检结果"  field="ruzhiTijianResult"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="培训结果"  field="ruzhiPeixunResult"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否住宿"  field="ruzhiZhusuResult"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否上岗"  field="ruzhiShanggangResult"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否在职"  field="chargeZaizhiResult"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否收款"  field="chargeShoukuanResult"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="收款金额"  field="chargeJine"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="收款时间"  field="chargeDate"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否结算代理费"  field="chargeDlfResult"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="代理费金额"  field="chargeDailifei"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="当前环节"  field="flowHj"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tOrderHisController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o" urlStyle="background-color: red;"/>
   <t:dgOpenOpt  width="900" height="600" url="tOrderHisController.do?lookHis&id={id}" title="历史详情" urlclass="ace_button" urlfont="fa-file" urlStyle="background-color: #00B2EE;"></t:dgOpenOpt>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="tOrderHisController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tOrderHisController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/qpwl/order/tOrderHisList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tOrderHisController.do?upload', "tOrderHisList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tOrderHisController.do?exportXls","tOrderHisList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tOrderHisController.do?exportXlsByT","tOrderHisList");
}

 </script>