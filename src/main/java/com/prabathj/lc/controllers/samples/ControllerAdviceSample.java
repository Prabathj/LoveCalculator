package com.prabathj.lc.controllers.samples;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prabathj.lc.dtomodels.EmailDto;

@Controller
public class ControllerAdviceSample {

	@RequestMapping("email-home")
	public String getEmailPage(@ModelAttribute("emailDetails") EmailDto emailInfo){
		System.out.println("Inside getEmailPage");		
		return "email-info-sample";
	}
	
	@RequestMapping("process-email-ca")
	public String processEmail(@ModelAttribute("emailinfo") EmailDto emailInfo,Model modelS){
		System.out.println("Inside processEmail()");
		if(emailInfo.getEmailId().equals("pra@gmail.com")) {
			throw new NullPointerException();
		}
		
		return "sample-result";
	}
	
	
	//InitBinder method will not be called for this mapping handler method as it does not call any @MethodAttribute/ @RequestPram
	@RequestMapping("email-test")
	public String getEmailPage(){
		System.out.println("Inside getEmailPage");		
		return "sample-result";
	}	
}
