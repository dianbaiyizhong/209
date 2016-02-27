/**
 *
 */
package com.qawaa.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.qawaa.data.dao.ConfigWarningLineDao;
import com.qawaa.data.entity.ConfigWarningLine;
import com.qawaa.service.ConfigWarningLineService;

/**
 * @author Ryan  2013-10-8  下午11:47:51
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class ConfigWarningLineServiceImpl implements ConfigWarningLineService {
	private ConfigWarningLineDao dao;
	
	/**
	 * @return the dao
	 */
	public ConfigWarningLineDao getConfigWarningLineDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setConfigWarningLineDao(ConfigWarningLineDao dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.ConfigWarningLineService#loadNormalConfigWarningLine()
	 */
	public List<ConfigWarningLine> loadNormalConfigWarningLine() {
		List<ConfigWarningLine> list = dao.loadNormalConfigWarningLine();
		if(list == null) 
			list = new ArrayList<ConfigWarningLine>(0);
		return list;
	}

}
