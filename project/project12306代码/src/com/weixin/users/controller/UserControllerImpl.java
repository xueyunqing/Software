package com.weixin.users.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weixin.users.services.UserServicesImpl;

@Controller
@Transactional(readOnly = true)
public class UserControllerImpl {

	@Resource
	private UserServicesImpl userServicesImpl;

	/**
	 * 
	    * @Title: checkUserAgain  
	    * @Description: 教师通过搜索小程序进入  
	    * @param @param request
	    * @param @param response
	    * @param @param userName
	    * @param @param status
	    * @return void
	    * @throws
	 */
	@Transactional(readOnly = false)
	@RequestMapping("/teacherlogin")
	public void checkUserAgain(HttpServletRequest request, HttpServletResponse response, String wxName, String status) {
		response.setCharacterEncoding("utf-8");
		String s = this.userServicesImpl.findOneTeacher(wxName, status);
		try {
			PrintWriter writer = response.getWriter();
			writer.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	    * @Title: checkUser  
	    * @Description: 			家长通过点击分享保存  
	    * @param @param request
	    * @param @param response
	    * @param @param userName	用户微信名
	    * @param @param status		用户进入小程序方式
	    * @return void
	    * @throws
	 */
	@Transactional(readOnly = false)
	@RequestMapping("/parentlogin")
	public void checkUser(HttpServletRequest request, HttpServletResponse response, String wxName, String status,
			int schoolId, int classId) {
		response.setCharacterEncoding("utf-8");
		String s = this.userServicesImpl.findOneParent(wxName, status, schoolId, classId);
		try {
			PrintWriter writer = response.getWriter();
			writer.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	    * @Title: getUser  
	    * @Description: 已经保存过用户信息之后再次登录查询用户 ，通过微信聊天界面登录
	    * @param @param request
	    * @param @param response
	    * @param @param userName
	    * @return void
	    * @throws
	 */
	@RequestMapping("/getUser")
	public void getUser(HttpServletRequest request, HttpServletResponse response, String wxName) {
		System.out.println(wxName);
		response.setCharacterEncoding("utf-8");
		String s = this.userServicesImpl.getUser(wxName);
		try {
			PrintWriter writer = response.getWriter();
			writer.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
