<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tOrderIngList" checkbox="false" pagination="true" fitColumns="true" title="在途工单" actionUrl="tOrderIngController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="简历ID"  field="resumeId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程实例ID"  field="processInstanceId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人ID"  field="createUserId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createUserName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="求职意向"  field="qzjob"   query="true"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="姓名"  field="name"  query="true"  queryMode="single"  width="40"></t:dgCol>
   <t:dgCol title="性别"  field="sex"  queryMode="single"  width="40"></t:dgCol>
   <t:dgCol title="年龄"  field="age"  query="true"  queryMode="group"   width="40"></t:dgCol>
   <t:dgCol title="工作经验"  field="gzjy"  query="false"  queryMode="group"  width="60"></t:dgCol>
   <t:dgCol title="目前职位"  field="mqjob"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="当前环节"  field="taskName" query="true" queryMode="single"  width="50"></t:dgCol>
   <t:dgCol title="邀约结果"  field="inviteResult"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="邀约门店"  field="inviteStore"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="预约面试时间"  field="inviteDate"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="邀约备注"  field="inviteRemarks"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="企业名称"  field="businessName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="职位名称"  field="positionName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="面试结论"  field="interviewResult"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="不通过原因"  field="interviewReason"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="预约接送时间"  field="interviewPickDate"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核时间"  field="examineDate"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核结论"  field="examineResult"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核备注"  field="examineRemarks"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="接送时间"  field="pickDate"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="接送结论"  field="pickResult"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="体检结果"  field="workTijianResult"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="复试结果"  field="workFushiResult"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否签订劳动合同"  field="workHetongResult"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="复试是否通过"  field="ruzhiFushiResult"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否签订劳动合同"  field="ruzhiHetongResult"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="体检结果"  field="ruzhiTijianResult"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="培训结果"  field="ruzhiPeixunResult"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否住宿"  field="ruzhiZhusuResult"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否上岗"  field="ruzhiShanggangResult"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否在职"  field="chargeZaizhiResult"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否收款"  field="chargeShoukuanResult"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收款金额"  field="chargeJine"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收款时间"  field="chargeDate"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否结算代理费"  field="chargeDlfResult"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="代理费金额"  field="chargeDailifei"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgOpenOpt exp="taskName#eq#邀约" width="1000" height="600" url="tOrderIngController.do?goYaoyue&id={id}" title="邀约" urlclass="ace_button" urlfont="fa-phone" urlStyle="background-color: red;width: 40px;"></t:dgOpenOpt>
   <t:dgOpenOpt exp="taskName#eq#面试" width="1000" height="600" url="tOrderIngController.do?goMianshi&id={id}" title="面试" urlclass="ace_button" urlfont="fa-users" urlStyle="background-color: red;width: 40px;"></t:dgOpenOpt>
   <t:dgOpenOpt exp="taskName#eq#审核" width="1000" height="600" url="tOrderIngController.do?goShenhe&id={id}" title="审核" urlclass="ace_button" urlfont="fa-check" urlStyle="background-color: red;width: 40px;"></t:dgOpenOpt>
   <t:dgOpenOpt exp="taskName#eq#接送" width="1000" height="600" url="tOrderIngController.do?goJiedai&id={id}" title="接送" urlclass="ace_button" urlfont="fa-car" urlStyle="background-color: red;width: 40px;"></t:dgOpenOpt>
   <t:dgOpenOpt exp="taskName#eq#上岗" width="1000" height="600" url="tOrderIngController.do?goShanggang&id={id}" title="上岗" urlclass="ace_button" urlfont="fa-truck" urlStyle="background-color: red;width: 40px;"></t:dgOpenOpt>
   <t:dgOpenOpt exp="taskName#eq#入职" width="1000" height="600" url="tOrderIngController.do?goRuzhi&id={id}" title="入职" urlclass="ace_button" urlfont="fa-cubes" urlStyle="background-color: red;width: 40px;"></t:dgOpenOpt>
   <t:dgOpenOpt exp="taskName#eq#收款" width="1000" height="600" url="tOrderIngController.do?goShoukuan&id={id}" title="收款" urlclass="ace_button" urlfont="fa-money" urlStyle="background-color: red;width: 40px;"></t:dgOpenOpt>
   <t:dgOpenOpt width="1050" height="670" url="tOrderIngController.do?doResumeView&id={id}" title="简历详情" urlclass="ace_button" urlfont="fa-user" urlStyle="background-color: #00B2EE;"></t:dgOpenOpt>
   <t:dgOpenOpt width="820" height="670" url="tOrderIngController.do?flowImg&id={id}&taskName={taskName}" title="流程图" urlclass="ace_button" urlfont="fa-history" urlStyle="background-color: darkgray;"></t:dgOpenOpt>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="身份证补录" icon="icon-add" funname="idCardWrite()"></t:dgToolBar>
  </t:datagrid>
  </div>
  <OBJECT ID="ID100Control" CLASSID="CLSID:BAD80877-E3D2-41CC-91AE-C7FD9D019E36"></OBJECT>
 </div>
 <script src = "webpage/com/jeecg/qpwl/order/tOrderIngList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tOrderIngController.do?upload', "tOrderIngList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tOrderIngController.do?exportXls","tOrderIngList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tOrderIngController.do?exportXlsByT","tOrderIngList");
}
//身份证补录
function idCardWrite(){
  tip("开始读取身份证信息");
  try{
    //读取身份证信息
    if(typeof(ID100Control) =="undefined"){
    	tip("读取失败：未插入身份证读卡器,或者未使用IE10以上的浏览器。");
    	return;
    }
    if(ID100Control.Connect()){
 		alert("身份证读卡器连接成功");
 		var obj = ID100Control.ReadContentEx();
 		obj = JSON.parse(obj);
 		if(typeof(obj) == "undefined" || obj.ret != "0"){
 		  tip("读取失败：请重新插入读卡器或者将身份证取出重新放入再试");
 		  ID100Control.DisConnect();
 		  return;
 		}
		createdialog('身份证补录', '身份证补录,只能补录当前组织下正在招聘人员，是否继续?', "tOrderIngController.do?idCradWrite&idCardInfo="+JSON.stringify(obj),"tOrderIngList");
		ID100Control.DisConnect();
 	}else{
 		alert("身份证读卡器连接失败");
 	}
  }catch(error){
  	 tip("读取失败：未插入身份证读卡器,或者未使用IE10以上的浏览器。");
  	 ID100Control.DisConnect();
  }
}

 </script>