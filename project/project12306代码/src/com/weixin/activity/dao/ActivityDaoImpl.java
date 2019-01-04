package com.weixin.activity.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.weixin.entity.Activity;
import com.weixin.util.BaseDao;

@Repository
public class ActivityDaoImpl extends BaseDao<Activity>{
	
	 
	 private String entityClass= Activity.class.getSimpleName();  
     @Resource
     private SessionFactory sessionFactory;
     /*
      * 
         *   
         * 重写BaseDao的查询功能
         * @return
         * @throws Exception  
         * @see com.weixin.util.BaseDao#findAll()
      */
     @Override
	 public List<Activity> findAll() throws Exception {
			Query query = this.sessionFactory.getCurrentSession().createQuery("from " + entityClass);
			return query.list();
		}
     @Override
	    public List<Activity> find(String hql, Object[] params) throws Exception {
	          return super.find(hql, params);
	    }
     @Override
     public void save(Activity entity) throws Exception {
 		super.save(entity);
 	}
}
