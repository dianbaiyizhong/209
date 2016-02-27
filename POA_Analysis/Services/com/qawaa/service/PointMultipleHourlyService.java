/**
 *
 */
package com.qawaa.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.qawaa.data.entity.PointMultipleHourly;

/**
 * @author Ryan
 * @datetime 2014-3-15 下午10:26:02
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public interface PointMultipleHourlyService {
	/**
	 * 根据主键获取
	 * @param id
	 * @return
	 */
	public PointMultipleHourly get(Integer id);
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(PointMultipleHourly entity);
	
	/**
	 * 根据检索和翻页参数获取结果集
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<PointMultipleHourly> getPointMultipleHourlyByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults);
	
	/**
	 * 根据检索参数获取结果总数
	 * @param params
	 * @return
	 */
	public int getCountByParams(Map<String, Object> params);
	
	/**
	 * 根据事件ID获取最近的一条数据
	 * @param eventId
	 * @return
	 */
	public PointMultipleHourly getLastPointMultipleHourlyByEvent(Integer eventId);
	
	/**
	 * 根据事件和时间获取
	 * @param eventid
	 * @param date
	 * @return
	 */
	public PointMultipleHourly getPointByEventAndDate(Integer eventid, Date date);
}
