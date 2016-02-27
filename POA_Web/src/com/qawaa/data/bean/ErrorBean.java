/**
 *
 */
package com.qawaa.data.bean;

import org.apache.struts2.json.annotations.JSON;

/**
 * @author Ryan  2013-10-2  下午11:55:21
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class ErrorBean {
	private Integer error_code;
	private String error_msg;
	private String request_uri;
	/**
	 * @return the error_code
	 */
	@JSON(name="code")
	public Integer getError_code() {
		return error_code;
	}
	/**
	 * @param error_code the error_code to set
	 */
	public void setError_code(Integer error_code) {
		this.error_code = error_code;
	}
	/**
	 * @return the error_msg
	 */
	@JSON(name="msg")
	public String getError_msg() {
		return error_msg;
	}
	/**
	 * @param error_msg the error_msg to set
	 */
	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}
	/**
	 * @return the request_uri
	 */
	@JSON(name="uri")
	public String getRequest_uri() {
		return request_uri;
	}
	/**
	 * @param request_uri the request_uri to set
	 */
	public void setRequest_uri(String request_uri) {
		this.request_uri = request_uri;
	}
	/**
	 * 
	 */
	public ErrorBean() {
		super();
	}
	
}
