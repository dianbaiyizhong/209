package com.qawaa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qawaa.common.CustomerHttpClient;
import com.qawaa.model.EventModel;
import com.qawaa.model.Event_categoriesModel;



import net.sf.json.JSONObject;

public class Event {
	public static List<Event_categoriesModel> JsonToJavaBean(){
		String url="http://220.113.8.252:8300/category/event.json";
		String response=CustomerHttpClient.get(url);
		JSONObject object = JSONObject.fromObject(response);
		Map<String, Class<?>> cmap = new HashMap<String, Class<?>>();
		cmap.put("categories", Event_categoriesModel.class);
		EventModel categories = (EventModel) JSONObject.toBean(object, EventModel.class,cmap);
		List<Event_categoriesModel> category=categories.getCategories();
		return category;
		}
}
