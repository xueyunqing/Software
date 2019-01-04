package com.weixin.backtous.dao;

import org.springframework.stereotype.Repository;

import com.weixin.entity.Backtous;
import com.weixin.entity.User;
import com.weixin.util.BaseDao;

@Repository
public class BacktousDaoImpl extends BaseDao<Backtous> {

	@Override
	public void save(Backtous entity) throws Exception {
		super.save(entity);
	}

}
