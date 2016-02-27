/**
 *
 */
package com.qawaa.service;

import java.util.List;
import java.util.Map;

import com.qawaa.data.entity.EventList;

/**
 * @author Ryan  2013-9-29  下午9:47:39
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public interface EventListService {
	/**
	 * 根据检索参数和翻页参数获取结果
	 * @param params
	 * @param orders
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<EventList> getEventListByParamsAndPage(Map<String, Object> params, Map<String, Boolean> orders, int firstResult, int maxResults);
	/**
	 * 根据检索参数获取结果总数
	 * @param params
	 * @return
	 */
	public Integer getCountByParams(Map<String, Object> params);
	/**
	 * 根据主键获取
	 * @param id
	 * @return
	 */
	public EventList get(Integer id);
}
