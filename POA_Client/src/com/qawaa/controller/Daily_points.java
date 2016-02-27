package com.qawaa.controller;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.qawaa.common.CustomerHttpClient;
import com.qawaa.model.Daily_pointsModel;
import com.qawaa.model.Daily_points_pointModel;

public class Daily_points {
	public static Daily_pointsModel JsonToJavaBean(int event_id,int max_point,int count){
		String url="http://220.113.8.252:8300/point/daily_points.json?";
		if(event_id!=0){
			url+="event_id="+event_id;
		}
		if(max_point!=0){
			url+="&max_point="+max_point;
		}
		if(count!=0){
			url+="&count="+count;
		}
		String response=CustomerHttpClient.get(url);
		JSONObject object = JSONObject.fromObject(response);
		Map<String, Class<?>> cmap = new HashMap<String, Class<?>>();
		cmap.put("points", Daily_points_pointModel.class);
		Daily_pointsModel points = (Daily_pointsModel) JSONObject.toBean(object, Daily_pointsModel.class,cmap);
		//List<Daily_points_pointModel> point=points.getPoints();
		return points;
		}
}
