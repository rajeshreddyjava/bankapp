
package com.bank.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

@RequestMapping("/user/transfers")
public class TransfersController {
	private static final String TRANSFERS= "transfers";
	private static final Logger log = Logger.getLogger(TransfersController.class);
		
		
		@RequestMapping(method=RequestMethod.GET, value="/transfers.do")
		public ModelAndView showTransfers(ModelMap model){
			ModelAndView mv = new ModelAndView();
			log.info("In Transfers Controller - showTransfers");
			mv.setViewName(TRANSFERS);
			return mv;
	

	}
		
}
