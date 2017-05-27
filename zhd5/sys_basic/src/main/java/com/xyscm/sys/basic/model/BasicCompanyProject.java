package com.xyscm.sys.basic.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class BasicCompanyProject implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal companyProjectId;
    
    private String companyProjectCode;

    private String companyProjectName;

    private BigDecimal companyProjectType;

    private String companyCode;

    private String memberCode;

    private Date companyProjectDate;

    private String companyProjectRemark;

    public BigDecimal getCompanyProjectId() {
        return companyProjectId;
    }

    public void setCompanyProjectId(BigDecimal companyProjectId) {
        this.companyProjectId = companyProjectId;
    }

    public String getCompanyProjectCode() {
        return companyProjectCode;
    }

    public void setCompanyProjectCode(String companyProjectCode) {
        this.companyProjectCode = companyProjectCode == null ? null : companyProjectCode.trim();
    }

    public String getCompanyProjectName() {
        return companyProjectName;
    }

    public void setCompanyProjectName(String companyProjectName) {
        this.companyProjectName = companyProjectName == null ? null : companyProjectName.trim();
    }

    public BigDecimal getCompanyProjectType() {
        return companyProjectType;
    }

    public void setCompanyProjectType(BigDecimal companyProjectType) {
        this.companyProjectType = companyProjectType;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode == null ? null : memberCode.trim();
    }

    public Date getCompanyProjectDate() {
        return companyProjectDate;
    }

    public void setCompanyProjectDate(Date companyProjectDate) {
        this.companyProjectDate = companyProjectDate;
    }

    public String getCompanyProjectRemark() {
        return companyProjectRemark;
    }

    public void setCompanyProjectRemark(String companyProjectRemark) {
        this.companyProjectRemark = companyProjectRemark == null ? null : companyProjectRemark.trim();
    }
    
    
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
    
}