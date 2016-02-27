/**
 *
 */
package com.qawaa.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.qawaa.data.dao.PointMultipleHourlyDao;
import com.qawaa.data.entity.PointMultipleHourly;
import com.qawaa.service.PointMultipleHourlyService;

/**
 * @author Ryan  2013-10-12  下午10:00:58
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class PointMultipleHourlyServiceImpl implements PointMultipleHourlyService {
	private PointMultipleHourlyDao dao;
	
	/**
	 * @return the dao
	 */
	public PointMultipleHourlyDao getPointMultipleHourlyDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setPointMultipleHourlyDao(PointMultipleHourlyDao dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.PointMultipleHourlyService#getMultipleHourPointByParamsAndPage(java.util.Map, int, int)
	 */
	public List<PointMultipleHourly> getMultipleHourPointByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults) {
		List<PointMultipleHourly> list = dao.getMultipleHourPointByParamsAndPage(params, firstResult, maxResults);
		if(list == null)
			list = new ArrayList<PointMultipleHourly>(0);
		return list;
	}

}
