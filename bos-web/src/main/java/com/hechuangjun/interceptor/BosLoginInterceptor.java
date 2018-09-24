package com.hechuangjun.interceptor;

import org.aopalliance.intercept.Invocation;
import org.apache.struts2.ServletActionContext;

import com.hechuangjun.domain.User;
import com.hechuangjun.utils.BosUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年9月23日 
* 类说明 :
*/
public class BosLoginInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		User user = BosUtils.getLoginUser();
		if(user == null ) {
			return "login";
		}
		return arg0.invoke();
	}

}
