package com.hechuangjun.action;
import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hechuangjun.domain.Staff;
import com.hechuangjun.service.IStaffService;
import com.hechuangjun.utils.PageBean;

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
		return "list";
	}
	private int page;
	private int rows;
	
	
	public IStaffService getStaffService() {
		return staffService;
	}


	public void setStaffService(IStaffService staffService) {
		this.staffService = staffService;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getRows() {
		return rows;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}


	public String pageQuery() throws IOException {
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(page);
		pageBean.setPageSize(rows);
		//创建离线查询对象
		DetachedCriteria forClass = DetachedCriteria.forClass(Staff.class);
		pageBean.setDetachedCriteria(forClass);
		staffService.pageQuery(pageBean);
		
		//使用json-lib将PageBean对象转为json,通过输出流写回页面中
		//JSONObject 将单一对象转为json
		//JSONArray--将数组惑集合对象转为json
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[] {"currentPage","detachedCriteria","pageSize"});
		String jsonString =JSONObject.fromObject(pageBean,jsonConfig).toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(jsonString);
		return NONE;
	}
	private String ids;
	public String getIds() {
		return ids;
	}


	public void setIds(String ids) {
		this.ids = ids;
	}


	public String deleteBatch() {
		staffService.deleteBatch(ids);
		return LIST;
	}
	public String edit() {
		//查询数据库,根据id查询原始数据
		Staff staff=staffService.findById(model.getId());
		
		//使用页面提交的数据进行覆盖哦
		staff.setName(model.getName());
		staff.setTelephone(model.getTelephone());
		staff.setHaspda(model.getHaspda());
		staff.setStandard(model.getStandard());
		staff.setStation(model.getStation());
		
		
		staffService.update(staff);//直接update会有问题
		return LIST;
	}
}
