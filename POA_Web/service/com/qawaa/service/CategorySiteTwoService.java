/**
 *
 */
package com.qawaa.service;

import java.util.List;
import java.util.Map;

import com.qawaa.data.entity.CategorySiteTwo;

/**
 * @author Ryan  2013-10-8  上午12:18:27
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public interface CategorySiteTwoService {
	/**
	 * 根据检索条件和翻页参数获取结果
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<CategorySiteTwo> getCategorySiteTwoByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults);
}
