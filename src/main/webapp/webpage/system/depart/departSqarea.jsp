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
<t:formvalid formid="formobj" layout="div" dialog="true" action="systemController.do?saveDepart">
	<input id="id" name="id" type="hidden" value="${depart.id }">
	<fieldset class="step">
        <div class="form">
            <label class="Validform_label"> <t:mutiLang langKey="common.department.name"/>: </label>
            <input name="departname" class="inputxt" readonly="readonly" type="text" value="${depart.departname }"  datatype="s1-20">
            <span class="Validform_checktip"><t:mutiLang langKey="departmentname.rang1to20"/></span>
        </div>       
        <div class="form">
            <label class="Validform_label"> 省份: </label>
            <input id="provinceid" name="provinceid" type="hidden" /><input name="province" id="provincename" class="inputxt" readonly="readonly" datatype="*" value="${depart.province}"/><t:choose hiddenName="provinceid" hiddenid="provinceid" textname="provincename" url="selectViewController.do?provinces" name="provincesList" icon="icon-search" title="选择省份" isclear="false" isInit="true" fun="loadCrty"></t:choose>
        </div>       
         <div class="form">
            <label class="Validform_label"> 城市:</label>
            <input id="cityid" name="cityid" type="hidden" /><input name="city" id="cityname" class="inputxt" readonly="readonly" datatype="*" value="${depart.city}"/><t:choose hiddenName="cityid" hiddenid="cityid" textname="cityname" url="selectViewController.do?citys" name="cityList" icon="icon-search" title="选择城市" isclear="false" isInit="true" fun="loadTown" ></t:choose>
        </div>       
         <div class="form">
            <label  class="Validform_label">区县: </label>
            <input id="townid" name="townid" type="hidden" /><input name="town" id="townname" class="inputxt" readonly="readonly" value="${depart.town}"/><t:choose hiddenName="townid" hiddenid="townid" textname="townname" url="selectViewController.do?towns" name="townList" icon="icon-search" title="选择区县" isclear="false" isInit="true"></t:choose>
        </div>            
	</fieldset>
</t:formvalid>
</body>
</html>
<script>
function loadCrty(){
 	$.ajax({url:"selectViewController.do?citysProvince&provinceId="+$("#provinceid").val(),async:true});
}
 function loadTown(){
 	$.ajax({url:"selectViewController.do?townsCity&provinceId="+$("#cityid").val(),async:true});
 }
</script>
