/**
 *
 */
package com.qawaa.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.qawaa.data.dao.EventListDao;
import com.qawaa.data.entity.EventList;
import com.qawaa.service.EventListService;

/**
 * @author Ryan  2013-9-29  下午9:48:14
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class EventListServiceImpl implements EventListService {
	private EventListDao dao;
	
	/**
	 * @return the dao
	 */
	public EventListDao getEventListDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setEventListDao(EventListDao dao) {
		this.dao = dao;
	}


	/* (non-Javadoc)
	 * @see com.qawaa.service.EventListService#getEventListByParamsAndPage(java.util.Map, java.util.Map, int, int)
	 */
	public List<EventList> getEventListByParamsAndPage(Map<String, Object> params, Map<String, Boolean> orders, int firstResult, int maxResults){
		List<EventList> list = dao.getEventListByParamsAndPage(params, orders, firstResult, maxResults);
		if(list == null)
			list = new ArrayList<EventList>();
		return list;
	}


	/* (non-Javadoc)
	 * @see com.qawaa.service.EventListService#getCountByParams(java.util.Map)
	 */
	public Integer getCountByParams(Map<String, Object> params) {
		List<Integer> list = dao.getCountByParams(params);
		if(list == null || list.size() == 0)
			return 0;
		return list.get(0);
	}


	/* (non-Javadoc)
	 * @see com.qawaa.service.EventListService#get(java.lang.Integer)
	 */
	public EventList get(Integer id) {
		return dao.get(id);
	}

}
