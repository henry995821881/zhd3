package com.xyscm.sys.basic.facade;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xyscm.framework.common.api.ResultDTO;
import com.xyscm.sys.basic.api.ApiBasicWarehouseService;
import com.xyscm.sys.basic.api.dto.BasicWarehouseDTO;
import com.xyscm.sys.basic.model.BasicWarehouse;
import com.xyscm.sys.basic.service.BasicWarehouseService;
/**
 * 
 * 仓库设置接口实现
 * 
 * @author Administrator
 *
 */
public class ApiBasicWarehouseFacade implements ApiBasicWarehouseService {

	@Autowired
	BasicWarehouseService basicWarehouseService;

	/**
	 * 
	 * 还没确认加什么样的异常和不确认使用者的需求,后期加
	 */
	public ResultDTO queryListByMemberCode(String memberCode) {

		ResultDTO result = new ResultDTO();
		List<BasicWarehouse> list = basicWarehouseService
				.queryAllByMemberCode(memberCode);
		result.setMessage("ok");
		result.setData(list);
		return result;
	}

	

	public ResultDTO saveWarehouse(BasicWarehouseDTO dto) {
		ResultDTO result = new ResultDTO();
		BasicWarehouse r = new BasicWarehouse();
		BeanUtils.copyProperties(dto, r);
		basicWarehouseService.saveWarehouse(r);
		result.setMessage("ok");

		return result;
	}



	public ResultDTO deleteByCode(BasicWarehouseDTO dto) {
		ResultDTO result = new ResultDTO();
		BasicWarehouse r = new BasicWarehouse();
		BeanUtils.copyProperties(dto, r);
		basicWarehouseService.deleteWarehouseByCode(r);
		result.setMessage("ok");
		return result;
	}



	public ResultDTO updateByCode(BasicWarehouseDTO dto) {
		
		ResultDTO result = new ResultDTO();
		BasicWarehouse r = new BasicWarehouse();
		BeanUtils.copyProperties(dto, r);
		basicWarehouseService.updateWarehouse(r);
		result.setMessage("ok");
		return result;
	}



}
