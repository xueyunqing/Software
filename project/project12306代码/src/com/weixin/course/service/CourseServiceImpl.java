package com.weixin.course.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weixin.check.dao.CheckDaoImpl;
import com.weixin.course.dao.CourseDaoImpl;
import com.weixin.entity.Classes;
import com.weixin.entity.Course;

@Service

public class CourseServiceImpl {
	@Resource
	private CourseDaoImpl courseDaoImpl;

	/**
	 * 
	    * @Title: updateCourse  
	    * @Description: 更新新的课程表  
	    * @param @param classId
	    * @param @param lists
	    * @return void
	    * @throws
	 */
	@Transactional(readOnly = false)
	public void updateCourse(String classId, String lists) {

		String[] list = lists.split(",");
		List list0 = new ArrayList();
		int classId1;
		if (classId == null) {
			classId = "1";
		}
		classId1 = Integer.parseInt(classId);

		for (int i = 0; i < list.length; i++) {
			list0.add(list[i]);
		}
		for (int i = 0; i < list0.size(); i++) {

			Course course = new Course();
			Classes classes = new Classes();
			classes.setClassId(classId1);
			int workday = (i % 5) + 1;
			int lesson = (i / 5) + 1;

			course.setWorkday(workday);
			course.setLesson(lesson);
			course.setContent((String) list0.get(i));
			course.setClasses(classes);
			Object[] object = new Object[2];
			object[0] = classId1;

			try {
				courseDaoImpl.save(course);
				object[1] = course.getId();
				this.courseDaoImpl.excuteBySql("update tbl_course set classId=?  where id=?", object);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * 
	    * @Title: findCourse  
	    * @Description: 查询课程表
	    * @param @param classId
	    * @param @return
	    * @return List
	    * @throws
	 */

	public List findCourse(String classId) {
		int classId1;
		List listzong = new ArrayList();
		if (classId == null) {
			classId = "1";
		}
		classId1 = Integer.parseInt(classId);
		for (int i = 0; i < 8; i++) {
			Object[] object = new Object[2];
			object[0] = classId1;
			object[1] = i + 1;
			try {
				List list = this.courseDaoImpl.findBySql("select content from tbl_course where classId=? and lesson=?",
						object);
				for (Object m : list) {
					listzong.add(m);
				}

			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}

		System.out.println("jinlaileha");
		System.out.println(listzong.size());
		for (int i = 0; i < listzong.size(); i++) {
			System.out.println(listzong.get(i));
		}
		return listzong;
	}

	/**
	 * 
	    * @Title: deleteCourse  
	    * @Description: 删除原来的课程表 
	    * @param @param classId
	    * @return void
	    * @throws
	 */

	public void deleteCourse(String classId) {
		int classId1;
		if (classId == null) {
			classId = "1";
		}
		classId1 = Integer.parseInt(classId);
		Object[] object = new Object[1];
		object[0] = classId1;

		try {
			this.courseDaoImpl.excuteBySql("delete from tbl_course where classId=?", object);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
