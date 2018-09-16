<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="qpZpcompanyList" checkbox="false" pagination="true" fitColumns="true" title="招聘企业信息" actionUrl="qpZpcompanyController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="公司名称"  field="zpCompany"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="公司介绍"  field="companyInfo"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="招聘岗位"  field="zpJob"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="招聘人数"  field="zpPersonnum"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="学历"  field="edu"  query="true"  queryMode="single"  dictionary="edu"  width="120"></t:dgCol>
   <t:dgCol title="职位描述"  field="jobInfo"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="经验要求"  field="jingyan"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="地址"  field="address"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="薪资待遇"  field="money"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" operationCode="btn_company_del"  url="qpZpcompanyController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" operationCode="btn_company_input"  icon="icon-add" url="qpZpcompanyController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" operationCode="btn_company_edit"  icon="icon-edit" url="qpZpcompanyController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="qpZpcompanyController.do?goUpdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/qp/company/qpZpcompanyList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
  

 </script>