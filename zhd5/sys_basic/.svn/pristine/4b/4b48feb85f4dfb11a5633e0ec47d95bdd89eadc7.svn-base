package com.xyscm.sys.basic.facade;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xyscm.framework.common.api.ResultDTO;
import com.xyscm.sys.basic.api.ApiBasicAreaService;
import com.xyscm.sys.basic.api.dto.BasicAreaDto;
import com.xyscm.sys.basic.model.BasicArea;
import com.xyscm.sys.basic.service.BasicAreaService;
/**
 * 
 * 地区接口实现
 * 
 * @author Administrator
 *
 */
public class ApiBasicAreaFacade implements ApiBasicAreaService{
	

	
	@Autowired
	private BasicAreaService basicAreaService;

	
	/**
	 *所有地区	
	 */
	public ResultDTO queryAllArea(String memberCode) {
		ResultDTO result = new ResultDTO();
		List<BasicArea> list = basicAreaService.queryAllArea(memberCode);
		result.setData(list);
		return result;
	}
	
	/**
	 * 一级地区
	 */
	public ResultDTO queryBasicArea(String memberCode) {
		ResultDTO result = new ResultDTO();
		List<BasicArea> list = basicAreaService.queryBasicArea(memberCode);
		result.setData(list);
		return result;
	}
	
	/**
	 * 二级地区
	 */
	public ResultDTO query2BasicArea(String memberCode, String areaNodecode) {
		ResultDTO result = new ResultDTO();
		List<BasicArea> list = basicAreaService.query2BasicArea(memberCode, areaNodecode);
		result.setData(list);
		return result;
	}

	/**
	 * 当前地区详情
	 */
	public ResultDTO getAreaDetail(BigDecimal areaId) {
		ResultDTO result = new ResultDTO();
		BasicArea basicArea  = basicAreaService.getAreaDetail(areaId);
		result.setData(basicArea);
		return result;
	}
	
	/**
	 * 增加地区
	 */
	public ResultDTO insertArea(BasicAreaDto dto) {
		ResultDTO result = new ResultDTO();
		BasicArea basicArea = new BasicArea();
		BeanUtils.copyProperties(dto, basicArea);
		int i = basicAreaService.insertArea(basicArea);
		result.setStatus(i);
		return result;
	}

	/**
	 * 编辑地区
	 */
	public ResultDTO updateArea(BasicAreaDto dto) {
		ResultDTO result = new ResultDTO();
		BasicArea basicArea = new BasicArea();
		BeanUtils.copyProperties(dto, basicArea);
		int i = basicAreaService.updateArea(basicArea);
		result.setStatus(i);
		return result;
	}
	
	/**
	 * 删除地区
	 */
	public ResultDTO deleteBasicArea(String memberCode, String areaNodecode) {
		ResultDTO result = new ResultDTO();
		int i = basicAreaService.deleteArea(memberCode, areaNodecode);
		result.setStatus(i);
		return result;
	}


}
