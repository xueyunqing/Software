package com.weixin.course.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.weixin.entity.Course;
import com.weixin.util.BaseDao;

@Repository
public class CourseDaoImpl extends BaseDao<Course> {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void save(Course entity) throws Exception {
		super.save(entity);
	}

	@Override
	public int excuteBySql(String sql, Object[] params) throws Exception {
		return super.excuteBySql(sql, params);
	}

	@Override
	public Long findCountBySql(String sql, Object[] params) throws Exception {

		return super.findCountBySql(sql, params);
	}

}
