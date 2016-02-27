/**
 *
 */
package com.qawaa.data.dao;

import java.util.List;

import com.qawaa.data.entity.CategoryEvent;

/**
 * @author Ryan  2013-10-9  下午9:33:49
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public interface CategoryEventDao {
	/**
	 * 获取所有状态正常的数据
	 * @return
	 */
	public List<CategoryEvent> loadNormal();
	/**
	 * @param id
	 * @return
	 */
	public CategoryEvent get(Integer id);
}
