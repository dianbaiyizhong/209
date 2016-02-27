/**
 *
 */
package com.qawaa.web.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import com.qawaa.data.bean.AuthorizeBean;
import com.qawaa.data.entity.SecurityAuthorize;
import com.qawaa.service.SecurityAuthorizeService;

/**
 * @author Ryan  2013-10-1  下午10:59:34
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 授权定时加载器，单例模式
 */
public class TokenReload extends Thread implements Runnable {
	private static final int MAX_TOKENS = 100;
	private static final long SLEEP_TIME = 15L;
	private ServletContext application;
	private SecurityAuthorizeService securityAuthorizeService;
	private boolean runStatus;
	private static TokenReload self = null;
	public synchronized static TokenReload INIT(){
		if(self == null)
			self = new TokenReload();
		return self;
	}
	private TokenReload(){
		super();
		this.runStatus = true;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		if(application.getAttribute("USER_TOKENS") == null){
			application.setAttribute("USER_TOKENS", new HashMap<String, AuthorizeBean>());
		}
		while(true){
			if(this.runStatus){
				List<SecurityAuthorize> authorizes = securityAuthorizeService.getSecurityAuthorizeByParams(null, 0, MAX_TOKENS);
				Map<String, AuthorizeBean> tokens = new HashMap<String, AuthorizeBean>(0);
				for(SecurityAuthorize authorize:authorizes){
					AuthorizeBean bean = new AuthorizeBean();
					bean.setId(authorize.getAutId());
					bean.setUser(authorize.getAutUser());
					bean.setStatus(authorize.getAutStatus());
					bean.setExpTime(authorize.getAutExpDate().getTime());
					tokens.put(authorize.getAutToken(), bean);
				}
				application.setAttribute("USER_TOKENS", tokens);
			}
			try {
				sleep(SLEEP_TIME * 60L * 1000L);
			} catch (InterruptedException e) {
				
			}
		}
	}
	/**
	 * @return the application
	 */
	public ServletContext getApplication() {
		return application;
	}
	/**
	 * @param application the application to set
	 */
	public void setApplication(ServletContext application) {
		this.application = application;
	}

	/**
	 * @param securityAuthorizeService the securityAuthorizeService to set
	 */
	public void setAuthorize(SecurityAuthorizeService securityAuthorizeService) {
		this.securityAuthorizeService = securityAuthorizeService;
	}
	/**
	 * @return the runStatus
	 */
	public boolean isRunStatus() {
		return runStatus;
	}
	/**
	 * @param runStatus the runStatus to set
	 */
	public void setRunStatus(boolean runStatus) {
		this.runStatus = runStatus;
	}
	
}
