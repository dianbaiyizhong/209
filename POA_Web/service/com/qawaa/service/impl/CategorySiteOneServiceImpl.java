/**
 *
 */
package com.qawaa.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.qawaa.data.dao.CategorySiteOneDao;
import com.qawaa.data.entity.CategorySiteOne;
import com.qawaa.service.CategorySiteOneService;

/**
 * @author Ryan  2013-10-7  下午7:27:39
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class CategorySiteOneServiceImpl implements CategorySiteOneService {
	private CategorySiteOneDao dao;
	
	/**
	 * @return the dao
	 */
	public CategorySiteOneDao getCategorySiteOneDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setCategorySiteOneDao(CategorySiteOneDao dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.CategorySiteOneService#loadAll()
	 */
	public List<CategorySiteOne> loadAll() {
		List<CategorySiteOne> list = dao.loadAll();
		if(list == null)
			list = new ArrayList<CategorySiteOne>(0);
		return list;
	}

}
