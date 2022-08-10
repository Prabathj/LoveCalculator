package com.prabathj.lc.controllers;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prabathj.lc.dtomodels.RegistrationInfoDTO;
import com.prabathj.lc.dtomodels.support.CommunicationDto;
import com.prabathj.lc.dtomodels.support.MobileNumberDto;
import com.prabathj.lc.propertyeditors.NamePropertyEditor;
import com.prabathj.lc.validators.spring_validators.UserNameValidatorWithSpring;

@Controller
public class LCUserRegistationController {

	//At this stage No need of @ModelAttribute if you are not to write data to the form, 
	//but for the learning purpose of Spring MVC tags we pass @ModelAttribute
	
	@RequestMapping("/register")
	public String userRegistration(@ModelAttribute("regInfo") RegistrationInfoDTO regDTO) {
		
		//If we want to set default values to the form fields after fetching from DB we can set them here
		//If we want to add default phone number 
		MobileNumberDto mobile=new MobileNumberDto();
		mobile.setCountryCode("94");
		mobile.setMobileNum("714572650");
		CommunicationDto comminfo=new CommunicationDto();
		comminfo.setuMobileNum(mobile);
		regDTO.setCommInfo(comminfo);
		regDTO.setName("Danush");
		
		return "user-registation-page";
	}
	
	@RequestMapping("/process-registration")
	public String processRegistraion(@Valid @ModelAttribute("regInfo") RegistrationInfoDTO regD,BindingResult errors) {
		System.out.println("Inside Mapper");
		if(errors.hasErrors()) {
			regD.getCommInfo().getuMobileNum().setFlag(1);
			//regD.getCommInfo().getuMobileNum().setCountryCode("");
			//regD.getCommInfo().getuMobileNum().setMobileNum(regD.getCommInfo().getuMobileNum().getOrginalString());
			return "user-registation-page";
		}
		
		return "registration-confirm";
	}
	//@InitBinder instance is attached to a model attribute / request parameter so this will call at many time model attribute/ request parameters called
	//@InitBinder instance does not created for @RequestBody
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("Inside InitBinder");

		//To trim the 'name' field -> can use on reference class fields eg 'commInfo.uEmail'
		StringTrimmerEditor trimmer=new StringTrimmerEditor(false);
		binder.registerCustomEditor(String.class, "name", trimmer);
		//binder.registerCustomEditor(String.class, "commInfo.uEmail", trimmer);
		
		//apply this property editor to all String type fields including reference classes
		//binder.registerCustomEditor(String.class,trimmer);
		
		//Customed property editor to get Upper characters for the field 'name'
		NamePropertyEditor upper=new NamePropertyEditor();
		binder.registerCustomEditor(String.class,"name", upper);
		
		//Register a customed validator
		binder.addValidators(new UserNameValidatorWithSpring());

	}
	
}

