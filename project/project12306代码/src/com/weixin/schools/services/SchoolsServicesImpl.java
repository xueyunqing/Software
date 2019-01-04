package com.weixin.schools.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weixin.entity.Schools;
import com.weixin.schools.dao.SchoolsDaoImpl;

@Service
@Transactional(readOnly = false)
public class SchoolsServicesImpl {
	@Resource
	private SchoolsDaoImpl schoolsDaoImpl;

	/**
	* @return 
	 * 
	    * @Title: save  
	    * @Description: 保存数据到数据库  
	    * @Param@param entity
	    * @Return void
	    * @throws
	 */
	public void save(String province, String city, String county, String name1) {
		try {
			Schools s = new Schools();
			s.setCity(city);
			s.setCounty(county);
			s.setProvince(province);
			s.setSchoolName(name1);
			this.schoolsDaoImpl.save(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	    * @Title: findOne  
	    * @Description: 查询学校ID
	    * @Param@param grade
	    * @Param@param classInt
	    * @Param@return
	    * @Return Classes
	    * @throws
	 */
	public int findOne(String province, String city, String county, String name1) {
		String hql = "from Schools cl where cl.province=? and cl.city=? and cl.county=? and cl.schoolName=?";
		Object[] ob = new Object[4];
		ob[0] = province;
		ob[1] = city;
		ob[2] = county;
		ob[3] = name1;
		Schools s1 = new Schools();
		try {
			Schools s2 = this.schoolsDaoImpl.findOne(hql, ob);
			return s2.getSchoolId();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
