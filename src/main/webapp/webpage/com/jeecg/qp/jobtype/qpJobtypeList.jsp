<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="qpJobtypeList" checkbox="false" pagination="true" fitColumns="true" title="简历职位管理" actionUrl="qpJobtypeController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="用户名"  field="tsuser.userName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="归属组织"  field="owndeparts"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="可查看的职位大类"  field="jobtype1"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="可查看的职位小类"  field="jobtype2"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="可查看的职位详情"  field="jobtype3"  query="true"  queryMode="single"  width="120"></t:dgCol>
   
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <!--  
   <t:dgDelOpt title="删除" url="qpJobtypeController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
    -->
   <t:dgToolBar title="授权简历职位" icon="icon-edit" url="qpJobtypeController.do?sqjobtype" funname="update"></t:dgToolBar>
  
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/qp/jobtype/qpJobtypeList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
 </script>