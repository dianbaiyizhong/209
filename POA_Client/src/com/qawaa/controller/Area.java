package com.qawaa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qawaa.common.CustomerHttpClient;
import com.qawaa.model.AreaModel;
import com.qawaa.model.Area_areasModel;


import net.sf.json.JSONObject;
public class Area {
	public static List<Area_areasModel> JsonToJavaBean(){
		String url="http://220.113.8.252:8300/category/area.json";
		String response=CustomerHttpClient.get(url);
		JSONObject object = JSONObject.fromObject(response);
		Map<String, Class<?>> cmap = new HashMap<String, Class<?>>();
		cmap.put("areas", Area_areasModel.class);
		AreaModel areas = (AreaModel) JSONObject.toBean(object, AreaModel.class,cmap);
		List<Area_areasModel> areas_area=areas.getAreas();
		return areas_area;
		}
}
