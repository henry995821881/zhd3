/**
 * 
 */
package com.xyscm.sys.basic.common.util;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * 
 * 消息国际化工具类
 * 
 * @author xielf
 *
 */
public class MessageSourceUtil implements MessageSourceAware, ResourceLoaderAware, DisposableBean{
	
	private static Logger logger = LoggerFactory.getLogger(MessageSourceUtil.class.getName());

	private static MessageSource messageSource;
	
	private static ResourceLoader resourceLoader;
	
	/**
	 * @return the messageSource
	 */
	public  MessageSource getMessageSource() {
		return messageSource;
	}

	/**
	 * @param messageSource the messageSource to set
	 */
	public  void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
    public static ResourceLoader getResourceLoader()
    {
        return resourceLoader;
    }

    public static Resource getResource(String location)
    {
        return resourceLoader.getResource(location);
    }
    
    public void setResourceLoader(ResourceLoader resourceLoader)
    {
       this.resourceLoader = resourceLoader;
    }
	
    public void destroy()
            throws Exception
        {
            resourceLoader = null;
            messageSource = null;
        }
	

    /**
     * 获取国际化消息
     * @param code 国际化消息的key
     * @param parms 国际化消息参数
     * @param defaultMessage 没有找到的默认消息
     * @param locale 本地语言
     * @return 国际化消息
     */
	public static String getMessage(String code, Object[] parms, String defaultMessage, Locale locale){
		
		return messageSource.getMessage(code,parms,defaultMessage,locale);
		
	}
	
	/**
	 * 获取国际化消息
	 * @param code 国际化消息的key
	 * @param parms 国际化消息参数
	 * @param locale 本地语言
	 * @return 国际化消息
	 *
	 */
	public static String getMessage(String code, Object[] parms, Locale locale){
		
		return  messageSource.getMessage(code,parms,locale);
	}
	
	/**
	 * 
	 * @param code 国际化消息的key
	 * @param parms  国际化消息参数
	 * @return
	 */
	public static String getMessage(String code, Object[] parms){
		
		return getMessage(code,parms,Locale.getDefault());
	}
	
	/**
	 * 
	 * @param code 国际化消息的key
	 * @return  
	 *
	 */
	public static String getMessage(String code){
		
		return getMessage(code,new Object[]{});
	}

}
