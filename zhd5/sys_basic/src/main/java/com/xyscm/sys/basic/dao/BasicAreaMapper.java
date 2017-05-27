package com.xyscm.sys.basic.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xyscm.sys.basic.model.BasicArea;

@Repository
public interface BasicAreaMapper {
	
	
	/**
	 * 所有地区
	 * @param member_Code
	 * @return
	 */
	public List<BasicArea> queryAllArea(String memberCode);
	
	/**
	 * 一级地区
	 * @param member_Code
	 * @return
	 */
	public List<BasicArea> queryBasicArea(String memberCode);
	    
	/**
	 * 二级地区
	 * @param member_Code
	 * @param areaParent	所属一级地区的area_code
	 * @return
	 */
	public List<BasicArea> query2BasicArea(@Param("memberCode")String memberCode,@Param("areaParent")String areaParent);
	
	/**
	 * 三级地区
	 * @param member_Code
	 * @param areaNodecode	所属二级地区的area_code
	 * @return
	 */
	public List<BasicArea> query3BasicArea(@Param("memberCode")String memberCode,@Param("areaNodecode")String areaNodecode);
	
	
	/**
	 * 获取当前地址详情
	 * @param areaId
	 * @return
	 */
	public BasicArea getAreaDetail(BigDecimal areaId);
	
	/**
	 * 增加地区
	 * @param basicArea 
	 * @return
	 */
	public int insertArea(BasicArea record);
	
	/**
	 * 编辑地区
	 * @param basicArea 
	 * @return
	 */
	public int updateArea(BasicArea basicArea);
	
	/**
	 * 删除地区
	 * @param areaCode	
	 * @return
	 */
	public int deleteBasicArea(String areaCode);
	
	/**
	 * 查询下个area_code
	 */
	public Long getNextAreaCode();
}