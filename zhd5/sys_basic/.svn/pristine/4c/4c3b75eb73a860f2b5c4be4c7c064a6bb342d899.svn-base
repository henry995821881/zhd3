package com.xyscm.sys.basic.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyscm.sys.basic.common.constant.ErrorCode;
import com.xyscm.sys.basic.common.exception.BaseException;
import com.xyscm.sys.basic.dao.BasicAreaMapper;
import com.xyscm.sys.basic.model.BasicArea;
import com.xyscm.sys.basic.model.BasicOrg;


@Service
public class BasicAreaService {

	@Autowired
	BasicAreaMapper basicAreaMapper;
	
	/**
	 * 查询下个area_code
	 */
	public Long getNextAreaCode(){
		return basicAreaMapper.getNextAreaCode();
	}
	
	/**
	 * 所有地区
	 */
	public List<BasicArea> queryAllArea(String memberCode){
		List<BasicArea> list = null;
		try{
    		list = basicAreaMapper.queryAllArea(memberCode);
    	}catch(Exception e){
			e.printStackTrace();
    		throw new BaseException(ErrorCode.E_SYSB_AREA_SELECT_ALL.getErrCode());
    	}
    	
        return list;
	}
	
    /**
     * 查询一级地名
     * @param memberCode	都为0000
     */
    public List<BasicArea> queryBasicArea(String memberCode) {
    	
    	List<BasicArea> list = null;
    	try{
    		list = basicAreaMapper.queryBasicArea(memberCode);
    	}catch(Exception e){
			e.printStackTrace();
    		throw new BaseException(ErrorCode.E_SYSB_AREA_SELECT_FIRST.getErrCode());
    	}
    	
        return list;
    }
    
    /**
     * 查询一级地名---分页
     * @param memberCode	都为0000
     */
    public PageInfo queryBasicAreaPage(String memberCode,int pageNum,int pageSize) {
    	 PageInfo<BasicOrg> pageInfo=null;
    	 
    	try{
    		PageHelper.startPage(pageNum, pageSize); 
    		Page page = (Page)basicAreaMapper.queryBasicArea(memberCode);
    		pageInfo = new PageInfo<BasicOrg>(page);
    	}catch(Exception e){
    		e.printStackTrace();
    		throw new BaseException(ErrorCode.E_SYSB_AREA_SELECT_FIRST.getErrCode());
    	}
    	
        return pageInfo;
    }
    
    /**
     * 查询根据二级地名
     * @param memberCode 
     * @param areaParent 	所属一级地区的area_code（当areaNodecode传null时 则查出所有二级地区）
     */
    public List<BasicArea> query2BasicArea(String memberCode,String areaParent) {
    	List<BasicArea> list = null;
    	try{
    		list = basicAreaMapper.query2BasicArea(memberCode,areaParent);
    	}catch(Exception e){
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_AREA_SELECT_SECOND.getErrCode());
    	}
        return list;
    }
    
    /**
     * 查询根据二级地名-----分页
     * @param memberCode 
     * @param areaParent 	所属一级地区的area_code（当areaNodecode传null时 则查出所有二级地区）
     */
    public PageInfo query2BasicAreaPage(String memberCode,String areaParent,int pageNum,int pageSize) {
    	PageInfo<BasicOrg> pageInfo=null;
    	
    	try{
    		PageHelper.startPage(pageNum, pageSize); 
    		Page page = (Page)basicAreaMapper.query2BasicArea(memberCode,areaParent);
    		pageInfo = new PageInfo<BasicOrg>(page);
    	}catch(Exception e){
    		e.printStackTrace();
    		throw new BaseException(ErrorCode.E_SYSB_AREA_SELECT_SECOND.getErrCode());
    	}
        return pageInfo;
    }
    
    
    /**
     * 查询根据三级地名
     * @param memberCode 
     * @param areaNodecode 	所属一级地区的area_code（当areaNodecode传null时 则查出所有二级地区）
     */
    public List<BasicArea> query3BasicArea(String memberCode,String areaNodecode) {
    	List<BasicArea> list = null;
    	try{
    		list = basicAreaMapper.query3BasicArea(memberCode,areaNodecode);
    	}catch(Exception e){
			e.printStackTrace();
    		throw new BaseException(ErrorCode.E_SYSB_AREA_SELECT_THIRD.getErrCode());
    	}
        return list;
    }
    /**
     * 查询当前地址详情
     * @param memberCode 
     * @param areaNodecode 	地区的所属编号
     */
    public BasicArea getAreaDetail(BigDecimal areaId) {
    	BasicArea basicArea = null;
    	try{
    		basicArea = basicAreaMapper.getAreaDetail(areaId);
    	}catch(Exception e){
			e.printStackTrace();
    		throw new BaseException(ErrorCode.E_SYSB_AREA_SELECT_DETAIL.getErrCode());
    	}
        return basicArea;
    }
    
    
    /**
     * 增加地区
     * @param BasicArea.MemberCode
     * @param BasicArea.AreaName
     * @param BasicArea.AreaParent
     * @param BasicArea.AreaNodecode
     * @return -1:失败	1:成功
     */
    public int insertArea(BasicArea basicArea){
    	int i = -1;
    	try{
    		i = basicAreaMapper.insertArea(basicArea); 
    	}catch(Exception e){
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_AREA_ADD.getErrCode());
    	}
    	return i;
    }
  
    
    /**
     * 编辑地区
     * @param BasicArea.AreaId
     * @return -1:失败	1:成功
     */
    public int updateArea(BasicArea basicArea){
    	int i = -1;
    	try{
    		i = basicAreaMapper.updateArea(basicArea); 
    	}catch(Exception e){
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_AREA_UPDATE.getErrCode());
    	}
    	return i;
    }
  
    
	/**
	 * 删除地区（级联删除）
	 * @param memberCode
	 * @param areaNodecode	地区的所属编号
	 * @return	-1:失败	1:成功
	 */
    public int deleteArea(String memberCode,String areaNodecode){
    	int i = -1;
    	//areaNodecode为2级地区list中只有一个，areaNodecode为1级地区list中则有多个
    	List<BasicArea> list = basicAreaMapper.query3BasicArea(memberCode,areaNodecode);
    	try{
    		if(list != null && list.size() > 0){
        		for (BasicArea basicArea : list) {
        			//删除地区
        			i = basicAreaMapper.deleteBasicArea(basicArea.getAreaCode());
        			if(1 != i){
        				i = -1;
        				break;
        			}
        		}
        	}
    	}catch(Exception e){
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_AREA_DELETE.getErrCode());
    	}
    	return i;
    }
}
