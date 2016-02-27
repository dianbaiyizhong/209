/**
 *
 */
package org.cischina.dao.impl;

import java.util.List;
import java.util.Map;

import org.cischina.dao.CategorySiteTwoDao;
import org.cischina.data.entity.CategorySiteTwo;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Ryan
 * @datetime 2014-6-3 下午9:46:06
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class CategorySiteTwoDaoImpl extends HibernateDaoSupport implements CategorySiteTwoDao {

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#get(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public CategorySiteTwo get(Integer id) {
		return this.getHibernateTemplate().get(CategorySiteTwo.class, id);
	}

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public <T> void saveOrUpdate(T entity) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#del(java.lang.Object)
	 */
	@Override
	public <T> void del(T entity) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#del(java.lang.Integer)
	 */
	@Override
	public void del(Integer id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#getEntitiesByParamsAndPages(java.util.Map, int, int)
	 */
	@Override
	public List<?> getEntitiesByParamsAndPages(Map<String, Object> params, int firstResult, int maxResults) {
		DetachedCriteria dc = DetachedCriteria.forClass(CategorySiteTwo.class);
		this.setQuery(dc, params);
		dc.addOrder(Order.desc("cstOrder"));
		return this.getHibernateTemplate().findByCriteria(dc, firstResult, maxResults);
	}

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#getCountByParamsAndPages(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getCountByParamsAndPages(Map<String, Object> params) {
		DetachedCriteria dc = DetachedCriteria.forClass(CategorySiteTwo.class);
		this.setQuery(dc, params);
		dc.setProjection(Projections.count("cstId"));
		return this.getHibernateTemplate().findByCriteria(dc,0,1);
	}
	
	private void setQuery(DetachedCriteria dc, Map<String, Object> params){
		if(params == null || params.size() == 0)
			return;
		if(params.containsKey("cstId")){
			dc.add(Restrictions.eq("cstId", params.get("cstId")));
		}
		if(params.containsKey("cstOneId")){
			dc.add(Restrictions.eq("cstOneId", params.get("cstOneId")));
		}
		if(params.containsKey("cstOneIds")){
			dc.add(Restrictions.in("cstOneId", (Object[]) params.get("cstOneIds")));
		}
		if(params.containsKey("cstName")){
			dc.add(Restrictions.eq("cstName", params.get("cstName")));
		}
		if(params.containsKey("ilikeCstName")){
			dc.add(Restrictions.ilike("cstName", (String) params.get("ilikeCstName"), MatchMode.ANYWHERE));
		}
		if(params.containsKey("cstStatus")){
			dc.add(Restrictions.eq("cstStatus", params.get("cstStatus")));
		}
	}

}
