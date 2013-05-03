package com.bank.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("public/forgot.do")
public class ForgotCredentialsController {
	private @Value("#{views['forgot.username']}")  String FORGOT_USERNAME;
	private static final String FORGOT_PASSWORD = "forgot_password";
	private static final String ERROR = "error";
	
	@RequestMapping(method = RequestMethod.GET, params = {"credential"})
	public ModelAndView processForgotCredentials(@RequestParam("credential") String forgotCredential, ModelMap model){
		ModelAndView mv = new ModelAndView();
		mv.setViewName(FORGOT_USERNAME);
		return mv;
		
	}

}
