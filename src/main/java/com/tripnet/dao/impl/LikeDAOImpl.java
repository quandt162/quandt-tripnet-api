package com.tripnet.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.ILikeDAO;
import com.tripnet.enties.Comment;
import com.tripnet.enties.Like;

@Transactional
@Repository
public class LikeDAOImpl implements ICommonDAO<Like>, ILikeDAO<Like>{
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Like getOneById(int objectId) {
		return  entityManager.find(Like.class, objectId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Like> getAll() {
		String hql = "FROM Like AS l WHERE l.deleted = ?";
		return entityManager.createQuery(hql).setParameter(1, 0).getResultList();
	}

	@Override
	public void add(Like object) {
		entityManager.persist(object);
	}

	@Override
	public void update(Like object) {
		if(null != object) {
			Like l = getLike(object.getTourPostID(), object.getLikeByID());
			l.setDeleted(object.getDeleted());
			entityManager.flush();
		}
	}

	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Like> getAllLikeByTourPostID(int tourPostID) {
		String hql = "FROM Like AS l WHERE l.deleted = ? AND l.tourPostID = ?";
		return entityManager.createQuery(hql).setParameter(1, 0).setParameter(2,tourPostID ).getResultList();
	}

	@Override
	public Like getLike(int tourID, int accountID) {
		String hql = "FROM Like AS l WHERE l.tourPostID = ? AND  l.likeByID = ?";
		List<Like> result = entityManager.createQuery(hql).setParameter(1,tourID ).setParameter(2,accountID ).getResultList();
		if(result.isEmpty()) {
			return null;
		}
		return (Like)result.get(0);
	}

}
