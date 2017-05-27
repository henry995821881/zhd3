package com.xyscm.sys.basic.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyscm.sys.basic.model.BasicPartsName;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath*:spring/applicationContext.xml"
	})
public class PartNameServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(WarehouseGoodsDaoTest.class.getName());
	
	
	@Autowired
	BasicPartsNameService b;
	
	@Test
	public void ss(){
		
    BasicPartsName n = new BasicPartsName();

    n.setPntreeNodecode("0008.0029");
    n.setMemberCode("0000");
		List<BasicPartsName> list = b.queryList(n);
		logger.debug(list.toString());
		
	}
	
	
	@Test
	public void ss1(){
		  BasicPartsName n = new BasicPartsName();

		    n.setPartsnameCode("000285");
		    n.setMemberCode("0000");
		    n.setPartsnameName("宣传册1");
		b.updatePartsName(n);
	}
	
	@Test
	public void save(){
		
		  BasicPartsName n = new BasicPartsName();
		  n.setMemberCode("0000");
		  n.setPartsnameName("aaaa");
		b.savePartsName(n);
		
		
		
	}
	
	@Test 
	public void delete(){
		 BasicPartsName n = new BasicPartsName();
		 n.setMemberCode("0000");
		 n.setPartsnameCode("000365");
		b.deletePartsName(n);
		
	}
}
