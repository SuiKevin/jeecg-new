package com.jeecg.qpwl.orderflow.controller;
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
import com.jeecg.qpwl.orderflow.entity.TFlowExampleEntity;
import com.jeecg.qpwl.orderflow.entity.TFlowExecuteHistoryEntity;
import com.jeecg.qpwl.orderflow.page.TFlowExamplePage;
import com.jeecg.qpwl.orderflow.service.TFlowExampleServiceI;

/**   
 * @Title: Controller
 * @Description: 在途工单
 * @author onlineGenerator
 * @date 2017-12-24 15:35:51
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tFlowExampleController")
public class TFlowExampleController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TFlowExampleController.class);

	@Autowired
	private TFlowExampleServiceI tFlowExampleService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private TaskServiceI taskService;
	@Autowired
	private Validator validator;

	/**
	 * 在途工单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/qpwl/orderflow/tFlowExampleList");
	}
	/**
	 * 完成任务
	 * 
	 * @return
	 */
	@RequestMapping(params = "doComplete")
	@ResponseBody
	public AjaxJson complete(TFlowExampleEntity tFlowExample, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		FlowResult flowResult = taskService.complete(tFlowExample.getInstanceId(),ResourceUtil.getSessionUser(),new JSONObject());
		if(flowResult.getResultCode() == 0){
			j.setMsg("完成任务成功");
		}else{
			j.setMsg(flowResult.getResultMsg());
		}
		return j;
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
	public void datagrid(TFlowExampleEntity tFlowExample,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TFlowExampleEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tFlowExample);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tFlowExampleService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除在途工单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TFlowExampleEntity tFlowExample, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tFlowExample = systemService.getEntity(TFlowExampleEntity.class, tFlowExample.getId());
		String message = "在途工单删除成功";
		try{
			tFlowExampleService.delMain(tFlowExample);
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
	 * 批量删除在途工单
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "在途工单删除成功";
		try{
			for(String id:ids.split(",")){
				TFlowExampleEntity tFlowExample = systemService.getEntity(TFlowExampleEntity.class,
				id
				);
				tFlowExampleService.delMain(tFlowExample);
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
	public AjaxJson doAdd(TFlowExampleEntity tFlowExample,TFlowExamplePage tFlowExamplePage, HttpServletRequest request) {
		List<TFlowExecuteHistoryEntity> tFlowExecuteHistoryList =  tFlowExamplePage.getTFlowExecuteHistoryList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			tFlowExampleService.addMain(tFlowExample, tFlowExecuteHistoryList);
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
	public AjaxJson doUpdate(TFlowExampleEntity tFlowExample,TFlowExamplePage tFlowExamplePage, HttpServletRequest request) {
		List<TFlowExecuteHistoryEntity> tFlowExecuteHistoryList =  tFlowExamplePage.getTFlowExecuteHistoryList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			tFlowExampleService.updateMain(tFlowExample, tFlowExecuteHistoryList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新在途工单失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 在途工单新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TFlowExampleEntity tFlowExample, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tFlowExample.getId())) {
			tFlowExample = tFlowExampleService.getEntity(TFlowExampleEntity.class, tFlowExample.getId());
			req.setAttribute("tFlowExamplePage", tFlowExample);
		}
		return new ModelAndView("com/jeecg/qpwl/orderflow/tFlowExample-add");
	}
	
	/**
	 * 在途工单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TFlowExampleEntity tFlowExample, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tFlowExample.getId())) {
			tFlowExample = tFlowExampleService.getEntity(TFlowExampleEntity.class, tFlowExample.getId());
			req.setAttribute("tFlowExamplePage", tFlowExample);
		}
		return new ModelAndView("com/jeecg/qpwl/orderflow/tFlowExample-update");
	}
	
	
	/**
	 * 加载明细列表[历史环节]
	 * 
	 * @return
	 */
	@RequestMapping(params = "tFlowExecuteHistoryList")
	public ModelAndView tFlowExecuteHistoryList(TFlowExampleEntity tFlowExample, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = tFlowExample.getInstanceId();
		//===================================================================================
		//查询-历史环节
	    String hql0 = "from TFlowExecuteHistoryEntity where 1 = 1 AND iNSTANCE_ID = ? ";
	    try{
	    	List<TFlowExecuteHistoryEntity> tFlowExecuteHistoryEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("tFlowExecuteHistoryList", tFlowExecuteHistoryEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/qpwl/orderflow/tFlowExecuteHistoryList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(TFlowExampleEntity tFlowExample,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(TFlowExampleEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tFlowExample);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<TFlowExampleEntity> list=this.tFlowExampleService.getListByCriteriaQuery(cq, false);
    	List<TFlowExamplePage> pageList=new ArrayList<TFlowExamplePage>();
        if(list!=null&&list.size()>0){
        	for(TFlowExampleEntity entity:list){
        		try{
        		TFlowExamplePage page=new TFlowExamplePage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from TFlowExecuteHistoryEntity where 1 = 1 AND iNSTANCE_ID = ? ";
        	        List<TFlowExecuteHistoryEntity> tFlowExecuteHistoryEntityList = systemService.findHql(hql0,id0);
            		page.setTFlowExecuteHistoryList(tFlowExecuteHistoryEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"在途工单");
        map.put(NormalExcelConstants.CLASS,TFlowExamplePage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("在途工单列表", "导出人:Jeecg",
            "导出信息"));
        map.put(NormalExcelConstants.DATA_LIST,pageList);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

    /**
	 * 通过excel导入数据
	 * @param request
	 * @param
	 * @return
	 */
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
			params.setHeadRows(2);
			params.setNeedSave(true);
			try {
				List<TFlowExamplePage> list =  ExcelImportUtil.importExcel(file.getInputStream(), TFlowExamplePage.class, params);
				TFlowExampleEntity entity1=null;
				for (TFlowExamplePage page : list) {
					entity1=new TFlowExampleEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            tFlowExampleService.addMain(entity1, page.getTFlowExecuteHistoryList());
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
	/**
	* 导出excel 使模板
	*/
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ModelMap map) {
		map.put(NormalExcelConstants.FILE_NAME,"在途工单");
		map.put(NormalExcelConstants.CLASS,TFlowExamplePage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("在途工单列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
		"导出信息"));
		map.put(NormalExcelConstants.DATA_LIST,new ArrayList());
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	* 导入功能跳转
	*
	* @return
	*/
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name", "tFlowExampleController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<TFlowExampleEntity> list() {
		List<TFlowExampleEntity> listTFlowExamples=tFlowExampleService.getList(TFlowExampleEntity.class);
		return listTFlowExamples;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		TFlowExampleEntity task = tFlowExampleService.get(TFlowExampleEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody TFlowExamplePage tFlowExamplePage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TFlowExamplePage>> failures = validator.validate(tFlowExamplePage);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		List<TFlowExecuteHistoryEntity> tFlowExecuteHistoryList =  tFlowExamplePage.getTFlowExecuteHistoryList();
		
		TFlowExampleEntity tFlowExample = new TFlowExampleEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(tFlowExample,tFlowExamplePage);
		}catch(Exception e){
            logger.info(e.getMessage());
        }
		tFlowExampleService.addMain(tFlowExample, tFlowExecuteHistoryList);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = tFlowExamplePage.getId();
		URI uri = uriBuilder.path("/rest/tFlowExampleController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody TFlowExamplePage tFlowExamplePage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TFlowExamplePage>> failures = validator.validate(tFlowExamplePage);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		List<TFlowExecuteHistoryEntity> tFlowExecuteHistoryList =  tFlowExamplePage.getTFlowExecuteHistoryList();
		
		TFlowExampleEntity tFlowExample = new TFlowExampleEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(tFlowExample,tFlowExamplePage);
		}catch(Exception e){
            logger.info(e.getMessage());
        }
		tFlowExampleService.updateMain(tFlowExample, tFlowExecuteHistoryList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		TFlowExampleEntity tFlowExample = tFlowExampleService.get(TFlowExampleEntity.class, id);
		tFlowExampleService.delMain(tFlowExample);
	}
}
