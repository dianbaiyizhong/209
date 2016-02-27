/**
 * 
 */
package org.cischina.dao.impl;

import java.util.List;
import java.util.Map;

import org.cischina.dao.CategoryEventDao;
import org.cischina.data.entity.CategoryEvent;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Ran Xu
 * @data 2014-5-8 上午11:20:39 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public class CategoryEventDaoImpl extends HibernateDaoSupport implements CategoryEventDao {

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#get(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public CategoryEvent get(Integer id) {
		return this.getHibernateTemplate().get(CategoryEvent.class, id);
	}

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public <T> void saveOrUpdate(T entity) {
		if(entity != null)
			this.getHibernateTemplate().saveOrUpdate(CategoryEvent.class.getName(), entity);

	}

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#del(java.lang.Object)
	 */
	@Override
	public <T> void del(T entity) {
		if(entity != null)
			this.getHibernateTemplate().delete(CategoryEvent.class.getName(), entity);
	}

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#del(java.lang.Integer)
	 */
	@Override
	public void del(Integer id) {
		if(id == null)
			return;
		String hql = "delete CategoryEvent c where c.cgeId = '"+id+"'";
		this.getHibernateTemplate().bulkUpdate(hql);

	}

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#getEntitiesByParamsAndPages(java.util.Map, int, int)
	 */
	@Override
	public List<?> getEntitiesByParamsAndPages(Map<String, Object> params, int firstResult, int maxResults) {
		DetachedCriteria dc = DetachedCriteria.forClass(CategoryEvent.class);
		this.setQuery(dc, params);
		dc.addOrder(Order.asc("cgeId"));
		return this.getHibernateTemplate().findByCriteria(dc, firstResult, maxResults);
	}

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#getCountByParamsAndPages(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getCountByParamsAndPages(Map<String, Object> params) {
		DetachedCriteria dc = DetachedCriteria.forClass(CategoryEvent.class);
		this.setQuery(dc, params);
		dc.setProjection(Projections.count("cgeId"));
		return this.getHibernateTemplate().findByCriteria(dc, 0, 1);
	}
	private void setQuery(DetachedCriteria dc, Map<String, Object> params){
		if(params == null || params.size() == 0)
			return;
		if(params.containsKey("cgeId")){
			dc.add(Restrictions.eq("cgeId", params.get("cgeId")));
		}
		if(params.containsKey("neCgeId")){
			dc.add(Restrictions.ne("cgeId", params.get("neCgeId")));
		}
		if(params.containsKey("cgeName")){
			dc.add(Restrictions.eq("cgeName", params.get("cgeName")));
		}
		if(params.containsKey("ilikeCgeName")){
			dc.add(Restrictions.ilike("cgeName", (String) params.get("ilikeCgeName"), MatchMode.ANYWHERE));
		}
		if(params.containsKey("cgeComment")){
			dc.add(Restrictions.eq("cgeComment", params.get("cgeComment")));
		}
		if(params.containsKey("cgeStatus")){
			dc.add(Restrictions.eq("cgeStatus", params.get("cgeStatus")));
		}
		if(params.containsKey("cgeOrder")){
			dc.add(Restrictions.eq("cgeOrder", params.get("cgeOrder")));
		}
	}
}
