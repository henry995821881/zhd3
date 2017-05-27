package com.xyscm.sys.basic.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class WarehouseGoods implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal goodsId;

    private String goodsCodebill;

    private String memberCode;

    private Date goodsDate;

    @Override
	public String toString() {
    	return ReflectionToStringBuilder.toString(this);
	}

	private String scontractBillcode;

    private String scontractBillbatch;

    private String datasBalcorp;

    private String datasBalcorpname;

    private String datasOrdercorp;

    private String datasOrdercorpname;

    private BigDecimal goodsMinnum;

    private BigDecimal goodsInprice;

    private BigDecimal goodsInfeeprice;

    private BigDecimal goodsNewinprice;

    private BigDecimal goodsNewinfeeprice;

    private BigDecimal goodsTaxrate;

    private BigDecimal goodsFulfill;

    private BigDecimal dataInnerflag;

    private String goodsRemark;

    private BigDecimal dataVernum;

    private String billtypeCode;

    private String sumgoodsBatch;

    private String warehouseCode;

    private String goodstreeCode;

    private String pntreeName;

    private String productareaName;

    private String partsnameName;

    private String goodsMaterial;

    private String goodsSpec;

    private BigDecimal goodsSpec1;

    private BigDecimal goodsSpec2;

    private BigDecimal goodsSpec3;

    private BigDecimal goodsSpec4;

    private String goodsProperty1;

    private String goodsProperty2;

    private String goodsProperty3;

    private String goodsProperty4;

    private String goodsProperty5;

    private BigDecimal goodsNumproperty1;

    private BigDecimal goodsNumproperty2;

    private String goodsContract;

    private String goodsContractbatch;

    private String goodsContractstr1;

    private String goodsContractstr2;

    private String goodsContractstr3;

    private String goodsContractstr4;

    private String goodsContractstr5;

    private String goodsEntrybatch;

    private String goodsEntrybatchold;

    private String goodsEntrystr1;

    private String goodsEntrystr2;

    private String goodsEntrystr3;

    private String goodsEntrystr4;

    private String goodsEntrystr5;

    private String goodsCodebillold;

    private String goodsCodestr1;

    private String goodsCodestr2;

    private String goodsCodestr3;

    private String goodsCodestr4;

    private String goodsCodestr5;

    private String goodsCodestr6;

    private String goodsCodestr7;

    private String goodsCodestr8;

    private String goodsCodestr9;

    private String goodsCodestr10;

    private BigDecimal goodsCodenum1;

    private BigDecimal goodsCodenum2;

    private BigDecimal goodsCodenum3;

    private BigDecimal partsnameSplit;

    private String goodsProperty;

    private BigDecimal goodsPartsbranch;

    private BigDecimal goodsWetpercentage;

    private String goodsOrg;

    private String goodsDept;

    private String goodsCurrency;

    private BigDecimal goodsExrate;

    private String companyCode;

    private String companyName;

    private String partsnameNumunit;

    private String partsnameWeightunit;

    private String goodsMetering;

    private BigDecimal goodsPriceun;

    private BigDecimal goodsPiecemode;

    private BigDecimal goodsWeightmode;

    private String goodsCustomscode;

    private String goodsEnname;

    private String goodsEndescribe;

    private String goodsBatch;

    private String goodsIndustry;

    private BigDecimal goodsNum;

    private BigDecimal goodsPiecenum;

    private BigDecimal goodsSingernum;

    private BigDecimal goodsWeight;

    private BigDecimal goodsAssistweight;

    private String goodsWmscodebill;

    public BigDecimal getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(BigDecimal goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsCodebill() {
        return goodsCodebill;
    }

    public void setGoodsCodebill(String goodsCodebill) {
        this.goodsCodebill = goodsCodebill == null ? null : goodsCodebill.trim();
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode == null ? null : memberCode.trim();
    }

    public Date getGoodsDate() {
        return goodsDate;
    }

    public void setGoodsDate(Date goodsDate) {
        this.goodsDate = goodsDate;
    }

    public String getScontractBillcode() {
        return scontractBillcode;
    }

    public void setScontractBillcode(String scontractBillcode) {
        this.scontractBillcode = scontractBillcode == null ? null : scontractBillcode.trim();
    }

    public String getScontractBillbatch() {
        return scontractBillbatch;
    }

    public void setScontractBillbatch(String scontractBillbatch) {
        this.scontractBillbatch = scontractBillbatch == null ? null : scontractBillbatch.trim();
    }

    public String getDatasBalcorp() {
        return datasBalcorp;
    }

    public void setDatasBalcorp(String datasBalcorp) {
        this.datasBalcorp = datasBalcorp == null ? null : datasBalcorp.trim();
    }

    public String getDatasBalcorpname() {
        return datasBalcorpname;
    }

    public void setDatasBalcorpname(String datasBalcorpname) {
        this.datasBalcorpname = datasBalcorpname == null ? null : datasBalcorpname.trim();
    }

    public String getDatasOrdercorp() {
        return datasOrdercorp;
    }

    public void setDatasOrdercorp(String datasOrdercorp) {
        this.datasOrdercorp = datasOrdercorp == null ? null : datasOrdercorp.trim();
    }

    public String getDatasOrdercorpname() {
        return datasOrdercorpname;
    }

    public void setDatasOrdercorpname(String datasOrdercorpname) {
        this.datasOrdercorpname = datasOrdercorpname == null ? null : datasOrdercorpname.trim();
    }

    public BigDecimal getGoodsMinnum() {
        return goodsMinnum;
    }

    public void setGoodsMinnum(BigDecimal goodsMinnum) {
        this.goodsMinnum = goodsMinnum;
    }

    public BigDecimal getGoodsInprice() {
        return goodsInprice;
    }

    public void setGoodsInprice(BigDecimal goodsInprice) {
        this.goodsInprice = goodsInprice;
    }

    public BigDecimal getGoodsInfeeprice() {
        return goodsInfeeprice;
    }

    public void setGoodsInfeeprice(BigDecimal goodsInfeeprice) {
        this.goodsInfeeprice = goodsInfeeprice;
    }

    public BigDecimal getGoodsNewinprice() {
        return goodsNewinprice;
    }

    public void setGoodsNewinprice(BigDecimal goodsNewinprice) {
        this.goodsNewinprice = goodsNewinprice;
    }

    public BigDecimal getGoodsNewinfeeprice() {
        return goodsNewinfeeprice;
    }

    public void setGoodsNewinfeeprice(BigDecimal goodsNewinfeeprice) {
        this.goodsNewinfeeprice = goodsNewinfeeprice;
    }

    public BigDecimal getGoodsTaxrate() {
        return goodsTaxrate;
    }

    public void setGoodsTaxrate(BigDecimal goodsTaxrate) {
        this.goodsTaxrate = goodsTaxrate;
    }

    public BigDecimal getGoodsFulfill() {
        return goodsFulfill;
    }

    public void setGoodsFulfill(BigDecimal goodsFulfill) {
        this.goodsFulfill = goodsFulfill;
    }

    public BigDecimal getDataInnerflag() {
        return dataInnerflag;
    }

    public void setDataInnerflag(BigDecimal dataInnerflag) {
        this.dataInnerflag = dataInnerflag;
    }

    public String getGoodsRemark() {
        return goodsRemark;
    }

    public void setGoodsRemark(String goodsRemark) {
        this.goodsRemark = goodsRemark == null ? null : goodsRemark.trim();
    }

    public BigDecimal getDataVernum() {
        return dataVernum;
    }

    public void setDataVernum(BigDecimal dataVernum) {
        this.dataVernum = dataVernum;
    }

    public String getBilltypeCode() {
        return billtypeCode;
    }

    public void setBilltypeCode(String billtypeCode) {
        this.billtypeCode = billtypeCode == null ? null : billtypeCode.trim();
    }

    public String getSumgoodsBatch() {
        return sumgoodsBatch;
    }

    public void setSumgoodsBatch(String sumgoodsBatch) {
        this.sumgoodsBatch = sumgoodsBatch == null ? null : sumgoodsBatch.trim();
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode == null ? null : warehouseCode.trim();
    }

    public String getGoodstreeCode() {
        return goodstreeCode;
    }

    public void setGoodstreeCode(String goodstreeCode) {
        this.goodstreeCode = goodstreeCode == null ? null : goodstreeCode.trim();
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

    public String getGoodsContract() {
        return goodsContract;
    }

    public void setGoodsContract(String goodsContract) {
        this.goodsContract = goodsContract == null ? null : goodsContract.trim();
    }

    public String getGoodsContractbatch() {
        return goodsContractbatch;
    }

    public void setGoodsContractbatch(String goodsContractbatch) {
        this.goodsContractbatch = goodsContractbatch == null ? null : goodsContractbatch.trim();
    }

    public String getGoodsContractstr1() {
        return goodsContractstr1;
    }

    public void setGoodsContractstr1(String goodsContractstr1) {
        this.goodsContractstr1 = goodsContractstr1 == null ? null : goodsContractstr1.trim();
    }

    public String getGoodsContractstr2() {
        return goodsContractstr2;
    }

    public void setGoodsContractstr2(String goodsContractstr2) {
        this.goodsContractstr2 = goodsContractstr2 == null ? null : goodsContractstr2.trim();
    }

    public String getGoodsContractstr3() {
        return goodsContractstr3;
    }

    public void setGoodsContractstr3(String goodsContractstr3) {
        this.goodsContractstr3 = goodsContractstr3 == null ? null : goodsContractstr3.trim();
    }

    public String getGoodsContractstr4() {
        return goodsContractstr4;
    }

    public void setGoodsContractstr4(String goodsContractstr4) {
        this.goodsContractstr4 = goodsContractstr4 == null ? null : goodsContractstr4.trim();
    }

    public String getGoodsContractstr5() {
        return goodsContractstr5;
    }

    public void setGoodsContractstr5(String goodsContractstr5) {
        this.goodsContractstr5 = goodsContractstr5 == null ? null : goodsContractstr5.trim();
    }

    public String getGoodsEntrybatch() {
        return goodsEntrybatch;
    }

    public void setGoodsEntrybatch(String goodsEntrybatch) {
        this.goodsEntrybatch = goodsEntrybatch == null ? null : goodsEntrybatch.trim();
    }

    public String getGoodsEntrybatchold() {
        return goodsEntrybatchold;
    }

    public void setGoodsEntrybatchold(String goodsEntrybatchold) {
        this.goodsEntrybatchold = goodsEntrybatchold == null ? null : goodsEntrybatchold.trim();
    }

    public String getGoodsEntrystr1() {
        return goodsEntrystr1;
    }

    public void setGoodsEntrystr1(String goodsEntrystr1) {
        this.goodsEntrystr1 = goodsEntrystr1 == null ? null : goodsEntrystr1.trim();
    }

    public String getGoodsEntrystr2() {
        return goodsEntrystr2;
    }

    public void setGoodsEntrystr2(String goodsEntrystr2) {
        this.goodsEntrystr2 = goodsEntrystr2 == null ? null : goodsEntrystr2.trim();
    }

    public String getGoodsEntrystr3() {
        return goodsEntrystr3;
    }

    public void setGoodsEntrystr3(String goodsEntrystr3) {
        this.goodsEntrystr3 = goodsEntrystr3 == null ? null : goodsEntrystr3.trim();
    }

    public String getGoodsEntrystr4() {
        return goodsEntrystr4;
    }

    public void setGoodsEntrystr4(String goodsEntrystr4) {
        this.goodsEntrystr4 = goodsEntrystr4 == null ? null : goodsEntrystr4.trim();
    }

    public String getGoodsEntrystr5() {
        return goodsEntrystr5;
    }

    public void setGoodsEntrystr5(String goodsEntrystr5) {
        this.goodsEntrystr5 = goodsEntrystr5 == null ? null : goodsEntrystr5.trim();
    }

    public String getGoodsCodebillold() {
        return goodsCodebillold;
    }

    public void setGoodsCodebillold(String goodsCodebillold) {
        this.goodsCodebillold = goodsCodebillold == null ? null : goodsCodebillold.trim();
    }

    public String getGoodsCodestr1() {
        return goodsCodestr1;
    }

    public void setGoodsCodestr1(String goodsCodestr1) {
        this.goodsCodestr1 = goodsCodestr1 == null ? null : goodsCodestr1.trim();
    }

    public String getGoodsCodestr2() {
        return goodsCodestr2;
    }

    public void setGoodsCodestr2(String goodsCodestr2) {
        this.goodsCodestr2 = goodsCodestr2 == null ? null : goodsCodestr2.trim();
    }

    public String getGoodsCodestr3() {
        return goodsCodestr3;
    }

    public void setGoodsCodestr3(String goodsCodestr3) {
        this.goodsCodestr3 = goodsCodestr3 == null ? null : goodsCodestr3.trim();
    }

    public String getGoodsCodestr4() {
        return goodsCodestr4;
    }

    public void setGoodsCodestr4(String goodsCodestr4) {
        this.goodsCodestr4 = goodsCodestr4 == null ? null : goodsCodestr4.trim();
    }

    public String getGoodsCodestr5() {
        return goodsCodestr5;
    }

    public void setGoodsCodestr5(String goodsCodestr5) {
        this.goodsCodestr5 = goodsCodestr5 == null ? null : goodsCodestr5.trim();
    }

    public String getGoodsCodestr6() {
        return goodsCodestr6;
    }

    public void setGoodsCodestr6(String goodsCodestr6) {
        this.goodsCodestr6 = goodsCodestr6 == null ? null : goodsCodestr6.trim();
    }

    public String getGoodsCodestr7() {
        return goodsCodestr7;
    }

    public void setGoodsCodestr7(String goodsCodestr7) {
        this.goodsCodestr7 = goodsCodestr7 == null ? null : goodsCodestr7.trim();
    }

    public String getGoodsCodestr8() {
        return goodsCodestr8;
    }

    public void setGoodsCodestr8(String goodsCodestr8) {
        this.goodsCodestr8 = goodsCodestr8 == null ? null : goodsCodestr8.trim();
    }

    public String getGoodsCodestr9() {
        return goodsCodestr9;
    }

    public void setGoodsCodestr9(String goodsCodestr9) {
        this.goodsCodestr9 = goodsCodestr9 == null ? null : goodsCodestr9.trim();
    }

    public String getGoodsCodestr10() {
        return goodsCodestr10;
    }

    public void setGoodsCodestr10(String goodsCodestr10) {
        this.goodsCodestr10 = goodsCodestr10 == null ? null : goodsCodestr10.trim();
    }

    public BigDecimal getGoodsCodenum1() {
        return goodsCodenum1;
    }

    public void setGoodsCodenum1(BigDecimal goodsCodenum1) {
        this.goodsCodenum1 = goodsCodenum1;
    }

    public BigDecimal getGoodsCodenum2() {
        return goodsCodenum2;
    }

    public void setGoodsCodenum2(BigDecimal goodsCodenum2) {
        this.goodsCodenum2 = goodsCodenum2;
    }

    public BigDecimal getGoodsCodenum3() {
        return goodsCodenum3;
    }

    public void setGoodsCodenum3(BigDecimal goodsCodenum3) {
        this.goodsCodenum3 = goodsCodenum3;
    }

    public BigDecimal getPartsnameSplit() {
        return partsnameSplit;
    }

    public void setPartsnameSplit(BigDecimal partsnameSplit) {
        this.partsnameSplit = partsnameSplit;
    }

    public String getGoodsProperty() {
        return goodsProperty;
    }

    public void setGoodsProperty(String goodsProperty) {
        this.goodsProperty = goodsProperty == null ? null : goodsProperty.trim();
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

    public String getGoodsOrg() {
        return goodsOrg;
    }

    public void setGoodsOrg(String goodsOrg) {
        this.goodsOrg = goodsOrg == null ? null : goodsOrg.trim();
    }

    public String getGoodsDept() {
        return goodsDept;
    }

    public void setGoodsDept(String goodsDept) {
        this.goodsDept = goodsDept == null ? null : goodsDept.trim();
    }

    public String getGoodsCurrency() {
        return goodsCurrency;
    }

    public void setGoodsCurrency(String goodsCurrency) {
        this.goodsCurrency = goodsCurrency == null ? null : goodsCurrency.trim();
    }

    public BigDecimal getGoodsExrate() {
        return goodsExrate;
    }

    public void setGoodsExrate(BigDecimal goodsExrate) {
        this.goodsExrate = goodsExrate;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
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

    public String getGoodsCustomscode() {
        return goodsCustomscode;
    }

    public void setGoodsCustomscode(String goodsCustomscode) {
        this.goodsCustomscode = goodsCustomscode == null ? null : goodsCustomscode.trim();
    }

    public String getGoodsEnname() {
        return goodsEnname;
    }

    public void setGoodsEnname(String goodsEnname) {
        this.goodsEnname = goodsEnname == null ? null : goodsEnname.trim();
    }

    public String getGoodsEndescribe() {
        return goodsEndescribe;
    }

    public void setGoodsEndescribe(String goodsEndescribe) {
        this.goodsEndescribe = goodsEndescribe == null ? null : goodsEndescribe.trim();
    }

    public String getGoodsBatch() {
        return goodsBatch;
    }

    public void setGoodsBatch(String goodsBatch) {
        this.goodsBatch = goodsBatch == null ? null : goodsBatch.trim();
    }

    public String getGoodsIndustry() {
        return goodsIndustry;
    }

    public void setGoodsIndustry(String goodsIndustry) {
        this.goodsIndustry = goodsIndustry == null ? null : goodsIndustry.trim();
    }

    public BigDecimal getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(BigDecimal goodsNum) {
        this.goodsNum = goodsNum;
    }

    public BigDecimal getGoodsPiecenum() {
        return goodsPiecenum;
    }

    public void setGoodsPiecenum(BigDecimal goodsPiecenum) {
        this.goodsPiecenum = goodsPiecenum;
    }

    public BigDecimal getGoodsSingernum() {
        return goodsSingernum;
    }

    public void setGoodsSingernum(BigDecimal goodsSingernum) {
        this.goodsSingernum = goodsSingernum;
    }

    public BigDecimal getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(BigDecimal goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public BigDecimal getGoodsAssistweight() {
        return goodsAssistweight;
    }

    public void setGoodsAssistweight(BigDecimal goodsAssistweight) {
        this.goodsAssistweight = goodsAssistweight;
    }

    public String getGoodsWmscodebill() {
        return goodsWmscodebill;
    }

    public void setGoodsWmscodebill(String goodsWmscodebill) {
        this.goodsWmscodebill = goodsWmscodebill == null ? null : goodsWmscodebill.trim();
    }
}