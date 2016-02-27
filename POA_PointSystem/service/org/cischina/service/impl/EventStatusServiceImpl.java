/**
 * 
 */
package org.cischina.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.cischina.dao.EventStatusDao;
import org.cischina.data.entity.EventStatus;
import org.cischina.service.EventStatusService;

/**
 * @author Ran Xu
 * @data 2014-5-7 下午4:27:55 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public class EventStatusServiceImpl implements EventStatusService {
	private EventStatusDao dao;
	/**
	 * @return the dao
	 */
	public EventStatusDao getEventStatusDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setEventStatusDao(EventStatusDao dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.EventStatusService#get(java.lang.Integer)
	 */
	@Override
	public EventStatus get(Integer id) {
		return dao.get(id);
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.EventStatusService#saveOrUpdate(org.cischina.data.entity.EventStatus)
	 */
	@Override
	public void saveOrUpdate(EventStatus entity) {
		dao.saveOrUpdate(entity);

	}

	/* (non-Javadoc)
	 * @see org.cischina.service.EventStatusService#del(org.cischina.data.entity.EventStatus)
	 */
	@Override
	public void del(EventStatus entity) {
		dao.del(entity);

	}

	/* (non-Javadoc)
	 * @see org.cischina.service.EventStatusService#del(java.lang.Integer)
	 */
	@Override
	public void del(Integer id) {
		dao.del(id);

	}

	/* (non-Javadoc)
	 * @see org.cischina.service.EventStatusService#getEntitiesByParamsAndPages(java.util.Map, int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EventStatus> getEntitiesByParamsAndPages(Map<String, Object> params, int firstResult, int maxResults) {
		List<EventStatus> list = (List<EventStatus>) dao.getEntitiesByParamsAndPages(params, firstResult, maxResults);
		if(list == null)
			list = new ArrayList<EventStatus>(0);
		return list;
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.EventStatusService#getCountByParamsAndPages(java.util.Map)
	 */
	@Override
	public int getCountByParamsAndPages(Map<String, Object> params) {
		List<Integer> list = dao.getCountByParamsAndPages(params);
		if(list == null || list.size() == 0)
			return 0;
		return list.get(0);
	}

}
