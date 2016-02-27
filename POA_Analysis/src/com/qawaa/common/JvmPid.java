/**
 *
 */
package com.qawaa.common;

import java.lang.management.ManagementFactory;

/**
 * @author Ryan  2013-10-23  上午10:21:34
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 返回此虚拟机的系统PID
 */
public class JvmPid {
	/**
	 * 返回此虚拟机的系统PID
	 * @return
	 */
	public static String getPID(){
		try{
			return ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
		}catch(Exception e){
			return "UNKNOW";
		}
	}
	
}
