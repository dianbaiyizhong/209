package com.qawaa.controller;

import java.util.HashMap;
import java.util.Map;

import com.qawaa.common.CustomerHttpClient;
import com.qawaa.model.Event_pointsModel;
import com.qawaa.model.Event_points_pointModel;


import net.sf.json.JSONObject;

public class Event_points{
	public static Event_pointsModel JsonToJavaBean(int event_id,int max_id,int count){
		String url="http://220.113.8.252:8300/point/event_points.json?";
		if(event_id!=0){
			url+="event_id="+event_id;
		}
		if(max_id!=0){
			url+="&max_id="+max_id;
		}
		if(count!=0){
			url+="&count="+count;
		}
	String response=CustomerHttpClient.get(url);
	JSONObject object = JSONObject.fromObject(response);
	Map<String, Class<?>> cmap = new HashMap<String, Class<?>>();
	cmap.put("points", Event_points_pointModel.class);
	Event_pointsModel points = (Event_pointsModel) JSONObject.toBean(object, Event_pointsModel.class,cmap);
	//List<Event_points_pointModel> point=points.getPoints();	
	return points;
	}
}
