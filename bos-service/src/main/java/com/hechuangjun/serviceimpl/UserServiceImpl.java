package com.hechuangjun.serviceimpl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hechuangjun.dao.IUserDao;
import com.hechuangjun.domain.User;
import com.hechuangjun.service.IUserService;
import com.hechuangjun.utils.MD5Utils;
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User login(User user) {
		//String md5 = MD5Utils.md5(user.getPassword());
		return userDao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
		
	}

	@Override
	public void editPassword(String id, String password) {
		// TODO Auto-generated method stub
		//String md5 = MD5Utils.md5(user.getPassword());
		userDao.executeUpdate("user.editpassword", password,id);
	}

}
