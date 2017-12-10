package com.tripnet.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.IJoinGroupDAO;
import com.tripnet.enties.Comment;
import com.tripnet.enties.JoinGroup;

@Transactional
@Repository
public class JoinGroupDAOImpl implements ICommonDAO<JoinGroup>, IJoinGroupDAO<JoinGroup>{
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public JoinGroup getOneById(int objectId) {
		return  entityManager.find(JoinGroup.class, objectId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JoinGroup> getAll() {
		String hql = "FROM JoinGroup AS l";
		return entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void add(JoinGroup object) {
		entityManager.persist(object);
	}

	@Override
	public void update(JoinGroup object) {
		if(null != object) {
			JoinGroup l = getJoinGroup(object.getTourPostID(), object.getJoinGroupByID());
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
	public List<JoinGroup> getAllJoinGroupByTourPostID(int tourPostID) {
		String hql = "FROM JoinGroup AS l WHERE l.tourPostID = ?";
		return entityManager.createQuery(hql).setParameter(1, tourPostID).getResultList();
	}

	@Override
	public JoinGroup getJoinGroup(int tourID, int accountID) {
		String hql = "FROM JoinGroup AS l WHERE l.tourPostID = ? AND  l.JoinGroupByID = ?";
		List<JoinGroup> result = entityManager.createQuery(hql).setParameter(1,tourID ).setParameter(2,accountID ).getResultList();
		if(result.isEmpty()) {
			return null;
		}
		return (JoinGroup)result.get(0);
	}

}
