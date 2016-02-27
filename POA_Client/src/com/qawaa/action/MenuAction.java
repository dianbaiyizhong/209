package com.qawaa.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qawaa.common.CustomerHttpClient;
import com.qawaa.controller.Class2;
import com.qawaa.controller.Event;
import com.qawaa.model.Class2esModel;
import com.qawaa.model.Event_categoriesModel;

public class MenuAction extends ActionSupport{
	public String execute()throws Exception{
		Map session=ActionContext.getContext().getSession();
		session.clear();
		authorize();
		web10();
		web20();
		web30();
		type();		
		return SUCCESS;
	}
	//授权
	public void authorize()throws Exception{
		String url="http://220.113.8.252:8300/authorize/pass.json?token=chinalab";
		String response=CustomerHttpClient.get(url);
	}
	//web1.0
	public void web10()throws Exception{
		List<Class2esModel> web10=Class2.JsonToJavaBean(10,0,null);
		Map session=ActionContext.getContext().getSession();
		session.put("web10", web10);
	}
	//web2.0
    public void web20()throws Exception{
		List<Class2esModel> web20=Class2.JsonToJavaBean(20,0,null);
		Map session=ActionContext.getContext().getSession();
		session.put("web20", web20);
	}
    //web3.0
    public void web30()throws Exception{
    	List<Class2esModel> web30=Class2.JsonToJavaBean(30,0,null);
		Map session=ActionContext.getContext().getSession();
		session.put("web30", web30);
    }
    //事件类型
    public void type()throws Exception{
    	List<Event_categoriesModel> type=Event.JsonToJavaBean();
    	Map session=ActionContext.getContext().getSession();
    	session.put("type", type);
    }
	}
