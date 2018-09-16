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
            <label class="Validform_label"> 用户名: </label>
            <input name="tsuser.userName" class="inputxt" readonly="readonly" type="text" value="${jobtype.tsuser.userName }"  datatype="s1-20">
            <span class="Validform_checktip"><t:mutiLang langKey="departmentname.rang1to20"/></span>
        </div>
        
        <div class="form">            
			<td align="right"><label class="Validform_label"> 职位大类: </label></td>
             
			<td class="value">
				<input id="positionid" name="positionid" type="hidden"/>
               	<input name="jobtype1" id="positionname" class="inputxt" readonly="readonly" datatype="*" />
                <t:choose hiddenName="positionid" hiddenid="positionid" textname="positionname" url="selectViewController.do?jobpositions" name="jobpositionList" icon="icon-search" title="职位大类" isclear="false" isInit="true" fun="loadJob2" ></t:choose>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">职位大类</label>
			</td>
            
		</div>  
		 
		<div class="form">            
			<td align="right"><label class="Validform_label"> 职位小类: </label></td>
            <td class="value">
				<input id="jobid" name="jobid" type="hidden"/>
               	<input name="jobtype2" id="jobname" class="inputxt" readonly="readonly" datatype="*" />
                <t:choose hiddenName="jobid" hiddenid="jobid" textname="jobname" url="selectViewController.do?jobs" name="jobList" icon="icon-search" title="职位小类" isclear="false" isInit="true" fun="loadJob3" ></t:choose>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">职位小类</label>
			</td>
		</div>         	
		
		<div class="form">   
		    <td align="right"><label class="Validform_label"> 职位详情: </label></td>
           <td class="value">
				<input id="jobdesccode" name="jobdesccode" type="hidden"/>
               	<input name="jobtype3" id="jobdescname" class="inputxt" readonly="readonly" datatype="*" />
                <t:choose hiddenName="jobdesccode" hiddenid="jobdesccode" textname="jobdescname" url="selectViewController.do?jobdescriptios" name="jobdescriptionList" icon="icon-search" title="职位描述" isclear="false" isInit="true"></t:choose>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">职位详情</label>
			</td>			 
		</div>   
	</fieldset>
</t:formvalid>
</body>
</html>
<script>

	function loadJob2(){
		$.ajax({url:"selectViewController.do?job1job2&positionId="+$("#positionid").val(),async:true});
	}
	
	function loadJob3(){
		$.ajax({url:"selectViewController.do?job2job3&jobId="+$("#jobid").val(),async:true});
	}
	
</script>
