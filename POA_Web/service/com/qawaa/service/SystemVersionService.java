/**
 *
 */
package com.qawaa.service;

import java.util.List;
import java.util.Map;

import com.qawaa.data.entity.SystemVersion;

/**
 * @author Ryan  2013-10-13  下午11:31:12
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public interface SystemVersionService {
	/**
	 * 根据检索和翻页参数获取
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<SystemVersion> getSystemVersionByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults);
	
	/**
	 * 获取当前的系统版本
	 * @return
	 */
	public SystemVersion now();
}
