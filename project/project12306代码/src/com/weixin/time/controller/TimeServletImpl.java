package com.weixin.time.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weixin.entity.Classes;
import com.weixin.entity.Schooltime;
import com.weixin.entity.Time;
import com.weixin.schooltime.service.SchoolTimeServiceImpl;
import com.weixin.time.service.TimeServiceImpl;

import net.sf.json.JSONArray;

@Controller
public class TimeServletImpl {
	@Resource
    private TimeServiceImpl timeServiceImpl;
    /**
     * 
        * @Title: save  
        * @Description: 向上下学时间表中添加前台获得的时间  
        * @Param@param request
        * @Param@param response
        * @Param@param st
        * @Param@param st2
        * @Param@param st3
        * @Param@param upschool1
        * @Param@param upschool2
        * @Param@param upschool3
        * @Param@param downschool1
        * @Param@param downschool2
        * @Param@param downschool3
        * @Return void
        * @throws
     */
    @RequestMapping("/time")
    public void save(HttpServletRequest request,HttpServletResponse response,String upschool1,String upschool2,String upschool3,String downschool1,String downschool2,String downschool3,int classId) {
   	 response.setCharacterEncoding("utf-8");
     response.setContentType("application/json");
       
     Time st=new Time();        
   	 st.setGo(upschool1);
   	 st.setBack(downschool1);
   	 Classes a=new Classes();
   	 st.setClasss(a);
   	 st.getClasss().setClassId(classId);
   	 timeServiceImpl.save(st);
   	 
     Time st2=new Time();    	 
   	 st2.setGo(upschool2);
   	 st2.setBack(downschool2);
   	 Classes a1=new Classes();
  	 st.setClasss(a1);
  	 st.getClasss().setClassId(classId);
   	 timeServiceImpl.save(st2);
   	 
   	 Time st3=new Time();
   	 st3.setGo(upschool3);
   	 st3.setBack(downschool3);
   	 Classes a2=new Classes();
  	 st.setClasss(a2);
  	 st.getClasss().setClassId(classId);
   	 timeServiceImpl.save(st3);
    }
    
    /**
     * 
        * @Title: find  
        * @Description: 查询上下学时间表中的数据 
        * @Param@param request
        * @Param@param response
        * @Param@param a
        * @Param@return
        * @Return String
        * @throws
     */
    @RequestMapping("/timecheck")
    public String find(HttpServletRequest request,HttpServletResponse response,String a,int classId){
    	response.setCharacterEncoding("utf-8");
       response.setContentType("application/json");
          
    	List<Time> list=this.timeServiceImpl.list(classId);  
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
}
