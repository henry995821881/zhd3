package com.xyscm.sys.basic.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xyscm.sys.basic.model.BasicArea;
import com.xyscm.sys.basic.model.BasicOrg;

@Repository
public interface BasicOrgMapper {
	
	public BasicOrg getOrgByCode(@Param("orgCode")String orgCode, @Param("memberCode")String memberCode);

	public List<BasicOrg> queryAll();

	public BasicOrg getByCode(String orgCode);

	public BasicOrg getByName(@Param("orgName")String orgName, @Param("memberCode")String memberCode);

	public BasicOrg getByAbbreviate(@Param("orgAbbreviate")String orgAbbreviate, @Param("memberCode")String memberCode);

	public int save(BasicOrg mod);

	public int getMaxOrgCode();

	public int update(BasicOrg mod);

	public int delete(@Param("orgCode")String orgCode, @Param("memberCode")String memberCode);

	public int getCountByParentCode(@Param("orgParent")String orgParent, @Param("orgIsleaf")Long orgIsleaf,
			@Param("memberCode")String memberCode);

	public List<BasicOrg> queryByParent(@Param("orgParent")String orgParent, @Param("orgIsleaf")Long orgIsleaf,
			@Param("memberCode")String memberCode);

	public BasicOrg getRootNode();

	public List<BasicOrg> queryBasicOrg(String memberCode);

	public List<BasicOrg> query2BasicOrg(@Param("memberCode")String memberCode, @Param("orgParent")String orgParent);

	public BasicOrg getOrgDetail(@Param("orgId")BigDecimal orgId);

	public List<BasicOrg> queryOrgCombo(@Param("memberCode")String memberCode, @Param("orgIsleaf")Long orgIsleaf);
	
	
/*	public List<BasicOrg> query(OrgBeanVo bean);*/
	
	
	
}