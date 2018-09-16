<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>用户信息</title>
<t:base type="jquery,easyui,tools"></t:base>
  
</head>
<body style="overflow-y: hidden" scroll="no">
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="userController.do?saveUser" beforeSubmit="setOrgIds">
	<input id="id" name="id" type="hidden" value="${user.id }">
	<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" width="25%" nowrap>
                <label class="Validform_label">  <t:mutiLang langKey="common.username"/>:  </label>
            </td>
			<td class="value" width="85%">
                <c:if test="${user.id!=null }"> ${user.userName } </c:if>
                <c:if test="${user.id==null }">
                    <input id="userName" class="inputxt" name="userName" validType="t_s_base_user,userName,id" value="${user.userName }" datatype="s2-10" />
                    <span class="Validform_checktip"> <t:mutiLang langKey="username.rang2to10"/></span>
                </c:if>
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label">姓名: </label></td>
			<td class="value" width="10%">
                <input id="realName" class="inputxt" name="realName" value="" datatype="s2-10">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label">身份证: </label></td>
			<td class="value" width="10%">
                <input id="idcard" class="inputxt" name="idcard" value="" datatype="s2-18">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label">性别: </label></td>
			<td class="value" width="10%">
                <input id="sex" class="inputxt" name="sex" value="" datatype="s2-10">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label">住址: </label></td>
			<td class="value" width="30%">
                <input id="addr" style="width:80%" class="inputxt" name="addr" value=""  readonly="readonly">
               
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label">有效期: </label></td>
			<td class="value" width="30%">
                <input id="validata" style="width:80%" class="inputxt" name="validata" value="" readonly="readonly">
                 
            </td>
		</tr>
	    <tr>
			<td align="right" width="10%" nowrap>请在IE10+以上版本操作 </td>
			<td class="value" width="10%">
			    <a href="#" id="readidcard"  class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="readidcard()">读取身份证</a>
            </td>
		</tr>		        
	</table>
</t:formvalid>
<OBJECT ID="ID100Control" CLASSID="CLSID:BAD80877-E3D2-41CC-91AE-C7FD9D019E36"></OBJECT>
</body>
<script type="text/javascript">
    function readidcard(){ 	    	
    	 ID100Control.Connect();
    	 var idcardobj=ID100Control.ReadContentEx();    	 
    	 var idobj = JSON.parse(idcardobj); 
       
         $("#realName").val(idobj.info.name);
         $("#idcard").val(idobj.info.cardno);
         $("#sex").val(idobj.info.sex);
         $("#addr").val(idobj.info.address);
         $("#validata").val(idobj.info.validata);    	 
    	
        ID100Control.DisConnect();        
        
    	var rowsData = $('#departList').datagrid('getSelections');
    	if (!rowsData || rowsData.length==0) {
    		tip('请选择编辑项目');
    		return;
    	}
    	if (rowsData.length>1) {
    		tip('请选择一条记录再编辑');
    		return;
    	}
    	
    	//var orgType=rowsData["0"]["fieldMap.orgType"];
    	//if (orgType == 2) {
    		//debugger;
        	//update('授权可查询职位','departController.do?sqjobtype','departList','680px','450px');
    	//}else{
    		//tip('请选择-组织机构-进行授权');
    		//return;
    	//}    	
    } 
</script>