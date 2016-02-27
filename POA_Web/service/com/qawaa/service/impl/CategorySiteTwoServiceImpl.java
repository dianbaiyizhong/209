/**
 *
 */
package com.qawaa.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.qawaa.data.dao.CategorySiteTwoDao;
import com.qawaa.data.entity.CategorySiteTwo;
import com.qawaa.service.CategorySiteTwoService;

/**
 * @author Ryan  2013-10-8  上午12:26:03
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class CategorySiteTwoServiceImpl implements CategorySiteTwoService {
	private CategorySiteTwoDao dao;
	
	/**
	 * @return the dao
	 */
	public CategorySiteTwoDao getCategorySiteTwoDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setCategorySiteTwoDao(CategorySiteTwoDao dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.CategorySiteTwoService#getCategorySiteTwoByParamsAndPage(java.util.Map, int, int)
	 */
	public List<CategorySiteTwo> getCategorySiteTwoByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults) {
		List<CategorySiteTwo> list = dao.getCategorySiteTwoByParamsAndPage(params, firstResult, maxResults);
		if(list == null)
			list = new ArrayList<CategorySiteTwo>(0);
		return list;
	}

}
