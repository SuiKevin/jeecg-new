package com.jeecg.qpwl.talentpool.service.impl;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.List;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.qpwl.comInf.ComonInf;
import com.jeecg.qpwl.core.FlowResult;
import com.jeecg.qpwl.talentpool.entity.JianliBusinessEntity;
import com.jeecg.qpwl.talentpool.entity.JianliBusinessJiaoyuEntity;
import com.jeecg.qpwl.talentpool.entity.JianliBusinessJingyanEntity;
import com.jeecg.qpwl.talentpool.entity.JianliOnlineEntity;
import com.jeecg.qpwl.talentpool.entity.JianliXiaofenEntity;
import com.jeecg.qpwl.talentpool.entity.JinaliBusinessZhengshuEntity;
import com.jeecg.qpwl.talentpool.service.JianliBusinessServiceI;
import com.jeecg.qpwl.utils.TelNoCreate;


@Service("jianliBusinessService")
@Transactional
public class JianliBusinessServiceImpl extends CommonServiceImpl implements JianliBusinessServiceI {
	
	@Autowired
	private ComonInf comInf;
	@Autowired
	private SystemService systemService;
	
	/**
	 * 查询所有数据
	 * @param dataGrid
	 * @throws Exception
	 */
	public void qryAll(DataGrid dataGrid,JSONObject paramObj)throws Exception{
		StringBuffer qrySQL = new StringBuffer();
		qrySQL.append("select * from ( ");
		qrySQL.append("select tl.id as id,tl.website as website,tl.province as province,tl.xueli as xueli,tl.xjzd as xjzd,tl.qwgzd,tl.city as city,tl.town as town,tl.jobtype1 as jobtype1,tl.jobtype2 as jobtype2,tl.jobtype3 as jobtype3, ")
			.append("tl.`name`,tl.sex as sex,tl.age ,tl.mobile,tl.email as email,tl.gzjy as gzjy,tl.qwzw as qwzw,tl.mqzw as mqzw,tl.qwxz as qwxz,'1' as isMyLooked ")
			.append(",DATE_FORMAT(tl.gxsj  ,'%Y/%m/%d %H:%i') as gxsj from jianli_business tl ")
			.append("where tl.id in (SELECT tx.resume_id from jianli_xiaofen tx where tx.user_id='"+ResourceUtil.getSessionUser().getId()+"') ");
		if(!"".equals(paramObj.optString("ageStart", "")) && null != paramObj.optString("ageStart", "")){
			qrySQL.append(" and tl.age >="+paramObj.optString("ageStart", ""));
		}
		if(!"".equals(paramObj.optString("ageEnd", "")) && null != paramObj.optString("ageEnd", "")){
			qrySQL.append(" and tl.age <="+paramObj.optString("ageEnd", ""));
		}
		if(!"".equals(paramObj.optString("province", "")) && null != paramObj.optString("province", "")){
			qrySQL.append(" and tl.province = '"+paramObj.optString("province", "")+"'");
		}else{
			if(!ResourceUtil.getSessionUser().getUserName().equals("admin")){//超级管理员不受权限控制
				//查找组织对应的省份
				StringBuffer provinceBuffer = new StringBuffer();
				provinceBuffer.append("( ");
				TSDepart depart = this.systemService.get(TSDepart.class, ResourceUtil.getSessionUser().getDepartid());
				String provinces[] = depart.getProvince().split(",");
				for(int i=0;i<provinces.length;i++){
					provinceBuffer.append("'"+provinces[i]+"',");
				}
				provinceBuffer.append("'')");
				qrySQL.append(" and tl.province in " + provinceBuffer.toString());
			}
		}
		if(!"".equals(paramObj.optString("city", "")) && null != paramObj.optString("city", "")){
			qrySQL.append(" and tl.city = '"+paramObj.optString("city", "")+"'");
		}else{
			if(!ResourceUtil.getSessionUser().getUserName().equals("admin")){//超级管理员不受权限控制
				//查找组织对应的省份
				StringBuffer provinceBuffer = new StringBuffer();
				provinceBuffer.append("( ");
				TSDepart depart = this.systemService.get(TSDepart.class, ResourceUtil.getSessionUser().getDepartid());
				String provinces[] = depart.getCity().split(",");
				for(int i=0;i<provinces.length;i++){
					provinceBuffer.append("'"+provinces[i]+"',");
				}
				provinceBuffer.append("'')");
				qrySQL.append(" and tl.city in " + provinceBuffer.toString());
			}
		}
		if(!"".equals(paramObj.optString("town", "")) && null != paramObj.optString("town", "")){
			qrySQL.append(" and tl.town = '"+paramObj.optString("town", "")+"'");
		}else{
			if(!ResourceUtil.getSessionUser().getUserName().equals("admin")){//超级管理员不受权限控制
				//查找组织对应的省份
				StringBuffer provinceBuffer = new StringBuffer();
				provinceBuffer.append("( ");
				TSDepart depart = this.systemService.get(TSDepart.class, ResourceUtil.getSessionUser().getDepartid());
				String provinces[] = depart.getTown().split(",");
				for(int i=0;i<provinces.length;i++){
					provinceBuffer.append("'"+provinces[i]+"',");
				}
				provinceBuffer.append("'')");
				qrySQL.append(" and tl.town in " + provinceBuffer.toString());
			}
		}
		if(!"".equals(paramObj.optString("jobtype1", "")) && null != paramObj.optString("jobtype1", "")){
			qrySQL.append(" and tl.jobtype1 = '"+paramObj.optString("jobtype1", "")+"'");
		}
		if(!"".equals(paramObj.optString("jobtype2", "")) && null != paramObj.optString("jobtype2", "")){
			qrySQL.append(" and tl.jobtype2 = '"+paramObj.optString("jobtype2", "")+"'");
		}
		if(!"".equals(paramObj.optString("jobtype3", "")) && null != paramObj.optString("jobtype3", "")){
			qrySQL.append(" and tl.jobtype3 = '"+paramObj.optString("jobtype3", "")+"'");
		}
		if(!"".equals(paramObj.optString("qwgz", "")) && null != paramObj.optString("qwgz", "")){
			qrySQL.append(" and tl.qwgz = '"+paramObj.optString("qwgz", "")+"'");
		}
		if(!"".equals(paramObj.optString("gzjy", "")) && null != paramObj.optString("gzjy", "")){
			qrySQL.append(" and tl.gzjy = '"+paramObj.optString("gzjy", "")+"'");
		}
		if(!"".equals(paramObj.optString("sex", "")) && null != paramObj.optString("sex", "")){
			qrySQL.append(" and tl.sex = '"+paramObj.optString("sex", "")+"'");
		}
		if(!"".equals(paramObj.optString("qwgzd", "")) && null != paramObj.optString("qwgzd", "")){
			qrySQL.append(" and tl.qwgzd like '%"+paramObj.optString("qwgzd", "")+"%'");
		}
		if(!"".equals(paramObj.optString("qwzw", "")) && null != paramObj.optString("qwzw", "")){
			qrySQL.append(" and tl.qwzw like '%"+paramObj.optString("qwzw", "")+"%'");
		}
		if(!"".equals(paramObj.optString("qwxz", "")) && null != paramObj.optString("qwxz","")){
			qrySQL.append(" and tl.qwxz = '"+paramObj.optString("qwxz", "")+"'");
		}
		qrySQL.append(" union ")
			.append("select tl.id as id,tl.website as website,tl.province as province,tl.xueli as xueli,tl.xjzd as xjzd,tl.qwgzd,tl.city as city,tl.town as town,tl.jobtype1 as jobtype1,tl.jobtype2 as jobtype2,tl.jobtype3 as jobtype3, ")
			.append("tl.`name`,tl.sex as sex,tl.age ,'137********' as mobile,tl.email as email,tl.gzjy as gzjy,tl.qwzw as qwzw,tl.mqzw as mqzw,tl.qwxz as qwxz,'0' as isMyLooked ")
			.append(",DATE_FORMAT(tl.gxsj  ,'%Y/%m/%d %H:%i') as gxsj from jianli_business tl ")
			.append("where tl.id not in (SELECT tx.resume_id from jianli_xiaofen tx where tx.user_id='"+ResourceUtil.getSessionUser().getId()+"') ");
		if(!"".equals(paramObj.optString("ageStart", "")) && null != paramObj.optString("ageStart", "")){
			qrySQL.append(" and tl.age >="+paramObj.optString("ageStart", ""));
		}
		if(!"".equals(paramObj.optString("ageEnd", "")) && null != paramObj.optString("ageEnd", "")){
			qrySQL.append(" and tl.age <="+paramObj.optString("ageEnd", ""));
		}
		if(!"".equals(paramObj.optString("province", "")) && null != paramObj.optString("province", "")){
			qrySQL.append(" and tl.province = '"+paramObj.optString("province", "")+"'");
		}else{
			if(!ResourceUtil.getSessionUser().getUserName().equals("admin")){//超级管理员不受权限控制
				//查找组织对应的省份
				StringBuffer provinceBuffer = new StringBuffer();
				provinceBuffer.append("( ");
				TSDepart depart = this.systemService.get(TSDepart.class, ResourceUtil.getSessionUser().getDepartid());
				String provinces[] = depart.getProvince().split(",");
				for(int i=0;i<provinces.length;i++){
					provinceBuffer.append("'"+provinces[i]+"',");
				}
				provinceBuffer.append("'')");
				qrySQL.append(" and tl.province in " + provinceBuffer.toString());
			}
		}
		if(!"".equals(paramObj.optString("city", "")) && null != paramObj.optString("city", "")){
			qrySQL.append(" and tl.city = '"+paramObj.optString("city", "")+"'");
		}else{
			if(!ResourceUtil.getSessionUser().getUserName().equals("admin")){//超级管理员不受权限控制
				//查找组织对应的省份
				StringBuffer provinceBuffer = new StringBuffer();
				provinceBuffer.append("( ");
				TSDepart depart = this.systemService.get(TSDepart.class, ResourceUtil.getSessionUser().getDepartid());
				String provinces[] = depart.getCity().split(",");
				for(int i=0;i<provinces.length;i++){
					provinceBuffer.append("'"+provinces[i]+"',");
				}
				provinceBuffer.append("'')");
				qrySQL.append(" and tl.city in " + provinceBuffer.toString());
			}
		}
		if(!"".equals(paramObj.optString("town", "")) && null != paramObj.optString("town", "")){
			qrySQL.append(" and tl.town = '"+paramObj.optString("town", "")+"'");
		}else{
			if(!ResourceUtil.getSessionUser().getUserName().equals("admin")){//超级管理员不受权限控制
				//查找组织对应的省份
				StringBuffer provinceBuffer = new StringBuffer();
				provinceBuffer.append("( ");
				TSDepart depart = this.systemService.get(TSDepart.class, ResourceUtil.getSessionUser().getDepartid());
				String provinces[] = depart.getTown().split(",");
				for(int i=0;i<provinces.length;i++){
					provinceBuffer.append("'"+provinces[i]+"',");
				}
				provinceBuffer.append("'')");
				qrySQL.append(" and tl.town in " + provinceBuffer.toString());
			}
		}
		if(!"".equals(paramObj.optString("jobtype1", "")) && null != paramObj.optString("jobtype1", "")){
			qrySQL.append(" and tl.jobtype1 = '"+paramObj.optString("jobtype1", "")+"'");
		}
		if(!"".equals(paramObj.optString("jobtype2", "")) && null != paramObj.optString("jobtype2", "")){
			qrySQL.append(" and tl.jobtype2 = '"+paramObj.optString("jobtype2", "")+"'");
		}
		if(!"".equals(paramObj.optString("jobtype3", "")) && null != paramObj.optString("jobtype3", "")){
			qrySQL.append(" and tl.jobtype3 = '"+paramObj.optString("jobtype3", "")+"'");
		}
		if(!"".equals(paramObj.optString("qwgz", "")) && null != paramObj.optString("qwgz", "")){
			qrySQL.append(" and tl.qwgz = '"+paramObj.optString("qwgz", "")+"'");
		}
		if(!"".equals(paramObj.optString("gzjy", "")) && null != paramObj.optString("gzjy", "")){
			qrySQL.append(" and tl.gzjy = '"+paramObj.optString("gzjy", "")+"'");
		}
		if(!"".equals(paramObj.optString("sex", "")) && null != paramObj.optString("sex", "")){
			qrySQL.append(" and tl.sex = '"+paramObj.optString("sex", "")+"'");
		}
		if(!"".equals(paramObj.optString("qwgzd", "")) && null != paramObj.optString("qwgzd", "")){
			qrySQL.append(" and tl.qwgzd like '%"+paramObj.optString("qwgzd", "")+"%'");
		}
		if(!"".equals(paramObj.optString("qwzw", "")) && null != paramObj.optString("qwzw", "")){
			qrySQL.append(" and tl.qwzw like '%"+paramObj.optString("qwzw", "")+"%'");
		}
		if(!"".equals(paramObj.optString("qwxz", "")) && null != paramObj.optString("qwxz","")){
			qrySQL.append(" and tl.qwxz = '"+paramObj.optString("qwxz", "")+"'");
		}
		qrySQL.append(" ) temp order by gxsj desc ");
		super.findDataGridForJdbc( dataGrid,qrySQL.toString(), JianliOnlineEntity.class);
		//将隐藏号码替换成随机号码
		for(int i=0;i<dataGrid.getResults().size();i++){
			JianliOnlineEntity jianli = (JianliOnlineEntity)dataGrid.getResults().get(i);
			if("137********".equals(jianli.getMobile())){
				jianli.setMobile(TelNoCreate.getTel());
			}
	}
	}
	
	
	/**
	 * 查询电话信息
	 * @param jianliOnline
	 */
	public FlowResult qryPhoneNo(JianliBusinessEntity jianliOnline){
		FlowResult result = new FlowResult();
		//调用积分接口判断是否有积分
		result =comInf.lookPhoneNo(ResourceUtil.getSessionUser());
		//积分获取成功后，将联系电话保存到剪切板
//	     Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard(); //得到系统剪贴板    
//	     String text = jianliOnline.getMobile();    
//	     StringSelection selection = new StringSelection(text);    
//	     clipboard.setContents(selection, null); 
		if(result.getResultCode() == 0){
			//获取联系电话
			JianliXiaofenEntity jianliXiaofenEntity = new JianliXiaofenEntity();
			jianliXiaofenEntity.setId(UUID.randomUUID().toString());
			jianliXiaofenEntity.setMobile(jianliOnline.getMobile());
			jianliXiaofenEntity.setDepartId(ResourceUtil.getSessionUser().getDepartid());
			jianliXiaofenEntity.setUserId(ResourceUtil.getSessionUser().getId());
			jianliXiaofenEntity.setResumeId(jianliOnline.getId());
			super.save(jianliXiaofenEntity);
			result.setResultCode(0);
			result.setResultMsg("获取联系方式成功,请到企业库查看");
		}
		return result;
	}
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((JianliBusinessEntity)entity);
 	}
	
	public void addMain(JianliBusinessEntity jianliBusiness,
	        List<JianliBusinessJiaoyuEntity> jianliBusinessJiaoyuList,List<JianliBusinessJingyanEntity> jianliBusinessJingyanList,List<JinaliBusinessZhengshuEntity> jinaliBusinessZhengshuList){
			//保存主信息
			this.save(jianliBusiness);
		
			/**保存-学历教育*/
			for(JianliBusinessJiaoyuEntity jianliBusinessJiaoyu:jianliBusinessJiaoyuList){
				//外键设置
				jianliBusinessJiaoyu.setResumeId(jianliBusiness.getId());
				this.save(jianliBusinessJiaoyu);
			}
			/**保存-工作经验*/
			for(JianliBusinessJingyanEntity jianliBusinessJingyan:jianliBusinessJingyanList){
				//外键设置
				jianliBusinessJingyan.setResumeId(jianliBusiness.getId());
				this.save(jianliBusinessJingyan);
			}
			/**保存-获取证书*/
			for(JinaliBusinessZhengshuEntity jinaliBusinessZhengshu:jinaliBusinessZhengshuList){
				//外键设置
				jinaliBusinessZhengshu.setResumeId(jianliBusiness.getId());
				this.save(jinaliBusinessZhengshu);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(jianliBusiness);
	}

	
	public void updateMain(JianliBusinessEntity jianliBusiness,
	        List<JianliBusinessJiaoyuEntity> jianliBusinessJiaoyuList,List<JianliBusinessJingyanEntity> jianliBusinessJingyanList,List<JinaliBusinessZhengshuEntity> jinaliBusinessZhengshuList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(jianliBusiness.getId())){
			try {
				JianliBusinessEntity temp = findUniqueByProperty(JianliBusinessEntity.class, "id", jianliBusiness.getId());
				MyBeanUtils.copyBeanNotNull2Bean(jianliBusiness, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(jianliBusiness);
		}
		//===================================================================================
		//获取参数
		Object id0 = jianliBusiness.getId();
		Object id1 = jianliBusiness.getId();
		Object id2 = jianliBusiness.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-学历教育
	    String hql0 = "from JianliBusinessJiaoyuEntity where 1 = 1 AND rESUME_ID = ? ";
	    List<JianliBusinessJiaoyuEntity> jianliBusinessJiaoyuOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-学历教育
		if(jianliBusinessJiaoyuList!=null&&jianliBusinessJiaoyuList.size()>0){
		for(JianliBusinessJiaoyuEntity oldE:jianliBusinessJiaoyuOldList){
			boolean isUpdate = false;
				for(JianliBusinessJiaoyuEntity sendE:jianliBusinessJiaoyuList){
					//需要更新的明细数据-学历教育
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-学历教育
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-学历教育
			for(JianliBusinessJiaoyuEntity jianliBusinessJiaoyu:jianliBusinessJiaoyuList){
				if(oConvertUtils.isEmpty(jianliBusinessJiaoyu.getId())){
					//外键设置
					jianliBusinessJiaoyu.setResumeId(jianliBusiness.getId());
					this.save(jianliBusinessJiaoyu);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-工作经验
	    String hql1 = "from JianliBusinessJingyanEntity where 1 = 1 AND rESUME_ID = ? ";
	    List<JianliBusinessJingyanEntity> jianliBusinessJingyanOldList = this.findHql(hql1,id1);
		//2.筛选更新明细数据-工作经验
		if(jianliBusinessJingyanList!=null&&jianliBusinessJingyanList.size()>0){
		for(JianliBusinessJingyanEntity oldE:jianliBusinessJingyanOldList){
			boolean isUpdate = false;
				for(JianliBusinessJingyanEntity sendE:jianliBusinessJingyanList){
					//需要更新的明细数据-工作经验
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-工作经验
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-工作经验
			for(JianliBusinessJingyanEntity jianliBusinessJingyan:jianliBusinessJingyanList){
				if(oConvertUtils.isEmpty(jianliBusinessJingyan.getId())){
					//外键设置
					jianliBusinessJingyan.setResumeId(jianliBusiness.getId());
					this.save(jianliBusinessJingyan);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-获取证书
	    String hql2 = "from JinaliBusinessZhengshuEntity where 1 = 1 AND rESUME_ID = ? ";
	    List<JinaliBusinessZhengshuEntity> jinaliBusinessZhengshuOldList = this.findHql(hql2,id2);
		//2.筛选更新明细数据-获取证书
		if(jinaliBusinessZhengshuList!=null&&jinaliBusinessZhengshuList.size()>0){
		for(JinaliBusinessZhengshuEntity oldE:jinaliBusinessZhengshuOldList){
			boolean isUpdate = false;
				for(JinaliBusinessZhengshuEntity sendE:jinaliBusinessZhengshuList){
					//需要更新的明细数据-获取证书
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-获取证书
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-获取证书
			for(JinaliBusinessZhengshuEntity jinaliBusinessZhengshu:jinaliBusinessZhengshuList){
				if(oConvertUtils.isEmpty(jinaliBusinessZhengshu.getId())){
					//外键设置
					jinaliBusinessZhengshu.setResumeId(jianliBusiness.getId());
					this.save(jinaliBusinessZhengshu);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(jianliBusiness);
	}

	
	public void delMain(JianliBusinessEntity jianliBusiness) {
		//删除主表信息
		this.delete(jianliBusiness);
		//===================================================================================
		//获取参数
		Object id0 = jianliBusiness.getId();
		Object id1 = jianliBusiness.getId();
		Object id2 = jianliBusiness.getId();
		//===================================================================================
		//删除-学历教育
	    String hql0 = "from JianliBusinessJiaoyuEntity where 1 = 1 AND rESUME_ID = ? ";
	    List<JianliBusinessJiaoyuEntity> jianliBusinessJiaoyuOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(jianliBusinessJiaoyuOldList);
		//===================================================================================
		//删除-工作经验
	    String hql1 = "from JianliBusinessJingyanEntity where 1 = 1 AND rESUME_ID = ? ";
	    List<JianliBusinessJingyanEntity> jianliBusinessJingyanOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(jianliBusinessJingyanOldList);
		//===================================================================================
		//删除-获取证书
	    String hql2 = "from JinaliBusinessZhengshuEntity where 1 = 1 AND rESUME_ID = ? ";
	    List<JinaliBusinessZhengshuEntity> jinaliBusinessZhengshuOldList = this.findHql(hql2,id2);
		this.deleteAllEntitie(jinaliBusinessZhengshuOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(JianliBusinessEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(JianliBusinessEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(JianliBusinessEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,JianliBusinessEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{website}",String.valueOf(t.getWebsite()));
 		sql  = sql.replace("#{province}",String.valueOf(t.getProvince()));
 		sql  = sql.replace("#{city}",String.valueOf(t.getCity()));
 		sql  = sql.replace("#{town}",String.valueOf(t.getTown()));
 		sql  = sql.replace("#{jobtype1}",String.valueOf(t.getJobtype1()));
 		sql  = sql.replace("#{jobtype2}",String.valueOf(t.getJobtype2()));
 		sql  = sql.replace("#{jobtype3}",String.valueOf(t.getJobtype3()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{age}",String.valueOf(t.getAge()));
 		sql  = sql.replace("#{mobile}",String.valueOf(t.getMobile()));
 		sql  = sql.replace("#{email}",String.valueOf(t.getEmail()));
 		sql  = sql.replace("#{xueli}",String.valueOf(t.getXueli()));
 		sql  = sql.replace("#{gzjy}",String.valueOf(t.getGzjy()));
 		sql  = sql.replace("#{jg}",String.valueOf(t.getJg()));
 		sql  = sql.replace("#{xjzd}",String.valueOf(t.getXjzd()));
 		sql  = sql.replace("#{qwzw}",String.valueOf(t.getQwzw()));
 		sql  = sql.replace("#{mqzw}",String.valueOf(t.getMqzw()));
 		sql  = sql.replace("#{qwxz}",String.valueOf(t.getQwxz()));
 		sql  = sql.replace("#{qwgzd}",String.valueOf(t.getQwgzd()));
 		sql  = sql.replace("#{grbq}",String.valueOf(t.getGrbq()));
 		sql  = sql.replace("#{zwpj}",String.valueOf(t.getZwpj()));
 		sql  = sql.replace("#{xxgzjy}",String.valueOf(t.getXxgzjy()));
 		sql  = sql.replace("#{jyjl}",String.valueOf(t.getJyjl()));
 		sql  = sql.replace("#{hdzs}",String.valueOf(t.getHdzs()));
 		sql  = sql.replace("#{gxsj}",String.valueOf(t.getGxsj()));
 		sql  = sql.replace("#{bllcs}",String.valueOf(t.getBllcs()));
 		sql  = sql.replace("#{bckg}",String.valueOf(t.getBckg()));
 		sql  = sql.replace("#{zdsq}",String.valueOf(t.getZdsq()));
 		sql  = sql.replace("#{dtgxq}",String.valueOf(t.getDtgxq()));
 		sql  = sql.replace("#{bxzcs}",String.valueOf(t.getBxzcs()));
 		sql  = sql.replace("#{sdyq}",String.valueOf(t.getSdyq()));
 		sql  = sql.replace("#{lrsj}",String.valueOf(t.getLrsj()));
 		sql  = sql.replace("#{zjzp}",String.valueOf(t.getZjzp()));
 		sql  = sql.replace("#{lrfs}",String.valueOf(t.getLrfs()));
 		sql  = sql.replace("#{lrwd}",String.valueOf(t.getLrwd()));
 		sql  = sql.replace("#{lrry}",String.valueOf(t.getLrry()));
 		sql  = sql.replace("#{sfzh}",String.valueOf(t.getSfzh()));
 		sql  = sql.replace("#{mz}",String.valueOf(t.getMz()));
 		sql  = sql.replace("#{csrq}",String.valueOf(t.getCsrq()));
 		sql  = sql.replace("#{address}",String.valueOf(t.getAddress()));
 		sql  = sql.replace("#{fzjg}",String.valueOf(t.getFzjg()));
 		sql  = sql.replace("#{yxq}",String.valueOf(t.getYxq()));
 		sql  = sql.replace("#{sflrsj}",String.valueOf(t.getSflrsj()));
 		sql  = sql.replace("#{sfzlrwd}",String.valueOf(t.getSfzlrwd()));
 		sql  = sql.replace("#{sfzlrry}",String.valueOf(t.getSfzlrry()));
 		sql  = sql.replace("#{sfzsfyc}",String.valueOf(t.getSfzsfyc()));
 		sql  = sql.replace("#{hyzk}",String.valueOf(t.getHyzk()));
 		sql  = sql.replace("#{zzmm}",String.valueOf(t.getZzmm()));
 		sql  = sql.replace("#{jkzk}",String.valueOf(t.getJkzk()));
 		sql  = sql.replace("#{bsxq}",String.valueOf(t.getBsxq()));
 		sql  = sql.replace("#{hkxz}",String.valueOf(t.getHkxz()));
 		sql  = sql.replace("#{fzjl}",String.valueOf(t.getFzjl()));
 		sql  = sql.replace("#{ldgx}",String.valueOf(t.getLdgx()));
 		sql  = sql.replace("#{lzyy}",String.valueOf(t.getLzyy()));
 		sql  = sql.replace("#{bjlrwd}",String.valueOf(t.getBjlrwd()));
 		sql  = sql.replace("#{bjlrry}",String.valueOf(t.getBjlrry()));
 		sql  = sql.replace("#{bjlrrq}",String.valueOf(t.getBjlrrq()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}