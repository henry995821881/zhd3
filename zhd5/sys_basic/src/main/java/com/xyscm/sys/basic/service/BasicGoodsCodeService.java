package com.xyscm.sys.basic.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyscm.sys.basic.cas.User;
import com.xyscm.sys.basic.common.constant.ErrorCode;
import com.xyscm.sys.basic.common.exception.BaseException;
import com.xyscm.sys.basic.common.util.BasicCacheUtil;
import com.xyscm.sys.basic.dao.BasicGoodsCodeMapper;
import com.xyscm.sys.basic.model.BasicGoodsCode;
import com.xyscm.sys.basic.model.BasicOrg;


/**
 * 物资代码设置
 * @author Administrator
 *
 */
@Service
public class BasicGoodsCodeService {
	
	Logger logger = LoggerFactory.getLogger(BasicGoodsCodeService.class);	
	@Autowired
	BasicGoodsCodeMapper basicGoodsCodeMapper;
	
	/**
	 * 
	 * @param   memeberCode    like   GOODS_NODECODE 模糊查询条件
	 * @return
	 */
	public List<BasicGoodsCode> queryList(BasicGoodsCode record){
		
		List<BasicGoodsCode> list= null;
		try {
			list = basicGoodsCodeMapper.queryList(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw new BaseException(ErrorCode.E_SYSB_GC_SELECT.getErrCode());
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
	public PageInfo getPage(int pageNum,int pageSize,BasicGoodsCode record){
		
         PageInfo<BasicOrg> pageInfo =null;
		try {
			PageHelper.startPage(pageNum, pageSize);  // 开启分页，必须
			
			
			  // 对原来的查询方法不需要任何修改
			  Page page = (Page)basicGoodsCodeMapper.queryList(record);
			pageInfo = new PageInfo<BasicOrg>(page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw new BaseException(ErrorCode.E_SYSB_GC_SELECT.getErrCode());
		}
		
		return pageInfo;
	}
	
	
	
	/**
	 * 
	 * @param record memebercode 查询规格
	 * @return
	 *
	 * List<BasicGoodsCode>
	 */
public List<BasicGoodsCode> queryGoodsSpec(BasicGoodsCode record){
		
		List<BasicGoodsCode> list= null;
		try {
			list = basicGoodsCodeMapper.queryGoodsSpec(record);
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new BaseException(ErrorCode.E_SYSB_GC_SELECT.getErrCode());
		}
		
		return list;
	}


/**
 * 
 * @param record memebercode 查询材质
 * @return
 *
 * List<BasicGoodsCode>
 */
public List<BasicGoodsCode> queryGoodsMaterial(BasicGoodsCode record){
	
	List<BasicGoodsCode> list= null;
	try {
		list = basicGoodsCodeMapper.queryGoodsMaterial(record);
	} catch (Exception e) {
		
		logger.info(e.getMessage());
		throw new BaseException(ErrorCode.E_SYSB_GC_SELECT.getErrCode());
	}
	
	return list;
}

	
	
	/**
	 * 
	 * @param  GOODSCODE_CODE MEMBER_CODE
	 */
	public void updateGoodsCode(BasicGoodsCode record){
		
		try {
			basicGoodsCodeMapper.updateGoodsCode(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw new BaseException(ErrorCode.E_SYSB_GC_UPDATE.getErrCode());
		}
		
	}
	
	/**
	 * 
	 * @param  GOODSCODE_CODE MEMBER_CODE
	 */
	public void deleteGoodsCode(BasicGoodsCode record){
		
		try {
			basicGoodsCodeMapper.deleteGoodsCode(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw new BaseException(ErrorCode.E_SYSB_GC_DELETE.getErrCode());
		}
	}
	
	
	/**
	 * 
	 * @param record
	 */
	public void saveGoodsCode(BasicGoodsCode record){
		try {
			basicGoodsCodeMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			throw new BaseException(ErrorCode.E_SYSB_GC_ADD.getErrCode());
		}
	}


/**
 * 保存物资代码
 * @param bean
 * @param userInfo
 *
 * void
 */
	public  void saveGoodsCodeWith(BasicGoodsCode bean, User userInfo,String memberCode) {
		
		String orgCode = userInfo.getOrgCode();
		bean.setDataEditOrg(orgCode);
		
		this.saveGoodsCode(bean);
		if(bean.getDataAwedit()!=null){
			
			//更新库存

		}
		
		
		
	}
	
	

	

}
