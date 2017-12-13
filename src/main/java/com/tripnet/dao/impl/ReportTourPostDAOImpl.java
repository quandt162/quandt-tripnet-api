package com.tripnet.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.IReportTourPostDAO;
import com.tripnet.enties.ReportTourPost;

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
	public void add(ReportTourPost object) {
		if(null != object) {
			entityManager.persist(object);
		}
	}
	
	@Override
	public void update(ReportTourPost object) {
		if(null != object) {
			ReportTourPost r = getOneById(object.getId());
			r.setDeleted(object.getDeleted());
			r.setDescription(object.getDescription());
			r.setReasonReport(object.getReasonReport());
			r.setUpdateTime(object.getUpdateTime());
			
			entityManager.flush();
		}
		
	}

	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<ReportTourPost> getAllReportByAccountID(int reportedBy) {
		String hql = "FROM ReportTourPost as rp WHERE rp.deleted = ? AND rp.reportedBy = ?";
		return entityManager.createQuery(hql).setParameter(1, 0).setParameter(2, reportedBy).getResultList();
	}

	@Override
	public List<ReportTourPost> getAllReportOfPost(int postID) {
		String hql = "FROM ReportTourPost as rp WHERE rp.deleted = ? AND rp.tourPostID = ?";
		return entityManager.createQuery(hql).setParameter(1, 0).setParameter(2, postID).getResultList();
	}

	@Override
	public int getNumberReportOfPost(int postID) {
		String hql = "FROM ReportTourPost as rp WHERE rp.deleted = ? AND rp.tourPostID = ?";
		return entityManager.createQuery(hql).setParameter(1, 0).setParameter(2, postID).getResultList().size();
	}
	
}
