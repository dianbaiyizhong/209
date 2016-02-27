/**
 *
 */
package org.cischina.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/**
 * @author Ryan  2013-2-25  下午11:22:12
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment ajax表单提交相应
 */
public class AjaxDoneAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5077471154732434722L;
	private int statusCode;
	private String message;
	private String navTabId;
	private String rel;
	private String callbackType;
	private String forwardUrl;

	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		try {
			this.message = URLDecoder.decode(message, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			this.message = this.getText("gobal.alert.fail.params.error");
		}
	}

	/**
	 * @return the navTabId
	 */
	public String getNavTabId() {
		return navTabId;
	}

	/**
	 * @param navTabId the navTabId to set
	 */
	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}

	/**
	 * @return the rel
	 */
	public String getRel() {
		return rel;
	}

	/**
	 * @param rel the rel to set
	 */
	public void setRel(String rel) {
		this.rel = rel;
	}

	/**
	 * @return the callbackType
	 */
	public String getCallbackType() {
		return callbackType;
	}

	/**
	 * @param callbackType the callbackType to set
	 */
	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}

	/**
	 * @return the forwardUrl
	 */
	public String getForwardUrl() {
		return forwardUrl;
	}

	/**
	 * @param forwardUrl the forwardUrl to set
	 */
	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}

	/**
	 * @param code
	 * @param message
	 * @return
	 */
	public String ajaxDoneSuccess(){
		this.statusCode = 200;
		return SUCCESS;
	}	
	
	public String ajaxDoneError(){
		this.statusCode = 300;
		return "error";
	}
}
