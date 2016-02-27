/**
 *
 */
package com.qawaa.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.qawaa.data.bean.HotEventBean;
import com.qawaa.data.dao.PointMultipleDailyDao;
import com.qawaa.data.entity.PointMultipleDaily;
import com.qawaa.service.PointMultipleDailyService;

/**
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class PointMultipleDailyServiceImpl implements PointMultipleDailyService {
	private PointMultipleDailyDao dao;
	
	/**
	 * @return the dao
	 */
	public PointMultipleDailyDao getPointMultipleDailyDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setPointMultipleDailyDao(PointMultipleDailyDao dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.PointMultipleDailyService#getMultipleDayPointsByParamsAndPage(java.util.Map, int, int)
	 */
	public List<PointMultipleDaily> getMultipleDayPointsByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults) {
		List<PointMultipleDaily> list = dao.getMultipleDayPointsByParamsAndPage(params, firstResult, maxResults);
		if(list == null)
			list = new ArrayList<PointMultipleDaily>(0);
 		return list;
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.PointMultipleDailyService#getDailyHotEvent(java.util.Date)
	 */
	public List<HotEventBean> getDailyHotEvent(Date date) {
		return dao.getDailyHotEvent(date);
	}

}
