package com.xyscm.sys.basic.facade;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xyscm.framework.common.api.ResultDTO;
import com.xyscm.sys.basic.api.ApiBasicDeptService;
import com.xyscm.sys.basic.api.dto.BasicDeptDto;
import com.xyscm.sys.basic.model.BasicDept;
import com.xyscm.sys.basic.service.BasicDeptService;

public class ApiBasicDeptFacade implements ApiBasicDeptService{

	@Autowired
	private BasicDeptService basicDeptService;
	        
	/**
	 * 查询所有部门
	 */
	public ResultDTO queryAll(String sysId) {
		List<BasicDept> basicDeptList = basicDeptService.queryAll();
		ResultDTO resultDTO = new ResultDTO();
		
		//数据处理封装
		resultDTO.setData(basicDeptList);
		return resultDTO;
	}

	/**
	 * 查询单个部门
	 */
	public ResultDTO get(String sysId, BasicDeptDto basicDeptDto) {
		BasicDept basicDept = basicDeptService.getDeptByCode(basicDeptDto.getDeptCode(), basicDeptDto.getMemberCode());
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setData(basicDept);
		return resultDTO;
	}

	/**
	 * 增加
	 */
	public ResultDTO save(String sysId,BasicDeptDto basicDeptDto) {
		BasicDept basicDept = new BasicDept();
		BeanUtils.copyProperties(basicDeptDto, basicDept);
		int save = basicDeptService.save(basicDept);
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setStatus(save);
		return resultDTO;
	}

	/**
	 * 修改
	 */
	public ResultDTO update(String sysId,BasicDeptDto basicDeptDto) {
		BasicDept basicDept = new BasicDept();
		BeanUtils.copyProperties(basicDeptDto, basicDept);
		int update = basicDeptService.update(basicDept);
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setStatus(update);
		return resultDTO;
	}

	/**
	 * 删除
	 */
	public ResultDTO delete(String sysId,BasicDeptDto basicDeptDto) {
		int delete = basicDeptService.delete(basicDeptDto.getDeptCode(), basicDeptDto.getMemberCode());
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setStatus(delete);
		return resultDTO;
	}

}
