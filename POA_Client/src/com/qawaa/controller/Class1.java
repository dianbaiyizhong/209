package com.qawaa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qawaa.common.CustomerHttpClient;
import com.qawaa.model.Class1Model;
import com.qawaa.model.Class1esModel;



import net.sf.json.JSONObject;

public class Class1 {
	public static List<Class1esModel> JsonToJavaBean(){
		String url="http://220.113.8.252:8300/category/site.class1.json";
		String response=CustomerHttpClient.get(url);
		JSONObject object = JSONObject.fromObject(response);
		Map<String, Class<?>> cmap = new HashMap<String, Class<?>>();
		cmap.put("class1es", Class1esModel.class);
		Class1Model class1es = (Class1Model) JSONObject.toBean(object, Class1Model.class,cmap);
		List<Class1esModel> class1=class1es.getClass1es();
		return class1;
		}
}
