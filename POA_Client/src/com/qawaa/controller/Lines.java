package com.qawaa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qawaa.common.CustomerHttpClient;
import com.qawaa.model.LinesModel;
import com.qawaa.model.Lines_lineModel;



import net.sf.json.JSONObject;

public class Lines {
	public static List<Lines_lineModel> JsonToJavaBean(){
		String url="http://220.113.8.252:8300/category/warning/line.json";
		String response=CustomerHttpClient.get(url);
		JSONObject object = JSONObject.fromObject(response);
		Map<String, Class<?>> cmap = new HashMap<String, Class<?>>();
		cmap.put("lines", Lines_lineModel.class);
		LinesModel lines = (LinesModel) JSONObject.toBean(object, LinesModel.class,cmap);
		List<Lines_lineModel> line=lines.getLines();
		return line;
		}
}
