/**
 * 
 */
package com.qawaa.control;


import org.springframework.context.ApplicationContext;

import com.qawaa.data.entity.EventList;
import com.qawaa.framework.ApplicationContextFactory;
import com.qawaa.service.EventListService;

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
public class WebScanControl {
	private volatile static WebScanControl Instance;
	private ApplicationContext context;
	private WebScanControl(){
		context = ApplicationContextFactory.getInstance();
	}
	/**
	 * 实例化
	 * @return
	 */
	public static WebScanControl getInstance(){
		if(Instance == null){
			synchronized(WebScanControl.class){
				if(Instance == null){
					Instance = new WebScanControl();
				}
			}
		}
		return Instance;
	}
	
	/**
	 * 根据主键获取事件
	 * @param id
	 * @return
	 */
	public EventList getEventList(Integer id){
		EventListService service = (EventListService) context.getBean("eventListService");
		return service.get(id);
	}
	
	/**
	 * 判断事件表中数据是否为空，为空返回true
	 * @return
	 */
	public boolean isExistEventList(){
		EventListService service = (EventListService) context.getBean("eventListService");
		return service.isExistEventList();
	}
	
	/**
	 * 获取下一个需要扫描的舆情事件
	 * @return
	 */
	public EventList getNextEvent(){
		EventListService service = (EventListService) context.getBean("eventListService");
		return service.getRequestEventList();
	}
	
	/**
	 * 更新事件状态至监测时间完成（41）
	 * @param id
	 */
	public void updateExpired(Integer id){
		EventListService service = (EventListService) context.getBean("eventListService");
		service.updateStatus(id, 41);
	}
	
	/**
	 * 更新事件状态至正常（20）
	 * @param id
	 */
	public void updateNormal(Integer id){
		EventListService service = (EventListService) context.getBean("eventListService");
		service.updateStatus(id, 20);
	}
	/**
	 * 更新事件状态至异常状态（60~69）
	 * @param id
	 */
	public void updateException(Integer id, Integer status){
		EventListService service = (EventListService) context.getBean("eventListService");
		if(status >=60 && status <= 69)
			service.updateStatus(id, status);
	}
	
	/**
	 * 更新事件检索信息
	 * @param id
	 * @param date
	 * @param number
	 * @param status
	 */
	public void updateScanDate(Integer id){
		EventListService service = (EventListService) context.getBean("eventListService");
		service.updateScanDate(id);
	}
	
}
