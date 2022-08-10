package com.prabathj.lc.dtomodels.support;

import javax.validation.constraints.NotNull;

public class MobileNumberDto {
	
	private String countryCode;
	private String mobileNum;
	private String orginalString;
	private int flag=0;
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	
	public String getOrginalString() {
		return orginalString;
	}
	public void setOrginalString(String orginalString) {
		this.orginalString = orginalString;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		if(flag==0)
			return this.getCountryCode()+ "-"+this.getMobileNum();
		else
			return this.getOrginalString();
	}
}
