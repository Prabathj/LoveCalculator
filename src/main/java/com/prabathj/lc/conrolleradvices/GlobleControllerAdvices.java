package com.prabathj.lc.conrolleradvices;

import java.io.IOException;

import org.springframework.beans.propertyeditors.CharArrayPropertyEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.prabathj.lc.controllers.samples.ControllerAdviceSample;
import com.prabathj.lc.dtomodels.support.ModelAttributeDTO;
import com.prabathj.lc.propertyeditors.sample.EmailPropertyEditorCA;

/*With this, the GlobleControllerAdvices.class is available for the component scan and can be used to register
	*@ModelAttributes
	*@ExceptionHandlers
	*@InitBinder
  In different levels [globally/class/package]
*/

@ControllerAdvice(assignableTypes= ControllerAdviceSample.class)
public class GlobleControllerAdvices {

	//Exception processing Order is like a try catch  block
	/* try{   
	  
	   }catch(NullPointerException.class)
			NullPointerExceptionHandler()
		  catch(IOException.class)
			IOExceptionHandler()
		  catch(Exception.class)
			CommanExceptionHandlerSample()
	
	*/
		  
	@ExceptionHandler(NullPointerException.class)
	public String NullPointerExceptionHandler(){
		System.out.println("Inside NullPointerExceptionHandler()");
		return "exception-handler";
	} 
	
	@ExceptionHandler({IOException.class,IndexOutOfBoundsException.class})
	public String IOExceptionHandler(){
		System.out.println("Inside IOExceptionHandler()");
		return "exception-handler";
	} 	
	//Cannot have only @ExceptionHandler need to specify the Exception either in method parameters/ as a @ExeprionHandler(exception)
	@ExceptionHandler(Exception.class)
	public String CommanExceptionHandlerSample() {
		System.out.println("Inside CommanExceptionHandler()");
		return "exception-handler";		
	}
	
	//Create @InitBinder instance  for this model attribute
	@ModelAttribute("globleDto")
	public ModelAttributeDTO getGlobleModel(){
		System.out.println("Inside getGlobleModel()");
		ModelAttributeDTO modelDto=new ModelAttributeDTO();
		modelDto.setCourseName("Java");
		modelDto.setCourseType("Learning");		
		return modelDto;
	}
	
	@InitBinder
	public void InitBinderMethod(WebDataBinder wbinder){

		System.out.println("Inside Globle INITBINDER");
		EmailPropertyEditorCA emailPE=new EmailPropertyEditorCA();
		wbinder.registerCustomEditor(String.class, "emailId", emailPE);

	}
	
}
