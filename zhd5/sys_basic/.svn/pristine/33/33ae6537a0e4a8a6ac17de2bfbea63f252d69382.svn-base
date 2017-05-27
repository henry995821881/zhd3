package com.xyscm.sys.basic.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
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
import com.xyscm.sys.basic.service.BasicOrgService;
import com.xyscm.sys.basic.vo.BasicOrgVo;

@Controller
public class BasicOrgController{

	@Autowired
	private BasicOrgService basicOrgService;
	
	private static final Logger logger = LoggerFactory.getLogger(BasicEmployeeController.class.getName());
	
	/**
	 * 跳转的机构设置设置页面
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 *
	 * String
	 */
	@RequestMapping("/orgManage")
	public String DeptManage(ServletRequest request,ServletResponse response){
		return "orgManage/orgManage";
	}
	
	
	/**
	 * 查询所有组织
	 * @param request
	 * @param response
	 * @return
	 *
	 */
	@RequestMapping("/orgManage/queryAllOrg")
	@ResponseBody
	public Map<String,Object> queryAllOrg(ServletRequest request,ServletResponse response){
		Map<String,Object> map = new HashMap<>();
		List<Map<String,Object>> list = new ArrayList<>();
		
		
		String memberCode = "0000";
		List<BasicOrg> One_list = basicOrgService.queryBasicOrg(memberCode);	//一级组织
		if(One_list != null && One_list.size() > 0){
			for (BasicOrg basicOrg : One_list) {
				Map<String,Object> map_list = new HashMap<>();
				map_list.put("first", basicOrg);
				String orgParent = basicOrg.getOrgCode();
				List<BasicOrg> Two_list = basicOrgService.query2BasicOrg(memberCode, orgParent);	//二级地区
				map_list.put("second", Two_list);
				/*for (int i=0;i<Two_list.size();i++) {
					BasicOrg basicOrg2 = Two_list.get(i);
					String orgNodecode = basicOrg2.getOrgNodecode();
					List<BasicOrg> Three_list = basicOrgService.query3BasicOrg(memberCode, orgNodecode);	//三级地区
					map_list.put("third"+i+"", Three_list);
				}*/
				list.add(map_list);
			}
		}
		//组织下拉列表 orgIsleaf = 0;
		Long  orgIsleaf = 0L;
		List<BasicOrg> parentList = basicOrgService.queryOrgCombo(memberCode,orgIsleaf);
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
	@RequestMapping("/orgManage/queryBasicOrg")
	@ResponseBody
	public Map<String,Object> queryBasicOrg(ServletRequest request,ServletResponse response){
		Map<String,Object> map = new HashMap<>();
		String memberCode = "0000";
		String orgCode = request.getParameter("orgCode");
		String type = request.getParameter("type");
		String orgId = request.getParameter("orgId");
		String current_page = request.getParameter("current_page");
		String page_size = request.getParameter("page_size");
		List<BasicOrg> list = new ArrayList<>();
		/*if( 0 == Integer.parseInt(type)){	//查看一级机构
			list = basicOrgService.queryBasicOrg(memberCode);
		}else if (1 == Integer.parseInt(type)) {	//查看二级机构
			list = basicOrgService.query2BasicOrg(memberCode, orgNodecode);
		}*/
		PageInfo<BasicOrg> page = basicOrgService.queryByParentPage(current_page,page_size,orgCode);
		
		map.put("max_page",  page.getPages());
		map.put("data", page.getList());
		map.put("page", page);
		map.put("msg", "ok");
		
		return map;
	}
	
	
	
	/**
	 * 新增机构
	 * @return
	 */
	@RequestMapping("/orgManage/add")
	@ResponseBody
	public  Map<String,Object> add(BasicOrgVo basicOrgVo) {
		Map<String,Object> map = new HashMap<>();
		try {
			//表单验证
			logger.debug(basicOrgVo.toString());
			BasicOrg basicOrg = new BasicOrg();
			BeanUtils.copyProperties(basicOrgVo, basicOrg);
			/*basicOrg.setOrgNodecode("node");*/
			basicOrg.setMemberCode("0000");
			basicOrg.setOrgIsleaf(new BigDecimal(1));
			logger.debug(basicOrg.toString());
			try {
				basicOrgService.save(basicOrg);
			} catch (Exception e) {
				throw new RuntimeException("11111111");
			}
		
			
			map.put("msg", "ok");
		} catch (Exception e) {
			map.put("msg", "error");
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_ORG_ADD.getErrCode(),MessageSourceUtil.getMessage(ErrorCode.E_SYSB_ORG_ADD.getErrCode()));
		}
		return map;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/orgManage/update")
	@ResponseBody
	public  Map<String,Object> update(BasicOrgVo basicOrgVo) {
		Map<String,Object> map = new HashMap<>();
		try {
			logger.debug(basicOrgVo.toString());
			BasicOrg basicOrg = new BasicOrg();
			BeanUtils.copyProperties(basicOrgVo, basicOrg);
			basicOrg.setMemberCode("0000");
			logger.debug(basicOrg.toString());
			try {
				int update = basicOrgService.update(basicOrg);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("11111111");
			}
			map.put("msg", "ok");
		} catch (Exception e) {
			map.put("msg", "error");
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_ORG_UPDATE.getErrCode(),MessageSourceUtil.getMessage(ErrorCode.E_SYSB_ORG_UPDATE.getErrCode()));
		}
		return map;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/orgManage/delete")
	@ResponseBody
	public  Map<String,Object> delete(String orgCode) {
		Map<String,Object> map = new HashMap<>();
		try {
			BasicOrg basicOrg = new BasicOrg();
			basicOrg.setMemberCode("0000");
			int delete = basicOrgService.delete(orgCode,basicOrg.getMemberCode());
			map.put("msg", "ok");
		} catch (Exception e) {
			map.put("msg", "error");
			throw new BaseException(ErrorCode.E_SYSB_ORG_DELETE.getErrCode(),MessageSourceUtil.getMessage(ErrorCode.E_SYSB_ORG_DELETE.getErrCode()));
		}
		return map;
	}
	
	
	/**
	 * 查询分页(分页)
	 */
	@RequestMapping("/orgManage/query")
	@ResponseBody
	public  Map<String,Object> query(){
		Map<String,Object> map = new HashMap<>();
		
		List<BasicOrg> basicOrgList = basicOrgService.queryAll();
		
		map.put("msg", "ok");
		map.put("data", basicOrgList);
		
		return map;
	}
	
	/**
	 * 查询机构下拉框
	 */
	@RequestMapping("/orgManage/queryCombo")
	@ResponseBody
	public   Map<String,Object> query(String orgIsleaf){
		Map<String,Object> map = new HashMap<>();
		String memberCode = "0000";
		List<BasicOrg> basicOrgList = basicOrgService.queryOrgCombo(memberCode, Long.parseLong(orgIsleaf));	
		//查询上级组织
		map.put("msg", "ok");
		map.put("data", basicOrgList);
		return map;
	}

	
	
	
}
