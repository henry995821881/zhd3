package com.xyscm.sys.basic.dao;

import com.xyscm.sys.basic.model.BasicCompanyProject;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicCompanyProjectMapper {
   

	/**
	 * 根据compangcode查询公司项目
	 * @param companyCode
	 * @return
	 *
	 * List<BasicCompanyProject>
	 */
	public List<BasicCompanyProject> queryCompanyProject(@Param("companyCode")String companyCode);
	
	  
	/**
	 * 新增公司项目
	 * @param companyCode
     * @return
     *
     * BasicCompanyProject
	 */
	public int insertCompanyProject(BasicCompanyProject basicCompanyProject);
	
	
	/**
	 * 根据id删除公司项目
	 * @param basicCompanyAccounts
	 * @return
	 *
	 * int
	 */
	public int deltCompanyProjectByCode(@Param("companyCode")String companyCode);
	
	
	/**
	 * 根据companyCode更新公司项目
	 * @param basicCompanyAccounts
	 * @return
	 *
	 * int
	 */
	public int updateProjectByCompanyCode(@Param("newCompanyCode")String newCompanyCode,@Param("oldCompanyCode")String oldCompanyCode);
	
}