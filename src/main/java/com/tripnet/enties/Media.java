package com.tripnet.enties;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "media")
public class Media {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int Id;
	@Column(name = "Name")
	private String name;
	@Column(name = "media_URL")
	private String mediaURL;
	@Column(name = "Deleted")
	private int deleted;
	@Column(name = "Created_Time")
	private String createdTime;
	@Column(name = "Updated_Time")
	private String updatedTime;
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
	@Column(name = "Size")
	private Double size;
	@Column(name = "Type")
	private int type;
	@Column(name = "Description")
	private String description;
	@Column(name = "Format")
	private String format;
	@Column(name = "Tour_Post_ID")
	private int tourPostID;
	@Column(name = "Account_ID")
	private int accountID;

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMediaURL() {
		return mediaURL;
	}
	public void setMediaURL(String mediaURL) {
		this.mediaURL = mediaURL;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public String getCreateTime() {
		return createdTime;
	}
	public void setCreateTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public Double getSize() {
		return size;
	}
	public void setSize(Double size) {
		this.size = size;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public int getTourPostID() {
		return tourPostID;
	}
	public void setTourPostID(int tourPostID) {
		this.tourPostID = tourPostID;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public int getTourByDayID() {
		return tourByDayID;
	}
	public void setTourByDayID(int tourByDayID) {
		this.tourByDayID = tourByDayID;
	}
	@Column(name = "Tour_By_Day_ID")
	private int tourByDayID;
}
