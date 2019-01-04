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
    * @ClassName: Homework  
    * @Description: TODO  
    * @author xueyunqing  
    * @date 2018年12月3日   
    *
 */
@Entity
@Table(name="tbl_homework")
public class Homework {
	private int id;
	private String hTime;
	private String hBody;
	private Classes classs;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String gethTime() {
		return hTime;
	}

	public void sethTime(String hTime) {
		this.hTime = hTime;
	}

	public String gethBody() {
		return hBody;
	}

	public void sethBody(String hBody) {
		this.hBody = hBody;
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
