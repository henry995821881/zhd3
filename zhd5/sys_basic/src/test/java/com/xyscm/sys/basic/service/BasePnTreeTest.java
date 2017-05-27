package com.xyscm.sys.basic.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyscm.sys.basic.model.BasicPnTree;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath*:spring/applicationContext.xml"
	})
public class BasePnTreeTest {

	@Autowired
	BasicPnTreeService basicPnTreeService;
	private static final Logger logger = LoggerFactory.getLogger(WarehouseGoodsDaoTest.class.getName());
	
	@Test
	public void ss(){
		
		BasicPnTree r = new BasicPnTree();
		r.setMemberCode("0000");
		r.setPntreeParentcode("-1");
		List<BasicPnTree> list = basicPnTreeService.queryList(r);
		logger.debug(list.toString());
		
	}
}
