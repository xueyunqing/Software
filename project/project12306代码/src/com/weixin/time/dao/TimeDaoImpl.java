package com.weixin.time.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import com.weixin.entity.Time;
import com.weixin.util.BaseDao;
@Repository
public class TimeDaoImpl extends BaseDao<Time>{
	
	
	     /*
	      * 
	         *   
	         * 重写BaseDao的存数据功能
	         * @param entity
	         * @throws Exception  
	         * @see com.weixin.util.BaseDao#save(java.lang.Object)
	      */
		@Override
		public void save(Time entity) throws Exception {
			super.save(entity);
		}
		
		private String entityClass= Time.class.getSimpleName();  
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
	    public List<Time> find(String hql, Object[] params) throws Exception {
	          return super.find(hql, params);
	    }
	    @Override
		 public List<Time> findAll() throws Exception {
				Query query = this.sessionFactory.getCurrentSession().createQuery("from " + entityClass);
				return query.list();
			}


}
