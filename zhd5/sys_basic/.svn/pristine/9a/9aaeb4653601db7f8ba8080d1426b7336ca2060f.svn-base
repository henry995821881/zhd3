package com.xyscm.sys.basic.facade;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xyscm.framework.common.api.ResultDTO;
import com.xyscm.sys.basic.api.ApiBasicCompanyService;
import com.xyscm.sys.basic.api.dto.BasicCompanyDto;
import com.xyscm.sys.basic.model.BasicCompany;
import com.xyscm.sys.basic.service.BasicCompanyService;

public class ApiBasicCompanyFacade implements ApiBasicCompanyService{

	@Autowired
	private BasicCompanyService basicCompanyService;
	
	public ResultDTO queryCompany(BasicCompanyDto dto) {
		ResultDTO result = new ResultDTO();
		BasicCompany basicCompany = new BasicCompany();
		BeanUtils.copyProperties(dto, basicCompany);
		List<BasicCompany> list = basicCompanyService.queryCompany(basicCompany);
		result.setData(list);
		return result;
	}

	public ResultDTO getCompanyInfo(BigDecimal companyId) {
		ResultDTO result = new ResultDTO();
		BasicCompany basicCompany = basicCompanyService.getCompanyInfo(companyId);
		result.setData(basicCompany);
		return result;
	}

	public ResultDTO insertCompany(BasicCompanyDto dto) {
		ResultDTO result = new ResultDTO();
		BasicCompany basicCompany = new BasicCompany();
		BeanUtils.copyProperties(dto, basicCompany);
		int i = basicCompanyService.insertCompany(basicCompany);
		result.setStatus(i);
		return result;
	}

	public ResultDTO updateCompany(BasicCompanyDto dto) {
		ResultDTO result = new ResultDTO();
		BasicCompany basicCompany = new BasicCompany();
		BeanUtils.copyProperties(dto, basicCompany);
		int i = basicCompanyService.updateCompany(basicCompany);
		result.setStatus(i);
		return result;
	}

	public ResultDTO deleteCompany(BigDecimal companyId) {
		ResultDTO result = new ResultDTO();
		int i = basicCompanyService.deleteCompany(companyId);
		result.setStatus(i);
		return result;
	}
	
	

}
