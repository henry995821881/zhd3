package com.xyscm.sys.basic.dao;

import com.xyscm.sys.basic.model.BasicPnTree;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface BasicPnTreeMapper {
    int deleteByPrimaryKey(BigDecimal pntreeId);

    int insert(BasicPnTree record);

    int insertSelective(BasicPnTree record);

    BasicPnTree selectByPrimaryKey(BigDecimal pntreeId);

    int updateByPrimaryKeySelective(BasicPnTree record);

    int updateByPrimaryKey(BasicPnTree record);

	List<BasicPnTree> queryList(BasicPnTree record);

	void updataTree(BasicPnTree record);

	void deleteTree(BasicPnTree record);

	
}