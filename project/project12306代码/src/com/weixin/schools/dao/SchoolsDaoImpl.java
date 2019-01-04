package com.weixin.schools.dao;

import org.springframework.stereotype.Repository;

import com.weixin.entity.Schools;
import com.weixin.util.BaseDao;

@Repository
public class SchoolsDaoImpl extends BaseDao<Schools>{
     

    @Override
	public void save(Schools entity) throws Exception {
		// TODO Auto-generated method stub
		super.save(entity);
	}

	@Override
    public Schools findOne(String hql, Object[] params) throws Exception {
		
		return super.findOne(hql, params);
	}

	@Override
	public void update(Schools entity) throws Exception {
		super.update(entity);
	}

	
    
}
