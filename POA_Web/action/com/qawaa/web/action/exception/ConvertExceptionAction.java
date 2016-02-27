/**
 *
 */
package com.qawaa.web.action.exception;

import com.qawaa.web.action.BaseAction;

/**
 * @author Ryan  2013-10-5  下午11:01:40
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class ConvertExceptionAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8928290977788719421L;
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		request.setAttribute("error_code", 20002);
		return "error";
	}

}
