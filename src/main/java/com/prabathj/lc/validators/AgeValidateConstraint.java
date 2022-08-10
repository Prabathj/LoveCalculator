package com.prabathj.lc.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidateConstraint implements ConstraintValidator<Age, Integer> {

	private int max;
	private int min;
	
	public void initialize(Age age) {
		this.min=age.min();
		this.max=age.max();
	}

	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		
		if(value==null)
			return false;
		if(value<min || value>max)
			return false;
		else
			return true;

	}

}
