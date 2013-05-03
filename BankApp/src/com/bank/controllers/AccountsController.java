package com.bank.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bank.beans.AccountSummaryForm;
import com.bank.beans.TransactionsForm;
import com.bank.domain.User;
import com.bank.service.IAccountsService;

@Controller
@RequestMapping("/user/accounts.do")
public class AccountsController {
	private IAccountsService accountService;
	
   static Logger log = Logger.getLogger(AccountsController.class.getName());
	
	@Autowired
	public void setAccountService(IAccountsService accountService) {
		this.accountService = accountService;
	}
	private static final String ACCOUNT_SUMMARY = "account_summary";
	private static final String TRANSACTIONS = "transactions";
	private static final String ERROR = "error";
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView showAccountSummary(ModelMap model, HttpSession session){
       String viewName = null;
       List<AccountSummaryForm> summaryList = null;
       try{
    	   log.info("Starting showAccountSummary() method...");
		User user  =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		summaryList = accountService.getAccountSummary(user.getUsername());
		session.setAttribute("summaryList", summaryList);
		viewName = ACCOUNT_SUMMARY;
       }
       catch(Exception e){
    	   viewName = ERROR;
    	   e.printStackTrace();
       }
		ModelAndView mv = new ModelAndView(viewName,"summary", summaryList);
		return mv;
		
	}
	
	@RequestMapping(method=RequestMethod.GET, params={"type"})
	public ModelAndView showTransactions(@RequestParam("type") String accountType, ModelMap model, HttpSession session){
		String viewName = null;
		List<TransactionsForm> transactions = null;
		String accountNumber = null;
		try{
		log.info("Show transactions started...");
		User user  =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<AccountSummaryForm> summaryList = (List)session.getAttribute("summaryList");
		for(AccountSummaryForm form : summaryList){
			if(form.getAccountType().equalsIgnoreCase(accountType))
				accountNumber = form.getAccountNumber();
		}
		transactions = accountService.getTransactions(accountType, accountNumber, user.getUsername());	
		viewName = TRANSACTIONS;
		}
		catch(NullPointerException e){
			viewName = ERROR;
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName(TRANSACTIONS);
		mv.addObject("transactions", transactions);
		return mv;
	}

}
