package com.tripnet.services;

import java.util.List;

public interface IReportTourPostService<ReportTourPost> {
	List<ReportTourPost> getAllReportByAccountID(int reportedBy);
	
	List<ReportTourPost> getAllReportOfPost(int postID);
	
	int getNumberReportOfPost(int postID);
}
