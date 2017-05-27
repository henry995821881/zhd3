/**
 * 智恒达钢盟网络科技有限公司
 */
package com.xyscm.sys.basic.common.util;

import com.xyscm.sys.basic.cas.component.RedisUtils;
import com.xyscm.sys.basic.common.constant.RedisKeyConstants;
import com.xyscm.sys.basic.model.BasicDept;
import com.xyscm.sys.basic.model.BasicEmployee;
import com.xyscm.sys.basic.model.BasicOrg;

/**
 * 功能描述：
 * 
 * @author xielf
 * @CreateDate 2017-5-18 下午7:17:35
 * @Version: 1.0
 */
public class BasicCacheUtil {

	/**
	 * 从缓存中查询部门信息
	 * @param memberCode
	 * @param deptCode
	 * @return
	 *
	 * BasicDept
	 */
	public static BasicDept getDept(String memberCode,String deptCode){
		
		if(RedisUtils.exists(RedisKeyConstants.PREFIX_BASIC_DEPT)){
			return (BasicDept)RedisUtils.getMap(RedisKeyConstants.PREFIX_BASIC_DEPT).get(memberCode+"-"+deptCode);
		}
		return null;
		
	}
	
	/**
	 * 从缓存中查询机构信息
	 * @param memberCode
	 * @param orgCode
	 * @return
	 *
	 * BasicOrg
	 */
	public static BasicOrg getOrg(String memberCode,String orgCode){
		if(RedisUtils.exists(RedisKeyConstants.PREFIX_BASIC_ORG)){
			return (BasicOrg)RedisUtils.getMap(RedisKeyConstants.PREFIX_BASIC_ORG).get(memberCode+"-"+orgCode);
		}
		return null;
	}
	
	/**
	 * 从缓存中查询员工信息
	 * @param memberCode
	 * @param employeeCode
	 * @return
	 *
	 * BasicEmployee
	 */
	public static BasicEmployee getEmployee(String memberCode,String employeeCode){
		if(RedisUtils.exists(RedisKeyConstants.PREFIX_BASIC_EMPLOYEE)){
			return (BasicEmployee)RedisUtils.getMap(RedisKeyConstants.PREFIX_BASIC_EMPLOYEE).get(memberCode+"-"+employeeCode);
		}
		return null;
	}
	
}
