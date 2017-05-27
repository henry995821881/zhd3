package com.xyscm.sys.basic.dao;

import com.github.pagehelper.Page;
import com.xyscm.sys.basic.model.BasicWareArea;
import com.xyscm.sys.basic.model.BasicWareAreaEx;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface BasicWareAreaMapper {
    int deleteByPrimaryKey(BigDecimal wareareaId);

    int insert(BasicWareArea record);

    int insertSelective(BasicWareArea record);

    BasicWareArea selectByPrimaryKey(BigDecimal wareareaId);

    int updateByPrimaryKeySelective(BasicWareArea record);

    int updateByPrimaryKey(BasicWareArea record);

    /**
     * memeberCode
     * warehouseCode
     * 
     * @param record
     * @return
     */
	List<BasicWareArea> queryList(BasicWareArea record);

	/**
	 * 根据WAREAREA_CODE 删除
	 * 
	 * memeberCode也是需要
	 * @param record
	 * @return
	 */
	int deleteWareArea(BasicWareArea record);

	void updateWareAreaByCode(BasicWareArea record);

	List<BasicWareAreaEx> queryListWithWarehouse(BasicWareArea record);

	

	
}