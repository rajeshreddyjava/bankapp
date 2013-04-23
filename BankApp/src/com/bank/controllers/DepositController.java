package com.bank.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.bank.beans.DepositForm;
import com.bank.domain.User;
import com.bank.service.IAccountsService;
import com.bank.util.CustomDateEditor;

@Controller
@RequestMapping("user/deposits.do")
public class DepositController {
	private static final String DEPOSIT = "deposit";
	private static final String DEPOSIT_CONFIRM = "deposit_confirm";
	private static final String HOME = "home";
	private static final String ERROR = "deposit_error";
	private IAccountsService accountsService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(DepositForm.class, new CustomDateEditor());
	}

	@Autowired
	public void setAccountsService(IAccountsService accountsService) {
		this.accountsService = accountsService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initDeposit(ModelMap model) {

		DepositForm depositForm = new DepositForm();

		model.put("depositForm", depositForm);
		return DEPOSIT;
	}

	@RequestMapping(params = "_deposit")
	public String processDeposit(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("depositForm") DepositForm depositForm,
			BindingResult bindingResult, SessionStatus sessionStatus,
			Model model) {
		System.out.println("Account Number :" + depositForm.getAccountTypeSelected());
		//custRegValidator.validateIntro(customerRegistrationForm, bindingResult);
		User user  =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = user.getUsername();
		depositForm.setUserId(userId);
		accountsService.processDeposit(depositForm);
		if (bindingResult.hasErrors())
			return DEPOSIT_CONFIRM;
		else
			return ERROR;
	}

	@RequestMapping(params = "_cancel")
	public String cancelDeposit(
			@ModelAttribute("depositForm") DepositForm depositForm,
			BindingResult bindingResult, Errors errors,
			SessionStatus sessionStatus) {

		return ERROR;
	}

	@ModelAttribute("accountTypes")
	public Map<String,String> populateAccountTypes(ModelMap model) {
		List<String> accountTypes = new ArrayList<String>();
		Map<String,String> accountNames = new HashMap<String,String>();
		User user  =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = user.getUsername();
		System.out.println("User ID -------:"+  userId);
		if(userId!=null){
		accountNames = accountsService.getExistingAccountTypes(userId);
		}
		//accountNames.
		Collections.sort(accountTypes);
		return accountNames;
	}
}
