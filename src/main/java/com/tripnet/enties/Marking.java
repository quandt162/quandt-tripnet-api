package com.tripnet.enties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Author QuanDT
 * 
 * */

@Entity
@Table(name = "Marking")
public class Marking {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int Id;
	@Column(name = "Tour_Post_ID")
	private int tourPostID;
	@Column(name = "Marking_By_ID")
	private int makingByID;
	@Column(name = "Deleted")
	private int deleted;
	@Column(name = "Created_Time")
	private String createTime;
	@Column(name = "Update_Time")
	private String updateTime;
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
	public int getMarkingByID() {
		return makingByID;
	}
	public void setMarkingByID(int makingByID) {
		this.makingByID = makingByID;
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
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
}
