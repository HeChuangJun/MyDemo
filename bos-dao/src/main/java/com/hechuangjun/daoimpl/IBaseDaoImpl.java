package com.hechuangjun.daoimpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.hechuangjun.dao.IBaseDao;

public class IBaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T>{
	//代表某个实体的类型
	private Class<T> entityClass;
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
		
	}
	
	//在父类(IBaseDaoImpl)的构造方法中动态获得entityClass字节码对象
	public IBaseDaoImpl() {
		//获得T
		ParameterizedType Superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得父类上声明的泛型数组
		Type[] actualTypeArguments = Superclass.getActualTypeArguments();
		entityClass=(Class<T>) actualTypeArguments[0];
	}

	@Override
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
		
	}

	@Override
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
		
	}

	@Override
	public void update(T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
		
	}

	@Override
	public T findById(Serializable id) {
		return this.getHibernateTemplate().get(entityClass, id);
		
	}

	@Override
	public List<T> findAll(T entity) {
		String hql="from "+entityClass.getSimpleName();
		return (List<T>) this.getHibernateTemplate().find(hql);
		
	}

	@Override
	public void executeUpdate(String queryName, Object... objects) {
		// queryName执行语句的名称
		Session currentSession = this.getSessionFactory().getCurrentSession();
		Query namedQuery = currentSession.getNamedQuery(queryName);
		int i=0;
		//为HQL语句中的？赋值
		for(Object object :objects) {
			namedQuery.setParameter(i++, object);
		}
		//执行更新
		namedQuery.executeUpdate();
	}

}
