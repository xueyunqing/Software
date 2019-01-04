package com.weixin.students.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weixin.entity.Students;
import com.weixin.entity.User;
import com.weixin.students.dao.StudentsDaoImpl;

@Service
@Transactional(readOnly=false)
public class StudentsServiceImpl{
     @Resource
     private StudentsDaoImpl studentsDaoImpl;
     /**
      * 
         * @Title: findById  
         * @Description: 从学生表里查出一个班级的学生 
         * @Param@param id
         * @Param@return
         * @Return List<Students>
         * @throws
      */
     public List<Students> findById(int id){
		 String hql="from Students where classId=?";
		 Object[] ob = new Object[1];
		 ob[0]=id;
		 try {
			 List<Students> list=this.studentsDaoImpl.find(hql,ob);	
			 List<Students> list2=new ArrayList<>();
	          for(Students l:list) {
	        	  Students s=new Students();
	        	  s.setId(l.getId());
	        	  s.setName(l.getName());        	  
	        	  list2.add(s);
	          }
	          return list2;
		 }catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
     }
     
        
     /**
      * 
         * @Title: findOne  
         * @Description: 根据学生班级和姓名查学生  
         * @param @param studentName  学生姓名，classId 学生班级
         * @param @return
         * @return Students
         * @throws
      */
 	public Students findOne(int classId,String studentName) {
		String hql = "from Students  where classId=? and  name=? ";
		Object[] ob = new Object[2];
		ob[0]=classId;
		ob[1] = studentName;
		try {
			return this.studentsDaoImpl.findOne(hql, ob);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
}
