package com.jeecg.qp.jobtype.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.UpdateUtils;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSUserOrg;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeecg.qp.jobtype.entity.QpJobtypeEntity;
import com.jeecg.qp.jobtype.entity.QpJobtypeEntity2;
import com.jeecg.qp.jobtype.service.QpJobtypeServiceI;

/**   
 * @Title: Controller  
 * @Description: 简历职位管理
 * @author onlineGenerator
 * @date 2017-12-30 20:31:43
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/qpJobtypeController")
public class QpJobtypeController extends BaseController {
 
	private static final Logger logger = Logger.getLogger(QpJobtypeController.class);

	@Autowired
	private QpJobtypeServiceI qpJobtypeService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	
 
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/qp/jobtype/qpJobtypeList");
	}
	 
	@RequestMapping(params = "sqjobtype")
	public ModelAndView sqjobtype(QpJobtypeEntity jobtypeEntity, HttpServletRequest req) {
		jobtypeEntity = systemService.getEntity(QpJobtypeEntity.class, jobtypeEntity.getId());
		req.setAttribute("jobtype", jobtypeEntity);
		return new ModelAndView("com/jeecg/qp/jobtype/sqjobtype");
	}
 
	@RequestMapping(params = "datagrid")
	public void datagrid(QpJobtypeEntity qpJobtype,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(QpJobtypeEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, qpJobtype, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.qpJobtypeService.getDataGridReturn(cq, true);
		
		for (Object  obj : dataGrid.getResults()) {
			QpJobtypeEntity jf=(QpJobtypeEntity)obj;
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
		
		TagUtil.datagrid(response, dataGrid);
	}
 
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(QpJobtypeEntity qpJobtype, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		qpJobtype = systemService.getEntity(QpJobtypeEntity.class, qpJobtype.getId());
		message = "简历职位管理删除成功";
		try{
			qpJobtypeService.delete(qpJobtype);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "简历职位管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
 
	@RequestMapping(params = "saveJobType")
	@ResponseBody
	public AjaxJson saveJobType(QpJobtypeEntity qpJobtype, HttpServletRequest request) {
		logger.info("111111111111222222222");
		AjaxJson j = new AjaxJson();
		String message = "简历职位成功";
		try{
			QpJobtypeEntity2 qpJobtype2 = systemService.getEntity(QpJobtypeEntity2.class, qpJobtype.getId());
			 
			UpdateUtils.copyNonNullProperties(qpJobtype, qpJobtype2);
			
			systemService.saveOrUpdate(qpJobtype2);
			//qpJobtypeService.executeSql("update qp_jobtype set jobtype_code=?,jobtype_name=? where id=?", qpJobtype.getJobtypeCode(),qpJobtype.getJobtypeName(),qpJobtype.getId());
			//qpJobtypeService.executeSql("update qp_jobtype set jobtype1=?,jobtype2=? where id=?", qpJobtype.getJobtype1(),qpJobtype.getJobtype2(),qpJobtype.getId());
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "简历职位管理失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}  
    
}
