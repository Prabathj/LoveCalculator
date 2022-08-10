package com.prabathj.lc.dtomodels.support;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.prabathj.lc.validators.Email;
import com.prabathj.lc.validators.Phone;

public class CommunicationDto {

	@Email
	private String uEmail;
	@Phone
	private MobileNumberDto uMobileNum;
	
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public MobileNumberDto getuMobileNum() {
		return uMobileNum;
	}
	public void setuMobileNum(MobileNumberDto uMobileNum) {
		this.uMobileNum = uMobileNum;
	}
	
}
