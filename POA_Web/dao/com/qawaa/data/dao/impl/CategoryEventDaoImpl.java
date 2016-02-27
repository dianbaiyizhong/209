/**
 *
 */
package com.qawaa.data.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qawaa.data.dao.CategoryEventDao;
import com.qawaa.data.entity.CategoryEvent;

/**
 * @author Ryan  2013-10-9  下午9:36:28
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class CategoryEventDaoImpl extends HibernateDaoSupport implements CategoryEventDao {

	/* (non-Javadoc)
	 * @see com.qawaa.data.dao.CategoryEventDao#loadNormal()
	 */
	@SuppressWarnings("unchecked")
	public List<CategoryEvent> loadNormal() {
		DetachedCriteria dc = DetachedCriteria.forClass(CategoryEvent.class);
		dc.add(Restrictions.eq("cgeStatus", true));
		dc.addOrder(Order.desc("cgeOrder"));
		return this.getHibernateTemplate().findByCriteria(dc, 0, 100);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.data.dao.CategoryEventDao#get(java.lang.Integer)
	 */
	public CategoryEvent get(Integer id) {
		if(id == null)
			return null;
		return this.getHibernateTemplate().get(CategoryEvent.class, id);
	}

}
