package com.hechuangjun.dao;

import com.hechuangjun.domain.User;

public interface IUserDao extends IBaseDao<User>{

	User findUserByUsernameAndPassword(String username, String password);

}
