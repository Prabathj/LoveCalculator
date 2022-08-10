package com.prabathj.lc.dtomodels.support;

public class CreditCardDto {
	
	private String ccFirst;
	private String ccSecond;
	private String ccThird;
	private String ccFourth;
	public String getCcFirst() {
		return ccFirst;
	}
	public void setCcFirst(String ccFirst) {
		this.ccFirst = ccFirst;
	}
	public String getCcSecond() {
		return ccSecond;
	}
	public void setCcSecond(String ccSecond) {
		this.ccSecond = ccSecond;
	}
	public String getCcThird() {
		return ccThird;
	}
	public void setCcThird(String ccThird) {
		this.ccThird = ccThird;
	}
	public String getCcFourth() {
		return ccFourth;
	}
	public void setCcFourth(String ccFourth) {
		this.ccFourth = ccFourth;
	}
	@Override
	public String toString() {
		
		return ccFirst+"-"+ccSecond +"-"+ccThird+"-" + ccFourth;
	}
	
	

}
