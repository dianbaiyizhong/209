/**
 * 
 */
package com.qawaa.control;



import java.sql.Timestamp;
import org.springframework.context.ApplicationContext;

import com.qawaa.data.entity.EventList;
import com.qawaa.data.entity.PointMultipleHourly;
import com.qawaa.data.entity.PointMultipleRealTime;
import com.qawaa.framework.ApplicationContextFactory;
import com.qawaa.service.EventListService;
import com.qawaa.service.PointMultipleHourlyService;
import com.qawaa.service.PointMultipleRealTimeService;

/**
 * @author Ran Xu
 * @data 2014-2-14 上午10:12:27 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public class EventRealTimePointAnalysisControl {
	private volatile static EventRealTimePointAnalysisControl Instance;
	private ApplicationContext context;
	private EventRealTimePointAnalysisControl(){
		context = ApplicationContextFactory.getInstance();
	}
	/**
	 * 实例化
	 * @return
	 */
	public static EventRealTimePointAnalysisControl getInstance(){
		if(Instance == null){
			synchronized(EventRealTimePointAnalysisControl.class){
				if(Instance == null){
					Instance = new EventRealTimePointAnalysisControl();
				}
			}
		}
		return Instance;
	}
	
	/**
	 * 获取主键下于指定值的下一个舆情事件，若不存在则返回第一个
	 * @param id
	 * @return
	 */
	public EventList getNextEventList(Integer id){
		EventListService service = (EventListService) context.getBean("eventListService");
		if(id.intValue() <= 0)
			return service.getLastNormalEvent();
		EventList event = service.getNextNormalEvent(id);
		if(event == null)
			event = service.getLastNormalEvent();
		return event;
	}
	
	/**
	 * 根据事件ID获取最新的一条每时指数数据
	 * @param eventId
	 * @return
	 */
	public PointMultipleHourly getLastPointMultipleHourlyByEvent(Integer eventId) {
		PointMultipleHourlyService service = (PointMultipleHourlyService) context.getBean("pointMultipleHourlyService");
		return service.getLastPointMultipleHourlyByEvent(eventId);
	}
	
	/**
	 * 插入新数据
	 * @param point
	 * @param eventId
	 */
	public void insertPointMultipleRealTime(Integer point, Integer eventId){
		PointMultipleRealTime entity = new PointMultipleRealTime();
		entity.setAmpEventId(eventId);
		entity.setAmpDate(new Timestamp(System.currentTimeMillis()));
		entity.setAmpPoint(point);
		entity.setAmpStatus(true);
		PointMultipleRealTimeService service = (PointMultipleRealTimeService) context.getBean("pointMultipleRealTimeService");
		service.save(entity);
	}
		
}
