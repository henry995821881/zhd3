package com.xyscm.sys.basic.model;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class BasicArea  {
   
	private BigDecimal areaId;

    private String memberCode;

    private String areaCode;

    private String areaName;

    private String areaMnemcode;

    private String areaParent;

    private String areaRemark;

    private String areaNodecode;

    private BigDecimal basicShare;

    public BigDecimal getAreaId() {
        return areaId;
    }

    public void setAreaId(BigDecimal areaId) {
        this.areaId = areaId;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode == null ? null : memberCode.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getAreaMnemcode() {
        return areaMnemcode;
    }

    public void setAreaMnemcode(String areaMnemcode) {
        this.areaMnemcode = areaMnemcode == null ? null : areaMnemcode.trim();
    }

    public String getAreaParent() {
        return areaParent;
    }

    public void setAreaParent(String areaParent) {
        this.areaParent = areaParent == null ? null : areaParent.trim();
    }

    public String getAreaRemark() {
        return areaRemark;
    }

    public void setAreaRemark(String areaRemark) {
        this.areaRemark = areaRemark == null ? null : areaRemark.trim();
    }

    public String getAreaNodecode() {
        return areaNodecode;
    }

    public void setAreaNodecode(String areaNodecode) {
        this.areaNodecode = areaNodecode == null ? null : areaNodecode.trim();
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