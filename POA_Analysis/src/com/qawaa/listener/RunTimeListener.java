/**
 *
 */
package com.qawaa.listener;

import javax.swing.text.JTextComponent;

/**
 * @author Ryan  2013-10-27  下午11:27:04
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class RunTimeListener extends Thread {
	private static final long TIME = 28L * 1240L;
	private JTextComponent component;
	private long start;
	/**
	 * @param component
	 * @param start
	 */
	public RunTimeListener(JTextComponent component) {
		super();
		this.component = component;
		this.start = System.currentTimeMillis();
	}
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while(true){
			long now = System.currentTimeMillis();
			long t = now - start;
			component.setText(this.getRunTime(t));
			try {
				Thread.sleep(TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private String getRunTime(long time){
		StringBuffer buffer = new StringBuffer();
		long day = time/(24L*60L*60L*1000L);
		buffer.append(day);
		buffer.append(" 天 ");
		long last = time%(24L*60L*60L*1000L);
		long hour = last/(60L*60L*1000L);
		buffer.append(hour);
		buffer.append(" 小时 ");
		last = last % (60L*60L*1000L);
		long minute = last/(60L*1000L);
		buffer.append(minute);
		buffer.append(" 分钟");
		return buffer.toString();
	}
	
}
