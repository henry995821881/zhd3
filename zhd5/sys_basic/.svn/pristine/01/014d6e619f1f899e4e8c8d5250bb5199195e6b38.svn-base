/**
 * 智恒达钢盟网络科技有限公司
 */
package com.xyscm.sys.basic.cas.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.xyscm.sys.basic.cas.IncorrectCaptchaException;
import com.xyscm.sys.basic.cas.User;
import com.xyscm.sys.basic.cas.UsernamePasswordCaptchaToken;
import com.xyscm.sys.basic.cas.util.SessionUtils;


/**
 * 功能描述：用户登录验证入口
 * 
 * @author xielf
 * @CreateDate 2017-5-16 下午2:03:07
 * @Version: 1.0
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class.getName());
	
	/** 处理成功返回值 */
	private static final String RET_OK="sucess";
	
    /**
     * 登录入口
     */
    @RequestMapping(value = "/login")
	public String login(){
		
		return "login/login";
		
	}
    
    /**
     * 欢迎入口
     */
    @RequestMapping(value = "/welcome")
	public String welcome(){
		
    	User user = SessionUtils.getUserInfo();
    	logger.debug("user="+user);
		return "welcome";
		
	}
	
    /**
     * 用户注销
     */
    @RequestMapping(value = "/logout")
	public String logout(SessionStatus sessionStatus){
		
		// 清理本地缓存用户登录信息，
		sessionStatus.setComplete();
		
		return "/";
	}
	
    /**
     * 用户登录校验
     * 
     * void
     */
    @ResponseBody
    @RequestMapping(value = "/checkLogin")
	public ModelMap checkLogin(User user) {
    	
    	logger.debug("checkLogin() call. user="+user);
    	
    	String errmsg = null;
    	ModelMap map = new ModelMap();
    	
    	UsernamePasswordCaptchaToken token = new UsernamePasswordCaptchaToken(
    			user.getUserId(), user.getPassword(),user.getCaptcha());
		Subject currentUser = SecurityUtils.getSubject();
		try {
			// 使用shire验证
			currentUser.login(token);
			
		} catch (ExcessiveAttemptsException e) {
			// 重试次数达到上限
			errmsg="登录错误次数达到上限，请稍后重试";
			logger.error("重试次数达到上限。"+user.getUserId()+e.getMessage(),e);
		}
		catch (IncorrectCaptchaException e) {
			// 验证码错误
			errmsg="验证码错误";
			logger.error("验证码错误。"+user.getUserId()+e.getMessage(),e);
		}
		catch (AuthenticationException e) {
			// 校验失败
			errmsg=e.getMessage();
			logger.error("登录失败。 user="+user.getUserId()+e.getMessage(),e);

		}
		catch (Throwable e) {
			// 校验失败
			errmsg="系统繁忙，请稍后重试";
			logger.error("登录异常。 user="+user.getUserId()+e.getMessage(),e);

		}
		map.addAttribute("errmsg", errmsg);
		return map;

	}

}
