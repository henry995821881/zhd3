package com.xyscm.sys.basic.dao;

import com.xyscm.sys.basic.model.BasicWarePlace;
import com.xyscm.sys.basic.model.BasicWarePlaceEx;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface BasicWarePlaceMapper {
    int deleteByPrimaryKey(BigDecimal wareplaceId);

    int insert(BasicWarePlace record);

    int insertSelective(BasicWarePlace record);

    BasicWarePlace selectByPrimaryKey(BigDecimal wareplaceId);

    int updateByPrimaryKeySelective(BasicWarePlace record);

    int updateByPrimaryKey(BasicWarePlace record);

    /**
     * 
     * @param record
     * @return
     */
	List<BasicWarePlace> queryList(BasicWarePlace record);

	/**
	 * 更近warePlace_code 删除
	 * @param record
	 * @return
	 */
	int deleteWarePlace(BasicWarePlace record);

	void updateWarePlaceByCode(BasicWarePlace record);

	List<BasicWarePlaceEx> queryListWithWarehouse(BasicWarePlace record);

}