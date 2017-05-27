package com.xyscm.sys.basic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xyscm.sys.basic.model.BasicDept;
import com.xyscm.sys.basic.model.BasicOrg;

@Repository
public interface BasicDeptMapper {
	
	public List<BasicDept> queryByParent(@Param("deptParent")String deptParent,
			@Param("deptIsleaf")Long deptIsleaf, @Param("memberCode")String memberCode);

	public BasicDept getByCode(String deptParent);

	public int updateDeptParentCode(@Param("deptCode")String deptCode, @Param("deptNodecode")String newDeptNodecode,
			@Param("deptParent")String deptParent, @Param("memberCode")String memberCode);

	public int updateDeptNodecode(@Param("deptNodeCode")String oldDeptNodecode, @Param("newDeptNodecode")String newDeptNodecode,
			@Param("memberCode")String memberCode);

	public int getCountByParentCode(@Param("deptParent")String deptParent, @Param("deptIsleaf")Long deptIsleaf,
			@Param("memberCode")String memberCode);

	public int delete(@Param("deptCode")String deptCode, @Param("memberCode")String memberCode);

	public int deleteDeptByParent(@Param("deptParent")String deptParent, @Param("deptIsleaf")Long deptIsleaf, @Param("memberCode")String memberCode);

	public BasicDept getByName(@Param("deptName")String deptName, @Param("memberCode")String memberCode);

	public int save(BasicDept mod);

	public int update(BasicDept mod);

	List<BasicDept> queryAll();

	public BasicDept getDeptByCode(@Param("deptCode")String deptCode, @Param("memberCode")String memberCode);

	public List<BasicDept> queryBasicDept(String memberCode);

	public List<BasicDept> query2BasicDept(@Param("memberCode")String memberCode, @Param("deptParent")String deptParent);

	public List<BasicDept> queryDeptCombo(@Param("memberCode")String memberCode, @Param("deptIsleaf")Long deptIsleaf);

}