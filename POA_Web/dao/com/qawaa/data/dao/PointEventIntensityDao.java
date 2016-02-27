/**
 * 
 */
package com.qawaa.data.dao;

import java.util.List;

import com.qawaa.data.entity.PointEventIntensity;

/**
 * @author Ran Xu
 * @data 2014-3-10 上午9:27:18 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public interface PointEventIntensityDao {
	/**
	 * 根据事件ID获取最近的一条强度信息
	 * @param eventId
	 * @return
	 */
	public List<PointEventIntensity> getLastIntensityByEvent(Integer eventId);
}
