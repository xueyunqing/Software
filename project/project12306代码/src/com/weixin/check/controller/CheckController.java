package com.weixin.check.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weixin.check.service.CheckServiceImpl;
import com.weixin.entity.Check;
import com.weixin.entity.Students;
import com.weixin.students.service.StudentsServiceImpl;
import com.weixin.users.services.UserServicesImpl;

import net.sf.json.JSONArray;

/**
 * 
 * @ClassName: CheckController
 * @Description: 考勤的系列操作
 * @author xueyunqing
 * @date 2018年12月6日
 *
 */
@Controller
public class CheckController {
	@Resource
	private CheckServiceImpl checkServiceImpl;

	@Resource
	private StudentsServiceImpl studentsServiceImpl;

	/**
	 * 
	    * @Title: printAbsence  
	    * @Description: 查询请假学生 
	    * @param @param request
	    * @param @param response
	    * @param @param classId 班级ID
	    * @return void
	    * @throws
	 */
	@RequestMapping(value = "/absence")
	public void printAbsence(HttpServletRequest request, HttpServletResponse response, String classId) {
		response.setCharacterEncoding("UTF-8");
		List<Check> list = this.checkServiceImpl.findAbsence(classId);
		JSONArray j1 = JSONArray.fromObject(list);
		String j12String = j1.toString();

		try {

			PrintWriter writer = response.getWriter();
			writer.write(j12String);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	    * @Title: printDelay  
	    * @Description: 查询迟到学生 
	    * @param @param request
	    * @param @param response
	    * @param @param classId 班级ID
	    * @return void
	    * @throws
	 */
	@RequestMapping(value = "/delay")
	public void printDelay(HttpServletRequest request, HttpServletResponse response, String classId) {
		response.setCharacterEncoding("UTF-8");
		List<Check> list = this.checkServiceImpl.findDelay(classId);
		JSONArray j1 = JSONArray.fromObject(list);
		String j12String = j1.toString();

		try {

			PrintWriter writer = response.getWriter();
			writer.write(j12String);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	    * @Title: writeDelay  
	    * @Description: 先判断老师输入的迟到学生姓名有没有，如果有，插入 到迟到表中    
	    * @param @param request
	    * @param @param response
	    * @param @param studentName  迟到学生姓名
	    * @param @param studentDate   迟到时间
	    * @param @param classId 班级ID
	    * @return void
	    * @throws
	 */
	@Transactional(readOnly = false)
	@RequestMapping(value = "/delayteacher")
	public void writeDelay(HttpServletRequest request, HttpServletResponse response, String classId, String studentName,
			String studentDate) {
		response.setCharacterEncoding("UTF-8");
		int classId1 = Integer.parseInt(classId);
		Students s = this.studentsServiceImpl.findOne(classId1, studentName);
		System.out.println(s);
		if (null != s) {
			this.checkServiceImpl.updateCheckDelay(studentDate, s);

		}
	}

	/**
	 * 
	    * @Title: writeAbsence  
	    * @Description: 先判断老师输入的请假学生姓名有没有，如果有，插入 到请假表中      
	    * @param @param request
	    * @param @param response
	    * @param @param studentName1  请假学生姓名
	    * @param @param studentDate1 请假时间
	    * @param @param classId 班级ID
	    * @return void
	    * @throws
	 */
	@Transactional(readOnly = false)
	@RequestMapping(value = "/absenceteacher")
	public void writeAbsence(HttpServletRequest request, HttpServletResponse response, String classId,
			String studentName1, String studentDate1) {
		int classId1 = Integer.parseInt(classId);
		response.setCharacterEncoding("UTF-8");
		Students s = this.studentsServiceImpl.findOne(classId1, studentName1);
		System.out.println(s);
		if (null != s) {
			System.out.println("jinlaiel");
			this.checkServiceImpl.updateCheckAbsence(studentDate1, s);
		}
	}

}
