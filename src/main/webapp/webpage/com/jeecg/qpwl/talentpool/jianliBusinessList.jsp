<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<style>
.div_bg_card{
	background:#ffffff;
	box-shadow:0 1px 8px 0 rgba(221,221,221,0.50);
	width:100%;
	min-height:40px;
	overflow: hidden;
}
.item_image_card{
	float:left;
	background:#1e96f7;
	width:4px;
	height:15px;
	margin-top: 5px;
	margin-left: 10px;
	margin-right:10px;
}
.font_bg_blue_14{
	font-family:PingFangSC-Semibold;
	font-size:14px;
	color:#1e96f7;
	line-height:24px;
	text-align:left;
}
.font_bg_blue_16{
	font-family:PingFangSC-Semibold;
	font-size:16px;
	color:#1e96f7;
	line-height:24px;
	text-align:left;
}
input{
				height: 25px;
                border: 1px solid #ccc;
                padding: 7px 0px;
                border-radius: 3px;
                padding-left:5px;
                -webkit-box-shadow: inset 0 1px 1px #708090;
                box-shadow: inset 0 1px 1px #708090;
                -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
                -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
                transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s
                margin-left: 10px;
				margin-right:10px;
            }
input:focus{
                    outline: 0;
            		border-color: #4169E1;
            		box-shadow: 0 0 10px #4169E1;
            }
 .div_button{
            background: #009dff;
            border: none;
            border-radius: 5px;
            color: #fff;
            cursor: pointer;
            height: 25px;
            font-family: 'Open Sans', sans-serif;
            font-size: 1.2em;
            letter-spacing: 0.05em;
            text-align: center;
            text-transform: uppercase;
            transition: background 0.3s ease-in-out;
            width: 100px;
        }
.div_button:hover {
            background: #00c8ff;
        }
.proccess b{vertical-align:middle;background:url(plug-in/layer/skin/default/loading-0.gif) no-repeat 0 center;padding-left:55px;display:inline-block;}  
</style>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <div style="margin-top: -20px;">
  	<br/><div class="item_image_card"></div><div class="font_bg_blue_16">查询条件</div>
  	<div class="div_bg_card" id="jianliBusinessListtb">
  		<table>
  			 <tr style="height: 35px;">
  				<td style="width: 8%;text-align:right;">职位大类:&nbsp;&nbsp;</td><td style="width: 22%;display: inline;"><input id="positionid" name="positionid" type="hidden"/><input name="jobtype1" id="positionname" class="inputxt" readonly="readonly" datatype="*" /><t:choose hiddenName="positionid" hiddenid="positionid" textname="positionname" url="selectViewController.do?jobpositions&from=jianli" name="jobpositionList" icon="icon-search" title="职位大类" isclear="false" isInit="true" fun="loadJob2" ></t:choose></td>
  				<td style="width: 8%;text-align:right;">职位小类:&nbsp;&nbsp;</td><td style="width: 22%;display: inline;"><input id="jobid" name="jobid" type="hidden"/><input name="jobtype2" id="jobname" class="inputxt" readonly="readonly" datatype="*" /><t:choose hiddenName="jobid" hiddenid="jobid" textname="jobname" url="selectViewController.do?jobs&from=jianli" name="jobList" icon="icon-search" title="职位小类" isclear="false" isInit="true" fun="loadJob3" ></t:choose></td>
  				<td style="width: 8%;text-align:right;">职位详情:&nbsp;&nbsp;</td><td style="width: 22%;display: inline;"><input id="jobdesccode" name="jobdesccode" type="hidden"/><input name="jobtype3" id="jobdescname" class="inputxt" readonly="readonly" datatype="*" /><t:choose hiddenName="jobdesccode" hiddenid="jobdesccode" textname="jobdescname" url="selectViewController.do?jobdescriptios&from=jianli" name="jobdescriptionList" icon="icon-search" title="职位描述" isclear="false" isInit="true"></t:choose></td>
  				<td style="width: 8%;text-align:right;">期望薪资:&nbsp;&nbsp;</td><td style="width: 22%;display: inline;"><t:dictSelect field="qwxz" type="list"   typeGroupCode="qwxz"  hasLabel="false"  title="期望薪资" ></t:dictSelect></td>
  			</tr>
  			<tr style="height: 35px;">
  				<td style="width: 8%;text-align:right;">省份:&nbsp;&nbsp;</td><td style="width: 22%;display: inline;"><input id="provinceid" name="provinceid" type="hidden"/><input name="province" id="provincename" class="inputxt" readonly="readonly" datatype="*" /><t:choose hiddenName="provinceid" hiddenid="provinceid" textname="provincename" url="selectViewController.do?provinces&from=jianli" name="provincesList" icon="icon-search" title="选择省份" isclear="false" isInit="true" fun="loadCrty"></t:choose></td>
  				<td style="width: 8%;text-align:right;">城市:&nbsp;&nbsp;</td><td style="width: 22%;display: inline;"><input id="cityid" name="cityid" type="hidden"/><input name="city" id="cityname" class="inputxt" readonly="readonly" datatype="*" /><t:choose hiddenName="cityid" hiddenid="cityid" textname="cityname" url="selectViewController.do?citys&from=jianli" name="cityList" icon="icon-search" title="选择城市" isclear="false" isInit="true" fun="loadTown" ></t:choose></td>
  				<td style="width: 8%;text-align:right;">区县:&nbsp;&nbsp;</td><td style="width: 22%;display: inline;"><input id="townId" name="townId" type="hidden"/><input name="town" id="townname" class="inputxt" readonly="readonly" datatype="*" /><t:choose hiddenName="townId" hiddenid="townId" textname="townname" url="selectViewController.do?towns&from=jianli" name="townList" icon="icon-search" title="选择区县" isclear="false" isInit="true"></t:choose></td>
  				<td style="width: 8%;text-align:right;">工作经验:&nbsp;&nbsp;</td><td style="width: 22%;display: inline;"><t:dictSelect field="gzjy" type="list"   typeGroupCode="gzjy"  hasLabel="false"  title="工作经验" ></t:dictSelect></td>
  			</tr>
  			<tr style="height: 35px;">
  				<td style="width: 8%;text-align:right;">性别:&nbsp;&nbsp;</td><td style="width: 22%;display: inline;"><t:dictSelect field="sex" type="list"  datatype="*"   typeGroupCode="sex2"  defaultVal="${jianliBusinessPage.sex}" hasLabel="false"  title="性别" ></t:dictSelect></td>
  				<td style="width: 8%;text-align:right;">年龄:&nbsp;&nbsp;</td><td style="width: 22%;display: inline;"><input id="ageStart" name="ageStart" type="text" style="width: 90px" class="inputxt"  datatype="n"  ignore="ignore" value="${ageStart}" datatype="*"/>~<input id="ageEnd" name="ageEnd" type="text" style="width: 90px" class="inputxt"  datatype="n"  ignore="ignore"  datatype="*"/></td>
  				<td style="width: 8%;text-align:right;">期望工作地:&nbsp;&nbsp;</td><td style="width: 22%;display: inline;"><input id="qwgzd" name="qwgzd" type="text" style="width: 180px" class="inputxt"  datatype="n"  ignore="ignore"  datatype="*"/></td>
  				<td style="width: 8%;text-align:right;">期望职位:&nbsp;&nbsp;</td><td style="width: 22%;display: inline;"><input id="qwzw" name="qwzw" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  datatype="*"/></td>
  			</tr>
  		</table>
  		<div style="margin-left: 10px;width:100%;margin-bottom:5px;">
  		  	<div class="div_button" style="width: 100px;display: inline-table;" onClick="inputResume()"><i class="fa fa-user" style="margin-right:5px;"></i>简历录入</div>
  		  	<div class="div_button" style="display: inline-table;margin-left: 77%;width: 80px;margin-right:20px;" onClick="laodRemotData()"><i class="fa fa-search" style="margin-right:5px;"></i>查找</div>
  		  	<div class="div_button" style="display: inline-table;width: 80px;" onClick="queryReset()"><i class="fa fa-trash-o" style="margin-right:5px;"></i>重置</div>
  		</div>
  	</div>
  	<div class="proccess" id="panelloadingDiv" style="margin-left: 45%;display: none;"><b>&nbsp;</b></div> 
  </div>
  <div style="height: 580px;">
  <t:datagrid name="jianliBusinessList" checkbox="true" fitColumns="true" title="" actionUrl="jianliBusinessController.do?datagrid" idField="id" fit="true" 
queryBuilder="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="网站类型"  field="website"  hidden="true" queryMode="single"  width="60"></t:dgCol>
   <t:dgCol title="省份"  field="province"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="城市"  field="city"  queryMode="single"  width="60" query="false" ></t:dgCol>
   <t:dgCol title="区县"  field="town"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="职位大类"  field="jobtype1"  hidden="true"  queryMode="single" query="false" width="120"></t:dgCol>
   <t:dgCol title="职位小类"  field="jobtype2"  hidden="true"  queryMode="single" query="false"  width="120"></t:dgCol>
   <t:dgCol title="职位详情"  field="jobtype3"  queryMode="single" query="false" width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="name"  queryMode="single" query="false" width="60"></t:dgCol>
   <t:dgCol title="性别"  field="sex"  queryMode="single"  width="40"></t:dgCol>
   <t:dgCol title="年龄"  field="age"  queryMode="single" query="false" width="40"></t:dgCol>
   <t:dgCol title="联系电话"  field="mobile"  queryMode="single" query="false" width="120"></t:dgCol>
   <t:dgCol title="电子邮件"  field="email"  hidden="true" query="false" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="学历"  field="xueli"  queryMode="single" query="false" dictionary="edu" width="120"></t:dgCol>
   <t:dgCol title="工作经验"  field="gzjy"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="籍贯"  field="jg"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="现居地"  field="xjzd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="期望职位"  field="qwzw"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="目前职位"  field="mqzw"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="期望薪资"  field="qwxz"  queryMode="single"  query="false" dictionary="xzsp" width="120"></t:dgCol>
   <t:dgCol title="期望工作地"  field="qwgzd"  hidden="true" queryMode="group"   width="120"></t:dgCol>
   <t:dgCol title="个人标签"  field="grbq"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="自我评价"  field="zwpj"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="详细工作经验"  field="xxgzjy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="教育经历"  field="jyjl"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="获得证书"  field="hdzs"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新时间"  field="gxsj"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="被浏览"  field="bllcs"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="查看过"  field="bckg"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="主动申请"  field="zdsq"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="对他感兴趣"  field="dtgxq"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="被下载"  field="bxzcs"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="收到邀请"  field="sdyq"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="录入时间"  field="lrsj"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="证件照片"  field="zjzp"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="录入方式"  field="lrfs"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="录入网点"  field="lrwd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="录入人员"  field="lrry"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身份证号"  field="sfzh"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="民族"  field="mz"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="出生日期"  field="csrq"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="住址"  field="address"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="签发机关"  field="fzjg"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="有效期"  field="yxq"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身份录入时间"  field="sflrsj"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身份证录入网点"  field="sfzlrwd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身份证录入人员"  field="sfzlrry"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身份证是否有磁"  field="sfzsfyc"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="婚姻状况"  field="hyzk"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="政治面貌"  field="zzmm"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="健康状况"  field="jkzk"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="病史详情"  field="bsxq"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="户口性质"  field="hkxz"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="犯罪记录"  field="fzjl"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="劳动关系"  field="ldgx"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="离职原因"  field="lzyy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="背景录入网点"  field="bjlrwd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="背景录入人员"  field="bjlrry"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="背景录入日期"  field="bjlrrq"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否获取过"  field="isMyLooked"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="300"></t:dgCol>
   <t:dgFunOpt exp="isMyLooked#eq#1" funname="delCgForm(id,isMyLooked)" title="联系方式" urlclass="ace_button" urlfont="fa-phone" urlStyle="background-color: #CCCCCC;"></t:dgFunOpt>
   <t:dgFunOpt exp="isMyLooked#eq#0" funname="delCgForm(id,isMyLooked)" title="联系方式" urlclass="ace_button" urlfont="fa-phone" urlStyle="background-color: red;"></t:dgFunOpt>
   <t:dgOpenOpt width="1150" height="600" url="jianliBusinessController.do?doResumeView&id={id}&viewFrom=jianli_business" title="查看简历" urlclass="ace_button" urlfont="fa-file" urlStyle="background-color: #1C86EE;"></t:dgOpenOpt>
   <t:dgFunOpt funname="startFlow(id)" title="发起招聘" urlclass="ace_button" urlfont="fa-play-circle" urlStyle="background-color: #00CD00;"></t:dgFunOpt>
  </t:datagrid>
  </div>
  </div>
 </div>
 <script src = "webpage/com/jeecg/qpwl/talentpool/jianliBusinessList.js"></script>		
 <script type="text/javascript">

function delCgForm(myID,type){//测试
    if(type == "1"){
    	createdialog('获取联系方式 ', '该简历您已经获取过联系方式，是否再次获取。获取联系方式将消耗1个积分', "jianliBusinessController.do?doQueryPhoneNo&id="+myID,"获取联系方式");
    }else{
    	createdialog('获取联系方式 ', '确定是否获取联系方式,获取联系方式将扣除1个积分', "jianliBusinessController.do?doQueryPhoneNo&id="+myID,"获取联系方式");
    }
	
}


function startFlow(myID){//起流程
	createdialog('提示', '确认是否对该人员发起招聘流程', "jianliBusinessController.do?doStartFlow&id="+myID,"起流程");
}

//导入
function ImportXls() {
	openuploadwin('Excel导入', 'jianliBusinessController.do?upload', "jianliBusinessList");
}

//导出
function ExportXls() {
	JeecgExcelExport("jianliBusinessController.do?exportXls","jianliBusinessList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("jianliBusinessController.do?exportXlsByT","jianliBusinessList");
}
function loadCrty(){
 	$.ajax({url:"selectViewController.do?citysProvince&provinceId="+$("#provinceid").val(),async:true});
}
 function loadTown(){
 	$.ajax({url:"selectViewController.do?townsCity&provinceId="+$("#cityid").val(),async:true});
 }
 	
 function loadJob2(){
 	$.ajax({url:"selectViewController.do?job1job2&provinceId="+$("#positionid").val(),async:true});
 }
 	
 function loadJob3(){
 	$.ajax({url:"selectViewController.do?job2job3&provinceId="+$("#jobid").val(),async:true});
 }
 function laodRemotData(){
   	//$("#panelloadingDiv").show();
 	jianliBusinessListsearch();
 	//$("#panelloadingDiv").hide();
 }
 function queryReset(){//重置
 	searchReset("jianliBusinessList");
 }
 function inputResume(){//简历录入
 	createwindow('简历录入', 'jianliOnlineController.do?goAdd',1150,600);
 }
 </script>