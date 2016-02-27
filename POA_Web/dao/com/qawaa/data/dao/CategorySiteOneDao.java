/**
 *
 */
package com.qawaa.data.dao;

import java.util.List;

import com.qawaa.data.entity.CategorySiteOne;

/**
 * @author Ryan  2013-10-7  下午7:23:38
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public interface CategorySiteOneDao {
	/**
	 * 获取所有
	 * @return
	 */
	public List<CategorySiteOne> loadAll();
}
