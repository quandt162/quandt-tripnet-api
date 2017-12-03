package com.tripnet.enties;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * *Author: QuanDT
 */
@Entity
@Table(name = "tour_posts")
public class TourPost implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int id;
	@Column(name = "Account_ID")
	private int accountID;
	@Column(name = "Start_Place_ID")
	private int startPlaceID;
	@Column(name = "End_Place_ID")
	private int endPlaceID;
	@Column(name = "Duration")
	private int duration;
	@Column(name = "Description")
	private String description;
	@Column(name = "Note")
	private String note;
	@Column(name = "Prepare")
	private String prepare;
	@Column(name = "Tour_Article_Title")
	private String tourArticleTitle;
	@Column(name = "Post_View_Number")
	private String postViewNumber;
	@Column(name = "Deleted")
	private int deleted;
	@Column(name = "Created_Time")
	private String createTime;
	@Column(name = "Updated_Time")
	private String updateTime;
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getPrepare() {
		return prepare;
	}
	public void setPrepare(String prepare) {
		this.prepare = prepare;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public int getStartPlaceID() {
		return startPlaceID;
	}
	public void setStartPlaceID(int startPlaceID) {
		this.startPlaceID = startPlaceID;
	}
	public int getEndPlaceID() {
		return endPlaceID;
	}
	public void setEndPlaceID(int endPlaceID) {
		this.endPlaceID = endPlaceID;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTourArticleTitle() {
		return tourArticleTitle;
	}
	public void setTourArticleTitle(String tourArticleTitle) {
		this.tourArticleTitle = tourArticleTitle;
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
	public String getPostViewNumber() {
		return postViewNumber;
	}
	public void setPostViewNumber(String postViewNumber) {
		this.postViewNumber = postViewNumber;
	}
}