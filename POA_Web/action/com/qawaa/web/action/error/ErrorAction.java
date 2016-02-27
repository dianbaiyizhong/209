/**
 *
 */
package com.qawaa.web.action.error;

import com.qawaa.data.bean.ErrorBean;
import com.qawaa.web.action.BaseAction;

/**
 * @author Ryan  2013-10-2  下午8:11:35
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class ErrorAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -180102114871029517L;
	private ErrorBean error;
	
	/**
	 * @return the error
	 */
	public ErrorBean getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(ErrorBean error) {
		this.error = error;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		this.error = new ErrorBean();
		if(request.getMethod().equalsIgnoreCase("post") || request.getAttribute("error_code") == null){
			error.setError_code(20000);
			error.setError_msg(this.getText("error."+error.getError_code().toString()));
			error.setRequest_uri(request.getRequestURI());
		}else{
			error.setError_code((Integer) request.getAttribute("error_code"));
			error.setError_msg(this.getText("error."+error.getError_code().toString()));
			error.setRequest_uri(request.getRequestURI());
		}
		return SUCCESS;
	}
	

}
