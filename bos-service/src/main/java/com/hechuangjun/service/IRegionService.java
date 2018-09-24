package com.hechuangjun.service;

import java.util.List;

import com.hechuangjun.domain.Region;
import com.hechuangjun.utils.PageBean;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年9月24日 
* 类说明 :
*/
public interface IRegionService {

	void saveBatch(List<Region> regionList);

	List<Region> findListByQ(String q);

	void pageQuery(PageBean pageBean);

	List<Region> findAll();

}
