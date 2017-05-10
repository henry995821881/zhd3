/**
 * 
 */
package com.xyscm.sys.basic.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyscm.sys.basic.dao.BasicOrgMapper;
import com.xyscm.sys.basic.model.BasicOrg;

/**
 * @author xielf
 *
 */
@Service
public class BasicOrgService {

	@Autowired
	BasicOrgMapper basicOrgMapper;
	
    /**
     * 根据主键ID查找记录
     * <find one by id>
     *
     * @param id
     */
    public BasicOrg get(Integer id) {


        return basicOrgMapper.selectByPrimaryKey(new BigDecimal(id));

    }

}
