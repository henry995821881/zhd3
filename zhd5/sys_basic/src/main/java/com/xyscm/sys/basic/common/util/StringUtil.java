package com.xyscm.sys.basic.common.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

	/**
	 * 只要有一个参数为空就返回true
	 * @param args
	 * @return true false
	 */
	public static Boolean isBlankOne(Object... args){
		Boolean flag=false;
		for (int i = 0; i < args.length; i++) {
			if(args[i] instanceof String){
				if(StringUtils.isBlank((String) args[i])){
					flag=true;
				}
			}else{
				if(null==args[i]){
					flag=true;
				}
			}
		}
		return flag;
	}
	
	/**
	 * 检测字符是否为空,为空的时候返回提示
	 * @param str
	 * @param msg 为空的时候返回提示
	 * @return
	 */
	public static String isBlankToMsg(String str,String msg){
		String returnstr="";
		if (StringUtils.isBlank(str)) {
			returnstr=msg+",";
		}
		return returnstr;
	}
	
	
	
}
