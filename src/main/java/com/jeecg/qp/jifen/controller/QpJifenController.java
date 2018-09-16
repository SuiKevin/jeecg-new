package com.jeecg.qp.jifen.controller;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
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
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.pojo.base.TSUserOrg;
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

import com.alibaba.fastjson.JSON;
import com.jeecg.qp.jifen.dao.QpJifenMinidaoDao;
import com.jeecg.qp.jifen.entity.QpJifenEntity;
import com.jeecg.qp.jifen.entity.QpJifenLogEntity;
import com.jeecg.qp.jifen.service.QpJifenServiceI;

/**   
 * @Title: Controller  
 * @Description: 积分管理
 * @author onlineGenerator
 * @date 2017-12-29 11:52:31
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/qpJifenController")
public class QpJifenController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(QpJifenController.class);

	@Autowired
	private QpJifenServiceI qpJifenService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	
	@Autowired
	private QpJifenMinidaoDao qpJifenMinidaoDao;

	/**
	 * 积分管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/qp/jifen/qpJifenList");
	}
	/**
	 * 积分管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list_me")
	public ModelAndView listme(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/qp/jifen/qpJifenList");
	}

	/**
	 * easyui AJAX请求数据 
	 */
	@RequestMapping(params = "datagrid")
	public void datagrid(QpJifenEntity qpJifen,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		logger.error("======qpJifen====>"+JSON.toJSONString(qpJifen));
		logger.error("========dataGrid==>"+JSON.toJSONString(dataGrid));
		//logger.error("=====request=====>"+JSON.toJSONString(request));
		CriteriaQuery cq = new CriteriaQuery(QpJifenEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, qpJifen, request.getParameterMap());
		this.systemService.getDataGridReturn(cq, true);
		for (Object  obj : dataGrid.getResults()) {
			QpJifenEntity jf=(QpJifenEntity)obj;
			List<TSUserOrg> tSUserOrgs = systemService.findByProperty(TSUserOrg.class, "tsUser.id", jf.getId());
			String departname = "";
			if (tSUserOrgs.size() > 0) {
				for (TSUserOrg tSUserOrg : tSUserOrgs) {
					departname += tSUserOrg.getTsDepart().getDepartname() + ",";
				}
			}
			logger.error("=====departname=====>"+departname);
			jf.setOwndeparts(departname);
			 
		}
		
		logger.error("=====dataGrid=====>"+JSON.toJSONString(dataGrid));
		TagUtil.datagrid(response, dataGrid);
	}
	/*@RequestMapping(params = "datagrid")
	public void datagrid(QpJifenEntity qpJifen,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		logger.error("==========>"+JSON.toJSONString(dataGrid));
		String authSql = JeecgDataAutorUtils.loadDataSearchConditonSQLString();
		MiniDaoPage<QpJifenEntity> list = qpJifenMinidaoDao.getAllEntities(qpJifen, dataGrid.getPage(), dataGrid.getRows(),authSql);
		dataGrid.setTotal(list.getTotal());
		dataGrid.setResults(list.getResults());
		//String total_salary = String.valueOf(jeecgMinidaoDao.getSumSalary());
		//说明：格式为 字段名:值(可选，不写该值时为分页数据的合计) 多个合计 以 , 分割
		//dataGrid.setFooter("salary:"+(total_salary.equalsIgnoreCase("null")?"0.0":total_salary)+",age,email:合计");
		TagUtil.datagrid(response, dataGrid);
	}*/
	
	public void getOrgInfos(TSUser user) {
		List<TSUserOrg> tSUserOrgs = systemService.findByProperty(TSUserOrg.class, "tsUser.id", user.getId());
		String orgIds = "";
		String departname = "";
		if (tSUserOrgs.size() > 0) {
			for (TSUserOrg tSUserOrg : tSUserOrgs) {
				orgIds += tSUserOrg.getTsDepart().getId() + ",";
				departname += tSUserOrg.getTsDepart().getDepartname() + ",";
			}
		}
		 

	}
	
	/**
	 * 删除积分管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(QpJifenEntity qpJifen, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		qpJifen = systemService.getEntity(QpJifenEntity.class, qpJifen.getId());
		message = "积分管理删除成功";
		try{
			qpJifenService.delete(qpJifen);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "积分管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除积分管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "积分管理删除成功";
		try{
			for(String id:ids.split(",")){
				QpJifenEntity qpJifen = systemService.getEntity(QpJifenEntity.class, id);
				qpJifenService.delete(qpJifen);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "积分管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加积分管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(QpJifenEntity qpJifen, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "积分管理添加成功";
		try{
			qpJifenService.save(qpJifen);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "积分管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新积分管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(QpJifenEntity qpJifen, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "积分管理更新成功";
		QpJifenEntity t = qpJifenService.get(QpJifenEntity.class, qpJifen.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(qpJifen, t);
			qpJifenService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "积分管理更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 授权积分 超级管理员直接授权 无需扣除本人积分
	 */
	@RequestMapping(params = "addjifen")
	@ResponseBody
	public AjaxJson addjifen(QpJifenEntity qpJifen, HttpServletRequest request) {
		TSUser user = ResourceUtil.getSessionUser();
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "积分新增成功";
		try {
			qpJifenMinidaoDao.addpoint(qpJifen.getAddpoint(), qpJifen.getId());
			//qpJifenMinidaoDao.delpoint(qpJifen.getAddpoint(), qpJifen.getId());
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			logger.info("11111111111111111111");		
			TSUser buser2 = qpJifenService.get(TSUser.class, qpJifen.getId());			
			QpJifenLogEntity qpJifenLog = new QpJifenLogEntity();
			qpJifenLog.setOperDate(new Date());
			qpJifenLog.setOperUser(user.getUserName());
			qpJifenLog.setOperEvent("积分授权新增");
			qpJifenLog.setBeioperUser(buser2.getUserName());
			qpJifenLog.setBeioperJifen(""+qpJifen.getAddpoint());
			qpJifenService.saveOrUpdate(qpJifenLog);
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "积分管理更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 转移积分  除本人积分 授权同组织及以下
	 */
	@RequestMapping(params = "movjifen")
	@ResponseBody
	public AjaxJson movjifen(QpJifenEntity qpJifen, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "积分转移成功";
		TSUser user = ResourceUtil.getSessionUser();
		try {
			//计算当前用户有多少积分 是否够转移
			//QpJifenEntity opUser=qpJifenMinidaoDao.getEntitie(user.getId());
			QpJifenEntity opUser = qpJifenService.getEntity(QpJifenEntity.class, user.getId());
			QpJifenEntity jifenobj = qpJifenService.getEntity(QpJifenEntity.class, qpJifen.getId());
			int hasjifen=opUser.getSqPoint()-opUser.getSqPointUsed();
			if(hasjifen >=qpJifen.getAddpoint()){
				jifenobj.setSqPoint(jifenobj.getSqPoint()+qpJifen.getAddpoint());
				jifenobj.setUpdateDate(new Date());
				qpJifenService.saveOrUpdate(jifenobj);
				opUser.setSqPoint(opUser.getSqPoint()-qpJifen.getAddpoint());
				qpJifenService.saveOrUpdate(opUser);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			
			
				TSUser buser2 = qpJifenService.get(TSUser.class, jifenobj.getId());			
				QpJifenLogEntity qpJifenLog = new QpJifenLogEntity();
				qpJifenLog.setOperDate(new Date());
				qpJifenLog.setOperUser(user.getUserName());
				qpJifenLog.setOperEvent("积分转移(A->B)");
				qpJifenLog.setBeioperUser(buser2.getUserName());
				qpJifenLog.setBeioperJifen(""+qpJifen.getAddpoint());
				qpJifenService.saveOrUpdate(qpJifenLog);
			
			}else{
				message = "您的剩余积分不足，无法完成转移";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "积分管理更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	

	/**
	 * 积分管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(QpJifenEntity qpJifen, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(qpJifen.getId())) {
			qpJifen = qpJifenService.getEntity(QpJifenEntity.class, qpJifen.getId());
			req.setAttribute("qpJifenPage", qpJifen);
		}
		return new ModelAndView("com/jeecg/qp/jifen/qpJifen-add");
	}
	/**
	 * 积分管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(QpJifenEntity qpJifen, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(qpJifen.getId())) {
			qpJifen = qpJifenService.getEntity(QpJifenEntity.class, qpJifen.getId());
			req.setAttribute("qpJifenPage", qpJifen);
		}
		return new ModelAndView("com/jeecg/qp/jifen/qpJifen-update");
	}
	/**
	 * 主页看个人积分 
	 * 
	 * @return
	 */
	@RequestMapping(params = "seeMyJifen")
	public ModelAndView seeMyJifen(QpJifenEntity qpJifen, HttpServletRequest req) {
		TSUser user = ResourceUtil.getSessionUser();
			qpJifen = qpJifenService.getEntity(QpJifenEntity.class, user.getId());
			req.setAttribute("qpJifenPage", qpJifen);
		 
		return new ModelAndView("com/jeecg/qp/jifen/qpJifen-update");
	}
	//授权积分
	@RequestMapping(params = "sqjifen")
	public ModelAndView sqjifen(QpJifenEntity qpJifen, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(qpJifen.getId())) {
			qpJifen = qpJifenService.getEntity(QpJifenEntity.class, qpJifen.getId());
			req.setAttribute("qpJifenPage", qpJifen);
		}
		return new ModelAndView("com/jeecg/qp/jifen/qpJifen-sqjifen");
	}
	//转移积分
	@RequestMapping(params = "movjifenpage")
	public ModelAndView movjifenpage(QpJifenEntity qpJifen, HttpServletRequest req) {
			if (StringUtil.isNotEmpty(qpJifen.getId())) {
				qpJifen = qpJifenService.getEntity(QpJifenEntity.class, qpJifen.getId());
				req.setAttribute("qpJifenPage", qpJifen);
			}
			TSUser user = ResourceUtil.getSessionUser();
				//计算当前用户有多少积分 是否够转移
			QpJifenEntity opUser = qpJifenService.getEntity(QpJifenEntity.class, user.getId());
			int mypoint=opUser.getSqPoint()-opUser.getSqPointUsed();
			
			req.setAttribute("mypoint", mypoint);
			return new ModelAndView("com/jeecg/qp/jifen/qpJifen-movjifen");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","qpJifenController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(QpJifenEntity qpJifen,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(QpJifenEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, qpJifen, request.getParameterMap());
		List<QpJifenEntity> qpJifens = this.qpJifenService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"积分管理");
		modelMap.put(NormalExcelConstants.CLASS,QpJifenEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("积分管理列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,qpJifens);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(QpJifenEntity qpJifen,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"积分管理");
    	modelMap.put(NormalExcelConstants.CLASS,QpJifenEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("积分管理列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<QpJifenEntity> listQpJifenEntitys = ExcelImportUtil.importExcel(file.getInputStream(),QpJifenEntity.class,params);
				for (QpJifenEntity qpJifen : listQpJifenEntitys) {
					qpJifenService.save(qpJifen);
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
	public List<QpJifenEntity> list() {
		List<QpJifenEntity> listQpJifens=qpJifenService.getList(QpJifenEntity.class);
		return listQpJifens;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		QpJifenEntity task = qpJifenService.get(QpJifenEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody QpJifenEntity qpJifen, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<QpJifenEntity>> failures = validator.validate(qpJifen);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			qpJifenService.save(qpJifen);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = qpJifen.getId();
		URI uri = uriBuilder.path("/rest/qpJifenController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody QpJifenEntity qpJifen) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<QpJifenEntity>> failures = validator.validate(qpJifen);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			qpJifenService.saveOrUpdate(qpJifen);
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
		qpJifenService.deleteEntityById(QpJifenEntity.class, id);
	}
}
