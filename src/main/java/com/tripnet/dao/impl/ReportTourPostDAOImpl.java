package com.tripnet.dao.impl;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.IReportTourPostDAO;
import com.tripnet.enties.ReportTourPost;
import com.tripnet.enties.TourByDay;

/*
 * *Author: QuanDT
 */
@Transactional
@Repository
public class ReportTourPostDAOImpl implements ICommonDAO<ReportTourPost>, IReportTourPostDAO<ReportTourPost>{
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public ReportTourPost getOneById(int objectId) {
		return entityManager.find(ReportTourPost.class, objectId);
	}

	@Override
	public List<ReportTourPost> getAll() {
		String hql = "FROM ReportTourPost AS tbd WHERE tbd.deleted = ?";
		return entityManager.createQuery(hql).setParameter(1,0).getResultList();
	}

	@Override
	public void update(ReportTourPost object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(ReportTourPost object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ReportTourPost getReportTourPost() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void add(List<ReportTourPost> list) {
		if(null != list) {
			for (ReportTourPost reportTourPost : list) {
				entityManager.persist(reportTourPost);
			}
			
		}
	}
	
}
