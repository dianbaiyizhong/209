/**
 *
 */
package org.cischina.service;

import java.util.List;
import java.util.Map;

import org.cischina.data.entity.CategorySiteTwo;

/**
 * @author Ryan
 * @datetime 2014-6-4 上午12:23:01
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public interface CategorySiteTwoService {
	/**
	 * 根据主键获取
	 * @param id
	 * @return
	 */
	public CategorySiteTwo get(Integer id);
	
	/**
	 * 保存或更新数据
	 * @param entity
	 */
	public void saveOrUpdate(CategorySiteTwo entity);
	
	/**
	 * 删除
	 * @param entity
	 */
	public void del(CategorySiteTwo entity);
	
	/**
	 * 根据主键删除
	 * @param id
	 */
	public void del(Integer id);
	
	/**
	 * 根据检索条件和翻页参数获取
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<CategorySiteTwo> getEntitiesByParamsAndPages(Map<String, Object> params, int firstResult, int maxResults);
	
	/**
	 * 根据检索条件获取结果总数
	 * @param params
	 * @return
	 */
	public int getCountByParamsAndPages(Map<String, Object> params);
	
	/**
	 * 根据分类站点一获取
	 * @param siteOneId
	 * @return
	 */
	public List<CategorySiteTwo> getEntitiesBySiteOne(Integer siteOneId);
}
