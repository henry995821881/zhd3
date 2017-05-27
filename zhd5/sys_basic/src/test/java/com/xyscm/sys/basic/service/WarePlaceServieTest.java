package com.xyscm.sys.basic.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyscm.sys.basic.model.BasicWarePlace;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath*:spring/applicationContext.xml"
	})
public class WarePlaceServieTest {

	@Autowired
	BasicWarePlaceService b;
	private static final Logger logger = LoggerFactory.getLogger(WarehouseGoodsDaoTest.class.getName());
	
	
	@Test
	public void query(){
		
		BasicWarePlace a = new BasicWarePlace();
		a.setWarehouseCode("0098");
		a.setMemberCode("0000");
		List<BasicWarePlace> list = b.queryList(a);
		logger.debug(list.toString());
		
	}
	
	
	@Test
	public void update(){
		BasicWarePlace a = new BasicWarePlace();

		a.setMemberCode("0000");
		a.setWareplaceCode("000000");
		a.setWareplaceName("板材位置");
		
		b.updateWarePlaceByCode(a);
		
	}
	
	@Test
	public void save(){
		
		BasicWarePlace a = new BasicWarePlace();

		a.setMemberCode("0000");
		a.setWareplaceName("H型钢位置");
		a.setWarehouseCode("0098");
		b.saveWarePlace(a);
		
	}
	@Test
	public void delete(){
		
		
		BasicWarePlace a = new BasicWarePlace();

		a.setMemberCode("0000");
		a.setWareplaceCode("000003");
		b.deleteWarePlace(a);
		
	}
	
	
}
