package com.weixin.check.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.weixin.entity.Check;
import com.weixin.entity.Students;
import com.weixin.util.BaseDao;

/**
 * 
    * @ClassName: CheckDaoImpl  
    * @Description: 考勤  
    * @author xueyunqing  
    * @date 2018年12月6日  
    *
 */
@Repository
public class CheckDaoImpl extends BaseDao<Check> {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<Check> find(String hql, Object[] params) throws Exception {
		// TODO Auto-generated method stub
		return super.find(hql, params);
	}

	/**
	 * 
	    * @Title: insertAbsence  
	    * @Description: 插入请假表中
	    * @param @param studentDate  请假日期
	    * @param @param s
	    * @return void
	    * @throws
	 */
	public void insertAbsence(String studentDate, Students s) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("insert into tbl_check(cTime,absence,delay,classId) values(?,?,?,?)");
		query.setParameter(0, studentDate);
		query.setParameter(1, s.getName());
		query.setParameter(2, "0");
		query.setParameter(3, s.getClasss().getClassId());
		query.executeUpdate();

	}

	/**
	 * 
	    * @Title: insertDelay  
	    * @Description: 插入迟到表中 
	    * @param @param studentDate  迟到日期
	    * @param @param s
	    * @return void
	    * @throws
	 */
	public void insertDelay(String studentDate, Students s) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("insert into tbl_check(cTime,absence,delay,classId) values(?,?,?,?)");
		query.setParameter(0, studentDate);
		query.setParameter(1, "0");
		query.setParameter(2, s.getName());
		query.setParameter(3, s.getClasss().getClassId());
		query.executeUpdate();
	}

}
