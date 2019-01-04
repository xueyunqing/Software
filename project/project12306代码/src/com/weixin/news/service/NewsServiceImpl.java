package com.weixin.news.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;

import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weixin.backtous.dao.BacktousDaoImpl;
import com.weixin.entity.Activity;
import com.weixin.entity.Backtous;
import com.weixin.entity.News;
import com.weixin.entity.User;
import com.weixin.news.dao.NewsDaoImpl;
import com.weixin.users.dao.UserDaoImpl;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

@Service
@Transactional(readOnly=false)
public class NewsServiceImpl {
	
	
	@Resource
	private NewsDaoImpl newsDaoImpl;
	
	
	 public List<News> list(){
	    	try {
				return this.newsDaoImpl.findAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	    }

	

	
	
}
