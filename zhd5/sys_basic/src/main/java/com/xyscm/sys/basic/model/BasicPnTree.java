package com.xyscm.sys.basic.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class BasicPnTree implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	private BigDecimal pntreeId;

    private String memberCode;

    private String pntreeCode;

    private String pntreeName;

    private String pntreeParentcode;

    private String pntreeNodecode;

    private BigDecimal basicShare;

    public BigDecimal getPntreeId() {
        return pntreeId;
    }

    public void setPntreeId(BigDecimal pntreeId) {
        this.pntreeId = pntreeId;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode == null ? null : memberCode.trim();
    }

    public String getPntreeCode() {
        return pntreeCode;
    }

    public void setPntreeCode(String pntreeCode) {
        this.pntreeCode = pntreeCode == null ? null : pntreeCode.trim();
    }

    public String getPntreeName() {
        return pntreeName;
    }

    public void setPntreeName(String pntreeName) {
        this.pntreeName = pntreeName == null ? null : pntreeName.trim();
    }

    public String getPntreeParentcode() {
        return pntreeParentcode;
    }

    public void setPntreeParentcode(String pntreeParentcode) {
        this.pntreeParentcode = pntreeParentcode == null ? null : pntreeParentcode.trim();
    }

    public String getPntreeNodecode() {
        return pntreeNodecode;
    }

    public void setPntreeNodecode(String pntreeNodecode) {
        this.pntreeNodecode = pntreeNodecode == null ? null : pntreeNodecode.trim();
    }

    public BigDecimal getBasicShare() {
        return basicShare;
    }

    public void setBasicShare(BigDecimal basicShare) {
        this.basicShare = basicShare;
    }
}