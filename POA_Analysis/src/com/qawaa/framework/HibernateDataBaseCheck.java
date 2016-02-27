/**
 * 
 */
package com.qawaa.framework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Ran Xu
 * @data 2014-2-19 下午4:52:11 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment hibernate 与数据库连接测试类
 *
 */
public class HibernateDataBaseCheck extends HibernateDaoSupport {
	/**
	 * 连接成功返回true
	 * @return
	 */
	public static boolean check(){
		ApplicationContext context = ApplicationContextFactory.getInstance();
		try {
			SessionFactory sf = (SessionFactory) context.getBean("sessionFactory");
			Session session = sf.openSession();
			if (session == null)
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
