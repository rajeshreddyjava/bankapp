package com.bank.controllers;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	static Logger log= Logger.getLogger(WelcomeController.class);

	@RequestMapping(value="/user/welcome.do", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Principal principal) {
		log.info("Printing welcome message after successful login...");
		String name = principal.getName();
		model.addAttribute("userName", name);
		
		return "hello";
	}
	
	@RequestMapping(value="/public/login.do",method=RequestMethod.GET)
	public String login(ModelMap model){
		log.info("showing login page..");
		return "login";
	}
	@RequestMapping(value="/public/loginfailed.do" , method = RequestMethod.GET)
	public String loginFailed(ModelMap model){
		log.error("Login failed..");
		model.addAttribute("error", "true");
		return "login";
	}
	@RequestMapping(value="/public/logout.do", method=RequestMethod.GET)
	public String logout(ModelMap model){
		log.info("Logged out of the application...");
		return "home";
	}
}
