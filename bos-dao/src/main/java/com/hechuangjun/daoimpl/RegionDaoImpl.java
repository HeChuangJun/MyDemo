package com.hechuangjun.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hechuangjun.dao.IReginDao;
import com.hechuangjun.domain.Region;
@Repository
public class RegionDaoImpl extends BaseDaoImpl<Region> implements IReginDao {
	/**
	 * 根据q参数进行模糊查询
	 */
	public List<Region> findListByQ(String q) {
		String hql = "FROM Region r WHERE r.shortcode LIKE ? "
					+ "	OR r.citycode LIKE ? OR r.province LIKE ? "
					+ "OR r.city LIKE ? OR r.district LIKE ?";
		List<Region> list = (List<Region>) this.getHibernateTemplate().
				find(hql, "%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%");
		return list;
	}
}
