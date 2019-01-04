package com.weixin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jsoup.select.Elements;



import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class Crawler {

	private static int n;
	private static Connection conn;
	private static Statement st;

public static class MyCrawler extends BreadthCrawler {
		

		public MyCrawler(String crawlPath, boolean autoParse) {
			super(crawlPath, autoParse);
			n=0;
		}

		@Override
		public void visit(Page page, CrawlDatums next) {
			String url = page.url();
			String title = page.doc().title();
			Elements text = page.select("div.articlebody");
			Elements time = page.select("span.time.SG_txtc");
			if (page.matchUrl("http://blog.sina.com.cn/.*")) {
				if (text.isEmpty()) {

					text = page.select("div.articalContent");
				} else {
					text = page.select("div.articalContent");
				}
				time = page.select("span.time.SG_txtc");

			} else if (page.matchUrl("http://baby.sina.com.cn/.*")) {
				if (!page.select("div#artibody.article").isEmpty()) {
					text = page.select("div#artibody.article");
				}
				if (!page.select("dl.content").isEmpty()) {
					text = page.select("dl.content");
				}
				if (!page.select("div#article.article").isEmpty()) {
					text = page.select("div#article.article");
				}
				if (!page.select("div#articlebody").isEmpty()) {
					text = page.select("div#articlebody");
				}
				time = page.select("span.date");
			}
			try {
				if (!text.isEmpty() && !time.isEmpty()) {
					n++;
					insertStu("insert into tbl_news (nTitle,nTime,nBody) values(?,?,?)", title, time.text(), text.text());
				}
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		
		
		public static int insertStu(String sql, String... args) throws SQLException {
			int row = 0;
			PreparedStatement ps = null;
			if (sql == null || sql.equals("")) {
				return 0;
			} else {
				ps = conn.prepareStatement(sql);
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i + 1, args[i]);
				}
				row = ps.executeUpdate();
				return row;
			}
		}

		public static void main(String[] args) {
			MyCrawler myCrawler = new MyCrawler("crawl", true);
			myCrawler.addSeed("http://news.sina.com.cn/");
			myCrawler.addRegex("http://blog.sina.com.cn/.*");
			myCrawler.addRegex("-http://blog.sina.com.cn/u/.*");
			myCrawler.addRegex("http://baby.sina.com.cn/.*");
			myCrawler.addRegex("-http://baby.sina.com.cn/zt_d/.*");
			myCrawler.addRegex("-.*\\.(jpg|png|gif).*");
			myCrawler.addRegex("-.*#.*");
			myCrawler.addRegex("-http://.+.sina.com.cn/.*/$");
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					conn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/weixin?useUnicode=true&characterEncoding=UTF-8", "root", "");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					st = conn.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
			try {
				myCrawler.setThreads(20);
				myCrawler.setMaxExecuteCount(10);
				myCrawler.start(2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
}
}
