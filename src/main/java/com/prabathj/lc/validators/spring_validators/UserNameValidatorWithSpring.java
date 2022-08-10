package com.prabathj.lc.validators.spring_validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.prabathj.lc.dtomodels.RegistrationInfoDTO;

public class UserNameValidatorWithSpring implements Validator {

	//This method check whether the passed class can be applied to the validation
	//we make sure the passed object is RegistrationInfoDTO object and call the validate()
	//if not ignore
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return RegistrationInfoDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "RegistrationInfoDTO.userName.empty", "User Name cannot be empty");

		RegistrationInfoDTO obj=(RegistrationInfoDTO)target;
		
		if(!obj.getUserName().startsWith("SL_")){
			
			errors.rejectValue("userName", "RegistrationInfoDTO.userName.NotContain","Srart with SL_");
		}
		
	}

}
