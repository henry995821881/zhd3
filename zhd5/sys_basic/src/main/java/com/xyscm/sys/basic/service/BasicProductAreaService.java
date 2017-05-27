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
import com.xyscm.sys.basic.dao.BasicProductAreaMapper;
import com.xyscm.sys.basic.model.BasicOrg;
import com.xyscm.sys.basic.model.BasicProductArea;
import com.xyscm.sys.basic.model.BasicWarehouse;

/**
 * 
 * @author henry 产地设置
 * 
 */
@Service
public class BasicProductAreaService {
	Logger logger = LoggerFactory.getLogger(BasicProductAreaService.class);
	@Autowired
	BasicProductAreaMapper basicProductAreaMapper;

	/**
	 * 
	 * @param record memberCode
	 * @return
	 */
	public List<BasicProductArea> queryList(BasicProductArea record) {

		List<BasicProductArea> list = null;
		try {
			list = basicProductAreaMapper.queryList(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw new BaseException(ErrorCode.E_SYSB_PA_SELECT.getErrCode());
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
	public PageInfo getPage(int pageNum,int pageSize,BasicProductArea record){
		
         PageInfo<BasicOrg> pageInfo=null;
		try {
			PageHelper.startPage(pageNum, pageSize);  // 开启分页，必须
			
			
			  // 对原来的查询方法不需要任何修改
			  Page page = (Page)basicProductAreaMapper.queryList(record);
			pageInfo = new PageInfo<BasicOrg>(page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw new BaseException(ErrorCode.E_SYSB_PA_SELECT.getErrCode());
		}
		
		return pageInfo;
	}
	
	
	
	
	/**
	 * 
	 * @param record membercode PRODUCTAREA_CODE
	 */
	public void updateProductArea(BasicProductArea record){
		try {
			basicProductAreaMapper.updateProductArea(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw new BaseException(ErrorCode.E_SYSB_PA_UPDATE.getErrCode());
		}
	}
	
	/**
	 * 
	 * @param record record membercode PRODUCTAREA_CODE
	 */
	public void deleteProductArea(BasicProductArea record){
		
		try {
			basicProductAreaMapper.deleteProductArea(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw new BaseException(ErrorCode.E_SYSB_PA_DELETE.getErrCode());
		}
	}
	
	
	public void saveProductArea(BasicProductArea record){
		try {
			basicProductAreaMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw new BaseException(ErrorCode.E_SYSB_PA_ADD.getErrCode());
		}
	}
}
