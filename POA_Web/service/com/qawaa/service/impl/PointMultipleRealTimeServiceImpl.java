/**
 *
 */
package com.qawaa.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.qawaa.data.dao.PointMultipleRealTimeDao;
import com.qawaa.data.entity.PointMultipleRealTime;
import com.qawaa.service.PointMultipleRealTimeService;

/**
 * @author Ryan  2013-10-10  下午4:36:49
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class PointMultipleRealTimeServiceImpl implements PointMultipleRealTimeService {
	private PointMultipleRealTimeDao dao;
	
	/**
	 * @return the dao
	 */
	public PointMultipleRealTimeDao getPointMultipleRealTimeDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setPointMultipleRealTimeDao(PointMultipleRealTimeDao dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.PointMultipleRealTimeService#getMultiplePointByParamsAndPage(java.util.Map, int, int)
	 */
	public List<PointMultipleRealTime> getMultiplePointByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults) {
		List<PointMultipleRealTime> list = dao.getMultiplePointByParamsAndPage(params, firstResult, maxResults);
		if(list == null)
			list = new ArrayList<PointMultipleRealTime>(0);
		return list;
	}

}
