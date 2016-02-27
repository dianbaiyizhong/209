/**
 * 
 */
package com.qawaa.service;

/**
 * @author Ran Xu
 * @data 2014-3-10 上午9:32:12 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public interface PointEventIntensityService {
	/**
	 * 根据事件ID获取最近的一条强度信息
	 * @param eventId
	 * @return
	 */
	public int getLastIntensityByEvent(Integer eventId);
	
}
