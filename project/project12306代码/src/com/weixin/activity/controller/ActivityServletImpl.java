package com.weixin.activity.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weixin.activity.service.ActivityServiceImpl;
import com.weixin.entity.Activity;
import com.weixin.entity.Classes;

import net.sf.json.JSONArray;


@Controller
@Transactional(readOnly=false)
public class ActivityServletImpl {
	
    @Resource
    private ActivityServiceImpl activityServiceImpl;
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
    @RequestMapping("/activity")
    public String find(HttpServletRequest request,HttpServletResponse response,String a,int classId){
    	response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
          
    	
        List<Activity> list=this.activityServiceImpl.list(classId); 
    	
        JSONArray j1=JSONArray.fromObject(list);
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
    
    
    @RequestMapping("/addactivity")
    public void addactivity(HttpServletRequest request,HttpServletResponse response,String title,String text,int classId) {
    	response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        Activity et=new Activity();
        Classes a=new Classes();
        System.out.println(text);
        try {            
//        	et.setTitle();
        	et.setaBody(text);
        	et.setClasss(a);
        	et.getClasss().setClassId(classId);
			this.activityServiceImpl.addactivity(et);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
