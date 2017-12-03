package com.tripnet.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.ITourByDayDAO;
import com.tripnet.enties.TourByDay;
/*
 * *Author: QuanDT
 */
@Transactional
@Repository
public class TourByDayDAOImpl implements ICommonDAO<TourByDay>, ITourByDayDAO<TourByDay> {
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public TourByDay getOneById(int objectId) {
		return entityManager.find(TourByDay.class, objectId);
	}

	@Override
	public List<TourByDay> getAll() {
		String hql = "FROM TourByDay AS tbd WHERE tbd.deleted = ?";
		return entityManager.createQuery(hql).setParameter(1,0).getResultList();
	}

	@Override
	public void add(TourByDay object) {
		if(null != object) {
			entityManager.persist(object);
		}
	}

	@Override
	public void update(TourByDay object) {
		if(null != object) {
			TourByDay tbd = getOneById(object.getId());
			tbd.setDay(object.getDay());
			tbd.setDescription(object.getDescription());
			tbd.setTourPostID(object.getTourPostID());
			tbd.setDeleted(object.getDeleted());
			tbd.setCreateTime(object.getCreateTime());
			tbd.setUpdateTime(object.getUpdateTime());
			tbd.setFood(object.getFood());
			tbd.setHotel(object.getHotel());
			tbd.setNote(object.getNote());
			entityManager.flush();
		}
	}

	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TourByDay getTourByDayByTourPost(int toutPostID, int day) {
		String hql = "FROM TourByDay AS tbd WHERE tbd.deleted = ? AND tbd.tourPostID = ? AND tbd.day = ?";
		List results = entityManager.createQuery(hql).setParameter(1,0).setParameter(2,toutPostID).setParameter(3,day).getResultList();
		
		if (results.isEmpty()) { 
			return null;
		}
			
		return  (TourByDay) results.get(0);

	}
	
	@Override
	public List<TourByDay> getAllTourByDayByTourPost(int tourPostID) {
		String hql = "FROM TourByDay AS tbd WHERE tbd.deleted = ? AND tbd.tourPostID = ?";
		return entityManager.createQuery(hql).setParameter(1,0).setParameter(2,tourPostID).getResultList();
	}

}
