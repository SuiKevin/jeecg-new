<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="qpJifenList" checkbox="false" pagination="true" fitColumns="true" title="积分管理" actionUrl="qpJifenController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="用户名"  field="tsuser.userName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="归属组织"  field="owndeparts"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="授权积分"  field="sqPoint"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="已用积分"  field="sqPointUsed"     queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="每日限制用量"  field="pointDayLimit"     queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="当日用量"  field="pointDayUsed"     queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd hh:mm:ss"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <%--<t:dgDelOpt title="删除" url="qpJifenController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
    --%>
   <t:dgFunOpt title="转他积分"  funname="movjifen()"  urlclass="ace_button"  urlfont="fa-trash-o"/>
   <%--<t:dgToolBar title="录入" icon="icon-add" url="qpJifenController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="qpJifenController.do?goUpdate" funname="update"></t:dgToolBar>
    
   <t:dgToolBar title="查看" icon="icon-search" url="qpJifenController.do?goUpdate" funname="detail"></t:dgToolBar>
   --%>
   <t:dgToolBar title="授权积分"  operationCode="btn_jifen_sq"  icon="icon-search" url="qpJifenController.do?sqjifen" funname="update"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/qp/jifen/qpJifenList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
 function movjifen(){
 	var rowsData = $('#qpJifenList').datagrid('getSelections');
 	if (!rowsData || rowsData.length==0) {
 		tip('请选择编辑项目');
 		return;
 	}
 	if (rowsData.length>1) {
 		tip('请选择一条记录再编辑');
 		return;
 	} 	  
    update('积分转移','qpJifenController.do?movjifenpage','qpJifenList','400px','200px');
 }

 </script>