package com.prabathj.lc.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy= {AgeValidateConstraint.class})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Age {

	int max() default 60;
	int min() default 30;
	
	String message() default "This field should be {min} - {max}";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };	
}
