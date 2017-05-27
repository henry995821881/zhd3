package com.xyscm.sys.basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyscm.sys.basic.dao.BasicDdMapper;
import com.xyscm.sys.basic.model.BasicDd;



@Service
public class BasicDdService {

	@Autowired
	BasicDdMapper basicDdMapper;
	
	/**
	 * 根据ddtype_Class查询信息
	 */
	public List<BasicDd> queryByClass(String ddtypeClass){
		return basicDdMapper.queryByClass(ddtypeClass);
	}
	
}
