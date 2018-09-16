package com.jeecg.qpwl.talentpool.controller;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

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
import com.jeecg.qpwl.talentpool.entity.JianliJiaoyuEntity;
import com.jeecg.qpwl.talentpool.entity.JianliJingyanEntity;
import com.jeecg.qpwl.talentpool.entity.JianliOnlineEntity;
import com.jeecg.qpwl.talentpool.entity.JianliXiaofenEntity;
import com.jeecg.qpwl.talentpool.entity.JinaliZhengshuEntity;
import com.jeecg.qpwl.talentpool.page.JianliOnlinePage;
import com.jeecg.qpwl.talentpool.service.JianliOnlineServiceI;

/**   
 * @Title: Controller
 * @Description: 实时人才库
 * @author onlineGenerator
 * @date 2017-12-29 18:04:42
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/jianliOnlineController")
public class JianliOnlineController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(JianliOnlineController.class);

	@Autowired
	private JianliOnlineServiceI jianliOnlineService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * 实时人才库列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/qpwl/talentpool/jianliOnlineList");
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
	public void datagrid(JianliOnlineEntity jianliOnline,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		try{
			JSONObject paramObj = JSONObject.fromObject(jianliOnline);
			paramObj.put("ageStart",request.getParameter("ageStart"));//起始年龄
			paramObj.put("ageEnd",request.getParameter("ageEnd"));//结束年龄
			this.jianliOnlineService.qryAll(dataGrid,paramObj);
			TagUtil.datagrid(response, dataGrid);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
        
	}

	/**
	 * 查看人员简历
	 * @param jianliOnline
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "doResumeView")
	public ModelAndView doResumeView(JianliOnlineEntity jianliOnline, HttpServletRequest req){
		if (StringUtil.isNotEmpty(jianliOnline.getId())) {
			//获取简历信息
			JianliOnlinePage page=new JianliOnlinePage();
			try{
				jianliOnline = systemService.getEntity(JianliOnlineEntity.class, jianliOnline.getId());
				String hql = "from JianliXiaofenEntity where 1 = 1 AND rESUME_ID = ? and USER_ID='"+ResourceUtil.getSessionUser().getId()+"' ";
				List<JianliXiaofenEntity> xiaofenList = systemService.findHql(hql,jianliOnline.getId());
				if(req.getParameter("viewFrom") != null && "jianli_business".equals(req.getParameter("viewFrom")) && xiaofenList.size()<1){
					jianliOnline.setMobile("137********");
				}
				MyBeanUtils.copyBeanNotNull2Bean(jianliOnline,page);
				//获取简历被查看的次数
				List<Map<String,Object>> retList = systemService.findListbySql("select * from jianli_xiaofen where resume_id='"+jianliOnline.getId()+"'");
				page.setLookNum(retList.size()+"");
				String hql0 = "from JianliJingyanEntity where 1 = 1 AND rESUME_ID = ? ";
				List<JianliJingyanEntity> jianliJingyanEntityList = systemService.findHql(hql0,page.getId());
				page.setJianliJingyanList(jianliJingyanEntityList);
				String hql1 = "from JianliJiaoyuEntity where 1 = 1 AND rESUME_ID = ? ";
				List<JianliJiaoyuEntity> jianliJiaoyuEntityList = systemService.findHql(hql1,page.getId());
				page.setJianliJiaoyuList(jianliJiaoyuEntityList);
				String hql2 = "from JinaliZhengshuEntity where 1 = 1 AND rESUME_ID = ? ";
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
	 * 获取联系方式
	 * @param jianliOnline
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "doQueryPhoneNo")
	@ResponseBody
	public AjaxJson doQueryPhoneNo(JianliOnlineEntity jianliOnline, HttpServletRequest req){
		AjaxJson j = new AjaxJson();
		jianliOnline = systemService.getEntity(JianliOnlineEntity.class, jianliOnline.getId());
		String message = "获取联系方式成功,请到企业人才库查看";
		try{
			FlowResult result = jianliOnlineService.qryPhoneNo(jianliOnline);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			if(result.getResultCode() != 0){
				message = result.getResultMsg();
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "获取联系方式失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 删除实时人才库
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(JianliOnlineEntity jianliOnline, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		jianliOnline = systemService.getEntity(JianliOnlineEntity.class, jianliOnline.getId());
		String message = "实时人才库删除成功";
		try{
			jianliOnlineService.delMain(jianliOnline);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "实时人才库删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除实时人才库
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "实时人才库删除成功";
		try{
			for(String id:ids.split(",")){
				JianliOnlineEntity jianliOnline = systemService.getEntity(JianliOnlineEntity.class,
				id
				);
				jianliOnlineService.delMain(jianliOnline);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "实时人才库删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加实时人才库
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(JianliOnlineEntity jianliOnline,JianliOnlinePage jianliOnlinePage, HttpServletRequest request) {
		List<JinaliZhengshuEntity> jinaliZhengshuList =  jianliOnlinePage.getJinaliZhengshuList();
		List<JianliJiaoyuEntity> jianliJiaoyuList =  jianliOnlinePage.getJianliJiaoyuList();
		List<JianliJingyanEntity> jianliJingyanList =  jianliOnlinePage.getJianliJingyanList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			jianliOnline.setId(UUID.randomUUID().toString().replace("-", ""));
			jianliOnlineService.addMain(jianliOnline, jinaliZhengshuList,jianliJiaoyuList,jianliJingyanList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "实时人才库添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新实时人才库
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(JianliOnlineEntity jianliOnline,JianliOnlinePage jianliOnlinePage, HttpServletRequest request) {
		List<JinaliZhengshuEntity> jinaliZhengshuList =  jianliOnlinePage.getJinaliZhengshuList();
		List<JianliJiaoyuEntity> jianliJiaoyuList =  jianliOnlinePage.getJianliJiaoyuList();
		List<JianliJingyanEntity> jianliJingyanList =  jianliOnlinePage.getJianliJingyanList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			jianliOnlineService.updateMain(jianliOnline, jinaliZhengshuList,jianliJiaoyuList,jianliJingyanList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新实时人才库失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 实时人才库新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(JianliOnlineEntity jianliOnline, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(jianliOnline.getId())) {
			jianliOnline = jianliOnlineService.getEntity(JianliOnlineEntity.class, jianliOnline.getId());
			req.setAttribute("jianliOnlinePage", jianliOnline);
		}
		return new ModelAndView("com/jeecg/qpwl/talentpool/jianliOnline-add");
	}
	
	/**
	 * 实时人才库编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(JianliOnlineEntity jianliOnline, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(jianliOnline.getId())) {
			jianliOnline = jianliOnlineService.getEntity(JianliOnlineEntity.class, jianliOnline.getId());
			req.setAttribute("jianliOnlinePage", jianliOnline);
		}
		return new ModelAndView("com/jeecg/qpwl/talentpool/jianliOnline-update");
	}
	
	
	/**
	 * 加载明细列表[获取证书]
	 * 
	 * @return
	 */
	@RequestMapping(params = "jinaliZhengshuList")
	public ModelAndView jinaliZhengshuList(JianliOnlineEntity jianliOnline, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = jianliOnline.getId();
		//===================================================================================
		//查询-获取证书
	    String hql0 = "from JinaliZhengshuEntity where 1 = 1 AND rESUME_ID = ? ";
	    try{
	    	List<JinaliZhengshuEntity> jinaliZhengshuEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("jinaliZhengshuList", jinaliZhengshuEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/qpwl/talentpool/jinaliZhengshuList");
	}
	
	/**
	 * 加载明细列表[学历教育]
	 * 
	 * @return
	 */
	@RequestMapping(params = "jianliJiaoyuList")
	public ModelAndView jianliJiaoyuList(JianliOnlineEntity jianliOnline, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = jianliOnline.getId();
		//===================================================================================
		//查询-学历教育
	    String hql1 = "from JianliJiaoyuEntity where 1 = 1 AND rESUME_ID = ? ";
	    try{
	    	List<JianliJiaoyuEntity> jianliJiaoyuEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("jianliJiaoyuList", jianliJiaoyuEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/qpwl/talentpool/jianliJiaoyuList");
	}
	/**
	 * 加载明细列表[工作经验]
	 * 
	 * @return
	 */
	@RequestMapping(params = "jianliJingyanList")
	public ModelAndView jianliJingyanList(JianliOnlineEntity jianliOnline, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id2 = jianliOnline.getId();
		//===================================================================================
		//查询-工作经验
	    String hql2 = "from JianliJingyanEntity where 1 = 1 AND rESUME_ID = ? ";
	    try{
	    	List<JianliJingyanEntity> jianliJingyanEntityList = systemService.findHql(hql2,id2);
			req.setAttribute("jianliJingyanList", jianliJingyanEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/qpwl/talentpool/jianliJingyanList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(JianliOnlineEntity jianliOnline,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(JianliOnlineEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, jianliOnline);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<JianliOnlineEntity> list=this.jianliOnlineService.getListByCriteriaQuery(cq, false);
    	List<JianliOnlinePage> pageList=new ArrayList<JianliOnlinePage>();
        if(list!=null&&list.size()>0){
        	for(JianliOnlineEntity entity:list){
        		try{
        		JianliOnlinePage page=new JianliOnlinePage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from JinaliZhengshuEntity where 1 = 1 AND rESUME_ID = ? ";
        	        List<JinaliZhengshuEntity> jinaliZhengshuEntityList = systemService.findHql(hql0,id0);
            		page.setJinaliZhengshuList(jinaliZhengshuEntityList);
            	    Object id1 = entity.getId();
				    String hql1 = "from JianliJiaoyuEntity where 1 = 1 AND rESUME_ID = ? ";
        	        List<JianliJiaoyuEntity> jianliJiaoyuEntityList = systemService.findHql(hql1,id1);
            		page.setJianliJiaoyuList(jianliJiaoyuEntityList);
            	    Object id2 = entity.getId();
				    String hql2 = "from JianliJingyanEntity where 1 = 1 AND rESUME_ID = ? ";
        	        List<JianliJingyanEntity> jianliJingyanEntityList = systemService.findHql(hql2,id2);
            		page.setJianliJingyanList(jianliJingyanEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"实时人才库");
        map.put(NormalExcelConstants.CLASS,JianliOnlinePage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("实时人才库列表", "导出人:Jeecg",
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
				List<JianliOnlinePage> list =  ExcelImportUtil.importExcel(file.getInputStream(), JianliOnlinePage.class, params);
				JianliOnlineEntity entity1=null;
				for (JianliOnlinePage page : list) {
					entity1=new JianliOnlineEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            jianliOnlineService.addMain(entity1, page.getJinaliZhengshuList(),page.getJianliJiaoyuList(),page.getJianliJingyanList());
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
		map.put(NormalExcelConstants.FILE_NAME,"实时人才库");
		map.put(NormalExcelConstants.CLASS,JianliOnlinePage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("实时人才库列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "jianliOnlineController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<JianliOnlineEntity> list() {
		List<JianliOnlineEntity> listJianliOnlines=jianliOnlineService.getList(JianliOnlineEntity.class);
		return listJianliOnlines;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		JianliOnlineEntity task = jianliOnlineService.get(JianliOnlineEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody JianliOnlinePage jianliOnlinePage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<JianliOnlinePage>> failures = validator.validate(jianliOnlinePage);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		List<JinaliZhengshuEntity> jinaliZhengshuList =  jianliOnlinePage.getJinaliZhengshuList();
		List<JianliJiaoyuEntity> jianliJiaoyuList =  jianliOnlinePage.getJianliJiaoyuList();
		List<JianliJingyanEntity> jianliJingyanList =  jianliOnlinePage.getJianliJingyanList();
		
		JianliOnlineEntity jianliOnline = new JianliOnlineEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(jianliOnline,jianliOnlinePage);
		}catch(Exception e){
            logger.info(e.getMessage());
        }
		jianliOnlineService.addMain(jianliOnline, jinaliZhengshuList,jianliJiaoyuList,jianliJingyanList);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = jianliOnlinePage.getId();
		URI uri = uriBuilder.path("/rest/jianliOnlineController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody JianliOnlinePage jianliOnlinePage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<JianliOnlinePage>> failures = validator.validate(jianliOnlinePage);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		List<JinaliZhengshuEntity> jinaliZhengshuList =  jianliOnlinePage.getJinaliZhengshuList();
		List<JianliJiaoyuEntity> jianliJiaoyuList =  jianliOnlinePage.getJianliJiaoyuList();
		List<JianliJingyanEntity> jianliJingyanList =  jianliOnlinePage.getJianliJingyanList();
		
		JianliOnlineEntity jianliOnline = new JianliOnlineEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(jianliOnline,jianliOnlinePage);
		}catch(Exception e){
            logger.info(e.getMessage());
        }
		jianliOnlineService.updateMain(jianliOnline, jinaliZhengshuList,jianliJiaoyuList,jianliJingyanList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		JianliOnlineEntity jianliOnline = jianliOnlineService.get(JianliOnlineEntity.class, id);
		jianliOnlineService.delMain(jianliOnline);
	}
}
