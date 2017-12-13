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
	private int postViewNumber;
	@Column(name = "Deleted")
	private int deleted;
	@Column(name = "Created_Time")
	private String createTime;
	@Column(name = "Updated_Time")
	private String updateTime;
	@Column(name = "Reference_Link ")
	private String referenceLink;
	@Column(name = "Type")
	private int type;
	@Column(name = "Start_Time")
	private String startTime;
	@Column(name = "Category")
	private int category;
	
	public String getReferenceLink() {
		return referenceLink;
	}
	public void setReferenceLink(String referenceLink) {
		this.referenceLink = referenceLink;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
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
	public int getPostViewNumber() {
		return postViewNumber;
	}
	public void setPostViewNumber(int postViewNumber) {
		this.postViewNumber = postViewNumber;
	}
}