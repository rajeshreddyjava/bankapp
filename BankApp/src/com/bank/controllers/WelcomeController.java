package com.bank.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	@RequestMapping(value="/user/welcome.do", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("userName", name);
		
		return "hello";
	}
	
	@RequestMapping(value="/public/login.do",method=RequestMethod.GET)
	public String login(ModelMap model){
		return "login";
	}
	@RequestMapping(value="/public/loginfailed.do" , method = RequestMethod.GET)
	public String loginFailed(ModelMap model){
		model.addAttribute("error", "true");
		return "login";
	}
	@RequestMapping(value="/public/logout.do", method=RequestMethod.GET)
	public String logout(ModelMap model){
		return "home";
	}
}
