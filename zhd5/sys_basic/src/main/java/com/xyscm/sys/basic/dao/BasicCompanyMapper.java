package com.xyscm.sys.basic.dao;

import com.xyscm.sys.basic.model.BasicCompany;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BasicCompanyMapper {
	
	
	/**
	 * 查询往来单位
	 * @param orgCode 		当前操作者的orgCode必须有
	 * @return
	 */
	public List<BasicCompany> queryCompany(BasicCompany basicCompany);
	
	
	/**
	 * 往来单位详情
	 * @param companyId
	 * @return
	 */
	public BasicCompany getCompanyInfo(BigDecimal companyId);
	
	
	/**
	 * 新增往来单位
	 * @param basicCompany
	 * @return
	 */
	public int insertCompany(BasicCompany basicCompany);
	
	
	/**
	 * 修改往来单位
	 * @param basicCompany
	 * @return
	 */
	public int updateCompany(BasicCompany basicCompany);
    
	
	/**
	 * 删除往来单位
	 * @param companyId
	 * @return
	 */
	public int deleteCompany(BigDecimal companyId);
	
	
	
	/**
	 * 根据AreaCode查询往来单位
	 * @param memberCode
	 * @param areaCode
	 * @return
	 */
	public List<BasicCompany> queryCompanyByAreaCode(@Param("memberCode")String memberCode,@Param("areaCode")String areaCode,@Param("orgCode")String orgCode);
	

}