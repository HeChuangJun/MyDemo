package com.hechuangjun.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hechuangjun.dao.SubareaDao;
import com.hechuangjun.domain.Subarea;
import com.hechuangjun.service.ISubareaService;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年9月24日 
* 类说明 :
*/
@Service
@Transactional
public class SubareaServiceImpl implements ISubareaService{

	@Autowired
	private SubareaDao subareaDao;
	@Override
	public void save(Subarea model) {
		// TODO Auto-generated method stub
		subareaDao.save(model);
	}

}
