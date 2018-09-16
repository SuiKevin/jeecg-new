<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addTFlowExecuteHistoryBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delTFlowExecuteHistoryBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addTFlowExecuteHistoryBtn').bind('click', function(){   
 		 var tr =  $("#add_tFlowExecuteHistory_table_template tr").clone();
	 	 $("#add_tFlowExecuteHistory_table").append(tr);
	 	 resetTrNum('add_tFlowExecuteHistory_table');
	 	 return false;
    });  
	$('#delTFlowExecuteHistoryBtn').bind('click', function(){   
      	$("#add_tFlowExecuteHistory_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_tFlowExecuteHistory_table'); 
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
	<a id="addTFlowExecuteHistoryBtn" href="#">添加</a> <a id="delTFlowExecuteHistoryBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="tFlowExecuteHistory_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						流程实例ID
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						创建日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						环节名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						执行人
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						执行结论
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						备注
				  </td>
	</tr>
	<tbody id="add_tFlowExecuteHistory_table">
	<c:if test="${fn:length(tFlowExecuteHistoryList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="tFlowExecuteHistoryList[0].id" type="hidden"/>
					<input name="tFlowExecuteHistoryList[0].taskCode" type="hidden"/>
					<input name="tFlowExecuteHistoryList[0].executorId" type="hidden"/>
				  <td align="left">
					  	<input name="tFlowExecuteHistoryList[0].instanceId" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">流程实例ID</label>
					</td>
				  <td align="left">
							<input name="tFlowExecuteHistoryList[0].createDate" maxlength="20"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">创建日期</label>
					</td>
				  <td align="left">
					  	<input name="tFlowExecuteHistoryList[0].taskName" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">环节名称</label>
					</td>
				  <td align="left">
					  	<input name="tFlowExecuteHistoryList[0].executorName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">执行人</label>
					</td>
				  <td align="left">
					  	<input name="tFlowExecuteHistoryList[0].taskResult" maxlength="1000" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">执行结论</label>
					</td>
				  <td align="left">
					  	<input name="tFlowExecuteHistoryList[0].taskRemark" maxlength="1000" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(tFlowExecuteHistoryList)  > 0 }">
		<c:forEach items="${tFlowExecuteHistoryList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="tFlowExecuteHistoryList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="tFlowExecuteHistoryList[${stuts.index }].taskCode" type="hidden" value="${poVal.taskCode }"/>
						<input name="tFlowExecuteHistoryList[${stuts.index }].executorId" type="hidden" value="${poVal.executorId }"/>
				   <td align="left">
					  	<input name="tFlowExecuteHistoryList[${stuts.index }].instanceId" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.instanceId }"/>
					  <label class="Validform_label" style="display: none;">流程实例ID</label>
				   </td>
				   <td align="left">
							<input name="tFlowExecuteHistoryList[${stuts.index }].createDate" maxlength="20" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.createDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">创建日期</label>
				   </td>
				   <td align="left">
					  	<input name="tFlowExecuteHistoryList[${stuts.index }].taskName" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.taskName }"/>
					  <label class="Validform_label" style="display: none;">环节名称</label>
				   </td>
				   <td align="left">
					  	<input name="tFlowExecuteHistoryList[${stuts.index }].executorName" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.executorName }"/>
					  <label class="Validform_label" style="display: none;">执行人</label>
				   </td>
				   <td align="left">
					  	<input name="tFlowExecuteHistoryList[${stuts.index }].taskResult" maxlength="1000" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.taskResult }"/>
					  <label class="Validform_label" style="display: none;">执行结论</label>
				   </td>
				   <td align="left">
					  	<input name="tFlowExecuteHistoryList[${stuts.index }].taskRemark" maxlength="1000" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.taskRemark }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
