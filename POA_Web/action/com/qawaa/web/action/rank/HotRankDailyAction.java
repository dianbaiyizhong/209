/**
 *
 */
package com.qawaa.web.action.rank;

import java.util.Date;
import java.util.List;

import com.qawaa.data.bean.HotEventBean;
import com.qawaa.service.PointMultipleDailyService;
import com.qawaa.web.action.BaseAction;

/**
 * @author Ryan
 * @datetime 2014-6-4 下午9:02:31
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 每日指数最高事件排行榜
 */
public class HotRankDailyAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6695429394348155672L;
	
	private PointMultipleDailyService pointMultipleDailyService;
	private List<HotEventBean> hotEvents;
	private Long time = System.currentTimeMillis();
	private Integer total = 0;
	/**
	 * @return the pointMultipleDailyService
	 */
	public PointMultipleDailyService getPointMultipleDailyService() {
		return pointMultipleDailyService;
	}
	/**
	 * @param pointMultipleDailyService the pointMultipleDailyService to set
	 */
	public void setPointMultipleDailyService(PointMultipleDailyService pointMultipleDailyService) {
		this.pointMultipleDailyService = pointMultipleDailyService;
	}
	/**
	 * @return the hotEvents
	 */
	public List<HotEventBean> getHotEvents() {
		return hotEvents;
	}
	/**
	 * @param hotEvents the hotEvents to set
	 */
	public void setHotEvents(List<HotEventBean> hotEvents) {
		this.hotEvents = hotEvents;
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

	public String today(){
		this.hotEvents = pointMultipleDailyService.getDailyHotEvent(new Date());
		total = hotEvents.size();
		return SUCCESS;
	}
}
