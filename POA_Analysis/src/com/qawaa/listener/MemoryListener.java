/**
 *
 */
package com.qawaa.listener;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.text.DecimalFormat;

import javax.swing.text.JTextComponent;

/**
 * @author Ryan  2013-10-17  下午4:07:01
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 监听组件内存的使用量
 */
public class MemoryListener extends Thread {
	private static final long TIME = 5000L;
	private JTextComponent component;

	/**
	 * @param component
	 */
	public MemoryListener(JTextComponent component) {
		super();
		this.component = component;
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		do{
			MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
			long used = mbean.getHeapMemoryUsage().getUsed();
			long used_kb = used / 1000L;
			String s = new DecimalFormat(",###").format(used_kb) + " KB";
			component.setText(s);
			try {
				sleep(TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(true);
	}
	
}
