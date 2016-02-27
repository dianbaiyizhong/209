/**
 *
 */
package com.qawaa.web.action.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qawaa.data.entity.EventList;
import com.qawaa.service.EventListService;
import com.qawaa.web.action.BaseAction;

/**
 * @author Ryan  2013-9-29  下午9:54:40
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 获取综合推荐前10条数据
 */
public class EventsRecommendTimeLineAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6926788975361007137L;
	private EventListService eventListService;
	private List<EventList> events;
	private Integer next;
	private Integer total;
	private Long time;
	
	/**
	 * @return the eventListService
	 */
	public EventListService getEventListService() {
		return eventListService;
	}

	/**
	 * @param eventListService the eventListService to set
	 */
	public void setEventListService(EventListService eventListService) {
		this.eventListService = eventListService;
	}


	/**
	 * @return the events
	 */
	public List<EventList> getEvents() {
		return events;
	}

	/**
	 * @param events the events to set
	 */
	public void setEvents(List<EventList> events) {
		this.events = events;
	}

	/**
	 * @return the next
	 */
	public Integer getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Integer next) {
		this.next = next;
	}

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the time
	 */
	public Long getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Long time) {
		this.time = time;
	}

	/**
	 * 获取最新的几条数据
	 * @return
	 */
	public String timeline(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("eventStatus", 20);
		Map<String, Boolean> orders = new HashMap<String, Boolean>();
		orders.put("eventTop", false);
		orders.put("eventOrder", false);
		orders.put("eventId", false);
		events = eventListService.getEventListByParamsAndPage(params, orders, 0, 10);
		if(events.size() == 0){
			next = 0;
		}else{
			next = events.get(events.size() - 1).getEventId();
		}
		total = events.size();
		time = System.currentTimeMillis();
		return SUCCESS;
	}

}
