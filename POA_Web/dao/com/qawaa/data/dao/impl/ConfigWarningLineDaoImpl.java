/**
 *
 */
package com.qawaa.data.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qawaa.data.dao.ConfigWarningLineDao;
import com.qawaa.data.entity.ConfigWarningLine;

/**
 * @author Ryan  2013-10-8  下午11:44:06
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class ConfigWarningLineDaoImpl extends HibernateDaoSupport implements ConfigWarningLineDao {

	/* (non-Javadoc)
	 * @see com.qawaa.data.dao.ConfigWarningLineDao#loadNormalConfigWarningLine()
	 */
	@SuppressWarnings("unchecked")
	public List<ConfigWarningLine> loadNormalConfigWarningLine() {
		DetachedCriteria dc = DetachedCriteria.forClass(ConfigWarningLine.class);
		dc.add(Restrictions.eq("wnlStatus", true));
		dc.addOrder(Order.desc("wnlOrder"));
		return this.getHibernateTemplate().findByCriteria(dc, 0, 10);
	}

}
