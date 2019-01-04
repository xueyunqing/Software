package com.weixin.course.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weixin.check.service.CheckServiceImpl;
import com.weixin.course.service.CourseServiceImpl;

import net.sf.json.JSONArray;

/**
 * 
    * @ClassName: CourseController  
    * @Description: 课程表的建立和查询 
    * @author xueyunqing  
    * @date 2018年12月19日  
    *
 */
@Controller
public class CourseController {
	@Resource
	private CourseServiceImpl courseServiceImpl;

	/**
	 * 
	    * @Title: writeCourse  
	    * @Description: 新建课程表 （在新建之前把原来的删除了）
	    * @param @param request
	    * @param @param response
	    * @param @param lists   课程表表列表
	    * @param @param classId 班级id
	    * @return void
	    * @throws
	 */
	@RequestMapping(value = "/courseteacher")
	public void writeCourse(HttpServletRequest request, HttpServletResponse response, String lists, String classId) {
		this.courseServiceImpl.deleteCourse(classId);
		this.courseServiceImpl.updateCourse(classId, lists);

	}

	/**
	 * 
	    * @Title: showCourse  
	    * @Description: 查询课程表  
	    * @param @param request
	    * @param @param response
	    * @param @param classId
	    * @return void
	    * @throws
	 */
	@RequestMapping(value = "/courseparent")
	public void showCourse(HttpServletRequest request, HttpServletResponse response, String classId) {
		response.setCharacterEncoding("UTF-8");
		List<String> l = this.courseServiceImpl.findCourse(classId);

		JSONArray j = JSONArray.fromObject(l);
		String s = j.toString();
		try {
			PrintWriter writer = response.getWriter();
			writer.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
