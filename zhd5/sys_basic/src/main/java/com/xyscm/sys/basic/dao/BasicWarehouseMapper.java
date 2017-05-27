package com.xyscm.sys.basic.dao;

import com.xyscm.sys.basic.model.BasicWarehouse;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicWarehouseMapper {
	int deleteByPrimaryKey(BigDecimal warehouseId);

	/**
	 * 根据会员编号 仓库id 删除
	 * 
	 * @param memberCode
	 * @param warehouseId
	 * @return
	 */
	int deleteWarehouse(BasicWarehouse record);

	int insert(BasicWarehouse record);

	int insertSelective(BasicWarehouse record);

	BasicWarehouse selectByPrimaryKey(BigDecimal warehouseId);

	int updateByPrimaryKeySelective(BasicWarehouse record);

	int updateByPrimaryKey(BasicWarehouse record);

	/**
	 * 根据会员code查询所有仓库
	 * 
	 * @param memberCode
	 * @return
	 */
	List<BasicWarehouse> queryAllByMemberCode(String memberCode);
	List<BasicWarehouse> queryList(BasicWarehouse record);

	void updateWarehouse(BasicWarehouse record);

	void deleteWarehouseByCode(BasicWarehouse record);
}