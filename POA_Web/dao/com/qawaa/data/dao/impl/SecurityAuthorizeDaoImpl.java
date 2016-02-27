/**
 *
 */
package com.qawaa.data.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qawaa.data.dao.SecurityAuthorizeDao;
import com.qawaa.data.entity.SecurityAuthorize;

/**
 * @author Ryan  2013-10-1  下午10:26:31
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class SecurityAuthorizeDaoImpl extends HibernateDaoSupport implements SecurityAuthorizeDao {

	/* (non-Javadoc)
	 * @see com.qawaa.data.dao.SecurityAuthorizeDao#getSecurityAuthorizeByParams(java.util.Map, int, int)
	 */
	@SuppressWarnings("unchecked")
	public List<SecurityAuthorize> getSecurityAuthorizeByParams(Map<String, Object> params, int firstResult, int maxResults) {
		DetachedCriteria dc = DetachedCriteria.forClass(SecurityAuthorize.class);
		this.setQuery(dc, params);
		
		return this.getHibernateTemplate().findByCriteria(dc, firstResult, maxResults);
	}
	
	private void setQuery(DetachedCriteria dc, Map<String, Object> params){
		if(params == null || params.size() == 0)
			return;
		if(params.containsKey("autId")){
			dc.add(Restrictions.eq("autId", params.get("autId")));
		}
		if(params.containsKey("autToken")){
			dc.add(Restrictions.eq("autToken", params.get("autToken")));
		}
		if(params.containsKey("autUser")){
			dc.add(Restrictions.eq("autUser", params.get("autUser")));
		}
		if(params.containsKey("ilikeAutUser")){
			dc.add(Restrictions.ilike("autUser", (String) params.get("ilikeAutUser"), MatchMode.ANYWHERE));
		}
		if(params.containsKey("autExpDate")){
			dc.add(Restrictions.eq("autExpDate", params.get("autExpDate")));
		}
		if(params.containsKey("geAutExpDate")){
			dc.add(Restrictions.ge("autExpDate", params.get("geAutExpDate")));
		}
		if(params.containsKey("leAutExpDate")){
			dc.add(Restrictions.le("autExpDate", params.get("leAutExpDate")));
		}
		if(params.containsKey("autStatus")){
			dc.add(Restrictions.eq("autStatus", params.get("autStatus")));
		}
	}
}
