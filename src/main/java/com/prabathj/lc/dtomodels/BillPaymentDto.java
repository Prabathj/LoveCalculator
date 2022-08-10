package com.prabathj.lc.dtomodels;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

import org.springframework.format.annotation.DateTimeFormat;

import com.prabathj.lc.dtomodels.support.CreditCardDto;
import com.prabathj.lc.dtomodels.support.CurrencyInfoDTO;

public class BillPaymentDto {

	private CreditCardDto ccNo;
	private CurrencyInfoDTO  ammountInfo;
	private Currency currencyCode;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate billDate;
	private BigDecimal ammount;
	
	public CreditCardDto getCcNo() {
		return ccNo;
	}
	public void setCcNo(CreditCardDto ccNo) {
		this.ccNo = ccNo;
	}
	public CurrencyInfoDTO getAmmountInfo() {
		return ammountInfo;
	}
	public void setAmmountInfo(CurrencyInfoDTO ammountInfo) {
		this.ammountInfo = ammountInfo;
	}
	public Currency getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(Currency currencyCode) {
		this.currencyCode = currencyCode;
	}
	public LocalDate getBillDate() {
		return billDate;
	}
	public void setBillDate(LocalDate billDae) {
		this.billDate = billDae;
	}
	public BigDecimal getAmmount() {
		return ammount;
	}
	public void setAmmount(BigDecimal ammount) {
		this.ammount = ammount;
	}
	
	
}
