/**
 *
 */
package com.qawaa.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.qawaa.data.dao.CategoryAreaDao;
import com.qawaa.data.entity.CategoryArea;
import com.qawaa.service.CategoryAreaService;

/**
 * @author Ryan  2013-10-9  下午11:11:24
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class CategoryAreaServiceImpl implements CategoryAreaService {
	private CategoryAreaDao dao;
	
	/**
	 * @return the dao
	 */
	public CategoryAreaDao getCategoryAreaDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setCategoryAreaDao(CategoryAreaDao dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.CategoryAreaService#loadNormal()
	 */
	public List<CategoryArea> loadNormal() {
		List<CategoryArea> list = dao.loadNormal();
		if(list == null)
			list = new  ArrayList<CategoryArea>(0);
		return list;
	}

}
