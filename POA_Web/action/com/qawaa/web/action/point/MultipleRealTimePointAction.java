/**
 *
 */
package com.qawaa.web.action.point;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.qawaa.data.entity.EventList;
import com.qawaa.data.entity.PointMultipleRealTime;
import com.qawaa.service.EventListService;
import com.qawaa.service.PointMultipleRealTimeService;
import com.qawaa.web.action.BaseAction;

/**
 * @author Ryan  2013-10-10  下午4:41:24
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 获取单个舆情事件的实时综合指数
 */
public class MultipleRealTimePointAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3941582191465466147L;
	private EventListService eventListService;
	private PointMultipleRealTimeService pointMultipleRealTimeService;
	private Integer event_id;
	private PointMultipleRealTime event;
	private Integer point_id;
	private Integer total;
	private Integer next;
	private Long time;
	/**
	 * @return the pointMultipleRealTimeService
	 */
	public PointMultipleRealTimeService getPointMultipleRealTimeService() {
		return pointMultipleRealTimeService;
	}
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
	 * @param pointMultipleRealTimeService the pointMultipleRealTimeService to set
	 */
	public void setPointMultipleRealTimeService(PointMultipleRealTimeService pointMultipleRealTimeService) {
		this.pointMultipleRealTimeService = pointMultipleRealTimeService;
	}
	/**
	 * @return the event_id
	 */
	public Integer getEvent_id() {
		return event_id;
	}
	/**
	 * @param event_id the event_id to set
	 */
	public void setEvent_id(Integer event_id) {
		this.event_id = event_id;
	}
	/**
	 * @return the point
	 */
	@JSON(name="p")
	public PointMultipleRealTime getEvent() {
		return event;
	}
	/**
	 * @param point the point to set
	 */
	public void setEvent(PointMultipleRealTime event) {
		this.event = event;
	}
	/**
	 * @return the point_id
	 */
	public Integer getPoint_id() {
		return point_id;
	}
	/**
	 * @param point_id the point_id to set
	 */
	public void setPoint_id(Integer point_id) {
		this.point_id = point_id;
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
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if(event_id == null){
			request.setAttribute("error_code", 20003);
			return "error";
		}
		EventList event = eventListService.get(event_id);
		if(event == null || event.getEventStatus().intValue() <= 10){
			request.setAttribute("error_code", 30201);
			return "error";
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ampEventId", event_id);
		params.put("ampStatus", true);
		if(point_id != null){
			params.put("gtAmpId", point_id);
		}
		List<PointMultipleRealTime> list = pointMultipleRealTimeService.getMultiplePointByParamsAndPage(params, 0, 1);
		if(list != null && list.size() > 0){
			this.event = list.get(0);
			next = this.event.getAmpId();
		}else{
			next = 0;
		}
		time = System.currentTimeMillis();
		total = list.size();
		return SUCCESS;
	}
	

}
