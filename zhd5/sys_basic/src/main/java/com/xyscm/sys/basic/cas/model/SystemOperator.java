package com.xyscm.sys.basic.cas.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class SystemOperator implements Serializable{

	private static final long serialVersionUID = 6812530713872267536L;

	private BigDecimal operatorId;

    private String memberCode;

    private String operatorCode;

    private String operatorUserid;

    private String operatorUser;

    private String operatorPassword;

    private String roleCodelist;

    private String operatorKey;

    private BigDecimal operatorState;

    private BigDecimal operatorIdentity;

    private String orgCode;

    private String deptCode;

    private String employeeCode;

    private String operatorNickname;

    private String operatorPhoto;

    private String operatorHomeurl;

    private BigDecimal operatorFailnum;

    private BigDecimal pdauserState;

    public BigDecimal getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(BigDecimal operatorId) {
        this.operatorId = operatorId;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode == null ? null : memberCode.trim();
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode == null ? null : operatorCode.trim();
    }

    public String getOperatorUserid() {
        return operatorUserid;
    }

    public void setOperatorUserid(String operatorUserid) {
        this.operatorUserid = operatorUserid == null ? null : operatorUserid.trim();
    }

    public String getOperatorUser() {
        return operatorUser;
    }

    public void setOperatorUser(String operatorUser) {
        this.operatorUser = operatorUser == null ? null : operatorUser.trim();
    }

    public String getOperatorPassword() {
        return operatorPassword;
    }

    public void setOperatorPassword(String operatorPassword) {
        this.operatorPassword = operatorPassword == null ? null : operatorPassword.trim();
    }

    public String getRoleCodelist() {
        return roleCodelist;
    }

    public void setRoleCodelist(String roleCodelist) {
        this.roleCodelist = roleCodelist == null ? null : roleCodelist.trim();
    }

    public String getOperatorKey() {
        return operatorKey;
    }

    public void setOperatorKey(String operatorKey) {
        this.operatorKey = operatorKey == null ? null : operatorKey.trim();
    }

    public BigDecimal getOperatorState() {
        return operatorState;
    }

    public void setOperatorState(BigDecimal operatorState) {
        this.operatorState = operatorState;
    }

    public BigDecimal getOperatorIdentity() {
        return operatorIdentity;
    }

    public void setOperatorIdentity(BigDecimal operatorIdentity) {
        this.operatorIdentity = operatorIdentity;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode == null ? null : employeeCode.trim();
    }

    public String getOperatorNickname() {
        return operatorNickname;
    }

    public void setOperatorNickname(String operatorNickname) {
        this.operatorNickname = operatorNickname == null ? null : operatorNickname.trim();
    }

    public String getOperatorPhoto() {
        return operatorPhoto;
    }

    public void setOperatorPhoto(String operatorPhoto) {
        this.operatorPhoto = operatorPhoto == null ? null : operatorPhoto.trim();
    }

    public String getOperatorHomeurl() {
        return operatorHomeurl;
    }

    public void setOperatorHomeurl(String operatorHomeurl) {
        this.operatorHomeurl = operatorHomeurl == null ? null : operatorHomeurl.trim();
    }

    public BigDecimal getOperatorFailnum() {
        return operatorFailnum;
    }

    public void setOperatorFailnum(BigDecimal operatorFailnum) {
        this.operatorFailnum = operatorFailnum;
    }

    public BigDecimal getPdauserState() {
        return pdauserState;
    }

    public void setPdauserState(BigDecimal pdauserState) {
        this.pdauserState = pdauserState;
    }
}