/**
 * 
 */
package com.qawaa.data.bean;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

/**
 * @author Ran Xu
 * @data 2014-6-4 下午6:02:02 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 * 热门事件bean
 */
public class HotEventBean {
	private String title;
	private Integer point;
	private Date datetime;
	/**
	 * @return the title
	 */
	@JSON(name="title")
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the point
	 */
	@JSON(name="point")
	public Integer getPoint() {
		return point;
	}
	/**
	 * @param point the point to set
	 */
	public void setPoint(Integer point) {
		this.point = point;
	}
	/**
	 * @return the datetime
	 */
	@JSON(name="datetime")
	public Date getDatetime() {
		return datetime;
	}
	/**
	 * @param datetime the datetime to set
	 */
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	/**
	 * @param title
	 * @param point
	 * @param datetime
	 */
	public HotEventBean(String title, Integer point, Date datetime) {
		super();
		this.title = title;
		this.point = point;
		this.datetime = datetime;
	}
	
}
