package com.xyscm.sys.basic.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyscm.sys.basic.common.constant.ErrorCode;
import com.xyscm.sys.basic.common.exception.BaseException;
import com.xyscm.sys.basic.dao.BasicCompanyLinkmanMapper;
import com.xyscm.sys.basic.dao.BasicCompanyProjectMapper;
import com.xyscm.sys.basic.model.BasicCompanyAccounts;
import com.xyscm.sys.basic.model.BasicCompanyLinkman;
import com.xyscm.sys.basic.model.BasicCompanyProject;


@Service
public class BasicCompanyProjectService {

	@Autowired
	BasicCompanyProjectMapper basicCompanyProjectMapper;
	
	  /**
     * 根据compangcode查询公司项目
     * @param companyCode
     * @return
     *
     * List<BasicCompanyProject>
     */
    public List<BasicCompanyProject> queryCompanyProject(String companyCode){
		List<BasicCompanyProject> list  = basicCompanyProjectMapper.queryCompanyProject(companyCode);
		return list;
	}
    
    
   	/**
   	 * 新增公司项目
     * @return
     *
     * basicCompanyProject
   	 */
   	public void insertCompanyProject(String[] projects,String companyCode){
	   	try{
   			for (int i = 0; i < projects.length; i++) {
	   			String[] arr = projects[i].split(":");
	   			BasicCompanyProject basicCompanyProject = new BasicCompanyProject();
	   			if(arr[0].trim().length() != 0){
	   				basicCompanyProject.setCompanyProjectDate(new Date(arr[0]));
	   			}
	   			basicCompanyProject.setCompanyProjectName(arr[1]);
	   			basicCompanyProject.setCompanyProjectRemark(arr[2]);
	   			basicCompanyProject.setCompanyCode(companyCode);
	   			basicCompanyProject.setMemberCode("0000");
	   			int num = basicCompanyProjectMapper.insertCompanyProject(basicCompanyProject);
	   		}
	   	}catch(Exception e){
	   		e.printStackTrace();
	   		throw new BaseException(ErrorCode.E_SYSB_COMPANY_ADD_PROJECT.getErrCode());
	   	}
   		
   	}
    

	/**
	 * 根据id删除公司项目
	 * @param companyLinkmanId
	 * @return
	 *
	 * int
	 */
	public void deltCompanyProject(String companyCode){
		try{
			basicCompanyProjectMapper.deltCompanyProjectByCode(companyCode);
	 	}catch(Exception e){
	   		e.printStackTrace();
	   		throw new BaseException(ErrorCode.E_SYSB_COMPANY_DELETE_PROJECT.getErrCode());
	   	}
	}
	
	
	/**
	 * 修改
	 * @param projects
	 * @param companyCode
	 * @return
	 *	
	 * int
	 */
	public void updateCompanyProject(String[] projects,String companyCode){
		try{
			deltCompanyProject(companyCode);	//先删除再添加
			insertCompanyProject(projects,companyCode);
	 	}catch(Exception e){
	   		e.printStackTrace();
	   		throw new BaseException(ErrorCode.E_SYSB_COMPANY_UPDATE_PROJECT.getErrCode());
	   	}
	}

	/**
	 * 根据companyCode更新公司项目
	 * @param basicCompanyAccounts
	 * @return
	 *
	 * int
	 */
	public void updateProjectByCompanyCode(String newCompanyCode,String oldCompanyCode){
		try{
			basicCompanyProjectMapper.updateProjectByCompanyCode(newCompanyCode, oldCompanyCode);
		}catch(Exception e){
	   		e.printStackTrace();
	   		throw new BaseException(ErrorCode.E_SYSB_COMPANY_UPDATE_COMBINE_PROJECT.getErrCode());
	   	}
	}
	
}
