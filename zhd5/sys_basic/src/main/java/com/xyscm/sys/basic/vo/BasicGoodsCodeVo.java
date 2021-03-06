package com.xyscm.sys.basic.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

import com.xyscm.sys.basic.common.validatedGroup.DeleteGroup;
import com.xyscm.sys.basic.common.validatedGroup.QueryGroup;
import com.xyscm.sys.basic.common.validatedGroup.SaveGroup;
import com.xyscm.sys.basic.common.validatedGroup.UpdateGroup;

public class BasicGoodsCodeVo implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
	
    private BigDecimal goodscodeId;

    private String memberCode;
    @NotEmpty(message="物资代码不能空",groups={UpdateGroup.class,DeleteGroup.class})
    private String goodscodeCode;

    private String pntreeName;
    @NotEmpty(message="产地不能空！",groups={SaveGroup.class})
    private String productareaName;

    private String partsnameName;
    @NotEmpty(message="材质不能空！",groups={SaveGroup.class})
    private String goodsMaterial;
    @NotEmpty(message="规格不能空！",groups={SaveGroup.class})
    private String goodsSpec;

    private BigDecimal goodsSpec1;

    private BigDecimal goodsSpec2;

    private BigDecimal goodsSpec3;

    private BigDecimal goodsSpec4;

    private BigDecimal goodsSpec5;

    private String goodsProperty1;

    private String goodsProperty2;

    private String goodsProperty3;

    private String goodsProperty4;

    private String goodsProperty5;

    private BigDecimal goodsNumproperty1;

    private BigDecimal goodsNumproperty2;

    private String partsnameMnemcode;

    private String partsnameNumunit;

    private String partsnameWeightunit;

    private String partsnameRemark;
    @NotEmpty(message="大类树的代码不存在",groups={QueryGroup.class})
    private String goodsNodecode;

    private String industryCode;

    private BigDecimal goodsPriceun;

    private BigDecimal goodsPiecemode;

    private BigDecimal goodsWeightmode;

    private String goodsMetering;

    private String goodsProperty;

    private BigDecimal basicShare;

    private BigDecimal goodsPartsbranch;

    private BigDecimal goodsWetpercentage;

    private BigDecimal goodsTaxrate;

    private String pntreeParentname;

    private String orgCode;

    private String dataEditOrg;

    private BigDecimal dataTypeEbp;

    private BigDecimal dataTypeWlp;

    private String staPartsnameName;

    private String staGoodsMaterial;

    private String staGoodsSpec;

    private String staProductareaName;

    private String workgroupName;

    private BigDecimal dataAwedit;

    private BigDecimal goodsPmeterweight;

    private BigDecimal m98sWeight;

    private BigDecimal l98sWeight;

    private BigDecimal l98sPrice;

    private BigDecimal m10sWeight;

    private BigDecimal l10sWeight;

    private BigDecimal l10sPrice;

    private String gcfw;

    private String zlfw;

    public BigDecimal getGoodscodeId() {
        return goodscodeId;
    }

    public void setGoodscodeId(BigDecimal goodscodeId) {
        this.goodscodeId = goodscodeId;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode == null ? null : memberCode.trim();
    }

    public String getGoodscodeCode() {
        return goodscodeCode;
    }

    public void setGoodscodeCode(String goodscodeCode) {
        this.goodscodeCode = goodscodeCode == null ? null : goodscodeCode.trim();
    }

    public String getPntreeName() {
        return pntreeName;
    }

    public void setPntreeName(String pntreeName) {
        this.pntreeName = pntreeName == null ? null : pntreeName.trim();
    }

    public String getProductareaName() {
        return productareaName;
    }

    public void setProductareaName(String productareaName) {
        this.productareaName = productareaName == null ? null : productareaName.trim();
    }

    public String getPartsnameName() {
        return partsnameName;
    }

    public void setPartsnameName(String partsnameName) {
        this.partsnameName = partsnameName == null ? null : partsnameName.trim();
    }

    public String getGoodsMaterial() {
        return goodsMaterial;
    }

    public void setGoodsMaterial(String goodsMaterial) {
        this.goodsMaterial = goodsMaterial == null ? null : goodsMaterial.trim();
    }

    public String getGoodsSpec() {
        return goodsSpec;
    }

    public void setGoodsSpec(String goodsSpec) {
        this.goodsSpec = goodsSpec == null ? null : goodsSpec.trim();
    }

    public BigDecimal getGoodsSpec1() {
        return goodsSpec1;
    }

    public void setGoodsSpec1(BigDecimal goodsSpec1) {
        this.goodsSpec1 = goodsSpec1;
    }

    public BigDecimal getGoodsSpec2() {
        return goodsSpec2;
    }

    public void setGoodsSpec2(BigDecimal goodsSpec2) {
        this.goodsSpec2 = goodsSpec2;
    }

    public BigDecimal getGoodsSpec3() {
        return goodsSpec3;
    }

    public void setGoodsSpec3(BigDecimal goodsSpec3) {
        this.goodsSpec3 = goodsSpec3;
    }

    public BigDecimal getGoodsSpec4() {
        return goodsSpec4;
    }

    public void setGoodsSpec4(BigDecimal goodsSpec4) {
        this.goodsSpec4 = goodsSpec4;
    }

    public BigDecimal getGoodsSpec5() {
        return goodsSpec5;
    }

    public void setGoodsSpec5(BigDecimal goodsSpec5) {
        this.goodsSpec5 = goodsSpec5;
    }

    public String getGoodsProperty1() {
        return goodsProperty1;
    }

    public void setGoodsProperty1(String goodsProperty1) {
        this.goodsProperty1 = goodsProperty1 == null ? null : goodsProperty1.trim();
    }

    public String getGoodsProperty2() {
        return goodsProperty2;
    }

    public void setGoodsProperty2(String goodsProperty2) {
        this.goodsProperty2 = goodsProperty2 == null ? null : goodsProperty2.trim();
    }

    public String getGoodsProperty3() {
        return goodsProperty3;
    }

    public void setGoodsProperty3(String goodsProperty3) {
        this.goodsProperty3 = goodsProperty3 == null ? null : goodsProperty3.trim();
    }

    public String getGoodsProperty4() {
        return goodsProperty4;
    }

    public void setGoodsProperty4(String goodsProperty4) {
        this.goodsProperty4 = goodsProperty4 == null ? null : goodsProperty4.trim();
    }

    public String getGoodsProperty5() {
        return goodsProperty5;
    }

    public void setGoodsProperty5(String goodsProperty5) {
        this.goodsProperty5 = goodsProperty5 == null ? null : goodsProperty5.trim();
    }

    public BigDecimal getGoodsNumproperty1() {
        return goodsNumproperty1;
    }

    public void setGoodsNumproperty1(BigDecimal goodsNumproperty1) {
        this.goodsNumproperty1 = goodsNumproperty1;
    }

    public BigDecimal getGoodsNumproperty2() {
        return goodsNumproperty2;
    }

    public void setGoodsNumproperty2(BigDecimal goodsNumproperty2) {
        this.goodsNumproperty2 = goodsNumproperty2;
    }

    public String getPartsnameMnemcode() {
        return partsnameMnemcode;
    }

    public void setPartsnameMnemcode(String partsnameMnemcode) {
        this.partsnameMnemcode = partsnameMnemcode == null ? null : partsnameMnemcode.trim();
    }

    public String getPartsnameNumunit() {
        return partsnameNumunit;
    }

    public void setPartsnameNumunit(String partsnameNumunit) {
        this.partsnameNumunit = partsnameNumunit == null ? null : partsnameNumunit.trim();
    }

    public String getPartsnameWeightunit() {
        return partsnameWeightunit;
    }

    public void setPartsnameWeightunit(String partsnameWeightunit) {
        this.partsnameWeightunit = partsnameWeightunit == null ? null : partsnameWeightunit.trim();
    }

    public String getPartsnameRemark() {
        return partsnameRemark;
    }

    public void setPartsnameRemark(String partsnameRemark) {
        this.partsnameRemark = partsnameRemark == null ? null : partsnameRemark.trim();
    }

    public String getGoodsNodecode() {
        return goodsNodecode;
    }

    public void setGoodsNodecode(String goodsNodecode) {
        this.goodsNodecode = goodsNodecode == null ? null : goodsNodecode.trim();
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode == null ? null : industryCode.trim();
    }

    public BigDecimal getGoodsPriceun() {
        return goodsPriceun;
    }

    public void setGoodsPriceun(BigDecimal goodsPriceun) {
        this.goodsPriceun = goodsPriceun;
    }

    public BigDecimal getGoodsPiecemode() {
        return goodsPiecemode;
    }

    public void setGoodsPiecemode(BigDecimal goodsPiecemode) {
        this.goodsPiecemode = goodsPiecemode;
    }

    public BigDecimal getGoodsWeightmode() {
        return goodsWeightmode;
    }

    public void setGoodsWeightmode(BigDecimal goodsWeightmode) {
        this.goodsWeightmode = goodsWeightmode;
    }

    public String getGoodsMetering() {
        return goodsMetering;
    }

    public void setGoodsMetering(String goodsMetering) {
        this.goodsMetering = goodsMetering == null ? null : goodsMetering.trim();
    }

    public String getGoodsProperty() {
        return goodsProperty;
    }

    public void setGoodsProperty(String goodsProperty) {
        this.goodsProperty = goodsProperty == null ? null : goodsProperty.trim();
    }

    public BigDecimal getBasicShare() {
        return basicShare;
    }

    public void setBasicShare(BigDecimal basicShare) {
        this.basicShare = basicShare;
    }

    public BigDecimal getGoodsPartsbranch() {
        return goodsPartsbranch;
    }

    public void setGoodsPartsbranch(BigDecimal goodsPartsbranch) {
        this.goodsPartsbranch = goodsPartsbranch;
    }

    public BigDecimal getGoodsWetpercentage() {
        return goodsWetpercentage;
    }

    public void setGoodsWetpercentage(BigDecimal goodsWetpercentage) {
        this.goodsWetpercentage = goodsWetpercentage;
    }

    public BigDecimal getGoodsTaxrate() {
        return goodsTaxrate;
    }

    public void setGoodsTaxrate(BigDecimal goodsTaxrate) {
        this.goodsTaxrate = goodsTaxrate;
    }

    public String getPntreeParentname() {
        return pntreeParentname;
    }

    public void setPntreeParentname(String pntreeParentname) {
        this.pntreeParentname = pntreeParentname == null ? null : pntreeParentname.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getDataEditOrg() {
        return dataEditOrg;
    }

    public void setDataEditOrg(String dataEditOrg) {
        this.dataEditOrg = dataEditOrg == null ? null : dataEditOrg.trim();
    }

    public BigDecimal getDataTypeEbp() {
        return dataTypeEbp;
    }

    public void setDataTypeEbp(BigDecimal dataTypeEbp) {
        this.dataTypeEbp = dataTypeEbp;
    }

    public BigDecimal getDataTypeWlp() {
        return dataTypeWlp;
    }

    public void setDataTypeWlp(BigDecimal dataTypeWlp) {
        this.dataTypeWlp = dataTypeWlp;
    }

    public String getStaPartsnameName() {
        return staPartsnameName;
    }

    public void setStaPartsnameName(String staPartsnameName) {
        this.staPartsnameName = staPartsnameName == null ? null : staPartsnameName.trim();
    }

    public String getStaGoodsMaterial() {
        return staGoodsMaterial;
    }

    public void setStaGoodsMaterial(String staGoodsMaterial) {
        this.staGoodsMaterial = staGoodsMaterial == null ? null : staGoodsMaterial.trim();
    }

    public String getStaGoodsSpec() {
        return staGoodsSpec;
    }

    public void setStaGoodsSpec(String staGoodsSpec) {
        this.staGoodsSpec = staGoodsSpec == null ? null : staGoodsSpec.trim();
    }

    public String getStaProductareaName() {
        return staProductareaName;
    }

    public void setStaProductareaName(String staProductareaName) {
        this.staProductareaName = staProductareaName == null ? null : staProductareaName.trim();
    }

    public String getWorkgroupName() {
        return workgroupName;
    }

    public void setWorkgroupName(String workgroupName) {
        this.workgroupName = workgroupName == null ? null : workgroupName.trim();
    }

    public BigDecimal getDataAwedit() {
        return dataAwedit;
    }

    public void setDataAwedit(BigDecimal dataAwedit) {
        this.dataAwedit = dataAwedit;
    }

    public BigDecimal getGoodsPmeterweight() {
        return goodsPmeterweight;
    }

    public void setGoodsPmeterweight(BigDecimal goodsPmeterweight) {
        this.goodsPmeterweight = goodsPmeterweight;
    }

    public BigDecimal getM98sWeight() {
        return m98sWeight;
    }

    public void setM98sWeight(BigDecimal m98sWeight) {
        this.m98sWeight = m98sWeight;
    }

    public BigDecimal getL98sWeight() {
        return l98sWeight;
    }

    public void setL98sWeight(BigDecimal l98sWeight) {
        this.l98sWeight = l98sWeight;
    }

    public BigDecimal getL98sPrice() {
        return l98sPrice;
    }

    public void setL98sPrice(BigDecimal l98sPrice) {
        this.l98sPrice = l98sPrice;
    }

    public BigDecimal getM10sWeight() {
        return m10sWeight;
    }

    public void setM10sWeight(BigDecimal m10sWeight) {
        this.m10sWeight = m10sWeight;
    }

    public BigDecimal getL10sWeight() {
        return l10sWeight;
    }

    public void setL10sWeight(BigDecimal l10sWeight) {
        this.l10sWeight = l10sWeight;
    }

    public BigDecimal getL10sPrice() {
        return l10sPrice;
    }

    public void setL10sPrice(BigDecimal l10sPrice) {
        this.l10sPrice = l10sPrice;
    }

    public String getGcfw() {
        return gcfw;
    }

    public void setGcfw(String gcfw) {
        this.gcfw = gcfw == null ? null : gcfw.trim();
    }

    public String getZlfw() {
        return zlfw;
    }

    public void setZlfw(String zlfw) {
        this.zlfw = zlfw == null ? null : zlfw.trim();
    }
}