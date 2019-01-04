package com.weixin.backtous.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weixin.backtous.dao.BacktousDaoImpl;
import com.weixin.entity.Backtous;
import com.weixin.entity.User;
import com.weixin.users.dao.UserDaoImpl;

@Service
public class BacktousServiceImpl {

	@Resource
	private BacktousDaoImpl backtousDaoImpl;
	@Resource
	private UserDaoImpl userDaoImpl;
	
	/**
	 * 
	    * @Title: saveSuggest  
	    * @Description: 根据用户名查出用户并将反馈意见插入到数据库中
	    * @param @param userName	用户名
	    * @param @param suggest		反馈已将
	    * @param @return
	    * @return String		无错误返回true 有错返回false
	    * @throws
	 */
	public String saveS(String userName, String suggest) {
		String hql = "from User where wxName=?";
		Object[] params = new Object[1];
		params[0] = userName;
		Date date = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		String time = s.format(date);
		try {
			User u =  this.userDaoImpl.findOne(hql, params);
			Backtous b = new Backtous();
			User user = new User();
			user.setId(u.getId());
			b.setbBody(suggest);
			b.setUser(user);
			b.setbTime(time); 
			this.backtousDaoImpl.save(b);
			return "true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "false";
	}
}
