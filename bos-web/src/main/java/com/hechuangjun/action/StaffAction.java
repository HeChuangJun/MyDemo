package com.hechuangjun.action;
import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hechuangjun.domain.Staff;
import com.hechuangjun.service.IStaffService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 取派员管理
 * @author zhaoqx
 *
 */
@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff>{
	@Autowired
	private IStaffService staffService;
	
	/**
	 * 添加取派员
	 */
	public String add(){
		staffService.save(model);	
		return LIST;
	}
	
	/**
	 * 分页查询方法
	 * @throws IOException 
	 */
	public String pageQuery() throws IOException{
		staffService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"currentPage","detachedCriteria","pageSize"});
		return NONE;
	}
	
	//属性驱动，接收页面提交的ids参数
	private String ids;
	
	/**
	 * 取派员批量删除
	 */
	public String deleteBatch(){
		staffService.deleteBatch(ids);
		return LIST;
	}
	
	/**
	 * 修改取派员信息
	 */
	public String edit(){
		//显查询数据库，根据id查询原始数据
		Staff staff = staffService.findById(model.getId());
		//使用页面提交的数据进行覆盖
		staff.setName(model.getName());
		staff.setTelephone(model.getTelephone());
		staff.setHaspda(model.getHaspda());
		staff.setStandard(model.getStandard());
		staff.setStation(model.getStation());
		staffService.update(staff);
		return LIST;
	}
	
	/*public static void main(String[] args) {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(2);
		pageBean.setPageSize(30);
		String json = JSONObject.fromObject(pageBean ).toString();
		System.out.println(json);
	}*/

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
}
