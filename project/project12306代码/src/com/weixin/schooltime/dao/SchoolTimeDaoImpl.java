package com.weixin.schooltime.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.weixin.entity.Activity;
import com.weixin.entity.Schooltime;
import com.weixin.util.BaseDao;

@Repository
public class SchoolTimeDaoImpl extends BaseDao<Schooltime>{
     /*
      * 
         *   
         * 重写BaseDao的存数据功能
         * @param entity
         * @throws Exception  
         * @see com.weixin.util.BaseDao#save(java.lang.Object)
      */
	@Override
	public void save(Schooltime entity) throws Exception {
		super.save(entity);
	}
	
	private String entityClass= Schooltime.class.getSimpleName();  
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
	 public List<Schooltime> findAll() throws Exception {
			Query query = this.sessionFactory.getCurrentSession().createQuery("from " + entityClass);
			return query.list();
		}
    @Override
    public List<Schooltime> find(String hql, Object[] params) throws Exception {
          return super.find(hql, params);
    }
}
