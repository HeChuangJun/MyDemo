package com.hechuangjun.utils;
/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年9月23日 
* 类说明 :
*/

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hechuangjun.domain.User;

public class BosUtils {
	//获取session对象
	public static HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}
	//获取登录用户 
	public static User getLoginUser() {
		return (User) getSession().getAttribute("loginUser");
	}
}	
