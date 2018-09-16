package com.jeecg.qpwl.comInf;

import java.util.Date;

import net.sf.json.JSONObject;

import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeecg.qp.jifen.entity.QpJifenEntity;
import com.jeecg.qp.jifen.entity.QpJifenLogEntity;
import com.jeecg.qpwl.core.FlowResult;
import com.jeecg.qpwl.talentpool.entity.JianliOnlineEntity;

@Service
public class ComonInfImpl implements ComonInf {
	@Autowired
	private SystemService systemService;
	@Override
	public FlowResult lookPhoneNo(TSUser user) {
		QpJifenEntity qpJifenEntity = systemService.getEntity(QpJifenEntity.class, user.getId());			
		if(qpJifenEntity.getSqPoint()-qpJifenEntity.getSqPointUsed()>0){
			if(qpJifenEntity.getPointDayLimit()>qpJifenEntity.getPointDayUsed()){
				qpJifenEntity.setSqPointUsed(qpJifenEntity.getPointDayUsed()+1);
				qpJifenEntity.setPointDayUsed(qpJifenEntity.getPointDayUsed()+1);
				systemService.saveOrUpdate(qpJifenEntity);
				
				//积分消费写日志
				QpJifenLogEntity qpJifenLog = new QpJifenLogEntity();
				qpJifenLog.setOperDate(new Date());
				qpJifenLog.setOperUser(user.getUserName());
				qpJifenLog.setOperEvent("积分消费");
				qpJifenLog.setBeioperUser("");
				qpJifenLog.setBeioperJifen("1");
				systemService.saveOrUpdate(qpJifenLog);
				
				JSONObject jsonObject = JSONObject.fromObject("{\"ret_code\":\"0000\"}");
				return FlowResult.buildSuccess(jsonObject);
			}else{			
				return FlowResult.buildFailed(-1,"当日授权查询次数已经用完") ;
			}		 
		}else{			
			return FlowResult.buildFailed(-1,"授权积分已经用完,请联系主管购买") ;
		}		
	}
	

	@Override
	public FlowResult bayPhoneNo(TSUser user, JianliOnlineEntity jianliOnline) {
		return FlowResult.buildSuccess(null);
	}
	
	
	@Override
	public FlowResult chekJf(TSUser user){
		QpJifenEntity qpJifenEntity = systemService.getEntity(QpJifenEntity.class, user.getId());			
		if(qpJifenEntity.getSqPoint()-qpJifenEntity.getSqPointUsed() < 0){
			return FlowResult.buildFailed(-1,"授权积分已经用完,请联系主管授权");
		}
		if(qpJifenEntity.getPointDayLimit() <= qpJifenEntity.getPointDayUsed()){
			return FlowResult.buildFailed(-1,"当日授权查询次数已经用完") ;
		}
		return FlowResult.buildSuccess(new JSONObject());
	}
 

}
