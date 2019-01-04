package com.weixin.students.dao;

import org.springframework.stereotype.Repository;

import com.weixin.entity.Students;
import com.weixin.util.BaseDao;

@Repository
public class AddStudentDaoImpl extends BaseDao<Students> {

	@Override
	public void save(Students entity) throws Exception {
		super.save(entity);
	}

	
	
}
