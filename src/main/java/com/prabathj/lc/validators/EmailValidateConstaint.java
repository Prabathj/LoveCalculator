package com.prabathj.lc.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.prabathj.lc.dtomodels.support.CommunicationDto;

public class EmailValidateConstaint implements ConstraintValidator<Email, String> {

	private String sufix_msg;

	@Override
	public void initialize(Email email) {
		this.sufix_msg=email.sufix();
	}


	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		
		if(email==null)
			return false;
		else { 
			
			if(email.endsWith(sufix_msg))
				return true;
			else
				return false;
		}

	}
	

}
