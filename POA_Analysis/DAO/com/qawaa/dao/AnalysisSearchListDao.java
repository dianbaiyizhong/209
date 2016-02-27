/**
 * 
 */
package com.qawaa.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.qawaa.data.entity.AnalysisSearchList;

/**
 * @author Ran Xu
 * @data 2014-3-10 下午4:34:46 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public interface AnalysisSearchListDao {
	/**
	 * 根据主键获取
	 * @param id
	 * @return
	 */
	public AnalysisSearchList get(Integer id);
	
	/**
	 * 根据检索条件和翻页参数获取
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<AnalysisSearchList> getAnalysisSearchListByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults);
	
	/**
	 * 根据检索条件获取结果总数
	 * @param params
	 * @return
	 */
	public List<Integer> getCountByParams(Map<String, Object> params);
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(AnalysisSearchList entity);
	
	/**
	 * 根据事件和时间段的文章总数
	 * @param eventId
	 * @param date
	 * @return
	 */
	public List<Integer> getWebCountByEventAndDate(Integer eventId, Timestamp startTime, Timestamp endTime);
}
