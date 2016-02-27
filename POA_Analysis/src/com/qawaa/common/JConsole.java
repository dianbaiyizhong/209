/**
 *
 */
package com.qawaa.common;

import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

/**
 * @author Ryan  2013-10-17  上午12:33:26
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 重定向java控制台输出 到swing组件中
 */
public class JConsole extends PrintStream {
	private JTextComponent text;
	private StringBuffer buffer = new StringBuffer();
	private Integer maxMsg = 2000;
	private Integer point = 0;

	/**
	 * @return the maxMsg
	 */
	public Integer getMaxMsg() {
		return maxMsg;
	}

	/**
	 * @param maxMsg the maxMsg to set
	 */
	public void setMaxMsg(Integer maxMsg) {
		this.maxMsg = maxMsg;
	}

	public JConsole(OutputStream out, JTextComponent text) {
		super(out);
		this.text = text;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.PrintStream#write(byte[], int, int)
	 */
	public void write(byte[] buf, int off, int len) {
		final String message = new String(buf, off, len);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				buffer.append(message);
				text.setText(buffer.toString());
				if(point > maxMsg){
					buffer = new StringBuffer();
					text.setText("");
					point = 0;
				}else{
					point++;
				}
			}
		});
	}
	/**
	 * 清理console信息
	 */
	public void clear(){
		if(buffer.length() > 0)
			buffer.delete(0, buffer.length());
	}

}
