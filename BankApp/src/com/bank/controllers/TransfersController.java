
package com.bank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user/transfers.do")

public class TransfersController {
	private static final String TRANSFERS= "transfers";
		
		
		@RequestMapping(method=RequestMethod.GET)
		public String showTransfers(ModelMap model){
			return TRANSFERS;
	

	}
}
