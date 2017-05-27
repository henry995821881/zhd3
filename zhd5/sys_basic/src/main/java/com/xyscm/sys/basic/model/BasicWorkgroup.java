package com.xyscm.sys.basic.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class BasicWorkgroup implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	

	private BigDecimal workgroupId;

    private String workgroupCode;

    private String workgroupName;

    private String memberCode;

    private String warehouseCode;

    private String employeeCode;

    private String worktypeName;

    private BigDecimal workgroupClass;

    private String workgroupRemark;

    private String dataEditOrg;

    private String orgCode;

    public BigDecimal getWorkgroupId() {
        return workgroupId;
    }

    public void setWorkgroupId(BigDecimal workgroupId) {
        this.workgroupId = workgroupId;
    }

    public String getWorkgroupCode() {
        return workgroupCode;
    }

    public void setWorkgroupCode(String workgroupCode) {
        this.workgroupCode = workgroupCode == null ? null : workgroupCode.trim();
    }

    public String getWorkgroupName() {
        return workgroupName;
    }

    public void setWorkgroupName(String workgroupName) {
        this.workgroupName = workgroupName == null ? null : workgroupName.trim();
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode == null ? null : memberCode.trim();
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode == null ? null : warehouseCode.trim();
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode == null ? null : employeeCode.trim();
    }

    public String getWorktypeName() {
        return worktypeName;
    }

    public void setWorktypeName(String worktypeName) {
        this.worktypeName = worktypeName == null ? null : worktypeName.trim();
    }

    public BigDecimal getWorkgroupClass() {
        return workgroupClass;
    }

    public void setWorkgroupClass(BigDecimal workgroupClass) {
        this.workgroupClass = workgroupClass;
    }

    public String getWorkgroupRemark() {
        return workgroupRemark;
    }

    public void setWorkgroupRemark(String workgroupRemark) {
        this.workgroupRemark = workgroupRemark == null ? null : workgroupRemark.trim();
    }

    public String getDataEditOrg() {
        return dataEditOrg;
    }

    public void setDataEditOrg(String dataEditOrg) {
        this.dataEditOrg = dataEditOrg == null ? null : dataEditOrg.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }
}