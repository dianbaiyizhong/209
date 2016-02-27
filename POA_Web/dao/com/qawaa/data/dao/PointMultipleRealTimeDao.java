/**
 *
 */
package com.qawaa.data.dao;

import java.util.List;
import java.util.Map;

import com.qawaa.data.entity.PointMultipleRealTime;

/**
 * @author Ryan  2013-10-10  下午4:16:31
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public interface PointMultipleRealTimeDao {
	/**
	 * 根据检索参数和翻页参数获取数据集
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<PointMultipleRealTime> getMultiplePointByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults);
	
}	
