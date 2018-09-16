<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>部门信息</title>
<t:base type="jquery,easyui,tools"></t:base>
<script type="text/javascript">
	$(function() {
		 
	});

	 

</script>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:formvalid formid="formobj" layout="div" dialog="true" action="qpJobtypeController.do?saveJobType">
	<input id="id" name="id" type="hidden" value="${jobtype.id}">
	<fieldset class="step">
        <div class="form">
            <label class="Validform_label"> 用户名2: </label>
            <input name="tsuser.userName" class="inputxt" readonly="readonly" type="text" value="${jobtype.tsuser.userName }"  datatype="s1-20">
            <span class="Validform_checktip"><t:mutiLang langKey="departmentname.rang1to20"/></span>
        </div>
        
        <div class="form">            
			<td align="right"><label class="Validform_label"> 授权可查询岗位: </label></td>
            <td style="width: 22%;display: inline;">
             <input id="positionid" name="positionid" type="hidden"/>
             <input name="jobtype1" id="positionname" class="inputxt" readonly="readonly" datatype="*" />
             <t:choose hiddenName="positionid" hiddenid="positionid" textname="positionname" url="selectViewController.do?jobpositions" name="jobpositionList" icon="icon-search" title="职位大类" isclear="false" isInit="true"></t:choose>
        
            </td>
		</div>       
	</fieldset>
</t:formvalid>
</body>
</html>
