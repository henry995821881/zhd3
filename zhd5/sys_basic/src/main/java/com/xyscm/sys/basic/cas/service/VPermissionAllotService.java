/**
 * 智恒达钢盟网络科技有限公司
 */
package com.xyscm.sys.basic.cas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyscm.sys.basic.cas.dao.VPermissionAllotMapper;
import com.xyscm.sys.basic.cas.model.VPermissionAllot;

/**
 * 功能描述：
 * 
 * @author xielf
 * @CreateDate 2017-5-18 下午3:31:15
 * @Version: 1.0
 */
@Service
public class VPermissionAllotService {
	
	@Autowired
	VPermissionAllotMapper vPermissionAllotMapper;

	/**
	 * 查询用户权限
	 * @param memberCode
	 * @param operatorCode
	 * @return
	 *
	 * VPermissionAllot
	 */
	public List<VPermissionAllot> queryPermission(String memberCode,String operatorCode){
		
		return vPermissionAllotMapper.queryPermission(memberCode, operatorCode);
	}

}
