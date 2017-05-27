package com.xyscm.sys.basic.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyscm.sys.basic.cas.User;
import com.xyscm.sys.basic.cas.util.SessionUtils;
import com.xyscm.sys.basic.common.validatedGroup.SaveGroup;
import com.xyscm.sys.basic.common.validatedGroup.UpdateGroup;
import com.xyscm.sys.basic.model.BasicArea;
import com.xyscm.sys.basic.model.BasicCompany;
import com.xyscm.sys.basic.model.BasicDd;
import com.xyscm.sys.basic.model.BasicDept;
import com.xyscm.sys.basic.service.BasicCompanyService;
import com.xyscm.sys.basic.service.BasicDdService;
import com.xyscm.sys.basic.service.BasicDeptService;
import com.xyscm.sys.basic.vo.BasicCompanyVo;
import com.xyscm.sys.basic.vo.CombineCompanyVo;

@Controller
public class CompanyManageController {

	@Autowired
	private BasicCompanyService basicCompanyService;
	
	@Autowired
	private BasicDeptService basicDeptService;
	
	@Autowired
	private BasicDdService basicDdService;
	
	/**
	 * 跳转往来单位设置页面
	 * @param request
	 * @param response
	 * @return
	 *
	 * String
	 */
	@RequestMapping("/to_company")
	public String to_company(ServletRequest request,ServletResponse response){
			
		
		return "/companyManage/companyManage";
	}
	
	
	/**
	 * 查询往来单位
	 * @param request
	 * @param response
	 * @return
	 *
	 * PageInfo
	 */
/*	@RequestMapping("/company/queryCompany")
	@ResponseBody
	public Map<String,Object>  queryCompany(BasicCompanyVo vo){
		Map<String,Object> map = new HashMap<>();
		
		BasicCompany basicCompany = new BasicCompany();
		BeanUtils.copyProperties(vo, basicCompany);
		String orgCode = "0002";	//权限
		basicCompany.setMemberCode("0000");
		basicCompany.setOrgCode(orgCode);
		List<BasicCompany> list = basicCompanyService.queryCompany(basicCompany);
		map.put("data", list);
		return map;
	}*/
	
	
	/**
	 * 查询往来单位
	 * @param request
	 * @param response
	 * @return
	 *
	 * PageInfo
	 */
	@RequestMapping("/company/queryCompany")
	@ResponseBody
	public Map<String,Object>  queryCompany(BasicCompanyVo vo,String current_page,String page_size){
		Map<String,Object> map = new HashMap<>();
		User user = SessionUtils.getUserInfo();
		String orgCode = user.getOrgCode();	//权限---登录获取
		String memberCode = user.getMemberCode();
		try {
			BasicCompany basicCompany = new BasicCompany();
			BeanUtils.copyProperties(vo, basicCompany);
			
			basicCompany.setMemberCode(memberCode);
			basicCompany.setOrgCode(orgCode);
			PageInfo page = basicCompanyService.queryCompanyPage(basicCompany,Integer.parseInt(current_page),Integer.parseInt(page_size));
			map.put("max_page",  page.getPages());
			map.put("data", page.getList());
			map.put("page", page);
			map.put("msg", "ok");
		} catch (Exception e) {
			map.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	

	
	
	/**
	 *  根据AreaCode查询往来单位----地区
	 * @param request
	 * @param response
	 * @return
	 *
	 * BasicCompany
	 */
	/*@RequestMapping("/company/queryCompanyByAreaCode")
	@ResponseBody
	public  Map<String,Object>  queryCompanyByAreaCode(String areaCode){	
		Map<String,Object> map = new HashMap<>();
		String memberCode = "0000";
		String orgCode = "0002";	//权限
		List<BasicCompany> list = basicCompanyService.queryCompanyByAreaCode(memberCode, areaCode,orgCode);
		map.put("data", list);
		return map;
	}*/
	
	/**
	 *  根据AreaCode查询往来单位----地区
	 * @param request
	 * @param response
	 * @return
	 *
	 * BasicCompany
	 */
	@RequestMapping("/company/queryCompanyByAreaCode")
	@ResponseBody
	public  Map<String,Object>  queryCompanyByAreaCode(String areaCode,String current_page,String page_size){	
		Map<String,Object> map = new HashMap<>();
		
		User user = SessionUtils.getUserInfo();
		String memberCode = user.getMemberCode();
		String orgCode = user.getOrgCode();	//权限----登录获取
		try{
			PageInfo page = null;
			page = basicCompanyService.queryCompanyByAreaCodePage(memberCode, areaCode, orgCode,Integer.parseInt(current_page),Integer.parseInt(page_size) );
			map.put("max_page",  page.getPages());
			map.put("data", page.getList());
			map.put("page", page);
			map.put("msg", "ok");
		}catch(Exception e){
			map.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	
	
	/**
	 * 新增往来单位
	 * @param request
	 * @param response
	 *
	 * void
	 */
	@RequestMapping("/company/addCompany")
	@ResponseBody
	public  Map<String,Object>  insertCompany(@Validated({SaveGroup.class})BasicCompanyVo vo,BindingResult bindingResult){
		
		Map<String,Object> map = new HashMap<>();
		
		User user = SessionUtils.getUserInfo();
		String orgCode = user.getOrgCode();	//权限---登录获取
		String memberCode = user.getMemberCode();
		
		BasicCompany basicCompany = new BasicCompany();
		BeanUtils.copyProperties(vo, basicCompany);
		basicCompany.setMemberCode(memberCode);
		basicCompany.setOrgCode(orgCode);
		basicCompany.setDataEditDept(orgCode);
		
		//联系人
		String[] linkmans = vo.getLinkman_list();
		String[] accounts = vo.getAccount_list();
		String[] projects = vo.getProject_list();
		try{
			
			//验证表单
			validatedForm(bindingResult);
			
			basicCompanyService.insertCompanyS(basicCompany,linkmans,accounts,projects);
			map.put("msg", "ok");
		}catch(Exception e){
			map.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 编辑往来单位
	 * @param request
	 * @param response
	 *
	 * void
	 */
	@RequestMapping("/company/updateCompany")
	@ResponseBody
	public Map<String,Object> update(@Validated({UpdateGroup.class})BasicCompanyVo vo,BindingResult bindingResult){
		Map<String,Object> map = new HashMap<>();
		BasicCompany basicCompany = new BasicCompany();
		BeanUtils.copyProperties(vo, basicCompany);
		
		String[] linkman_list = vo.getLinkman_list();
		String[] account_list = vo.getAccount_list();
		String[] project_list = vo.getProject_list();
		try{
			
			//验证表单
			validatedForm(bindingResult);
			
			basicCompanyService.updateCompany(basicCompany,linkman_list,account_list,project_list);
			map.put("msg", "ok");
		}catch (Exception e) {
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}
	
	/**
	 * 删除往来单位
	 *
	 */
	@RequestMapping("/company/deleteCompany")
	@ResponseBody
	public Map<String,Object> deleteArea(String companyId){
		Map<String,Object> map = new HashMap<>();
		
		try{
			basicCompanyService.deleteCompany(new BigDecimal(companyId));
			map.put("msg", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}
	
	/**
	 * 下拉分管部门
	 * @param request
	 * @param response
	 * @return
	 *
	 * PageInfo
	 */
	@RequestMapping("/company/queryDept")
	@ResponseBody
	public Map<String,Object>  queryDept(){
		Map<String,Object> map = new HashMap<>();
		
		User user = SessionUtils.getUserInfo();
		String deptCode = user.getDeptCode();
		String memberCode = user.getMemberCode();
		try{ 
			List<BasicDept> list =  new ArrayList<>();
			BasicDept basicDept = basicDeptService.getDeptByCode(deptCode, memberCode);
			list.add(basicDept);
			map.put("data", list);
		}catch (BeansException e) {
			e.printStackTrace();
			map.put("msg", "error");
		}	
		return map;
	}
	
	/**
	 * 下拉上级单位
	 * @param request
	 * @param response
	 * @return
	 *
	 * PageInfo
	 */
	@RequestMapping("/company/queryUpCompany")
	@ResponseBody
	public Map<String,Object>  queryUpCompany(BasicCompanyVo vo){
		Map<String,Object> map = new HashMap<>();
		
		User user = SessionUtils.getUserInfo();
		String memberCode = user.getMemberCode();
		
		BasicCompany basicCompany = new BasicCompany();
		BeanUtils.copyProperties(vo, basicCompany);
		basicCompany.setMemberCode(memberCode);
		try{
			List<BasicCompany> list = basicCompanyService.queryCompany(basicCompany);
			map.put("data", list);
			map.put("msg", "ok");
		}catch (BeansException e) {
			e.printStackTrace();
			map.put("msg", "error");
		}
		
		return map;
	}
	
	/**
	 * 下拉单位类型（companyClass）、客户来源（companySource）、所属行业（companyIndustry）
	 * @param request
	 * @param response
	 * @return
	 *
	 * PageInfo
	 */
	@RequestMapping("/company/queryByClass")
	@ResponseBody
	public Map<String,Object>  queryUpCompany(String ddtypeClass){
		Map<String,Object> map = new HashMap<>();
		
		List<BasicDd> list =basicDdService.queryByClass(ddtypeClass);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 合并往来单位
	 * @param vo
	 * @return
	 *
	 * Map<String,Object>
	 */
	
	@RequestMapping("/company/combineCompany")
	@ResponseBody
	public Map<String,Object> combineCompany(@Validated({UpdateGroup.class})CombineCompanyVo vo,BindingResult bindingResult){
		Map<String,Object> map = new HashMap<>();
		
		try{
			//验证表单
			validatedForm(bindingResult);
			
			basicCompanyService.combineCompany(vo);
			map.put("msg", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		return map;
	}
	
	
	
	/**
	 *
	 * 验证提交参数
	 */
	public void validatedForm(BindingResult bindingResult )throws Exception{
		
		
		//验证
		if (bindingResult.hasErrors()) {
            
			ObjectError error = bindingResult.getAllErrors().get(0);
			
			String msg = error.getDefaultMessage();
			throw new Exception(msg);
        }
		
	}
	
}
