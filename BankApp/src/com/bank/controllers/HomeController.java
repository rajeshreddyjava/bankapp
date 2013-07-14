package com.bank.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.bank.beans.LoginForm;

@Controller

public class HomeController {
	static Logger log= Logger.getLogger(HomeController.class);
	@RequestMapping(value="/public/home.do", method = RequestMethod.GET)
	public String goToHome() {
		log.info("Home Controller: redirecting to public home page" );
		return "home";
	}
	@RequestMapping(value="/user/home.do", method = RequestMethod.GET)
	public String goToUserHome() {
		log.info("Home Controller: redirecting to user home page" );
		return "user_home";
	}
}
