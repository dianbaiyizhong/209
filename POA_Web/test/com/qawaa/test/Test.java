/**
 *
 */
package com.qawaa.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Random;

import com.qawaa.data.entity.EventList;
import com.qawaa.util.DateUtil;

/**
 * @author Ryan 2013-10-3 下午8:46:37
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com www.qawaa.com
 * @comment
 */
public class Test {
	public static void main(String[] args) throws SecurityException, NoSuchFieldException, UnsupportedEncodingException {
		Random r = new Random(System.currentTimeMillis());
		int id = 5001;
		for (; id <= 5013; id++) {
			int p = 1533 + r.nextInt(2300);
			long start = DateUtil.getBeginTimeOfDay(new Date(System.currentTimeMillis() - (45L * 24L * 60L * 60L * 1000L))).getTime();
			while(start < System.currentTimeMillis()){
				int k = r.nextInt(10);
				if(k < 2)
					k = 10-k;
				boolean bl = true;
				if(k%2 == 0)
					bl = false;
				int v = r.nextInt(270);
				if(bl){
					p+=v;
				}else{
					p-=v;
				}
				if(p<0){
					p+=(2*v);
				}
				if(p > 9900){
					p = p-(2*v);
				}
				start =DateUtil.getBeginTimeOfDay(new Date(start+(24L * 60L * 60L * 1000L))).getTime();
				String d = DateUtil.formatDate("yyyy-MM-dd HH:mm:ss.SSS", new Date(start));
			}
			
		}
	}
}
