package com.hechuangjun.service;

import com.hechuangjun.domain.User;

public interface IUserService {

	User login(User user);

	void editPassword(String id, String password);
	
}
