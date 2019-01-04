package com.weixin.time.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weixin.entity.Time;
import com.weixin.time.dao.TimeDaoImpl;

@Service
@Transactional(readOnly=false)
public class TimeServiceImpl {
     @Resource
     public TimeDaoImpl timeDaoImpl;
     /**
      * 
         * @Title: 保存数据
         * @Description: TODO  
         * @Param@param entity
         * @Return void
         * @throws
      */
     public void save(Time entity) {
 		try {
 			timeDaoImpl.save(entity);
 			
 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 	}
 	/**
 	 *  
 	    * @Title: 查询数据
 	    * @Description: TODO  
 	    * @Param@return
 	    * @Return List<Time>
 	    * @throws
 	 */
 	 public List<Time> list(){
 	    	try {
 	    		List<Time> list=this.timeDaoImpl.findAll();
 				List<Time> list2=new ArrayList<>();
 		     	for(Time a1:list) {
 		     		Time w=new Time();
 		     		w.setId(a1.getId());
 		     		w.setGo(a1.getGo());
 		     		w.setBack(a1.getBack());
 		     		
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
 	     * @Description: 根据班级ID查询时间表中数据
 	     * @Param@return
 	     * @Return List<Time>
 	     * @throws
 	  */
 	 public List<Time> list(int id){
 		 String hql="from Time where classId=?";
		 Object[] ob = new Object[1];
		 ob[0]=id;
	    	try {
	    		List<Time> list=this.timeDaoImpl.find(hql,ob);
				List<Time> list2=new ArrayList<>();
		     	for(Time a1:list) {
		     		Time w=new Time();
		     		w.setId(a1.getId());
		     		w.setGo(a1.getGo());
		     		w.setBack(a1.getBack());
		     		
		     		list2.add(w);
		     	}
		     	return list2;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
	    }
     
}
