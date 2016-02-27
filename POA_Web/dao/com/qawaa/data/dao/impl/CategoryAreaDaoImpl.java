/**
 *
 */
package com.qawaa.data.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qawaa.data.dao.CategoryAreaDao;
import com.qawaa.data.entity.CategoryArea;

/**
 * @author Ryan  2013-10-9  下午10:57:15
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class CategoryAreaDaoImpl extends HibernateDaoSupport implements CategoryAreaDao {

	/* (non-Javadoc)
	 * @see com.qawaa.data.dao.CategoryAreaDao#loadNormal()
	 */
	@SuppressWarnings("unchecked")
	public List<CategoryArea> loadNormal() {
		DetachedCriteria dc = DetachedCriteria.forClass(CategoryArea.class);
		dc.add(Restrictions.eq("cgaStatus", true));
		dc.addOrder(Order.desc("cgaOrder"));
		return this.getHibernateTemplate().findByCriteria(dc, 0, 100);
	}

}
