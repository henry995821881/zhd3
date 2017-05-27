package com.xyscm.sys.basic.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class BasicDept implements Serializable{
	private static final long serialVersionUID = 1L;

	private BigDecimal deptId;

    private String memberCode;

    private String deptCode;

    private String deptName;

    private String orgCode;

    private String deptManager;

    private String deptRemark;

    private BigDecimal deptIsleaf;

    private String deptParent;

    private String deptNodecode;

    private BigDecimal basicShare;

    public BigDecimal getDeptId() {
        return deptId;
    }

    public void setDeptId(BigDecimal deptId) {
        this.deptId = deptId;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode == null ? null : memberCode.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getDeptManager() {
        return deptManager;
    }

    public void setDeptManager(String deptManager) {
        this.deptManager = deptManager == null ? null : deptManager.trim();
    }

    public String getDeptRemark() {
        return deptRemark;
    }

    public void setDeptRemark(String deptRemark) {
        this.deptRemark = deptRemark == null ? null : deptRemark.trim();
    }

    public BigDecimal getDeptIsleaf() {
        return deptIsleaf;
    }

    public void setDeptIsleaf(BigDecimal deptIsleaf) {
        this.deptIsleaf = deptIsleaf;
    }

    public String getDeptParent() {
        return deptParent;
    }

    public void setDeptParent(String deptParent) {
        this.deptParent = deptParent == null ? null : deptParent.trim();
    }

    public String getDeptNodecode() {
        return deptNodecode;
    }

    public void setDeptNodecode(String deptNodecode) {
        this.deptNodecode = deptNodecode == null ? null : deptNodecode.trim();
    }

    public BigDecimal getBasicShare() {
        return basicShare;
    }

    public void setBasicShare(BigDecimal basicShare) {
        this.basicShare = basicShare;
    }
    public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}