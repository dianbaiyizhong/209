/**
 *
 */
package com.qawaa.data.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.qawaa.data.bean.HotEventBean;
import com.qawaa.data.entity.PointMultipleDaily;

/**
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public interface PointMultipleDailyDao {
	/**
	 * 根据检索参数和翻页参数获取
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<PointMultipleDaily> getMultipleDayPointsByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults);
	
	/**
	 * 根据时间获取当日热门事件
	 * @param date
	 * @return
	 */
	public List<HotEventBean> getDailyHotEvent(Date date);
}
