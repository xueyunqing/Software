package com.weixin.myclass.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.weixin.entity.Classes;
import com.weixin.util.BaseDao;

@Repository
public class MyClassDaoImpl extends BaseDao<Classes>{
     /*
      * 
         *   
         *  创建班级保存到数据库
         * @param entity
         * @throws Exception  
         * @see com.weixin.util.BaseDao#save(java.lang.Object)
      */
	@Override
	public void save(Classes entity) throws Exception {		
		super.save(entity);
	}
	
	 /*
     * 
        *   
        * 查询班级对象   
        * @param hql
        * @param params
        * @return
        * @throws Exception  
        * @see com.weixin.util.BaseDao#findOne(java.lang.String, java.lang.Object[])
     */
    @Override
    public Classes findOne(String hql, Object[] params) throws Exception {
		
		return super.findOne(hql, params);
	}

    
    
	@Override
	public Map<String, Object> findOneBySql(String sql, Object[] params) throws Exception {
		return super.findOneBySql(sql, params);
	}

	@Override
	public List<Classes> find(String hql, Object[] params) throws Exception {
		return super.find(hql, params);
	}

	@Override
	public void update(Classes entity) throws Exception {
		super.update(entity);
	}
    
}
