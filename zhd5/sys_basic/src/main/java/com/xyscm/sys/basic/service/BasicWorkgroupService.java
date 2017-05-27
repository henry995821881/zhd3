package com.xyscm.sys.basic.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyscm.sys.basic.dao.BasicWorkgroupMapper;
import com.xyscm.sys.basic.model.BasicWorkgroup;

/**
 * 工作组
 * 
 * 
 * 
 * 功能描述：
 * 
 * @author Administrator
 * @CreateDate 2017年5月25日 上午9:37:57
 * @Version: 1.0
 */
@Service
public class BasicWorkgroupService {
	 Logger logger = LoggerFactory.getLogger(BasicWorkgroupService.class);
	@Autowired
	BasicWorkgroupMapper basicWorkgroupMapper;
	
	
	
	
	public List<BasicWorkgroup> queryAll(){
		
		BasicWorkgroup bean = new BasicWorkgroup();
		bean.setMemberCode("0000");
		
		List<BasicWorkgroup> list = basicWorkgroupMapper.queryAll(bean);
			
		return list;
		
	}
	
}
