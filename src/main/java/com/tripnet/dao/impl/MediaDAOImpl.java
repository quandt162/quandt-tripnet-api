package com.tripnet.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.IMediaDAO;
import com.tripnet.dao.ITourPostDAO;
import com.tripnet.enties.Like;
import com.tripnet.enties.Media;
import com.tripnet.enties.TourPost;
/*
 * *Author: QuanDT
 */
@Transactional
@Repository
public class MediaDAOImpl implements ICommonDAO<Media>, IMediaDAO<Media> {
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Media getOneById(int objectId) {
		return  entityManager.find(Media.class, objectId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Media> getAll() {
		String hql = "FROM Media AS m WHERE m.deleted = ?";
		return entityManager.createQuery(hql).setParameter(1, 0).getResultList();
	}

	@Override
	public void add(Media object) {
		entityManager.persist(object);
	}

	@Override
	public void update(Media object) {
		Media m = getOneById(object.getId());
		m.setName(object.getName());
		m.setDeleted(object.getDeleted());
		m.setUpdatedTime(object.getUpdatedTime());
		entityManager.flush();
	}

	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Media> getAllMediaByAccount(int accountID) {
		String hql = "FROM Media AS m WHERE m.accountID = ?";
		return entityManager.createQuery(hql).setParameter(1, accountID).getResultList();
	}
	
	@Override
	public List<Media> getAllMediaByTourByDayID(int tourByDayID) {
		String hql = "FROM Media AS m WHERE m.tourByDayID = ?";
		return entityManager.createQuery(hql).setParameter(1, tourByDayID).getResultList();
	}
	
	@Override
	public List<Media> getAllMediaByTourPostID(int tourByDayID) {
		String hql = "FROM Media AS m WHERE m.tourPostID = ?";
		return entityManager.createQuery(hql).setParameter(1, tourByDayID).getResultList();
	}
}
