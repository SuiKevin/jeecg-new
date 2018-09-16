package com.jeecg.qpwl.order.controller;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.jeecg.qpwl.core.FlowResult;
import com.jeecg.qpwl.core.TaskServiceI;
import com.jeecg.qpwl.order.entity.TOrderHisEntity;
import com.jeecg.qpwl.order.entity.TOrderIngEntity;
import com.jeecg.qpwl.order.service.TOrderHisServiceI;
import com.jeecg.qpwl.order.service.TOrderIngServiceI;
import com.jeecg.qpwl.talentpool.entity.JianliBusinessEntity;
import com.jeecg.qpwl.talentpool.entity.JianliJiaoyuEntity;
import com.jeecg.qpwl.talentpool.entity.JianliJingyanEntity;
import com.jeecg.qpwl.talentpool.entity.JinaliZhengshuEntity;
import com.jeecg.qpwl.talentpool.page.JianliOnlinePage;

/**   
 * @Title: Controller  
 * @Description: 在途工单
 * @author onlineGenerator
 * @date 2017-12-24 21:50:07
 * @version V1.0
 *
 */
@Controller
@RequestMapping("/tOrderIngController")
public class TOrderIngController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TOrderIngController.class);

	@Autowired
	private TOrderIngServiceI tOrderIngService;
	@Autowired
	private TOrderHisServiceI tOrderHisService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private TaskServiceI taskService;
	
	


	/**
	 * 在途工单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/qpwl/order/tOrderIngList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TOrderIngEntity tOrderIng,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
//		CriteriaQuery cq = new CriteriaQuery(TOrderIngEntity.class, dataGrid);
//		//查询条件组装器
//		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tOrderIng, request.getParameterMap());
//		try{
//		//自定义追加查询条件
//		String query_age_begin = request.getParameter("age_begin");
//		String query_age_end = request.getParameter("age_end");
//		if(StringUtil.isNotEmpty(query_age_begin)){
//			cq.ge("age", Integer.parseInt(query_age_begin));
//		}
//		if(StringUtil.isNotEmpty(query_age_end)){
//			cq.le("age", Integer.parseInt(query_age_end));
//		}
//		String query_gzjy_begin = request.getParameter("gzjy_begin");
//		String query_gzjy_end = request.getParameter("gzjy_end");
//		if(StringUtil.isNotEmpty(query_gzjy_begin)){
//			cq.ge("gzjy", Integer.parseInt(query_gzjy_begin));
//		}
//		if(StringUtil.isNotEmpty(query_gzjy_end)){
//			cq.le("gzjy", Integer.parseInt(query_gzjy_end));
//		}
//		}catch (Exception e) {
//			throw new BusinessException(e.getMessage());
//		}
//		cq.add();
//		this.tOrderIngService.getDataGridReturn(cq, true);
		try{
			JSONObject paramObj = new JSONObject();
			dataGrid.setField(dataGrid.getField()+"taskName,");
			paramObj.put("age_begin", request.getParameter("age_begin"));
			paramObj.put("age_end", request.getParameter("age_end"));
			paramObj.put("name", request.getParameter("name"));
			paramObj.put("qzjob", request.getParameter("qzjob"));
			paramObj.put("taskName", request.getParameter("taskName"));
			this.tOrderIngService.qryAll(dataGrid,paramObj);
		}catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
		TagUtil.datagrid(response, dataGrid);
	}
	
	
	/**
	 * 删除在途工单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TOrderIngEntity tOrderIng, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tOrderIng = systemService.getEntity(TOrderIngEntity.class, tOrderIng.getId());
		message = "在途工单删除成功";
		try{
			tOrderIngService.delete(tOrderIng);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "在途工单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	
	/**
	 * 身份证补录
	 * 
	 * @return
	 */
	@RequestMapping(params = "idCradWrite")
	@ResponseBody
	public AjaxJson idCradWrite(HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if(!"".equals(request.getParameter("idCardInfo")) && null != request.getParameter("idCardInfo")){
			JSONObject jsonObj = JSONObject.fromObject(request.getParameter("idCardInfo"));
			//补录身份证
			FlowResult flResult = tOrderIngService.idCradReWrite(jsonObj);
			if(flResult.getResultCode() != 0){
				message = flResult.getResultMsg();
			}else{
				message = "身份证补录成功";
			}
		}else{
			message = "身份证补录失败，没有获取到身份证信息";
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除在途工单
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "在途工单删除成功";
		try{
			for(String id:ids.split(",")){
				TOrderIngEntity tOrderIng = systemService.getEntity(TOrderIngEntity.class, 
				id
				);
				tOrderIngService.delete(tOrderIng);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "在途工单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加在途工单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TOrderIngEntity tOrderIng, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "在途工单添加成功";
		try{
			tOrderIngService.save(tOrderIng);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "在途工单添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新在途工单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TOrderIngEntity tOrderIng, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "在途工单更新成功";
		TOrderIngEntity t = tOrderIngService.get(TOrderIngEntity.class, tOrderIng.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tOrderIng, t);
			tOrderIngService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			FlowResult flowResult = taskService.complete(t.getProcessInstanceId(),ResourceUtil.getSessionUser(),JSONObject.fromObject(t));
			if(flowResult.getResultCode() == 0){
				message = "在途工单更新成功";
			}else if(flowResult.getResultCode()== 1000){//流程结束，插入历史流程表
				TOrderHisEntity tHisEntity =(TOrderHisEntity)JSONObject.toBean(JSONObject.fromObject(t),TOrderHisEntity.class);
				tOrderIngService.save(tHisEntity);
				message = "在途工单更新成功";
			}else{
				message = flowResult.getResultMsg();
				throw new BusinessException(flowResult.getResultMsg());
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "在途工单更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 在途工单新增页面跳转
	 * @return
	 */
	@RequestMapping(params = "flowImg")
	public ModelAndView flowImg(TOrderIngEntity tOrderIng, HttpServletRequest req){
		if("邀约".equals(tOrderIng.getTaskName())){
			return new ModelAndView("/com/jeecg/qpwl/flowImg/png_yaoyue");
		}else if("面试".equals(tOrderIng.getTaskName())){
			return new ModelAndView("/com/jeecg/qpwl/flowImg/png_mianshi");
		}else if("审核".equals(tOrderIng.getTaskName())){
			return new ModelAndView("/com/jeecg/qpwl/flowImg/png_shenhe");
		}else if("接送".equals(tOrderIng.getTaskName())){
			return new ModelAndView("/com/jeecg/qpwl/flowImg/png_jiesong");
		}else if("上岗".equals(tOrderIng.getTaskName())){
			return new ModelAndView("/com/jeecg/qpwl/flowImg/png_shanggang");
		}else if("入职".equals(tOrderIng.getTaskName())){
			return new ModelAndView("/com/jeecg/qpwl/flowImg/png_ruzhi");
		}else if("收款".equals(tOrderIng.getTaskName())){
			return new ModelAndView("/com/jeecg/qpwl/flowImg/png_shoukuan");
		}else{
			return new ModelAndView("/com/jeecg/qpwl/flowImg/png_yaoyue");
		}
	}

	/**
	 * 在途工单新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TOrderIngEntity tOrderIng, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tOrderIng.getId())) {
			tOrderIng = tOrderIngService.getEntity(TOrderIngEntity.class, tOrderIng.getId());
			req.setAttribute("tOrderIngPage", tOrderIng);
		}
		return new ModelAndView("com/jeecg/qpwl/order/tOrderIng-add");
	}
	/**
	 * 邀约界面
	 * 
	 * @return
	 */
	@RequestMapping(params = "goYaoyue")
	public ModelAndView goYaoyue(TOrderIngEntity tOrderIng, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tOrderIng.getId())) {
			tOrderIng = tOrderIngService.getEntity(TOrderIngEntity.class, tOrderIng.getId());
			TSDepart depart =tOrderIngService.getEntity(TSDepart.class, ResourceUtil.getSessionUser().getDepartid());
			tOrderIng.setInviteStore(ResourceUtil.getSessionUser().getDepartid());
			tOrderIng.setMdName(depart.getDepartname());
			req.setAttribute("tOrderIngPage", tOrderIng);
		}
		return new ModelAndView("com/jeecg/qpwl/order/order_yaoyue");
	}
	
	/**
	 * 面试界面
	 * 
	 * @return
	 */
	@RequestMapping(params = "goMianshi")
	public ModelAndView goMianshi(TOrderIngEntity tOrderIng, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tOrderIng.getId())) {
			tOrderIng = tOrderIngService.getEntity(TOrderIngEntity.class, tOrderIng.getId());
			TSDepart depart =tOrderIngService.getEntity(TSDepart.class, tOrderIng.getInviteStore());
			if(depart !=null)
			tOrderIng.setMdName(depart.getDepartname());
			req.setAttribute("tOrderIngPage", tOrderIng);
		}
		return new ModelAndView("com/jeecg/qpwl/order/order_mianshi");
	}
	
	/**
	 * 审核界面
	 * 
	 * @return
	 */
	@RequestMapping(params = "goShenhe")
	public ModelAndView goShenhe(TOrderIngEntity tOrderIng, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tOrderIng.getId())) {
			tOrderIng = tOrderIngService.getEntity(TOrderIngEntity.class, tOrderIng.getId());
			TSDepart depart =tOrderIngService.getEntity(TSDepart.class, tOrderIng.getInviteStore());
			if(depart !=null)
			tOrderIng.setMdName(depart.getDepartname());
			req.setAttribute("tOrderIngPage", tOrderIng);
		}
		return new ModelAndView("com/jeecg/qpwl/order/order_shenhe");
	}
	
	
	/**
	 * 接待界面
	 * 
	 * @return
	 */
	@RequestMapping(params = "goJiedai")
	public ModelAndView goJiedai(TOrderIngEntity tOrderIng, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tOrderIng.getId())) {
			tOrderIng = tOrderIngService.getEntity(TOrderIngEntity.class, tOrderIng.getId());
			TSDepart depart =tOrderIngService.getEntity(TSDepart.class, tOrderIng.getInviteStore());
			if(depart !=null)
				tOrderIng.setMdName(depart.getDepartname());
			req.setAttribute("tOrderIngPage", tOrderIng);
		}
		return new ModelAndView("com/jeecg/qpwl/order/order_jiesong");
	}
	
	
	/**
	 * 上岗界面
	 * 
	 * @return
	 */
	@RequestMapping(params = "goShanggang")
	public ModelAndView goShanggang(TOrderIngEntity tOrderIng, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tOrderIng.getId())) {
			tOrderIng = tOrderIngService.getEntity(TOrderIngEntity.class, tOrderIng.getId());
			TSDepart depart =tOrderIngService.getEntity(TSDepart.class, tOrderIng.getInviteStore());
			if(depart !=null)
				tOrderIng.setMdName(depart.getDepartname());
			req.setAttribute("tOrderIngPage", tOrderIng);
		}
		return new ModelAndView("com/jeecg/qpwl/order/order_shanggang");
	}
	
	/**
	 * 入职界面
	 * 
	 * @return
	 */
	@RequestMapping(params = "goRuzhi")
	public ModelAndView goRuzhi(TOrderIngEntity tOrderIng, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tOrderIng.getId())) {
			tOrderIng = tOrderIngService.getEntity(TOrderIngEntity.class, tOrderIng.getId());
			TSDepart depart =tOrderIngService.getEntity(TSDepart.class, tOrderIng.getInviteStore());
			if(depart !=null)
				tOrderIng.setMdName(depart.getDepartname());
			req.setAttribute("tOrderIngPage", tOrderIng);
		}
		return new ModelAndView("com/jeecg/qpwl/order/order_ruzhi");
	}
	
	/**
	 * 收款界面
	 * 
	 * @return
	 */
	@RequestMapping(params = "goShoukuan")
	public ModelAndView goShoukuan(TOrderIngEntity tOrderIng, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tOrderIng.getId())) {
			tOrderIng = tOrderIngService.getEntity(TOrderIngEntity.class, tOrderIng.getId());
			TSDepart depart =tOrderIngService.getEntity(TSDepart.class, tOrderIng.getInviteStore());
			if(depart !=null)
				tOrderIng.setMdName(depart.getDepartname());
			req.setAttribute("tOrderIngPage", tOrderIng);
		}
		return new ModelAndView("com/jeecg/qpwl/order/order_shoukuan");
	}
	
	
	/**
	 * 简历展示
	 * 
	 * @return
	 */
	@RequestMapping(params = "doResumeView")
	public ModelAndView doResumeView(TOrderIngEntity tOrderIng, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tOrderIng.getId())) {
			tOrderIng = tOrderIngService.getEntity(TOrderIngEntity.class, tOrderIng.getId());
			//获取简历信息
			JianliOnlinePage page=new JianliOnlinePage();
			try{
				JianliBusinessEntity jianliBusines = systemService.getEntity(JianliBusinessEntity.class, tOrderIng.getResumeId());
				MyBeanUtils.copyBeanNotNull2Bean(jianliBusines,page);
				String hql0 = "from JianliBusinessJingyanEntity where 1 = 1 AND rESUME_ID = ? ";
				List<JianliJingyanEntity> jianliJingyanList = systemService.findHql(hql0,page.getId());
				page.setJianliJingyanList(jianliJingyanList);
				String hql1 = "from JianliBusinessJiaoyuEntity where 1 = 1 AND rESUME_ID = ? ";
				List<JianliJiaoyuEntity> JianliJiaoyuList = systemService.findHql(hql1,page.getId());
				page.setJianliJiaoyuList(JianliJiaoyuList);
				String hql2 = "from JinaliBusinessZhengshuEntity where 1 = 1 AND rESUME_ID = ? ";
				List<JinaliZhengshuEntity> JinaliZhengshuEntityList = systemService.findHql(hql2,page.getId());
				page.setJinaliZhengshuList(JinaliZhengshuEntityList);
            }catch(Exception e){
            	logger.info(e.getMessage());
            }
			req.setAttribute("jianliOnlinePage", page);
		}
		return new ModelAndView("com/jeecg/qpwl/resumeView/resumeView");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tOrderIngController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TOrderIngEntity tOrderIng,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		//查找需要接送的人员信息
		try{
			List<TOrderIngEntity> tOrderIngs = tOrderIngService.qryAllJieSong(new JSONObject());
			modelMap.put(NormalExcelConstants.FILE_NAME,"接送人员名单");
			modelMap.put(NormalExcelConstants.CLASS,TOrderIngEntity.class);
			modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("接送人员名单", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
				"导出信息"));
			modelMap.put(NormalExcelConstants.DATA_LIST,tOrderIngs);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TOrderIngEntity tOrderIng,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"在途工单");
    	modelMap.put(NormalExcelConstants.CLASS,TOrderIngEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("在途工单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<TOrderIngEntity> listTOrderIngEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TOrderIngEntity.class,params);
				for (TOrderIngEntity tOrderIng : listTOrderIngEntitys) {
					tOrderIngService.save(tOrderIng);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<TOrderIngEntity> list() {
		List<TOrderIngEntity> listTOrderIngs=tOrderIngService.getList(TOrderIngEntity.class);
		return listTOrderIngs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		TOrderIngEntity task = tOrderIngService.get(TOrderIngEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody TOrderIngEntity tOrderIng, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TOrderIngEntity>> failures = validator.validate(tOrderIng);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			tOrderIngService.save(tOrderIng);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = tOrderIng.getId();
		URI uri = uriBuilder.path("/rest/tOrderIngController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody TOrderIngEntity tOrderIng) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TOrderIngEntity>> failures = validator.validate(tOrderIng);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			tOrderIngService.saveOrUpdate(tOrderIng);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		tOrderIngService.deleteEntityById(TOrderIngEntity.class, id);
	}
}
