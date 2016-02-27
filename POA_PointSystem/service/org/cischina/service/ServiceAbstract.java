/**
 * 
 */
package org.cischina.service;

import java.util.List;

/**
 * @author Ran Xu
 * @data 2014-5-8 下午2:04:16 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 部分通用service方法
 *
 */
public class ServiceAbstract {
	/**
	 * 获取结果总数
	 * @param list
	 * @return
	 */
	protected int getCount(List<Integer> list) {
		if(list == null || list.size() == 0)
			return 0;
		return list.get(0).intValue();
	}
}
