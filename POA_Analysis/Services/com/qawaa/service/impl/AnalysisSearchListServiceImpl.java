/**
 * 
 */
package com.qawaa.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qawaa.dao.AnalysisSearchListDao;
import com.qawaa.data.entity.AnalysisSearchList;
import com.qawaa.service.AnalysisSearchListService;
import com.qawaa.utils.DateUtil;

/**
 * @author Ran Xu
 * @data 2014-3-10 下午5:02:41 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public class AnalysisSearchListServiceImpl implements AnalysisSearchListService {
	private AnalysisSearchListDao dao;
	
	/**
	 * @return the dao
	 */
	public AnalysisSearchListDao getAnalysisSearchListDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setAnalysisSearchListDao(AnalysisSearchListDao dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.AnalysisSearchListService#get(java.lang.Integer)
	 */
	@Override
	public AnalysisSearchList get(Integer id) {
		return dao.get(id);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.AnalysisSearchListService#getAnalysisSearchListByParamsAndPage(java.util.Map, int, int)
	 */
	@Override
	public List<AnalysisSearchList> getAnalysisSearchListByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults) {
		List<AnalysisSearchList> list = dao.getAnalysisSearchListByParamsAndPage(params, firstResult, maxResults);
		if(list == null)
			list = new ArrayList<AnalysisSearchList>(0);
		return list;
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.AnalysisSearchListService#getCountByParams(java.util.Map)
	 */
	@Override
	public int getCountByParams(Map<String, Object> params) {
		List<Integer> list = dao.getCountByParams(params);
		if(list == null || list.size() == 0)
			return 0;
		return list.get(0);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.AnalysisSearchListService#save(com.qawaa.data.entity.AnalysisSearchList)
	 */
	@Override
	public void save(AnalysisSearchList entity) {
		dao.save(entity);

	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.AnalysisSearchListService#getAnalysisSearchListByURLAndEvent(java.lang.String, java.lang.Integer)
	 */
	@Override
	public AnalysisSearchList getAnalysisSearchListByURLAndEvent(String urlMd5, Integer eventId) {
		if(urlMd5 == null || urlMd5.trim().isEmpty() || eventId == null)
			return null;
		Map<String, Object> params = new HashMap<String, Object>(2);
		params.put("aslUrlMd5", urlMd5);
		params.put("aslEventId", eventId);
		List<AnalysisSearchList> list = this.getAnalysisSearchListByParamsAndPage(params, 0, 1);
		if(list.size() == 0)
			return null;
		return list.get(0);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.AnalysisSearchListService#getWebCountByEventAndDate(java.lang.Integer, java.sql.Timestamp)
	 */
	@Override
	public int getWebCountByEventAndDate(Integer eventId, Timestamp date) {
		if(eventId == null || date == null)
			return 0;
		List<Integer> list = dao.getWebCountByEventAndDate(eventId, new Timestamp(DateUtil.getBeginTimeOfDay(date).getTime()), new Timestamp(DateUtil.getLastTimeOfDay(date).getTime()));
		if(list == null || list.size() == 0 || list.get(0) == null)
			return 0;
		return list.get(0).intValue();
	}

}
