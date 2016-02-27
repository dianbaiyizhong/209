/**
 *
 */
package com.qawaa.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.qawaa.data.dao.CategoryEventDao;
import com.qawaa.data.entity.CategoryEvent;
import com.qawaa.service.CategoryEventService;

/**
 * @author Ryan  2013-10-9  下午9:44:37
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class CategoryEventServiceImpl implements CategoryEventService {
	private CategoryEventDao dao;
	
	/**
	 * @return the dao
	 */
	public CategoryEventDao getCategoryEventDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setCategoryEventDao(CategoryEventDao dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.CategoryEventService#loadNormal()
	 */
	public List<CategoryEvent> loadNormal() {
		List<CategoryEvent> list = dao.loadNormal();
		if(list == null)
			list = new ArrayList<CategoryEvent>(0);
		return list;
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.CategoryEventService#get(java.lang.Integer)
	 */
	public CategoryEvent get(Integer id) {
		return dao.get(id);
	}

}
