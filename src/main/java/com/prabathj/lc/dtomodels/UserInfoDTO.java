package com.prabathj.lc.dtomodels;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoDTO {
	@NotBlank(message="*User Name should not be blank")
	@Size(min=3,max=15,message="*User Name should have <15,>3 chars")
	private String userName;

	@NotBlank(message="*Crush Name should not be blank")
	@Size(min=3,max=15,message="*Crush Name should have <15,>3 chars")	
	private String crushName;
	
	@AssertTrue(message="Agree to terms and conditions")
	private boolean termsConditions;
	
	private String result;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCrushName() {
		return crushName;
	}
	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}
	
	public boolean isTermsConditions() {
		return termsConditions;
	}
	public void setTermsConditions(boolean termsConditions) {
		this.termsConditions = termsConditions;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	
}
