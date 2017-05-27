package com.xyscm.sys.basic.facade;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.common.json.JSONArray;
import com.alibaba.dubbo.common.json.JSONObject;
import com.xyscm.framework.common.api.ResultDTO;
import com.xyscm.sys.basic.api.ApiBasicOrgService;
import com.xyscm.sys.basic.api.dto.BasicOrgDto;
import com.xyscm.sys.basic.model.BasicOrg;
import com.xyscm.sys.basic.service.BasicOrgService;


public class ApiBasicOrgFacade implements ApiBasicOrgService{

	@Autowired
	private BasicOrgService basicOrgService;
	
	/**
	 * 查询所有机构
	 */
	public ResultDTO queryAll(String sysId) {
		List<BasicOrg> basicOrgList = basicOrgService.queryAll();
		ResultDTO resultDTO = new ResultDTO();
		
		//数据处理封装
		resultDTO.setData(basicOrgList);
		return resultDTO;
	}

	/**
	 * 查询单个机构
	 */
	public ResultDTO get(String sysId, BasicOrgDto basicOrgDto) {
		BasicOrg basicOrg = basicOrgService.getOrgByCode(basicOrgDto.getOrgCode(), basicOrgDto.getMemberCode());
		ResultDTO resultDTO = new ResultDTO();
		//resultDTO.setData(basicOrg);
		return resultDTO;
	}

	/**
	 * 增加
	 */
	public ResultDTO save(String sysId,BasicOrgDto basicOrgDto) {
		BasicOrg basicOrg = new BasicOrg();
		BeanUtils.copyProperties(basicOrgDto, basicOrg);
		int save = basicOrgService.save(basicOrg);
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setStatus(save);
		return resultDTO;
	}

	/**
	 * 修改
	 */
	public ResultDTO update(String sysId,BasicOrgDto basicOrgDto) {
		BasicOrg basicOrg = new BasicOrg();
		BeanUtils.copyProperties(basicOrgDto, basicOrg);
		int update = basicOrgService.update(basicOrg);
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setStatus(update);
		return resultDTO;
	}

	/**
	 * 删除
	 */
	public ResultDTO delete(String sysId,BasicOrgDto basicOrgDto) {
		int delete = basicOrgService.delete(basicOrgDto.getOrgCode(),basicOrgDto.getMemberCode());
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setStatus(delete);
		return resultDTO;
	}
	
}
