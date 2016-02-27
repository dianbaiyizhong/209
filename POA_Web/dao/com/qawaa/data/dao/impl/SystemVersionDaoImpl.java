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

import com.qawaa.data.dao.SystemVersionDao;
import com.qawaa.data.entity.SystemVersion;

/**
 * @author Ryan  2013-10-13  下午11:27:20
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class SystemVersionDaoImpl extends HibernateDaoSupport implements SystemVersionDao {

	/* (non-Javadoc)
	 * @see com.qawaa.data.dao.SystemVersionDao#getSystemVersionByParamsAndPage(java.util.Map, int, int)
	 */
	@SuppressWarnings("unchecked")
	public List<SystemVersion> getSystemVersionByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults) {
		DetachedCriteria dc = DetachedCriteria.forClass(SystemVersion.class);
		this.setQuery(dc, params);
		dc.addOrder(Order.desc("verId"));
		return this.getHibernateTemplate().findByCriteria(dc, firstResult, maxResults);
	}
	private void setQuery(DetachedCriteria dc, Map<String, Object> params){
		if(params == null || params.size() == 0)
			return;
		if(params.containsKey("verId")){
			dc.add(Restrictions.eq("verId", params.get("verId")));
		}
		if(params.containsKey("verName")){
			dc.add(Restrictions.eq("verName", params.get("verName")));
		}
		if(params.containsKey("verStatus")){
			dc.add(Restrictions.eq("verStatus", params.get("verStatus")));
		}
	}

}
