<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addJinaliBusinessZhengshuBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delJinaliBusinessZhengshuBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addJinaliBusinessZhengshuBtn').bind('click', function(){   
 		 var tr =  $("#add_jinaliBusinessZhengshu_table_template tr").clone();
	 	 $("#add_jinaliBusinessZhengshu_table").append(tr);
	 	 resetTrNum('add_jinaliBusinessZhengshu_table');
	 	 return false;
    });  
	$('#delJinaliBusinessZhengshuBtn').bind('click', function(){   
      	$("#add_jinaliBusinessZhengshu_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_jinaliBusinessZhengshu_table'); 
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
	<a id="addJinaliBusinessZhengshuBtn" href="#">添加</a> <a id="delJinaliBusinessZhengshuBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="jinaliBusinessZhengshu_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						证书
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						获证日期
				  </td>
	</tr>
	<tbody id="add_jinaliBusinessZhengshu_table">
	<c:if test="${fn:length(jinaliBusinessZhengshuList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="jinaliBusinessZhengshuList[0].id" type="hidden"/>
					<input name="jinaliBusinessZhengshuList[0].resumeId" type="hidden"/>
				  <td align="left">
					  	<input name="jinaliBusinessZhengshuList[0].zhengshu" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">证书</label>
					</td>
				  <td align="left">
							<input name="jinaliBusinessZhengshuList[0].hqrq" maxlength="0"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">获证日期</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(jinaliBusinessZhengshuList)  > 0 }">
		<c:forEach items="${jinaliBusinessZhengshuList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="jinaliBusinessZhengshuList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="jinaliBusinessZhengshuList[${stuts.index }].resumeId" type="hidden" value="${poVal.resumeId }"/>
				   <td align="left">
					  	<input name="jinaliBusinessZhengshuList[${stuts.index }].zhengshu" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.zhengshu }"/>
					  <label class="Validform_label" style="display: none;">证书</label>
				   </td>
				   <td align="left">
							<input name="jinaliBusinessZhengshuList[${stuts.index }].hqrq" maxlength="0" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.hqrq}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">获证日期</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
