package com.qawaa.controller;

import com.qawaa.common.CustomerHttpClient;
import com.qawaa.model.VersionModel;



import net.sf.json.JSONObject;

public class Version {
	public static String JsonToJavaBean(){
		String url="http://220.113.8.252:8300/version.json";
		String response=CustomerHttpClient.get(url);
		JSONObject object = JSONObject.fromObject(response);
		VersionModel versionM = (VersionModel) JSONObject.toBean(object, VersionModel.class);
		String version=versionM.getVersion();
		return version;
		}
}
