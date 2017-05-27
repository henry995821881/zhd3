package com.xyscm.sys.basic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xyscm.sys.basic.model.BasicEmployee;

@Repository
public interface BasicEmployeeMapper {

	public List<BasicEmployee> queryAll();

	public BasicEmployee getByCode(@Param("employeeCode")String employeeCode, @Param("memberCode")String memberCode);

	public BasicEmployee getByName(@Param("memberCode")String memberCode, @Param("employeeName")String employeeName);

	public void insert(BasicEmployee mod);

	public int update(BasicEmployee mod);

	public int delete(@Param("employeeCode")String employeeCode, @Param("memberCode")String memberCode);

	public int getCountByCode(@Param("orgCode")String orgCode, @Param("deptCode")String deptCode, String other1,
			String other2, String other3, @Param("memberCode")String memberCode);

	public List<BasicEmployee> queryPdaEmployee(String worktypeName);

	public List<BasicEmployee> queryByBean(BasicEmployee basicEmployee);

	
	
}