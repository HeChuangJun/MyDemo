package com.hechuangjun.dao;

import java.io.Serializable;
import java.util.List;

import com.hechuangjun.utils.PageBean;

//持久层通用的方法
public interface IBaseDao<T> {
	public void save(T entity);
	public void delete(T entity);
	public void update(T entity);
	public T findById(Serializable id);
	public List<T> findAll(T entity);
	public void executeUpdate(String queryName,Object...objects);
	public void pageQuery(PageBean pageBean);
}                    
