package com.jeecg.qpwl.core;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlEngine;

import net.sf.json.JSONObject;
 


/**
 * 
 * 描述： 动态执行java代码
 * 作者：liu.yj
 * 日期：2017-12-12
 */
public class DynamicExceuteUtils {
	private static String ifReg = "IF((?!ENDIF).)*ENDIF"; //用来判断IF表达式
	private static Pattern ifPattern = Pattern.compile(ifReg,Pattern.CASE_INSENSITIVE);
	
	public static String IFSourceException(String source,JSONObject paramObj){
		//获取IF表达式
		Matcher matcher = ifPattern.matcher(source);
		while(matcher.find()){
			String ifStr = matcher.group();
			String expression = ifStr.substring(ifStr.indexOf("[")+1, ifStr.indexOf("]"));
			expression = buildIFExpContext(expression,paramObj);
			//执行表达式
			JexlEngine jexl = new JexlEngine();
			Expression e  = (Expression) jexl.createExpression(expression);
			if(e.evaluate(null) != null && (Boolean)e.evaluate(null)){
				String SQLContex =  ifStr.substring(ifStr.indexOf("]")+1,ifStr.indexOf("ENDIF"));
				source = source.replace(ifStr, SQLContex);
				break;
			}else{
				source = source.replace(ifStr, "");
			}
		}
		source = buildSqlContext(source,paramObj);
		return source;
	}
	
	/**
	 * 描述：构建IF表达式语句
	 * 作者：liu.yj
	 * 日期：2017-12-12
	 * @param sqlContext
	 * @param paramObj
	 * @return
	 */
	public static String buildIFExpContext(String sqlContext,JSONObject paramObj){
		//替换#{param} 字符串类型
	    Matcher m = Pattern.compile("#[{][A-Za-z0-9_$]{1,}[}]").matcher(sqlContext);
	    while(m.find()){
	    	sqlContext = sqlContext.replace(m.group(), "\""+paramObj.optString(m.group().replaceAll("[#{}]{1,}",""),"")+"\"");
	    }
	    //替换${param} 数字类型
	    Matcher m2 = Pattern.compile("[$][{][A-Za-z0-9_$]{1,}[}]").matcher(sqlContext);
	    while(m2.find()){
	    	sqlContext = sqlContext.replace(m2.group(), paramObj.optString(m2.group().replaceAll("[${}]{1,}",""),""));
	    }
		return sqlContext;
	}
	
	/**
	 * 描述：构建IF表达式语句
	 * 作者：liu.yj
	 * 日期：2017-12-12
	 * @param sqlContext
	 * @param paramObj
	 * @return
	 */
	public static String buildSqlContext(String sqlContext,JSONObject paramObj){
		//替换#{param} 字符串类型
	    Matcher m = Pattern.compile("#[{][A-Za-z0-9_$]{1,}[}]").matcher(sqlContext);
	    while(m.find()){
	    	sqlContext = sqlContext.replace(m.group(), "\""+paramObj.optString(m.group().replaceAll("[#{}]{1,}",""),"")+"\"");
	    }
	    //替换${param} 数字类型
	    Matcher m2 = Pattern.compile("[$][{][A-Za-z0-9_$]{1,}[}]").matcher(sqlContext);
	    while(m2.find()){
	    	sqlContext = sqlContext.replace(m2.group(), paramObj.optString(m2.group().replaceAll("[${}]{1,}",""),""));
	    }
		return sqlContext;
	}
	public static void main(String args[]){
		JSONObject paramObject = new JSONObject();
		paramObject.put("keyWord",1);
		paramObject.put("accNbr", "123456");
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("IF[#{keyWord}==1]{\"line_note\": \"审核通过\", \"next_task\": \"下一环节1\"} ENDIF ");
		strBuffer.append("IF[1==2]{\"line_note\": \"审核驳回\", \"next_task\": \"下一环节2\"} ENDIF ");
		strBuffer.append("IF[1==4]{\"line_note\": \"备注\", \"next_task\": \"下一环节3\"} ENDIF ") ;
		System.out.println(DynamicExceuteUtils.IFSourceException(strBuffer.toString(),paramObject));
	}
}
