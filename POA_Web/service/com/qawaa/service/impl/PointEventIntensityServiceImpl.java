/**
 * 
 */
package com.qawaa.service.impl;

import java.util.List;

import com.qawaa.data.dao.PointEventIntensityDao;
import com.qawaa.data.entity.PointEventIntensity;
import com.qawaa.service.PointEventIntensityService;

/**
 * @author Ran Xu
 * @data 2014-3-10 上午9:34:39 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public class PointEventIntensityServiceImpl implements PointEventIntensityService {
	private PointEventIntensityDao dao;
	
	/**
	 * @return the dao
	 */
	public PointEventIntensityDao getPointEventIntensityDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setPointEventIntensityDao(PointEventIntensityDao dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.PointEventIntensityService#getLastIntensityByEvent(java.lang.Integer)
	 */
	public int getLastIntensityByEvent(Integer eventId) {
		List<PointEventIntensity> list = dao.getLastIntensityByEvent(eventId);
		if(list == null || list.size() == 0)
			return 0;
		return list.get(0).getPesIntensity().intValue();
	}

}
