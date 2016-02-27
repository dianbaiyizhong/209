/**
 * 
 */
package org.cischina.service;

import java.util.List;
import java.util.Map;

import org.cischina.data.entity.EventStatus;

/**
 * @author Ran Xu
 * @data 2014-5-7 下午4:25:56 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public interface EventStatusService {
	/**
	 * 根据主键获取
	 * @param <T>
	 * @param id
	 * @return
	 */
	public EventStatus get(Integer id);
	
	/**
	 * 保存或更新数据
	 * @param entity
	 */
	public void saveOrUpdate(EventStatus entity);
	
	/**
	 * 删除
	 * @param entity
	 */
	public void del(EventStatus entity);
	
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
	public List<EventStatus> getEntitiesByParamsAndPages(Map<String, Object> params, int firstResult, int maxResults);
	
	/**
	 * 根据检索条件获取结果总数
	 * @param params
	 * @return
	 */
	public int getCountByParamsAndPages(Map<String, Object> params);
}
