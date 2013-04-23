package com.bank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user/profile.do")
public class CustomerProfileController {
	
	private static final String CUSTOMER_PROFILE= "customer_profile";
	@RequestMapping(method=RequestMethod.GET)
	public String showProfile(ModelMap model){
		return CUSTOMER_PROFILE;
		
	}

}