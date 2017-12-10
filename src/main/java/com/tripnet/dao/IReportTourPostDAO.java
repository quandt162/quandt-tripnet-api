package com.tripnet.dao;

import java.util.List;

import com.tripnet.enties.ReportTourPost;

public interface IReportTourPostDAO<ReportTourPost> {
	
	List<ReportTourPost> getAllReportByAccountID(int reportedBy);
	
	List<ReportTourPost> getAllReportOfPost(int postID);
	
	int getNumberReportOfPost(int postID);
}
