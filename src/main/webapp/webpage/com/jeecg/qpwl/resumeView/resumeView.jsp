<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>秦聘网络简历展示</title>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
	<meta http-equiv="expires" content="0">
	<script type="text/javascript" async="" src="webpage/com/jeecg/qpwl/resumeView/css/statistic.js"></script><script src="webpage/com/jeecg/qpwl/resumeView/css/hm.js"></script><script type="text/javascript" charset="utf-8">
		var timeTrak = {
			starttime: new Date().getTime(),//开始位置时间
			load_time: 0,//页面加载完位置
			cdn_time: 0,
			bp_time: "", //白屏时间
			sp_time: "", //首屏时间
			cz_time: "", //可操作时间
			pagetype: "resume_detail",
			city: "",//城市
			net_speed: "",
			net_type: "",//网络类型
			template_type: "detail_new",//模板类型
			connection: navigator.connection || navigator.mozConnection || navigator.webkitConnection || {type: 'unknown'},
			gettime: function () {
				return (new Date().getTime());
			}
		};
		document.addEventListener("DOMContentLoaded", function (e) {
			timeTrak.cz_time = timeTrak.gettime() - timeTrak.starttime;
		});
		window.addEventListener("load", function () {
			timeTrak.load_time = timeTrak.gettime() - timeTrak.starttime;
			timeTrak.imgLoad && timeTrak.imgLoad();
		});
	</script>
	<link type="text/css" rel="stylesheet" charset="utf-8" href="webpage/com/jeecg/qpwl/resumeView/css/public2012_v20160921010946.css">
	<link type="text/css" rel="stylesheet" charset="utf-8" href="webpage/com/jeecg/qpwl/resumeView/css/resume-detail_v20170321184746.css">
	<link type="text/css" rel="stylesheet" charset="utf-8" href="webpage/com/jeecg/qpwl/resumeView/css/screening_v20151119214831.css">
	<style charset="utf-8" type="text/css" media="print">.history, .gongneng, .comcss, .cssscore {  display: none  }</style>
	<%--<script type="text/javascript" language="javascript">document.domain = ""; </script>--%>
</head>
<body class="pvpbg">
<script type="text/javascript">
	timeTrak.bp_time = timeTrak.gettime() - timeTrak.starttime;
</script>
<div id="jplayerBox"></div>
<div id="login-header">
	<div id="login-header-content">
		<div class="rp_nav">
                <span>
                    <a href="#">秦聘网络简历</a>&gt;
                </span>
		</div>
	</div>
</div>
<div class="vipResMain clearfix">
	<div class="vipResContent resume_preview">
		<div class="resDetailRight">
			<h1 class="resTitle">
				<input style="display:none" id="hideRid" value="3_nerQ_eZsnv6QTeZXneZNlE6XnvZfneHsnena_E65lEnNTvyaTe6alETkneypMGnaMGyf_-5f_isfnErsnEzkneZvnEm*">
				<span class="name">${jianliOnlinePage.name}</span>
				<span class="sexAge">（${jianliOnlinePage.sex}，${jianliOnlinePage.age}岁）</span>
				<span class="vip-icon ">普通</span>	
				<span class="sexAge">（简历被下载过${jianliOnlinePage.lookNum}次）</span>																																																																				</h1>
			<div class="kindTips" id="warnTips" style="display:none"></div>
			<div class="kindTips" id="warnTips2" style="display:none"></div>

			<div class="certificate">
				<div class="certificate-title">我的认证：</div>
				<div class="certificate-list">
					<ul>
						<li>
							<i class="icon-mobile  on "></i>
							<span class="noCertificate" id="authPhone" style="cursor: pointer;">手机认证</span>
						</li>
						<li>
							<i class="icon-id "></i>
							<span class="noCertificate turnToCertList" style="cursor: pointer;">身份认证</span>
						</li>
						<li>
							<i class="icon-wechat  on "></i>
							<span class="noCertificate" id="authWechat" style="cursor: pointer;">微信认证</span>
						</li>
						<li>
							<i class="icon-zhima "></i>
							<span class="noCertificate turnToCertList" style="cursor: pointer;">芝麻认证</span>
						</li>
						<li>
							<i class="icon-edu "></i>
							<span class="noCertificate turnToCertList" style="cursor: pointer;">学历认证</span>
						</li>
					</ul>
				</div>
			</div>

			<div class="expectInfo">
				<div class="expectTitle">
					<dl>
						<dt class="fb f-58">基本情况：</dt>
						<dd>
							<ul class="expectDetail">
								<li>${jianliOnlinePage.xueli}</li>
								<li class="divide">|</li>
								<li>${jianliOnlinePage.gzjy}工作经验</li>
								<li class="divide">|</li>
								<li>${jianliOnlinePage.xjzd}</li>
								<li class="divide">|</li>
								<li>${jianliOnlinePage.jg}</li>
							</ul>
						</dd>
					</dl>
					<dl>
						<dt class="fb f-58">求职意向：</dt>
						<dd>
							<ul class="expectDetail">
								<li class="pl0">${jianliOnlinePage.qwzw}</li>
								<li class="divide">|</li>
								<li>${jianliOnlinePage.qwgzd}</li>
								<li class="divide">|</li>
								<li class="br0">期望薪资${jianliOnlinePage.qwxz}</li>
							</ul>
						</dd>
					</dl>
					<dl>
					<dt class="fb f-58">联系方式：</dt>
						<dd>
							<ul class="expectDetail">
								<li class="br0">tel：${jianliOnlinePage.mobile}</li>
								<li class="divide">|</li>
								<li class="br0">email：${jianliOnlinePage.email}</li>
							</ul>
						</dd>
					</dl>
				</div>

				
					<div class="intrCon">
						${jianliOnlinePage.zwpj}
					</div>
					<!-- 在校情况
					<ul class="cbright">
							<li>
								<div class="cbbg1"><span class="fl">县市级二等奖学金2次</span></div>
							</li>
					</ul>
					 -->
				<div id="contviewfunc" class="cb">
					<div class="cvbtg">
						<div class="cv_dtl" style="display:block">
							<ul class="summ">
								<li class="br0">
									<span class="sth"></span>
									<!-- 此处是原来的联系方式位置 -->
								</li>
							</ul>
						</div>
					</div>
				<p class="protect-icon-mes">该求职者已开启号码保护，此联系方式为通话密号替代真实手机号</p></div>
			</div>
			<div class="addcont addexpe">
				<div class="modtab">
					<h3>工作经验</h3>
					<span>&nbsp;&nbsp;&nbsp;(做了${fn:length(jianliOnlinePage.jianliJingyanList)}份工作)</span>
				</div>
				<c:if test="${fn:length(jianliOnlinePage.jianliJingyanList)  > 0 }">
						<c:forEach items="${jianliOnlinePage.jianliJingyanList}" var="poVal" varStatus="stuts">
							<div class="infoview noborder">
							<h4>${poVal.gzdw}</h4>
							<p class="pst">
								<span class="sth">工作时间：</span>
								<span class="std"><fmt:formatDate value='${poVal.kssj}' type="date" pattern="yyyy年MM月"/>——<fmt:formatDate value='${poVal.jsrq}' type="date" pattern="yyyy年MM月"/></span>
							</p>
							<p class="pst">
								<span class="sth">薪资水平：</span>
								<span class="std">${poVal.xzsp}</span>
							</p>
							<p class="pst">
								<span class="sth">在职职位：</span>
								<span class="std">${poVal.zzzw}</span>
							</p>
							<p class="pst2">
								<span class="sth">工作职责：</span>
								<span class="std">${poVal.gzzz}</span>
						</p>
					</div>
					</c:forEach>
				</c:if>	
		</div>
			
		<div class="addcont addeduc">
				<div class="modtab">
					<h3>学历教育</h3>
				</div>
				<div class="infoview noborder">
					<c:if test="${fn:length(jianliOnlinePage.jianliJiaoyuList)  > 0 }">
					<c:forEach items="${jianliOnlinePage.jianliJiaoyuList}" var="poVal" varStatus="stuts">
							<ul class="summ">
								<li><fmt:formatDate value='${poVal.bysj}' type="date" pattern="yyyy年MM月"/>毕业</li>
								<li>${poVal.xuexiao}</li>
								<li class="noborder">${poVal.zhuanye}</li>
							</ul>
					</c:forEach>
					</c:if>	
				</div>
		</div>
		<div class="addcont addatsch">
			<div class="modtab">
				<h3>在校情况</h3>
			</div>
			<!-- 
			<div class="infoview">
				<p class="pst2">
					<span class="sth">获奖学金：</span>
                    <span class="std">县市级二等奖2次</span>
				</p>
			</div>
			 -->
		 </div>
		<div class="addcont addlan">
			 <div class="modtab">
				<h3>语言能力</h3>
			 </div>
			 <!-- 
			 <div class="infoview">
						<p class="pst2">
							<span class="sth">日语：</span>
                        	<span class="std">
                              	<span>听说一般</span>
							  	<span>读写一般</span>
							 	<span>已通过日语专业四级考试</span>
                         	</span>
						 </p>
				</div>
				 -->
		</div>
			
		<div class="addcont addcert">
			<div class="modtab">
				<h3>获得证书</h3>
			</div>
			<div class="infoview">
				<p class="pst2">
				<c:if test="${fn:length(jianliOnlinePage.jinaliZhengshuList)  > 0 }">
					<c:forEach items="${jianliOnlinePage.jinaliZhengshuList}" var="poVal" varStatus="stuts">
							${poVal.zhengshu}&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<fmt:formatDate value='${poVal.hqrq}' type="date" pattern="yyyy年MM月"/>获取<br/>
					</c:forEach>
				</c:if>	

				</p>
			</div>
	     </div>
		 <!-- 	
		 <div class="addcont addproj">
					<div class="modtab">
						<h3>项目经验</h3>
					</div>
											<div class="infoview">
							<h4>某某学校</h4>

							<p class="pst2">
								<span class="sth">项目时间：</span>
                                <span class="std">2015年02月-2015年11月</span>
							</p>

							<p class="pst2">
								<span class="sth">项目简介：</span>
                                <span class="std">某某学校某某学校某某学校</span>
							</p>

							<p class="pst2">
								<span class="sth">职责和业绩：</span>
                                <span class="std">某某学校某某学校某某学校某某学校</span>
							</p>
						</div>
											<div class="infoview">
							<h4>某某公司</h4>

							<p class="pst2">
								<span class="sth">项目时间：</span>
                                <span class="std">2013年02月-2013年10月</span>
							</p>

							<p class="pst2">
								<span class="sth">项目简介：</span>
                                <span class="std">某某学校某某学校某某学校某某学校</span>
							</p>

							<p class="pst2">
								<span class="sth">职责和业绩：</span>
                                <span class="std">某某学校某某学校某某学校某某学校</span>
							</p>
						</div>
									</div>
		 -->
		<!-- 		
		<div class="addcont addAbility">
					<div class="modtab">
						<h3>专业技能</h3>
					</div>
					<div class="infoview">
													<p class="pst">
								<span class="sth">Excel：</span>
								<span class="std">
									<span>一般</span>
									<span>3年经验</span>
								</span>
							</p>
											</div>
				</div>
										<div class="addcont addshowme">
					<div class="modtab">
						<h3>照片/作品</h3>
					</div>
					<div class="infoview">
						<ul class="myphoto">
						</ul>
					</div>
				</div>
			
			<div class="addcont addvip">
				<div class="modtab">
					<h3>我的会员</h3>
				</div>
				<div class="infoview">
											<div class="noOpenVip">
							<div class="vipTip">
								<p class="vipTitle">开通金卡会员，享一站式求职服务</p>

								<p class="vipContent">个人认证＋黄金标签＋简历置顶＋闪信送达</p>
							</div>
							<div class="openVipBtn">去看看</div>
						</div>
									</div>
			</div>
		</div>
		</div>
			<script>timeTrak.sp_time = timeTrak.gettime() - timeTrak.starttime;</script>
		</div>
		 -->
		<div class="addcont addcert">
			<div class="modtab">
				<h3>身份证信息</h3>
			</div>
			<div class="infoview">
			<c:if test="${fn:length(jianliOnlinePage.sfzh)  > 0 }">
				<p class="pst">
					<span class="sth">姓名：</span>
					<span class="std">${jianliOnlinePage.name}</span>
				</p>
				<p class="pst">
					<span class="sth">性别：</span>
					<span class="std">${jianliOnlinePage.sex}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
					<span class="sth">名族：</span>
					<span class="std">${jianliOnlinePage.mz}</span>
				</p>
				<p class="pst">
					<span class="sth">身份证号：</span>
					<span class="std">${jianliOnlinePage.sfzh}</span>
				</p>
				<p class="pst">
					<span class="sth">发证机关：</span>
					<span class="std">${jianliOnlinePage.fzjg}</span>
				</p>
			</c:if>
			</div>
		</div>
		<div class="addcont addcert">
			<div class="modtab">
				<h3>背景资料</h3>
			</div>
			<div class="infoview">
				<p class="pst">
				    <table>
				    	<tr style="height:30px">
				    		<td><span class="sth" style="width: 180px;">婚姻状况：${jianliOnlinePage.hyzk}</span></td>
				    		<td><span class="sth" style="width: 180px;">政治面貌：${jianliOnlinePage.zzmm}</span></td>
				    		<td><span class="sth" style="width: 180px;">健康状况：${jianliOnlinePage.jkzk}</span></td>
				    	</tr>
				    	<tr style="height:30px">
				    		<td><span class="sth" style="width: 180px;">户口性质：${jianliOnlinePage.hkxz}</span></td>
				    		<td><span class="sth" style="width: 180px;">犯罪记录：${jianliOnlinePage.fzjl}</span></td>
				    		<td><span class="sth" style="width: 180px;">劳动关系：${jianliOnlinePage.ldgx}</span></td>
				    	</tr>
				    	<tr style="height:30px">
				    		<td colspan="3"><span class="sth">病史详情：${jianliOnlinePage.bsxq}</span></td>
				    	</tr>
				    	<tr style="height:30px">
				    		<td colspan="3"><span class="sth">离职原因：${jianliOnlinePage.lzyy}</span></td>
				    	</tr>
				    </table>
				</p>
			</div>
		</div>
		<div class="allMask noTips"></div>
		<div class="usreTipsFirst noTips">
			<span class="IknowFirst"></span>
		</div>
		<div class="usreTipsSecond noTips">
			<span class="IknowSecond"></span>
		</div>
		<div class="usreTipsThird noTips">
			<span class="IknowThird"></span>
		</div>
		<div class="usreTipsForth noTips">
			<span class="IknowForth"></span>
		</div>

		<div id="footer" style="border-top-width: 0;">
			<p>
			</p>
		</div><div class="r_ad"><div class="r_close"></div><a class="r_btn" href="javascript:void(0)"></a></div>
</body></html>
