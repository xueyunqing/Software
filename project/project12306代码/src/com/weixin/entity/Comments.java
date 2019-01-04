package com.weixin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @ClassName: Comments
 * @Description: TODO
 * @author xueyunqing
 * @date 2018年12月3日
 *
 */

@Entity
@Table(name = "tbl_comments")
public class Comments {
	private int id;
	private String cBody;
	private int thumbs;
	private String comments;
	private User user;
	private Classes classs;
	private boolean anonymity;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getcBody() {
		return cBody;
	}

	public void setcBody(String cBody) {
		this.cBody = cBody;
	}

	public int getThumbs() {
		return thumbs;
	}

	public void setThumbs(int thumbs) {
		this.thumbs = thumbs;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public boolean isAnonymity() {
		return anonymity;
	}

	public void setAnonymity(boolean anonymity) {
		this.anonymity = anonymity;
	}

	@ManyToOne
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name="classId")
	public Classes getClasss() {
		return classs;
	}

	public void setClasss(Classes classs) {
		this.classs = classs;
	}

}
