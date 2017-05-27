package com.xyscm.sys.basic.facade;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xyscm.framework.common.api.ResultDTO;
import com.xyscm.sys.basic.api.ApiBasicPartsNameService;
import com.xyscm.sys.basic.api.dto.BasicPartsNameDTO;
import com.xyscm.sys.basic.model.BasicPartsName;
import com.xyscm.sys.basic.service.BasicPartsNameService;
/**
 * 品名
 * @author henry
 *
 */
public class ApiBasicPartsNameFacade implements ApiBasicPartsNameService{

	@Autowired
	BasicPartsNameService basicPartsNameService;

	public ResultDTO queryList(BasicPartsNameDTO dto) {
		ResultDTO result = new ResultDTO();
		BasicPartsName bean = new BasicPartsName();
		BeanUtils.copyProperties(dto, bean);
		List<BasicPartsName> list = basicPartsNameService.queryList(bean);
		result.setData(list);

		return result;
	}

	public ResultDTO update(BasicPartsNameDTO dto) {

		ResultDTO result = new ResultDTO();
		BasicPartsName bean = new BasicPartsName();
		BeanUtils.copyProperties(dto, bean);
	    basicPartsNameService.updatePartsName(bean);	
	    result.setMessage("ok");
		return result;
	}

	public ResultDTO save(BasicPartsNameDTO dto) {

		ResultDTO result = new ResultDTO();
		BasicPartsName bean = new BasicPartsName();
		BeanUtils.copyProperties(dto, bean);
	    basicPartsNameService.savePartsName(bean);
	    result.setMessage("ok");

		return result;
	}

	public ResultDTO delete(BasicPartsNameDTO dto) {
		
		ResultDTO result = new ResultDTO();
		BasicPartsName bean = new BasicPartsName();
		BeanUtils.copyProperties(dto, bean);
	    basicPartsNameService.deletePartsName(bean);
	    result.setMessage("ok");
		
		return null;
	}

}
