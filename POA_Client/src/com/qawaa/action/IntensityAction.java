/**
 * 
 */
package com.qawaa.action;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;
import com.qawaa.controller.Event_intensity;
import com.qawaa.model.Event_intensity_intensityModel;

/**
 * @author Liu Te
 * @data 2014-3-10 上午11:34:17 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public class IntensityAction extends ActionSupport{
	
	private int event_id;
	private String result;
	
	/***
	 * 获取Event_intensity_intensityModel并转化为json
	 * @param event_id 事件编号
	 */
	public String execute() throws Exception{
		Event_intensity_intensityModel intensity = Event_intensity.JsonToBean(event_id);
		JSONArray i = JSONArray.fromObject(intensity);
		this.result = i.toString();
		return SUCCESS;
	}
	
	public int getEvent_id() {
		return event_id;
	}
	
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}

}
