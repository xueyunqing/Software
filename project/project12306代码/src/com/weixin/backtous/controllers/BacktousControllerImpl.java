package com.weixin.backtous.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weixin.backtous.services.BacktousServiceImpl;

@Controller
public class BacktousControllerImpl {
	@Resource
	private BacktousServiceImpl backtousServiceImpl;

	/**
	 * 
	    * @Title: saveSuggest  
	    * @Description: 保存用户的建议  
	    * @param @param request
	    * @param @param response
	    * @param @param userName	用户名
	    * @param @param suggest		反馈意见
	    * @return void	
	    * @throws
	 */
	@RequestMapping(value = "mybacktous")
	public void saveSuggest(HttpServletRequest request, HttpServletResponse response, String userName, String suggest) {

		response.setCharacterEncoding("utf-8");
		String s = this.backtousServiceImpl.saveS(userName, suggest);
		try {
			PrintWriter writer = response.getWriter();
			writer.write(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
