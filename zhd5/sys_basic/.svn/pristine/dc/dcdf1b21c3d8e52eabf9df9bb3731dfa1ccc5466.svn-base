package com.xyscm.sys.basic.facade;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xyscm.framework.common.api.ResultDTO;
import com.xyscm.sys.basic.api.ApiBasicWareAreaService;
import com.xyscm.sys.basic.api.dto.BasicWareAreaDTO;
import com.xyscm.sys.basic.model.BasicWareArea;
import com.xyscm.sys.basic.service.BasicWareAreaService;
/**
 * 
 * @author henry
 * 库区 api实现
 *
 */
public class ApiBasicWareAreaFacade implements ApiBasicWareAreaService {

	
	@Autowired
	BasicWareAreaService basicWareAreaService;
	
	public ResultDTO queryList(BasicWareAreaDTO dto) {
		ResultDTO result = new ResultDTO();
		BasicWareArea bean = new BasicWareArea();
		BeanUtils.copyProperties(dto,bean);
		List<BasicWareArea> list = basicWareAreaService.queryList(bean);
		result.setData(list);
		return result;
	}

	public ResultDTO update(BasicWareAreaDTO dto) {
		ResultDTO result = new ResultDTO();
		BasicWareArea bean = new BasicWareArea();
		BeanUtils.copyProperties(dto,bean);
		basicWareAreaService.updateWareAreaByCode(bean);
		result.setMessage("ok");
		
		return result;
	}

	public ResultDTO save(BasicWareAreaDTO dto) {
		ResultDTO result = new ResultDTO();
		BasicWareArea bean = new BasicWareArea();
		BeanUtils.copyProperties(dto,bean);
		basicWareAreaService.saveWareArea(bean);
		result.setMessage("ok");

		return result;
	}

	public ResultDTO delete(BasicWareAreaDTO dto) {
		ResultDTO result = new ResultDTO();
		BasicWareArea bean = new BasicWareArea();
		BeanUtils.copyProperties(dto,bean);
		basicWareAreaService.deleteWareArea(bean);
		result.setMessage("ok");
		
		return result;
	}

}
