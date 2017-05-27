package com.xyscm.sys.basic.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyscm.sys.basic.model.BasicProductArea;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath*:spring/applicationContext.xml"
	})
public class ProductAreaServieTest {
	private static final Logger logger = LoggerFactory.getLogger(WarehouseGoodsDaoTest.class.getName());
	
	
	
	@Autowired
	BasicProductAreaService b;
	
	@Test
	public void query(){
		
		BasicProductArea a = new BasicProductArea();
		a.setMemberCode("0000");
		List<BasicProductArea> list = b.queryList(a);
		logger.debug(list.toString());
		
	}
	
	
	
	@Test
	public void update(){
		BasicProductArea a = new BasicProductArea();
		a.setMemberCode("0000");
		a.setProductareaCode("000132");
		a.setProductareaName("henry3");
		b.updateProductArea(a);
		
		
		
	}
	
	
	@Test
	public void save(){
		BasicProductArea a = new BasicProductArea();
		a.setMemberCode("0000");
		a.setProductareaName("henry99");
		b.saveProductArea(a);
		
	}
	@Test
	public void delete(){
		BasicProductArea a = new BasicProductArea();
		a.setMemberCode("0000");
		a.setProductareaCode("000133");
		b.deleteProductArea(a);
		
		
	}
	
}
