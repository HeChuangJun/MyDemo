package com.hechuangjun.service;

import com.hechuangjun.domain.Staff;
import com.hechuangjun.utils.PageBean;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年9月23日 
* 类说明 :
*/
public interface IStaffService {

	public void save(Staff model);

	public void pageQuery(PageBean pageBean);

	public void deleteBatch(String ids);

	public Staff findById(String id);

	public void update(Staff staff);

}
