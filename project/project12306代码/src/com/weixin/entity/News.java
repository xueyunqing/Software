package com.weixin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
    * @ClassName: News  
    * @Description: TODO  
    * @author xueyunqing  
    * @date 2018年12月3日 
    *
 */
@Entity
@Table(name="tbl_news")
public class News {
	private int id;
	private String nTitle;
	private String nTime;
	private String nImage;
	private String nBody;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnTime() {
		return nTime;
	}

	public void setnTime(String nTime) {
		this.nTime = nTime;
	}

	public String getnImage() {
		return nImage;
	}

	public void setnImage(String nImage) {
		this.nImage = nImage;
	}

	public String getnBody() {
		return nBody;
	}

	public void setnBody(String nBody) {
		this.nBody = nBody;
	}

}
