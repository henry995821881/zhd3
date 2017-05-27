package com.xyscm.sys.basic.cas.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xyscm.sys.basic.cas.model.VPermissionAllot;

/**
 * 
 * 功能描述：
 * 
 * 权限视图查询mapper
 * 
 * @author xielf
 * @CreateDate 2017-5-18 下午3:23:45
 * @Version: 1.0
 */
@Repository
public interface VPermissionAllotMapper {
	
	/**
	 * 查询用户权限
	 * @param memberCode
	 * @param operatorCode
	 * @return
	 *
	 * VPermissionAllot
	 */
	public List<VPermissionAllot> queryPermission(String memberCode,String operatorCode);

}