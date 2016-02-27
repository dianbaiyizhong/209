/**
 *
 */
package com.qawaa.data.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qawaa.data.dao.CategorySiteTwoDao;
import com.qawaa.data.entity.CategorySiteTwo;

/**
 * @author Ryan  2013-10-8  上午12:04:40
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class CategorySiteTwoDaoImpl extends HibernateDaoSupport implements CategorySiteTwoDao {

	/* (non-Javadoc)
	 * @see com.qawaa.data.dao.CategorySiteTwoDao#getCategorySiteTwoByParamsAndPage(java.util.Map, int, int)
	 */
	@SuppressWarnings("unchecked")
	public List<CategorySiteTwo> getCategorySiteTwoByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults) {
		DetachedCriteria dc = DetachedCriteria.forClass(CategorySiteTwo.class);
		this.setQuery(dc, params);
		dc.addOrder(Order.desc("cstOrder"));
		return this.getHibernateTemplate().findByCriteria(dc, firstResult, maxResults);
	}
	
	private void setQuery(DetachedCriteria dc, Map<String, Object> params){
		if(params == null || params.size() == 1)
			return;
		if(params.containsKey("cstId")){
			dc.add(Restrictions.eq("cstId", params.get("cstId")));
		}
		if(params.containsKey("cstOneId")){
			dc.add(Restrictions.eq("cstOneId", params.get("cstOneId")));
		}
		if(params.containsKey("cstStatus")){
			dc.add(Restrictions.eq("cstStatus", params.get("cstStatus")));
		}
		if(params.containsKey("ids")){
			dc.add(Restrictions.in("cstId", (Object[]) params.get("ids")));
		}
	}

}
