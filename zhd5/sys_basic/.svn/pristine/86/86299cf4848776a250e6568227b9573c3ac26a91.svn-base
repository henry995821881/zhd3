package com.xyscm.sys.basic.dao;

import com.xyscm.sys.basic.model.BasicCompanyAccounts;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicCompanyAccountsMapper {

    
    /**
     * 根据compangcode查询公司账号
     * @param companyCode
     * @return
     *
     * List<BasicCompanyAccounts>
     */
    public List<BasicCompanyAccounts> queryCompanyAccounts(@Param("companyCode")String companyCode);
    
    
	/**
	 * 新增公司账号
	 * @param companyCode
     * @return
     *
     * basicCompanyAccounts
	 */
	public int insertCompanyAccount(BasicCompanyAccounts basicCompanyAccounts);
	
	
	/**
	 * 根据id删除公司账号
	 * @param basicCompanyAccounts
	 * @return
	 *
	 * int
	 */
	public int deltCompanyAccountByCode(@Param("companyCode")String companyCode);
	
	
	/**
	 * 根据companyCode更新公司账号
	 * @param basicCompanyAccounts
	 * @return
	 *
	 * int
	 */
	public int updateAccountByCompanyCode(@Param("newCompanyCode")String newCompanyCode,@Param("oldCompanyCode")String oldCompanyCode);
}