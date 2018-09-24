package com.hechuangjun.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.hechuangjun.dao.IUserDao;
import com.hechuangjun.domain.User;
import com.hp.hpl.sparta.xpath.ThisNodeTest;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao{

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		String hql="FROM User u WHERE u.username = ? AND u.password = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username,password);
		if(list!=null&&list.size()>0) {
			return list.get(0);
			
		}
		return null;
	}
	
}
