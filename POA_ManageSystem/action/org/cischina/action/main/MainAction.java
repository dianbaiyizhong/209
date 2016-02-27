/**
 *
 */
package org.cischina.action.main;

import org.cischina.action.BaseAction;
import org.cischina.data.bean.OnlineUserBean;
import org.cischina.web.security.SessionCookieKey;

/**
 * @author Ryan  2012-10-25  下午05:14:09
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 首页
 */
public class MainAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1196521124785489186L;
	private OnlineUserBean self;
	private int unReadMessage;
	/**
	 * @return the self
	 */
	public OnlineUserBean getSelf() {
		return self;
	}

	/**
	 * @param self the self to set
	 */
	public void setSelf(OnlineUserBean self) {
		this.self = self;
	}



	/**
	 * @return the unReadMessage
	 */
	public int getUnReadMessage() {
		return unReadMessage;
	}



	/**
	 * @param unReadMessage the unReadMessage to set
	 */
	public void setUnReadMessage(int unReadMessage) {
		this.unReadMessage = unReadMessage;
	}

	/**
	 * @return
	 */
	public String index(){
		this.self = (OnlineUserBean) session.get(SessionCookieKey.USER_INFO_KEY);
		this.unReadMessage = 0;
		return SUCCESS;
	}

}
