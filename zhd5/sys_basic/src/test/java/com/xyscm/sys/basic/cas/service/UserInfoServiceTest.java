/**
 * 智恒达钢盟网络科技有限公司
 */
package com.xyscm.sys.basic.cas.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xyscm.sys.basic.cas.User;
import com.xyscm.sys.basic.service.BaseTest;

/**
 * 功能描述：
 * 
 * @author xielf
 * @CreateDate 2017-5-18 下午4:42:14
 * @Version: 1.0
 */
public class UserInfoServiceTest extends BaseTest {
	
	@Autowired
	UserInfoService userInfoService;

	/**
	 * Test method for {@link com.xyscm.sys.basic.cas.service.UserInfoService#getUserInfo(java.lang.String)}.
	 */
	@Test
	public void testGetUserInfo() {
		
		try {
			User user = userInfoService.getUserInfo("gdsdp");
			logger.debug("user="+user);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
