package com.xyscm.sys.basic.cas.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.xyscm.sys.basic.cas.User;

/**
 * 获取当前登录用户session
 * 功能描述：
 * 
 * @author xielf
 * @CreateDate 2017-5-20 下午12:34:34
 * @Version: 1.0
 */
public class SessionUtils {

	public SessionUtils() {
	}

	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	/**
	 * 判断用户是否登录
	 * @return
	 *
	 * boolean
	 */
	public static boolean isLogin() {
		Subject subject = SecurityUtils.getSubject();
		if (subject == null)
			return false;
		else
			return subject.isAuthenticated();
	}

	/**
	 * 获取用户帐号
	 * @return
	 *
	 * String
	 */
	public static String getUserId() {
		return ((User) SecurityUtils.getSubject().getPrincipal())
				.getUserId();
	}

	/**
	 * 获取用户信息
	 * @return
	 *
	 * User
	 */
	public static User getUserInfo() {
		return (User) SecurityUtils.getSubject().getPrincipal();
	}

	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	public static Session getSession(boolean create) {
		return SecurityUtils.getSubject().getSession(create);
	}
}
