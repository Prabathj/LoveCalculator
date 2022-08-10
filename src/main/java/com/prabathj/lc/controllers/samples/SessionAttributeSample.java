package com.prabathj.lc.controllers.samples;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.prabathj.lc.dtomodels.support.ModelAttributeDTO;

@Controller
/*
Can't use [No use of using] @SessionAttributes & @ModelAtttribute at the same time for the same model attribute
This will create conversational scope only for this controller not to the outside ['/fourth'] 
and will set "sampleDto","fname" & "sname" to CONVERSATIONAL scope 
*/
@SessionAttributes({"fname","sname","sampleDto"})
public class SessionAttributeSample {

	//Can use @SessionAttributes & @ModelAtttribute at the same time for any not same model attribute
	//Like @SessionAttributes ->"sampleDto" , @ModelAttribute -> "Test"
	@RequestMapping("/first")
	public String firstPage(Model modelF,ModelAttributeDTO modelDto,@ModelAttribute("Test") ModelAttributeDTO obj) {
		//((ModelAttributeDTO)modelF.getAttribute("Test")).setCourseName("abc");
		//System.out.println(((ModelAttributeDTO)modelF.getAttribute("Test")).getCourseName());
		modelF.addAttribute("fname", "prabath");
		modelF.addAttribute("sname", "Jayarathne");
		modelDto.setCourseName("Spring");
		modelDto.setCourseType("Study");
		modelF.addAttribute("sampleDto", modelDto);
		return "first";
	}
	
	
	//This will throw EXCPETION -> 'Expected session attribute 'sampleDto'
	//Can't use [No use of using] @SessionAttributes & @ModelAtttribute at the same time for the same model attribute 'sampleDto'
/* 	
   public String firstPage(Model modelF,@ModelAttribute("sampleDto") ModelAttributeDTO modelDto) {
		modelF.addAttribute("fname", "prabath");
		modelF.addAttribute("sname", "Jayarathne");
		modelDto.setCourseName("Spring");
		modelDto.setCourseType("Study");
		return "first";
	}
*/
	
	//At this point request come to "/second" from "/first" then in the "/first", "sampleDto","fname" & "sname" are set to conversational scope 
	//Those will automatically copied as attributes of Model 'modelS' by Spring
	//Once the REQUEST scope is ended any modified data will be copied back to conversational scope
	@RequestMapping("/second")
	public String secondPage(Model modelS,SessionStatus sessionStatus,@ModelAttribute("sampleDto") ModelAttributeDTO modelDto,@ModelAttribute("sampleDto2") ModelAttributeDTO modelDto2,
							HttpSession httpSession,ModelAttributeDTO testDto) {
		System.out.println(modelS.getAttribute("fname"));
		System.out.println(modelS.getAttribute("sname"));
		
		//modelS is a copy of the conversational scope attributes, so it already has a  'ModelAttributeDTO' object
		System.out.println(((ModelAttributeDTO)modelS.getAttribute("sampleDto")).getCourseName());
		
		//A new object is not created as a [ModelAttributeDTO sampleDto] object already in the Model [As only one Model is created] it will inject 
		System.out.println(modelDto.getCourseName());
		modelDto.setCourseName("Spring JDBC");
		//A new object is created as a [ModelAttributeDTO sampleDto2] 
		System.out.println(modelDto2.getCourseName());
		
		//This data will be copied back to conversational scope
		modelS.addAttribute("fname", "Upali");
		
		modelDto2.setCourseName("Spring-Boot");
		httpSession.setAttribute("sampleDto2", modelDto2);
		
		//A new ModelAttributeDTO object is created by Spring for the 'testDto'
		testDto.setCourseName("testDTO");
		System.out.println(testDto.getCourseName());
		
		/*
		With 'SessionStatus' we can define the end line of conversational scope, 
		before that conversational scope was whole Controller. Now scope start at '/first' end '/second' 
		remove data from SESSION . After this  line data will be not available in REQUEST[Model] or SESSION Scope
		*/
		
		//sessionStatus.setComplete();
		return "second";
	}
	
	
	//New [ModelAttributeDTO sampleDto2] object is created as such object is not available in REQUEST/CONVERSATIONAL scope
	//Though a object available in SESSION scope it will not be considered for Injection
	@RequestMapping("/third")
	public String thirdPage(Model modelT,HttpSession httpSession,@ModelAttribute("sampleDto2") ModelAttributeDTO modelDto2) {
		System.out.println(modelT.getAttribute("fname"));
		System.out.println(modelT.getAttribute("sname"));		
		System.out.println(((ModelAttributeDTO)modelT.getAttribute("sampleDto")).getCourseName());
		
		System.out.println(modelDto2.getCourseName());
		httpSession.setAttribute("nfname", "Prasad");
		httpSession.setAttribute("nsname", "Nirmala");
		
		return "third";
	}	
	
	
}
