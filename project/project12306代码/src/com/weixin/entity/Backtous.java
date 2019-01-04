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
 * 
 * @ClassName: Backtous
 * @Description: TODO
 * @author xueyunqing
 * @date 2018年12月3日
 *
 */

@Entity
@Table(name = "tbl_backtous")
public class Backtous {
	private int id;
	private User user;
	private String bBody;
	private String bTime;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getbBody() {
		return bBody;
	}

	public void setbBody(String bBody) {
		this.bBody = bBody;
	}

	public String getbTime() {
		return bTime;
	}

	public void setbTime(String bTime) {
		this.bTime = bTime;
	}

	@ManyToOne
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
