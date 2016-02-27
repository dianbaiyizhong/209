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

import com.qawaa.data.dao.PointMultipleRealTimeDao;
import com.qawaa.data.entity.PointMultipleRealTime;

/**
 * @author Ryan  2013-10-10  下午4:18:07
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class PointMultipleRealTimeDaoImpl extends HibernateDaoSupport implements PointMultipleRealTimeDao {

	/* (non-Javadoc)
	 * @see com.qawaa.data.dao.PointMultipleRealTimeDao#getMultiplePointByParamsAndPage(java.util.Map, int, int)
	 */
	@SuppressWarnings("unchecked")
	public List<PointMultipleRealTime> getMultiplePointByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults) {
		DetachedCriteria dc = DetachedCriteria.forClass(PointMultipleRealTime.class);
		this.setQuery(dc, params);
		dc.addOrder(Order.desc("ampDate"));
		return this.getHibernateTemplate().findByCriteria(dc, firstResult, maxResults);
	}
	/**
	 * @param dc
	 * @param params
	 */
	private void setQuery(DetachedCriteria dc, Map<String, Object> params){
		if(params == null || params.size() == 0)
			return;
		if(params.containsKey("ampId")){
			dc.add(Restrictions.eq("ampId", params.get("ampId")));
		}
		if(params.containsKey("geAmpId")){
			dc.add(Restrictions.ge("ampId", params.get("geAmpId")));
		}
		if(params.containsKey("gtAmpId")){
			dc.add(Restrictions.gt("ampId", params.get("gtAmpId")));
		}
		if(params.containsKey("leAmpId")){
			dc.add(Restrictions.le("ampId", params.get("leAmpId")));
		}
		if(params.containsKey("ltAmpId")){
			dc.add(Restrictions.lt("ampId", params.get("ltAmpId")));
		}
		if(params.containsKey("ampEventId")){
			dc.add(Restrictions.eq("ampEventId", params.get("ampEventId")));
		}
		if(params.containsKey("ampEventIds")){
			dc.add(Restrictions.in("ampEventId", (Object[]) params.get("ampEventIds")));
		}
		if(params.containsKey("geAmpDate")){
			dc.add(Restrictions.ge("ampDate", params.get("geAmpDate")));
		}
		if(params.containsKey("gtAmpDate")){
			dc.add(Restrictions.gt("ampDate", params.get("gtAmpDate")));
		}
		if(params.containsKey("leAmpDate")){
			dc.add(Restrictions.le("ampDate", params.get("leAmpDate")));
		}
		if(params.containsKey("ltAmpDate")){
			dc.add(Restrictions.lt("ampDate", params.get("ltAmpDate")));
		}
		if(params.containsKey("ampStatus")){
			dc.add(Restrictions.eq("ampStatus", params.get("ampStatus")));
		}
	}

}
