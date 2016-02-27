package com.qawaa.controller;

import java.util.HashMap;
import java.util.Map;

import com.qawaa.common.CustomerHttpClient;
import com.qawaa.model.Hour_timelineModel;
import com.qawaa.model.Hour_timeline_pointsModel;



import net.sf.json.JSONObject;

public class Hour_timeline {
	public static Hour_timeline_pointsModel JsonToJavaBean(int event_id,int min_point){
		String url="http://220.113.8.252:8300/point/hour_timeline.json?";
		if(event_id!=0){
			url+="event_id="+event_id;
		}
		if(min_point!=0){
			url+="&min_point="+min_point;
		}
		String response=CustomerHttpClient.get(url);
		JSONObject object = JSONObject.fromObject(response);
		Map<String, Class<?>> cmap = new HashMap<String, Class<?>>();
		cmap.put("p", Hour_timeline_pointsModel.class);
		Hour_timelineModel points = (Hour_timelineModel) JSONObject.toBean(object, Hour_timelineModel.class,cmap);
		Hour_timeline_pointsModel point=points.getP();
		return point;
		}
}
