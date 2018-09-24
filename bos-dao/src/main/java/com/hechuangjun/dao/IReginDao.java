/**
 * 
 */
package com.hechuangjun.dao;

import java.util.List;

import com.hechuangjun.domain.Region;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年9月24日 
* 类说明 :
*/
/**
 * @author 创军
 *
 */
public interface IReginDao extends IBaseDao<Region>{

	List<Region> findListByQ(String q);

}
