/**
 * 
 */
package com.qawaa.service;

import java.util.List;
import java.util.Map;

import com.qawaa.data.entity.EventList;

/**
 * @author Ran Xu
 * @data 2014-2-13 下午5:29:52 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public interface EventListService {
	/**
	 * 根据主键获取
	 * @param id
	 * @return
	 */
	public EventList get(Integer id);
	
	/**
	 * 根据检索参数、起始值以及最大值参数获取
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<EventList> getEventListByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults);
	
	/**
	 * 更新
	 * @param entity
	 */
	public void update(EventList entity);
	
	/**
	 * 根据检索参数获取结果总数
	 * @param params
	 * @return
	 */
	public int getCountByParams(Map<String, Object> params);
	
	/**
	 * 判断事件表中数据是否为空，为空返回true
	 * @return
	 */
	public boolean isExistEventList();
	
	/**
	 * 根据主键更新状态
	 * @param id 主键
	 * @param status 状态码
	 */
	public void updateStatus(Integer id, Integer status);
	
	/**
	 * 获取最新的一个需要分析指数的舆情事件
	 * @return
	 */
	public EventList getLastNormalEvent();
	
	/**
	 * 获取下一个符合指定参数的舆情事件
	 * @param id
	 * @return
	 */
	public EventList getNextNormalEvent(Integer id);

	/**
	 * 获取最近一条的请求扫描的事件
	 * @return
	 */
	public EventList getRequestEventList();
	/**
	 * 根据主键更新扫描时间
	 * @param id
	 */
	public void updateScanDate(Integer id);
}
