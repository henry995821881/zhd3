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

import com.xyscm.sys.basic.model.BasicCompany;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath*:spring/applicationContext.xml"
	})
public class BasicCompanyServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(BasicOrgServiceTest.class.getName());
	
	@Autowired
	BasicCompanyService basicCompanyService;
	
	@Test
	public void testGet(){
		
		try{
			
			
//			查询往来单位
//			logger.debug("查询往来单位		start");
//			BasicCompany basicCompany = new BasicCompany();
//			basicCompany.setMemberCode("0000");
//			basicCompany.setOrgCode("0026");
//			List<BasicCompany> queryCompany = basicCompanyService.queryCompany(basicCompany);
//			logger.debug("queryCompany="+queryCompany);
//			logger.debug("查询往来单位		end");
			
			
//			查询往来单位详情
//			logger.debug("查询往来单位详情		start");
//			BasicCompany getCompanyInfo = basicCompanyService.getCompanyInfo(new BigDecimal(19971));
//			logger.debug("getCompanyInfo="+getCompanyInfo);
//			logger.debug("查询往来单位详情		end");
			
			
//			新增往来单位
//			logger.debug("新增往来单位		start");
//			BasicCompany basicCompany = new BasicCompany();
//			必要参数
//			basicCompany.setMemberCode("0000");
//			basicCompany.setCompanyName("nob");
//			basicCompanyService.insertCompany(basicCompany);
//			logger.debug("新增往来单位		end");
			
			
//			修改往来单位
//			logger.debug("修改往来单位		start");
//			BasicCompany basicCompany = new BasicCompany();
//			必要参数
//			basicCompany.setCompanyId(new BigDecimal(21499));
//			basicCompany.setCompanyAbbreviate("adc");
//			basicCompanyService.updateCompany(basicCompany);			
//			logger.debug("修改往来单位		end");
			
			

//			删除往来单位
			logger.debug("删除往来单位		start");
			basicCompanyService.deleteCompany(new BigDecimal(21499));		
			logger.debug("删除往来单位		end");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	

}
