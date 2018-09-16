<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div id="main_depart_list" class="easyui-layout" fit="true">
    <div region="center" style="padding:0px;border:0px">
        <t:datagrid name="departList" title="common.department.list" fitColumns="false" actionUrl="departController.do?departgrid" treegrid="true" idField="departid" pagination="false">
            <t:dgCol title="common.id" field="id" treefield="id" hidden="true"></t:dgCol>
            <t:dgCol title="common.department.name" field="departname" treefield="text" width="140"></t:dgCol>
            <t:dgCol title="position.desc" field="description" treefield="src" width="100"></t:dgCol>
            <t:dgCol title="common.org.code" field="orgCode" treefield="fieldMap.orgCode" width="60"></t:dgCol>
            <t:dgCol title="common.org.type" field="orgType" dictionary="orgtype" treefield="fieldMap.orgType" width="70"></t:dgCol>
            <t:dgCol title="联系人" field="fax" treefield="fieldMap.fax" width="80"></t:dgCol>
            <t:dgCol title="58编码" field="areaCode" treefield="fieldMap.areaCode" width="80"></t:dgCol>
            <t:dgCol title="联系电话" field="mobile" treefield="fieldMap.mobile" width="80"></t:dgCol>
            <t:dgCol title="机构地址" field="address" treefield="fieldMap.address" width="100"></t:dgCol>
            <t:dgCol title="授权省份" field="province" treefield="fieldMap.province" width="80"></t:dgCol>
            <t:dgCol title="授权城市" field="city" treefield="fieldMap.city" width="80"></t:dgCol>
            <t:dgCol title="授权区域" field="town" treefield="fieldMap.town" width="80"></t:dgCol>
           <%--
            <t:dgCol title="简历查询职位" field="sqjobtype" treefield="fieldMap.sqjobtype" width="100"></t:dgCol>
            <t:dgCol title="简历查看区域" field="sqarea" treefield="fieldMap.sqarea" width="100"></t:dgCol>
            <t:dgCol title="已授权积分" field="sqpoint" treefield="fieldMap.sqpoint" width="100"></t:dgCol>
            <t:dgCol title="已消费积分" field="sqpointused" treefield="fieldMap.sqpointused" width="100"></t:dgCol>
            <t:dgCol title="剩余积分" field="address" treefield="fieldMap.address" width="100"></t:dgCol>
             --%>
            <t:dgCol title="common.operation" field="opt" width="300"></t:dgCol>
            <t:dgDelOpt operationCode="btn_row_del" url="departController.do?del&id={id}" title="common.delete" urlclass="ace_button"  urlfont="fa-trash-o" urlStyle="background-color:#ec4758;"></t:dgDelOpt>
            <t:dgFunOpt operationCode="btn_row_depuser" funname="queryUsersByDepart(id)" title="绑定人员" urlclass="ace_button"  urlfont="fa-user"></t:dgFunOpt>
            <t:dgFunOpt exp="orgType#eq#8" operationCode="btn_row_role" funname="setRoleByDepart(id,text)" title="role.set" urlclass="ace_button"  urlfont="fa-cog" urlStyle="background-color:#1a7bb9;"></t:dgFunOpt>
          
        </t:datagrid>
     
        <div id="departListtb" style="padding: 3px; height: 25px">
            <div style="float: left;">
                <a href="#" id="addorg"  class="easyui-linkbutton" plain="true" icon="icon-add" onclick="addOrg()"><t:mutiLang langKey="common.add.param" langArg="common.department"/></a>
                
                <a href="#" id="editorg" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="update('<t:mutiLang langKey="common.edit.param" langArg="common.department"/>','departController.do?update','departList','680px','450px')">编辑组织</a>
                <a href="#" id="sqarea"  class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="sqarea()">授权简历查看区域</a> 
               <!--
                <a href="#" id="sqjobtype"  class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="sqjobtype()">授权简历职位</a>
                <a href="#" id="point" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="sqpoint()">授权查看简历点数</a>
                -->
                <!--
                <a href="#" id="sqarea"  class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="sqarea()">授权简历地区</a>
                <a href="#" class="easyui-linkbutton" plain="true" icon="icon-put" onclick="ImportXls()"><t:mutiLang langKey="excelImport" langArg="common.department"/></a>
                <a href="#" class="easyui-linkbutton" plain="true" icon="icon-putout" onclick="ExportXls()"><t:mutiLang langKey="excelOutput" langArg="common.department"/></a>
                <a href="#" class="easyui-linkbutton" plain="true" icon="icon-putout" onclick="ExportXlsByT()"><t:mutiLang langKey="templateDownload" langArg="common.department"/></a> 
                -->
            </div>
        </div>
    </div>
</div>
<div data-options="region:'east',
	title:'<t:mutiLang langKey="member.list"/>',
	collapsed:true,
	split:true,
	border:false,
	onExpand : function(){
		li_east = 1;
	},
	onCollapse : function() {
	    li_east = 0;
	}"
	style="width: 400px; overflow: hidden;" id="eastPanel">
    <div class="easyui-panel" style="padding:0px;border:0px" fit="true" border="false" id="userListpanel"></div>
</div>

<script type="text/javascript">
<!--

    $(function() {
        var li_east = 0;
    });
    function addOrg() {
        var id = "";
        var rowsData = $('#departList').datagrid('getSelections');
        if (rowsData.length == 1) {
            id = rowsData[0].id;
        }
        var url = "departController.do?add&id=" + id;
        add('组织机构录入', url, "departList","660px","480px");
    }
    
    function sqarea(){
    	var rowsData = $('#departList').datagrid('getSelections');
    	if (!rowsData || rowsData.length==0) {
    		tip('请选择编辑项目');
    		return;
    	}
    	if (rowsData.length>1) {
    		tip('请选择一条记录再编辑');
    		return;
    	}
    	var orgType=rowsData["0"]["fieldMap.orgType"];
    	if (orgType == 2) {
    		//debugger;
        	update('授权可查询区域','departController.do?sqarea','departList','680px','450px');
    	}else{
    		tip('请选择-组织机构-进行授权');
    		return;
    	}
    	
    }
    
    function sqjobtype(){
    	var rowsData = $('#departList').datagrid('getSelections');
    	if (!rowsData || rowsData.length==0) {
    		tip('请选择编辑项目');
    		return;
    	}
    	if (rowsData.length>1) {
    		tip('请选择一条记录再编辑');
    		return;
    	}
    	var orgType=rowsData["0"]["fieldMap.orgType"];
    	if (orgType == 2) {
    		//debugger;
        	update('授权可查询职位','departController.do?sqjobtype','departList','680px','450px');
    	}else{
    		tip('请选择-组织机构-进行授权');
    		return;
    	}
    	
    } 
    function sqpoint(){
    	var rowsData = $('#departList').datagrid('getSelections');
    	if (!rowsData || rowsData.length==0) {
    		tip('请选择编辑项目');
    		return;
    	}
    	if (rowsData.length>1) {
    		tip('请选择一条记录再编辑');
    		return;
    	}
    	var orgType=rowsData["0"]["fieldMap.orgType"];
    	if (orgType == 2) {
    		//debugger;
        	update('授权点数','departController.do?sqpoint','departList','680px','450px');
    	}else{
    		tip('请选择-组织机构-进行授权');
    		return;
    	}
    	
    } 

    function queryUsersByDepart(departid){
        var title = '<t:mutiLang langKey="member.list"/>';
        if(li_east == 0 || $('#main_depart_list').layout('panel','east').panel('options').title != title){
            $('#main_depart_list').layout('expand','east');
        }
        <%--$('#eastPanel').panel('setTitle','<t:mutiLang langKey="member.list"/>');--%>
        $('#main_depart_list').layout('panel','east').panel('setTitle', title);
        $('#main_depart_list').layout('panel','east').panel('resize', {width: 500});
        $('#userListpanel').panel("refresh", "departController.do?userList&departid=" + departid);
    }
    /**
     * 为 组织机构 设置 角色
     * @param departid 组织机构主键
     * @param departname 组织机构名称
     */
    function setRoleByDepart(departid, departname){
        var currentTitle = $('#main_depart_list').layout('panel', 'east').panel('options').title;
        if(li_east == 0 || currentTitle.indexOf("<t:mutiLang langKey="current.org"/>") < 0){
            $('#main_depart_list').layout('expand','east');
        }
        var title = departname + ':<t:mutiLang langKey="current.org"/>';
        $('#main_depart_list').layout('panel','east').panel('setTitle', title);
        $('#main_depart_list').layout('panel','east').panel('resize', {width: 200});
        var url = {
            href:"roleController.do?roleTree&orgId=" + departid
        }
        $('#userListpanel').panel(url);
        $('#userListpanel').panel("refresh");
    }
    //导入
    function ImportXls() {
        openuploadwin('Excel导入', 'departController.do?upload', "departList");
    }

    //导出
    function ExportXls() {
        JeecgExcelExport("departController.do?exportXls","departList");
    }

    //模板下载
    function ExportXlsByT() {
        JeecgExcelExport("departController.do?exportXlsByT","departList");
    }

//-->
</script>