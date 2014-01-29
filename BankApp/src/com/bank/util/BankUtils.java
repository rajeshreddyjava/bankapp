package com.bank.util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.bank.domain.User;

public class BankUtils {
	public static String getCurrentUserId(){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user!=null)
			return user.getUsername();
		else
			return null;
	}

}
