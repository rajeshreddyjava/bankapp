package com.bank.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.beans.Receiver;
import com.bank.service.ITransfersService;

@Controller
@RequestMapping("/user/transfers")
public class AddReceiverController {
	private static final String ADD_RECEIVER = "add_receiver";
	private static final String ADD_RECIEVER_CONFIRMATION = "addreceiverconfirm";
	private static final String ERROR = "error";
	private static final Logger log = Logger
			.getLogger(TransfersController.class);
	@Autowired
	private ITransfersService transfersService;


	
	@RequestMapping(method = RequestMethod.GET, value = "/addReceiver.do")
	public ModelAndView showAddReceiver(ModelMap model) {
		ModelAndView mv = new ModelAndView();
		log.info("In AddReceiveController - showAddReceiver");
		Receiver addReciverForm = new Receiver();
		mv.addObject("addReceiverForm", addReciverForm);
		mv.setViewName(ADD_RECEIVER);
		return mv;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/addReceiver.do")
	public ModelAndView doSubmit(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("addReceiverForm")Receiver addReceiverForm,
			BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		try {
			validateReceiverInfo(addReceiverForm, bindingResult);
			if(bindingResult.hasErrors()){
				mv.addObject("addReceiverForm", addReceiverForm);
				mv.setViewName(ADD_RECEIVER);
				return mv;
			}
			else{
				transfersService.addReceiver(addReceiverForm);
				mv.addObject("addReceiverForm", addReceiverForm);
				mv.setViewName(ADD_RECIEVER_CONFIRMATION);
			}
			

		} catch (Exception e) {

			mv.setViewName(ERROR);
		}
		return mv;
	}
	
	public void validateReceiverInfo(Receiver addReceiverForm, BindingResult bindingResult){
		
		Receiver fromDBForm = transfersService.getReceiverInfo(addReceiverForm.getAccountNumber());
		
		if(!addReceiverForm.getFirstName().equalsIgnoreCase(fromDBForm.getFirstName())){
			bindingResult.addError(new ObjectError("receiver.notmatched", "Receiver Information not matched, please verify"));
		}
		else if(!addReceiverForm.getLastName().equalsIgnoreCase(fromDBForm.getLastName())){
			bindingResult.addError(new ObjectError("receiver.notmatched", "Receiver Information not matched, please verify"));
		}
		else if(!addReceiverForm.getAccountNumber().equalsIgnoreCase(fromDBForm.getAccountNumber())){
			bindingResult.addError(new ObjectError("receiver.notmatched", "Receiver Information not matched, please verify"));
		}
		else if(!addReceiverForm.getAddress().getZipCode().equalsIgnoreCase(fromDBForm.getAddress().getZipCode())){
			bindingResult.addError(new ObjectError("receiver.notmatched", "Receiver Information not matched, please verify"));
		}
		return ;
	}

}
