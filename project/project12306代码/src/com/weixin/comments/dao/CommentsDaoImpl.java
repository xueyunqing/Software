package com.weixin.comments.dao;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.weixin.entity.Activity;
import com.weixin.entity.Comments;
import com.weixin.util.BaseDao;

@Repository
public class CommentsDaoImpl extends BaseDao<Comments>{
	
	 
	 private String entityClass= Activity.class.getSimpleName();  
     @Resource
     private SessionFactory sessionFactory;
     /*
      * 
         *   
         * 閲嶅啓BaseDao鐨勬煡璇㈠姛鑳�
         * @return
         * @throws Exception  
         * @see com.weixin.util.BaseDao#findAll()
      */
     @Override
	 public List<Comments> findAll() throws Exception {
			Query query = this.sessionFactory.getCurrentSession().createQuery("from " + entityClass);
			return query.list();
		}
     
}

