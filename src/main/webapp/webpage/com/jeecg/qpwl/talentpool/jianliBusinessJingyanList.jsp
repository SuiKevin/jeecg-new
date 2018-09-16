<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addJianliBusinessJingyanBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delJianliBusinessJingyanBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addJianliBusinessJingyanBtn').bind('click', function(){   
 		 var tr =  $("#add_jianliBusinessJingyan_table_template tr").clone();
	 	 $("#add_jianliBusinessJingyan_table").append(tr);
	 	 resetTrNum('add_jianliBusinessJingyan_table');
	 	 return false;
    });  
	$('#delJianliBusinessJingyanBtn').bind('click', function(){   
      	$("#add_jianliBusinessJingyan_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_jianliBusinessJingyan_table'); 
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
	<a id="addJianliBusinessJingyanBtn" href="#">添加</a> <a id="delJianliBusinessJingyanBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="jianliBusinessJingyan_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						工作单位
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						开始日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						结束日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						薪资水平
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						在职职位
				  </td>
	</tr>
	<tbody id="add_jianliBusinessJingyan_table">
	<c:if test="${fn:length(jianliBusinessJingyanList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="jianliBusinessJingyanList[0].id" type="hidden"/>
					<input name="jianliBusinessJingyanList[0].resumeId" type="hidden"/>
				  <td align="left">
					  	<input name="jianliBusinessJingyanList[0].gzdw" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">工作单位</label>
					</td>
				  <td align="left">
							<input name="jianliBusinessJingyanList[0].kssj" maxlength="0"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">开始日期</label>
					</td>
				  <td align="left">
							<input name="jianliBusinessJingyanList[0].jsrq" maxlength="0"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">结束日期</label>
					</td>
				  <td align="left">
					  	<input name="jianliBusinessJingyanList[0].xzsp" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">薪资水平</label>
					</td>
				  <td align="left">
					  	<input name="jianliBusinessJingyanList[0].zzzw" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">在职职位</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(jianliBusinessJingyanList)  > 0 }">
		<c:forEach items="${jianliBusinessJingyanList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="jianliBusinessJingyanList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="jianliBusinessJingyanList[${stuts.index }].resumeId" type="hidden" value="${poVal.resumeId }"/>
				   <td align="left">
					  	<input name="jianliBusinessJingyanList[${stuts.index }].gzdw" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.gzdw }"/>
					  <label class="Validform_label" style="display: none;">工作单位</label>
				   </td>
				   <td align="left">
							<input name="jianliBusinessJingyanList[${stuts.index }].kssj" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.kssj}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">开始日期</label>
				   </td>
				   <td align="left">
							<input name="jianliBusinessJingyanList[${stuts.index }].jsrq" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.jsrq}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">结束日期</label>
				   </td>
				   <td align="left">
					  	<input name="jianliBusinessJingyanList[${stuts.index }].xzsp" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.xzsp }"/>
					  <label class="Validform_label" style="display: none;">薪资水平</label>
				   </td>
				   <td align="left">
					  	<input name="jianliBusinessJingyanList[${stuts.index }].zzzw" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.zzzw }"/>
					  <label class="Validform_label" style="display: none;">在职职位</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
