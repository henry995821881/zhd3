package com.xyscm.sys.basic.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyscm.sys.basic.common.constant.ErrorCode;
import com.xyscm.sys.basic.common.exception.BaseException;
import com.xyscm.sys.basic.dao.BasicCompanyLinkmanMapper;
import com.xyscm.sys.basic.model.BasicCompanyLinkman;


@Service
public class BasicCompanyLinkmanService {

	@Autowired
	BasicCompanyLinkmanMapper basicCompanyLinkmanMapper;
	
	  /**
     * 根据compangcode查询公司联系人
     * @param companyCode
     * @return
     *
     * List<BasicCompanyLinkman>
     */
    public List<BasicCompanyLinkman> queryCompanyLinkman(String companyCode){
		List<BasicCompanyLinkman> list  = basicCompanyLinkmanMapper.queryCompanyLinkman(companyCode);
		return list;
	}
    
    
   	/**
   	 * 新增公司联系人
     * @return 0:失败 1:成功
     *
     * basicCompanyLinkman
   	 */
   	public void insertCompanyLinkman(String[] linkmans,String companyCode){
   		try{	
	   		for (int i = 0; i < linkmans.length; i++) {
	   			String[] arr = linkmans[i].split(":");
	   			BasicCompanyLinkman basicCompanyLinkman = new BasicCompanyLinkman();
	   			basicCompanyLinkman.setCompanyLinkmanName(arr[0]);
	   			basicCompanyLinkman.setCompanyLinkmanSex(arr[1]);
	   			if(arr[2].trim().length() != 0){
	   				basicCompanyLinkman.setCompanyLinkmanBirthday(new Date(arr[2]));
	   			}
	   			basicCompanyLinkman.setCompanyLinkmanPhone(arr[3]);
	   			basicCompanyLinkman.setCompanyLinkmanMsn(arr[4]);
	   			basicCompanyLinkman.setCompanyLinkmanQq(arr[5]);
	   			basicCompanyLinkman.setCompanyLinkmanFax(arr[6]);
	   			basicCompanyLinkman.setCompanyLinkmanEmail(arr[7]);
	   			basicCompanyLinkman.setCompanyLinkmanMobile(arr[8]);
	   			basicCompanyLinkman.setCompanyLinkmanAddr(arr[9]);
	   			basicCompanyLinkman.setCompanyLinkmanJob(arr[10]);
	//   			basicCompanyLinkman.setCompanyLinkmanRemark(arr[11]);
	   			basicCompanyLinkman.setMemberCode("0000");
	   			basicCompanyLinkman.setCompanyCode(companyCode);
	   			basicCompanyLinkmanMapper.insertCompanyLinkman(basicCompanyLinkman);
			}
	   	}catch(Exception e){
	   		e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_COMPANY_ADD_LINKMAN.getErrCode());
	   	}
   	}
    

	/**
	 * 根据id删除公司联系人
	 * @param companyLinkmanId
	 * @return
	 *
	 * int
	 */
	public void deltCompanyLinkman(String companyCode){
		try{
			basicCompanyLinkmanMapper.deltCompanyLinkmanByCode(companyCode);
		}catch(Exception e){
	  		e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_COMPANY_DELETE_LINKMAN.getErrCode());
		}
	}

	
	/**
	 * 修改
	 * @param linkmans
	 * @param companyCode
	 * @return
	 *
	 * int
	 */
	public void updateCompanyLinkman(String[] linkmans,String companyCode){
		try{	
			deltCompanyLinkman(companyCode);	//先删除再添加
			insertCompanyLinkman(linkmans,companyCode);
		}catch(Exception e){
	  		e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_COMPANY_UPDATE_LINKMAN.getErrCode());
		}
	}
	
	
	/**
	 * 根据companyCode更新公司联系人
	 * @param basicCompanyAccounts
	 * @return
	 *
	 * int
	 */
	public void updateLinkmanByCompanyCode(String newCompanyCode,String oldCompanyCode){
		try{
			basicCompanyLinkmanMapper.updateLinkmanByCompanyCode(newCompanyCode, oldCompanyCode);
		}catch(Exception e){
	  		e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_COMPANY_UPDATE_COMBINE_LINKMAN.getErrCode());
		}
	}
}
