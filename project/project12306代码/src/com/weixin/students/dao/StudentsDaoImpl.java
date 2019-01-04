package com.weixin.students.dao;
import java.util.List;

import javax.annotation.Resource;


import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.weixin.entity.Students;
import com.weixin.util.BaseDao;

@Repository
public class StudentsDaoImpl extends BaseDao<Students> {
	 private String entityClass= Students.class.getSimpleName();  
	    @Resource
	    private SessionFactory sessionFactory;
	    /*
	     * 
	        * 重写BaseDao查询功能 从Students中查询数据
	        * @return
	        * @throws Exception  
	        * @see com.weixin.util.BaseDao#findAll()
	     */
	    @Override
	    public List<Students> find(String hql, Object[] params) throws Exception {
	          return super.find(hql, params);
	    }
		@Override
		public Students findOne(String hql, Object[] params) throws Exception {
			// TODO Auto-generated method stub
			return super.findOne(hql, params);
		} 
}
