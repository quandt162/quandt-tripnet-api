package com.tripnet.dao;

import java.util.List;

import com.tripnet.enties.ReportTourPost;

public interface IReportTourPostDAO<ReportTourPost> {
	
	public ReportTourPost getReportTourPost();
	
	public void add(List<ReportTourPost> list);
}
