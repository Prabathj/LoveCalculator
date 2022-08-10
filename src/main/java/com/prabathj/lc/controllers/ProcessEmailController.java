package com.prabathj.lc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prabathj.lc.dtomodels.EmailDto;
import com.prabathj.lc.dtomodels.FeedBackDto;
import com.prabathj.lc.services.LCSendEmailServiceInterface;

@Controller
public class ProcessEmailController {

	@Autowired
	private LCSendEmailServiceInterface sendEmailImpl;
	
	@RequestMapping("/send-email")
	public String startEmailProcess(@ModelAttribute("emailDetails") EmailDto emailDto){
		
		return "email-info";
	}
	
	@RequestMapping("/process-email")
	public String processEmail(@ModelAttribute("emailDetails") EmailDto emailDto,@ModelAttribute("feedBackInfo") FeedBackDto feedbackData, HttpSession session){
		String userN=(String) session.getAttribute("userName");
		//sendEmailImpl.processEmail(userN, emailDto.getEmailId(), (String) session.getAttribute("relationship"));
		
		return "email-result";
	}
}
