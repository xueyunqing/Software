package com.weixin.news.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.weixin.entity.Activity;
import com.weixin.entity.Backtous;
import com.weixin.entity.News;
import com.weixin.util.BaseDao;
@Repository
public class NewsDaoImpl extends BaseDao<News>{
	
	private String entityClass= News.class.getSimpleName();  
    @Resource
    private SessionFactory sessionFactory;
    
	@Override
	public void save(News entity) throws Exception {
		// TODO Auto-generated method stub
		super.save(entity);
	}
	@Override
	public List<News> findAll() throws Exception {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from " + entityClass);
		return query.list();
	}
 
}
