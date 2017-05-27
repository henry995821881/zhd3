package com.xyscm.sys.basic.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.xyscm.sys.basic.common.constant.ErrorCode;
import com.xyscm.sys.basic.common.exception.BaseException;
import com.xyscm.sys.basic.common.util.DateUtil;
import com.xyscm.sys.basic.common.util.MessageSourceUtil;
import com.xyscm.sys.basic.model.BasicDept;
import com.xyscm.sys.basic.model.BasicEmployee;
import com.xyscm.sys.basic.model.BasicOrg;
import com.xyscm.sys.basic.service.BasicDeptService;
import com.xyscm.sys.basic.service.BasicEmployeeService;
import com.xyscm.sys.basic.service.BasicOrgService;
import com.xyscm.sys.basic.vo.BasicEmployeeVo;

@Controller
public class BasicEmployeeController {

	@Autowired
	private BasicEmployeeService basicEmployeeService;
	@Autowired
	private BasicOrgService basicOrgService;
	@Autowired
	private BasicDeptService basicDeptService;
	
	private static final Logger logger = LoggerFactory.getLogger(BasicEmployeeController.class.getName());
	
	@RequestMapping("/employeeManage")
	public String DeptManage(ServletRequest request,ServletResponse response){
		return "orgManage/employeeManage";
	}
	
	/**
	 * 新增员工
	 * @return
	 */
	@RequestMapping("/employeeManage/add")
	@ResponseBody
	public  Map<String,Object> add(BasicEmployeeVo basicEmployeeVo) {
		Map<String,Object> map = new HashMap<>();
		try {
			//表单验证
			logger.debug(basicEmployeeVo.toString());
			BasicEmployee basicEmployee = new BasicEmployee();
			BeanUtils.copyProperties(basicEmployeeVo, basicEmployee);
			Date employeeBirthday = DateUtil.getDateToString(basicEmployeeVo.getEmployeeBirthday(), DateUtil.DATESHOWFORMAT);
			basicEmployee.setEmployeeBirthday(employeeBirthday);
			Date employeeJoindate = DateUtil.getDateToString(basicEmployeeVo.getEmployeeJoindate(), DateUtil.DATESHOWFORMAT);
			basicEmployee.setEmployeeJoindate(employeeJoindate);
			basicEmployee.setMemberCode("0000");
			logger.debug(basicEmployee.toString());
			try {
				basicEmployeeService.insert(basicEmployee);
			} catch (Exception e) {
				throw new RuntimeException("11111111");
			}
		
			
			map.put("msg", "ok");
		} catch (Exception e) {
			map.put("msg", "error");
			throw new BaseException(ErrorCode.E_SYSB_EMPLOYEE_ADD.getErrCode(),MessageSourceUtil.getMessage(ErrorCode.E_SYSB_EMPLOYEE_ADD.getErrCode()));
		}
		return map;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/employeeManage/update")
	@ResponseBody
	public  Map<String,Object> updateEmployee(BasicEmployeeVo basicEmployeeVo) {
		Map<String,Object> map = new HashMap<>();
		try {
			logger.debug(basicEmployeeVo.toString());
			BasicEmployee basicEmployee = new BasicEmployee();
			
			BeanUtils.copyProperties(basicEmployeeVo, basicEmployee);
			Date employeeBirthday = DateUtil.getDateToString(basicEmployeeVo.getEmployeeBirthday(), DateUtil.DATESHOWFORMAT);
			basicEmployee.setEmployeeBirthday(employeeBirthday);
			Date employeeJoindate = DateUtil.getDateToString(basicEmployeeVo.getEmployeeJoindate(), DateUtil.DATESHOWFORMAT);
			basicEmployee.setEmployeeJoindate(employeeJoindate);
			basicEmployee.setMemberCode("0000");
			logger.debug(basicEmployee.toString());
			try {
				int update = basicEmployeeService.update(basicEmployee);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("11111111");
			}
			
			map.put("msg", "ok");
		} catch (Exception e) {
			map.put("msg", "error");
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_EMPLOYEE_UPDATE.getErrCode(),MessageSourceUtil.getMessage(ErrorCode.E_SYSB_EMPLOYEE_UPDATE.getErrCode()));
		}
		return map;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/employeeManage/delete")
	@ResponseBody
	public Map<String,Object> delete(String employee_code) {
		Map<String,Object> map = new HashMap<>();
		try {
			BasicEmployee basicEmployee = new BasicEmployee();
			basicEmployee.setMemberCode("0000");
			int delete = basicEmployeeService.delete(employee_code,basicEmployee.getMemberCode());
			map.put("msg", "ok");
		} catch (Exception e) {
			map.put("msg", "error");
			throw new BaseException(ErrorCode.E_SYSB_EMPLOYEE_DELETE.getErrCode(),MessageSourceUtil.getMessage(ErrorCode.E_SYSB_EMPLOYEE_DELETE.getErrCode()));
		}
		return map;
	}
	
	
	/**
	 * 查询所有
	 */
	@RequestMapping("/employeeManage/query")
	@ResponseBody
	public  Map<String,Object> queryEmployee(){
		Map<String,Object> map = new HashMap<>();
		
		List<BasicEmployee> basicEmployeeList = basicEmployeeService.queryAll();
		String memberCode = "0000";
		Long deptIsleaf = 1L;
		Long orgIsleaf = 1L;
		List<BasicDept> basicDeptList = basicDeptService.queryDeptCombo(memberCode, deptIsleaf);
		List<BasicOrg> basicOrgList = basicOrgService.queryOrgCombo(memberCode,orgIsleaf);
		
		map.put("msg", "ok");
		map.put("data", basicEmployeeList);
		map.put("deptList", basicDeptList);
		map.put("orgList", basicOrgList);
		
		return map;
	}
	
	/**
	 * 查询分页(分页)
	 */
	@RequestMapping("/employeeManage/queryForPage")
	@ResponseBody
	public  Map<String,Object> queryEmployeePage(BasicEmployeeVo basicEmployeeVo,Integer current_page,Integer page_size){
		Map<String,Object> map = new HashMap<>();
		
		try {
			BasicEmployee basicEmployee = new BasicEmployee();
			 
			BeanUtils.copyProperties(basicEmployeeVo, basicEmployee);
			basicEmployee.setMemberCode("0000");
			
			 
			PageInfo page = basicEmployeeService.getPage(current_page, page_size, basicEmployee);
			
			
			map.put("max_page",  page.getPages());
			map.put("data", page.getList());
			map.put("page", page);
			map.put("msg", "ok");
		} catch (Exception e) {
			map.put("msg", "error");
			e.printStackTrace();
		}
		
		return map;
	}
}
