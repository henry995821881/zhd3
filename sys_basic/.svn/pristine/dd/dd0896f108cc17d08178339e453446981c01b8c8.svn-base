package com.xyscm.sys.basic.service;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyscm.sys.basic.dao.WarehouseGoodsMapper;
import com.xyscm.sys.basic.dao.WarehouseGoodsProMapper;
import com.xyscm.sys.basic.dao.WarehouseSumGoodsMapper;
import com.xyscm.sys.basic.dao.WarehouseSumGoodsProMapper;
import com.xyscm.sys.basic.model.WarehouseGoods;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath*:spring/applicationContext.xml"
	})
public class WarehouseGoodsDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(WarehouseGoodsDaoTest.class.getName());
	
	@Autowired
	WarehouseGoodsMapper warehouseGoodsMapper;
	@Autowired
	WarehouseGoodsProMapper  warehouseGoodsProMapper;

	@Autowired
	WarehouseSumGoodsMapper  warehouseSumGoodsMapper;

	@Autowired
	WarehouseSumGoodsProMapper warehouseSumGoodsProMapper;
	
	@Test
	public void testGet() {
		
		
		WarehouseGoods warehouseGoods = warehouseGoodsMapper.selectByPrimaryKey(new BigDecimal(2229));
		
		logger.debug(warehouseGoods.toString());
		logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		
		logger.debug(warehouseGoodsProMapper.selectByPrimaryKey(new BigDecimal(12882)).toString());
		logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		
		logger.debug(warehouseSumGoodsMapper.selectByPrimaryKey(new BigDecimal(9692)).toString());
		logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		
		logger.debug(warehouseSumGoodsProMapper.selectByPrimaryKey(new BigDecimal(9693)).toString());
		logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		
	}
	
	
}
