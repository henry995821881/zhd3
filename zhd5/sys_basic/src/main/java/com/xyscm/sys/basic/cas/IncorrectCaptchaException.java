/**
 * 智恒达钢盟网络科技有限公司
 */
package com.xyscm.sys.basic.cas;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 功能描述：验证码校验失败异常
 * 
 * @author xielf
 * @CreateDate 2017-5-17 上午10:16:34
 * @Version: 1.0
 */
public class IncorrectCaptchaException extends AuthenticationException {

	/**
	 * 
	 */
	public IncorrectCaptchaException() {

	}

	/**
	 * @param message
	 */
	public IncorrectCaptchaException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public IncorrectCaptchaException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public IncorrectCaptchaException(String message, Throwable cause) {
		super(message, cause);
	}

}
