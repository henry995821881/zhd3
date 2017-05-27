package com.xyscm.sys.basic.vo;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import com.xyscm.sys.basic.common.validatedGroup.SaveGroup;
import com.xyscm.sys.basic.common.validatedGroup.UpdateGroup;

public class CombineCompanyVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String oldCompanyCode;
	
	private String oldCompanyName;
	
	private String oldCompanyId;

	private String newCompanyCode;

    @NotEmpty(message="合并的目标公司名不能为空",groups={UpdateGroup.class})	
	private String newCompanyName;

	public String getOldCompanyCode() {
		return oldCompanyCode;
	}

	public void setOldCompanyCode(String oldCompanyCode) {
		this.oldCompanyCode = oldCompanyCode;
	}

	public String getOldCompanyName() {
		return oldCompanyName;
	}

	public void setOldCompanyName(String oldCompanyName) {
		this.oldCompanyName = oldCompanyName;
	}

	public String getNewCompanyCode() {
		return newCompanyCode;
	}

	public void setNewCompanyCode(String newCompanyCode) {
		this.newCompanyCode = newCompanyCode;
	}

	public String getNewCompanyName() {
		return newCompanyName;
	}

	public void setNewCompanyName(String newCompanyName) {
		this.newCompanyName = newCompanyName;
	}

	public String getOldCompanyId() {
		return oldCompanyId;
	}

	public void setOldCompanyId(String oldCompanyId) {
		this.oldCompanyId = oldCompanyId;
	}

	@Override
	public String toString() {
		return "CombineCompanyVo [oldCompanyCode=" + oldCompanyCode
				+ ", oldCompanyName=" + oldCompanyName + ", oldCompanyId="
				+ oldCompanyId + ", newCompanyCode=" + newCompanyCode
				+ ", newCompanyName=" + newCompanyName + "]";
	}

	
}
