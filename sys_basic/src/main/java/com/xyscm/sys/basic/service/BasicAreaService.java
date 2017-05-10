package com.xyscm.sys.basic.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyscm.sys.basic.dao.BasicAreaMapper;
import com.xyscm.sys.basic.model.BasicArea;


@Service
public class BasicAreaService {

	@Autowired
	BasicAreaMapper basicAreaMapper;
	
    /**
     * 根据主键ID查找记录
     * @param id
     */
    public BasicArea get(Integer id) {


        return basicAreaMapper.selectByPrimaryKey(new BigDecimal(id));

    }

}
