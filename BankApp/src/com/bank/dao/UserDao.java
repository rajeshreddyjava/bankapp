package com.bank.dao;

import com.bank.domain.User;

public interface UserDao {
	User getUserByUserName(String userName);
}