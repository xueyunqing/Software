package com.weixin.students.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weixin.entity.Classes;
import com.weixin.entity.Students;
import com.weixin.students.dao.AddStudentDaoImpl;

@Service
public class AddStudentServicesImpl {

	@Resource
	private AddStudentDaoImpl addStudentDaoImpl;
	
	/**
	 * 
	    * @Title: saveStudents  
	    * @Description: 第一个是空字符串不保存，学生姓名按空格分开重复学生不保存
	    * @param @param studentNames
	    * @param @param classId
	    * @param @return
	    * @return String
	    * @throws
	 */
	public String saveStudents(String stuNames, int classId) {
		String[] strs = stuNames.split(" ");
		for(int i = 1; i < strs.length; i++) {
			System.out.println("student name" + strs[i]);
			Students s = new Students();
			Classes c = new Classes();
			s.setName(strs[i]);
			s.setClasss(c);
			s.getClasss().setClassId(classId);
			try {
				this.addStudentDaoImpl.save(s);
			} catch (Exception e) {
				e.printStackTrace();
				return "false";
			}
		}
		return "true";
		
	}
	
}
