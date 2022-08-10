package com.prabathj.lc.validators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy= {PhoneValidateConstrainte.class})
@Retention(RUNTIME)
@Target(FIELD)
public @interface Phone {

	int size() default 11;
	
	String message() default "{phone-valid-msg}";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };		
} 
