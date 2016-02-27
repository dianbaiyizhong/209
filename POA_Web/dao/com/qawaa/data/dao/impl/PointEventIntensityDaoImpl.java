/**
 * 
 */
package com.qawaa.data.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qawaa.data.dao.PointEventIntensityDao;
import com.qawaa.data.entity.PointEventIntensity;

/**
 * @author Ran Xu
 * @data 2014-3-10 上午9:29:06 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public class PointEventIntensityDaoImpl extends HibernateDaoSupport implements PointEventIntensityDao {

	/* (non-Javadoc)
	 * @see com.qawaa.data.dao.PointEventIntensityDao#getLastIntensityByEvent(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	public List<PointEventIntensity> getLastIntensityByEvent(Integer eventId) {
		if(eventId == null)
			return null;
		DetachedCriteria dc = DetachedCriteria.forClass(PointEventIntensity.class);
		dc.add(Restrictions.eq("pesEventId", eventId));
		dc.add(Restrictions.eq("pesStatus", true));
		dc.addOrder(Order.desc("pesDate"));
		return this.getHibernateTemplate().findByCriteria(dc, 0, 1);
	}

}
