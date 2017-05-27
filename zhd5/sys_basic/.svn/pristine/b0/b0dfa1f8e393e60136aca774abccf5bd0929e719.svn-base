package com.xyscm.sys.basic.dao;

import com.xyscm.sys.basic.model.BasicWorkgroup;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface BasicWorkgroupMapper {
    int deleteByPrimaryKey(BigDecimal workgroupId);

    int insert(BasicWorkgroup record);

    int insertSelective(BasicWorkgroup record);

    BasicWorkgroup selectByPrimaryKey(BigDecimal workgroupId);

    int updateByPrimaryKeySelective(BasicWorkgroup record);

    int updateByPrimaryKey(BasicWorkgroup record);

	List<BasicWorkgroup> queryAll(BasicWorkgroup bean);
}