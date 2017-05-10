package com.xyscm.sys.basic.dao;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.xyscm.sys.basic.model.BasicOrg;

@Repository
public interface BasicOrgMapper {
    int deleteByPrimaryKey(BigDecimal orgId);

    int insert(BasicOrg record);

    int insertSelective(BasicOrg record);

    BasicOrg selectByPrimaryKey(BigDecimal orgId);

    int updateByPrimaryKeySelective(BasicOrg record);

    int updateByPrimaryKey(BasicOrg record);
}