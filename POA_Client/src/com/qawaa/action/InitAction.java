package com.qawaa.action;

import java.util.List;
import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;
import com.qawaa.common.CustomerHttpClient;
import com.qawaa.common.InitMethod;

import com.qawaa.controller.Recommend_timeline;

import com.qawaa.model.Recommend_timeline_eventsModel;


public class InitAction extends ActionSupport{
    /**
	 * 
	 */
	private static final long serialVersionUID = 556615574265816967L;
	public String result;
	public String execute()throws Exception{
		authorize();
		List<Recommend_timeline_eventsModel> recommend_events = Recommend_timeline.JsonToJavaBean();
		JSONArray d_json=InitMethod.recommendDailyInit(recommend_events);
		JSONArray r_json=InitMethod.recommendRealtimeInit(recommend_events);
		JSONArray h_json=InitMethod.recommendHourInit(recommend_events);
//			List<Public_timeline_eventsModel> eventsIds=Public_timeline.JsonToJavaBean(0,0,0);
//			JSONArray r_json=InitMethod.realtimeInit(eventsIds);
//			JSONArray h_json=InitMethod.hourInit(eventsIds);
//			JSONArray d_json=InitMethod.dailyInit(eventsIds);
			/*InitMethod.realtimeAdd(eventsIds);
			InitMethod.DailyAndHourAdd(eventsIds);*/
			this.result="{jsond:"+d_json.toString()+",jsonh:"+h_json.toString()+",jsonr:"+r_json.toString()+"}";
		return SUCCESS;
	}
	//授权
	public void authorize()throws Exception{
		String url="http://220.113.8.252:8300/authorize/pass.json?token=chinalab";
		String response=CustomerHttpClient.get(url);
	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	}
