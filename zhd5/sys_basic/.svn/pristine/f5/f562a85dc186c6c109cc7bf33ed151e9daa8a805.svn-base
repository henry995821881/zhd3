/**
 * 
 */
package com.xyscm.sys.basic.service;

import static org.junit.Assert.fail;

import java.util.Locale;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import com.github.pagehelper.PageInfo;
import com.xyscm.sys.basic.common.constant.ErrorCode;
import com.xyscm.sys.basic.common.util.MessageSourceUtil;

/**
 * @author xielf
 *
 */
public class DemoTestServiceTest extends BaseTest{
	
	private static final Logger logger = LoggerFactory.getLogger(DemoTestServiceTest.class.getName());
	
	@Autowired
	DemoTestService demoTestService;
	
	@Autowired
	MessageSource messageSource;

	@Test
	public void test() {
		
		try {
			
			PageInfo page = demoTestService.getOry(1, 10);
			logger.debug("page="+page);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}
	
	/**
	 * void
	 * 国际化测试
	 */
	@Test
	public void testMessageSource(){
		
		try {
			String messge =MessageSourceUtil.getMessage(ErrorCode.E_SYSB_AREA_ADD.getErrCode(), new Object[]{"北京"});
			String messge1 =MessageSourceUtil.getMessage(ErrorCode.E_SYSB_AREA_ADD.getErrCode());
			
			logger.debug("messge="+messge);
			logger.debug("messge1="+messge1);
		} catch (NoSuchMessageException e) {
			e.printStackTrace();
			fail();
		}
	}

}
