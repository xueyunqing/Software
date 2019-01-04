package com.weixin.users.dao;

import org.springframework.stereotype.Repository;

import com.weixin.entity.User;
import com.weixin.util.BaseDao;

@Repository
public class UserDaoImpl extends BaseDao <User>{

	
	@Override
	public User findOne(String hql, Object[] params) throws Exception {
		return super.findOne(hql, params);
	}

	@Override
	public void save(User entity) throws Exception {
		super.save(entity);
	}

	@Override
	public void update(User entity) throws Exception {
		super.update(entity);
	}

	@Override
	public void delete(Object entity) throws Exception {
		super.delete(entity);
	}

	
}
