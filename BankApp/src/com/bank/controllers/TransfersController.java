
package com.bank.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.beans.AddReceiverForm;
import com.bank.exceptions.BankServiceException;
import com.bank.service.AccountService;
import com.bank.service.IAccountsService;

@Controller
@RequestMapping("/user/transfers")

public class TransfersController {
	private static final String TRANSFERS= "transfers";
	private static final String ADD_RECEIVER= "add_receiver";
	private static final String ERROR= "error";
	static Logger log= Logger.getLogger(AccountService.class);	
	private IAccountsService accountsService;
	
	@Autowired
	public void setAccountsService(IAccountsService accountsService) {
		this.accountsService = accountsService;
	}
		@RequestMapping(method=RequestMethod.GET)
		public ModelAndView initTransfers(ModelMap model){
			ModelAndView modelAndView = new ModelAndView();
		log.info("Initializing model for transfers.. in initTransfers method");	
			try{
				throw new BankServiceException("In Transfers Controller ");
			}
			catch(BankServiceException e){
				log.error("InTransfersController - " + e.toString() );
			}
			return modelAndView;
	}
		@RequestMapping(method= RequestMethod.GET , value = "/addReceiver.do")
		public ModelAndView addReceiver(ModelMap model){
			ModelAndView modelAndView = new ModelAndView();
			try{
				modelAndView.setViewName(ADD_RECEIVER);
				AddReceiverForm addReceiverForm = new AddReceiverForm();
				modelAndView.addObject("addReceiverForm", addReceiverForm);
			}
			catch (Exception e) {
				log.error(e);
			}
			
			return modelAndView;
		}
}
