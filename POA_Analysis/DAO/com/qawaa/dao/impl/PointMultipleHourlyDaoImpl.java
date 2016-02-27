/**
 *
 */
package com.qawaa.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qawaa.dao.PointMultipleHourlyDao;
import com.qawaa.data.entity.PointMultipleHourly;

/**
 * @author Ryan
 * @datetime 2014-3-15 下午10:14:42
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class PointMultipleHourlyDaoImpl extends HibernateDaoSupport implements PointMultipleHourlyDao {

	/* (non-Javadoc)
	 * @see com.qawaa.dao.PointMultipleHourlyDao#get(java.lang.Integer)
	 */
	@Override
	public PointMultipleHourly get(Integer id) {
		if(id == null)
			return null;
		return this.getHibernateTemplate().get(PointMultipleHourly.class, id);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.dao.PointMultipleHourlyDao#save(com.qawaa.data.entity.PointMultipleHourly)
	 */
	@Override
	public void save(PointMultipleHourly entity) {
		if(entity != null)
			this.getHibernateTemplate().saveOrUpdate(entity);

	}

	/* (non-Javadoc)
	 * @see com.qawaa.dao.PointMultipleHourlyDao#getPointMultipleHourlyByParamsAndPage(java.util.Map, int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PointMultipleHourly> getPointMultipleHourlyByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults) {
		DetachedCriteria dc = DetachedCriteria.forClass(PointMultipleHourly.class);
		this.setQuery(dc, params);
		dc.addOrder(Order.desc("mhpDate"));
		return this.getHibernateTemplate().findByCriteria(dc, firstResult, maxResults);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.dao.PointMultipleHourlyDao#getCountByParams(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getCountByParams(Map<String, Object> params) {
		DetachedCriteria dc = DetachedCriteria.forClass(PointMultipleHourly.class);
		this.setQuery(dc, params);
		dc.setProjection(Projections.count("mhpId"));
		return this.getHibernateTemplate().findByCriteria(dc, 0, 1);
	}
	
	private void setQuery(DetachedCriteria dc, Map<String, Object> params){
		if(params == null || params.size() == 0)
			return;
		if(params.containsKey("mhpEventId")){
			dc.add(Restrictions.eq("mhpEventId", params.get("mhpEventId")));
		}
		if(params.containsKey("mhpPoint")){
			dc.add(Restrictions.eq("mhpPoint", params.get("mhpPoint")));
		}
		if(params.containsKey("mhpDate")){
			dc.add(Restrictions.eq("mhpDate", params.get("mhpDate")));
		}
		if(params.containsKey("mhpStatus")){
			dc.add(Restrictions.eq("mhpStatus", params.get("mhpStatus")));
		}
	}

}
