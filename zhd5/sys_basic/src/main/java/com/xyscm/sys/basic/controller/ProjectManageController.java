package com.xyscm.sys.basic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyscm.sys.basic.model.BasicCompanyProject;
import com.xyscm.sys.basic.service.BasicCompanyProjectService;

@Controller
public class ProjectManageController {

	@Autowired
	private BasicCompanyProjectService basicCompanyProjectService;
	
	/**
	 * 查询对应的联系人
	 * @param request
	 * @param response
	 * @return
	 *
	 * PageInfo
	 */
	@RequestMapping("/project/queryCompanyProject")
	@ResponseBody
	public Map<String,Object>  queryCompany(String companyCode){
		Map<String,Object> map = new HashMap<>();
		List<BasicCompanyProject> list = basicCompanyProjectService.queryCompanyProject(companyCode);
		map.put("data", list);
		return map;
	}
	

}
