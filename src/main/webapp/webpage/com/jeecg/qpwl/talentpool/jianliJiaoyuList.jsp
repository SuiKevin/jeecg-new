<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addJianliJiaoyuBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delJianliJiaoyuBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addJianliJiaoyuBtn').bind('click', function(){   
 		 var tr =  $("#add_jianliJiaoyu_table_template tr").clone();
	 	 $("#add_jianliJiaoyu_table").append(tr);
	 	 resetTrNum('add_jianliJiaoyu_table');
	 	 return false;
    });  
	$('#delJianliJiaoyuBtn').bind('click', function(){   
      	$("#add_jianliJiaoyu_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_jianliJiaoyu_table'); 
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
	<a id="addJianliJiaoyuBtn" href="#">添加</a> <a id="delJianliJiaoyuBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="jianliJiaoyu_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						学校
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						专业
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						毕业时间
				  </td>
	</tr>
	<tbody id="add_jianliJiaoyu_table">
	<c:if test="${fn:length(jianliJiaoyuList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="jianliJiaoyuList[0].id" type="hidden"/>
					<input name="jianliJiaoyuList[0].resumeId" type="hidden"/>
				  <td align="left">
					  	<input name="jianliJiaoyuList[0].xuexiao" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">学校</label>
					</td>
				  <td align="left">
					  	<input name="jianliJiaoyuList[0].zhuanye" maxlength="20" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">专业</label>
					</td>
				  <td align="left">
							<input name="jianliJiaoyuList[0].bysj" maxlength="50"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">毕业时间</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(jianliJiaoyuList)  > 0 }">
		<c:forEach items="${jianliJiaoyuList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="jianliJiaoyuList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="jianliJiaoyuList[${stuts.index }].resumeId" type="hidden" value="${poVal.resumeId }"/>
				   <td align="left">
					  	<input name="jianliJiaoyuList[${stuts.index }].xuexiao" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.xuexiao }"/>
					  <label class="Validform_label" style="display: none;">学校</label>
				   </td>
				   <td align="left">
					  	<input name="jianliJiaoyuList[${stuts.index }].zhuanye" maxlength="20" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.zhuanye }"/>
					  <label class="Validform_label" style="display: none;">专业</label>
				   </td>
				   <td align="left">
							<input name="jianliJiaoyuList[${stuts.index }].bysj" maxlength="50" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.bysj}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">毕业时间</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
