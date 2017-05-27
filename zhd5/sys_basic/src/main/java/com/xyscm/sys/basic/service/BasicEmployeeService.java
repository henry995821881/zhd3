package com.xyscm.sys.basic.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyscm.sys.basic.common.constant.ErrorCode;
import com.xyscm.sys.basic.common.exception.BaseException;
import com.xyscm.sys.basic.common.util.MessageSourceUtil;
import com.xyscm.sys.basic.common.util.StringUtil;
import com.xyscm.sys.basic.dao.BasicEmployeeMapper;
import com.xyscm.sys.basic.model.BasicEmployee;
import com.xyscm.sys.basic.model.BasicOrg;
@Service
public class BasicEmployeeService {
		
	@Autowired
	BasicEmployeeMapper basicEmployeeMapper;
			
	/**
	 * 查询信息
	 * 
	 * @return List<BasicEmployee>
	 */
	public List<BasicEmployee> queryAll(){
		return basicEmployeeMapper.queryAll();
	}

	/**
	 * 查询员工信息
	 * @param queryBean 查询条件对象
	 * @param page 分页对象
	 * @return
	 */
	/*public List<BasicEmployee> query(QueryBean queryBean,PageTools page){
		return basicEmployeeMapper.query(queryBean, page);
	}*/

	/**
	 * 通过员工代码,使用单位查询员工记录
	 * @param employeeCode 职工代码
	 * @param memberCode 使用单位代码
	 * @return
	 */
	public BasicEmployee getByCode(String employeeCode, String memberCode){
		return basicEmployeeMapper.getByCode(employeeCode, memberCode);
	}

	/**
	 * 通过员工名称,使用单位查询员工记录
	 * @param memberCode
	 * @param employeeName
	 * @return
	 * 
	 */
	public BasicEmployee getByName(String memberCode, String employeeName){
		return basicEmployeeMapper.getByName(memberCode, employeeName);
	}

	/**
	 * 查询下拉列表信息
	 * @param user 用户信息
	 * @param page 分页对象
	 * @param query 过滤职员代码或职员名称或助记码
	 * @param employeeCode 职员代码
	 * @return
	 */
	/*public List<ComboBean> queryCombo(UserSession user,PageTools page,String query,String employeeCode,String employeeName){
		return basicEmployeeMapper.queryCombo(user, page, query, employeeCode,employeeName);
	}*/

	/**
	 * 插入记录
	 * 
	 * @param mod
	 * @return 1 成功 -1 失败
	 */
	public void insert(BasicEmployee mod){
		try {
			basicEmployeeMapper.insert(mod);
		} catch (Exception e) {
			throw new BaseException(ErrorCode.E_SYSB_EMPLOYEE_ADD.getErrCode(),MessageSourceUtil.getMessage(ErrorCode.E_SYSB_EMPLOYEE_ADD.getErrCode()));
		}
	}

	/**
	 * 更新记录
	 * 
	 * @param mod
	 * @return 1 成功 -1 失败
	 */
	public int update(BasicEmployee mod){
		int update = 0;
		try {
			update = basicEmployeeMapper.update(mod);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_EMPLOYEE_UPDATE.getErrCode(),MessageSourceUtil.getMessage(ErrorCode.E_SYSB_EMPLOYEE_UPDATE.getErrCode()));
		}
		return update;
	}

	/**
	 * 删除记录
	 * @param employeeCode 员工代码
	 * @param memberCode 使用单位
	 * @return
	 */
	public int delete(String employeeCode, String memberCode){
		int i = 0;
		try {
			i = basicEmployeeMapper.delete(employeeCode, memberCode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException(ErrorCode.E_SYSB_EMPLOYEE_DELETE.getErrCode(),MessageSourceUtil.getMessage(ErrorCode.E_SYSB_EMPLOYEE_DELETE.getErrCode()));
		}
		return i;
		/*if (1 != i) {
			throw new BaseException("0310003", "", "删除["+ memberCode + "/" + employeeCode + "]失败:" + i);
		}
		return 1;*/
	}
	/**
	 * 获取相应的记录数
	 * @param orgCode
	 * @param deptCode
	 * @param other1
	 * @param other2
	 * @param other3
	 * @param memberCode
	 * @return
	 */
	public int getCountByCode(String orgCode, String deptCode, String other1, String other2, String other3, String memberCode){
		return basicEmployeeMapper.getCountByCode(orgCode, deptCode, other1, other2, other3, memberCode);
	}
	/**
	 * 根据工种查询业务员
	 * @param worktypeName
	 * @return
	 */
	public List<BasicEmployee> queryPdaEmployee(String worktypeName){
		return basicEmployeeMapper.queryPdaEmployee(worktypeName);
	}
	
	/**
	 * @param mod
	 * @return 提示消息
	 */
	private String checkEmployee(BasicEmployee mod) {
		if (null == mod) {
			return "数据为空";
		}
		String msg = "";
		msg += StringUtil.isBlankToMsg(mod.getMemberCode(), "数据中心为空");
		msg += StringUtil.isBlankToMsg(mod.getEmployeeName(), "请输入姓名");
		msg += StringUtil.isBlankToMsg(mod.getOrgCode(), "机构为空");
		msg += StringUtil.isBlankToMsg(mod.getDeptCode(), "部门为空");
		if(null==mod.getEmployeeState()){
			mod.setEmployeeState(new BigDecimal(0L));
		}
		if (StringUtils.isNotBlank(msg) && msg.trim().endsWith(",")) {
			msg = msg.trim().substring(0, msg.trim().length() - 1);
		}
		return msg;
	}

	/**
	 * 条件查询分页信息
	 * @param current_page
	 * @param page_size
	 * @param basicEmployee
	 * @return
	 *
	 * PageInfo
	 */
	public PageInfo getPage(int pageNum, int pageSize,
			BasicEmployee basicEmployee) {
		 PageInfo<BasicEmployee> pageInfo=null;
			try {
				PageHelper.startPage(pageNum, pageSize);  // 开启分页，必须
				
				
				  // 对原来的查询方法不需要任何修改
				  List<BasicEmployee> basicEmployeeList = basicEmployeeMapper.queryByBean(basicEmployee);
				  
				  pageInfo = new PageInfo<BasicEmployee>(basicEmployeeList);
				  
			} catch (Exception e) {
				e.printStackTrace();
				throw new BaseException("");
			}
			
			return pageInfo;
	}

	/**
	 * 条件查询分页信息
	 * @param bean
	 * @param page  当前页
	 * @param rows	每页显示条数
	 * @return
	 *//*
	public PageJson query(EmployeeBeanVo bean, Integer page, Integer rows) {
		PageJson pageJson = new PageJson();
		
		//查询之前，设置分页。分页插件PageHelper设置分页
		PageHelper.startPage(page, rows);
		//执行分页查询
		List<BasicEmployee> basicEmployeeList = basicEmployeeMapper.query(bean);
		//创建PageInfo对象，获取分页信息
		PageInfo<BasicEmployee> pageInfo = new PageInfo<BasicEmployee>(basicEmployeeList);
		//从pageInfo包装类中获取分页信息，设置EasyUIJson对象
		pageJson.setTotal(pageInfo.getTotal());
		pageJson.setRows(basicEmployeeList);
		return pageJson;
		
	}*/
	
}
