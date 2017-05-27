package com.xyscm.sys.basic.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.NotEmpty;

import com.xyscm.sys.basic.common.validatedGroup.DeleteGroup;
import com.xyscm.sys.basic.common.validatedGroup.QueryGroup;
import com.xyscm.sys.basic.common.validatedGroup.SaveGroup;
import com.xyscm.sys.basic.common.validatedGroup.UpdateGroup;

public class BasicWareAreaVo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Override
	public String toString() {
		return "BasicWareArea [wareareaId=" + wareareaId + ", wareareaCode="
				+ wareareaCode + ", wareareaName=" + wareareaName
				+ ", wareareaGregion=" + wareareaGregion + ", warehouseCode="
				+ warehouseCode + ", wareareaMinnum=" + wareareaMinnum
				+ ", wareareaMaxnum=" + wareareaMaxnum + ", memberCode="
				+ memberCode + ", wareareaRemark=" + wareareaRemark
				+ ", wareareaX=" + wareareaX + ", wareareaY=" + wareareaY
				+ ", wareareaHeight=" + wareareaHeight + ", wareareaWidth="
				+ wareareaWidth + ", wareareaCtype=" + wareareaCtype + "]";
	}

	private BigDecimal wareareaId;

	@NotEmpty(message="库区代码不能空",groups = {UpdateGroup.class,DeleteGroup.class})
    private String wareareaCode;
	@NotEmpty(message="库区名不能空",groups = {SaveGroup.class})
    private String wareareaName;

    private String wareareaGregion;

   
    private String warehouseCode;

    @DecimalMin(message="最低存放量必须大于0的数字", value="0",groups={SaveGroup.class,UpdateGroup.class})
    private BigDecimal wareareaMinnum;
    @DecimalMin(message="最大存放量必须大于0的数字", value="0",groups={SaveGroup.class,UpdateGroup.class})
    private BigDecimal wareareaMaxnum;

    private String memberCode;

    private String wareareaRemark;
   
    private BigDecimal wareareaX;

    private BigDecimal wareareaY;
    @DecimalMin(message="高必须大于0的数字", value="0",groups={SaveGroup.class,UpdateGroup.class})
    private BigDecimal wareareaHeight;
    @DecimalMin(message="宽必须大于0的数字", value="0",groups={SaveGroup.class,UpdateGroup.class})
    private BigDecimal wareareaWidth;

    private String wareareaCtype;

    public BigDecimal getWareareaId() {
        return wareareaId;
    }

    public void setWareareaId(BigDecimal wareareaId) {
        this.wareareaId = wareareaId;
    }

    public String getWareareaCode() {
        return wareareaCode;
    }

    public void setWareareaCode(String wareareaCode) {
        this.wareareaCode = wareareaCode == null ? null : wareareaCode.trim();
    }

    public String getWareareaName() {
        return wareareaName;
    }

    public void setWareareaName(String wareareaName) {
        this.wareareaName = wareareaName == null ? null : wareareaName.trim();
    }

    public String getWareareaGregion() {
        return wareareaGregion;
    }

    public void setWareareaGregion(String wareareaGregion) {
        this.wareareaGregion = wareareaGregion == null ? null : wareareaGregion.trim();
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode == null ? null : warehouseCode.trim();
    }

    public BigDecimal getWareareaMinnum() {
        return wareareaMinnum;
    }

    public void setWareareaMinnum(BigDecimal wareareaMinnum) {
        this.wareareaMinnum = wareareaMinnum;
    }

    public BigDecimal getWareareaMaxnum() {
        return wareareaMaxnum;
    }

    public void setWareareaMaxnum(BigDecimal wareareaMaxnum) {
        this.wareareaMaxnum = wareareaMaxnum;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode == null ? null : memberCode.trim();
    }

    public String getWareareaRemark() {
        return wareareaRemark;
    }

    public void setWareareaRemark(String wareareaRemark) {
        this.wareareaRemark = wareareaRemark == null ? null : wareareaRemark.trim();
    }

    public BigDecimal getWareareaX() {
        return wareareaX;
    }

    public void setWareareaX(BigDecimal wareareaX) {
        this.wareareaX = wareareaX;
    }

    public BigDecimal getWareareaY() {
        return wareareaY;
    }

    public void setWareareaY(BigDecimal wareareaY) {
        this.wareareaY = wareareaY;
    }

    public BigDecimal getWareareaHeight() {
        return wareareaHeight;
    }

    public void setWareareaHeight(BigDecimal wareareaHeight) {
        this.wareareaHeight = wareareaHeight;
    }

    public BigDecimal getWareareaWidth() {
        return wareareaWidth;
    }

    public void setWareareaWidth(BigDecimal wareareaWidth) {
        this.wareareaWidth = wareareaWidth;
    }

    public String getWareareaCtype() {
        return wareareaCtype;
    }

    public void setWareareaCtype(String wareareaCtype) {
        this.wareareaCtype = wareareaCtype == null ? null : wareareaCtype.trim();
    }
}