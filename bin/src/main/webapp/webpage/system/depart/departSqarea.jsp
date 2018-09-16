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

	function openSqareaSelect() {
		$.dialog.setting.zIndex = getzIndex(); 
		var sqareaIds = $("#sqareaIds").val();

		$.dialog({content: 'url:departController.do?areaSelect&sqareaIds='+sqareaIds, zIndex: getzIndex(), title: '区域树列表', lock: true, width: '400px', height: '350px', opacity: 0.4, button: [
		   {name: '<t:mutiLang langKey="common.confirm"/>', callback: callbackSqareaSelect, focus: true},
		   {name: '<t:mutiLang langKey="common.cancel"/>', callback: function (){}}
	   ]}).zindex();
	}
	
	function callbackClean(){
		$('#sqarea').val('');
		$('#sqareaIds').val('');	
	}
	

	function callbackSqareaSelect() {
		  var iframe = this.iframe.contentWindow;
		  var treeObj = iframe.$.fn.zTree.getZTreeObj("areaSelect");
		  var nodes = treeObj.getCheckedNodes(true);
		  if(nodes.length>0){
		  var ids='',names='';
		  for(i=0;i<nodes.length;i++){
		     var node = nodes[i];
		     ids += node.id+',';
		    names += node.name+',';
		 }
		 $('#sqarea').val(names);
		 $('#sqarea').blur();		
		 $('#sqareaIds').val(ids);		
		}
	}

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
			<td align="right"><label class="Validform_label"> 授权区域: </label></td>
			<td class="value">               
                <input id="sqarea" name="sqarea" type="text" readonly="readonly" class="inputxt" datatype="*" value="${depart.sqarea}">
                <input id="sqareaIds" name="sqareaIds" type="hidden" value="${depart.sqareaIds}">
                <input id="pid" name="TSPDepart.id" type="hidden" value="${depart.TSPDepart.id}">
                <a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" id="departSearch" onclick="openSqareaSelect()">选择</a>
                <a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" id="departRedo" onclick="callbackClean()">清空</a>
                <span class="Validform_checktip">不能为空</span>
            </td>
		</div>       
	</fieldset>
</t:formvalid>
</body>
</html>
