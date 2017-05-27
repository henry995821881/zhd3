/**
 * 智恒达钢盟网络科技有限公司
 */
package com.xyscm.sys.basic.cas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyscm.sys.basic.cas.dao.VButpermissionAllotMapper;
import com.xyscm.sys.basic.cas.model.VButpermissionAllot;

/**
 * 功能描述：
 * 
 * @author xielf
 * @CreateDate 2017-5-18 下午3:31:34
 * @Version: 1.0
 */
@Service
public class VButpermissionAllotService {
	
	@Autowired
	VButpermissionAllotMapper vButpermissionAllotMapper;

	/**
	 * 查询用户权限
	 * @param memberCode
	 * @param operatorCode
	 * @return
	 *
	 * VPermissionAllot
	 */
	public List<VButpermissionAllot> queryButPermission(String memberCode,String operatorCode){
		return vButpermissionAllotMapper.queryButPermission(memberCode, operatorCode);
	}

}
