/**
 * 智恒达钢盟网络科技有限公司
 */
package com.xyscm.sys.basic.cas.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import com.xyscm.sys.basic.cas.component.RedisUtils;
import com.xyscm.sys.basic.common.constant.RedisKeyConstants;
import com.xyscm.sys.basic.model.BasicDept;
import com.xyscm.sys.basic.model.BasicEmployee;
import com.xyscm.sys.basic.model.BasicOrg;
import com.xyscm.sys.basic.service.BasicDeptService;
import com.xyscm.sys.basic.service.BasicEmployeeService;
import com.xyscm.sys.basic.service.BasicOrgService;

/**
 * 功能描述：，将部门信息、机构信息、员工信息初始化到缓存
 * 
 * @author xielf
 * @CreateDate 2017-5-18 下午6:15:09
 * @Version: 1.0
 */
@Service
public class CacheBeanPostProcessor implements BeanPostProcessor {

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization(java.lang.Object, java.lang.String)
	 */
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {

		// 机构数据初始化完成
		if(arg0 instanceof BasicOrgService) {
			
			if(!RedisUtils.exists(RedisKeyConstants.PREFIX_BASIC_ORG)){
				List<BasicOrg> list = ((BasicOrgService)arg0).queryAll();
				Map<String,BasicOrg> map = getBasicOrgMap(list);
				if(map!=null){
					RedisUtils.setMap(RedisKeyConstants.PREFIX_BASIC_ORG, map);
				}
			}
		} 
		// 部门数据初始化完成
		else if(arg0 instanceof BasicDeptService){
			
			if(!RedisUtils.exists(RedisKeyConstants.PREFIX_BASIC_DEPT)){
				List<BasicDept> list = ((BasicDeptService)arg0).queryAll();
				Map<String,BasicDept> map = getBasicDeptMap(list);
				if(map!=null){
					RedisUtils.setMap(RedisKeyConstants.PREFIX_BASIC_DEPT, map);
				}
			}
			
		} 
		// 员工数据初始化完成
		else if(arg0 instanceof BasicEmployeeService){
			if(!RedisUtils.exists(RedisKeyConstants.PREFIX_BASIC_EMPLOYEE)){
				List<BasicEmployee> list = ((BasicEmployeeService)arg0).queryAll();
				Map<String,BasicEmployee> map = getBasicEmployeeMap(list);
				if(map!=null){
					RedisUtils.setMap(RedisKeyConstants.PREFIX_BASIC_EMPLOYEE, map);
				}
			}
		}
		
		return arg0;
	}

	/**
	 * bean初始化完成前处理
	 */
	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {

		return arg0;
	}
	
	/**
	 * 获取机构信息
	 * @param list
	 * @return
	 *
	 * Map<String,BasicOrg>
	 */
	private Map<String,BasicOrg> getBasicOrgMap(List<BasicOrg> list){
		
		Map<String,BasicOrg> map = null;
		
		if(list!=null && list.size()>0){
			
			map = new HashMap<String,BasicOrg>();
			for(BasicOrg org:list){
				map.put(org.getMemberCode()+"-"+org.getOrgCode(), org);
			}
			
		}
		return map;
		
	}
	
	/**
	 * 获取部门信息
	 * @param list
	 * @return
	 *
	 * Map<String,BasicOrg>
	 */
	private Map<String,BasicDept> getBasicDeptMap(List<BasicDept> list){
		
		Map<String,BasicDept> map = null;
		
		if(list!=null && list.size()>0){
			
			map = new HashMap<String,BasicDept>();
			for(BasicDept dept:list){
				map.put(dept.getMemberCode()+"-"+dept.getDeptCode(), dept);
			}
			
		}
		return map;
		
	}
	
	/**
	 * 获取员工信息
	 * @param list
	 * @return
	 *
	 * Map<String,BasicOrg>
	 */
	private Map<String,BasicEmployee> getBasicEmployeeMap(List<BasicEmployee> list){
		
		Map<String,BasicEmployee> map = null;
		
		if(list!=null && list.size()>0){
			
			map = new HashMap<String,BasicEmployee>();
			for(BasicEmployee employee:list){
				map.put(employee.getMemberCode()+"-"+employee.getEmployeeCode(), employee);
			}
			
		}
		return map;
		
	}

}
