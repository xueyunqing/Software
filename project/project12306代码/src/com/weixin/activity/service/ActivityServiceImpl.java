package com.weixin.activity.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weixin.activity.dao.ActivityDaoImpl;
import com.weixin.entity.Activity;

@Service
@Transactional(readOnly=false)
public class ActivityServiceImpl {
    @Resource
    private ActivityDaoImpl activityDaoImpl;
    /**
     * 
        * @Title: list  
        * @Description: TODO  
        * @Param@return
        * @Return List<Activity>
        * @throws
     */
    public List<Activity> list(){
    	try {
    		List<Activity> list=this.activityDaoImpl.findAll();  
        	List<Activity> list2=new ArrayList<>();
        	for(Activity a1:list) {
        		Activity w=new Activity();
        		w.setId(a1.getId());
        		w.setaTime(a1.getaTime());
        		w.setaBody(a1.getaBody());
        		list2.add(w);
        	}
			return list2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
    }
    /**
     * 
        * @Title: list  
        * @Description:根据班级ID查询本班级的活动
        * @Param@param id
        * @Param@return
        * @Return List<Activity>
        * @throws
     */
    public List<Activity> list(int id){
    	 String hql="from Activity where classId=?";
		 Object[] ob = new Object[1];
		 ob[0]=id;
    	try {
    		List<Activity> list=this.activityDaoImpl.find(hql,ob);  
        	List<Activity> list2=new ArrayList<>();
        	for(Activity a1:list) {
        		Activity w=new Activity();
        		w.setId(a1.getId());
        		w.setaTime(a1.getaTime());
        		w.setaBody(a1.getaBody());
        		list2.add(w);
        	}
			return list2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
    }
    
    /**
     * 
        * @Title: addactivity  
        * @Description: TODO  
        * @Param@param entity
        * @Return void
        * @throws
     */
    public void addactivity(Activity entity) {
       try {
		this.activityDaoImpl.save(entity);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
}
