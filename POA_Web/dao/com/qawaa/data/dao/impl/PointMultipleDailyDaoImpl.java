/**
 *
 */
package com.qawaa.data.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qawaa.data.bean.HotEventBean;
import com.qawaa.data.dao.PointMultipleDailyDao;
import com.qawaa.data.entity.PointMultipleDaily;
import com.qawaa.util.DateUtil;

/**
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class PointMultipleDailyDaoImpl extends HibernateDaoSupport implements PointMultipleDailyDao {


	/* (non-Javadoc)
	 * @see com.qawaa.data.dao.PointMultipleDailyDao#getMultipleDayPointsByParamsAndPage(java.util.Map, int, int)
	 */
	@SuppressWarnings("unchecked")
	public List<PointMultipleDaily> getMultipleDayPointsByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults) {
		DetachedCriteria dc = DetachedCriteria.forClass(PointMultipleDaily.class);
		this.setQuery(dc, params);
		dc.addOrder(Order.desc("mdpDate"));
		dc.addOrder(Order.desc("mdpId"));
		return this.getHibernateTemplate().findByCriteria(dc, firstResult, maxResults);
	}
	
	private void setQuery(DetachedCriteria dc, Map<String, Object> params){
		if(params == null || params.isEmpty())
			return;
		if(params.containsKey("mdpId")){
			dc.add(Restrictions.eq("mdpId", params.get("mdpId")));
		}
		if(params.containsKey("geMdpId")){
			dc.add(Restrictions.ge("mdpId", params.get("geMdpId")));
		}
		if(params.containsKey("gtMdpId")){
			dc.add(Restrictions.gt("mdpId", params.get("gtMdpId")));
		}
		if(params.containsKey("leMdpId")){
			dc.add(Restrictions.le("mdpId", params.get("leMdpId")));
		}
		if(params.containsKey("ltMdpId")){
			dc.add(Restrictions.lt("mdpId", params.get("ltMdpId")));
		}
		if(params.containsKey("mdpEventId")){
			dc.add(Restrictions.eq("mdpEventId", params.get("mdpEventId")));
		}
		if(params.containsKey("mdpDate")){
			dc.add(Restrictions.eq("mdpDate", params.get("mdpDate")));
		}
		if(params.containsKey("gtMdpDate")){
			dc.add(Restrictions.gt("mdpDate", params.get("gtMdpDate")));
		}
		if(params.containsKey("ltMdpDate")){
			dc.add(Restrictions.lt("mdpDate", params.get("ltMdpDate")));
		}
		if(params.containsKey("mdpStatus")){
			dc.add(Restrictions.eq("mdpStatus", params.get("mdpStatus")));
		}
		if(params.containsKey("mdpEventIds")){
			dc.add(Restrictions.in("mdpEventId", (Object[]) params.get("mdpEventIds")));
		}
	}

	/* (non-Javadoc)
	 * @see com.qawaa.data.dao.PointMultipleDailyDao#getDailyHotEvent(java.util.Date)
	 */
	@SuppressWarnings("unchecked")
	public List<HotEventBean> getDailyHotEvent(Date date) {
		String hql = "select new com.qawaa.data.bean.HotEventBean(el.eventTitle, pmd.mdpPoint, pmd.mdpDate) from PointMultipleDaily as pmd, EventList as el where pmd.mdpDate = ? and pmd.mdpStatus = ? and pmd.mdpEventId=el.eventId order by pmd.mdpPoint desc";
		Query query = this.getSession().createQuery(hql);
		query.setTimestamp(0, new Timestamp(DateUtil.getBeginTimeOfDay(date).getTime()));
		query.setBoolean(1, true);
		query.setMaxResults(25);
		List<HotEventBean> list =  query.list();
		getSession().beginTransaction().commit();
		this.getSession().close();
		return list;
	}

}
