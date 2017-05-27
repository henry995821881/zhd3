package com.xyscm.sys.basic.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class BasicPartsName implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	private BigDecimal partsnameId;

    private String memberCode;

    private String partsnameCode;

    private String partsnameName;

    private String partsnameMnemcode;

    private String pntreeName;

    private BigDecimal partsnameWorkcoe;

    private String partsnameFormula;

    private BigDecimal partsnameProperty1;

    private BigDecimal partsnameProperty2;

    private BigDecimal partsnameProperty3;

    private BigDecimal partsnameProperty4;

    private BigDecimal partsnameProperty5;

    private BigDecimal partsnameScrapprice;

    private BigDecimal goodsTaxrate;

    private String partsnamePrice;

    private String partsnameNumunit;

    private String partsnameWeightunit;

    private BigDecimal partsnamePriceun;

    private BigDecimal partsnameAmdi;

    private BigDecimal partsnameWedi;

    private String partsnameRemark;

    private BigDecimal partsnameAdjustWeight;

    private BigDecimal partsnameState;

    private String pntreeNodecode;

    private String industryCode;

    private BigDecimal goodsPiecemode;

    private BigDecimal goodsWeightmode;

    private String goodsMetering;

    private BigDecimal goodsPriceun;

    private String goodsProperty;

    private BigDecimal basicShare;

    private String pntreeParentname;

    public BigDecimal getPartsnameId() {
        return partsnameId;
    }

    public void setPartsnameId(BigDecimal partsnameId) {
        this.partsnameId = partsnameId;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode == null ? null : memberCode.trim();
    }

    public String getPartsnameCode() {
        return partsnameCode;
    }

    public void setPartsnameCode(String partsnameCode) {
        this.partsnameCode = partsnameCode == null ? null : partsnameCode.trim();
    }

    public String getPartsnameName() {
        return partsnameName;
    }

    public void setPartsnameName(String partsnameName) {
        this.partsnameName = partsnameName == null ? null : partsnameName.trim();
    }

    public String getPartsnameMnemcode() {
        return partsnameMnemcode;
    }

    public void setPartsnameMnemcode(String partsnameMnemcode) {
        this.partsnameMnemcode = partsnameMnemcode == null ? null : partsnameMnemcode.trim();
    }

    public String getPntreeName() {
        return pntreeName;
    }

    public void setPntreeName(String pntreeName) {
        this.pntreeName = pntreeName == null ? null : pntreeName.trim();
    }

    public BigDecimal getPartsnameWorkcoe() {
        return partsnameWorkcoe;
    }

    public void setPartsnameWorkcoe(BigDecimal partsnameWorkcoe) {
        this.partsnameWorkcoe = partsnameWorkcoe;
    }

    public String getPartsnameFormula() {
        return partsnameFormula;
    }

    public void setPartsnameFormula(String partsnameFormula) {
        this.partsnameFormula = partsnameFormula == null ? null : partsnameFormula.trim();
    }

    public BigDecimal getPartsnameProperty1() {
        return partsnameProperty1;
    }

    public void setPartsnameProperty1(BigDecimal partsnameProperty1) {
        this.partsnameProperty1 = partsnameProperty1;
    }

    public BigDecimal getPartsnameProperty2() {
        return partsnameProperty2;
    }

    public void setPartsnameProperty2(BigDecimal partsnameProperty2) {
        this.partsnameProperty2 = partsnameProperty2;
    }

    public BigDecimal getPartsnameProperty3() {
        return partsnameProperty3;
    }

    public void setPartsnameProperty3(BigDecimal partsnameProperty3) {
        this.partsnameProperty3 = partsnameProperty3;
    }

    public BigDecimal getPartsnameProperty4() {
        return partsnameProperty4;
    }

    public void setPartsnameProperty4(BigDecimal partsnameProperty4) {
        this.partsnameProperty4 = partsnameProperty4;
    }

    public BigDecimal getPartsnameProperty5() {
        return partsnameProperty5;
    }

    public void setPartsnameProperty5(BigDecimal partsnameProperty5) {
        this.partsnameProperty5 = partsnameProperty5;
    }

    public BigDecimal getPartsnameScrapprice() {
        return partsnameScrapprice;
    }

    public void setPartsnameScrapprice(BigDecimal partsnameScrapprice) {
        this.partsnameScrapprice = partsnameScrapprice;
    }

    public BigDecimal getGoodsTaxrate() {
        return goodsTaxrate;
    }

    public void setGoodsTaxrate(BigDecimal goodsTaxrate) {
        this.goodsTaxrate = goodsTaxrate;
    }

    public String getPartsnamePrice() {
        return partsnamePrice;
    }

    public void setPartsnamePrice(String partsnamePrice) {
        this.partsnamePrice = partsnamePrice == null ? null : partsnamePrice.trim();
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

    public BigDecimal getPartsnamePriceun() {
        return partsnamePriceun;
    }

    public void setPartsnamePriceun(BigDecimal partsnamePriceun) {
        this.partsnamePriceun = partsnamePriceun;
    }

    public BigDecimal getPartsnameAmdi() {
        return partsnameAmdi;
    }

    public void setPartsnameAmdi(BigDecimal partsnameAmdi) {
        this.partsnameAmdi = partsnameAmdi;
    }

    public BigDecimal getPartsnameWedi() {
        return partsnameWedi;
    }

    public void setPartsnameWedi(BigDecimal partsnameWedi) {
        this.partsnameWedi = partsnameWedi;
    }

    public String getPartsnameRemark() {
        return partsnameRemark;
    }

    public void setPartsnameRemark(String partsnameRemark) {
        this.partsnameRemark = partsnameRemark == null ? null : partsnameRemark.trim();
    }

    public BigDecimal getPartsnameAdjustWeight() {
        return partsnameAdjustWeight;
    }

    public void setPartsnameAdjustWeight(BigDecimal partsnameAdjustWeight) {
        this.partsnameAdjustWeight = partsnameAdjustWeight;
    }

    public BigDecimal getPartsnameState() {
        return partsnameState;
    }

    public void setPartsnameState(BigDecimal partsnameState) {
        this.partsnameState = partsnameState;
    }

    public String getPntreeNodecode() {
        return pntreeNodecode;
    }

    public void setPntreeNodecode(String pntreeNodecode) {
        this.pntreeNodecode = pntreeNodecode == null ? null : pntreeNodecode.trim();
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode == null ? null : industryCode.trim();
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

    public BigDecimal getGoodsPriceun() {
        return goodsPriceun;
    }

    public void setGoodsPriceun(BigDecimal goodsPriceun) {
        this.goodsPriceun = goodsPriceun;
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

    public String getPntreeParentname() {
        return pntreeParentname;
    }

    public void setPntreeParentname(String pntreeParentname) {
        this.pntreeParentname = pntreeParentname == null ? null : pntreeParentname.trim();
    }
}