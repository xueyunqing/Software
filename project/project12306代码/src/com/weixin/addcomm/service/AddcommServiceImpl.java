//package com.weixin.addcomm.service;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Service;
//
//import com.weixin.addcomm.dao.AddcommDaoImpl;
//import com.weixin.backtous.dao.BacktousDaoImpl;
//import com.weixin.entity.Backtous;
//import com.weixin.entity.Comments;
//import com.weixin.entity.User;
//import com.weixin.users.dao.UserDaoImpl;
//
//
//	@Service
//	public class AddcommServiceImpl {
//
//		@Resource
//		private AddcommDaoImpl addcommDaoImpl;
//		@Resource
//		private UserDaoImpl userDaoImpl;
//		
//		/**
//		 * 
//		    * @Title: saveSuggest  
//		    * @Description: 根据用户名查出用户并将反馈意见插入到数据库中
//		    * @param @param userName	用户名
//		    * @param @param suggest		反馈已将
//		    * @param @return
//		    * @return String		无错误返回true 有错返回false
//		    * @throws
//		 */
//		public String saveComment(String userName, String cBody,Boolean anonymity) {
//			String hql = "from User where name=?";
//			Object[] params = new Object[1];
//			params[0] = userName;
//			try {
//				User u =  this.userDaoImpl.findOne(hql, params);
//				Comments b = new Comments();
//				b.setcBody(cBody);
//				b.setAnonymity(anonymity);
//				b.setUser(u);
//				this.addcommDaoImpl.save(b);
//				return "true";
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return "false";
//		}
//	}
//
