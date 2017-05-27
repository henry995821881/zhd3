package com.xyscm.sys.basic.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class BasicWarehouse implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	private BigDecimal warehouseId;

    private String memberCode;

    private String warehouseCode;

    private String warehouseName;

    private String warehouseMnemcode;

    private String warehouseCtype;

    private String areaCode;

    private String warehousePhone;

    private String warehouseAddr;

    private String warehouseMobile;

    private String warehouseRemark;

    private BigDecimal warehouseWareplace;

    private BigDecimal warehouseState;

    private BigDecimal basicShare;

    private String warehouseLinkman;

    private BigDecimal warehouseOwnSupervise;

    public BigDecimal getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(BigDecimal warehouseId) {
        this.warehouseId = warehouseId;
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

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName == null ? null : warehouseName.trim();
    }

    public String getWarehouseMnemcode() {
        return warehouseMnemcode;
    }

    public void setWarehouseMnemcode(String warehouseMnemcode) {
        this.warehouseMnemcode = warehouseMnemcode == null ? null : warehouseMnemcode.trim();
    }

    public String getWarehouseCtype() {
        return warehouseCtype;
    }

    public void setWarehouseCtype(String warehouseCtype) {
        this.warehouseCtype = warehouseCtype == null ? null : warehouseCtype.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getWarehousePhone() {
        return warehousePhone;
    }

    public void setWarehousePhone(String warehousePhone) {
        this.warehousePhone = warehousePhone == null ? null : warehousePhone.trim();
    }

    public String getWarehouseAddr() {
        return warehouseAddr;
    }

    public void setWarehouseAddr(String warehouseAddr) {
        this.warehouseAddr = warehouseAddr == null ? null : warehouseAddr.trim();
    }

    public String getWarehouseMobile() {
        return warehouseMobile;
    }

    public void setWarehouseMobile(String warehouseMobile) {
        this.warehouseMobile = warehouseMobile == null ? null : warehouseMobile.trim();
    }

    public String getWarehouseRemark() {
        return warehouseRemark;
    }

    public void setWarehouseRemark(String warehouseRemark) {
        this.warehouseRemark = warehouseRemark == null ? null : warehouseRemark.trim();
    }

    public BigDecimal getWarehouseWareplace() {
        return warehouseWareplace;
    }

    public void setWarehouseWareplace(BigDecimal warehouseWareplace) {
        this.warehouseWareplace = warehouseWareplace;
    }

    public BigDecimal getWarehouseState() {
        return warehouseState;
    }

    public void setWarehouseState(BigDecimal warehouseState) {
        this.warehouseState = warehouseState;
    }

    public BigDecimal getBasicShare() {
        return basicShare;
    }

    public void setBasicShare(BigDecimal basicShare) {
        this.basicShare = basicShare;
    }

    public String getWarehouseLinkman() {
        return warehouseLinkman;
    }

    public void setWarehouseLinkman(String warehouseLinkman) {
        this.warehouseLinkman = warehouseLinkman == null ? null : warehouseLinkman.trim();
    }

    public BigDecimal getWarehouseOwnSupervise() {
        return warehouseOwnSupervise;
    }

    public void setWarehouseOwnSupervise(BigDecimal warehouseOwnSupervise) {
        this.warehouseOwnSupervise = warehouseOwnSupervise;
    }
}