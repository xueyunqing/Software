package com.weixin.news.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weixin.activity.service.ActivityServiceImpl;
import com.weixin.entity.Activity;
import com.weixin.entity.News;
import com.weixin.news.service.NewsServiceImpl;
import com.weixin.util.Crawler;

import net.sf.json.JSONArray;

@Controller
public class NewsServletImpl {
	
		
	    @Resource
	    private NewsServiceImpl newsServiceImpl;
	    
	    Crawler crawler=new Crawler();
	    
	    /**
	     * 
	        * @Title: find  
	        * @Description:将后台从数据库得到的数据传到微信前台  
	        * @Param@param request
	        * @Param@param response
	        * @Param@param a
	        * @Param@return
	        * @Return String
	        * @throws
	     */
	    @RequestMapping("/news")
	    public String find(HttpServletRequest request,HttpServletResponse response,String a){
	    	response.setCharacterEncoding("utf-8");
	        response.setContentType("application/json");
	          
	    	List<News> list=this.newsServiceImpl.list();  
	    	List<News> list2=new ArrayList<>();
	    	for(News a1:list) {
	    		News w=new News();
	    		w.setId(a1.getId());
	    		w.setnTitle(a1.getnTitle());
	    		w.setnBody(a1.getnBody());
	    		w.setnTime(a1.getnTime());
	    		list2.add(w);
	    	}
	    	
	       JSONArray j1=JSONArray.fromObject(list2);
	       String j12String = j1.toString();
	       System.out.println(j12String);
	        
			try {
				PrintWriter writer = response.getWriter();
				writer.write(j12String);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return null;
	    }
}
