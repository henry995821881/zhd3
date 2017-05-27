/**
 * 智恒达钢盟网络科技有限公司
 */
package com.xyscm.sys.basic.cas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.xyscm.sys.basic.cas.dao.SystemOperatorMapper;
import com.xyscm.sys.basic.cas.model.SystemOperator;

/**
 * 功能描述：注册用户查询service
 * 
 * @author xielf
 * @CreateDate 2017-5-17 下午1:40:15
 * @Version: 1.0
 */
@Service(value="operatorService")
public class OperatorService {
	
	@Autowired
	SystemOperatorMapper systemOperatorMapper;

	/**
	 * 通过用户账户查询操作员记录
	 * @param operatorUserid 用户账户
	 * @return
	 */
	public SystemOperator getByUserid(String operatorUserid){
		
		if(StringUtils.isNotEmpty(operatorUserid)){
			
			return systemOperatorMapper.selectByUserId(operatorUserid);
		}
		
		return null;
	}

}
