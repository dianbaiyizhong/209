/**
 *
 */
package com.qawaa.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.qawaa.data.dao.SecurityAuthorizeDao;
import com.qawaa.data.entity.SecurityAuthorize;
import com.qawaa.service.SecurityAuthorizeService;

/**
 * @author Ryan  2013-10-1  下午10:35:59
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class SecurityAuthorizeServiceImpl implements SecurityAuthorizeService {
	private SecurityAuthorizeDao dao;
	
	/**
	 * @return the dao
	 */
	public SecurityAuthorizeDao getSecurityAuthorizeDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setSecurityAuthorizeDao(SecurityAuthorizeDao dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.SecurityAuthorizeService#getSecurityAuthorizeByParams(java.util.Map, int, int)
	 */
	public List<SecurityAuthorize> getSecurityAuthorizeByParams(Map<String, Object> params, int firstResult, int maxResults) {
		List<SecurityAuthorize> list = dao.getSecurityAuthorizeByParams(params, firstResult, maxResults);
		if(list == null)
			list = new ArrayList<SecurityAuthorize>(0);
		return list;
	}

}
