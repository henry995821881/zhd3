package com.xyscm.sys.basic.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.xyscm.sys.basic.common.util.MessageSourceUtil;
import com.xyscm.sys.basic.model.BasicDept;
import com.xyscm.sys.basic.model.BasicOrg;
import com.xyscm.sys.basic.service.BasicDeptService;
import com.xyscm.sys.basic.vo.BasicDeptVo;



@Controller
public class BasicDeptController {

	@Autowired
	private BasicDeptService basicDeptService;
	
	private static final Logger logger = LoggerFactory.getLogger(BasicEmployeeController.class.getName());
	
	@RequestMapping("/deptManage")
	public String DeptManage(ServletRequest request,ServletResponse response){
		return "orgManage/deptManage";
	}
	
	
	/**
	 * 查询所有部门
	 * @param request
	 * @param response
	 * @return
	 *
	 */
	@RequestMapping("/deptManage/queryAllDept")
	@ResponseBody
	public Map<String,Object> queryAllDept(ServletRequest request,ServletResponse response){
		Map<String,Object> map = new HashMap<>();
		List<Map<String,Object>> list = new ArrayList<>();
		
		
		String memberCode = "0000";
		List<BasicDept> One_list = basicDeptService.queryBasicDept(memberCode);	//一级组织
		if(One_list != null && One_list.size() > 0){
			for (BasicDept basicDept : One_list) {
				Map<String,Object> map_list = new HashMap<>();
				map_list.put("first", basicDept);
				String deptParent = basicDept.getDeptCode();
				List<BasicDept> Two_list = basicDeptService.query2BasicDept(memberCode, deptParent);	//二级地区
				map_list.put("second", Two_list);
				/*for (int i=0;i<Two_list.size();i++) {
					BasicDept basicDept2 = Two_list.get(i);
					String deptNodecode = basicDept2.getDeptNodecode();
					List<BasicDept> Three_list = basicDeptService.query3BasicDept(memberCode, deptNodecode);	//三级地区
					map_list.put("third"+i+"", Three_list);
				}*/
				list.add(map_list);
			}
		}
		
		//部门下拉列表 deptIsleaf = 0;
		Long  deptIsleaf = 0L;
		List<BasicDept> parentList = basicDeptService.queryDeptCombo(memberCode,deptIsleaf);
		map.put("parentList",parentList);
		map.put("data", list);
		return map;
	}
	
	
	/**
	 * 查看机构
	 * @param request
	 * @param response
	 *
	 * void
	 */
	@RequestMapping("/deptManage/queryBasicDept")
	@ResponseBody
	public Map<String,Object> queryBasicDept(ServletRequest request,ServletResponse response){
		Map<String,Object> map = new HashMap<>();
		String memberCode = "0000";
		String deptCode = request.getParameter("deptCode");
		String type = request.getParameter("type");
		String deptId = request.getParameter("deptId");
		String current_page = request.getParameter("current_page");
		String page_size = request.getParameter("page_size");
		List<BasicDept> list = new ArrayList<>();
		/*if( 0 == Integer.parseInt(type)){	//查看一级机构
			list = basicOrgService.queryBasicOrg(memberCode);
		}else if (1 == Integer.parseInt(type)) {	//查看二级机构
			list = basicOrgService.query2BasicOrg(memberCode, orgNodecode);
		}*/
		PageInfo<BasicDept> page = basicDeptService.queryByParentPage(current_page,page_size,deptCode);
		
		map.put("max_page",  page.getPages());
		map.put("data", page.getList());
		map.put("page", page);
		map.put("msg", "ok");
		
		return map;
	}
	
	
	
	
	/**
	 * 新增部门
	 * @return
	 */
	@RequestMapping("/deptManage/add")
	@ResponseBody
	public  Map<String,Object> add(BasicDeptVo basicDeptVo) {
		Map<String,Object> map = new HashMap<>();
		try {
			//表单验证
			logger.debug(basicDeptVo.toString());
			BasicDept basicDept = new BasicDept();
			BeanUtils.copyProperties(basicDeptVo, basicDept);
			basicDept.setMemberCode("0000");
			/*basicDept.setDeptNodecode("node");*/
			basicDept.setDeptIsleaf(new BigDecimal(1));
			logger.debug(basicDept.toString());
			try {
				basicDeptService.save(basicDept);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("11111111");
			}
			map.put("msg", "ok");
		} catch (Exception e) {
			map.put("msg", "error");
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_DEPT_ADD.getErrCode(),MessageSourceUtil.getMessage(ErrorCode.E_SYSB_DEPT_ADD.getErrCode()));
		}
		return map;
	}
	
	/**
	 * 修改部门
	 */
	@RequestMapping("/deptManage/update")
	@ResponseBody
	public  Map<String,Object> update(BasicDeptVo basicDeptVo) {
		Map<String,Object> map = new HashMap<>();
		try {
			logger.debug(basicDeptVo.toString());
			BasicDept basicDept = new BasicDept();
			BeanUtils.copyProperties(basicDeptVo, basicDept);
			basicDept.setMemberCode("0000");
			logger.debug(basicDept.toString());
			try {
				int update = basicDeptService.update(basicDept);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("11111111");
			}
			map.put("msg", "ok");
		} catch (Exception e) {
			map.put("msg", "error");
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_DEPT_UPDATE.getErrCode(),MessageSourceUtil.getMessage(ErrorCode.E_SYSB_DEPT_UPDATE.getErrCode()));
		}
		return map;
	}
	/*@RequestMapping("/deptManage/update")
	public @ResponseBody BasicResult update(BasicDept basicDept) {
		try {
			int update = basicDeptService.update(basicDept);
		} catch (Exception e) {
			throw new BaseException(ErrorCode.E_SYSB_DEPT_UPDATE.getErrCode(),MessageSourceUtil.getMessage(ErrorCode.E_SYSB_DEPT_UPDATE.getErrCode()));
		}
		return BasicResult.ok();
	}*/
	
	/**
	 * 删除部门
	 */
	@RequestMapping("/deptManage/delete")
	@ResponseBody
	public  Map<String,Object> delete(String deptCode) {
		Map<String,Object> map = new HashMap<>();
		try {
			BasicDept basicDept = new BasicDept();
			basicDept.setMemberCode("0000");
			int delete = basicDeptService.delete(deptCode,basicDept.getMemberCode());
			map.put("msg", "ok");
		} catch (Exception e) {
			map.put("msg", "error");
			throw new BaseException(ErrorCode.E_SYSB_DEPT_DELETE.getErrCode(),MessageSourceUtil.getMessage(ErrorCode.E_SYSB_DEPT_DELETE.getErrCode()));
		}
		return map;
	}
	/**
	 * 查询所有
	 */
	@RequestMapping("/deptManage/query")
	@ResponseBody
	public  Map<String,Object> query(){
		Map<String,Object> map = new HashMap<>();
		List<BasicDept> basicDeptList = basicDeptService.queryAll();
		
		//查询上级组织
		
		map.put("msg", "ok");
		map.put("data", basicDeptList);
		return map;
	}
	
	
	/**
	 * 查询部门下拉框
	 */
	@RequestMapping("/deptManage/queryCombo")
	@ResponseBody
	public   Map<String,Object> query(String deptIsleaf){
		Map<String,Object> map = new HashMap<>();
		String memberCode = "0000";
		List<BasicDept> basicDeptList = basicDeptService.queryDeptCombo(memberCode, Long.parseLong(deptIsleaf));	
		//查询上级组织
		map.put("msg", "ok");
		map.put("data", basicDeptList);
		return map;
	}
	
}
