/**
 * 
 */
package com.qawaa.dao;

import java.util.List;
import java.util.Map;

import com.qawaa.data.entity.PointMultipleDaily;

/**
 * @author Ran Xu
 * @data 2014-3-12 下午4:09:05 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public interface PointMultipleDailyDao {
	/**
	 * 保存
	 * @param entity
	 */
	public void save(PointMultipleDaily entity);
	
	/**
	 * 根据检索和翻页参数获取结果
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<PointMultipleDaily> getPointMultipleDailyByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults);
	
}
