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
    * @ClassName: Schooltime  
    * @Description: TODO  
    * @author xueyunqing 
    * @date 2018年12月3日 
    *
 */
@Entity
@Table(name="tbl_schooltime")
public class Schooltime {
	private int id;
	private Classes classs;
	private User user;
	private String go;
	private String back;
	private String remark;
	private String sTime;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getGo() {
		return go;
	}

	public void setGo(String go) {
		this.go = go;
	}

	public String getBack() {
		return back;
	}

	public void setBack(String back) {
		this.back = back;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getsTime() {
		return sTime;
	}

	public void setsTime(String sTime) {
		this.sTime = sTime;
	}

	@ManyToOne
	@JoinColumn(name="classId")
	public Classes getClasss() {
		return classs;
	}

	public void setClasss(Classes classs) {
		this.classs = classs;
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
