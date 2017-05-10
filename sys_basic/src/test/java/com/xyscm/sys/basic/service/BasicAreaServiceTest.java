package com.xyscm.sys.basic.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyscm.sys.basic.model.BasicArea;
import com.xyscm.sys.basic.service.BasicAreaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath*:spring/applicationContext.xml"
	})
public class BasicAreaServiceTest {
	
	@Autowired
	BasicAreaService basicAreaService;

	@Test
	public void testGet() {
		
		try {
			BasicArea org = basicAreaService.get(103);
			System.out.println(org);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
