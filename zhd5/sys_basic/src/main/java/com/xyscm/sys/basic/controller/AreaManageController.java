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
import com.xyscm.sys.basic.model.BasicOrg;
import com.xyscm.sys.basic.service.BasicAreaService;
import com.xyscm.sys.basic.vo.BasicAreaVo;

@Controller
public class AreaManageController {
	
	@Autowired
	private BasicAreaService areaService;

	/**
	 * 跳转的地区设置页面
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 *
	 * String
	 */
	@RequestMapping("/to_area")
	public String to_area(ServletRequest request,ServletResponse response) {
		
		
		return "/areaManage/areaManage";
	}
	
	/**
	 * 查询所有地区
	 * @param request
	 * @param response
	 * @return
	 *
	 */
	@RequestMapping("/area/queryAllArea")
	@ResponseBody
	public Map<String,Object> queryAllArea(ServletRequest request,ServletResponse response){
		Map<String,Object> map = new HashMap<>();
		List<Map<String,Object>> list = new ArrayList<>();
		
		User user = SessionUtils.getUserInfo();
		String memberCode = user.getMemberCode();
		
		try{
			List<BasicArea> One_list = areaService.queryBasicArea(memberCode);	//一级地区
			if(One_list != null && One_list.size() > 0){
				for (BasicArea basicArea : One_list) {
					Map<String,Object> map_list = new HashMap<>();
					map_list.put("first", basicArea);
					String areaParent = basicArea.getAreaCode();
					List<BasicArea> Two_list = areaService.query2BasicArea(memberCode, areaParent);	//二级地区
					map_list.put("second", Two_list);
					for (int i=0;i<Two_list.size();i++) {
						BasicArea basicArea2 = Two_list.get(i);
						String areaNodecode = basicArea2.getAreaNodecode();
						List<BasicArea> Three_list = areaService.query3BasicArea(memberCode, areaNodecode);	//三级地区
						map_list.put("third"+i+"", Three_list);
					}
					list.add(map_list);
				}
			}
			map.put("data", list);
		} catch (Exception e) {
			map.put("msg", e.getMessage());
			e.printStackTrace();
		}	
		return map;
	}
	
	
	/**
	 * 查看地区
	 * @param request
	 * @param response
	 *
	 * void
	 */
	/*@RequestMapping("/area/query2BasicArea")
	@ResponseBody
	public Map<String,Object> query2BasicArea(ServletRequest request,ServletResponse response){
		Map<String,Object> map = new HashMap<>();
		String memberCode = "0000";
		String areaNodecode = request.getParameter("areaNodecode");
		String type = request.getParameter("type");
		String areaId = request.getParameter("areaId");
		String areaParent = request.getParameter("areaParent");
		List<BasicArea> list = new ArrayList<>();
		if( 0 == Integer.parseInt(type)){	//查看一级地区
			list = areaService.queryBasicArea(memberCode);
		}else if (1 == Integer.parseInt(type)) {	//查看二级地区
			list = areaService.query2BasicArea(memberCode, areaNodecode);
		}else {	//查看余下地区
			list = areaService.query2BasicArea(memberCode, areaParent);
		}
	
		map.put("data", list);
		
		BasicArea basicArea = null;
		if(areaId != null){
			basicArea = areaService.getAreaDetail(new BigDecimal(areaId));
		}
		map.put("basicArea", basicArea);
		return map;
	}
	*/
	
	/**
	 * 查看地区分页
	 * @param request
	 * @param response
	 *
	 * void
	 */
	@RequestMapping("/area/query2BasicArea")
	@ResponseBody
	public Map<String,Object> query2BasicArea(ServletRequest request,ServletResponse response){
		Map<String,Object> map = new HashMap<>();
		
		User user = SessionUtils.getUserInfo();
		String memberCode = user.getMemberCode();
		
		String areaNodecode = request.getParameter("areaNodecode");
		String type = request.getParameter("type");
		String areaId = request.getParameter("areaId");
		String areaParent = request.getParameter("areaParent");
		
		String current_page = request.getParameter("current_page");
		String page_size = request.getParameter("page_size");
		
		BasicArea basicArea = null;
		if(areaId != null && areaId.trim().length() != 0){
			basicArea = areaService.getAreaDetail(new BigDecimal(areaId));
		}
		map.put("basicArea", basicArea);
		
		try{
			PageInfo page = null;
			if( 0 == Integer.parseInt(type)){	//查看一级地区
				page = areaService.queryBasicAreaPage(memberCode,Integer.parseInt(current_page),Integer.parseInt(page_size));
			}else if (1 == Integer.parseInt(type)) {	//查看二级地区
				page = areaService.query2BasicAreaPage(memberCode, areaNodecode,Integer.parseInt(current_page),Integer.parseInt(page_size));
			}else {	//查看余下地区
				page = areaService.query2BasicAreaPage(memberCode, areaParent,Integer.parseInt(current_page),Integer.parseInt(page_size));
			}
		
			map.put("max_page",  page.getPages());
			map.put("data", page.getList());
			map.put("page", page);
			map.put("msg", "ok");
		}catch (Exception e) {
			map.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	
	
	/**
	 * 查询所有地区----------用于往来单位中的地区下拉框（无需树形结构）
	 * @param request
	 * @param response
	 *
	 * void
	 */
	@RequestMapping("/area/getAllArea")
	@ResponseBody
	public Map<String,Object>  getAllArea(ServletRequest request,ServletResponse response){
		Map<String,Object> map = new HashMap<>();
		
		User user = SessionUtils.getUserInfo();
		String memberCode = user.getMemberCode();
		
		try{
			List<BasicArea> list = areaService.queryAllArea(memberCode);
			map.put("data", list);
		}catch(Exception e){
			map.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
	
	
	/**
	 * 查询地区详情
	 * @param request
	 * @param response
	 *
	 * void
	 */
	@RequestMapping("/area/getAreaDetail")
	public BasicArea getAreaDetail(ServletRequest request,ServletResponse response){
		BigDecimal areaId = new BigDecimal(1234);
		BasicArea basicArea = areaService.getAreaDetail(areaId);
		return basicArea;
	}
	
	
	
	/**
	 * 新增地区
	 * @param request
	 * @param response
	 *
	 */
	@RequestMapping("/area/insertArea")
	@ResponseBody
	public Map<String,Object>  insertArea(@Validated({SaveGroup.class})BasicAreaVo vo,BindingResult bindingResult){
		
		Map<String,Object> map = new HashMap<>();
		 
		User user = SessionUtils.getUserInfo();
		String memberCode = user.getMemberCode();
		
		BasicArea basicArea = new BasicArea();
		
		try{
			//验证表单
			validatedForm(bindingResult);
			
			BeanUtils.copyProperties(vo, basicArea);
			basicArea.setMemberCode(memberCode);
			areaService.insertArea(basicArea);
			map.put("msg", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}
	
	
	
	
	/**
	 * 编辑地区
	 * @param request
	 * @param response
	 *
	 * void
	 */
	@RequestMapping("/area/updateArea")
	@ResponseBody
	public  Map<String,Object> updateArea(@Validated({UpdateGroup.class})BasicAreaVo vo,BindingResult bindingResult){
		Map<String,Object> map = new HashMap<>();
		BasicArea basicArea = new BasicArea();
		
		try{
			//验证表单
			validatedForm(bindingResult);
			
			BeanUtils.copyProperties(vo, basicArea);
			areaService.updateArea(basicArea);
			map.put("msg", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
		
	}
	
	
	/**
	 * 删除地区
	 * @param request
	 * @param response
	 *
	 * void
	 */
	@RequestMapping("/area/deleteArea")
	@ResponseBody
	public Map<String,Object> deleteArea(String areaNodecode,String areaParent){
		Map<String,Object> map = new HashMap<>();
		String memberCode = "0000";
		
		try{
			List<?> list = areaService.query2BasicArea(memberCode, areaParent);
			if(list == null || list.size() == 0){
				areaService.deleteArea(memberCode, areaNodecode);
				map.put("msg", "ok");
			}else{
				map.put("msg", "error");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "error");
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
