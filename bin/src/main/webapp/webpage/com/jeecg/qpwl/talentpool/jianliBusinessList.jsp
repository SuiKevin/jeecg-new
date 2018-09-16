<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="jianliBusinessList" checkbox="true" fitColumns="true" title="企业人才库" actionUrl="jianliBusinessController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="网站类型"  field="website"  hidden="true" queryMode="group"  width="60"></t:dgCol>
   <t:dgCol title="省份"  field="province"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="城市"  field="city"  queryMode="group"  width="60" query="true" ></t:dgCol>
   <t:dgCol title="区县"  field="town"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="职位大类"  field="jobtype1"  hidden="true"  queryMode="group" query="true" width="120"></t:dgCol>
   <t:dgCol title="职位小类"  field="jobtype2"  hidden="true"  queryMode="group" query="true"  width="120"></t:dgCol>
   <t:dgCol title="职位详情"  field="jobtype3"  queryMode="group" query="true" width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="name"  queryMode="group" query="true" width="60"></t:dgCol>
   <t:dgCol title="性别"  field="sex"  queryMode="group"  width="40"></t:dgCol>
   <t:dgCol title="年龄"  field="age"  queryMode="group" query="true" width="40"></t:dgCol>
   <t:dgCol title="联系电话"  field="mobile"  queryMode="group" query="true" width="120"></t:dgCol>
   <t:dgCol title="电子邮件"  field="email"  hidden="true" query="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="学历"  field="xueli"  queryMode="group" query="true" width="120"></t:dgCol>
   <t:dgCol title="工作经验"  field="gzjy"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="籍贯"  field="jg"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="先居地"  field="xjzd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="期望职位"  field="qwzw"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="目前职位"  field="mqzw"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="期望薪资"  field="qwxz"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="期望工作地"  field="qwgzd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="个人标签"  field="grbq"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="自我评价"  field="zwpj"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="详细工作经验"  field="xxgzjy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="教育经历"  field="jyjl"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="获得证书"  field="hdzs"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新时间"  field="gxsj"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="被浏览"  field="bllcs"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="查看过"  field="bckg"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="主动申请"  field="zdsq"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="对他感兴趣"  field="dtgxq"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="被下载"  field="bxzcs"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="收到邀请"  field="sdyq"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="录入时间"  field="lrsj"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="证件照片"  field="zjzp"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="录入方式"  field="lrfs"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="录入网点"  field="lrwd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="录入人员"  field="lrry"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身份证号"  field="sfzh"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="民族"  field="mz"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="出生日期"  field="csrq"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="住址"  field="address"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="签发机关"  field="fzjg"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="有效期"  field="yxq"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身份录入时间"  field="sflrsj"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身份证录入网点"  field="sfzlrwd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身份证录入人员"  field="sfzlrry"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身份证是否有磁"  field="sfzsfyc"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="婚姻状况"  field="hyzk"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="政治面貌"  field="zzmm"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="健康状况"  field="jkzk"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="病史详情"  field="bsxq"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="户口性质"  field="hkxz"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="犯罪记录"  field="fzjl"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="劳动关系"  field="ldgx"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="离职原因"  field="lzyy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="背景录入网点"  field="bjlrwd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="背景录入人员"  field="bjlrry"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="背景录入日期"  field="bjlrrq"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="300"></t:dgCol>
   <t:dgDelOpt title="联系方式" url="jianliOnlineController.do?doQueryPhoneNo&id={id}"  urlclass="ace_button" urlfont="fa-phone" urlStyle="background-color: red;"/>
   <t:dgOpenOpt width="1150" height="600" url="jianliBusinessController.do?doResumeView&id={id}" title="查看简历" urlclass="ace_button" urlfont="fa-file" urlStyle="background-color: #3399CC;"></t:dgOpenOpt>
   <t:dgDelOpt title="发起招聘" url="jianliBusinessController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgToolBar title="简历录入" icon="icon-add" url="jianliOnlineController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="jianliBusinessController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="jianliBusinessController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="jianliBusinessController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/qpwl/talentpool/jianliBusinessList.js"></script>		
 <script type="text/javascript">
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'jianliBusinessController.do?upload', "jianliBusinessList");
}

//导出
function ExportXls() {
	JeecgExcelExport("jianliBusinessController.do?exportXls","jianliBusinessList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("jianliBusinessController.do?exportXlsByT","jianliBusinessList");
}
 </script>