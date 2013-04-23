package com.bank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user/customer_serivce.do")
public class CustomerServiceController {
	
	private static final String CUSTOMER_SERVICE = "customer_service";
	@RequestMapping(method=RequestMethod.GET)
	public String showCustomerService(ModelMap model){
		return CUSTOMER_SERVICE;
		
	}

}