/**
 *
 */
package com.qawaa.web.action.point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qawaa.data.entity.PointMultipleRealTime;
import com.qawaa.service.PointMultipleRealTimeService;
import com.qawaa.web.action.BaseAction;

/**
 * @author Ryan  2013-10-11  下午10:16:38
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 根据多个事件ID批量获取这些事件的实时指数
 */
public class BatchMultipleRealTimePointAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4962332120605222011L;
	private PointMultipleRealTimeService pointMultipleRealTimeService;
	private Integer[] event_ids;
	private List<PointMultipleRealTime> points;
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
	 * @param pointMultipleRealTimeService the pointMultipleRealTimeService to set
	 */
	public void setPointMultipleRealTimeService(PointMultipleRealTimeService pointMultipleRealTimeService) {
		this.pointMultipleRealTimeService = pointMultipleRealTimeService;
	}
	/**
	 * @return the event_ids
	 */
	public Integer[] getEvent_ids() {
		return event_ids;
	}
	/**
	 * @param event_ids the event_ids to set
	 */
	public void setEvent_ids(Integer[] event_ids) {
		this.event_ids = event_ids;
	}
	/**
	 * @return the points
	 */
	public List<PointMultipleRealTime> getPoints() {
		return points;
	}
	/**
	 * @param points the points to set
	 */
	public void setPoints(List<PointMultipleRealTime> points) {
		this.points = points;
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
		if(event_ids == null || event_ids.length == 0){
			request.setAttribute("error_code", 20003);
			return "error";
		}
		points = new ArrayList<PointMultipleRealTime>();
		for(Integer id:event_ids){
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("ampEventId", id);
			params.put("ampStatus", true);
			points.addAll(pointMultipleRealTimeService.getMultiplePointByParamsAndPage(params, 0, 1));
		}
		next = 0;
		time = System.currentTimeMillis();
		total = points.size();
		return super.execute();
	}
	

}
