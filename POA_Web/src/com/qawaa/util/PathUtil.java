/**
 * 
 */
package com.qawaa.util;

import java.io.File;

/**
 * @author Ryan  2011-4-24  下午02:09:47
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * File路径扩展类
 */
public class PathUtil {
	/**
	 * 返回抽象目录名的绝对路径名字符串，如果该路径不存在则创建该目录
	 * @param path
	 * @return
	 */
	public static String getAbsolutePath(String path){
		File file = new File(path);
		if(!file.exists()){
			file.mkdir();
		}
		return file.getAbsolutePath();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getAbsolutePath("bin"));
	}
}
