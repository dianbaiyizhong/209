/**
 *
 */
package com.qawaa.data.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qawaa.data.dao.CategorySiteOneDao;
import com.qawaa.data.entity.CategorySiteOne;

/**
 * @author Ryan  2013-10-7  下午7:24:29
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class CategorySiteOneDaoImpl extends HibernateDaoSupport implements CategorySiteOneDao {

	/* (non-Javadoc)
	 * @see com.qawaa.data.dao.CategorySiteOneDao#loadAll()
	 */
	@SuppressWarnings("unchecked")
	public List<CategorySiteOne> loadAll() {
		DetachedCriteria dc = DetachedCriteria.forClass(CategorySiteOne.class);
		dc.add(Restrictions.eq("csoStatus", true));
		dc.addOrder(Order.desc("csoOrder"));
		return this.getHibernateTemplate().findByCriteria(dc, 0, 100);
	}

}
