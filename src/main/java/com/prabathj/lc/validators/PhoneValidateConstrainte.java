package com.prabathj.lc.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.prabathj.lc.dtomodels.support.MobileNumberDto;

public class PhoneValidateConstrainte implements ConstraintValidator<Phone, MobileNumberDto> {

	private int size;
	
	@Override
	public void initialize(Phone phone) {
		// TODO Auto-generated method stub
		this.size=phone.size();
	}

	@Override
	public boolean isValid(MobileNumberDto phone, ConstraintValidatorContext context) {
		
		if(phone==null)
			return false;
		else if((phone.getCountryCode().length()+phone.getMobileNum().length()) !=size)
			return false;
		else if(phone.getCountryCode().matches("[0-9]+") && phone.getMobileNum().matches("[0-9]+"))
			return true;
		else
			return false;
	}

}
