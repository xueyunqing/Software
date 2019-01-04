package com.weixin.check.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weixin.check.dao.CheckDaoImpl;
import com.weixin.entity.Check;
import com.weixin.entity.Students;
import com.weixin.entity.User;
import com.weixin.users.dao.UserDaoImpl;

/**
 * 
    * @ClassName: CheckServiceImpl  
    * @Description: 考勤  
    * @author xueyunqing  
    * @date 2018年12月6日  
    *
 */
@Service
@Transactional(readOnly = true)
public class CheckServiceImpl {
	@Resource
	private CheckDaoImpl checkDaoImpl;

	/**
	 * 
	    * @Title: findAbsence  
	    * @Description: 通过班级id查询请假学生  
	    * @param classId   班级id
	    * @return List<Check>
	    * @throws
	 */
	public List<Check> findAbsence(String classId) {
		List<Check> list0 = new ArrayList<Check>();
		List<Check> list1 = new ArrayList<Check>();
		List<Check> list;
		int classId1 = Integer.parseInt(classId);
		Object[] object = new Object[2];
		object[0] = classId1;
		object[1] = "0";
		try {
			list = this.checkDaoImpl.find("from Check where classId=? and delay =? order by id desc", object);

			for (Check r : list) {
				Check r1 = new Check();
				r1.setId(r.getId());
				r1.setcTime(r.getcTime());
				r1.setAbsence(r.getAbsence());
				r1.setDelay(r.getDelay());
				list1.add(r1);
			}

			if (list1.size() < 8) {
				for (int i = 0; i < list.size(); i++) {

					list0.add(list1.get(i));

				}
			} else {
				for (int i = 0; i < 8; i++) {

					list0.add(list1.get(i));

				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list0;
	}

	/**
	 * 
	    * @Title: findDelay  
	    * @Description:通过班级id查询迟到学生 
	    * @param classId  班级id
	    * @return List<Check>
	    * @throws
	 */
	public List<Check> findDelay(String classId) {
		List<Check> list0 = new ArrayList<Check>();
		List<Check> list1 = new ArrayList<Check>();
		List<Check> list;
		int classId1 = Integer.parseInt(classId);
		Object[] object = new Object[2];
		object[0] = classId1;
		object[1] = "0";
		try {
			list = this.checkDaoImpl.find("from Check where classId=? and absence =? order by id desc", object);
			for (Check r : list) {
				Check r1 = new Check();
				r1.setId(r.getId());
				r1.setcTime(r.getcTime());
				r1.setAbsence(r.getAbsence());
				r1.setDelay(r.getDelay());
				list1.add(r1);
			}

			if (list1.size() < 8) {
				for (int i = 0; i < list.size(); i++) {

					list0.add(list1.get(i));

				}
			} else {
				for (int i = 0; i < 8; i++) {

					list0.add(list1.get(i));

				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list0;
	}

	/**
	 * 
	    * @Title: updateCheckAbsence  
	    * @Description: 插入 请假学生
	    * @param @param studentDate  请假时间
	    * @param @param s  请假学生
	    * @return void
	    * @throws
	 */
	public void updateCheckAbsence(String studentDate, Students s) {
		this.checkDaoImpl.insertAbsence(studentDate, s);
	}

	/**
	 * 
	    * @Title: updateCheckDelay  
	    * @Description: 插入迟到学生 
	    * @param @param studentDate  迟到时间
	    * @param @param s   迟到学生
	    * @return void
	    * @throws
	 */
	public void updateCheckDelay(String studentDate, Students s) {
		this.checkDaoImpl.insertDelay(studentDate, s);
	}

}
