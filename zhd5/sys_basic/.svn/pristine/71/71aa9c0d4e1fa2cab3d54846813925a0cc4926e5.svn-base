package com.xyscm.sys.basic.service;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyscm.sys.basic.model.BasicWarehouse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath*:spring/applicationContext.xml"
	})
public class BasichouseServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(WarehouseGoodsDaoTest.class.getName());
	
	@Autowired
	BasicWarehouseService s;
	
	
	@Test
	public void sss(){
		
		logger.debug(s.queryAllByMemberCode("0000").toString());
		
		
		logger.debug(">>>>>>>>>>>>>>>>>>>>");
		
	}
	
	@Test
	public void sss1(){
		
		BasicWarehouse r = new BasicWarehouse();
		r.setMemberCode("0000");
		r.setWarehouseName("henry8");
		
	
		try {
			s.saveWarehouse(r);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		logger.debug(">>>>>>>>>>>>>>>>>>>>");
		
	}
	
	@Test
	public void sss2(){
		
		BasicWarehouse r = new BasicWarehouse();
		r.setMemberCode("0000");
		
		r.setWarehouseId(new BigDecimal(202));
	
		logger.debug(s.deleteWarehouse(r)+" ");
		
		
		logger.debug(">>>>>>>>>>>>>>>>>>>>");
	}
}
