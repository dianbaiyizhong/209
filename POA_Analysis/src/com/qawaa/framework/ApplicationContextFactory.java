/**
 *
 */
package com.qawaa.framework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author Ryan  2013-10-19  下午10:51:46
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 加载spring Application Context,单例模式
 */
public class ApplicationContextFactory {
	private volatile static ApplicationContextFactory factory;
	private ApplicationContext context;
	
	private ApplicationContextFactory(){
		super();
		context = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
	}
	
	/**
	 * 实例化
	 * @return
	 */
	public static ApplicationContext getInstance(){
		if(factory == null){
			synchronized(ApplicationContextFactory.class){
				if(factory == null){
					factory = new ApplicationContextFactory();
				}
			}
		}
		return factory.context;
	}
}
