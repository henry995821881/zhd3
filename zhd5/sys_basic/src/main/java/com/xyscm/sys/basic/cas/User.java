/**
 * 智恒达钢盟网络科技有限公司
 */
package com.xyscm.sys.basic.cas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 功能描述：
 * 
 * @author xielf
 * @CreateDate 2017-5-16 下午3:12:58
 * @Version: 1.0
 */
public class User implements Serializable {

	private static final long serialVersionUID = 2826040410594360350L;
	
	/** 用户账号*/
	@NotEmpty
	private String userId;
	/** 密码 */
	@NotEmpty
	private String password;
	/** 验证码 */
	@NotEmpty
	private String captcha;
	
	// 会员代码
	private String memberCode;
	// 用户代码
    private String operatorCode;
    // 用户名称
    private String operatorUser;
    // 角色列表
    private String roleCodelist;

    private String operatorKey;
    // 状态：0：启用 1：停用
    private BigDecimal operatorState;
    // 0：用户 1：管理员 2：系统管理员
    private BigDecimal operatorIdentity;
    // 机构
    private String orgCode;
    /** 机构名称*/
	private String orgName;
	/** 机构简称*/
	private String orgAbbreviate;
    // 部门
    private String deptCode;
    /**部门名称*/
	private String deptName;
    // 员工号
    private String employeeCode;
    /**员工名称 */
	private String employeeName;
    // 昵称
    private String operatorNickname;
    // 照片
    private String operatorPhoto;
	
    /** 操作员按钮权限 */
	private Map<String, Boolean> buttonPermissionMap;
	/** 操作员权限 */
	private Map<String, Boolean> permissionMap;
	/** 操作员数据权限 启用*/
	private Map<String, String> opDataMap;
	/** 操作员数据只读权限 map<map<key==数据权限类别,对应用户数据权限信息('1','2')>> */
	private Map<String,String> opDataReadMap;
	/** 操作员数据写权限 map<map<key==数据权限类别,对应用户数据权限信息('1','2')>> */
	private Map<String,String> opDataWriteMap;
	
	/**
	 * @return 
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param 
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the captcha
	 */
	public String getCaptcha() {
		return captcha;
	}
	/**
	 * @param captcha the captcha to set
	 */
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
	/**
	 * @return the memberCode
	 */
	public String getMemberCode() {
		return memberCode;
	}
	/**
	 * @param memberCode the memberCode to set
	 */
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	/**
	 * @return the operatorCode
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * @param operatorCode the operatorCode to set
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	/**
	 * @return the operatorUser
	 */
	public String getOperatorUser() {
		return operatorUser;
	}
	/**
	 * @param operatorUser the operatorUser to set
	 */
	public void setOperatorUser(String operatorUser) {
		this.operatorUser = operatorUser;
	}
	/**
	 * @return the roleCodelist
	 */
	public String getRoleCodelist() {
		return roleCodelist;
	}
	/**
	 * @param roleCodelist the roleCodelist to set
	 */
	public void setRoleCodelist(String roleCodelist) {
		this.roleCodelist = roleCodelist;
	}
	/**
	 * @return the operatorKey
	 */
	public String getOperatorKey() {
		return operatorKey;
	}
	/**
	 * @param operatorKey the operatorKey to set
	 */
	public void setOperatorKey(String operatorKey) {
		this.operatorKey = operatorKey;
	}
	/**
	 * @return the operatorState
	 */
	public BigDecimal getOperatorState() {
		return operatorState;
	}
	/**
	 * @param operatorState the operatorState to set
	 */
	public void setOperatorState(BigDecimal operatorState) {
		this.operatorState = operatorState;
	}
	/**
	 * @return the operatorIdentity
	 */
	public BigDecimal getOperatorIdentity() {
		return operatorIdentity;
	}
	/**
	 * @param operatorIdentity the operatorIdentity to set
	 */
	public void setOperatorIdentity(BigDecimal operatorIdentity) {
		this.operatorIdentity = operatorIdentity;
	}
	/**
	 * @return the orgCode
	 */
	public String getOrgCode() {
		return orgCode;
	}
	/**
	 * @param orgCode the orgCode to set
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	/**
	 * @return the orgAbbreviate
	 */
	public String getOrgAbbreviate() {
		return orgAbbreviate;
	}
	/**
	 * @param orgAbbreviate the orgAbbreviate to set
	 */
	public void setOrgAbbreviate(String orgAbbreviate) {
		this.orgAbbreviate = orgAbbreviate;
	}
	/**
	 * @return the deptCode
	 */
	public String getDeptCode() {
		return deptCode;
	}
	/**
	 * @param deptCode the deptCode to set
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * @return the employeeCode
	 */
	public String getEmployeeCode() {
		return employeeCode;
	}
	/**
	 * @param employeeCode the employeeCode to set
	 */
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	/**
	 * @return the operatorNickname
	 */
	public String getOperatorNickname() {
		return operatorNickname;
	}
	/**
	 * @param operatorNickname the operatorNickname to set
	 */
	public void setOperatorNickname(String operatorNickname) {
		this.operatorNickname = operatorNickname;
	}
	/**
	 * @return the operatorPhoto
	 */
	public String getOperatorPhoto() {
		return operatorPhoto;
	}
	/**
	 * @param operatorPhoto the operatorPhoto to set
	 */
	public void setOperatorPhoto(String operatorPhoto) {
		this.operatorPhoto = operatorPhoto;
	}
	/**
	 * @return the buttonPermissionMap
	 */
	public Map<String, Boolean> getButtonPermissionMap() {
		return buttonPermissionMap;
	}
	/**
	 * @param buttonPermissionMap the buttonPermissionMap to set
	 */
	public void setButtonPermissionMap(Map<String, Boolean> buttonPermissionMap) {
		this.buttonPermissionMap = buttonPermissionMap;
	}
	/**
	 * @return the permissionMap
	 */
	public Map<String, Boolean> getPermissionMap() {
		return permissionMap;
	}
	/**
	 * @param permissionMap the permissionMap to set
	 */
	public void setPermissionMap(Map<String, Boolean> permissionMap) {
		this.permissionMap = permissionMap;
	}
	/**
	 * @return the opDataMap
	 */
	public Map<String, String> getOpDataMap() {
		return opDataMap;
	}
	/**
	 * @param opDataMap the opDataMap to set
	 */
	public void setOpDataMap(Map<String, String> opDataMap) {
		this.opDataMap = opDataMap;
	}
	/**
	 * @return the opDataReadMap
	 */
	public Map<String, String> getOpDataReadMap() {
		return opDataReadMap;
	}
	/**
	 * @param opDataReadMap the opDataReadMap to set
	 */
	public void setOpDataReadMap(Map<String, String> opDataReadMap) {
		this.opDataReadMap = opDataReadMap;
	}
	/**
	 * @return the opDataWriteMap
	 */
	public Map<String, String> getOpDataWriteMap() {
		return opDataWriteMap;
	}
	/**
	 * @param opDataWriteMap the opDataWriteMap to set
	 */
	public void setOpDataWriteMap(Map<String, String> opDataWriteMap) {
		this.opDataWriteMap = opDataWriteMap;
	}
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
