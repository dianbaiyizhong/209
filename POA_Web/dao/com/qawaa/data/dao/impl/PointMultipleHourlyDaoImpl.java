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

import com.qawaa.data.dao.PointMultipleHourlyDao;
import com.qawaa.data.entity.PointMultipleHourly;

/**
 * @author Ryan  2013-10-12  下午9:44:30
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class PointMultipleHourlyDaoImpl extends HibernateDaoSupport implements PointMultipleHourlyDao {


	/* (non-Javadoc)
	 * @see com.qawaa.data.dao.PointMultipleHourlyDao#getMultipleHourPointByParamsAndPage(java.util.Map, int, int)
	 */
	@SuppressWarnings("unchecked")
	public List<PointMultipleHourly> getMultipleHourPointByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults) {
		DetachedCriteria dc = DetachedCriteria.forClass(PointMultipleHourly.class);
		this.setQuery(dc, params);
		dc.addOrder(Order.desc("mhpId"));
		return this.getHibernateTemplate().findByCriteria(dc, firstResult, maxResults);
	}
	/**
	 * @param dc
	 * @param params
	 */
	private void setQuery(DetachedCriteria dc, Map<String, Object> params){
		if(params == null || params.size() == 0)
			return;
		if(params.containsKey("mhpId")){
			dc.add(Restrictions.eq("mhpId", params.get("mhpId")));
		}
		if(params.containsKey("gtMhpId")){
			dc.add(Restrictions.gt("mhpId", params.get("gtMhpId")));
		}
		if(params.containsKey("ltMhpId")){
			dc.add(Restrictions.lt("mhpId", params.get("ltMhpId")));
		}
		if(params.containsKey("mhpEventId")){
			dc.add(Restrictions.eq("mhpEventId", params.get("mhpEventId")));
		}
		if(params.containsKey("gtMhpDate")){
			dc.add(Restrictions.gt("mhpDate", params.get("gtMhpDate")));
		}
		if(params.containsKey("ltMhpDate")){
			dc.add(Restrictions.lt("mhpDate", params.get("ltMhpDate")));
		}
		if(params.containsKey("mhpStatus")){
			dc.add(Restrictions.eq("mhpStatus", params.get("mhpStatus")));
		}
		if(params.containsKey("geMhpId")){
			dc.add(Restrictions.ge("mhpId", params.get("geMhpId")));
		}
		if(params.containsKey("leMhpId")){
			dc.add(Restrictions.le("mhpId", params.get("leMhpId")));
		}
	}

}
