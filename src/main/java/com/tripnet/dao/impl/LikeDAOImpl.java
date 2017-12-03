package com.tripnet.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.ILikeDAO;
import com.tripnet.enties.Comment;
import com.tripnet.enties.Likes;

@Transactional
@Repository
public class LikeDAOImpl implements ICommonDAO<Likes>, ILikeDAO<Likes>{
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Likes getOneById(int objectId) {
		return  entityManager.find(Likes.class, objectId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Likes> getAll() {
		String hql = "FROM Likes AS l WHERE l.deleted = ?";
		return entityManager.createQuery(hql).setParameter(1, 0).getResultList();
	}

	@Override
	public void add(Likes object) {
		entityManager.persist(object);
	}

	@Override
	public void update(Likes object) {
		if(null != object) {
			Likes l = getOneById(object.getId());
			l.setDeleted(object.getDeleted());
			l.setCreateTime(object.getCreateTime());
			entityManager.flush();
		}
	}

	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Likes> getAllLikeByTourPostID(int tourPostID) {
		String hql = "FROM Likes AS l WHERE l.deleted = ? AND l.tourPostID = ?";
		return entityManager.createQuery(hql).setParameter(1, 0).setParameter(2,tourPostID ).getResultList();
	}

}
