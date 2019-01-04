package com.weixin.schooltime.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weixin.entity.Activity;
import com.weixin.entity.Classes;
import com.weixin.entity.Schooltime;
import com.weixin.schooltime.service.SchoolTimeServiceImpl;

import net.sf.json.JSONArray;

@Controller
public class SchoolTimeServletImpl {
     @Resource
     private SchoolTimeServiceImpl schoolTimeServiceImpl;
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
     @RequestMapping("/schooltime")
     public void save(HttpServletRequest request,HttpServletResponse response,String upschool,String downschool,int classId) {
    	 response.setCharacterEncoding("utf-8");
         response.setContentType("application/json");
         Schooltime st=new Schooltime();
         System.out.println(classId);
//         int s=Integer.parseInt(classId);
         Classes a=new Classes();
         st.setClasss(a);
         st.getClasss().setClassId(classId);
    	 st.setGo(upschool);
    	 st.setBack(downschool);
    	 
    	 schoolTimeServiceImpl.save(st);
    	 System.out.println("1");
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
     @RequestMapping("/schooltimecheck")
     public String find(HttpServletRequest request,HttpServletResponse response,String a,int classId){
     	response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
           
     	List<Schooltime> list=this.schoolTimeServiceImpl.list(classId);  
     	
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
