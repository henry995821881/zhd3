package com.xyscm.sys.basic.service;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyscm.sys.basic.model.BasicDept;
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
	@Autowired
	BasicDeptService basicDeptService;
	@Autowired
	BasicEmployeeService basicEmployeeService;

	@Test
	public void testGet() {
		
		try {
			
			logger.debug("testGet() call.");
			
			//BasicOrg org = basicOrgService.getOrgByCode("0001","0000");
			/*List<BasicOrg> list = basicOrgService.queryAll();
			for (BasicOrg basicOrg : list) {
				logger.debug(basicOrg.toString());
			}*/
			
			//BasicOrg basicOrg = basicOrgService.getOrgByCode("0001", "0000");
			//logger.debug(basicOrg.toString());
			
			BasicDept basicDept = basicDeptService.getDeptByCode("0083", "0000");
			logger.debug(basicDept.toString());
			
			
			
			logger.debug("testGet() end.");
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
