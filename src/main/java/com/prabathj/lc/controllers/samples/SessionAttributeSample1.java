package com.prabathj.lc.controllers.samples;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class SessionAttributeSample1 {
	/*
	Here when request come from 'third' the "fname" & "sname" are set in SESSION unless 'SessionStatus.setComplete()' called
	Then automatically copying as attributes of Model 'modelFo' by Spring will not be apply as this controller is out of the conversational scope
	*/
	@RequestMapping("/fourth")
	public String firstPage(Model modelFo,HttpSession httpSession) {
//		modelFo.addAttribute("fname", "prabath");
//		modelFo.addAttribute("sname", "Jayarathne");
		
		System.out.println("modelFo.fname: "+modelFo.getAttribute("fname"));
		System.out.println("modelFo.sname: "+modelFo.getAttribute("sname"));	
		
		System.out.println("session.fname: "+httpSession.getAttribute("fname"));
		System.out.println("session.sname: "+httpSession.getAttribute("sname"));			
		
		System.out.println("session.nfname: "+httpSession.getAttribute("nfname"));
		System.out.println("session.nsname: "+httpSession.getAttribute("nsname"));			
		
		return "fourth";
	}	
	
	//We can access a Conventional scope attribute from out side of the conventional scope using '@SessionAttribute'
	//Spring don't recommend this as it is outside of the SCOPE
	
	@RequestMapping("/fourth-a")
	public String firstPage_a(Model modelFo,HttpSession httpSession,@SessionAttribute("fname") String fnameOfSessionAttribute) {
//		modelFo.addAttribute("fname", "prabath");
//		modelFo.addAttribute("sname", "Jayarathne");
				
		return "fourth";
	}	
	
	
}
