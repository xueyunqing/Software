package com.weixin.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
    * @ClassName: User  
    * @Description: TODO  
    * @author xueyunqing 
    * @date 2018年12月3日   
    *
 */
@Entity
@Table(name="tbl_user")
public class User {
	private int id;
	private String name;
	private String phoneNum;
	private String images;
	private Classes classs;
	private int status;
	private int studentId;
	private Schools school;
	private String wxName;
	private Set<Schooltime> schooltimes = new HashSet<>();
	private Set<Notice> notices = new HashSet<>();
	private Set<Comments> comments = new HashSet<>();
	private Set<Backtous> backtous = new HashSet<>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	
	public String getWxName() {
		return wxName;
	}

	public void setWxName(String wxName) {
		this.wxName = wxName;
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
	@JoinColumn(name="schoolId")
	public Schools getSchool() {
		return school;
	}

	public void setSchool(Schools school) {
		this.school = school;
	}

	@OneToMany(mappedBy="user",targetEntity=Schooltime.class)
	public Set<Schooltime> getSchooltimes() {
		return schooltimes;
	}

	public void setSchooltimes(Set<Schooltime> schooltimes) {
		this.schooltimes = schooltimes;
	}

	@OneToMany(mappedBy="user", targetEntity=Notice.class)
	public Set<Notice> getNotices() {
		return notices;
	}

	public void setNotices(Set<Notice> notices) {
		this.notices = notices;
	}
	
	@OneToMany(mappedBy="user",targetEntity=Comments.class)
	public Set<Comments> getComments() {
		return comments;
	}

	public void setComments(Set<Comments> comments) {
		this.comments = comments;
	}

	@OneToMany(mappedBy="user",targetEntity=Backtous.class)
	public Set<Backtous> getBacktous() {
		return backtous;
	}

	public void setBacktous(Set<Backtous> backtous) {
		this.backtous = backtous;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phoneNum=" + phoneNum + ", images=" + images + ", classs="
				+ classs + ", status=" + status + ", studentId=" + studentId + ", school=" + school + ", wxName="
				+ wxName + ", schooltimes=" + schooltimes + ", notices=" + notices + ", comments=" + comments
				+ ", backtous=" + backtous + "]";
	}


	
	
	
}
