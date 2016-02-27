/**
 * 
 */
package com.qawaa.control;



import java.sql.Timestamp;

import org.springframework.context.ApplicationContext;

import com.qawaa.data.entity.PointMultipleRealTime;
import com.qawaa.framework.ApplicationContextFactory;
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
public class PointMultipleRealTimeControl {
	private volatile static PointMultipleRealTimeControl Instance;
	private ApplicationContext context;
	private PointMultipleRealTimeControl(){
		context = ApplicationContextFactory.getInstance();
	}
	/**
	 * 实例化
	 * @return
	 */
	public static PointMultipleRealTimeControl getInstance(){
		if(Instance == null){
			synchronized(PointMultipleRealTimeControl.class){
				if(Instance == null){
					Instance = new PointMultipleRealTimeControl();
				}
			}
		}
		return Instance;
	}
	
	/**
	 * 根据eventId获取最新的一条指数
	 * 
	 * @param eventId
	 * @return
	 */
	public int getNewPointByEventId(Integer eventId){
		PointMultipleRealTimeService service = (PointMultipleRealTimeService) context.getBean("pointMultipleRealTimeService");
		PointMultipleRealTime point = service.getNewPoint(eventId);
		if(point == null){
			return 0;
		}
		return point.getAmpPoint();
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
