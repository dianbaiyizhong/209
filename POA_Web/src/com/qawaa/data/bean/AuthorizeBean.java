/**
 *
 */
package com.qawaa.data.bean;

/**
 * @author Ryan  2013-10-1  下午10:47:09
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 授权信息BEAN
 */
public class AuthorizeBean {
	private Integer id;
	private String user;
	private boolean status;
	private long expTime;
	
	/**
	 * 
	 */
	public AuthorizeBean() {
		super();
	}
	/**
	 * @param id
	 * @param user
	 * @param status
	 * @param expTime
	 */
	public AuthorizeBean(Integer id, String user, boolean status, long expTime) {
		super();
		this.id = id;
		this.user = user;
		this.status = status;
		this.expTime = expTime;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	/**
	 * @return the expTime
	 */
	public long getExpTime() {
		return expTime;
	}
	/**
	 * @param expTime the expTime to set
	 */
	public void setExpTime(long expTime) {
		this.expTime = expTime;
	}
}
