
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
    * @ClassName: Activity  
    * @Description: TODO  
    * @author xueyunqing  
    * @date 2018年12月3日  
    *
 */
@Entity
@Table(name="tbl_activity")
public class Activity {
	private int id;
	private String aTime;
	private String aBody;
	private Classes classs;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getaTime() {
		return aTime;
	}

	public void setaTime(String aTime) {
		this.aTime = aTime;
	}

	public String getaBody() {
		return aBody;
	}

	public void setaBody(String aBody) {
		this.aBody = aBody;
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