package com.xyscm.sys.basic.service;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(BasicOrgServiceTest.class.getName());
	
	@Autowired
	BasicAreaService basicAreaService;

	@Test
	public void testGet() {
		
		try {
//			所有地区
//			logger.debug("查询所有地区		start");
//			List<BasicArea> queryAllArea = basicAreaService.queryAllArea("0000");
//			logger.debug("queryAllArea="+queryAllArea);
//			logger.debug("查询所有地区		end");
			
			
//			一级地区
//			logger.debug("查询一级地区		start");
//			List<BasicArea> queryBasicArea = basicAreaService.queryBasicArea("0000");
//			logger.debug("queryBasicArea="+queryBasicArea);
//			logger.debug("查询一级地区		end");			
			
			
//			二级地区
//			logger.debug("查询二级地区		start");
//			List<BasicArea> query2BasicArea = basicAreaService.query2BasicArea("0000", "0001");
//			logger.debug("query2BasicArea="+query2BasicArea);
//			logger.debug("查询二级地区		end");	
			
			
//			地区详情
//			logger.debug("查询地区详情		start");
//			BasicArea getAreaDetail = basicAreaService.getAreaDetail(new BigDecimal(121));
//			logger.debug("getAreaDetail="+getAreaDetail);
//			logger.debug("查询地区详情		end");		
			
		
//			增加地区
//			logger.debug("增加地区		start");
//			BasicArea basicArea = new BasicArea();
//			主要参数
//			basicArea.setMemberCode("0000");	
//			basicArea.setAreaName("露希尔");		//名称
//			basicArea.setAreaParent("0001");		
//			basicArea.setAreaNodecode("0001.");	//父节点
//			basicAreaService.insertArea(basicArea);
//			logger.debug("增加地区		end");
			
			
//			编辑地区
//			logger.debug("编辑地区		start");
//			BasicArea basicArea = new BasicArea();
//			basicArea.setAreaId(new BigDecimal(2501));	//地区id 主要参数
//			basicArea.setAreaName("萝丝");	
//			basicAreaService.updateArea(basicArea);
//			logger.debug("编辑地区		end");
			
			
//			删除地区
			logger.debug("删除地区		start");
			String areaNodecode = "0001.2352";		
			basicAreaService.deleteArea("0000", areaNodecode);
			logger.debug("删除地区		end");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
