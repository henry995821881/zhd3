package com.xyscm.sys.basic.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class BasicWarePlace implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	private BigDecimal wareplaceId;

    private String wareplaceCode;

    private String wareplaceName;

    private String wareplaceWregion;

    private String wareplaceGregion;

    private String warehouseCode;

    private BigDecimal wareplaceMinnum;

    private BigDecimal wareplaceMaxnum;

    private String memberCode;

    private String wareplaceCtype;

    private String wareplaceRemark;

    private BigDecimal wareplaceX;

    private BigDecimal wareplaceY;

    private BigDecimal wareplaceHeight;

    private BigDecimal wareplaceWidth;

    private BigDecimal deviceId;

    private String deviceName;

    public BigDecimal getWareplaceId() {
        return wareplaceId;
    }

    public void setWareplaceId(BigDecimal wareplaceId) {
        this.wareplaceId = wareplaceId;
    }

    public String getWareplaceCode() {
        return wareplaceCode;
    }

    public void setWareplaceCode(String wareplaceCode) {
        this.wareplaceCode = wareplaceCode == null ? null : wareplaceCode.trim();
    }

    public String getWareplaceName() {
        return wareplaceName;
    }

    public void setWareplaceName(String wareplaceName) {
        this.wareplaceName = wareplaceName == null ? null : wareplaceName.trim();
    }

    public String getWareplaceWregion() {
        return wareplaceWregion;
    }

    public void setWareplaceWregion(String wareplaceWregion) {
        this.wareplaceWregion = wareplaceWregion == null ? null : wareplaceWregion.trim();
    }

    public String getWareplaceGregion() {
        return wareplaceGregion;
    }

    public void setWareplaceGregion(String wareplaceGregion) {
        this.wareplaceGregion = wareplaceGregion == null ? null : wareplaceGregion.trim();
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode == null ? null : warehouseCode.trim();
    }

    public BigDecimal getWareplaceMinnum() {
        return wareplaceMinnum;
    }

    public void setWareplaceMinnum(BigDecimal wareplaceMinnum) {
        this.wareplaceMinnum = wareplaceMinnum;
    }

    public BigDecimal getWareplaceMaxnum() {
        return wareplaceMaxnum;
    }

    public void setWareplaceMaxnum(BigDecimal wareplaceMaxnum) {
        this.wareplaceMaxnum = wareplaceMaxnum;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode == null ? null : memberCode.trim();
    }

    public String getWareplaceCtype() {
        return wareplaceCtype;
    }

    public void setWareplaceCtype(String wareplaceCtype) {
        this.wareplaceCtype = wareplaceCtype == null ? null : wareplaceCtype.trim();
    }

    public String getWareplaceRemark() {
        return wareplaceRemark;
    }

    public void setWareplaceRemark(String wareplaceRemark) {
        this.wareplaceRemark = wareplaceRemark == null ? null : wareplaceRemark.trim();
    }

    public BigDecimal getWareplaceX() {
        return wareplaceX;
    }

    public void setWareplaceX(BigDecimal wareplaceX) {
        this.wareplaceX = wareplaceX;
    }

    public BigDecimal getWareplaceY() {
        return wareplaceY;
    }

    public void setWareplaceY(BigDecimal wareplaceY) {
        this.wareplaceY = wareplaceY;
    }

    public BigDecimal getWareplaceHeight() {
        return wareplaceHeight;
    }

    public void setWareplaceHeight(BigDecimal wareplaceHeight) {
        this.wareplaceHeight = wareplaceHeight;
    }

    public BigDecimal getWareplaceWidth() {
        return wareplaceWidth;
    }

    public void setWareplaceWidth(BigDecimal wareplaceWidth) {
        this.wareplaceWidth = wareplaceWidth;
    }

    public BigDecimal getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(BigDecimal deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }
}