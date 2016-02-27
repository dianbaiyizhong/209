/**
 * 
 */
package org.cischina.dao;

import java.util.List;

import org.cischina.data.entity.EventList;
import org.cischina.framework.hibernate3.HibernateDaoInterface;

/**
 * @author Ran Xu
 * @data 2014-5-9 下午5:14:21 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public interface EventListDao extends HibernateDaoInterface {
	/**
	 * 获取10条推荐的事件
	 * @return
	 */
	public List<EventList> getRecommendEvents();
}
