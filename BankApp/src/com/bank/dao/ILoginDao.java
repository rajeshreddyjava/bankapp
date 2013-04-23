package com.bank.dao;

import com.bank.beans.LoginForm;
import com.bank.domain.Login;

public interface ILoginDao {
	public Login getLogin(LoginForm loginForm);

}
