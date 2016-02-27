package org.cischina.web.interceptor;

import java.util.Map;

import org.cischina.web.security.SessionCookieKey;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


/**
 * @author Ryan  2012-11-20  下午02:55:32
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 身份拦截器
 */
public class IdentityInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4918955296271244256L;

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		ActionContext actionContext = invocation.getInvocationContext();
		Map<String, Object> session = actionContext.getSession();
		if (session != null && session.get(SessionCookieKey.USER_VALIDATION_KEY) != null && session.get(SessionCookieKey.USER_INFO_KEY) != null) {
			return invocation.invoke();
		}
		return "identityFail";
		
	}
}