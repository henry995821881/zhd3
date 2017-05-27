package com.xyscm.sys.basic.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class BasicProductArea implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	private BigDecimal productareaId;

    private String memberCode;

    private String productareaCode;

    private String productareaName;

    private String productareaMnemcode;

    private String productareaRemark;

    private BigDecimal basicShare;

    public BigDecimal getProductareaId() {
        return productareaId;
    }

    public void setProductareaId(BigDecimal productareaId) {
        this.productareaId = productareaId;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode == null ? null : memberCode.trim();
    }

    public String getProductareaCode() {
        return productareaCode;
    }

    public void setProductareaCode(String productareaCode) {
        this.productareaCode = productareaCode == null ? null : productareaCode.trim();
    }

    public String getProductareaName() {
        return productareaName;
    }

    public void setProductareaName(String productareaName) {
        this.productareaName = productareaName == null ? null : productareaName.trim();
    }

    public String getProductareaMnemcode() {
        return productareaMnemcode;
    }

    public void setProductareaMnemcode(String productareaMnemcode) {
        this.productareaMnemcode = productareaMnemcode == null ? null : productareaMnemcode.trim();
    }

    public String getProductareaRemark() {
        return productareaRemark;
    }

    public void setProductareaRemark(String productareaRemark) {
        this.productareaRemark = productareaRemark == null ? null : productareaRemark.trim();
    }

    public BigDecimal getBasicShare() {
        return basicShare;
    }

    public void setBasicShare(BigDecimal basicShare) {
        this.basicShare = basicShare;
    }
}