package com.prabathj.lc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prabathj.lc.dtomodels.FeedBackDto;

@Controller
public class FeedBackController {

	@RequestMapping("/sendFeedBack")
	public String processFeedback(@Valid @ModelAttribute("feedBackInfo") FeedBackDto feedbackData,BindingResult erros){
		
		if(erros.hasErrors()) {
			return "email-result";
		}
		
		//Save FeedBack into the DB
		
		return "feedback-result";
	}
	
}
