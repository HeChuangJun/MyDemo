package com.hechuangjun.action;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.aspectj.internal.lang.reflect.PointcutBasedPerClauseImpl;
import org.hibernate.procedure.internal.Util.ResultClassesResolutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.remoting.RemoteTimeoutException;
import org.springframework.stereotype.Controller;


import com.hechuangjun.domain.User;
import com.hechuangjun.service.IUserService;
import com.hechuangjun.utils.BosUtils;
import com.opensymphony.xwork2.ActionContext;


@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	@Autowired
	private IUserService userService;
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	//登录方法
	public String login() {
		//校验验证码是否正确
		 String validatecode = (String) ActionContext.getContext().getSession().get("key");
		 if(StringUtils.isNotBlank(validatecode)&&checkcode.equals(validatecode)) {
			 User user=userService.login(model);
			 if(user!=null) {
				 ActionContext.getContext().getSession().put("loginUser", user);
				 ActionContext.getContext().put("loginUser", user);
				 return "home";
			 }else {
				 this.addActionError("用户名或者密码错误");
				 return "login"; 
			 }
			 
		 }else {
			 this.addActionError("输入的验证码错误");
			 return "login";
		 }
		
	}
	public String logout() {
		ActionContext.getContext().getSession().remove("loginUser");
		return "login";	
	}

	public String editPassword() throws IOException {
		String fString="1";
		User loginUser = BosUtils.getLoginUser();
		try {
			userService.editPassword(loginUser.getId(),model.getPassword());
		}catch (Exception e) {
			// TODO: handle exception
			fString="0";
			e.printStackTrace();
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(fString);
		return NONE;
	}
}
