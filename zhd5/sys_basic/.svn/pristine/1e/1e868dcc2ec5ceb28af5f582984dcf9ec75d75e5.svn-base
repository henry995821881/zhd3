package com.xyscm.sys.basic.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyscm.sys.basic.common.constant.ErrorCode;
import com.xyscm.sys.basic.common.exception.BaseException;
import com.xyscm.sys.basic.dao.BasicCompanyAccountsMapper;
import com.xyscm.sys.basic.model.BasicCompanyAccounts;


@Service
public class BasicCompanyAccountsService {

	@Autowired
	BasicCompanyAccountsMapper basicCompanyAccountsMapper;
	
	  /**
     * 根据compangcode查询公司账号
     * @param companyCode
     * @return
     *
     * List<BasicCompanyAccounts>
     */
    public List<BasicCompanyAccounts> queryCompanyAccounts(String companyCode){
		List<BasicCompanyAccounts> list  = basicCompanyAccountsMapper.queryCompanyAccounts(companyCode);
		return list;
	}
    
    
   	/**
   	 * 新增公司账号
   	 * @param companyCode
        * @return
        *
        * basicCompanyAccounts
   	 */
   	public void insertCompanyAccount(String[] accounts,String companyCode){
   		try{
	   		for (int i = 0; i < accounts.length; i++) {
	   			String[] arr = accounts[i].split(":");
	   			BasicCompanyAccounts basicCompanyAccounts = new BasicCompanyAccounts();
	   			basicCompanyAccounts.setCompanyAccountsCode(arr[0]);
	   			basicCompanyAccounts.setCompanyAccountsName(arr[1]);
	   			basicCompanyAccounts.setCompanyAccountsRemark(arr[2]);
	   			basicCompanyAccounts.setCompanyCode(companyCode);
	   			basicCompanyAccounts.setMemberCode("0000");
	   			int num = basicCompanyAccountsMapper.insertCompanyAccount(basicCompanyAccounts);
	   		}
   		}catch(Exception e){
   			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_COMPANY_ADD_ACCOUNT.getErrCode());
   		}
    }
    

	/**
	 * 根据id删除公司账号
	 * @param basicCompanyAccounts
	 * @return
	 *
	 * int
	 */
	public void deltCompanyAccount(String companyCode){
		try{
			basicCompanyAccountsMapper.deltCompanyAccountByCode(companyCode);
		}catch(Exception e){
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_COMPANY_DELETE_ACCOUNT.getErrCode());
		}
	}
	
	
	/**
	 * 修改
	 * @param accounts
	 * @param companyCode
	 * @return
	 *
	 * int
	 */
	public void updateCompanyAccount(String[] accounts,String companyCode){
		try{
			deltCompanyAccount(companyCode);	//先删除再添加
			insertCompanyAccount(accounts,companyCode);
		}catch(Exception e){
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_COMPANY_UPDATE_ACCOUNT.getErrCode());
		}
	}

	/**
	 * 根据companyCode更新公司账号
	 * @param basicCompanyAccounts
	 * @return
	 *
	 * int
	 */
	public void updateAccountByCompanyCode(String newCompanyCode,String oldCompanyCode){
		try{
			basicCompanyAccountsMapper.updateAccountByCompanyCode(newCompanyCode, oldCompanyCode);
		}catch(Exception e){
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_COMPANY_UPDATE_COMBINE_ACCOUNT.getErrCode());
		}
	}
	
}
