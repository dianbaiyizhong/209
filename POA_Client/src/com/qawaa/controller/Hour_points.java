package com.qawaa.controller;

import java.util.HashMap;
import java.util.Map;

import com.qawaa.common.CustomerHttpClient;
import com.qawaa.model.Hour_pointsModel;
import com.qawaa.model.Hour_points_pointModel;



import net.sf.json.JSONObject;


public class Hour_points {
	public static Hour_pointsModel JsonToJavaBean(int event_id,int max_point,int count){
		String url="http://220.113.8.252:8300/point/hour_points.json?";
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
		cmap.put("points", Hour_points_pointModel.class);
		Hour_pointsModel points = (Hour_pointsModel) JSONObject.toBean(object, Hour_pointsModel.class,cmap);
		//List<Hour_points_pointModel> point=points.getPoints();
		return points;
		}
}
