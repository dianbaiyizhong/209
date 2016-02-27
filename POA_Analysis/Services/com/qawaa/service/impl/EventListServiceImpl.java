/**
 * 
 */
package com.qawaa.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qawaa.dao.EventListDao;
import com.qawaa.data.entity.EventList;
import com.qawaa.service.EventListService;

/**
 * @author Ran Xu
 * @data 2014-2-13 下午5:31:18 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
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
	 * @see com.qawaa.service.EventListService#get(java.lang.Integer)
	 */
	@Override
	public EventList get(Integer id) {
		return dao.get(id);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.EventListService#getEventListByParamsAndPage(java.util.Map, int, int)
	 */
	@Override
	public List<EventList> getEventListByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults) {
		List<EventList> list = dao.getEventListByParamsAndPage(params, firstResult, maxResults);
		if(list == null)
			list = new ArrayList<EventList>(0);
		return list;
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.EventListService#update(com.qawaa.data.entity.EventList)
	 */
	@Override
	public void update(EventList entity) {
		dao.update(entity);

	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.EventListService#getCountByParams(java.util.Map)
	 */
	@Override
	public int getCountByParams(Map<String, Object> params) {
		List<Integer> list = dao.getCountByParams(params);
		if(list == null || list.size() == 0)
			return 0;
		return list.get(0);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.EventListService#isExistEventList()
	 */
	@Override
	public boolean isExistEventList() {
		int count = this.getCountByParams(null);
		if(count == 0)
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.EventListService#updateStatus(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public void updateStatus(Integer id, Integer status) {
		dao.updateStatus(id, status);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.EventListService#getLastNormalEvent()
	 */
	@Override
	public EventList getLastNormalEvent() {
		Map<String, Object> params = new HashMap<String, Object>(1);
		params.put("eventStatus", 20);
		List<EventList> list = dao.getEventListByParamsAndPage(params, 0, 1);
		if(list == null || list.size() == 0)
			return null;
		return list.get(0);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.EventListService#getNextNormalEvent(java.lang.Integer)
	 */
	@Override
	public EventList getNextNormalEvent(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>(1);
		params.put("eventStatus", 20);
		params.put("ltEventId", id);
		List<EventList> list = dao.getEventListByParamsAndPage(params, 0, 1);
		if(list == null || list.size() == 0)
			return null;
		return list.get(0);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.EventListService#getRequestEventList()
	 */
	@Override
	public EventList getRequestEventList() {
		List<EventList> list = dao.getRequestEventList();
		if(list == null || list.size() == 0)
			return null;
		return list.get(0);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.EventListService#updateScanDate(java.lang.Integer)
	 */
	@Override
	public void updateScanDate(Integer id) {
		dao.updateScanDate(id);
		
	}

}
