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

	function openSqjobtypeSelect() {
		$.dialog.setting.zIndex = getzIndex(); 
		var sqjobtypeIds = $("#jobtypeCode").val();

		$.dialog({content: 'url:departController.do?jobtypeSelect&sqjobtypeIds='+sqjobtypeIds, zIndex: getzIndex(), title: '简历职位树列表', lock: true, width: '400px', height: '350px', opacity: 0.4, button: [
		   {name: '<t:mutiLang langKey="common.confirm"/>', callback: callbackSqjobtypeSelect, focus: true},
		   {name: '<t:mutiLang langKey="common.cancel"/>', callback: function (){}}
	   ]}).zindex();
	}
	
	function callbackClean(){
		$('#sqjobtype').val('');
		$('#jobtypeCode').val('');	
	}
	

	function callbackSqjobtypeSelect() {
		  var iframe = this.iframe.contentWindow;
		  var treeObj = iframe.$.fn.zTree.getZTreeObj("jobtypeSelect");
		  var nodes = treeObj.getCheckedNodes(true);
		  if(nodes.length>0){
		  var ids='',names='';
		  for(i=0;i<nodes.length;i++){
		     var node = nodes[i];
		     ids += node.id+',';
		     names += node.name+',';
		 }
		 $('#jobtypeName').val(names);
		 $('#jobtypeName').blur();		
		 $('#jobtypeCode').val(ids);		
		}
	}

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
			<td align="right"><label class="Validform_label"> 授权可查询岗位: </label></td>
			<td class="value">               
                <input id="jobtypeName" name="jobtypeName" type="text" readonly="readonly" class="inputxt" datatype="*" value="${jobtype.jobtypeName}">
                <input id="jobtypeCode" name="jobtypeCode" type="hidden" value="${jobtype.jobtypeCode}">
                <a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" id="departSearch" onclick="openSqjobtypeSelect()">选择</a>
                <a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" id="departRedo" onclick="callbackClean()">清空</a>
                <span class="Validform_checktip">不能为空</span>
            </td>
		</div>       
	</fieldset>
</t:formvalid>
</body>
</html>
