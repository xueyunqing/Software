package com.weixin.students.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weixin.students.service.AddStudentServicesImpl;

@Controller
public class AddStudentController {

	@Resource
	private AddStudentServicesImpl addStudentServicesImpl;

	/**
	 * 
	    * @Title: saveStudents  
	    * @Description: 教师添加学生  
	    * @param @param response
	    * @param @param stuNames
	    * @param @param classId
	    * @return void
	    * @throws
	 */
	@RequestMapping(value = "saveStudent")
	public void saveStudents(HttpServletResponse response, String stuNames, int classId) {
		System.out.println(stuNames);
		try {
			PrintWriter writer = response.getWriter();
			writer.write(this.addStudentServicesImpl.saveStudents(stuNames, classId));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
