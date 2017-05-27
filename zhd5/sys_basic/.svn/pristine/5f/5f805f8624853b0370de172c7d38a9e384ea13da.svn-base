package com.xyscm.sys.basic.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyscm.sys.basic.model.BasicWareArea;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath*:spring/applicationContext.xml"
	})
public class WareAreaServieTest {
	private static final Logger logger = LoggerFactory.getLogger(WarehouseGoodsDaoTest.class.getName());
	
	
	
	
	@Autowired
	BasicWareAreaService b;
	
	@Test
	public void query(){
		
		BasicWareArea a = new BasicWareArea();
		a.setMemberCode("0000");
		a.setWarehouseCode("0098");
		List<BasicWareArea> list = b.queryList(a);
		logger.debug(list.toString());
		
	}
	
	@Test
	public void update(){
		
		BasicWareArea a = new BasicWareArea();
		a.setMemberCode("0000");
		//a.setWarehouseCode("0098");
         a.setWareareaCode("000000");
         a.setWareareaName("9号门");
        b.updateWareAreaByCode(a);
		
	}
	
	
	@Test
	public void save(){
		
		BasicWareArea a = new BasicWareArea();
		a.setMemberCode("0000");
		a.setWareareaName("20号门");
		a.setWarehouseCode("0098");
		b.saveWareArea(a);
		
	}
	
	
	@Test
	public void delete(){
		
		BasicWareArea a = new BasicWareArea();
		a.setMemberCode("0000");
		a.setWareareaCode("000004");
		b.deleteWareArea(a);
		
	}
	
	
	
	
}
