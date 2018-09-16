package com.jeecg.qpwl.talentpool.controller;
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
import com.jeecg.qpwl.core.ProcessEngineI;
import com.jeecg.qpwl.order.entity.TOrderIngEntity;
import com.jeecg.qpwl.orderflow.entity.TFlowExampleEntity;
import com.jeecg.qpwl.talentpool.entity.JianliBusinessEntity;
import com.jeecg.qpwl.talentpool.entity.JianliBusinessJiaoyuEntity;
import com.jeecg.qpwl.talentpool.entity.JianliBusinessJingyanEntity;
import com.jeecg.qpwl.talentpool.entity.JianliJiaoyuEntity;
import com.jeecg.qpwl.talentpool.entity.JianliJingyanEntity;
import com.jeecg.qpwl.talentpool.entity.JianliOnlineEntity;
import com.jeecg.qpwl.talentpool.entity.JianliXiaofenEntity;
import com.jeecg.qpwl.talentpool.entity.JinaliBusinessZhengshuEntity;
import com.jeecg.qpwl.talentpool.entity.JinaliZhengshuEntity;
import com.jeecg.qpwl.talentpool.page.JianliBusinessPage;
import com.jeecg.qpwl.talentpool.page.JianliOnlinePage;
import com.jeecg.qpwl.talentpool.service.JianliBusinessServiceI;

/**   
 * @Title: Controller
 * @Description: 企业人才库
 * @author onlineGenerator
 * @date 2018-01-03 15:03:15
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/jianliBusinessController")
public class JianliBusinessController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(JianliBusinessController.class);

	@Autowired
	private JianliBusinessServiceI jianliBusinessService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private ProcessEngineI processEngine;//流程引擎

	/**
	 * 企业人才库列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/qpwl/talentpool/jianliBusinessList");
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
	public void datagrid(JianliBusinessEntity jianliBusiness,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		try{
			JSONObject paramObj = JSONObject.fromObject(jianliBusiness);
			paramObj.put("ageStart",request.getParameter("ageStart"));//起始年龄
			paramObj.put("ageEnd",request.getParameter("ageEnd"));//结束年龄
			this.jianliBusinessService.qryAll(dataGrid,paramObj);
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
	public ModelAndView doResumeView(JianliBusinessEntity jianliBusines, HttpServletRequest req){
		if (StringUtil.isNotEmpty(jianliBusines.getId())) {
			//获取简历信息
			JianliOnlinePage page=new JianliOnlinePage();
			try{
				jianliBusines = systemService.getEntity(JianliBusinessEntity.class, jianliBusines.getId());
				String hql = "from JianliXiaofenEntity where 1 = 1 AND rESUME_ID = ? and USER_ID='"+ResourceUtil.getSessionUser().getId()+"' ";
				List<JianliXiaofenEntity> xiaofenList = systemService.findHql(hql,jianliBusines.getId());
				if(req.getParameter("viewFrom") != null && "jianli_business".equals(req.getParameter("viewFrom")) && xiaofenList.size()<1){
					jianliBusines.setMobile("137********");
				}
				MyBeanUtils.copyBeanNotNull2Bean(jianliBusines,page);
				//获取简历被查看的次数
				List<Map<String,Object>> retList = systemService.findListbySql("select * from jianli_xiaofen where resume_id='"+jianliBusines.getId()+"'");
				page.setLookNum(retList.size()+"");
				
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
	 * 获取联系方式
	 * @param jianliOnline
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "doQueryPhoneNo")
	@ResponseBody
	public AjaxJson doQueryPhoneNo(JianliBusinessEntity businessJlianli, HttpServletRequest req){
		AjaxJson j = new AjaxJson();
		businessJlianli = systemService.getEntity(JianliBusinessEntity.class, businessJlianli.getId());
		String message = "获取联系方式成功";
		try{
			FlowResult flowResult = jianliBusinessService.qryPhoneNo(businessJlianli);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			if(flowResult.getResultCode() != 0){
				message = flowResult.getResultMsg();
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
	 * 发起招聘流程
	 * 
	 * @return
	 */
	@RequestMapping(params = "doStartFlow")
	@ResponseBody
	public AjaxJson startFlow(JianliBusinessEntity businessJlianli, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		businessJlianli = jianliBusinessService.getEntity(JianliBusinessEntity.class, businessJlianli.getId());
		TOrderIngEntity orderIng = new TOrderIngEntity();
		orderIng.setName(businessJlianli.getName());
		orderIng.setResumeId(businessJlianli.getId());
		orderIng.setAge(businessJlianli.getAge());
		orderIng.setQzjob(businessJlianli.getQwzw());
		orderIng.setSex(businessJlianli.getSex());
		orderIng.setGzjy(businessJlianli.getGzjy());
		orderIng.setMqjob(businessJlianli.getMqzw());
		//判断是否有在途工单
	    String hql1 = "from TOrderIngEntity where 1 = 1 AND rESUME_ID = ? ";
		List<TOrderIngEntity> tOrderIngList = systemService.findHql(hql1,businessJlianli.getId());
		for(TOrderIngEntity tOrderIng:tOrderIngList){
			String hql2 = "from TFlowExampleEntity where 1 = 1 AND INSTANCE_ID = ? ";
			List<TFlowExampleEntity> tFlowExampleList = systemService.findHql(hql2, tOrderIng.getProcessInstanceId());
			if(tFlowExampleList.size()>0){
				j.setMsg("有人正在招聘该人员，不能发起招聘流程");
				return j;
			}
		}
		//判断是否查看过联系方式(没查看过联系方式，不允许发起招聘流程)
		String hql = "from JianliXiaofenEntity where 1 = 1 AND rESUME_ID = ? and USER_ID='"+ResourceUtil.getSessionUser().getId()+"' ";
		List<JianliXiaofenEntity> xiaofenList = systemService.findHql(hql,businessJlianli.getId());
		if(xiaofenList.size() < 1){
			j.setMsg("您还没有查看过联系方式，不能发起招聘流程。请先联系后再发起");
			return j;
		}
		FlowResult result = processEngine.startFlow("qpwl_test",ResourceUtil.getSessionUser(),new JSONObject());
		if(result.getResultCode() == 0){
			if(result.getResultData() != null && !result.getResultData().optString("instance_id","").equals("")){
				orderIng.setProcessInstanceId(result.getResultData().optString("instance_id",""));
				orderIng.setCreateUserId(ResourceUtil.getSessionUser().getId());
				orderIng.setCreateUserName(ResourceUtil.getSessionUser().getUserName());
				jianliBusinessService.save(orderIng);
				j.setMsg("起流程成功");
			}else{
				j.setMsg(result.getResultMsg());
			}
			j.setMsg("起流程成功");
		}else{
			j.setMsg(result.getResultMsg());
		}
		return j;
	}
	
	/**
	 * 删除企业人才库
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(JianliBusinessEntity jianliBusiness, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		jianliBusiness = systemService.getEntity(JianliBusinessEntity.class, jianliBusiness.getId());
		String message = "企业人才库删除成功";
		try{
			jianliBusinessService.delMain(jianliBusiness);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "企业人才库删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除企业人才库
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "企业人才库删除成功";
		try{
			for(String id:ids.split(",")){
				JianliBusinessEntity jianliBusiness = systemService.getEntity(JianliBusinessEntity.class,
				id
				);
				jianliBusinessService.delMain(jianliBusiness);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "企业人才库删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加企业人才库
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(JianliBusinessEntity jianliBusiness,JianliBusinessPage jianliBusinessPage, HttpServletRequest request) {
		List<JianliBusinessJiaoyuEntity> jianliBusinessJiaoyuList =  jianliBusinessPage.getJianliBusinessJiaoyuList();
		List<JianliBusinessJingyanEntity> jianliBusinessJingyanList =  jianliBusinessPage.getJianliBusinessJingyanList();
		List<JinaliBusinessZhengshuEntity> jinaliBusinessZhengshuList =  jianliBusinessPage.getJinaliBusinessZhengshuList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			jianliBusinessService.addMain(jianliBusiness, jianliBusinessJiaoyuList,jianliBusinessJingyanList,jinaliBusinessZhengshuList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "企业人才库添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新企业人才库
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(JianliBusinessEntity jianliBusiness,JianliBusinessPage jianliBusinessPage, HttpServletRequest request) {
		List<JianliBusinessJiaoyuEntity> jianliBusinessJiaoyuList =  jianliBusinessPage.getJianliBusinessJiaoyuList();
		List<JianliBusinessJingyanEntity> jianliBusinessJingyanList =  jianliBusinessPage.getJianliBusinessJingyanList();
		List<JinaliBusinessZhengshuEntity> jinaliBusinessZhengshuList =  jianliBusinessPage.getJinaliBusinessZhengshuList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			jianliBusinessService.updateMain(jianliBusiness, jianliBusinessJiaoyuList,jianliBusinessJingyanList,jinaliBusinessZhengshuList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新企业人才库失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 企业人才库新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(JianliBusinessEntity jianliBusiness, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(jianliBusiness.getId())) {
			jianliBusiness = jianliBusinessService.getEntity(JianliBusinessEntity.class, jianliBusiness.getId());
			req.setAttribute("jianliBusinessPage", jianliBusiness);
		}
		return new ModelAndView("com/jeecg/qpwl/talentpool/jianliOnline-add");
	}
	
	/**
	 * 企业人才库编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(JianliBusinessEntity jianliBusiness, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(jianliBusiness.getId())) {
			jianliBusiness = jianliBusinessService.getEntity(JianliBusinessEntity.class, jianliBusiness.getId());
			req.setAttribute("jianliBusinessPage", jianliBusiness);
		}
		return new ModelAndView("com/jeecg/qpwl/talentpool/jianliBusiness-update");
	}
	
	
	/**
	 * 加载明细列表[学历教育]
	 * 
	 * @return
	 */
	@RequestMapping(params = "jianliBusinessJiaoyuList")
	public ModelAndView jianliBusinessJiaoyuList(JianliBusinessEntity jianliBusiness, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = jianliBusiness.getId();
		//===================================================================================
		//查询-学历教育
	    String hql0 = "from JianliBusinessJiaoyuEntity where 1 = 1 AND rESUME_ID = ? ";
	    try{
	    	List<JianliBusinessJiaoyuEntity> jianliBusinessJiaoyuEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("jianliBusinessJiaoyuList", jianliBusinessJiaoyuEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/qpwl/talentpool/jianliBusinessJiaoyuList");
	}
	/**
	 * 加载明细列表[工作经验]
	 * 
	 * @return
	 */
	@RequestMapping(params = "jianliBusinessJingyanList")
	public ModelAndView jianliBusinessJingyanList(JianliBusinessEntity jianliBusiness, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = jianliBusiness.getId();
		//===================================================================================
		//查询-工作经验
	    String hql1 = "from JianliBusinessJingyanEntity where 1 = 1 AND rESUME_ID = ? ";
	    try{
	    	List<JianliBusinessJingyanEntity> jianliBusinessJingyanEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("jianliBusinessJingyanList", jianliBusinessJingyanEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/qpwl/talentpool/jianliBusinessJingyanList");
	}
	/**
	 * 加载明细列表[获取证书]
	 * 
	 * @return
	 */
	@RequestMapping(params = "jinaliBusinessZhengshuList")
	public ModelAndView jinaliBusinessZhengshuList(JianliBusinessEntity jianliBusiness, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id2 = jianliBusiness.getId();
		//===================================================================================
		//查询-获取证书
	    String hql2 = "from JinaliBusinessZhengshuEntity where 1 = 1 AND rESUME_ID = ? ";
	    try{
	    	List<JinaliBusinessZhengshuEntity> jinaliBusinessZhengshuEntityList = systemService.findHql(hql2,id2);
			req.setAttribute("jinaliBusinessZhengshuList", jinaliBusinessZhengshuEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/qpwl/talentpool/jinaliBusinessZhengshuList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(JianliBusinessEntity jianliBusiness,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(JianliBusinessEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, jianliBusiness);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<JianliBusinessEntity> list=this.jianliBusinessService.getListByCriteriaQuery(cq, false);
    	List<JianliBusinessPage> pageList=new ArrayList<JianliBusinessPage>();
        if(list!=null&&list.size()>0){
        	for(JianliBusinessEntity entity:list){
        		try{
        		JianliBusinessPage page=new JianliBusinessPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from JianliBusinessJiaoyuEntity where 1 = 1 AND rESUME_ID = ? ";
        	        List<JianliBusinessJiaoyuEntity> jianliBusinessJiaoyuEntityList = systemService.findHql(hql0,id0);
            		page.setJianliBusinessJiaoyuList(jianliBusinessJiaoyuEntityList);
            	    Object id1 = entity.getId();
				    String hql1 = "from JianliBusinessJingyanEntity where 1 = 1 AND rESUME_ID = ? ";
        	        List<JianliBusinessJingyanEntity> jianliBusinessJingyanEntityList = systemService.findHql(hql1,id1);
            		page.setJianliBusinessJingyanList(jianliBusinessJingyanEntityList);
            	    Object id2 = entity.getId();
				    String hql2 = "from JinaliBusinessZhengshuEntity where 1 = 1 AND rESUME_ID = ? ";
        	        List<JinaliBusinessZhengshuEntity> jinaliBusinessZhengshuEntityList = systemService.findHql(hql2,id2);
            		page.setJinaliBusinessZhengshuList(jinaliBusinessZhengshuEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"企业人才库");
        map.put(NormalExcelConstants.CLASS,JianliBusinessPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("企业人才库列表", "导出人:Jeecg",
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
				List<JianliBusinessPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), JianliBusinessPage.class, params);
				JianliBusinessEntity entity1=null;
				for (JianliBusinessPage page : list) {
					entity1=new JianliBusinessEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            jianliBusinessService.addMain(entity1, page.getJianliBusinessJiaoyuList(),page.getJianliBusinessJingyanList(),page.getJinaliBusinessZhengshuList());
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
		map.put(NormalExcelConstants.FILE_NAME,"企业人才库");
		map.put(NormalExcelConstants.CLASS,JianliBusinessPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("企业人才库列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
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
		req.setAttribute("controller_name", "jianliBusinessController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
 	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<JianliBusinessEntity> list() {
		List<JianliBusinessEntity> listJianliBusinesss=jianliBusinessService.getList(JianliBusinessEntity.class);
		return listJianliBusinesss;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		JianliBusinessEntity task = jianliBusinessService.get(JianliBusinessEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}
 	
 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody JianliBusinessPage jianliBusinessPage, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<JianliBusinessPage>> failures = validator.validate(jianliBusinessPage);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		List<JianliBusinessJiaoyuEntity> jianliBusinessJiaoyuList =  jianliBusinessPage.getJianliBusinessJiaoyuList();
		List<JianliBusinessJingyanEntity> jianliBusinessJingyanList =  jianliBusinessPage.getJianliBusinessJingyanList();
		List<JinaliBusinessZhengshuEntity> jinaliBusinessZhengshuList =  jianliBusinessPage.getJinaliBusinessZhengshuList();
		
		JianliBusinessEntity jianliBusiness = new JianliBusinessEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(jianliBusiness,jianliBusinessPage);
		}catch(Exception e){
            logger.info(e.getMessage());
        }
		jianliBusinessService.addMain(jianliBusiness, jianliBusinessJiaoyuList,jianliBusinessJingyanList,jinaliBusinessZhengshuList);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = jianliBusinessPage.getId();
		URI uri = uriBuilder.path("/rest/jianliBusinessController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody JianliBusinessPage jianliBusinessPage) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<JianliBusinessPage>> failures = validator.validate(jianliBusinessPage);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		List<JianliBusinessJiaoyuEntity> jianliBusinessJiaoyuList =  jianliBusinessPage.getJianliBusinessJiaoyuList();
		List<JianliBusinessJingyanEntity> jianliBusinessJingyanList =  jianliBusinessPage.getJianliBusinessJingyanList();
		List<JinaliBusinessZhengshuEntity> jinaliBusinessZhengshuList =  jianliBusinessPage.getJinaliBusinessZhengshuList();
		
		JianliBusinessEntity jianliBusiness = new JianliBusinessEntity();
		try{
			MyBeanUtils.copyBeanNotNull2Bean(jianliBusiness,jianliBusinessPage);
		}catch(Exception e){
            logger.info(e.getMessage());
        }
		jianliBusinessService.updateMain(jianliBusiness, jianliBusinessJiaoyuList,jianliBusinessJingyanList,jinaliBusinessZhengshuList);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		JianliBusinessEntity jianliBusiness = jianliBusinessService.get(JianliBusinessEntity.class, id);
		jianliBusinessService.delMain(jianliBusiness);
	}
}
