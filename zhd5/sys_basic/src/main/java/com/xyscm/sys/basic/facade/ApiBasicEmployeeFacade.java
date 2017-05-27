package com.xyscm.sys.basic.facade;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xyscm.framework.common.api.ResultDTO;
import com.xyscm.sys.basic.api.ApiBasicEmployeeService;
import com.xyscm.sys.basic.api.dto.BasicEmployeeDto;
import com.xyscm.sys.basic.model.BasicEmployee;
import com.xyscm.sys.basic.service.BasicEmployeeService;

public class ApiBasicEmployeeFacade implements ApiBasicEmployeeService{

	@Autowired
	private BasicEmployeeService basicEmployeeService;
	        
	/**
	 * 查询所有员工
	 */
	public ResultDTO queryAll(String sysId) {
		List<BasicEmployee> basicEmployeeList = basicEmployeeService.queryAll();
		ResultDTO resultDTO = new ResultDTO();
		
		//数据处理封装
		resultDTO.setData(basicEmployeeList);
		return resultDTO;
	}

	/**
	 * 查询单个员工
	 */
	public ResultDTO get(String sysId, BasicEmployeeDto basicEmployeeDto) {
		BasicEmployee basicEmployee = basicEmployeeService.getByCode(basicEmployeeDto.getEmployeeCode(), basicEmployeeDto.getMemberCode());
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setData(basicEmployee);
		return resultDTO;
	}

	/**
	 * 增加
	 */
	public ResultDTO save(String sysId,BasicEmployeeDto basicEmployeeDto) {
		BasicEmployee BasicEmployee = new BasicEmployee();
		BeanUtils.copyProperties(basicEmployeeDto, BasicEmployee);
		basicEmployeeService.insert(BasicEmployee);
		ResultDTO resultDTO = new ResultDTO();
		//resultDTO.setStatus(save);
		return resultDTO;
	}

	/**
	 * 修改
	 */
	public ResultDTO update(String sysId,BasicEmployeeDto basicEmployeeDto) {
		BasicEmployee basicEmployee = new BasicEmployee();
		BeanUtils.copyProperties(basicEmployeeDto, basicEmployee);
		int update = basicEmployeeService.update(basicEmployee);
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setStatus(update);
		return resultDTO;
	}

	/**
	 * 删除
	 */
	public ResultDTO delete(String sysId,BasicEmployeeDto basicEmployeeDto) {
		int delete = basicEmployeeService.delete(basicEmployeeDto.getEmployeeCode(),basicEmployeeDto.getMemberCode());
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setStatus(delete);
		return resultDTO;
	}
}
