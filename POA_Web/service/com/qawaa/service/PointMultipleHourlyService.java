/**
 *
 */
package com.qawaa.service;

import java.util.List;
import java.util.Map;

import com.qawaa.data.entity.PointMultipleHourly;

/**
 * @author Ryan  2013-10-12  下午10:00:24
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public interface PointMultipleHourlyService {
	/**
	 * 根据检索参数和翻页参数获取
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<PointMultipleHourly> getMultipleHourPointByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults);
}
