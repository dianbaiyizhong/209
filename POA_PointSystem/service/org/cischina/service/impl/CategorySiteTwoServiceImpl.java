/**
 *
 */
package org.cischina.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cischina.dao.CategorySiteTwoDao;
import org.cischina.data.entity.CategorySiteTwo;
import org.cischina.service.CategorySiteTwoService;

/**
 * @author Ryan
 * @datetime 2014-6-4 上午12:25:53
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
	 * @see org.cischina.service.CategorySiteTwoService#get(java.lang.Integer)
	 */
	@Override
	public CategorySiteTwo get(Integer id) {
		return dao.get(id);
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.CategorySiteTwoService#saveOrUpdate(org.cischina.data.entity.CategorySiteTwo)
	 */
	@Override
	public void saveOrUpdate(CategorySiteTwo entity) {
		dao.saveOrUpdate(entity);

	}

	/* (non-Javadoc)
	 * @see org.cischina.service.CategorySiteTwoService#del(org.cischina.data.entity.CategorySiteTwo)
	 */
	@Override
	public void del(CategorySiteTwo entity) {
		dao.del(entity);
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.CategorySiteTwoService#del(java.lang.Integer)
	 */
	@Override
	public void del(Integer id) {
		dao.del(id);

	}

	/* (non-Javadoc)
	 * @see org.cischina.service.CategorySiteTwoService#getEntitiesByParamsAndPages(java.util.Map, int, int)
	 */
	@Override
	public List<CategorySiteTwo> getEntitiesByParamsAndPages(Map<String, Object> params, int firstResult, int maxResults) {
		@SuppressWarnings("unchecked")
		List<CategorySiteTwo> list = (List<CategorySiteTwo>) dao.getEntitiesByParamsAndPages(params, firstResult, maxResults);
		if(list == null)
			list = new ArrayList<CategorySiteTwo>(0);
		
		return list;
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.CategorySiteTwoService#getCountByParamsAndPages(java.util.Map)
	 */
	@Override
	public int getCountByParamsAndPages(Map<String, Object> params) {
		List<Integer> list = dao.getCountByParamsAndPages(params);
		if(list == null || list.size() == 0)
			return 0;
		return list.get(0).intValue();
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.CategorySiteTwoService#getEntitiesBySiteOne(java.lang.Integer)
	 */
	@Override
	public List<CategorySiteTwo> getEntitiesBySiteOne(Integer siteOneId) {
		if(siteOneId == null)
			return null;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("cstStatus", true);
		params.put("cstOneId", siteOneId);
		return this.getEntitiesByParamsAndPages(params, 0, 20);
	}

}
