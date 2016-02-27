/**
 * 
 */
package com.qawaa.control;


import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.ApplicationContext;

import com.qawaa.data.entity.AnalysisSearchList;
import com.qawaa.framework.ApplicationContextFactory;
import com.qawaa.service.AnalysisSearchListService;
import com.qawaa.utils.security.MD5;

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
public class AnalysisSearchListControl {
	private volatile static AnalysisSearchListControl Instance;
	private ApplicationContext context;
	private AnalysisSearchListControl(){
		context = ApplicationContextFactory.getInstance();
	}
	/**
	 * 实例化
	 * @return
	 */
	public static AnalysisSearchListControl getInstance(){
		if(Instance == null){
			synchronized(AnalysisSearchListControl.class){
				if(Instance == null){
					Instance = new AnalysisSearchListControl();
				}
			}
		}
		return Instance;
	}
	
	/**
	 * 根据URL和事件ID获取，不存在时返回null
	 * @param url
	 * @param eventId
	 * @return
	 */
	public AnalysisSearchList getEventList(String url, Integer eventId){
		AnalysisSearchListService service = (AnalysisSearchListService) context.getBean("analysisSearchListService");
		return service.getAnalysisSearchListByURLAndEvent(MD5.MD5Encode(url), eventId);
	}
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(AnalysisSearchList entity){
		AnalysisSearchListService service = (AnalysisSearchListService) context.getBean("analysisSearchListService");
		service.save(entity);
	}
	
	/**
	 * 根据事件和时间获取改时间所在天的文章总数
	 * @param eventId
	 * @param date
	 * @return
	 */
	public int getWebCountByEventAndDate(Integer eventId, Date date) {
		AnalysisSearchListService service = (AnalysisSearchListService) context.getBean("analysisSearchListService");
		return service.getWebCountByEventAndDate(eventId, new Timestamp(date.getTime()));
	}
		
}
