package com.qawaa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qawaa.common.CustomerHttpClient;
import com.qawaa.model.Batch_timelineModel;
import com.qawaa.model.Batch_timeline_pointsModel;



import net.sf.json.JSONObject;

public class Batch_timeline {
	public static List<Batch_timeline_pointsModel> JsonToJavaBean(String event_ids){
		String url="http://220.113.8.252:8300/point/batch_timeline.json?";
			if(event_ids!=null){
				url+="event_ids="+event_ids;
			}
		String response=CustomerHttpClient.get(url);
		JSONObject object = JSONObject.fromObject(response);
		Map<String, Class<?>> cmap = new HashMap<String, Class<?>>();
		cmap.put("points", Batch_timeline_pointsModel.class);
		Batch_timelineModel points = (Batch_timelineModel) JSONObject.toBean(object, Batch_timelineModel.class,cmap);
		List<Batch_timeline_pointsModel> point=points.getPoints();
		return point;
		}
}
