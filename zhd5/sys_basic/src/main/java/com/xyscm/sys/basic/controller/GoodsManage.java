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
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.xyscm.sys.basic.cas.User;
import com.xyscm.sys.basic.cas.util.SessionUtils;
import com.xyscm.sys.basic.common.validatedGroup.DeleteGroup;
import com.xyscm.sys.basic.common.validatedGroup.QueryGroup;
import com.xyscm.sys.basic.common.validatedGroup.SaveGroup;
import com.xyscm.sys.basic.common.validatedGroup.UpdateGroup;
import com.xyscm.sys.basic.model.BasicGoodsCode;
import com.xyscm.sys.basic.model.BasicPartsName;
import com.xyscm.sys.basic.model.BasicPnTree;
import com.xyscm.sys.basic.model.BasicProductArea;
import com.xyscm.sys.basic.model.BasicWareArea;
import com.xyscm.sys.basic.model.BasicWarePlace;
import com.xyscm.sys.basic.model.BasicWarehouse;
import com.xyscm.sys.basic.model.BasicWorkgroup;
import com.xyscm.sys.basic.model.MonitoringDevice;
import com.xyscm.sys.basic.model.SystemIndustry;
import com.xyscm.sys.basic.service.BasicGoodsCodeService;
import com.xyscm.sys.basic.service.BasicPartsNameService;
import com.xyscm.sys.basic.service.BasicPnTreeService;
import com.xyscm.sys.basic.service.BasicProductAreaService;
import com.xyscm.sys.basic.service.BasicWareAreaService;
import com.xyscm.sys.basic.service.BasicWarePlaceService;
import com.xyscm.sys.basic.service.BasicWarehouseService;
import com.xyscm.sys.basic.service.BasicWorkgroupService;
import com.xyscm.sys.basic.service.MonitoringDeviceService;
import com.xyscm.sys.basic.service.SystemIndustryService;
import com.xyscm.sys.basic.vo.BasicGoodsCodeVo;
import com.xyscm.sys.basic.vo.BasicPartsNameVo;
import com.xyscm.sys.basic.vo.BasicPnTreeVo;
import com.xyscm.sys.basic.vo.BasicProductAreaVo;
import com.xyscm.sys.basic.vo.BasicWareAreaVo;
import com.xyscm.sys.basic.vo.BasicWarePlaceVo;
import com.xyscm.sys.basic.vo.BasicWarehouseVo;
import com.xyscm.sys.basic.vo.MonitoringDeviceVo;
import com.xyscm.sys.basic.vo.SystemIndustryVo;

@Controller
public class GoodsManage {

	@Autowired
	BasicWarehouseService basicWarehouseService;
	
	
	@Autowired
	BasicWareAreaService basicWareAreaService;
	
	@Autowired
	BasicWarePlaceService basicWarePlaceService;
	
	
	@Autowired
	BasicPnTreeService basicPnTreeService;
	
	
	@Autowired
	BasicPartsNameService basicPartsNameService;
	
	@Autowired
	BasicProductAreaService basicProductAreaService;
	
	
	@Autowired
	BasicGoodsCodeService basicGoodsCodeService;
	
	@Autowired
	SystemIndustryService systemIndustryService;
	
	@Autowired
	MonitoringDeviceService monitoringDeviceService;
	
	@Autowired
	BasicWorkgroupService basicWorkgroupService;
	 
	private static final Logger logger = LoggerFactory.getLogger(GoodsManage.class.getName());

	
/*
 * 仓库
 */
	@RequestMapping("/warehouseManage")
	public String Warehouse(ServletRequest request,ServletResponse response){
		
	
		return "goodsManage/warehouseManage";
		
	}
	
	
	@RequestMapping("/warehouseManage/query")
	@ResponseBody
	public  Map<String,Object> queryWareHouse(BasicWarehouseVo vo){
		
		Map<String,Object> map = new HashMap<>();
		
		try {
			BasicWarehouse bean = new BasicWarehouse();
			 
			BeanUtils.copyProperties(vo, bean);
			bean.setMemberCode("0000");
			
			 
	List<BasicWarehouse> list = basicWarehouseService.queryList(bean);
		  
			
			map.put("data", list);
		
			map.put("msg", "ok");
		} catch (Exception e) {
			map.put("msg", "error");
			e.printStackTrace();
		}
		
	
		return map;
	}
	
	
	
	@RequestMapping("/warehouseManage/query/page")
	@ResponseBody
	public  Map<String,Object> queryWareHousePage(  BasicWarehouseVo vo,Integer current_page,Integer page_size){
		
		
		
		
		
		Map<String,Object> map = new HashMap<>();
		
		try {
		
			
			BasicWarehouse bean = new BasicWarehouse();
			 
			BeanUtils.copyProperties(vo, bean);
			bean.setMemberCode("0000");
			
			 
		PageInfo page = basicWarehouseService.getPage(current_page, page_size, bean);
		  
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
	
	@RequestMapping("/warehouseManage/add")
	@ResponseBody
	public  Map<String,Object> addWareHouse( @Validated({SaveGroup.class}) BasicWarehouseVo vo,BindingResult bindingResult){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			//验证表单
			validatedForm(bindingResult);
			
			BasicWarehouse bean = new BasicWarehouse();
			
			BeanUtils.copyProperties(vo, bean);
			bean.setMemberCode("0000");
			basicWarehouseService.saveWarehouse(bean);
			map.put("msg", "ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}
	
	
	
	
	@RequestMapping("/warehouseManage/update")
	@ResponseBody
	public  Map<String,Object> updateWareHouse(@Validated({UpdateGroup.class})  BasicWarehouseVo vo,BindingResult bindingResult){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			//验证表单
			validatedForm(bindingResult);
			
			BasicWarehouse bean = new BasicWarehouse();
		logger.debug(vo.toString());	
			BeanUtils.copyProperties(vo, bean);
			bean.setMemberCode("0000");
			basicWarehouseService.updateWarehouse(bean);
			map.put("msg", "ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}

	
	@RequestMapping("/warehouseManage/delete")
	@ResponseBody
	public  Map<String,Object> deleteWareHouse(String warehouse_code){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			if(warehouse_code ==null || ("".equals(warehouse_code))){
				
				throw new Exception("仓库代码空！");
			}
			
			
			
			BasicWarehouse bean = new BasicWarehouse();
			
			
			bean.setMemberCode("0000");
			bean.setWarehouseCode(warehouse_code);
			basicWarehouseService.deleteWarehouseByCode(bean);
			map.put("msg", "ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}

	
	/*
	 * 库区
	 */
	
	@RequestMapping("/wareAreaManage")
	public  String wareArea(){
		
		
		return "goodsManage/wareAreaManage";
	
	}
	
	
	
	
	
	
	@RequestMapping("/wareAreaManage/query")
	@ResponseBody
	public  Map<String,Object> queryWareArea(@Validated({QueryGroup.class}) BasicWareAreaVo vo,BindingResult bindingResult){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			
			//验证
			validatedForm(bindingResult);
			
			BasicWareArea bean = new BasicWareArea();
			BeanUtils.copyProperties(vo, bean);
			bean.setMemberCode("0000");
			List<BasicWareArea> list = basicWareAreaService.queryList(bean);
			map.put("data", list);
			
			map.put("msg", "ok");	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}
	
	/*@RequestMapping("/wareAreaManage/query/page")
	@ResponseBody
	public  Map<String,Object> pageWareArea(@Validated({QueryGroup.class}) BasicWareAreaVo vo ,BindingResult bindingResult,Integer current_page,Integer page_size){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			
			//验证
			validatedForm(bindingResult);
			
			BasicWareArea bean = new BasicWareArea();
			BeanUtils.copyProperties(vo, bean);
			bean.setMemberCode("0000");
			 PageInfo page = basicWareAreaService.getPage(current_page, page_size, bean);
			
			
			map.put("max_page",  page.getPages());
			map.put("data", page.getList());
			map.put("page", page);
			map.put("msg", "ok");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}*/	
	
	
	@RequestMapping("/wareAreaManage/query/page")
	@ResponseBody
	public  Map<String,Object> pageWareArea(@Validated({QueryGroup.class}) BasicWareAreaVo vo ,BindingResult bindingResult,Integer current_page,Integer page_size){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			
			//验证
			validatedForm(bindingResult);
			
			BasicWareArea bean = new BasicWareArea();
			BeanUtils.copyProperties(vo, bean);
			bean.setMemberCode("0000");
			// PageInfo page = basicWareAreaService.getPage(current_page, page_size, bean);
			 PageInfo page = basicWareAreaService.getPageWithWarehouse(current_page, page_size, bean);
			
			
			map.put("max_page",  page.getPages());
			map.put("data", page.getList());
			map.put("page", page);
			map.put("msg", "ok");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}
	
	@RequestMapping("/wareAreaManage/add")
	@ResponseBody
	public  Map<String,Object> addWareArea(@Validated({SaveGroup.class}) BasicWareAreaVo vo,BindingResult bindingResult){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			
			//验证
			validatedForm(bindingResult);
			
			logger.debug(vo.toString());
			BasicWareArea bean = new BasicWareArea();
			BeanUtils.copyProperties(vo, bean);
			bean.setMemberCode("0000");
			basicWareAreaService.saveWareArea(bean);
			
			map.put("msg", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}
	
	@RequestMapping("/wareAreaManage/update")
	@ResponseBody
	public  Map<String,Object> updateWareArea(@Validated({UpdateGroup.class}) BasicWareAreaVo vo,BindingResult bindingResult){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			
			//验证
			validatedForm(bindingResult);
			
			logger.debug(vo.toString());
			BasicWareArea bean = new BasicWareArea();
			BeanUtils.copyProperties(vo, bean);
			bean.setMemberCode("0000");
			basicWareAreaService.updateWareAreaByCode(bean);
			
			map.put("msg", "ok");	
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}	
	
	
	@RequestMapping("/wareAreaManage/delete")
	@ResponseBody
	public  Map<String,Object> deleteWareArea(String wareareaCode){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			
			//验证
			if(wareareaCode ==null || "".equals(wareareaCode)){
				
				throw new Exception("仓库代码空！");
			}
			
			
			BasicWareArea bean = new BasicWareArea();
		
			bean.setMemberCode("0000");
			bean.setWareareaCode(wareareaCode);
			basicWareAreaService.deleteWareArea(bean);
			
			map.put("msg", "ok");	
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}
	
	
	
	
	/**
	 * 库位
	 */
	
	
	@RequestMapping("/warePlaceManage")
	public  String wareplace(){
		
		
		return "goodsManage/wareplaceManage";
	
	}

	
	
	@RequestMapping("/warePlaceManage/query")
	@ResponseBody
	public  Map<String,Object> queryWarePlace(@Validated({QueryGroup.class}) BasicWarePlaceVo vo,BindingResult bindingResult){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			
			//验证
			validatedForm(bindingResult);
			
			BasicWarePlace bean = new BasicWarePlace();
			BeanUtils.copyProperties(vo, bean);
			bean.setMemberCode("0000");
			
			List<BasicWarePlace> list = basicWarePlaceService.queryList(bean);
			map.put("data", list);
			map.put("msg", "ok");
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}
	
	/*@RequestMapping("/warePlaceManage/query/page")
	@ResponseBody
	public  Map<String,Object> queryWarePlacePage(@Validated({QueryGroup.class})  BasicWarePlaceVo vo,BindingResult bindingResult,Integer current_page,Integer page_size){
		
		Map<String,Object> map = new HashMap<>();
		
		try {
			
			//验证
			validatedForm(bindingResult);
			
			BasicWarePlace bean = new BasicWarePlace();
			BeanUtils.copyProperties(vo, bean);
			bean.setMemberCode("0000");
			
			PageInfo page = basicWarePlaceService.getPage(current_page, page_size, bean);
		
		  
			map.put("max_page",  page.getPages());
			map.put("data", page.getList());
			map.put("page", page);
			map.put("msg", "ok");
		} catch (Exception e) {
			map.put("msg", e.getMessage());
			e.printStackTrace();
		}
		
	
		return map;
	}*/
	
	
	@RequestMapping("/warePlaceManage/query/page")
	@ResponseBody
	public  Map<String,Object> queryWarePlacePage(@Validated({QueryGroup.class})  BasicWarePlaceVo vo,BindingResult bindingResult,Integer current_page,Integer page_size){
		
		Map<String,Object> map = new HashMap<>();
		
		try {
			
			//验证
			validatedForm(bindingResult);
			
			BasicWarePlace bean = new BasicWarePlace();
			BeanUtils.copyProperties(vo, bean);
			bean.setMemberCode("0000");
			
			
			PageInfo page = basicWarePlaceService.getPageWithWarehouse(current_page, page_size, bean);
		
		  
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
	
	
	
	
	
	@RequestMapping("/warePlaceManage/add")
	@ResponseBody
	public  Map<String,Object> saveWarePlace(@Validated({SaveGroup.class}) BasicWarePlaceVo vo,BindingResult bindingResult){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			
			//验证
			validatedForm(bindingResult);
			
			
			BasicWarePlace bean = new BasicWarePlace();
			
			BeanUtils.copyProperties(vo, bean);
			bean.setMemberCode("0000");

			basicWarePlaceService.saveWarePlace(bean);
			map.put("msg", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}
	
	
	
	
	@RequestMapping("/warePlaceManage/update")
	@ResponseBody
	public  Map<String,Object> updateWarePlace(@Validated({UpdateGroup.class}) BasicWarePlaceVo vo,BindingResult bindingResult){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			
			//验证
			validatedForm(bindingResult);
			logger.debug(vo.toString());
			BasicWarePlace bean = new BasicWarePlace();
			
			BeanUtils.copyProperties(vo, bean);
			bean.setMemberCode("0000");

			basicWarePlaceService.updateWarePlaceByCode(bean);
			map.put("msg", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}
	
	
	
	@RequestMapping("/warePlaceManage/delete")
	@ResponseBody
	public  Map<String,Object> deleteWarePlace(String wareplaceCode){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			
			//验证
			if(wareplaceCode ==null || "".equals(wareplaceCode)){
				throw new Exception("库位代码空！");
			}
		
			BasicWarePlace bean = new BasicWarePlace();
			
			bean.setMemberCode("0000");
			bean.setWareplaceCode(wareplaceCode);

			basicWarePlaceService.deleteWarePlace(bean);
			map.put("msg", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}
	
	
	
	/**
	 * 品名设置
	 */
	
	@RequestMapping("/partsname")
	public  String partsname(){
		
		
		return "goodsManage/partsName";
	
	}	
	
	
	//品名大类树
	@RequestMapping("/pntree/query")
	@ResponseBody
	public  Map<String,Object> queryPntree(){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			
			BasicPnTree bean = new BasicPnTree();
			bean.setMemberCode("0000");
			bean.setPntreeParentcode("-1");
			List<Map<String,Object>> list = new ArrayList<>();
			
			
			List<BasicPnTree> root_tree = basicPnTreeService.queryList(bean);
			for(BasicPnTree t:root_tree){
				bean.setPntreeParentcode(t.getPntreeNodecode());
				List<BasicPnTree> queryList = basicPnTreeService.queryList(bean);
				Map<String,Object> dd = new HashMap<>();
				dd.put("root", t);
				dd.put("second", queryList);
				list.add(dd);
				
			}
			map.put("data", list);
			map.put("msg", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "error");
		}
		
		return map;
	}

	//品名大类树
	@RequestMapping("/pntree/save")
	@ResponseBody
	public  Map<String,Object> savePntree(@Validated({SaveGroup.class}) BasicPnTreeVo vo,BindingResult bindingResult){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			//验证
			validatedForm(bindingResult);
			
			BasicPnTree bean = new BasicPnTree();
		
			BeanUtils.copyProperties(vo, bean);
		
			bean.setMemberCode("0000");
			//父节点必须
			basicPnTreeService.saveTree(bean);
		
			map.put("msg", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}
	
	
	
	//品名大类树
		@RequestMapping("/pntree/update")
		@ResponseBody
		public  Map<String,Object> updatePntree(@Validated({UpdateGroup.class}) BasicPnTreeVo vo,BindingResult bindingResult){
			Map<String,Object> map = new HashMap<>();
			
			
			try {
			    //验证	

				validatedForm(bindingResult);

				BasicPnTree bean = new BasicPnTree();
			
				BeanUtils.copyProperties(vo, bean);
			
				bean.setMemberCode("0000");
				//code 必须
				basicPnTreeService.updateTree(bean);
			
				map.put("msg", "ok");
			} catch (Exception e) {
				e.printStackTrace();
				map.put("msg", e.getMessage());
			}
			
			return map;
		}
	
		//品名大类树
				@RequestMapping("/pntree/delete")
				@ResponseBody
				public  Map<String,Object> deletePntree(@Validated({DeleteGroup.class}) BasicPnTreeVo vo,BindingResult bindingResult){

					Map<String,Object> map = new HashMap<>();
					
					
					try {
						
						//验证
						validatedForm(bindingResult);
                        BasicPnTree bean = new BasicPnTree();
						BeanUtils.copyProperties(vo, bean);
					
						bean.setMemberCode("0000");
						//如果含有子几点不能删除
						BasicPnTree bean1 = new BasicPnTree();
						bean1.setPntreeParentcode(bean.getPntreeCode());
						bean1.setMemberCode("0000");
						List<BasicPnTree> trees = basicPnTreeService.queryList(bean1);
						//
						if(trees !=null && trees.size()>0 ){
							
							throw new Exception("含有子节点不能删除！");
						}
						
						
						//code 必须
						basicPnTreeService.deleteTree(bean);
					
						map.put("msg", "ok");
					} catch (Exception e) {
						e.printStackTrace();
						map.put("msg", e.getMessage());
					}
					
					return map;
				}
		
		
		
	
	//品名
	@RequestMapping("/partsname/query")
	@ResponseBody
	public  Map<String,Object> querypartsname(String pntreeNodecode){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			if(pntreeNodecode ==null || "".equals(pntreeNodecode)){
				throw new Exception("品名查询的树节点代码不存在！");
			}
			
			//pntreeNodecode	
			BasicPartsName bean = new BasicPartsName();
	           		
                 bean.setMemberCode("0000");
                 bean.setPntreeNodecode(pntreeNodecode);
			List<BasicPartsName> list = basicPartsNameService.queryList(bean);
			map.put("data", list);
			map.put("msg", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}
	
	
	
	
	
	
	
	
	//品名
	@RequestMapping("/partsname/query/page")
	@ResponseBody
	public  Map<String,Object> querypartsnamePage(String pntreeNodecode,Integer current_page,Integer page_size){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			
			if(pntreeNodecode ==null || "".equals(pntreeNodecode)){
				throw new Exception("品名查询的树节点代码不存在！");
			}
			//pntreeNodecode	
			BasicPartsName bean = new BasicPartsName();
	           		
                 bean.setMemberCode("0000");
                 bean.setPntreeNodecode(pntreeNodecode);
			PageInfo page = basicPartsNameService.getPage(current_page, page_size, bean);
			
			map.put("max_page",  page.getPages());
			map.put("data", page.getList());
			map.put("page", page);
			map.put("msg", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}
	
	
	
	
	//品名
		@RequestMapping("/partsname/add")
		@ResponseBody
		public  Map<String,Object> addpartsname(@Validated({SaveGroup.class}) BasicPartsNameVo vo,BindingResult bindingResult){
			Map<String,Object> map = new HashMap<>();
			
			
			try {
				
				//验证
				validatedForm(bindingResult);

				BasicPartsName bean = new BasicPartsName();
		          BeanUtils.copyProperties(vo, bean);
	               bean.setMemberCode("0000");
	               basicPartsNameService.savePartsName(bean);
	               logger.debug(vo.toString());
				map.put("msg", "ok");
			} catch (Exception e) {
				e.printStackTrace();
				map.put("msg", e.getMessage());
			}
			
			return map;
		}
	
	
	
	
		//品名
		@RequestMapping("/partsname/update")
		@ResponseBody
		public  Map<String,Object> updatepartsname(@Validated({UpdateGroup.class}) BasicPartsNameVo vo,BindingResult bindingResult ){
			Map<String,Object> map = new HashMap<>();
			
			
			try {
				
				validatedForm(bindingResult);
				
				BasicPartsName bean = new BasicPartsName();
		          BeanUtils.copyProperties(vo, bean);
	               bean.setMemberCode("0000");
	               basicPartsNameService.updatePartsName(bean);
	               logger.debug(vo.toString());
				map.put("msg", "ok");
			} catch (Exception e) {
				e.printStackTrace();
				map.put("msg", e.getMessage());
			}
			
			return map;
		}
	
	
		//品名
		@RequestMapping("/partsname/delete")
		@ResponseBody
		public  Map<String,Object> deletepartsname(@Validated({DeleteGroup.class}) BasicPartsNameVo vo,BindingResult bindingResult){
			Map<String,Object> map = new HashMap<>();
			
			
			try {
				
				validatedForm(bindingResult);
				
				BasicPartsName bean = new BasicPartsName();
		          BeanUtils.copyProperties(vo, bean);
	               bean.setMemberCode("0000");
	               basicPartsNameService.deletePartsName(bean);
	               logger.debug(vo.toString());
				map.put("msg", "ok");
			} catch (Exception e) {
				e.printStackTrace();
				map.put("msg", e.getMessage());
			}
			
			return map;
		}
	
	
	
	
	/**
	 * 产地
	 */
	
	@RequestMapping("/productArea")
	public  String productArea(){
		
		
		return "goodsManage/productArea";
	
	}
	
	
	@RequestMapping("/productArea/query/page")
	@ResponseBody
	public  Map<String,Object> queryproductAreapage(BasicProductAreaVo vo,Integer current_page,Integer page_size){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			
			BasicProductArea bean = new BasicProductArea();
			
			BeanUtils.copyProperties(vo, bean);
			bean.setMemberCode("0000");

		 PageInfo page = basicProductAreaService.getPage(current_page, page_size, bean);
			
		 map.put("max_page",  page.getPages());
			map.put("data", page.getList());
			map.put("page", page);
			map.put("msg", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "error");
		}
		
		return map;
	}
	
	
	@RequestMapping("/productArea/query")
	@ResponseBody
	public  Map<String,Object> queryproductArea(BasicProductAreaVo vo){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			
			BasicProductArea bean = new BasicProductArea();
			
			BeanUtils.copyProperties(vo, bean);
			bean.setMemberCode("0000");

			List<BasicProductArea> list = basicProductAreaService.queryList(bean);
			
			map.put("data", list);
		
			map.put("msg", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "error");
		}
		
		return map;
	}	
	
	
	@RequestMapping("/productArea/add")
	@ResponseBody
	public  Map<String,Object> addProductArea(@Validated({SaveGroup.class}) BasicProductAreaVo vo,BindingResult bindingResult){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			//验证
			validatedForm(bindingResult);
			
			BasicProductArea bean = new BasicProductArea();
			
			BeanUtils.copyProperties(vo, bean);
			bean.setMemberCode("0000");

		 basicProductAreaService.saveProductArea(bean);
			
			
		
			map.put("msg", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}
	
	
	

	@RequestMapping("/productArea/update")
	@ResponseBody
	public  Map<String,Object> updateProductArea(@Validated({UpdateGroup.class}) BasicProductAreaVo vo,BindingResult bindingResult){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			
			//验证
			validatedForm(bindingResult);
			BasicProductArea bean = new BasicProductArea();
			
			BeanUtils.copyProperties(vo, bean);
			bean.setMemberCode("0000");

		 basicProductAreaService.updateProductArea(bean);
			
			
		
			map.put("msg", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}
	
	
	
	@RequestMapping("/productArea/delete")
	@ResponseBody
	public  Map<String,Object> deleteProductArea(@Validated({DeleteGroup.class}) BasicProductAreaVo vo,BindingResult bindingResult){
		Map<String,Object> map = new HashMap<>();
		
		
		try {
			validatedForm(bindingResult);
			
			BasicProductArea bean = new BasicProductArea();
			
			BeanUtils.copyProperties(vo, bean);
			bean.setMemberCode("0000");

		 basicProductAreaService.deleteProductArea(bean);
			
			
		
			map.put("msg", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}
	
	
/**
 * 物资代码	
 */
	
	
		@RequestMapping("/goodsCode")
		public String goodsCode(ServletRequest request,ServletResponse response){
			
		
			return "goodsManage/goodsCode";
			
		}
		
	
		
	
		@RequestMapping("/goodsCode/query/page")
		@ResponseBody
		public  Map<String,Object> querygoodsCode(@Validated({QueryGroup.class}) BasicGoodsCodeVo vo,BindingResult bindingResult,Integer current_page,Integer page_size){
			
			Map<String,Object> map = new HashMap<>();
			
			try {
				//验证
				validatedForm(bindingResult);
				
				BasicGoodsCode bean = new BasicGoodsCode();
				 
				BeanUtils.copyProperties(vo, bean);
				bean.setMemberCode("0000");
				
				 
			PageInfo page = basicGoodsCodeService.getPage(current_page, page_size, bean);
			  
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
	
		//查询规格
		@RequestMapping("/goodsCode/query/goodsSpec")
		@ResponseBody
		public  Map<String,Object> querygoodsSpec(){
			
			Map<String,Object> map = new HashMap<>();
			try {
				BasicGoodsCode bean = new BasicGoodsCode();
				bean.setMemberCode("0000");
			   List<BasicGoodsCode> list = basicGoodsCodeService.queryGoodsSpec(bean);
				map.put("data", list);
				map.put("msg", "ok");
			} catch (Exception e) {
				map.put("msg", e.getMessage());
				e.printStackTrace();
			}
			return map;
		}
		
		//查询工作组
		@RequestMapping("/workgroup/query")
		@ResponseBody
		public  Map<String,Object> queryworkgroup(){
			
			Map<String,Object> map = new HashMap<>();
			try {
				
			  List<BasicWorkgroup> list = basicWorkgroupService.queryAll();
				map.put("data", list);
				map.put("msg", "ok");
			} catch (Exception e) {
				map.put("msg", e.getMessage());
				e.printStackTrace();
			}
			return map;
		}
		
		
		
		      //查询材质
				@RequestMapping("/goodsCode/query/goodsMaterial")
				@ResponseBody
				public  Map<String,Object> querygoodsMaterial(){
					
					Map<String,Object> map = new HashMap<>();
					try {
						BasicGoodsCode bean = new BasicGoodsCode();
						bean.setMemberCode("0000");
					   List<BasicGoodsCode> list = basicGoodsCodeService.queryGoodsMaterial(bean);
						map.put("data", list);
						map.put("msg", "ok");
					} catch (Exception e) {
						map.put("msg", e.getMessage());
						e.printStackTrace();
					}
					return map;
				}
		

		@RequestMapping("/goodsCode/add")
		@ResponseBody
		public  Map<String,Object> addGoodsCode(@Validated({SaveGroup.class}) BasicGoodsCodeVo vo,BindingResult bindingResult,BasicPartsNameVo vo1){
			
			Map<String,Object> map = new HashMap<>();
			
			try {
				 //验证
				validatedForm(bindingResult);
			   if(vo1.getPartsnameName() ==null || "".equals(vo1.getPartsnameName())){
				   throw new Exception("品名不能空");
			   }
				
				  BasicPartsName b = new BasicPartsName();
				  BeanUtils.copyProperties(vo1, b);
				  b.setMemberCode("0000");
			      BasicPartsName basicPartsName = basicPartsNameService.queryByName(b).get(0);
				
			    
			      BasicGoodsCode bean = new BasicGoodsCode();
			      BeanUtils.copyProperties(vo, bean);
				  bean.setMemberCode("0000");
				  if(bean.getDataAwedit() ==null){
					  bean.setDataAwedit(new BigDecimal(0));
				  }
			      bean.setPartsnameName(basicPartsName.getPartsnameName());
			      bean.setPntreeName(basicPartsName.getPntreeName());
			      bean.setPntreeParentname(basicPartsName.getPntreeParentname());
			      bean.setGoodsNodecode(basicPartsName.getPntreeNodecode()+"."+basicPartsName.getPartsnameName());
			      bean.setIndustryCode(basicPartsName.getIndustryCode());
			      //bean.setGoodsTaxrate(basicPartsName.getGoodsTaxrate());
			     // bean.setGoodsPriceun(basicPartsName.getGoodsPriceun());
			     // bean.setGoodsPiecemode(basicPartsName.getGoodsPiecemode());
			     // bean.setGoodsWeightmode(basicPartsName.getGoodsWeightmode());
			     // bean.setGoodsMetering(basicPartsName.getGoodsMetering());
			      
		          basicGoodsCodeService.saveGoodsCode(bean);
		          User userInfo = SessionUtils.getUserInfo();
		          
		          basicGoodsCodeService.saveGoodsCodeWith(bean,userInfo,"0000");
				map.put("msg", "ok");
			} catch (Exception e) {
				map.put("msg", e.getMessage());
				e.printStackTrace();
			}
			
		
			return map;
		}
		
		
		@RequestMapping("/goodsCode/update")
		@ResponseBody
		public  Map<String,Object> updateGoodsCode(@Validated({UpdateGroup.class})BasicGoodsCodeVo vo,BindingResult bindingResult,BasicPartsNameVo vo1){
			
			Map<String,Object> map = new HashMap<>();
			
			try {
				//验证
				 if(vo1.getPartsnameName() ==null || "".equals(vo1.getPartsnameName())){
					   throw new Exception("品名不能空");
				   }
				 validatedForm(bindingResult);
				
				 BasicPartsName b = new BasicPartsName();
				 
				  BeanUtils.copyProperties(vo1, b);
				  b.setMemberCode("0000");
			      BasicPartsName basicPartsName = basicPartsNameService.queryByName(b).get(0);
				
			    
			      BasicGoodsCode bean = new BasicGoodsCode();
			     
			      BeanUtils.copyProperties(vo, bean);
				  bean.setMemberCode("0000");
				  if(bean.getDataAwedit() ==null){
					  bean.setDataAwedit(new BigDecimal(0));
				  }
			      bean.setPartsnameName(basicPartsName.getPartsnameName());
			      bean.setPntreeName(basicPartsName.getPntreeName());
			      bean.setPntreeParentname(basicPartsName.getPntreeParentname());
			      bean.setGoodsNodecode(basicPartsName.getPntreeNodecode()+"."+basicPartsName.getPartsnameName());
			     // bean.setGoodsTaxrate(basicPartsName.getGoodsTaxrate());
			      bean.setIndustryCode(basicPartsName.getIndustryCode());
			     // bean.setGoodsPriceun(basicPartsName.getGoodsPriceun());
			      //bean.setGoodsPiecemode(basicPartsName.getGoodsPiecemode());
			      //bean.setGoodsWeightmode(basicPartsName.getGoodsWeightmode());
			     // bean.setGoodsMetering(basicPartsName.getGoodsMetering());
			      bean.setDataEditOrg(SessionUtils.getUserInfo().getOrgCode());
				 
		          basicGoodsCodeService.updateGoodsCode(bean);
			  
			
				map.put("msg", "ok");
			} catch (Exception e) {
				map.put("msg", e.getMessage());
				e.printStackTrace();
			}
			
		
			return map;
		}
		
		@RequestMapping("/goodsCode/delete")
		@ResponseBody
		public  Map<String,Object> deleteGoodsCode(@Validated({DeleteGroup.class}) BasicGoodsCodeVo vo,BindingResult bindingResult){
			
			Map<String,Object> map = new HashMap<>();
			
			try {
				//验证
				validatedForm(bindingResult);

				BasicGoodsCode bean = new BasicGoodsCode();
				 
				BeanUtils.copyProperties(vo, bean);
				bean.setMemberCode("0000");
				
				 
		          basicGoodsCodeService.deleteGoodsCode(bean);
			  
			
				map.put("msg", "ok");
			} catch (Exception e) {
				map.put("msg", e.getMessage());
				e.printStackTrace();
			}
			
		
			return map;
		}
		
	
		
		@RequestMapping("/industry/query")
		@ResponseBody
		public  Map<String,Object> queryIndustry(SystemIndustryVo vo){
			
			Map<String,Object> map = new HashMap<>();
			
			try {
				
				SystemIndustry bean = new SystemIndustry();
				
				BeanUtils.copyProperties(vo, bean);
				bean.setMemberCode("0000");
				
				 
				List<SystemIndustry> list = systemIndustryService.queryList(bean);
			  
				
				map.put("data", list);
			
				map.put("msg", "ok");
			} catch (Exception e) {
				map.put("msg", "error");
				e.printStackTrace();
			}
			
		
			return map;
		}
	
		
		

		@RequestMapping("/monitor/query")
		@ResponseBody
		public  Map<String,Object> queryMonitor(MonitoringDeviceVo vo){
			
			Map<String,Object> map = new HashMap<>();
			
			try {
				
				MonitoringDevice bean = new MonitoringDevice();
				
				BeanUtils.copyProperties(vo, bean);
				bean.setMemberCode("0000");
				
				 
			 List<MonitoringDevice> list = monitoringDeviceService.queryList(bean);
			  
				
				map.put("data", list);
			
				map.put("msg", "ok");
			} catch (Exception e) {
				map.put("msg", "error");
				e.printStackTrace();
			}
			
		
			return map;
		}
		
		
		
		
		/**
		 * 
		 * 
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
