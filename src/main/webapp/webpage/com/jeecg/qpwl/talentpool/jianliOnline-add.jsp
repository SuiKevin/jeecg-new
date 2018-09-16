<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>实时人才库</title>
    <style>
  .ui-button {
  	  display: inline-block;
	  padding: 2px 2px;
	  margin-bottom: 0;
	  font-size: 8px;
	  font-weight: normal;
	  line-height: 1.42857143;
	  text-align: center;
	  white-space: nowrap;
	  vertical-align: middle;
	  -ms-touch-action: manipulation;
      touch-action: manipulation;
	  cursor: pointer;
	  -webkit-user-select: none;
      -moz-user-select: none;
      -ms-user-select: none;
      user-select: none;
	  background-image: none;
	  border: 1px solid transparent;
	  border-radius: 4px;
  }
  </style>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
  });
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="jianliOnlineController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${jianliOnlinePage.id }"/>
	<div>
		<div>
			<h3>求职者基本信息</h3>
		</div>
		<div  style="width:95%;margin-left: 2.5%;margin-top: 10px;margin-bottom: 10px;">
			<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">姓名:</label>
			</td>
			<td class="value">
		     	 <input id="name" name="name" type="text" style="width: 150px" datatype="*" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">姓名</label>
			</td>
			<td align="right">
				<label class="Validform_label">性别:</label>
			</td>
			<td class="value">
		     	 <t:dictSelect field="sex" type="radio"  datatype="*"   typeGroupCode="sex2"  defaultVal="${jianliBusinessPage.sex}" hasLabel="false"  title="性别" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">性别</label>
			</td>
			<td align="right">
				<label class="Validform_label">年龄:</label>
			</td>
			<td class="value">
		     	 <input id="age" name="age" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  datatype="*"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">年龄</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">学历:</label>
			</td>
			<td class="value">
				<t:dictSelect field="xueli" type="list" datatype="*"  typeGroupCode="edu"  hasLabel="false"  title="学历" ></t:dictSelect> 
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">学历</label>
			</td>
			<td align="right">
				<label class="Validform_label">联系电话:</label>
			</td>
			<td class="value">
		     	 <input id="mobile" name="mobile" type="text" style="width: 150px" class="inputxt" datatype="m" ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">联系电话</label>
			</td>
			<td align="right">
				<label class="Validform_label">电子邮件:</label>
			</td>
			<td class="value">
		     	 <input id="email" name="email" type="text" style="width: 150px" class="inputxt" datatype="e" ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">电子邮件</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">省份:</label>
			</td>
			<td class="value">
				<input id="provinceid" name="provinceid" type="hidden" value="${provinceid}"/>
               	<input name="province" id="provincename" class="inputxt" readonly="readonly" datatype="*" />
                <t:choose hiddenName="provinceid" hiddenid="provinceid" textname="provincename" url="selectViewController.do?provinces" name="provincesList" icon="icon-search" title="选择省份" isclear="false" isInit="true" fun="loadCrty"></t:choose>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">省份</label>
			</td>
			<td align="right">
				<label class="Validform_label">城市:</label>
			</td>
			<td class="value">
		     	<input id="cityid" name="cityid" type="hidden"/>
               	<input name="city" id="cityname" class="inputxt" readonly="readonly" datatype="*" />
                <t:choose hiddenName="cityid" hiddenid="cityid" textname="cityname" url="selectViewController.do?citys" name="cityList" icon="icon-search" title="选择城市" isclear="false" isInit="true" fun="loadTown" ></t:choose>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">城市</label>
			</td>
			<td align="right">
				<label class="Validform_label">区县:</label>
			</td>
			<td class="value">
		     	<input id="townId" name="townId" type="hidden"/>
               	<input name="town" id="townname" class="inputxt" readonly="readonly" datatype="*" />
                <t:choose hiddenName="townId" hiddenid="townId" textname="townname" url="selectViewController.do?towns" name="townList" icon="icon-search" title="选择区县" isclear="false" isInit="true"></t:choose>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">区县</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">信息来源:</label>
			</td>
			<td class="value">
		     	 <input id="website" name="website"  readonly="readonly" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value="门店录入"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">信息来源</label>
			</td>
			<td align="right">
				<label class="Validform_label">工作经验:</label>
			</td>
			<td class="value">
		     	<t:dictSelect field="gzjy" type="list"   typeGroupCode="gzjy"  hasLabel="false"  title="工作经验" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">工作经验</label>
			</td>
			<td align="right">
				<label class="Validform_label">目前职位:</label>
			</td>
			<td class="value">
		     	 <input id="mqzw" name="mqzw" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">目前职位</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">期望职位:</label>
			</td>
			<td class="value">
		     	 <input id="qwzw" name="qwzw" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">期望职位</label>
			</td>
			<td align="right">
				<label class="Validform_label">期望薪资:</label>
			</td>
			<td class="value">
		     	<t:dictSelect field="qwxz" type="list"   typeGroupCode="qwxz"  hasLabel="false"  title="期望薪资" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">期望薪资</label>
			</td>
			<td align="right">
				<label class="Validform_label">期望工作地:</label>
			</td>
			<td class="value">
		     	 <input id="qwgzd" name="qwgzd" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">期望工作地</label>
			</td>

		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">职位大类:</label>
			</td>
			<td class="value">
				<input id="positionid" name="positionid" type="hidden"/>
               	<input name="jobtype1" id="positionname" class="inputxt" readonly="readonly" datatype="*" />
                <t:choose hiddenName="positionid" hiddenid="positionid" textname="positionname" url="selectViewController.do?jobpositions" name="jobpositionList" icon="icon-search" title="职位大类" isclear="false" isInit="true" fun="loadJob2" ></t:choose>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">职位大类</label>
			</td>
			<td align="right">
				<label class="Validform_label">职位小类:</label>
			</td>
			<td class="value">
				<input id="jobid" name="jobid" type="hidden"/>
               	<input name="jobtype2" id="jobname" class="inputxt" readonly="readonly" datatype="*" />
                <t:choose hiddenName="jobid" hiddenid="jobid" textname="jobname" url="selectViewController.do?jobs" name="jobList" icon="icon-search" title="职位小类" isclear="false" isInit="true" fun="loadJob3" ></t:choose>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">职位小类</label>
			</td>
			<td align="right">
				<label class="Validform_label">职位详情:</label>
			</td>
			<td class="value">
				<input id="jobdesccode" name="jobdesccode" type="hidden"/>
               	<input name="jobtype3" id="jobdescname" class="inputxt" readonly="readonly" datatype="*" />
                <t:choose hiddenName="jobdesccode" hiddenid="jobdesccode" textname="jobdescname" url="selectViewController.do?jobdescriptios" name="jobdescriptionList" icon="icon-search" title="职位描述" isclear="false" isInit="true"></t:choose>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">职位详情</label>
			</td>
		</tr>		
		<tr>
			<td align="right">
				<label class="Validform_label">籍贯:</label>
			</td>
			<td class="value">
		     	 <input id="jg" name="jg" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">籍贯</label>
			</td>
			<td align="right">
				<label class="Validform_label">现居地:</label>
			</td>
			<td class="value">
		     	 <input id="xjzd" name="xjzd" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">现居地</label>
			</td>
			<td align="right">
				<label class="Validform_label">个人标签:</label>
			</td>
			<td class="value">
		     	 <input id="grbq" name="grbq" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">个人标签</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">自我评价:</label>
			</td>
			<td class="value" colspan="5">
		     	<textarea id="zwpj" name="zwpj" style="width:99.5%;height: 100%;" class="inputxt" rows="10"  datatype="*"  ignore="ignore" ></textarea>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">自我评价</label>
			</td>
		</tr>
		</table>
		</div>
	</div>
	<div class="addcont addexpe">
		<div class="modtab">
			<h3>身份证信息 &nbsp;<input class="btn" type="button" value="读取身份证" style="height:25px;width:120px !important;border-radius:5px;background-color: #6699FF;color: white;" onClick="readIdCard()">
		</div>
		<div style="width:95%;margin-left: 2.5%;margin-top: 10px;margin-bottom: 10px;">
		<table cellpadding="0" cellspacing="1" class="formtable">
		 <tr>
		 	<td align="right">
				<label class="Validform_label">身份证号:</label>
			</td>
			<td class="value">
		     	<input id="sfzh" name="sfzh" type="text" readonly="readonly" style="width: 200px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">身份证号</label>
			</td>
						<td align="right">
				<label class="Validform_label">民族:</label>
			</td>
			<td class="value">
		     	 <input id="mz" name="mz" type="text" readonly="readonly" style="width: 200px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">民族</label>
			</td>
			<td align="right">
				<label class="Validform_label">出生日期:</label>
			</td>
			<td class="value">
		     	 <input id="csrq" name="csrq" type="text" readonly="readonly" style="width: 200px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">出生日期</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">住址:</label>
			</td>
			<td class="value">
		     	 <input id="address" name="address" type="text" readonly="readonly" style="width: 200px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">住址</label>
			</td>
			<td align="right">
				<label class="Validform_label">签发机关:</label>
			</td>
			<td class="value">
		     	 <input id="fzjg" name="fzjg" type="text" readonly="readonly" style="width: 200px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">签发机关</label>
			</td>
			<td align="right">
				<label class="Validform_label">有效期:</label>
			</td>
			<td class="value">
		     	 <input id="yxq" name="yxq" type="text" readonly="readonly" style="width: 200px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">有效期</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">身份录入时间:</label>
			</td>
			<td class="value" colspan="5">
		     	 <input id="sflrsj" name="sflrsj" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">身份录入时间</label>
			</td>
		</tr>
		</table>
		</div>
	</div>
	<div class="addcont addexpe">
		<div class="modtab">
			<h3>背景信息</h3>
		</div>
		<div style="width:95%;margin-left: 2.5%;margin-top: 10px;margin-bottom: 10px;">
		<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">身份证是否有磁:</label>
			</td>
			<td class="value">
		     	<t:dictSelect field="sfzsfyc" type="list"   typeGroupCode="sfzsfyc"  hasLabel="false"  title="身份证是否有磁" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">身份证是否有磁</label>
			</td>
			<td align="right">
				<label class="Validform_label">婚姻状况:</label>
			</td>
			<td class="value">
		     	  <t:dictSelect field="hyzk" type="list"   typeGroupCode="hyzk"  defaultVal="${jianliBusinessPage.hyzk}" hasLabel="false"  title="婚姻状况" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">婚姻状况</label>
			</td>
			<td align="right">
				<label class="Validform_label">政治面貌:</label>
			</td>
			<td class="value">
		     	<t:dictSelect field="zzmm" type="list"   typeGroupCode="zzmm"  defaultVal="${jianliBusinessPage.zzmm}" hasLabel="false"  title="政治面貌" ></t:dictSelect> 
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">政治面貌</label>
			</td>
		</tr>
		
		<tr>
			<td align="right">
				<label class="Validform_label">健康状况:</label>
			</td>
			<td class="value">
		     	  <t:dictSelect field="jkzk" type="list"   typeGroupCode="jkzk"  defaultVal="${jianliBusinessPage.jkzk}" hasLabel="false"  title="健康状况" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">健康状况</label>
			</td>
			<td align="right">
				<label class="Validform_label">病史详情:</label>
			</td>
			<td class="value" colspan="3">
		     	 <input id="bsxq" name="bsxq" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">病史详情</label>
			</td>
		</tr>
		<tr>
			
			<td align="right">
				<label class="Validform_label">户口性质:</label>
			</td>
			<td class="value">
		     	 <t:dictSelect field="hkxz" type="list"   typeGroupCode="hkxz"  defaultVal="${jianliBusinessPage.hkxz}" hasLabel="false"  title="户口性质" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">户口性质</label>
			</td>
			<td align="right">
				<label class="Validform_label">犯罪记录:</label>
			</td>
			<td class="value">
		     	 <t:dictSelect field="fzjl" type="list"   typeGroupCode="fzjl"  defaultVal="${jianliBusinessPage.fzjl}" hasLabel="false"  title="犯罪记录" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">犯罪记录</label>
			</td>
			<td align="right">
				<label class="Validform_label">劳动关系:</label>
			</td>
			<td class="value">
		     	 <t:dictSelect field="ldgx" type="list"   typeGroupCode="ldgx"  defaultVal="${jianliBusinessPage.ldgx}" hasLabel="false"  title="劳动关系" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">劳动关系</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">离职原因:</label>
			</td>
			<td class="value" colspan="5">
		     	  <t:dictSelect field="lzyy" type="list"   typeGroupCode="lzyy"  defaultVal="${jianliBusinessPage.lzyy}" hasLabel="false"  title="离职原因" ></t:dictSelect> 
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">离职原因</label>
			</td>
		</tr>
		</table>
		</div>
	</div>
	<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="jianliOnlineController.do?jinaliZhengshuList&id=${jianliOnlinePage.id}" icon="pencil" title="获取证书" id="jinaliZhengshu"></t:tab>
				 <t:tab href="jianliOnlineController.do?jianliJiaoyuList&id=${jianliOnlinePage.id}" icon="pencil" title="学历教育" id="jianliJiaoyu"></t:tab>
				 <t:tab href="jianliOnlineController.do?jianliJingyanList&id=${jianliOnlinePage.id}" icon="pencil" title="工作经验" id="jianliJingyan"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_jinaliZhengshu_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="jinaliZhengshuList[#index#].zhengshu" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">证书</label>
				  </td>
				  <td align="left">
							<input name="jinaliZhengshuList[#index#].hqrq" maxlength="20" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">获证日期</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_jianliJiaoyu_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="jianliJiaoyuList[#index#].xuexiao" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">学校</label>
				  </td>
				  <td align="left">
					  	<input name="jianliJiaoyuList[#index#].zhuanye" maxlength="20" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">专业</label>
				  </td>
				  <td align="left">
							<input name="jianliJiaoyuList[#index#].bysj" maxlength="50" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">毕业时间</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_jianliJingyan_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="jianliJingyanList[#index#].gzdw" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">工作单位</label>
				  </td>
				  <td align="left">
							<input name="jianliJingyanList[#index#].kssj" maxlength="20" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">开始日期</label>
				  </td>
				  <td align="left">
							<input name="jianliJingyanList[#index#].jsrq" maxlength="50" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">结束日期</label>
				  </td>
				  <td align="left">
					  	<input name="jianliJingyanList[#index#].xzsp" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">薪资水平</label>
				  </td>
				  <td align="left">
					  	<input name="jianliJingyanList[#index#].zzzw" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">在职职位</label>
				  <td align="left">
				        <textarea id="inviteRemarks" style="width:100%;height: 100px" class="inputxt" rows="10" name="jianliJingyanList[#index#].gzzz"  datatype="*"  ignore="ignore" >
				        </textarea>
					  	<!-- 
					  	<input name="jianliJingyanList[#index#].gzzz" maxlength="4000" type="text" class="inputxt"  style="width:400px;"  ignore="ignore" />
					  	 -->
					  <label class="Validform_label" style="display: none;">工作职责</label>
				  </td>

				  </td>
			</tr>
		 </tbody>
		</table>
		<OBJECT ID="ID100Control" CLASSID="CLSID:BAD80877-E3D2-41CC-91AE-C7FD9D019E36"></OBJECT>
 </body>
 <script type="text/javascript">
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
 	
 	function readIdCard(){//读取身份证信息
 		if(ID100Control.Connect()){
 			alert("身份证读卡器连接成功");
 			var obj = ID100Control.ReadContentEx();
 			obj = JSON.parse(obj);
 			//设置身份证号
 			$("#sfzh").val(obj.info.cardno);
 			$("#mz").val(obj.info.nation);
 			$("#csrq").val(obj.info.birth);
 			$("#address").val(obj.info.address);
 			$("#fzjg").val(obj.info.org);
 			$("#yxq").val(obj.info.validata);
 			$("#name").val(obj.info.name);
 			ID100Control.DisConnect();
 		}else{
 		 	alert("身份证读卡器连接失败");
 		}
 	}
 </script>
 <script src = "webpage/com/jeecg/qpwl/talentpool/jianliOnline.js"></script>
	