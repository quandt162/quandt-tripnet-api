package com.tripnet.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.ITourPostDAO;
import com.tripnet.enties.TourPost;
/*
 * *Author: QuanDT
 */
@Transactional
@Repository
public class TourPostDAOImpl implements ICommonDAO<TourPost>, ITourPostDAO<TourPost>  {
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public TourPost getOneById(int objectId) {
		return  entityManager.find(TourPost.class, objectId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TourPost> getAll() {
		String hql = "FROM TourPost AS tp WHERE tp.deleted = ?";
		return entityManager.createQuery(hql).setParameter(1, 0).getResultList();
	}

	@Override
	public void add(TourPost object) {
		if(null != object) {
			entityManager.persist(object);
		}
	}

	@Override
	public void update(TourPost object) {
		if(null != object) {
			TourPost tp = getOneById(object.getId());
			if(object.getDeleted() != 0 || object.getDeleted() != 1 ) {
				tp.setDeleted(object.getDeleted());
			}
			
			tp.setDescription(object.getDescription());
			tp.setDuration(object.getDuration());
			tp.setStartPlaceID(object.getStartPlaceID());
			tp.setEndPlaceID(object.getEndPlaceID());
			tp.setTourArticleTitle(object.getTourArticleTitle());
			tp.setUpdateTime(object.getUpdateTime());
			tp.setPostViewNumber(object.getPostViewNumber());
			tp.setNote(object.getNote());
			tp.setPrepare(object.getPrepare());
			tp.setType(object.getType());
			entityManager.flush();	
		}
	}

	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isExits(String title) {
		String hql = "FROM TourPost as tp WHERE tp.tourArticleTitle = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title).getResultList().size();
		return count > 0 ? true : false;
	}

	@Override
	public List<TourPost> getAllTourPostByAccountId(int accountID) {
		String hql = "FROM TourPost as tp WHERE tp.deleted = ? AND tp.accountID = ?";
		return entityManager.createQuery(hql).setParameter(1, 0).setParameter(2, accountID).getResultList();
	}


	@Override
	public List<TourPost> getAllTourPostByAccountName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TourPost> getAllTourPostByDuration(int duration) {
		String hql = "FROM TourPost as tp WHERE tp.deleted = ? AND tp.duration = ?";
		return entityManager.createQuery(hql).setParameter(1, 0).setParameter(2, duration).getResultList();
	}

	@Override
	public List<TourPost> getAllTourPostByPlace(String place1, String place2) {
		String hql = "FROM TourPost as tp WHERE tp.deleted = ? AND tp.place1 = ? OR  tp.place2 = ?";
		return entityManager.createQuery(hql).setParameter(1, 0).setParameter(2, place1).setParameter(3, place2).getResultList();
	}

	@Override
	public TourPost getAllTourPostByTitle(String title) {
		String hql = "FROM TourPost as tp WHERE tp.deleted = ? AND tp.tourArticleTitle =?";
		List<TourPost> list = entityManager.createQuery(hql).setParameter(1, 0).setParameter(2, title).getResultList();
		
		if(list.isEmpty()) {
			return null;
		}
		return (TourPost)list.get(0);
				
	}
}
