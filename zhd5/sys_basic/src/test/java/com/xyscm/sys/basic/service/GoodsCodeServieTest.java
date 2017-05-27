package com.xyscm.sys.basic.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyscm.sys.basic.model.BasicGoodsCode;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath*:spring/applicationContext.xml"
	})
public class GoodsCodeServieTest {

	@Autowired
	BasicGoodsCodeService b;
	
	private static final Logger logger = LoggerFactory.getLogger(WarehouseGoodsDaoTest.class.getName());
	
	@Test
	public void query(){
		
BasicGoodsCode a = new BasicGoodsCode();

		a.setMemberCode("0000");
		//模糊查询条件
		a.setGoodsNodecode("0001.0011.船板");
		
		List<BasicGoodsCode> list = b.queryList(a);
		logger.debug(list.toString());
		
		
	}
	
	
	@Test
	public void update(){
		BasicGoodsCode a = new BasicGoodsCode();
		a.setMemberCode("0000");
		a.setGoodscodeCode("000866");
		a.setPartsnameName("酒柜1");
		b.updateGoodsCode(a);
		
	}
	
	@Test
	public void save(){
		
		BasicGoodsCode a = new BasicGoodsCode();
		a.setProductareaName("henry产地");
		a.setPartsnameName("HH型钢");
		a.setGoodsMaterial("Q235");
		a.setGoodsSpec("100*100*100");
		a.setMemberCode("0000");
		b.saveGoodsCode(a);
		
	}
	
	
	@Test
	public void delete(){
		
		BasicGoodsCode a = new BasicGoodsCode();
		a.setMemberCode("0000");
		a.setGoodscodeCode("001041");
		b.deleteGoodsCode(a);
	}
	
	
	
}
