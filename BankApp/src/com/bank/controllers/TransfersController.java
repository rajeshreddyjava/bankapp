
package com.bank.controllers;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.beans.TransferForm;
import com.bank.service.BankViews;
import com.bank.service.ITransfersService;
import com.bank.util.BankUtils;

@Controller

@RequestMapping("/user/transfers")
public class TransfersController {
	
	private static final Logger log = Logger.getLogger(TransfersController.class);
	@Autowired
	private ITransfersService transferService;
	
		@RequestMapping(method=RequestMethod.GET, value="/transfers.do")
		public ModelAndView showTransfers(ModelMap model){
			ModelAndView mv = new ModelAndView();
			log.info("In Transfers Controller - showTransfers");
			TransferForm transferForm = new TransferForm();
			Map<String, String> receiversMap = transferService.getReceiverList(BankUtils.getCurrentUserId());
			mv.addObject("receiversMap", receiversMap);
			mv.addObject("transferForm", transferForm);
			mv.setViewName(BankViews.TRANSFERS);
			return mv;
	}
		@RequestMapping(method=RequestMethod.POST, value="/transfers.do", params = "transfer")
		public ModelAndView doTransfer(ModelMap model){
			ModelAndView mv = new ModelAndView();
			log.info("In Transfers Controller - doTransfer");
			return mv;
	}
		@RequestMapping(method=RequestMethod.POST, value="/transfers.do", params = "_cancel")
		public ModelAndView cancelTransfers(ModelMap model){
			ModelAndView mv = new ModelAndView();
			log.info("In Transfers Controller - cancelTransfer");
			mv.setViewName(BankViews.HOME);
			return mv;
	

	}
		
}
