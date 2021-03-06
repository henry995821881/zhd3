/**
 * 智恒达钢盟网络科技有限公司
 */
package com.xyscm.sys.basic.cas;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能描述： 登录验证次数限制
 * 
 * @author xielf
 * @CreateDate 2017-5-17 下午12:40:04
 * @Version: 1.0
 */
public class RetryLimitHashedCredentialsMatcher extends
	SimpleCredentialsMatcher {
	
	private static final Logger logger = LoggerFactory.getLogger(RetryLimitHashedCredentialsMatcher.class.getName());
	
	private static final String RETRYCACHE_PREFIX = "passwordRetryCache_";

	private Cache<String, AtomicInteger> passwordRetryCache;  
	  
    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {  
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");  
    }  
  
    @Override  
    public boolean doCredentialsMatch(AuthenticationToken _token,  
            AuthenticationInfo info) { 
    	
    	UsernamePasswordCaptchaToken token = (UsernamePasswordCaptchaToken) _token;
        String username = token.getUsername();
        
        String key = RETRYCACHE_PREFIX+username;
        
        /* 1、重试次数校验 */
        // retry count + 1  
        AtomicInteger retryCount = passwordRetryCache.get(key);  
        if (retryCount == null) {  
            retryCount = new AtomicInteger(0);  
            passwordRetryCache.put(key, retryCount);  
        }  
        if (retryCount.incrementAndGet() > 5) {  
            // if retry count > 5 throw  
            throw new ExcessiveAttemptsException();  
        }  
  
        //boolean matches = super.doCredentialsMatch(token, info);  //调用上层校验方法
        
        /* 2、 验证码校验  */
		Session session = getSession();
		String code = (String) session.getAttribute("validateCode"); // 获取验证码
		
		// 验证码校验
		if(StringUtils.isBlank(token.getCaptcha())||!token.getCaptcha().toUpperCase().equals(code)){//判断验证码
			throw new IncorrectCaptchaException("验证码错误");
		}
		
		/* 3、 密码校验 */
		String psdInDb = ((User)info.getPrincipals().getPrimaryPrincipal()).getPassword();
		String password = new String(token.getPassword());
		if(StringUtils.isBlank(psdInDb)||!psdInDb.toLowerCase().equals(password)){//密码校验
			throw new AuthenticationException("密码错误");
		}
		
		/* 4、帐号状态校验 */
		BigDecimal status = ((User)info.getPrincipals().getPrimaryPrincipal()).getOperatorState();
		if(status!=null&& status.intValue()==1){
			throw new AuthenticationException("当前帐号已停用");
		}
		
		/* 5、授权认证：只有系统管理员角色，才能进入*/
		BigDecimal role = ((User)info.getPrincipals().getPrimaryPrincipal()).getOperatorIdentity();
		int id = 0;
		if(role!=null){
			id=role.intValue();
		}
		// 只有系统管理员才能访问基础数据管理
		if(id!=2){
			throw new AuthenticationException("当前用户无访问权限");
		}

        // clear retry count  
        passwordRetryCache.remove(key);       
        
        // 查询用户权限信息
        return true;  //  校验通过，返回true
    }
    
	/**
	 * 获取session对象
	 * @return
	 *
	 * Session
	 */
	private Session getSession() {
		try {
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null) {
				session = subject.getSession();
			}
			if (session != null) {
				return session;
			}
		} catch (InvalidSessionException e) {
			
			logger.debug("获取session异常. ", e);
			logger.warn("获取session异常："+e.getMessage());

		}
		return null;
	}

}
