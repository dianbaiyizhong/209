/**
 *
 */
package com.qawaa.data.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qawaa.data.dao.EventListDao;
import com.qawaa.data.entity.EventList;

/**
 * @author Ryan  2013-9-28  上午10:57:46
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class EventListDaoImpl extends HibernateDaoSupport implements EventListDao {

	/* (non-Javadoc)
	 * @see com.qawaa.data.dao.EventListDao#getEventListByParamsAndPage(java.util.Map, java.util.Map, int, int)
	 */
	@SuppressWarnings("unchecked")
	public List<EventList> getEventListByParamsAndPage(Map<String, Object> params, Map<String, Boolean> orders, int firstResult, int maxResults) {
		DetachedCriteria dc = DetachedCriteria.forClass(EventList.class);
		this.setQuery(dc, params);
		this.setOrder(dc, orders);
		return this.getHibernateTemplate().findByCriteria(dc, firstResult, maxResults);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.data.dao.EventListDao#getCountByParams(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> getCountByParams(Map<String, Object> params) {
		DetachedCriteria dc = DetachedCriteria.forClass(EventList.class);
		this.setQuery(dc, params);
		dc.setProjection(Projections.count("eventId"));
		return this.getHibernateTemplate().findByCriteria(dc, 0, 1);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.data.dao.EventListDao#get(java.lang.Integer)
	 */
	public EventList get(Integer id) {
		if(id == null)
		return null;
		return this.getHibernateTemplate().get(EventList.class, id);
	}
	
	/**
	 * @param dc
	 * @param params
	 */
	private void setQuery(DetachedCriteria dc, Map<String, Object> params){
		if(params == null){
			return;
		}
		if(params.containsKey("eventId")){
			dc.add(Restrictions.eq("eventId", params.get("eventId")));
		}
		if(params.containsKey("geEventId")){
			dc.add(Restrictions.ge("eventId", params.get("geEventId")));
		}
		if(params.containsKey("gtEventId")){
			dc.add(Restrictions.gt("eventId", params.get("gtEventId")));
		}
		if(params.containsKey("leEventId")){
			dc.add(Restrictions.le("eventId", params.get("leEventId")));
		}
		if(params.containsKey("ltEventId")){
			dc.add(Restrictions.lt("eventId", params.get("ltEventId")));
		}
		if(params.containsKey("neEventId")){
			dc.add(Restrictions.ne("eventId", params.get("")));
		}
		if(params.containsKey("eventTitle")){
			dc.add(Restrictions.eq("eventTitle", params.get("eventTitle")));
		}
		if(params.containsKey("ilikeEventTitle")){
			dc.add(Restrictions.ilike("eventTitle", (String) params.get("ilikeEventTitle"), MatchMode.ANYWHERE));
		}
		if(params.containsKey("ilikeEventTitles")){
			String[] values = (String[]) params.get("ilikeEventTitles");
			if(values != null && values.length > 0){
				for(String val:values){
					if(val != null && !val.trim().isEmpty()){
						dc.add(Restrictions.ilike("eventTitle", val, MatchMode.ANYWHERE));
					}
				}
			}
		}

		if(params.containsKey("eventKeyword")){
			dc.add(Restrictions.eq("eventKeyword", params.get("eventKeyword")));
		}
		if(params.containsKey("ilikeEventKeyword")){
			dc.add(Restrictions.ilike("eventKeyword", (String) params.get("ilikeEventKeyword"), MatchMode.ANYWHERE));
		}
		if(params.containsKey("ilikeEventCategory")){
			dc.add(Restrictions.ilike("eventCategory", (String) params.get("ilikeEventCategory"), MatchMode.ANYWHERE));
		}
		if(params.containsKey("eventDate")){
			dc.add(Restrictions.eq("eventDate", params.get("eventDate")));
		}
		if(params.containsKey("geEventDate")){
			dc.add(Restrictions.ge("eventDate", params.get("geEventDate")));
		}
		if(params.containsKey("leEventDate")){
			dc.add(Restrictions.le("eventDate", params.get("leEventDate")));
		}
		if(params.containsKey("eventStatus")){
			dc.add(Restrictions.eq("eventStatus", params.get("eventStatus")));
		}
		if(params.containsKey("neEventStatus")){
			dc.add(Restrictions.ne("eventStatus", params.get("neEventStatus")));
		}
		if(params.containsKey("gtEventStatus")){
			dc.add(Restrictions.gt("eventStatus", params.get("gtEventStatus")));
		}
		if(params.containsKey("ltEventStatus")){
			dc.add(Restrictions.lt("eventStatus", params.get("ltEventStatus")));
		}
		if(params.containsKey("eventExpand")){
			dc.add(Restrictions.eq("eventExpand", params.get("eventExpand")));
		}
		if(params.containsKey("eventExp")){
			dc.add(Restrictions.eq("eventExp", params.get("eventExp")));
		}
		if(params.containsKey("eventTop")){
			dc.add(Restrictions.eq("eventTop", params.get("eventTop")));
		}
		if(params.containsKey("eventOrder")){
			dc.add(Restrictions.eq("eventOrder", params.get("eventOrder")));
		}
		if(params.containsKey("geEventExp")){
			dc.add(Restrictions.ge("eventExp", params.get("geEventExp")));
		}
		if(params.containsKey("leEventExp")){
			dc.add(Restrictions.le("eventExp", params.get("leEventExp")));
		}
		if(params.containsKey("eventRecovery")){
			dc.add(Restrictions.eq("eventRecovery", params.get("eventRecovery")));
		}
	}
	
	private void setOrder(DetachedCriteria dc, Map<String, Boolean> orders){
		if(orders == null || orders.size() == 0){
			return;
		}
		if(orders.containsKey("eventTop")){
			if(orders.get("eventTop")){
				dc.addOrder(Order.asc("eventTop"));
			}else{
				dc.addOrder(Order.desc("eventTop"));
			}
		}
		if(orders.containsKey("eventOrder")){
			if(orders.get("eventOrder")){
				dc.addOrder(Order.asc("eventOrder"));
			}else{
				dc.addOrder(Order.desc("eventOrder"));
			}
		}
		if(orders.containsKey("eventStart")){
			if(orders.get("eventStart")){
				dc.addOrder(Order.asc("eventStart"));
			}else{
				dc.addOrder(Order.desc("eventStart"));
			}
		}
		if(orders.containsKey("eventId")){
			if(orders.get("eventId")){
				dc.addOrder(Order.asc("eventId"));
			}else{
				dc.addOrder(Order.desc("eventId"));
			}
		}
		
	}

}
