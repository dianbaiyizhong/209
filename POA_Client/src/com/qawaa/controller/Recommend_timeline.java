package com.qawaa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qawaa.common.CustomerHttpClient;
import com.qawaa.model.Recommend_timelineModel;
import com.qawaa.model.Recommend_timeline_eventsModel;


import net.sf.json.JSONObject;

public class Recommend_timeline {
	public static List<Recommend_timeline_eventsModel> JsonToJavaBean(){
		String url="http://220.113.8.252:8300/events/recommend_timeline.json";
		String response=CustomerHttpClient.get(url);
		JSONObject object = JSONObject.fromObject(response);
		Map<String, Class<?>> cmap = new HashMap<String, Class<?>>();
		cmap.put("events", Recommend_timeline_eventsModel.class);
		Recommend_timelineModel events = (Recommend_timelineModel) JSONObject.toBean(object, Recommend_timelineModel.class,cmap);
		List<Recommend_timeline_eventsModel> event=events.getEvents();
		return event;
		}
}
