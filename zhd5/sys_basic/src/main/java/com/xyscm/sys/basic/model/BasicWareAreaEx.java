package com.xyscm.sys.basic.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BasicWareAreaEx extends BasicWareArea implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 仓库名
	 */
	 private String warehouseName;

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
		
	}

	@Override
	public String toString() {
		
		return super.toString()+"BasicWareAreaEx [warehouseName=" + warehouseName + "]";
		//return "BasicWareAreaEx [warehouseName=" + warehouseName + "]";
	}

	


  
	 
	 
	 
}