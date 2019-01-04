package com.weixin.comments.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.weixin.comments.dao.CommentsDaoImpl;

import com.weixin.entity.Comments;

@Service
@Transactional(readOnly=false)
public class CommentsServiceImpl {
    @Resource
    private CommentsDaoImpl commentsDaoImpl;
    
    public List<Comments> list(){
    	try {
			return this.commentsDaoImpl.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
}

