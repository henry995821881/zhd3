/**
 * 智恒达钢盟网络科技有限公司
 */
package com.xyscm.sys.basic.cas;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 功能描述：
 * 
 * @author xielf
 * @CreateDate 2017-5-24 下午5:16:44
 * @Version: 1.0
 */
public class UserNofFoundException extends AuthenticationException {

	/**
	 * 
	 */
	public UserNofFoundException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public UserNofFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public UserNofFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UserNofFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
