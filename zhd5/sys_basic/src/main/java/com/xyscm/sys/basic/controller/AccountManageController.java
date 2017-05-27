package com.xyscm.sys.basic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyscm.sys.basic.model.BasicCompanyAccounts;
import com.xyscm.sys.basic.service.BasicCompanyAccountsService;

@Controller
public class AccountManageController {

	@Autowired
	private BasicCompanyAccountsService basicCompanyAccountsService;
	
	/**
	 * 查询对应的账号
	 * @param request
	 * @param response
	 * @return
	 *
	 * PageInfo
	 */
	@RequestMapping("/account/queryCompanyAccounts")
	@ResponseBody
	public Map<String,Object>  queryCompany(String companyCode){
		Map<String,Object> map = new HashMap<>();
		List<BasicCompanyAccounts> list = basicCompanyAccountsService.queryCompanyAccounts(companyCode);
		map.put("data", list);
		return map;
	}
	

}
