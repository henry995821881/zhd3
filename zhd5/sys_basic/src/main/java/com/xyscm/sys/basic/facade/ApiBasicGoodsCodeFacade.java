package com.xyscm.sys.basic.facade;

import java.util.List;

import org.apache.ibatis.mapping.ResultFlag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xyscm.framework.common.api.ResultDTO;
import com.xyscm.sys.basic.api.ApiBasicGoodsCodeService;
import com.xyscm.sys.basic.api.dto.BasicGoodsCodeDTO;
import com.xyscm.sys.basic.model.BasicGoodsCode;
import com.xyscm.sys.basic.service.BasicGoodsCodeService;

public class ApiBasicGoodsCodeFacade implements ApiBasicGoodsCodeService{

	@Autowired
	BasicGoodsCodeService basicGoodsCodeService;

	public ResultDTO queryList(BasicGoodsCodeDTO dto) {
		ResultDTO result = new ResultDTO();
		BasicGoodsCode bean = new BasicGoodsCode();
		BeanUtils.copyProperties(dto, bean);
		List<BasicGoodsCode> list = basicGoodsCodeService.queryList(bean);
		result.setData(list);
		return result;
	}

	public ResultDTO update(BasicGoodsCodeDTO dto) {
		
		ResultDTO result = new ResultDTO();
		BasicGoodsCode bean = new BasicGoodsCode();
		BeanUtils.copyProperties(dto, bean);
        basicGoodsCodeService.updateGoodsCode(bean);
		
        result.setMessage("ok");
		return result;
	}

	public ResultDTO save(BasicGoodsCodeDTO dto) {

		ResultDTO result = new ResultDTO();
		BasicGoodsCode bean = new BasicGoodsCode();
		BeanUtils.copyProperties(dto, bean);
        basicGoodsCodeService.saveGoodsCode(bean);
		
        result.setMessage("ok");
		return result;
	}

	public ResultDTO delete(BasicGoodsCodeDTO dto) {

		ResultDTO result = new ResultDTO();
		BasicGoodsCode bean = new BasicGoodsCode();
		BeanUtils.copyProperties(dto, bean);
        basicGoodsCodeService.deleteGoodsCode(bean);
		
        result.setMessage("ok");

		return result;
	}

}
