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
		     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">姓名</label>
			</td>
			<td align="right">
				<label class="Validform_label">性别:</label>
			</td>
			<td class="value">
		     	 <input id="sex" name="sex" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">性别</label>
			</td>
			<td align="right">
				<label class="Validform_label">年龄:</label>
			</td>
			<td class="value">
		     	 <input id="age" name="age" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">年龄</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">学历:</label>
			</td>
			<td class="value">
		     	 <input id="xueli" name="xueli" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">学历</label>
			</td>
			<td align="right">
				<label class="Validform_label">联系电话:</label>
			</td>
			<td class="value">
		     	 <input id="mobile" name="mobile" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">联系电话</label>
			</td>
			<td align="right">
				<label class="Validform_label">电子邮件:</label>
			</td>
			<td class="value">
		     	 <input id="email" name="email" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">电子邮件</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">省份:</label>
			</td>
			<td class="value">
		     	 <input id="province" name="province" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">省份</label>
			</td>
			<td align="right">
				<label class="Validform_label">城市:</label>
			</td>
			<td class="value">
		     	 <input id="city" name="city" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">城市</label>
			</td>
			<td align="right">
				<label class="Validform_label">区县:</label>
			</td>
			<td class="value">
		     	 <input id="town" name="town" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">区县</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">信息来源:</label>
			</td>
			<td class="value">
		     	 <input id="website" name="website" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">信息来源</label>
			</td>
			<td align="right">
				<label class="Validform_label">工作经验:</label>
			</td>
			<td class="value">
		     	 <input id="gzjy" name="gzjy" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
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
		     	 <input id="qwxz" name="qwxz" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
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
		     	 <input id="jobtype1" name="jobtype1" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">职位大类</label>
			</td>
			<td align="right">
				<label class="Validform_label">职位小类:</label>
			</td>
			<td class="value">
					  <input id="jobtype2" name="jobtype2" type="text" style="width: 150px" class="inputxt"   ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">职位小类</label>
			</td>
			<td align="right">
				<label class="Validform_label">职位详情:</label>
			</td>
			<td class="value">
		     	 <input id="jobtype3" name="jobtype3" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
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
				<label class="Validform_label">先居地:</label>
			</td>
			<td class="value">
		     	 <input id="xjzd" name="xjzd" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">先居地</label>
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
			<h3>身份证信息</h3>
		</div>
		<div style="width:95%;margin-left: 2.5%;margin-top: 10px;margin-bottom: 10px;">
		<table cellpadding="0" cellspacing="1" class="formtable">
		 <tr>
		 	<td align="right">
				<label class="Validform_label">身份证号:</label>
			</td>
			<td class="value">
		     	 <input id="sfzh" name="sfzh" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">身份证号</label>
			</td>
						<td align="right">
				<label class="Validform_label">民族:</label>
			</td>
			<td class="value">
		     	 <input id="mz" name="mz" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">民族</label>
			</td>
			<td align="right">
				<label class="Validform_label">出生日期:</label>
			</td>
			<td class="value">
		     	 <input id="csrq" name="csrq" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">出生日期</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">住址:</label>
			</td>
			<td class="value">
		     	 <input id="address" name="address" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">住址</label>
			</td>
			<td align="right">
				<label class="Validform_label">签发机关:</label>
			</td>
			<td class="value">
		     	 <input id="fzjg" name="fzjg" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">签发机关</label>
			</td>
			<td align="right">
				<label class="Validform_label">有效期:</label>
			</td>
			<td class="value">
		     	 <input id="yxq" name="yxq" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">有效期</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">身份录入时间:</label>
			</td>
			<td class="value">
		     	 <input id="sflrsj" name="sflrsj" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">身份录入时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">身份证录入网点:</label>
			</td>
			<td class="value">
		     	 <input id="sfzlrwd" name="sfzlrwd" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">身份证录入网点</label>
			</td>
			<td align="right">
				<label class="Validform_label">身份证录入人员:</label>
			</td>
			<td class="value">
		     	 <input id="sfzlrry" name="sfzlrry" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">身份证录入人员</label>
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
		     	 <input id="sfzsfyc" name="sfzsfyc" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">身份证是否有磁</label>
			</td>
			<td align="right">
				<label class="Validform_label">婚姻状况:</label>
			</td>
			<td class="value">
		     	 <input id="hyzk" name="hyzk" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">婚姻状况</label>
			</td>
			<td align="right">
				<label class="Validform_label">政治面貌:</label>
			</td>
			<td class="value">
		     	 <input id="zzmm" name="zzmm" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">政治面貌</label>
			</td>
		</tr>
		
		<tr>
			<td align="right">
				<label class="Validform_label">健康状况:</label>
			</td>
			<td class="value">
		     	 <input id="jkzk" name="jkzk" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
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
		     	 <input id="hkxz" name="hkxz" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">户口性质</label>
			</td>
			<td align="right">
				<label class="Validform_label">犯罪记录:</label>
			</td>
			<td class="value">
		     	 <input id="fzjl" name="fzjl" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">犯罪记录</label>
			</td>
			<td align="right">
				<label class="Validform_label">劳动关系:</label>
			</td>
			<td class="value">
		     	 <input id="ldgx" name="ldgx" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">劳动关系</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">离职原因:</label>
			</td>
			<td class="value">
		     	 <input id="lzyy" name="lzyy" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">离职原因</label>
			</td>
			<td align="right">
				<label class="Validform_label">背景录入网点:</label>
			</td>
			<td class="value" colspan="3">
		     	 <input id="bjlrwd" name="bjlrwd" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">背景录入网点</label>
			</td>
		</tr>
		</table>
		</div>
	</div>
	<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="jianliOnlineController.do?jinaliZhengshuList&id=${jianliOnlinePage.id}" icon="icon-search" title="获取证书" id="jinaliZhengshu"></t:tab>
				 <t:tab href="jianliOnlineController.do?jianliJiaoyuList&id=${jianliOnlinePage.id}" icon="icon-search" title="学历教育" id="jianliJiaoyu"></t:tab>
				 <t:tab href="jianliOnlineController.do?jianliJingyanList&id=${jianliOnlinePage.id}" icon="icon-search" title="工作经验" id="jianliJingyan"></t:tab>
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
 </body>
 <script src = "webpage/com/jeecg/qpwl/talentpool/jianliOnline.js"></script>
	