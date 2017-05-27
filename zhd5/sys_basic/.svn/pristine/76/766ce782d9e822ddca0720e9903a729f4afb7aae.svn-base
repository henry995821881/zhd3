/**
 * 智恒达钢盟网络科技有限公司
 */
package com.xyscm.sys.basic.cas.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.xyscm.sys.basic.cas.User;
import com.xyscm.sys.basic.cas.component.RedisUtils;
import com.xyscm.sys.basic.cas.model.SystemOperator;
import com.xyscm.sys.basic.cas.model.VButpermissionAllot;
import com.xyscm.sys.basic.cas.model.VPermissionAllot;
import com.xyscm.sys.basic.common.util.BasicCacheUtil;

/**
 * 功能描述：
 * 
 * 查询用户的详细信息、权限信息
 * 
 * @author xielf
 * @CreateDate 2017-5-18 下午2:57:22
 * @Version: 1.0
 */
@Service
public class UserInfoService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserInfoService.class.getName());
	
	@Autowired
	OperatorService operatorService;
	
	@Autowired
	VButpermissionAllotService vButpermissionAllotService;
	
	@Autowired
	VPermissionAllotService vPermissionAllotService;
	
	/**
	 * 通过用户账户查询操作员记录
	 * @param operatorUserid 用户账户
	 * @return
	 */
	public SystemOperator getOperatorByUserid(String userid){
		
		return operatorService.getByUserid(userid);
	}
	
	/**
	 * 查询登录用户基本信息、权限信息
	 * @param userid
	 * @return
	 *
	 * User
	 */
	public User getUserInfo(String userid){
		
		// 查询用户信息
		
		SystemOperator systemOperator = getOperatorByUserid(userid);
		
		if(systemOperator==null){
			logger.error("Operator not found in db. Operator user id="+userid);
			return null;
		} 
		
		User user = new User();
		BeanUtils.copyProperties(systemOperator, user); // 对象复制
		user.setUserId(systemOperator.getOperatorUserid());
		user.setPassword(systemOperator.getOperatorPassword());
		
		// 账户启用状态，才进行后续的权限查询设置
		if(user.getOperatorState().intValue()==0){
			
			String memberCode=systemOperator.getMemberCode();
			String orgCode = systemOperator.getOrgCode();
			String deptCode = systemOperator.getDeptCode();
			String employeeCode = systemOperator.getEmployeeCode();
			if(StringUtils.isNotEmpty(orgCode)){
				user.setOrgName(BasicCacheUtil.getOrg(memberCode, orgCode).getOrgName());
				user.setOrgAbbreviate(BasicCacheUtil.getOrg(memberCode, orgCode).getOrgAbbreviate());
			}
			if(StringUtils.isNotEmpty(deptCode)){
				user.setDeptName(BasicCacheUtil.getDept(memberCode, deptCode).getDeptName());
			}
			if(StringUtils.isNotEmpty(employeeCode)){
				user.setEmployeeName(BasicCacheUtil.getEmployee(memberCode, employeeCode).getEmployeeName());
			}
			
			Map<String, Boolean> mapPermission = queryPermission(
					systemOperator.getMemberCode(),systemOperator.getOperatorCode());
			
			Map<String, Boolean> buttonPermission = queryButtonPermission(
					systemOperator.getMemberCode(),systemOperator.getOperatorCode());
			
			user.setPermissionMap(mapPermission);
			user.setButtonPermissionMap(buttonPermission);
		}
		
		return user;
		
	}
	
	/**
	 * 查询用户权限
	 * @param memberCode
	 * @param operatorCode
	 * @return
	 *
	 * Map<String,Boolean>
	 */
	public Map<String, Boolean> queryPermission(String memberCode, String operatorCode) {
		List<VPermissionAllot> list = vPermissionAllotService.queryPermission(memberCode,operatorCode);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if(null != list && !list.isEmpty()){
			for (VPermissionAllot mod : list) {
				map.put(mod.getMemberCode()+"-"+mod.getPermissionCode(), checkPermission(
						mod.getOpPermissionAllot().longValue(), mod.getRoPermissionAllot().longValue()));
			}
		}
		return map;
	}
	
	/**
	 * 查询用户菜单权限
	 * @param memberCode
	 * @param operatorCode
	 * @return
	 *
	 * Map<String,Boolean>
	 */
	public Map<String, Boolean> queryButtonPermission(String memberCode, String operatorCode) {
		List<VButpermissionAllot> list = vButpermissionAllotService.queryButPermission(memberCode, operatorCode);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if(null != list && !list.isEmpty()){
			for (VButpermissionAllot mod : list) {
				map.put(mod.getMemberCode()+"-"+mod.getButtonCode(), checkPermission(
						mod.getOpPermissionAllot().longValue(), mod.getRoPermissionAllot().longValue()));
			}
		}
		return map;
	}
	
	
	/**
	 * @param opPermissionAllot 0默认 1启用 2停用
	 * @param roPermissionAllot 0默认 1启用
	 * @return
	 */
	public boolean checkPermission(Long opPermissionAllot, Long roPermissionAllot) {
		boolean state = false;
		if (Long.valueOf(1).equals(opPermissionAllot)
				|| (Long.valueOf(0).equals(opPermissionAllot) && Long.valueOf(1).equals(roPermissionAllot))) {
			state = true;
		}
		return state;
	}
	

}
