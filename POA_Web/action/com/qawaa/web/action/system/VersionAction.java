/**
 *
 */
package com.qawaa.web.action.system;

import com.qawaa.data.entity.SystemVersion;
import com.qawaa.service.SystemVersionService;
import com.qawaa.web.action.BaseAction;

/**
 * @author Ryan  2013-10-13  下午11:44:36
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class VersionAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 836617839068899704L;
	private SystemVersionService systemVersionService;
	private String version;
	private String description;
	/**
	 * @return the systemVersionService
	 */
	public SystemVersionService getSystemVersionService() {
		return systemVersionService;
	}
	/**
	 * @param systemVersionService the systemVersionService to set
	 */
	public void setSystemVersionService(SystemVersionService systemVersionService) {
		this.systemVersionService = systemVersionService;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		SystemVersion v = this.systemVersionService.now();
		this.version = v.getVerName();
		this.description = v.getVerComment();
		return SUCCESS;
	}
	
}
