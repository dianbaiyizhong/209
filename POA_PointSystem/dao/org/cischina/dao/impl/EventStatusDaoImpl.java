/**
 * 
 */
package org.cischina.dao.impl;

import java.util.List;
import java.util.Map;

import org.cischina.dao.EventStatusDao;
import org.cischina.data.entity.EventStatus;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Ran Xu
 * @data 2014-5-7 下午4:13:14 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public class EventStatusDaoImpl extends HibernateDaoSupport implements EventStatusDao {

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public <T> void saveOrUpdate(T entity) {
		if(entity != null)
			this.getHibernateTemplate().saveOrUpdate(EventStatus.class.getName(), entity);

	}

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#del(java.lang.Object)
	 */
	@Override
	public <T> void del(T entity) {
		if(entity != null)
			this.getHibernateTemplate().delete(entity);

	}

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#getEntitiesByParamsAndPages(java.util.Map, int, int)
	 */
	@Override
	public List<?> getEntitiesByParamsAndPages(Map<String, Object> params, int firstResult, int maxResults) {
		DetachedCriteria dc = DetachedCriteria.forClass(EventStatus.class);
		this.setQuery(dc, params);
		dc.addOrder(Order.asc("aesId"));
		return this.getHibernateTemplate().findByCriteria(dc, firstResult, maxResults);
	}

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#getCountByParamsAndPages(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getCountByParamsAndPages(Map<String, Object> params) {
		DetachedCriteria dc = DetachedCriteria.forClass(EventStatus.class);
		this.setQuery(dc, params);
		dc.setProjection(Projections.count("aesId"));
		return this.getHibernateTemplate().findByCriteria(dc, 0, 1);
	}

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#get(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EventStatus get(Integer id) {
		if(id == null)
			return null;
		return this.getHibernateTemplate().get(EventStatus.class, id);
	}
	
	private void setQuery(DetachedCriteria dc, Map<String, Object> params){
		if(params == null || params.size() == 0)
			return;
		if(params.containsKey("aesId")){
			dc.add(Restrictions.eq("aesId", params.get("aesId")));
		}
		if(params.containsKey("aesName")){
			dc.add(Restrictions.eq("aesName", params.get("aesName")));
		}
		if(params.containsKey("ilikeAesName")){
			dc.add(Restrictions.ilike("aesName", (String) params.get("ilikeAesName"), MatchMode.ANYWHERE));
		}
		if(params.containsKey("aesComment")){
			dc.add(Restrictions.eq("aesComment", params.get("aesComment")));
		}
	}

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#del(java.lang.Integer)
	 */
	@Override
	public void del(Integer id) {
		String hql = "delete from EventStatus where aesId=?";
		this.getHibernateTemplate().bulkUpdate(hql, id);
		
	}

}
