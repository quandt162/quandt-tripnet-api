package com.tripnet.enties;

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
@Table(name = "report_tour_post")
public class ReportTourPost {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int id;
	@Column(name = "Tour_Post_ID")
	private int tourPostID;
	@Column(name = "Reported_By")
	private int reportedBy;
	@Column(name = "Description")
	private String description;
	@Column(name = "Deleted")
	private int deleted;
	@Column(name = "Created_Time")
	private String createTime;
	@Column(name = "Updated_Time")
	private String updateTime;
	@Column(name = "Reason_Report")
	private String reasonReport;
	public String getReasonReport() {
		return reasonReport;
	}
	public void setReasonReport(String reasonReport) {
		this.reasonReport = reasonReport;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTourPostID() {
		return tourPostID;
	}
	public void setTourPostID(int tourPostID) {
		this.tourPostID = tourPostID;
	}
	public int getReportedBy() {
		return reportedBy;
	}
	public void setReportedBy(int reportedBy) {
		this.reportedBy = reportedBy;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
