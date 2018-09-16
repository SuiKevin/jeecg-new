package com.jeecg.qpwl.selectview.controller;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**   
 * @Title: Controller  
 * @Description: 各种选择窗口
 * @author onlineGenerator
 * @date 2017-12-24 21:50:07
 * @version V1.0
 *
 */
@Controller
@RequestMapping("/selectViewController")
public class SelectViewController extends BaseController {
	public static Map<String,String> roleTemp  = new HashMap<String,String>();
	/**
	 * 角色选择
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "roles")
	public ModelAndView roles(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("system/user/users");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		mv.addObject("ids", ids);
		return mv;
	}
	/**
	 * 弹出部门选择
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "departs")
	public ModelAndView departs(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("com/jeecg/qpwl/selectView/userSelect");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		mv.addObject("ids", ids);
		return mv;
	}
	
	/**
	 * 用户选择
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "users")
	public ModelAndView users(HttpServletRequest request) {
		//--author：zhoujf-----start----date:20150531--------for: 编辑用户，选择角色,弹出的角色列表页面，默认没选中
		ModelAndView mv = new ModelAndView("com/jeecg/qpwl/selectView/userSelect");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		mv.addObject("ids", ids);
		return mv;
	}
	
	/**
	 * 公司选择
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "companys")
	public ModelAndView companys(HttpServletRequest request) {
		//--author：zhoujf-----start----date:20150531--------for: 编辑用户，选择角色,弹出的角色列表页面，默认没选中
		ModelAndView mv = new ModelAndView("com/jeecg/qpwl/selectView/companySelect");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		mv.addObject("ids", ids);
		return mv;
	}
	/**
	 * 职位选择
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "positionas")
	public ModelAndView positionas(HttpServletRequest request) {
		//--author：zhoujf-----start----date:20150531--------for: 编辑用户，选择角色,弹出的角色列表页面，默认没选中
		ModelAndView mv = new ModelAndView("system/user/users");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		mv.addObject("ids", ids);
		return mv;
	}
	/**
	 * 选择省份
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "provinces")
	public ModelAndView provinces(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("com/jeecg/qpwl/selectView/provinceSelect");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		String from = oConvertUtils.getString(request.getParameter("from"));
		JSONObject paramObj = new JSONObject();
		paramObj.put("ids", ids);
		paramObj.put("from", from);
		try {
			mv.addObject("paramObj", URLEncoder.encode(paramObj.toString(), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 选择城市
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "citys")
	public ModelAndView citys(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("com/jeecg/qpwl/selectView/citySelect");
		String provinceId = oConvertUtils.getString(request.getParameter("ids"));
		String from = oConvertUtils.getString(request.getParameter("from"));
		JSONObject paramObj = new JSONObject();
		paramObj.put("ids", provinceId);
		paramObj.put("from", from);
		try {
			mv.addObject("paramObj", URLEncoder.encode(paramObj.toString(), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 选择区县
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "towns")
	public ModelAndView towns(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("com/jeecg/qpwl/selectView/townSelect");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		String from = oConvertUtils.getString(request.getParameter("from"));
		JSONObject paramObj = new JSONObject();
		paramObj.put("ids", ids);
		paramObj.put("from", from);
		try {
			mv.addObject("paramObj", URLEncoder.encode(paramObj.toString(), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 职位大类
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "jobpositions")
	public ModelAndView jobpositions(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("com/jeecg/qpwl/selectView/jobpositionSelect");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		String from = oConvertUtils.getString(request.getParameter("from"));
		JSONObject paramObj = new JSONObject();
		paramObj.put("ids", ids);
		paramObj.put("from", from);
		try {
			mv.addObject("paramObj", URLEncoder.encode(paramObj.toString(), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	
	/**
	 * 职位小类
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "jobs")
	public ModelAndView jobs(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("com/jeecg/qpwl/selectView/jobSelect");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		String from = oConvertUtils.getString(request.getParameter("from"));
		JSONObject paramObj = new JSONObject();
		paramObj.put("ids", ids);
		paramObj.put("from", from);
		try {
			mv.addObject("paramObj", URLEncoder.encode(paramObj.toString(), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 职位描述
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "jobdescriptios")
	public ModelAndView jobdescriptios(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("com/jeecg/qpwl/selectView/jobdescriptionSelect");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		String from = oConvertUtils.getString(request.getParameter("from"));
		JSONObject paramObj = new JSONObject();
		paramObj.put("ids", ids);
		paramObj.put("from", from);
		try {
			mv.addObject("paramObj", URLEncoder.encode(paramObj.toString(), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	
	/**
	 * 缓存省和市关系
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "citysProvince")
	@ResponseBody
	public void citysProvince(HttpServletRequest request){
		roleTemp.put(ResourceUtil.getSessionUser().getId()+"province", request.getParameter("provinceId"));
	}
	/**
	 * 缓存城市和区县关系
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "townsCity")
	@ResponseBody
	public void townsCity(HttpServletRequest request){
		roleTemp.put(ResourceUtil.getSessionUser().getId()+"city", request.getParameter("provinceId"));
	}
	
	/**
	 * 缓存一级职位分类和二级职位分类的关系
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "job1job2")
	@ResponseBody
	public void job1job2(HttpServletRequest request){
		roleTemp.put(ResourceUtil.getSessionUser().getId(), request.getParameter("positionId"));
	}
	
	
	/**
	 * 缓存二级职位分类和职位描述的关系
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "job2job3")
	@ResponseBody
	public void job2job3(HttpServletRequest request){
		roleTemp.put(ResourceUtil.getSessionUser().getId(), request.getParameter("jobId"));
	}
}
