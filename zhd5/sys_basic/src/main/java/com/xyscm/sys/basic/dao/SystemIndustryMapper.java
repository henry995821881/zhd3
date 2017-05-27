package com.xyscm.sys.basic.dao;

import com.xyscm.sys.basic.model.SystemIndustry;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface SystemIndustryMapper {
    int deleteByPrimaryKey(BigDecimal columnId);

    int insert(SystemIndustry record);

    int insertSelective(SystemIndustry record);

    SystemIndustry selectByPrimaryKey(BigDecimal columnId);

    int updateByPrimaryKeySelective(SystemIndustry record);

    int updateByPrimaryKey(SystemIndustry record);

	List<SystemIndustry> queryList(SystemIndustry record);
}