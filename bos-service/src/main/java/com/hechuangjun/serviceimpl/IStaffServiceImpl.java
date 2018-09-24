package com.hechuangjun.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hechuangjun.dao.IStaffDao;

import com.hechuangjun.domain.Staff;
import com.hechuangjun.service.IStaffService;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年9月23日 
* 类说明 :
*/
@Service
@Transactional
public class IStaffServiceImpl implements IStaffService{
	@Autowired
	private IStaffDao staffDao;
	
	@Override
	public void save(Staff model) {
		// TODO Auto-generated method stub
		staffDao.save(model);
	}

}
