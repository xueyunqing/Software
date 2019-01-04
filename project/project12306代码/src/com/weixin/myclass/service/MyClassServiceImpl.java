package com.weixin.myclass.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weixin.entity.Classes;
import com.weixin.entity.Schools;
import com.weixin.myclass.dao.MyClassDaoImpl;
import com.weixin.schools.services.SchoolsServicesImpl;

@Service
@Transactional(readOnly = false)
public class MyClassServiceImpl {
	@Resource
	private MyClassDaoImpl myClassDaoImpl;
	@Resource
	private SchoolsServicesImpl schoolsServicesImpl;

	/**
	* @return 
	 * 
	    * @Title: save  
	    * @Description: 保存数据到数据库  
	    * @Param@param entity
	    * @Return void
	    * @throws
	 */
	public void save(int grade, int classint, String province, String city, String county, String name1) {
		int s = this.schoolsServicesImpl.findOne(province, city, county, name1);
		try {
			Classes c = new Classes();
			c.setGrade(grade);
			c.setClassInt(classint);
			Schools s1 = new Schools();
			s1.setSchoolId(s);
			c.setSchool(s1);
			myClassDaoImpl.save(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	    * @Title: findOne  
	    * @Description: 根据班级名称查询班级ID  
	    * @Param@param grade
	    * @Param@param classInt
	    * @Param@return
	    * @Return Classes
	    * @throws
	 */
	public int findOne(int grade, int classInt, int schoolId) {

		String hql = "from Classes cl where cl.grade=? and cl.classInt=? ";
		Object[] ob = new Object[2];
		ob[0] = grade;
		ob[1] = classInt;
		Classes c1 = new Classes();
		try {
			List<Classes> c2 = this.myClassDaoImpl.find(hql, ob);
			for (Classes c : c2) {
				if (c.getSchool().getSchoolId() == schoolId) {
					c1.setClassId(c.getClassId());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return c1.getClassId();
	}
    /**
     * 
        * @Title: findClass  
        * @Description: 根据ID查询班级  
        * @Param@param classId
        * @Param@return
        * @Return Classes
        * @throws
     */
	public Classes findClass(int classId) {
		String hql = "from Classes where classId=?";
		Object[] ob = new Object[1];
		ob[0] = classId;
		try {
			return this.myClassDaoImpl.findOne(hql, ob);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
    /**
     * 
        * @Title: update  
        * @Description:修改班级属性值
        * @Param@param c
        * @Return void
        * @throws
     */
	public void update(Classes c) {
		try {
			this.myClassDaoImpl.update(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
