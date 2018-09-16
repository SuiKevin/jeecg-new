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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="jianliOnlineController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${jianliOnlinePage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">网站类型:</label>
			</td>
			<td class="value">
		     	 <input id="website" name="website" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.website}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">网站类型</label>
			</td>
			<td align="right">
				<label class="Validform_label">省份:</label>
			</td>
			<td class="value">
		     	 <input id="province" name="province" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.province}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">省份</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">城市:</label>
			</td>
			<td class="value">
		     	 <input id="city" name="city" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.city}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">城市</label>
			</td>
			<td align="right">
				<label class="Validform_label">区县:</label>
			</td>
			<td class="value">
		     	 <input id="town" name="town" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.town}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">区县</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">职位大类:</label>
			</td>
			<td class="value">
		     	 <input id="jobtype1" name="jobtype1" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.jobtype1}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">职位大类</label>
			</td>
			<td align="right">
				<label class="Validform_label">职位小类:</label>
			</td>
			<td class="value">
					  <input id="jobtype2" name="jobtype2" type="text" style="width: 150px"   ignore="ignore"  value='<fmt:formatDate value='${jianliOnlinePage.jobtype2}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">职位小类</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">职位详情:</label>
			</td>
			<td class="value">
		     	 <input id="jobtype3" name="jobtype3" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.jobtype3}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">职位详情</label>
			</td>
			<td align="right">
				<label class="Validform_label">姓名:</label>
			</td>
			<td class="value">
		     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.name}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">姓名</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">性别:</label>
			</td>
			<td class="value">
		     	 <input id="sex" name="sex" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.sex}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">性别</label>
			</td>
			<td align="right">
				<label class="Validform_label">年龄:</label>
			</td>
			<td class="value">
		     	 <input id="age" name="age" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${jianliOnlinePage.age}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">年龄</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">联系电话:</label>
			</td>
			<td class="value">
		     	 <input id="mobile" name="mobile" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.mobile}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">联系电话</label>
			</td>
			<td align="right">
				<label class="Validform_label">电子邮件:</label>
			</td>
			<td class="value">
		     	 <input id="email" name="email" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.email}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">电子邮件</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">学历:</label>
			</td>
			<td class="value">
		     	 <input id="xueli" name="xueli" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.xueli}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">学历</label>
			</td>
			<td align="right">
				<label class="Validform_label">工作经验:</label>
			</td>
			<td class="value">
		     	 <input id="gzjy" name="gzjy" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.gzjy}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">工作经验</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">籍贯:</label>
			</td>
			<td class="value">
		     	 <input id="jg" name="jg" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.jg}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">籍贯</label>
			</td>
			<td align="right">
				<label class="Validform_label">先居地:</label>
			</td>
			<td class="value">
		     	 <input id="xjzd" name="xjzd" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.xjzd}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">先居地</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">期望职位:</label>
			</td>
			<td class="value">
		     	 <input id="qwzw" name="qwzw" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.qwzw}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">期望职位</label>
			</td>
			<td align="right">
				<label class="Validform_label">目前职位:</label>
			</td>
			<td class="value">
		     	 <input id="mqzw" name="mqzw" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.mqzw}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">目前职位</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">期望薪资:</label>
			</td>
			<td class="value">
		     	 <input id="qwxz" name="qwxz" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.qwxz}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">期望薪资</label>
			</td>
			<td align="right">
				<label class="Validform_label">期望工作地:</label>
			</td>
			<td class="value">
		     	 <input id="qwgzd" name="qwgzd" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.qwgzd}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">期望工作地</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">个人标签:</label>
			</td>
			<td class="value">
		     	 <input id="grbq" name="grbq" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.grbq}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">个人标签</label>
			</td>
			<td align="right">
				<label class="Validform_label">自我评价:</label>
			</td>
			<td class="value">
		     	 <input id="zwpj" name="zwpj" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.zwpj}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">自我评价</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">详细工作经验:</label>
			</td>
			<td class="value">
		     	 <input id="xxgzjy" name="xxgzjy" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.xxgzjy}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">详细工作经验</label>
			</td>
			<td align="right">
				<label class="Validform_label">教育经历:</label>
			</td>
			<td class="value">
		     	 <input id="jyjl" name="jyjl" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.jyjl}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">教育经历</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">获得证书:</label>
			</td>
			<td class="value">
		     	 <input id="hdzs" name="hdzs" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.hdzs}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">获得证书</label>
			</td>
			<td align="right">
				<label class="Validform_label">更新时间:</label>
			</td>
			<td class="value">
		     	 <input id="gxsj" name="gxsj" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.gxsj}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">更新时间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">被浏览:</label>
			</td>
			<td class="value">
		     	 <input id="bllcs" name="bllcs" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.bllcs}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">被浏览</label>
			</td>
			<td align="right">
				<label class="Validform_label">查看过:</label>
			</td>
			<td class="value">
		     	 <input id="bckg" name="bckg" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.bckg}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">查看过</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">主动申请:</label>
			</td>
			<td class="value">
		     	 <input id="zdsq" name="zdsq" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.zdsq}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">主动申请</label>
			</td>
			<td align="right">
				<label class="Validform_label">对他感兴趣:</label>
			</td>
			<td class="value">
		     	 <input id="dtgxq" name="dtgxq" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.dtgxq}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">对他感兴趣</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">被下载:</label>
			</td>
			<td class="value">
		     	 <input id="bxzcs" name="bxzcs" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.bxzcs}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">被下载</label>
			</td>
			<td align="right">
				<label class="Validform_label">收到邀请:</label>
			</td>
			<td class="value">
		     	 <input id="sdyq" name="sdyq" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.sdyq}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">收到邀请</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">录入时间:</label>
			</td>
			<td class="value">
		     	 <input id="lrsj" name="lrsj" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.lrsj}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">录入时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">证件照片:</label>
			</td>
			<td class="value">
		     	 <input id="zjzp" name="zjzp" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.zjzp}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">证件照片</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">录入方式:</label>
			</td>
			<td class="value">
		     	 <input id="lrfs" name="lrfs" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.lrfs}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">录入方式</label>
			</td>
			<td align="right">
				<label class="Validform_label">录入网点:</label>
			</td>
			<td class="value">
		     	 <input id="lrwd" name="lrwd" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.lrwd}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">录入网点</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">录入人员:</label>
			</td>
			<td class="value">
		     	 <input id="lrry" name="lrry" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.lrry}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">录入人员</label>
			</td>
			<td align="right">
				<label class="Validform_label">身份证号:</label>
			</td>
			<td class="value">
		     	 <input id="sfzh" name="sfzh" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.sfzh}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">身份证号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">民族:</label>
			</td>
			<td class="value">
		     	 <input id="mz" name="mz" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.mz}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">民族</label>
			</td>
			<td align="right">
				<label class="Validform_label">出生日期:</label>
			</td>
			<td class="value">
		     	 <input id="csrq" name="csrq" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.csrq}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">出生日期</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">住址:</label>
			</td>
			<td class="value">
		     	 <input id="address" name="address" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.address}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">住址</label>
			</td>
			<td align="right">
				<label class="Validform_label">签发机关:</label>
			</td>
			<td class="value">
		     	 <input id="fzjg" name="fzjg" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.fzjg}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">签发机关</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">有效期:</label>
			</td>
			<td class="value">
		     	 <input id="yxq" name="yxq" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.yxq}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">有效期</label>
			</td>
			<td align="right">
				<label class="Validform_label">身份录入时间:</label>
			</td>
			<td class="value">
		     	 <input id="sflrsj" name="sflrsj" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.sflrsj}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">身份录入时间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">身份证录入网点:</label>
			</td>
			<td class="value">
		     	 <input id="sfzlrwd" name="sfzlrwd" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.sfzlrwd}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">身份证录入网点</label>
			</td>
			<td align="right">
				<label class="Validform_label">身份证录入人员:</label>
			</td>
			<td class="value">
		     	 <input id="sfzlrry" name="sfzlrry" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.sfzlrry}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">身份证录入人员</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">身份证是否有磁:</label>
			</td>
			<td class="value">
		     	 <input id="sfzsfyc" name="sfzsfyc" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.sfzsfyc}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">身份证是否有磁</label>
			</td>
			<td align="right">
				<label class="Validform_label">婚姻状况:</label>
			</td>
			<td class="value">
		     	 <input id="hyzk" name="hyzk" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.hyzk}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">婚姻状况</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">政治面貌:</label>
			</td>
			<td class="value">
		     	 <input id="zzmm" name="zzmm" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.zzmm}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">政治面貌</label>
			</td>
			<td align="right">
				<label class="Validform_label">健康状况:</label>
			</td>
			<td class="value">
		     	 <input id="jkzk" name="jkzk" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.jkzk}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">健康状况</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">病史详情:</label>
			</td>
			<td class="value">
		     	 <input id="bsxq" name="bsxq" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.bsxq}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">病史详情</label>
			</td>
			<td align="right">
				<label class="Validform_label">户口性质:</label>
			</td>
			<td class="value">
		     	 <input id="hkxz" name="hkxz" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.hkxz}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">户口性质</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">犯罪记录:</label>
			</td>
			<td class="value">
		     	 <input id="fzjl" name="fzjl" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.fzjl}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">犯罪记录</label>
			</td>
			<td align="right">
				<label class="Validform_label">劳动关系:</label>
			</td>
			<td class="value">
		     	 <input id="ldgx" name="ldgx" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.ldgx}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">劳动关系</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">离职原因:</label>
			</td>
			<td class="value">
		     	 <input id="lzyy" name="lzyy" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.lzyy}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">离职原因</label>
			</td>
			<td align="right">
				<label class="Validform_label">背景录入网点:</label>
			</td>
			<td class="value">
		     	 <input id="bjlrwd" name="bjlrwd" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.bjlrwd}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">背景录入网点</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">背景录入人员:</label>
			</td>
			<td class="value">
		     	 <input id="bjlrry" name="bjlrry" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.bjlrry}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">背景录入人员</label>
			</td>
			<td align="right">
				<label class="Validform_label">背景录入日期:</label>
			</td>
			<td class="value">
		     	 <input id="bjlrrq" name="bjlrrq" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${jianliOnlinePage.bjlrrq}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">背景录入日期</label>
			</td>
		</tr>
	
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="jianliOnlineController.do?jinaliZhengshuList&id=${jianliOnlinePage.id}"  title="获取证书" id="jinaliZhengshu"></t:tab>
				 <t:tab href="jianliOnlineController.do?jianliJiaoyuList&id=${jianliOnlinePage.id}"  title="学历教育" id="jianliJiaoyu"></t:tab>
				 <t:tab href="jianliOnlineController.do?jianliJingyanList&id=${jianliOnlinePage.id}"  title="工作经验" id="jianliJingyan"></t:tab>
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
							<input name="jinaliZhengshuList[#index#].hqrq" maxlength="20" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" />
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
							<input name="jianliJiaoyuList[#index#].bysj" maxlength="50" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" />
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
							<input name="jianliJingyanList[#index#].kssj" maxlength="20" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">开始日期</label>
				  </td>
				  <td align="left">
							<input name="jianliJingyanList[#index#].jsrq" maxlength="50" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">结束日期</label>
				  </td>
				  <td align="left">
					  		<input name="jianliJingyanList[#index#].xzsp" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">薪资水平</label>
				  </td>
				  <td align="left">
					  		<input name="jianliJingyanList[#index#].zzzw" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">在职职位</label>
				  </td>
				  <td align="left">
					  		<input name="jianliJingyanList[#index#].gzzz" maxlength="4000" type="text" class="inputxt"  style="width:400px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">工作职责</label>
				  </td>

			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/jeecg/qpwl/talentpool/jianliOnline.js"></script>	
