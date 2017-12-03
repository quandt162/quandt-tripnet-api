package com.tripnet.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.IMarking;
import com.tripnet.dao.ITourPostDAO;
import com.tripnet.enties.Like;
import com.tripnet.enties.Marking;
import com.tripnet.enties.TourPost;
/*
 * *Author: QuanDT
 */
@Transactional
@Repository
public class MarkingDAOImpl implements ICommonDAO<Marking>, IMarking<Marking> {
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Marking getOneById(int objectId) {
		return  entityManager.find(Marking.class, objectId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Marking> getAll() {
		String hql = "FROM Marking AS mk WHERE mk.deleted = ?";
		return entityManager.createQuery(hql).setParameter(1, 0).getResultList();
	}

	@Override
	public void add(Marking object) {
		if(null != object) {
			entityManager.persist(object);
		}
	}

	@Override
	public void update(Marking object) {
		if(null != object) {
			Marking mk = getOneById(object.getTourPostID(), object.getAccountID());
			mk.setCreateTime(object.getCreateTime());
			mk.setDeleted(object.getDeleted());
			entityManager.flush();
		}
	}

	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Marking getOneById(int accountId, int mId) {
		String hql = "FROM Marking AS l WHERE l.deleted = ? AND l.tourPostID = ? AND  l.accountID = ?";
		List<Marking> result = entityManager.createQuery(hql).setParameter(1,0 ).setParameter(2,accountId ).setParameter(3,mId ).getResultList();
		if(result.isEmpty()) {
			return null;
		}
		return (Marking)result.get(0);
	}

	@Override
	public List<Marking> getAllMarking(int accountId) {
		String hql = "FROM Marking AS l WHERE l.deleted = ? AND l.tourPostID = ?";
		return entityManager.createQuery(hql).setParameter(1, 0).setParameter(2,accountId ).getResultList();
	}
	
	
}
