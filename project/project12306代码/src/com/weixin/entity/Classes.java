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

/**
 * 
 * @ClassName: Classes
 * @Description: TODO
 * @author xueyunqing
 * @date 2018年12月3日
 *
 */
@Entity
@Table(name = "tbl_classes")
public class Classes {
	private int classId;
	private int grade;
	private int classInt;
	private Schools school;
	private Set<Activity> activities = new HashSet<>();
	private Set<Check> checks = new HashSet<>();
	private Set<Homework> homeworks = new HashSet<>();
	private Set<Onduty> onduties = new HashSet<>();
	private Set<User> users = new HashSet<>();
	private Set<Time> times = new HashSet<>();
	private Set<Schooltime> schooltimes = new HashSet<>();
	private Set<Notice> notices = new HashSet<>();
	private Set<Comments> comments = new HashSet<>();
	private Set<Students> students = new HashSet<>();


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassInt() {
		return classInt;
	}

	public void setClassInt(int classInt) {
		this.classInt = classInt;
	}

	@ManyToOne
	@JoinColumn(name = "schoolId")
	public Schools getSchool() {
		return school;
	}

	public void setSchool(Schools school) {
		this.school = school;
	}

	@OneToMany(mappedBy = "classs", targetEntity = Activity.class)
	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

	@OneToMany(mappedBy = "classs", targetEntity = Check.class)
	public Set<Check> getChecks() {
		return checks;
	}

	public void setChecks(Set<Check> checks) {
		this.checks = checks;
	}

	@OneToMany(mappedBy = "classs", targetEntity = Homework.class)
	public Set<Homework> getHomeworks() {
		return homeworks;
	}

	public void setHomeworks(Set<Homework> homeworks) {
		this.homeworks = homeworks;
	}

	@OneToMany(mappedBy = "classs", targetEntity = Onduty.class)
	public Set<Onduty> getOnduties() {
		return onduties;
	}

	public void setOnduties(Set<Onduty> onduties) {
		this.onduties = onduties;
	}

	@OneToMany(mappedBy = "classs", targetEntity = User.class)
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(mappedBy = "classs", targetEntity = Time.class)
	public Set<Time> getTimes() {
		return times;
	}

	public void setTimes(Set<Time> times) {
		this.times = times;
	}

	@OneToMany(mappedBy = "classs", targetEntity = Schooltime.class)
	public Set<Schooltime> getSchooltimes() {
		return schooltimes;
	}

	public void setSchooltimes(Set<Schooltime> schooltimes) {
		this.schooltimes = schooltimes;
	}

	@OneToMany(mappedBy = "user", targetEntity = Notice.class)
	public Set<Notice> getNotices() {
		return notices;
	}

	public void setNotices(Set<Notice> notices) {
		this.notices = notices;
	}

	@OneToMany(mappedBy="classs",targetEntity=Comments.class)
	public Set<Comments> getComments() {
		return comments;
	}

	public void setComments(Set<Comments> comments) {
		this.comments = comments;
	}

	@OneToMany(mappedBy="classs", targetEntity=Students.class)
	public Set<Students> getStudents() {
		return students;
	}

	public void setStudents(Set<Students> students) {
		this.students = students;
	}

	
}