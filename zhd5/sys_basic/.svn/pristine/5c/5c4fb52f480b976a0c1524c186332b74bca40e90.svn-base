package com.xyscm.sys.basic.facade;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xyscm.framework.common.api.ResultDTO;
import com.xyscm.sys.basic.api.ApiBasicProductAreaService;
import com.xyscm.sys.basic.api.dto.BasicProductAreaDTO;
import com.xyscm.sys.basic.model.BasicProductArea;
import com.xyscm.sys.basic.service.BasicProductAreaService;
/**
 * 
 * 产地
 * @author henry
 *
 */
public class ApiBasicProductAreaFacade implements ApiBasicProductAreaService {

	@Autowired
	BasicProductAreaService basicProductAreaService;
	
	public ResultDTO queryList(BasicProductAreaDTO dto) {

		ResultDTO result = new ResultDTO();
		BasicProductArea bean = new BasicProductArea();
		BeanUtils.copyProperties(dto, bean);
		List<BasicProductArea> list = basicProductAreaService.queryList(bean);
		result.setData(list);

		return result;
	}

	public ResultDTO update(BasicProductAreaDTO dto) {
		
		ResultDTO result = new ResultDTO();
		BasicProductArea bean = new BasicProductArea();
		BeanUtils.copyProperties(dto, bean);
		basicProductAreaService.updateProductArea(bean);
		result.setMessage("ok");

		return result;
	}

	public ResultDTO save(BasicProductAreaDTO dto) {
		
		ResultDTO result = new ResultDTO();
		BasicProductArea bean = new BasicProductArea();
		BeanUtils.copyProperties(dto, bean);
		basicProductAreaService.saveProductArea(bean);
		result.setMessage("ok");
		return result;
	}

	public ResultDTO delete(BasicProductAreaDTO dto) {

		ResultDTO result = new ResultDTO();
		BasicProductArea bean = new BasicProductArea();
		BeanUtils.copyProperties(dto, bean);
		basicProductAreaService.deleteProductArea(bean);
		result.setMessage("ok");
		return result;

	}

}
