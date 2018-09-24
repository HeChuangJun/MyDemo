package com.hechuangjun.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hechuangjun.dao.IReginDao;

import com.hechuangjun.domain.Region;
import com.hechuangjun.service.IRegionService;
import com.hechuangjun.utils.PageBean;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年9月24日 
* 类说明 :
*/
@Service
@Transactional
public class RegionServiceImpl implements IRegionService{
	@Autowired
	private IReginDao regionDao;

	@Override
	public void saveBatch(List<Region> regionList) {
		// TODO Auto-generated method stub
		for(Region region:regionList) {
			regionDao.saveOrUpdate(region);
		}
	}

	@Override
	//根据页面传过来的String进行模糊查询
	public List<Region> findListByQ(String q) {
		// TODO Auto-generated method stub
		return regionDao.findListByQ(q);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		regionDao.pageQuery(pageBean);
	}

	@Override
	public List<Region> findAll() {
		// TODO Auto-generated method stub
		return regionDao.findAll();
	}

}
