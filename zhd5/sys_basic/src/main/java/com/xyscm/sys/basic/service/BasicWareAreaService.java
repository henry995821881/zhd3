package com.xyscm.sys.basic.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyscm.sys.basic.common.constant.ErrorCode;
import com.xyscm.sys.basic.common.exception.BaseException;
import com.xyscm.sys.basic.dao.BasicWareAreaMapper;
import com.xyscm.sys.basic.model.BasicOrg;
import com.xyscm.sys.basic.model.BasicWareArea;
import com.xyscm.sys.basic.model.BasicWareAreaEx;
import com.xyscm.sys.basic.model.BasicWarehouse;

/**
 * 
 * 
 * 库区设置
 * 
 * @author Administrator
 * 
 */
@Service
public class BasicWareAreaService {
	Logger logger = LoggerFactory.getLogger(BasicWareAreaService.class);
	@Autowired
	BasicWareAreaMapper basicWareAreaMapper;

	/**
	 * 必须 memeberCode warehouse_code
	 * 
	 * 
	 * @param record
	 * @return
	 */
	public List<BasicWareArea> queryList(BasicWareArea record) {

		List<BasicWareArea> list = null;
		try {
			list = basicWareAreaMapper.queryList(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw new BaseException(ErrorCode.E_SYSB_WA_SELECT.getErrCode());
		}

		return list;
	}
	
	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @param record
	 * @return
	 *
	 * PageInfo
	 */
	public PageInfo getPage(int pageNum,int pageSize,BasicWareArea record){
		
         PageInfo<BasicOrg> pageInfo=null;
		try {
			PageHelper.startPage(pageNum, pageSize);  // 开启分页，必须
			
			
			  // 对原来的查询方法不需要任何修改
			  Page page = (Page)basicWareAreaMapper.queryList(record);
			pageInfo = new PageInfo<BasicOrg>(page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw new BaseException(ErrorCode.E_SYSB_WA_SELECT.getErrCode());
		}
		
		return pageInfo;
	}
	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @param record
	 * @return
	 *
	 * PageInfo
	 */
	public PageInfo getPageWithWarehouse(int pageNum,int pageSize,BasicWareArea record){
		
         PageInfo<BasicOrg> pageInfo=null;
		try {
			PageHelper.startPage(pageNum, pageSize);  // 开启分页，必须
			
			
			  // 对原来的查询方法不需要任何修改
			  Page page = (Page)basicWareAreaMapper.queryListWithWarehouse(record);
			pageInfo = new PageInfo<BasicOrg>(page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw new BaseException(ErrorCode.E_SYSB_WA_SELECT.getErrCode());
		}
		
		return pageInfo;
	}	

	/**
	 * 根据wareArea_id
	 * 
	 * @param record
	 * @return
	 */
	public int updateByWareAreaId(BasicWareArea record) {

		int i = 0;
		try {
			i = basicWareAreaMapper.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw new BaseException(ErrorCode.E_SYSB_WA_UPDATE.getErrCode());
		}

		return i;

	}

	/**
	 * 
	 * @param record WAREAREA_CODE memberCode
	 */
	public void updateWareAreaByCode(BasicWareArea record){
		
		try {
			basicWareAreaMapper.updateWareAreaByCode(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw new BaseException(ErrorCode.E_SYSB_WA_UPDATE.getErrCode());
		}
	}
	
	
	/**
	 * 
	 * @param record WAREAREA_CODE memberCode
	 * @return
	 */
	public void deleteWareArea(BasicWareArea record) {
	
		try {
		 basicWareAreaMapper.deleteWareArea(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw new BaseException(ErrorCode.E_SYSB_WA_DELETE.getErrCode());
		}

		

	}
	

	
	public void saveWareArea(BasicWareArea record){
		
	
		try {
			 basicWareAreaMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw new BaseException(ErrorCode.E_SYSB_WA_ADD.getErrCode());
		}
		
		
	}

}
