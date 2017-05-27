package com.xyscm.sys.basic.facade;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xyscm.framework.common.api.ResultDTO;
import com.xyscm.sys.basic.api.ApiBasicWarePlaceService;
import com.xyscm.sys.basic.api.dto.BasicWarePlaceDTO;
import com.xyscm.sys.basic.model.BasicWarePlace;
import com.xyscm.sys.basic.service.BasicWarePlaceService;
/**
 * 
 * 库位接口实现
 * @author henry
 *
 */
public class ApiBasicWarePlaceFacade implements ApiBasicWarePlaceService {

	@Autowired
	BasicWarePlaceService basicWarePlaceService;

	public ResultDTO queryList(BasicWarePlaceDTO dto) {
		ResultDTO result = new ResultDTO();
		BasicWarePlace bean = new BasicWarePlace();
		BeanUtils.copyProperties(dto, bean);
		List<BasicWarePlace> list = basicWarePlaceService.queryList(bean);
		result.setData(list);
		return result;
	}

	public ResultDTO update(BasicWarePlaceDTO dto) {
		ResultDTO result = new ResultDTO();
		BasicWarePlace bean = new BasicWarePlace();
		BeanUtils.copyProperties(dto, bean);
		basicWarePlaceService.updateWarePlaceByCode(bean);
		result.setMessage("ok");

		return result;
	}

	public ResultDTO save(BasicWarePlaceDTO dto) {

		ResultDTO result = new ResultDTO();
		BasicWarePlace bean = new BasicWarePlace();
		BeanUtils.copyProperties(dto, bean);
		basicWarePlaceService.saveWarePlace(bean);
		result.setMessage("ok");
		return result;
	}

	public ResultDTO delte(BasicWarePlaceDTO dto) {

		ResultDTO result = new ResultDTO();
		BasicWarePlace bean = new BasicWarePlace();
		BeanUtils.copyProperties(dto, bean);
		basicWarePlaceService.deleteWarePlace(bean);
		result.setMessage("ok");
		return result;
	}

}
