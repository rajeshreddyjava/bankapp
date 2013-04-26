package com.bank.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bank.beans.CustomerRegistrationForm;
import com.bank.beans.States;
import com.bank.service.ICustomerRegistrationService;
import com.bank.validator.CustomerRegistrationValidator;

@Controller
@RequestMapping("/public/cust_reg.do")
@SessionAttributes("customerRegistrationForm")
public class CustomerRegistrationController {
	private static final String CUSTOMER_REGISTRATION_INTRO = "customer_registration_intro";
	private static final String CUSTOMER_REGISTRATION_PERSONAL_INFO = "customer_registration_personal_info";
	private static final String ONLINE_BANKING_INFO = "online_banking_info";
	private static final String CUSTOMER_REGISTRATION_CONFIRM = "customer_registration_confirm";
	private static final String HOME = "home";
	private static final String ERROR = "error";
	private ICustomerRegistrationService customerRegistrationService;

	@Autowired
	public void setCustomerRegistrationService(
			ICustomerRegistrationService customerRegistrationService) {
		this.customerRegistrationService = customerRegistrationService;
	}

	private CustomerRegistrationValidator custRegValidator;

	@Autowired
	public void setCustRegValidator(
			CustomerRegistrationValidator custRegValidator) {
		this.custRegValidator = custRegValidator;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupRegistration(ModelMap model) {

		CustomerRegistrationForm customerRegistrationForm = new CustomerRegistrationForm();
		model.put("customerRegistrationForm", customerRegistrationForm);
		return CUSTOMER_REGISTRATION_INTRO;

	}

	@RequestMapping(params = "_intro")
	public String processIntro(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("customerRegistrationForm") CustomerRegistrationForm customerRegistrationForm,
			BindingResult bindingResult, SessionStatus sessionStatus,
			Model model) {
		custRegValidator.validateIntro(customerRegistrationForm, bindingResult);
		if (bindingResult.hasErrors())
			return CUSTOMER_REGISTRATION_INTRO;
		else
			return CUSTOMER_REGISTRATION_PERSONAL_INFO;
	}

	@RequestMapping(params = "_personal")
	public String processPersonalInfo(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("customerRegistrationForm") CustomerRegistrationForm customerRegistrationForm,
			BindingResult bindingResult, SessionStatus sessionStatus,
			Model model) {
		custRegValidator.validatePersonal(customerRegistrationForm,
				bindingResult);
		if (bindingResult.hasErrors())
			return CUSTOMER_REGISTRATION_PERSONAL_INFO;
		else
			return ONLINE_BANKING_INFO;
	}

	@RequestMapping(params = "_finish")
	public String finishRegistration(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("customerRegistrationForm") CustomerRegistrationForm customerRegistrationForm,
			BindingResult bindingResult, SessionStatus sessionStatus,
			Model model) {
		custRegValidator.validateOnlineBankInfo(customerRegistrationForm,
				bindingResult);

		if (bindingResult.hasErrors())
			return ONLINE_BANKING_INFO;
		else {
			if (customerRegistrationService
					.insertCustomerData(customerRegistrationForm)) {
				if (customerRegistrationService
						.sendConfirmationEmail(customerRegistrationForm))
					return CUSTOMER_REGISTRATION_CONFIRM;
				else
					return ERROR;
			} else
				return ERROR;
		}
	}

	@RequestMapping(params = "_cancel")
	public String cancelRegistration(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("customerRegistrationForm") CustomerRegistrationForm customerRegistrationForm,
			BindingResult bindingResult, SessionStatus sessionStatus,
			Model model) {

		return HOME;
	}

	@ModelAttribute("aacountTypeList")
	public List<String> getAccountTypes(ModelMap model) {
		List<String> accountTypes = new ArrayList<String>();
		accountTypes.add("Checking");
		accountTypes.add("Savings");

		return accountTypes;
	}

	@ModelAttribute("dateFieldsList")
	public List<ArrayList<String>> populateDateFields(ModelMap model) {
		List<ArrayList<String>> datefieldList = null;
		try{
		datefieldList = customerRegistrationService.populateDateFields();
		}
		catch(Exception e){
		e.printStackTrace();
		}
		return datefieldList;
		
	}

	@ModelAttribute("states")
	public List<String> populateStates(ModelMap model) {
		List<String> states = new ArrayList<String>();
		states.add(" ");
		for (States state : States.values())
			states.add(state.getStateValue());
		return states;
	}

}
