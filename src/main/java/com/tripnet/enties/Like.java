package com.tripnet.enties;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "likes")
public class Like implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int Id;
	@Column(name = "Tour_Post_ID")
	private int tourPostID;
	@Column(name = "Like_By_ID")
	private int likeByID;
	@Column(name = "Deleted")
	private int deleted;
	@Column(name = "Created_Time")
	private String createTime;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getTourPostID() {
		return tourPostID;
	}
	public void setTourPostID(int tourPostID) {
		this.tourPostID = tourPostID;
	}
	public int getLikeByID() {
		return likeByID;
	}
	public void setLikeByID(int likeByID) {
		this.likeByID = likeByID;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
