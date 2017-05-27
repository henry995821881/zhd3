package com.xyscm.sys.basic.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyscm.sys.basic.common.exception.BaseException;
import com.xyscm.sys.basic.dao.SystemIndustryMapper;
import com.xyscm.sys.basic.model.SystemIndustry;


/**
 * 行业分类
 * 功能描述：
 * 
 * @author Administrator
 * @CreateDate 2017年5月21日 上午11:16:24
 * @Version: 1.0
 */
@Service
public class SystemIndustryService {
    Logger logger = LoggerFactory.getLogger(SystemIndustryService.class);
	
	@Autowired
	SystemIndustryMapper SystemIndustryMapper;
	
	
	/**
	 * @param membercode
	 * @param record
	 * @return
	 *
	 * List<SystemIndustry>
	 */
	public List<SystemIndustry> queryList(SystemIndustry record){
		
		List<SystemIndustry> list=null;
		try {
			list = SystemIndustryMapper.queryList(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.info(e.getMessage());
	
		}
		return list;
		
	}
	
}
