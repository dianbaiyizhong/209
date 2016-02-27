/**
 * 
 */
package com.qawaa.service.impl;

import java.util.List;

import com.qawaa.dao.PointMultipleRealTimeDao;
import com.qawaa.data.entity.PointMultipleRealTime;
import com.qawaa.service.PointMultipleRealTimeService;

/**
 * @author Ran Xu
 * @data 2014-3-6 上午10:30:51 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
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
	 * @see com.qawaa.service.PointMultipleRealTimeService#getNewPoint(java.lang.Integer)
	 */
	@Override
	public PointMultipleRealTime getNewPoint(Integer eventid) {
		List<PointMultipleRealTime> list = dao.getNewPoint(eventid);
		if(list == null || list.size() == 0)
			return null;
		return list.get(0);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.PointMultipleRealTimeService#save(com.qawaa.data.entity.PointMultipleRealTime)
	 */
	@Override
	public void save(PointMultipleRealTime entity) {
		dao.save(entity);

	}

}
