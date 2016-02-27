/**
 * 
 */
package org.cischina.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.cischina.dao.EventListDao;
import org.cischina.data.entity.EventList;
import org.cischina.service.EventListService;
import org.cischina.service.ServiceAbstract;

/**
 * @author Ran Xu
 * @data 2014-5-27 下午3:46:36 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public class EventListServiceImpl extends ServiceAbstract implements EventListService {
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
	 * @see org.cischina.service.EventListService#get(java.lang.Integer)
	 */
	@Override
	public EventList get(Integer id) {
		if(id == null)
			return null;
		return dao.get(id);
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.EventListService#saveOrUpdate(org.cischina.data.entity.EventList)
	 */
	@Override
	public void saveOrUpdate(EventList entity) {
		if(entity == null)
			return;
		dao.saveOrUpdate(entity);

	}

	/* (non-Javadoc)
	 * @see org.cischina.service.EventListService#del(org.cischina.data.entity.EventList)
	 */
	@Override
	public void del(EventList entity) {
		if(entity == null)
			return;
		dao.del(entity);

	}

	/* (non-Javadoc)
	 * @see org.cischina.service.EventListService#del(java.lang.Integer)
	 */
	@Override
	public void del(Integer id) {
		if(id == null)
			return;
		dao.del(id);

	}

	/* (non-Javadoc)
	 * @see org.cischina.service.EventListService#getEntitiesByParamsAndPages(java.util.Map, int, int)
	 */
	@Override
	public List<EventList> getEntitiesByParamsAndPages(Map<String, Object> params, int firstResult, int maxResults) {
		@SuppressWarnings("unchecked")
		List<EventList> list = (List<EventList>) dao.getEntitiesByParamsAndPages(params, firstResult, maxResults);
		if(list == null)
			list = new ArrayList<EventList>(0);
		return list;
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.EventListService#getCountByParamsAndPages(java.util.Map)
	 */
	@Override
	public int getCountByParamsAndPages(Map<String, Object> params) {
		return this.getCount(dao.getCountByParamsAndPages(params));
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.EventListService#isExistByTitle(java.lang.String, java.lang.Integer)
	 */
	@Override
	public boolean isExistByTitle(String title, Integer id) {
		if(StringUtils.isBlank(title))
			return true;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("eventTitle", title.trim());
		if(id != null)
			params.put("nEventId", id);
		int count = this.getCountByParamsAndPages(params);
		if(count > 0)
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.EventListService#isExistByKeyword(java.lang.String, java.lang.Integer)
	 */
	@Override
	public boolean isExistByKeyword(String keyword, Integer id) {
		if(StringUtils.isBlank(keyword))
			return true;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("eventKeyword", keyword.trim());
		if(id != null)
			params.put("nEventId", id);
		int count = this.getCountByParamsAndPages(params);
		if(count > 0)
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.EventListService#isExistById(java.lang.Integer)
	 */
	@Override
	public boolean isExistById(Integer id) {
		if(id == null)
			return true;
		Map<String, Object> params = new HashMap<String, Object>(1);
		params.put("eventId", id);
		int count = this.getCountByParamsAndPages(params);
		if(count > 0)
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.EventListService#isExistChildEvent(java.lang.Integer)
	 */
	@Override
	public boolean isExistChildEvent(Integer id) {
		if(id == null)
			return true;
		Map<String, Object> params = new HashMap<String, Object>(1);
		params.put("eventParent", id);
		int count = this.getCountByParamsAndPages(params);
		if(count > 0)
			return true;
		return false;
	}

}
