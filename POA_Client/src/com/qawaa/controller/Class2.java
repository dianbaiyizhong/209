package com.qawaa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qawaa.common.CustomerHttpClient;
import com.qawaa.model.Class2Model;
import com.qawaa.model.Class2esModel;

  

import net.sf.json.JSONObject;

public class Class2{
	public static List<Class2esModel> JsonToJavaBean(int class1_id,int id,String ids){
		String url="http://220.113.8.252:8300/category/site/class2.json?";
		if(class1_id!=0){
			url+="class1_id="+class1_id;
		}
		if(id!=0){
			url+="&id="+id;
		}
		if(ids!=null){
			url+="&ids="+ids;
		}
		String response=CustomerHttpClient.get(url);
		JSONObject object = JSONObject.fromObject(response);
		Map<String, Class<?>> cmap = new HashMap<String, Class<?>>();
		cmap.put("class2es", Class2esModel.class);
		Class2Model class2 = (Class2Model) JSONObject.toBean(object, Class2Model.class,cmap);
		List<Class2esModel> class2es=(List<Class2esModel>)class2.getClass2es();
		return class2es;
		}
	
}
