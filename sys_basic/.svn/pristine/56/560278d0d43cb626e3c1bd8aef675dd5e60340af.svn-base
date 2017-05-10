package com.xyscm.sys.basic.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyscm.sys.basic.model.BasicOrg;
import com.xyscm.sys.basic.service.BasicOrgService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath*:spring/applicationContext.xml"
	})
public class BasicOrgServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BasicOrgServiceTest.class.getName());
	
	@Autowired
	BasicOrgService basicOrgService;

	@Test
	public void testGet() {
		
		try {
			
			logger.debug("testGet() call.");
			
			BasicOrg org = basicOrgService.get(283);
			logger.debug(org.toString());
			
			logger.debug("testGet() end.");
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
