/**
 *
 */
package com.qawaa.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qawaa.data.dao.SystemVersionDao;
import com.qawaa.data.entity.SystemVersion;
import com.qawaa.service.SystemVersionService;

/**
 * @author Ryan  2013-10-13  下午11:32:30
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class SystemVersionServiceImpl implements SystemVersionService {
	private SystemVersionDao dao;
	
	/**
	 * @return the dao
	 */
	public SystemVersionDao getSystemVersionDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setSystemVersionDao(SystemVersionDao dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.SystemVersionService#getSystemVersionByParamsAndPage(java.util.Map, int, int)
	 */
	public List<SystemVersion> getSystemVersionByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults) {
		List<SystemVersion> list = dao.getSystemVersionByParamsAndPage(params, firstResult, maxResults);
		if(list == null)
			list = new ArrayList<SystemVersion>(0);
		return list;
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.SystemVersionService#now()
	 */
	public SystemVersion now() {
		Map<String, Object> params = new HashMap<String, Object>(1);
		params.put("verStatus", true);
		List<SystemVersion> list = dao.getSystemVersionByParamsAndPage(params, 0, 1);
		if(list.size() == 0){
			SystemVersion version = new SystemVersion("error", true, "");
			return version;
		}
		return list.get(0);
	}

}
