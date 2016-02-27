/**
 * 
 */
package com.qawaa.util;

/**
 * ip地址扩展类
 * @author Ryan  2010-9-22  下午10:40:47
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 *
 */
public class IPUtil {
	/**
	 * 获取IP的数字码表示形式
	 * 
	 * @param ip
	 * @return
	 */
	public static long getIPNum(String ip){
		try{
		long part1=1;
		long part2=1;
		long part3=1;
		long part4=1;
		int i = ip.indexOf(",");
		if(i != -1){
			ip = ip.substring(i+1).trim();
		}
		part1=Long.parseLong(ip.substring(0,ip.indexOf('.')))*256*256*256;
		ip=ip.substring(ip.indexOf('.')+1);
		part2=Long.parseLong(ip.substring(0,ip.indexOf('.')))*256*256;
		ip=ip.substring(ip.indexOf('.')+1);
		part3=Long.parseLong(ip.substring(0,ip.indexOf('.')))*256;
		ip=ip.substring(ip.indexOf('.')+1);
		part4=Long.parseLong(ip.substring(0,ip.length()));
		return part1+part2+part3+part4-1;
		}
		catch(Exception e){
			return 0L;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getIPNum("133, 211.140.5.111"));
	}
}
