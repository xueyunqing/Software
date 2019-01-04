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
    * @ClassName: Time  
    * @Description: TODO  
    * @author xueyunqing  
    * @date 2018年12月3日 
    *
 */

@Entity
@Table(name="tbl_time")
public class Time {
	private int id;
	private String go;
	private String back;
	private Classes classs;

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

	@ManyToOne
	@JoinColumn(name="classId")
	public Classes getClasss() {
		return classs;
	}

	public void setClasss(Classes classs) {
		this.classs = classs;
	}


}
