package com.hechuangjun.serviceimpl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hechuangjun.dao.IStaffDao;
import com.hechuangjun.domain.Staff;
import com.hechuangjun.service.IStaffService;
import com.hechuangjun.utils.PageBean;


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

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		staffDao.pageQuery(pageBean);
	}

	@Override
	public void deleteBatch(String ids) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(ids)) {
			String[]strings =ids.split(",");
			for(String id :strings) {
				staffDao.executeUpdate("staff.delete", id);
			}
		}
	}

	@Override
	public Staff findById(String id) {
		// TODO Auto-generated method stub
		Staff findById = staffDao.findById(id);
		return findById;
	}

	@Override
	public void update(Staff staff) {
		// TODO Auto-generated method stub
		staffDao.update(staff);
	}
	


}
