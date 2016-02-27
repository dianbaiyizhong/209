package com.qawaa.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qawaa.common.CustomerHttpClient;
import com.qawaa.common.RankMethod;
import com.qawaa.controller.Class2;
import com.qawaa.controller.Event;
import com.qawaa.controller.Recommend_timeline;
import com.qawaa.model.Class2esModel;
import com.qawaa.model.Event_categoriesModel;
import com.qawaa.model.Recommend_timeline_eventsModel;

public class SynthesisAction extends ActionSupport{
	public String result;
	public String execute()throws Exception{
	
		authorize();
		
		List<Recommend_timeline_eventsModel> Ids=Recommend_timeline.JsonToJavaBean();
		JSONArray r_json=RankMethod.realtimeInit(Ids);
		/*JSONArray h_json=RankMethod.hourInit(Ids);
		JSONArray d_json=RankMethod.dailyInit(Ids);
		RankMethod.realtimeAdd(Ids);
		RankMethod.DailyAndHourAdd(Ids);*/
		this.result=r_json.toString();
		//this.result=r_json.toString()+h_json.toString()+d_json.toString();
		return SUCCESS;
	}
	//授权
	public void authorize()throws Exception{
		String url="http://220.113.8.252:8300/authorize/pass.json?token=chinalab";
		String response=CustomerHttpClient.get(url);
	}
	
}
