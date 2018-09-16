<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>职位集合</title>
<t:base type="jquery"></t:base>
<!-- update--start--by:jg_renjie--at:20160318 for:#942 【组件封装】组织机构弹出模式，目前是列表，得改造成树方式 -->
<!-- update-start--Author:jg_renjie  Date:20160317 for：组织机构改为ztree -->
<link rel="stylesheet" type="text/css" href="plug-in/ztree/css/zTreeStyle.css">
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
<!-- update-end--Author:jg_renjie  Date:20160317 for：组织机构改为ztree -->
<script type="text/javascript">
	var setting = {
	  check: {
			enable: true,
			chkboxType: { "Y": "", "N": "" }
		},
		data: {
			simpleData: {
				enable: true
			}
		},callback: {
			onExpand: zTreeOnExpand
		}
	};
	
	//加载展开方法
	function zTreeOnExpand(event, treeId, treeNode){
		 var treeNodeId = treeNode.id;
		 $.post(
			'departController.do?getJobtypeInfo',
			{parentid:treeNodeId,sqjobtypeIds:$("#sqjobtypeIds").val()},
			function(data){
				var d = $.parseJSON(data);
				if (d.success) {
					var dbDate = eval(d.msg);
					var tree = $.fn.zTree.getZTreeObj("jobtypeSelect");

					if (!treeNode.zAsync){
						tree.addNodes(treeNode, dbDate);
						treeNode.zAsync = true;
					} else{
						tree.reAsyncChildNodes(treeNode, "refresh");
					}
					//tree.addNodes(treeNode, dbDate);
				}
			}
		);
	}
	
	//首次进入加载level为1的
	$(function(){
		$.post(
			'departController.do?getJobtypeInfo',
		    {sqareaIds:$("#sqjobtypeIds").val()},
			function(data){
				var d = $.parseJSON(data);
				if (d.success) {
					var dbDate = eval(d.msg);
					$.fn.zTree.init($("#jobtypeSelect"), setting, dbDate);
				}
			}
		);
	});
</script>
</head>
<body style="overflow-y: auto" scroll="no">
<input id="sqjobtypeIds" name="sqjobtypeIds" type="hidden" value="${sqjobtypeIds}">
<ul id="jobtypeSelect" class="ztree" style="margin-top: 30px;"></ul>
 
</body>
</html>
