/**
 * 
 */
package org.cischina.service;

import java.util.List;
import java.util.Map;

import org.cischina.data.entity.CategoryEvent;

/**
 * @author Ran Xu
 * @data 2014-5-8 下午1:48:02 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public interface CategoryEventService {
	/**
	 * 根据主键获取
	 * @param <T>
	 * @param id
	 * @return
	 */
	public CategoryEvent get(Integer id);
	
	/**
	 * 保存或更新数据
	 * @param entity
	 */
	public void saveOrUpdate(CategoryEvent entity);
	
	/**
	 * 删除
	 * @param entity
	 */
	public void del(CategoryEvent entity);
	
	/**
	 * 根据主键删除
	 * @param entity
	 */
	public void del(Integer id);
	/**
	 * 根据检索条件和翻页参数获取
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<CategoryEvent> getEntitiesByParamsAndPages(Map<String, Object> params, int firstResult, int maxResults);
	
	/**
	 * 根据检索条件获取结果总数
	 * @param params
	 * @return
	 */
	public int getCountByParamsAndPages(Map<String, Object> params);
	
	/**
	 * 根据ID判断是否存在，存在返回true
	 * @param id
	 * @return
	 */
	public boolean isExistById(Integer id);
	
	/**
	 * 根据名称判断是否存在，存在返回true
	 * @param name
	 * @param id
	 * @return
	 */
	public boolean isExistByName(String name, Integer id);
}
