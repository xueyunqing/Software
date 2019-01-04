package com.weixin.comments.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weixin.comments.service.CommentsServiceImpl;
import com.weixin.entity.Comments;

import net.sf.json.JSONArray;


@Controller
public class CommentsServletImpl {
	
    @Resource
    private CommentsServiceImpl commentsServiceImpl;
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
    @RequestMapping("/comments")
    public String find(HttpServletRequest request,HttpServletResponse response,String a){
    	response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
          
    	List<Comments> list=this.commentsServiceImpl.list();  
    	List<Comments> list2=new ArrayList<>();
    	for(Comments a1:list) {
    		Comments w=new Comments();
    		w.setId(a1.getId());
    		w.setComments(a1.getComments());
    		w.setcBody(a1.getcBody());
    		w.setThumbs(a1.getThumbs());
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


