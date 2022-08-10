package com.prabathj.lc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prabathj.lc.dtomodels.UserInfoDTO;
import com.prabathj.lc.services.LCResultCalculationImpl;

@Controller
public class LoginController {

	@Autowired
	private LCResultCalculationImpl resutlCalculator;
	
	//@ResponseBody //With this view resolver will be replaced so remove his if view resolver need to use
	
	//No need of @ModelAttribute if you are not to write data to the form and form do not use ModelAttribute
	@RequestMapping("/home-a")
	public String getHome_a(){
		return "lc-home-a";
	}	
	
	//Write data to a form to set as default values (Use DTO getter methods)
	@RequestMapping("/home")
	public String getHome(@ModelAttribute("userInfo") UserInfoDTO userModel,HttpSession session){
		
		//@Bean (Model)+ @Bean (UserInfoDTO, Create object only for the master DTO not aggregated DTos(CommunicationDto)) 
		//+  model.addAttribute = @ModelAttribute
		//With @ModelAttribute model  we can refer Spring MVC tags to inject(write) data to a form
		/*	@Bean (Model)+
			UserInfoDTO userInfoDto=new UserInfoDTO();+
			model.addAttribute("userinfo",userInfoDto);
		*/			
		//userModel.setUserName("Prabath");
		
		
		//if((UserInfoDTO)session.getAttribute("userd")!=null)
		//System.out.println(((UserInfoDTO)session.getAttribute("userd")).getResult());
		
		//Create a UserInfoDTO object in SESSION scope
		//This will replace any attribute value with name 'userd' so if we need to keep the same object from this controller onward 
		//need to check the availability of "userd" attribute before setAttribute call 
		
		if((UserInfoDTO)session.getAttribute("userd")==null) {
			System.out.println("New Attribute");
			session.setAttribute("userd", userModel);
			userModel.setResult("Fail");
		}
		
		return "lc-home";
	}	

	//-----------------------Query Parameter----------------------------	
	
	/*	How to use Query Parameters to pass client information to controller, type conversion automatically apply 
		eg: http://localhost:8080/love-calculator/process-homepage?username=Prasad&crushname=Suneetha
		Model object scope is Request scope
		The Model is essentially a map (that is, a collection of key-value pairs) that will be
		handed off to the view so that the data can be rendered to the client.
		A Model object is created with the request and model attributes are ultimately copied into the request 
		as request attributes and are lost when the redirect takes place.
	*/
			
		
	@RequestMapping(path = "/process-homepage-a")
	public String calculateLove_a(Model model,
			@RequestParam(name = "username", defaultValue = "Prabath") String username,
			@RequestParam(name = "crushname", defaultValue = "Anuththara") String crushname) {
		System.out.println(username + " " + crushname);
		model.addAttribute("username", username);
		model.addAttribute("crushname", crushname);

		return "lc-result-a";

	}
	
	/*Read data from a form	
	Set the Query parameters to the given bean using setter methods ->
	   	@Bean (Model)+
	   	@Bean (UserInfoDTO)[At this stage all fields of the UserInfoDTO object is null,the data set @Autowired 
	   	, Create object only for the master DTO not aggregated DTos(CommunicationDto)]
	   	+ @Autowired (Form data -> query parameters -> UserInfoDTO using setters)
	   
	eg: http://localhost:8080/love-calculator/process-homepage?userName=Prasad&crushName=Suneetha   
	*/
	
	//Model [the map] is created only one time for the request here 
	//'model' & 'modelS' both are refer to the same Model object
	
	@RequestMapping("/process-homepage-b")
	public String calculateLove_b(Model model, UserInfoDTO user,Model modelS) {

		System.out.println(user.getCrushName() + " " + user.getUserName());
		model.addAttribute("userInfodto", user);
		model.addAttribute("shared", "Shared");

		//'model' & 'modelS' both are refer to the same Model object
		System.out.println(modelS.getAttribute("shared"));
		return "lc-result-b";

	}
	
	//With @ModelAttribute Spring perform followingsuserName
	//@Bean (Model)+@Bean (UserInfoDTO, Create object only for the master DTO not aggregated DTos(CommunicationDto)) 
	//+ @Autowired (Form data to UserInfoDTO using setters )+model.addAttribute("userInfo", userModel);
	
	//Validation -> @Valid always should be before the @ModelAttribute , BindingResult always should follow the Model
	
	@RequestMapping("/process-homepage")
	public String calculateLove(@Valid @ModelAttribute("userInfo") UserInfoDTO userModel,BindingResult errors,HttpServletRequest request){
		
		if(errors.hasErrors()){
			
			return "lc-home";
		}
		
		//'UserInfoDTO' object inject here is not related to the SESSION scope attribute 'userd' [Like @SessionAttributes object copy doent happen in SESSION]
		
		System.out.println(userModel.getResult()); //NULL 
		
		HttpSession session=request.getSession();
		System.out.println(session.getAttribute("userName"));
		System.out.println(((UserInfoDTO)session.getAttribute("userd")).getResult());	//Fail

		//session.setMaxInactiveInterval(60*60);
		//Now attribute add to the session object[not to the Model] when fetching data JSP will look in order of 
		//1. Model[Request] 2.Session 
		session.setAttribute("userName", userModel.getUserName());		
		session.setAttribute("relationship", resutlCalculator.calculateRelationship(userModel.getUserName(), userModel.getCrushName()));
		
		//If we want to store above data to the SESSION attribute '(UserInfoDTO)session.getAttribute("userd")' 
		//need to add explicitly
		//((UserInfoDTO)session.getAttribute("userd")).setCrushName(userModel.getCrushName());
		//((UserInfoDTO)session.getAttribute("userd")).setUserName(userModel.getUserName());
		
		
		return "lc-result";
	}	
	
	//-------------------End---------------------------------------		
	
	
	@InitBinder
	public void initBinder(WebDataBinder webDB){
		
	}
}
