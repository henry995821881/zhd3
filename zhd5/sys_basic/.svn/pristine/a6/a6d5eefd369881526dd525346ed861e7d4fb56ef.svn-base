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
import com.xyscm.sys.basic.dao.BasicCompanyMapper;
import com.xyscm.sys.basic.model.BasicCompany;
import com.xyscm.sys.basic.model.BasicCompanyAccounts;
import com.xyscm.sys.basic.model.BasicCompanyLinkman;
import com.xyscm.sys.basic.model.BasicCompanyProject;
import com.xyscm.sys.basic.model.BasicOrg;
import com.xyscm.sys.basic.vo.CombineCompanyVo;


@Service
public class BasicCompanyService {

	@Autowired
	BasicCompanyMapper basicCompanyMapper;
	@Autowired
	BasicCompanyLinkmanService basicCompanyLinkmanService;
	@Autowired
	BasicCompanyAccountsService basicCompanyAccountsService;
	@Autowired
	BasicCompanyProjectService basicCompanyProjectService;
	
	/**
	 * 查询往来单位	
	 * @param memberCode	0000
	 * @param BasicCompany.orgCode		当前操作者的orgCode
	 * @return	
	 */
	public List<BasicCompany> queryCompany(BasicCompany basicCompany){
		List<BasicCompany> list = null;
		try{
			list = basicCompanyMapper.queryCompany(basicCompany);
		}catch(Exception e){
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_COMPANY_SELECT_HEAD.getErrCode());
		}
		return list;
	}
	
	/**
	 * 查询往来单位----分页	
	 * @param memberCode	0000
	 * @param BasicCompany.orgCode		当前操作者的orgCode
	 * @return	
	 */
	public PageInfo queryCompanyPage(BasicCompany basicCompany,int pageNum,int pageSize){
		 PageInfo<BasicOrg> pageInfo=null;
		 try {
			  PageHelper.startPage(pageNum, pageSize);  // 开启分页，必须
			
			  Page page = (Page)basicCompanyMapper.queryCompany(basicCompany);
			  pageInfo = new PageInfo<BasicOrg>(page);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_COMPANY_SELECT.getErrCode());
		}
		
		return pageInfo;
	}
	
	
	/**
	 * 查询往来单位详情	
	 * @param companyId		
	 * @return	
	 */
	public BasicCompany getCompanyInfo(BigDecimal companyId){
		return basicCompanyMapper.getCompanyInfo(companyId);
	}
	
	/**
	 * 新增往来单位
	 * @param BasicCompany.MemberCode
	 * @param BasicCompany.CompanyName
	 * @return	-1：失败     1：成功
	 */
	public int insertCompany(BasicCompany basicCompany){
		return basicCompanyMapper.insertCompany(basicCompany);
	} 
	
	
	/**
	 * 新增往来单位
	 * @param BasicCompany.MemberCode
	 * @param BasicCompany.CompanyName
	 * @return	-1：失败     1：成功
	 */
	public void insertCompanyS(BasicCompany basicCompany,String[] linkmans,String[] accounts,String[] projects){
		//新增往来单位
		try{
			int i = basicCompanyMapper.insertCompany(basicCompany);
			
			if(i == 1){
				List<BasicCompany> list = basicCompanyMapper.queryCompany(basicCompany);
				String companyCode = list.get(0).getCompanyCode();
				//新增联系人
				basicCompanyLinkmanService.insertCompanyLinkman(linkmans,companyCode);
				
				//新增账号
				basicCompanyAccountsService.insertCompanyAccount(accounts,companyCode);
				
				//新增项目
				basicCompanyProjectService.insertCompanyProject(projects,companyCode);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_COMPANY_ADD.getErrCode());
		}
	} 
	
	/**
	 * 修改往来单位	
	 * @param BasicCompany.CompanyId
	 * @param BasicCompany.CompanyAbbreviate	公司名
	 * @return	-1：失败     1：成功
	 */
	public int updateCompany(BasicCompany basicCompany){
		return basicCompanyMapper.updateCompany(basicCompany);
	}
	
	/**
	 * 删除往来单位
	 * @param companyId
	 * @return	-1：失败     1：成功
	 */
	public int deleteCompany(BigDecimal companyId){
		return basicCompanyMapper.deleteCompany(companyId);
	}
	
	
	/**
	 * 根据AreaCode查询往来单位	
	 * @param memberCode	0000
	 * @param areaCode		地区code
	 * @return	
	 */
	public List<BasicCompany> queryCompanyByAreaCode(String memberCode,String areaCode,String orgCode){
		return basicCompanyMapper.queryCompanyByAreaCode(memberCode,areaCode,orgCode);
	}
	
	/**
	 * 根据AreaCode查询往来单位----分页	
	 * @param memberCode	0000
	 * @param areaCode		地区code
	 * @return	
	 */
	public PageInfo queryCompanyByAreaCodePage(String memberCode,String areaCode,String orgCode,int pageNum,int pageSize ){
		 PageInfo<BasicOrg> pageInfo=null;
		 
		try{
    		PageHelper.startPage(pageNum, pageSize); 
    		Page page = (Page)basicCompanyMapper.queryCompanyByAreaCode(memberCode,areaCode,orgCode);
    		pageInfo = new PageInfo<BasicOrg>(page);
    	}catch(Exception e){
    		e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_COMPANY_SELECT.getErrCode());
    	}
    	
        return pageInfo;
		 
	}
	
	
	/**
	 * 修改往来单位	
	 * @param BasicCompany.CompanyId
	 * @param BasicCompany.CompanyAbbreviate	公司名
	 * @return	-1：失败     1：成功
	 */
	public void updateCompany(BasicCompany basicCompany,String[] linkmans,String[] accounts,String[] projects ){
		try{
			int i = basicCompanyMapper.updateCompany(basicCompany);
			if(i == 1){
				
				String companyCode = basicCompany.getCompanyCode();
				
				//修改联系人
				basicCompanyLinkmanService.updateCompanyLinkman(linkmans, companyCode);
				
				//修改账号
				basicCompanyAccountsService.updateCompanyAccount(accounts, companyCode);
				
				//修改项目
				basicCompanyProjectService.updateCompanyProject(projects, companyCode);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_COMPANY_UPDATE.getErrCode());
		}
	}
	
	/**
	 * 合并往来单位
	 * @return	-1：失败     1：成功
	 */
	public void combineCompany(CombineCompanyVo vo){
		//被合并公司修改状态
		BasicCompany basicCompany = new BasicCompany();
		basicCompany.setCompanyId(new BigDecimal(vo.getOldCompanyId()));
		basicCompany.setCompanyState(new BigDecimal(1));
		try{
			int i = updateCompany(basicCompany);
			
			if(i == 1){
				//将被合并公司(old)的联系人转到合并公司(new)下
				String newCompanyCode = vo.getNewCompanyCode();
				String oldCompanyCode = vo.getOldCompanyCode();
				//联系人
				basicCompanyLinkmanService.updateLinkmanByCompanyCode(newCompanyCode, oldCompanyCode);
				//账号
				basicCompanyAccountsService.updateAccountByCompanyCode(newCompanyCode, oldCompanyCode);
				//项目
				basicCompanyProjectService.updateProjectByCompanyCode(newCompanyCode, oldCompanyCode);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_COMPANY_UPDATE_COMBINE.getErrCode());
		}
	}
	
}
