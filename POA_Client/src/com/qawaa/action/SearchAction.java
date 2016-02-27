package com.qawaa.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qawaa.common.CustomerHttpClient;
import com.qawaa.common.SearchMethod;
import com.qawaa.controller.Batch_timeline;
import com.qawaa.controller.Daily_points;
import com.qawaa.controller.Daily_timeline;
import com.qawaa.controller.Event_points;
import com.qawaa.controller.Hour_points;
import com.qawaa.controller.Hour_timeline;
import com.qawaa.controller.SearchEvent;
import com.qawaa.model.Batch_timeline_pointsModel;
import com.qawaa.model.Daily_pointsModel;
import com.qawaa.model.Daily_points_pointModel;
import com.qawaa.model.Daily_timeline_pointModel;
import com.qawaa.model.Event_pointsModel;
import com.qawaa.model.Event_points_pointModel;
import com.qawaa.model.Hour_pointsModel;
import com.qawaa.model.Hour_points_pointModel;
import com.qawaa.model.Hour_timeline_pointsModel;


public class SearchAction extends ActionSupport{
	public String result;
	public String keyword;
	public String searchEventIds;
    public String searchEventTitle;
	//根据关键字搜索事件
	public String execute()throws Exception{
		authorize();
		List ids=SearchEvent.JsonToJavaBean(keyword, 0, 0, 0);
		JSONArray jsonArray = JSONArray.fromObject(ids);
        String json=jsonArray.toString();
		this.result=json.toString();
		return SUCCESS;
	}

	//返回搜索事件的point值
	public String searchPoint()throws Exception{
		authorize();
		String eventsIds[]=searchEventIds.split(",");
		String eventTitle[]=searchEventTitle.split(",");
		//实时批量获取
		List<Batch_timeline_pointsModel> r_Ap=Batch_timeline.JsonToJavaBean(searchEventIds);
		Collections.sort(r_Ap, new Comparator<Batch_timeline_pointsModel>() {
            public int compare(Batch_timeline_pointsModel p0,Batch_timeline_pointsModel p1) {
                try {
                    int temp1= p0.getEvent_id();
                    int temp2=p1.getEvent_id(); 
                    return temp2-temp1;
                } catch (Exception ex) {
                }
                return 0;
            }
        });
	   JSONArray r_json=SearchMethod.realtimeInit(eventsIds, eventTitle);
	   JSONArray h_json=SearchMethod.hourInit(eventsIds, eventTitle);
	   JSONArray d_json=SearchMethod.dailyInit(eventsIds, eventTitle);
	   /*SearchMethod.DailyAndHourAdd(eventsIds);
	   Map session=ActionContext.getContext().getSession();
	   session.put("realtimeAp", r_Ap);*/
	   this.result="{jsond:"+d_json.toString()+",jsonh:"+h_json.toString()+",jsonr:"+r_json.toString()+"}";
	   return SUCCESS;
	}
	public void authorize()throws Exception{
		String url="http://220.113.8.252:8300/authorize/pass.json?token=chinalab";
		String response=CustomerHttpClient.get(url);
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getSearchEventIds(){
		return searchEventIds;
	}
	public void setSearchEventIds(String searchEventIds){
		this.searchEventIds=searchEventIds;
	}
	public String getSearchEventTitle(){
		return searchEventTitle;
	}
	public void setSearchEventTitle(String searchEventTitle){
		this.searchEventTitle=searchEventTitle;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

}
