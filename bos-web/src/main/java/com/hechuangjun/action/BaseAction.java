package com.hechuangjun.action;

import java.lang.reflect.ParameterizedType;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	
	public static final String HOME = "home";
	public static final String LIST ="list";
	
	//模型对象
	protected T model;
	//每个继承父类(BaseAction)的都会调用父类的构造方法
	//用于创建子类的对象
	public BaseAction() {
		ParameterizedType Superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class<T> entityClass = (Class<T>) Superclass.getActualTypeArguments()[0];
		try {
			model=entityClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}


	@Override
	public T getModel() {
		return model;
	}

}
