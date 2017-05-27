package com.xyscm.sys.basic.cas.model;

import java.math.BigDecimal;

public class VPermissionAllot {
    private String vId;

    private String permissionCode;

    private String permissionName;

    private String applicationCode;

    private String menuCode;

    private String menuModule;

    private BigDecimal permissionSort;

    private BigDecimal permissionShowinmenu;

    private BigDecimal permissionState;

    private BigDecimal permissionOrder;

    private String permissionRemark;

    private String menuNodecode;

    private BigDecimal permissionType;

    private String billtypeCode;

    private String memberCode;

    private String operatorCode;

    private String orgCode;

    private String deptCode;

    private String operatorUser;

    private String roleCodelist;

    private BigDecimal operatorState;

    private BigDecimal operatorIdentity;

    private BigDecimal opPermissionAllot;

    private BigDecimal roPermissionAllot;

    public String getvId() {
        return vId;
    }

    public void setvId(String vId) {
        this.vId = vId == null ? null : vId.trim();
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getApplicationCode() {
        return applicationCode;
    }

    public void setApplicationCode(String applicationCode) {
        this.applicationCode = applicationCode == null ? null : applicationCode.trim();
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode == null ? null : menuCode.trim();
    }

    public String getMenuModule() {
        return menuModule;
    }

    public void setMenuModule(String menuModule) {
        this.menuModule = menuModule == null ? null : menuModule.trim();
    }

    public BigDecimal getPermissionSort() {
        return permissionSort;
    }

    public void setPermissionSort(BigDecimal permissionSort) {
        this.permissionSort = permissionSort;
    }

    public BigDecimal getPermissionShowinmenu() {
        return permissionShowinmenu;
    }

    public void setPermissionShowinmenu(BigDecimal permissionShowinmenu) {
        this.permissionShowinmenu = permissionShowinmenu;
    }

    public BigDecimal getPermissionState() {
        return permissionState;
    }

    public void setPermissionState(BigDecimal permissionState) {
        this.permissionState = permissionState;
    }

    public BigDecimal getPermissionOrder() {
        return permissionOrder;
    }

    public void setPermissionOrder(BigDecimal permissionOrder) {
        this.permissionOrder = permissionOrder;
    }

    public String getPermissionRemark() {
        return permissionRemark;
    }

    public void setPermissionRemark(String permissionRemark) {
        this.permissionRemark = permissionRemark == null ? null : permissionRemark.trim();
    }

    public String getMenuNodecode() {
        return menuNodecode;
    }

    public void setMenuNodecode(String menuNodecode) {
        this.menuNodecode = menuNodecode == null ? null : menuNodecode.trim();
    }

    public BigDecimal getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(BigDecimal permissionType) {
        this.permissionType = permissionType;
    }

    public String getBilltypeCode() {
        return billtypeCode;
    }

    public void setBilltypeCode(String billtypeCode) {
        this.billtypeCode = billtypeCode == null ? null : billtypeCode.trim();
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode == null ? null : memberCode.trim();
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode == null ? null : operatorCode.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getOperatorUser() {
        return operatorUser;
    }

    public void setOperatorUser(String operatorUser) {
        this.operatorUser = operatorUser == null ? null : operatorUser.trim();
    }

    public String getRoleCodelist() {
        return roleCodelist;
    }

    public void setRoleCodelist(String roleCodelist) {
        this.roleCodelist = roleCodelist == null ? null : roleCodelist.trim();
    }

    public BigDecimal getOperatorState() {
        return operatorState;
    }

    public void setOperatorState(BigDecimal operatorState) {
        this.operatorState = operatorState;
    }

    public BigDecimal getOperatorIdentity() {
        return operatorIdentity;
    }

    public void setOperatorIdentity(BigDecimal operatorIdentity) {
        this.operatorIdentity = operatorIdentity;
    }

    public BigDecimal getOpPermissionAllot() {
        return opPermissionAllot;
    }

    public void setOpPermissionAllot(BigDecimal opPermissionAllot) {
        this.opPermissionAllot = opPermissionAllot;
    }

    public BigDecimal getRoPermissionAllot() {
        return roPermissionAllot;
    }

    public void setRoPermissionAllot(BigDecimal roPermissionAllot) {
        this.roPermissionAllot = roPermissionAllot;
    }
}