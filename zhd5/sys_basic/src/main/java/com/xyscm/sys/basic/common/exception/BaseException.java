package com.xyscm.sys.basic.common.exception;

import org.apache.commons.lang3.StringUtils;

import com.github.pagehelper.util.StringUtil;
import com.xyscm.sys.basic.common.util.MessageSourceUtil;

public class BaseException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private String exceptionFLag;
	private String msg;
	private String msgError;

	public String getExceptionFLag() {
		return exceptionFLag;
	}

	public void setExceptionFLag(String exceptionFLag) {
		this.exceptionFLag = exceptionFLag;
	}

	/**
	 * 异常构造方法
	 * @param errCode 错误编码
	 */
	public BaseException(String errCode, Throwable t) {
		super(errCode,t);
		this.setExceptionFLag(errCode);
		
		String errMsg = getErrMsg(errCode,null);
		this.setMsg(errMsg);
		this.setMsgError(errMsg+". "+t==null?"":t.getMessage());
	}

	/**
	 * 异常构造方法
	 * @param errCode 错误编码
	 */
	public BaseException(String errCode) {
		super(errCode);
		this.setExceptionFLag(errCode);
		
		String errMsg = getErrMsg(errCode,null);
		this.setMsg(errMsg);
		this.setMsgError(errMsg);
	}
	
	/**
	 * 异常构造方法
	 * @param errCode 错误编码
	 */
	public BaseException(String errCode, Object[] args) {
		super(errCode);
		
		this.setExceptionFLag(errCode);
		String errMsg = getErrMsg(errCode,args);
		this.setMsg(errMsg);
		this.setMsgError(errMsg);

	}
	
	/**
	 * 异常构造方法
	 * @param errCode 错误编码
	 */
	public BaseException(String errCode, Object[] args,Throwable t) {
		super(errCode,t);
		
		this.setExceptionFLag(errCode);
		String errMsg = getErrMsg(errCode,args);
		this.setMsg(errMsg);
		this.setMsgError(errMsg+". "+t==null?"":t.getMessage());

	}
	
	/**
	 * 异常构造方法
	 * @param errCode 错误编码
	 * @param msg  提示给用户信息（可以为空，为空默认操作失败）
	 * @param msgError 写到后台的错误信息
	 */
	public BaseException(String errCode,String msg,String msgError) {
		super(errCode + msgError);
		this.setExceptionFLag(errCode);
		this.setMsg(msg);
		this.setMsgError(msgError);
	}
	
	public BaseException(String errCode,String mess) {
		super(mess);
		this.setMsg(mess);
	}
	
	public BaseException(String mess,Exception ex) {
		super(mess,ex);
		this.setMsg(mess);
	}
	
	public String getMsgError(){
		return msgError;
	}
	public String getExcepMess() {
		if (StringUtils.isNotEmpty(msg)){
			return getMsg();
		}else{
			return "操作失败";
		}
	}
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		if(StringUtils.isBlank(msg)){
			msg="操作失败";
		}
		this.msg = msg;
	}

	public void setMsgError(String msgError) {
		this.msgError = msgError;
		//记录错误信息
		//operationLog.servicesLog(this.getExceptionFLag(), this.getExcepMess(), msgError);
	}
	
	/**
	 * 
	 * @param errCode 错误码
	 * @param args 参数
	 * @return
	 *
	 * String
	 */
	private String getErrMsg(String errCode, Object[] args){
		String errMsg = "";
		if(StringUtil.isNotEmpty(errCode)){
			
			if(args!=null && args.length>0){
				errMsg = MessageSourceUtil.getMessage(errCode,args);
			} else {
				errMsg = MessageSourceUtil.getMessage(errCode);
			}
		}
		
		return errMsg;
		
	}
}
