package com.xyscm.sys.basic.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class BasicDd implements Serializable{
    private BigDecimal ddId;

    private String memberCode;

    private String ddName;

    private String ddtypeClass;

    private BigDecimal ddNotuse;

    private String ddRemark;

    private BigDecimal basicShare;

    private String ddTypeAccinoutclass;

    private String subjectCode;

    public BigDecimal getDdId() {
        return ddId;
    }

    public void setDdId(BigDecimal ddId) {
        this.ddId = ddId;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode == null ? null : memberCode.trim();
    }

    public String getDdName() {
        return ddName;
    }

    public void setDdName(String ddName) {
        this.ddName = ddName == null ? null : ddName.trim();
    }

    public String getDdtypeClass() {
        return ddtypeClass;
    }

    public void setDdtypeClass(String ddtypeClass) {
        this.ddtypeClass = ddtypeClass == null ? null : ddtypeClass.trim();
    }

    public BigDecimal getDdNotuse() {
        return ddNotuse;
    }

    public void setDdNotuse(BigDecimal ddNotuse) {
        this.ddNotuse = ddNotuse;
    }

    public String getDdRemark() {
        return ddRemark;
    }

    public void setDdRemark(String ddRemark) {
        this.ddRemark = ddRemark == null ? null : ddRemark.trim();
    }

    public BigDecimal getBasicShare() {
        return basicShare;
    }

    public void setBasicShare(BigDecimal basicShare) {
        this.basicShare = basicShare;
    }

    public String getDdTypeAccinoutclass() {
        return ddTypeAccinoutclass;
    }

    public void setDdTypeAccinoutclass(String ddTypeAccinoutclass) {
        this.ddTypeAccinoutclass = ddTypeAccinoutclass == null ? null : ddTypeAccinoutclass.trim();
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode == null ? null : subjectCode.trim();
    }
    
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}