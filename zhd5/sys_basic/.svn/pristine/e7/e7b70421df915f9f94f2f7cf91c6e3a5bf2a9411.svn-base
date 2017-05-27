/**
 * 智恒达钢盟网络科技有限公司
 */
package com.xyscm.sys.basic.cas;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 功能描述：
 * 
 * 用户名、密码、验证码校验Token
 * 
 * @author xielf
 * @CreateDate 2017-5-17 上午9:29:41
 * @Version: 1.0
 */
public class UsernamePasswordCaptchaToken extends UsernamePasswordToken {
	
	private static final long serialVersionUID = -5176795187917210223L;
	
	/** 验证码 */
	private String captcha;

	/**
	 * 
	 */
	public UsernamePasswordCaptchaToken() {
		
	}

	/**
	 * @param username
	 * @param password
	 */
	public UsernamePasswordCaptchaToken(String username, char[] password,String captcha) {
		super(username, password);
		this.captcha=captcha;
	}

	/**
	 * @param username
	 * @param password
	 */
	public UsernamePasswordCaptchaToken(String username, String password,String captcha) {
		super(username, password);
		this.captcha = captcha;
	}

	/**
	 * @param username
	 * @param password
	 * @param host
	 */
	public UsernamePasswordCaptchaToken(String username, char[] password,
			String host,String captcha) {
		super(username, password, host);
		this.captcha = captcha;
	}

	/**
	 * @param username
	 * @param password
	 * @param host
	 */
	public UsernamePasswordCaptchaToken(String username, String password,
			String host,String captcha) {
		super(username, password, host);
		this.captcha = captcha;
	}

	/**
	 * @param username
	 * @param password
	 * @param rememberMe
	 */
	public UsernamePasswordCaptchaToken(String username, char[] password,
			boolean rememberMe,String captcha) {
		super(username, password, rememberMe);
		this.captcha = captcha;
	}

	/**
	 * @param username
	 * @param password
	 * @param rememberMe
	 */
	public UsernamePasswordCaptchaToken(String username, String password,
			boolean rememberMe,String captcha) {
		super(username, password, rememberMe);
		this.captcha = captcha;
	}

	/**
	 * @param username
	 * @param password
	 * @param rememberMe
	 * @param host
	 */
	public UsernamePasswordCaptchaToken(String username, char[] password,
			boolean rememberMe, String host,String captcha) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
	}

	/**
	 * @param username
	 * @param password
	 * @param rememberMe
	 * @param host
	 */
	public UsernamePasswordCaptchaToken(String username, String password,
			boolean rememberMe, String host,String captcha) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;

	}

	/**
	 * @return the captcha
	 */
	public String getCaptcha() {
		return captcha;
	}

	/**
	 * @param captcha the captcha to set
	 */
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
	
    /**
     * Clears out (nulls) the username, password, rememberMe, and inetAddress.  The password bytes are explicitly set to
     * <tt>0x00</tt> before nulling to eliminate the possibility of memory access at a later time.
     */
    public void clear() {
       super.clear();
       captcha=null;
    }

    /**
     * Returns the String representation.  It does not include the password in the resulting
     * string for security reasons to prevent accidentially printing out a password
     * that might be widely viewable).
     *
     * @return the String representation of the <tt>UsernamePasswordToken</tt>, omitting
     *         the password.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", captcha=");
        sb.append(captcha);
        return sb.toString();
    }

}
