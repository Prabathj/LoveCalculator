package com.prabathj.lc.dtomodels.support;

import java.math.BigDecimal;

public class CurrencyInfoDTO {

	private BigDecimal billValue;
	private String currencyType;
	
	public BigDecimal getBillValue() {
		return billValue;
	}
	public void setBillValue(BigDecimal billValue) {
		this.billValue = billValue;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	@Override
	public String toString() {
		return currencyType+" "+ billValue.toString();
	}
	
	
}
