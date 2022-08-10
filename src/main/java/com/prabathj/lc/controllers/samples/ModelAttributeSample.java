package com.prabathj.lc.controllers.samples;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.prabathj.lc.dtomodels.support.ModelAttributeDTO;


//How 
//Why  - When there are common attribute need to set to model
//When - when Working with both @SessionAttributes + @ModelAttribute

@Controller
//@SessionAttributes({"modelMethodLevel"})
//getModel() is called for each request comes to this controller in order to access getModel() from outside controllers
//we can specify @ControllerAdvice()
//@ControllerAdvice(basePackageClasses= {SessionAttributeSample.class})
public class ModelAttributeSample {
	
	//This will be called for every request of this controller before any request handler method.
	//if @SessionAttributes({"modelMethodLevel"}) is specified then the calling of this method will happen only one time
	//no call for every request as [ModelAttributeDTO modelMethodLevel] object is available in CONVERSATIONAL scope
	@ModelAttribute("modelMethodLevel")
	public ModelAttributeDTO getModel() {
		System.out.println("Inside getModel()");
		ModelAttributeDTO modelDto=new ModelAttributeDTO();
		modelDto.setCourseName("Java");
		modelDto.setCourseType("Learning");		
		return modelDto;
	}
	
	@ModelAttribute("webHeader")
	public String getHeader() {
		
		return "Header is NULL";
	}
	
	
	//If the @ModelAttribute qualifier ["modelAttr"] not equal then The return DTO ["modelMethodLevel"] from 'getModel()' will not be set as attribute 
	//to the Model of the request handler method ('modelAttributeFirst()')	
	//It will create its own object
	//Now two objects of ModelAttributeDTO exists in Model container with REQUEST scope
	//All the attributes of the REQUEST scope will automatically copied as attributes of Model  by Spring
	//now [webHeader], ["modelAttr"] & ["modelMethodLevel"] will be available in the Model
	
	@RequestMapping("modelfirst")
	public String modelAttributeFirst(@ModelAttribute("modelAttr") ModelAttributeDTO modelDto){
		
		modelDto.setCourseName("Spring");
		modelDto.setCourseType("Learning");
		
		return "modelfirst";
	}

	//If the @ModelAttribute qualifier ["modelMethodLevel"]  equal then The return DTO ["modelMethodLevel"] from 'getModel()' will be set as attribute 
	//to the Model of the request handler method ('modelAttributeSecond()')	
	//Now only one object of ModelAttributeDTO exists in IOC with REQUEST scope	
	
	@RequestMapping("modelsecond")
	public String modelAttributeSecond(@ModelAttribute("modelMethodLevel") ModelAttributeDTO modelDto){
		modelDto.setCourseName("Spring-Boot");
		modelDto.setCourseType("Learning");		
		return "modelSecond";
	}	
	
	//The return DTO from 'getModel()' will be set as attribute to the Model of the request handler method ('modelAttributeThird()')
	//Now two objects are available with request scope 
	
	@RequestMapping("modelthird")
	public String modelAttributeThird(Model modelDto,ModelAttributeDTO modelTestDto){
		
		return "modelthird";
	}		
}
