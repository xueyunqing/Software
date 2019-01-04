package com.weixin.myclass.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weixin.entity.Classes;
import com.weixin.myclass.service.MyClassServiceImpl;
import com.weixin.myclass.service.TotalServices;

@Controller
public class MyClassServletImpl {
	@Resource
	private TotalServices totalSevices;
	/**
	 * 
	    * @Title: save  
	    * @Description: 创建班级并存在数据库中 
	    * @Param@param response
	    * @Param@param entity
	    * @Param@param grade
	    * @Param@param classint
	    * @Return void
	    * @throws 
	 */
	@RequestMapping("/creatClass")
	public void save(HttpServletResponse response, String wxName, int grade, int classint, String province, String city,
			String county, String name1) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(this.totalSevices.total(wxName, grade, classint, province, city, county, name1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
