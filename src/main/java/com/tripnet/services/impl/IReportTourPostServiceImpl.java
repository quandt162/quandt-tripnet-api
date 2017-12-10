package com.tripnet.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.IReportTourPostDAO;
import com.tripnet.enties.ReportTourPost;
import com.tripnet.services.ICommonService;
import com.tripnet.services.IReportTourPostService;

/*
 * *Author: QuanDT
 */
@Service
public class IReportTourPostServiceImpl implements ICommonService<ReportTourPost>, IReportTourPostService<ReportTourPost>{
	@Autowired 
	private ICommonDAO<ReportTourPost> commonDAO;
	@Autowired 
	private IReportTourPostDAO<ReportTourPost> reportDAO;
	
	@Override
	public ReportTourPost getOneById(int objectId) {
		return commonDAO.getOneById(objectId);
	}
	@Override
	public List<ReportTourPost> getAll() {
		return commonDAO.getAll();
	}
	@Override
	public boolean add(ReportTourPost object) {
		if(object != null) {
			commonDAO.add(object);
			return true;
		}
		return false;
	}
	@Override
	public void update(ReportTourPost object) {
		if(object != null)commonDAO.update(object);
	}
	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<ReportTourPost> getAllReportByAccountID(int reportedBy) {
		return reportDAO.getAllReportByAccountID(reportedBy);
	}
	
	@Override
	public List<ReportTourPost> getAllReportOfPost(int postID) {
		return reportDAO.getAllReportOfPost(postID);
	}
	@Override
	public int getNumberReportOfPost(int postID) {
		return reportDAO.getNumberReportOfPost(postID);
	}
}
