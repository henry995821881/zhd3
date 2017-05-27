package com.xyscm.sys.basic.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

import com.xyscm.sys.basic.common.validatedGroup.SaveGroup;
import com.xyscm.sys.basic.common.validatedGroup.UpdateGroup;

public class BasicAreaVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigDecimal areaId;

    private String memberCode;
    
	private String areaCode;

	@NotEmpty(message="地区名称不能为空",groups={SaveGroup.class,UpdateGroup.class})
    private String areaName;

    private String areaMnemcode;

    private String areaParent;

    private String areaRemark;

    private String areaNodecode;

    private BigDecimal basicShare;
    @Override
	public String toString() {
		return "BasicAreaVo [areaId=" + areaId + ", memberCode=" + memberCode
				+ ", areaCode=" + areaCode + ", areaName=" + areaName
				+ ", areaMnemcode=" + areaMnemcode + ", areaParent="
				+ areaParent + ", areaRemark=" + areaRemark + ", areaNodecode="
				+ areaNodecode + ", basicShare=" + basicShare + "]";
	}

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
		this.memberCode = memberCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaMnemcode() {
		return areaMnemcode;
	}

	public void setAreaMnemcode(String areaMnemcode) {
		this.areaMnemcode = areaMnemcode;
	}

	public String getAreaParent() {
		return areaParent;
	}

	public void setAreaParent(String areaParent) {
		this.areaParent = areaParent;
	}

	public String getAreaRemark() {
		return areaRemark;
	}

	public void setAreaRemark(String areaRemark) {
		this.areaRemark = areaRemark;
	}

	public String getAreaNodecode() {
		return areaNodecode;
	}

	public void setAreaNodecode(String areaNodecode) {
		this.areaNodecode = areaNodecode;
	}

	public BigDecimal getBasicShare() {
		return basicShare;
	}

	public void setBasicShare(BigDecimal basicShare) {
		this.basicShare = basicShare;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
