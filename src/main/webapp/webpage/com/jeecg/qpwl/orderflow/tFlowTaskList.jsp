<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addTFlowTaskBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delTFlowTaskBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addTFlowTaskBtn').bind('click', function(){   
 		 var tr =  $("#add_tFlowTask_table_template tr").clone();
	 	 $("#add_tFlowTask_table").append(tr);
	 	 resetTrNum('add_tFlowTask_table');
	 	 return false;
    });  
	$('#delTFlowTaskBtn').bind('click', function(){   
      	$("#add_tFlowTask_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_tFlowTask_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addTFlowTaskBtn" href="#">添加</a> <a id="delTFlowTaskBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="tFlowTask_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						环节编码
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						环节名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						环节类型
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						下一环节
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						环节顺序
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						派单类型
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						执行人
				  </td>
	</tr>
	<tbody id="add_tFlowTask_table">
	<c:if test="${fn:length(tFlowTaskList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="tFlowTaskList[0].id" type="hidden"/>
					<input name="tFlowTaskList[0].flowId" type="hidden"/>
				  <td align="left">
					  	<input name="tFlowTaskList[0].taskCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">环节编码</label>
					</td>
				  <td align="left">
					  	<input name="tFlowTaskList[0].taskName" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">环节名称</label>
					</td>
				  <td align="left">
							<t:dictSelect field="tFlowTaskList[0].taskType" type="list"   typeGroupCode="task_type"  defaultVal="${tFlowTaskPage.taskType}" hasLabel="false"  title="环节类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">环节类型</label>
					</td>
				  <td align="left">
					  	<input name="tFlowTaskList[0].nextTask" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">下一环节</label>
					</td>
				  <td align="left">
					  	<input name="tFlowTaskList[0].taskIndex" maxlength="50" type="text" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">环节顺序</label>
					</td>
				  <td align="left">
							<t:dictSelect field="tFlowTaskList[0].partyType" type="list"   typeGroupCode="party_type"  defaultVal="${tFlowTaskPage.partyType}" hasLabel="false"  title="派单类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">派单类型</label>
					</td>
				  <td align="left">
					       	<input name="tFlowTaskList[0].partyIds" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  >
					  <label class="Validform_label" style="display: none;">执行人</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(tFlowTaskList)  > 0 }">
		<c:forEach items="${tFlowTaskList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="tFlowTaskList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="tFlowTaskList[${stuts.index }].flowId" type="hidden" value="${poVal.flowId }"/>
				   <td align="left">
					  	<input name="tFlowTaskList[${stuts.index }].taskCode" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.taskCode }"/>
					  <label class="Validform_label" style="display: none;">环节编码</label>
				   </td>
				   <td align="left">
					  	<input name="tFlowTaskList[${stuts.index }].taskName" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.taskName }"/>
					  <label class="Validform_label" style="display: none;">环节名称</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="tFlowTaskList[${stuts.index }].taskType" type="list"   typeGroupCode="task_type"  defaultVal="${poVal.taskType }" hasLabel="false"  title="环节类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">环节类型</label>
				   </td>
				   <td align="left">
					  	<input name="tFlowTaskList[${stuts.index }].nextTask" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.nextTask }"/>
					  <label class="Validform_label" style="display: none;">下一环节</label>
				   </td>
				   <td align="left">
					  	<input name="tFlowTaskList[${stuts.index }].taskIndex" maxlength="50" type="text" class="inputxt"  style="width:120px;"  datatype="n"  ignore="ignore"  value="${poVal.taskIndex }"/>
					  <label class="Validform_label" style="display: none;">环节顺序</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="tFlowTaskList[${stuts.index }].partyType" type="list"   typeGroupCode="party_type"  defaultVal="${poVal.partyType }" hasLabel="false"  title="派单类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">派单类型</label>
				   </td>
				   <td align="left">
					       	<input name="tFlowTaskList[${stuts.index }].partyIds" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.partyIds }"/>
					  <label class="Validform_label" style="display: none;">执行人</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
	<div id="div_userSelect">
		
	</div>
</table>
