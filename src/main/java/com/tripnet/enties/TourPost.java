package com.tripnet.enties;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
/*
 * *Author: QuanDT
 */
@Entity
@Table(name = "tourpost")
public class TourPost implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Account.class)
	@JoinColumn(name = "Acount_ID")
	@JsonBackReference
	private Account account;
	
	@Transient
	private int accountID;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Place.class)
	@JoinColumn(name = "Start_Place_ID")
	@JsonBackReference
	private Place startPlace;
	
	@Transient
	private int startPlaceID;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Place.class)
	@JoinColumn(name = "End_Place_ID")
	@JsonBackReference
	private Place endPlace;
	
	@Transient
	private int endPlaceID;
	
	//them tim kiem bang category
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Category.class)
	@JoinColumn(name = "Category_ID")
	@JsonBackReference
	private Category category;
	
	@Transient
	private int categoryID;
	
	//tim kiem bang place
//	@Column(name = "Start_Place_ID")
//	private int startPlaceID;
	
	
	
	@Column(name = "Duration")
	private int duration;
	
	@Column(name = "Description")
	private String description;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public Place getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(Place startPlace) {
		this.startPlace = startPlace;
	}

	public int getStartPlaceID() {
		return startPlaceID;
	}

	public void setStartPlaceID(int startPlaceID) {
		this.startPlaceID = startPlaceID;
	}

	public Place getEndPlace() {
		return endPlace;
	}

	public void setEndPlace(Place endPlace) {
		this.endPlace = endPlace;
	}

	public int getEndPlaceID() {
		return endPlaceID;
	}

	public void setEndPlaceID(int endPlaceID) {
		this.endPlaceID = endPlaceID;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
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

	public String getPostViewNumber() {
		return postViewNumber;
	}

	public void setPostViewNumber(String postViewNumber) {
		this.postViewNumber = postViewNumber;
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