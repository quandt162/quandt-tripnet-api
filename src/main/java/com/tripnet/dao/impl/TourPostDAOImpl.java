package com.tripnet.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.ITourPostDAO;
import com.tripnet.enties.Place;
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
			
			tp.setStartPlace(new Place(object.getStartPlaceID()));
			tp.setEndPlace(new Place(object.getStartPlaceID()));
			
			tp.setTourArticleTitle(object.getTourArticleTitle());
			tp.setUpdateTime(object.getUpdateTime());
			tp.setPostViewNumber(object.getPostViewNumber());
			tp.setCategory(object.getCategory());
			
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
	public TourPost getTourPostByAccountId(int accountID) {
		String hql = "FROM TourPost as tp WHERE tp.deleted = ? AND tp.accountID = ?";
		@SuppressWarnings("rawtypes")
		List list = entityManager.createQuery(hql).setParameter(1, 0).setParameter(2, accountID).getResultList();
		if(list.isEmpty()) {
			return null;
		}
		return (TourPost)list.get(0);
	}
	
	
	//Search by Account name
	@Override
	public List<TourPost> getAllTourPostByAccountName(String userName) {
		String hql = "select tp from TourPost tp join  tp.account ta where  ta.name like :userName";
		List list = entityManager.createQuery(hql).setParameter("userName", "%" + userName + "%").getResultList();
		if(list.isEmpty()) {
			return null;
		}
		return list;
	}

	//Search by Duration
	@SuppressWarnings("unchecked")
	@Override
	public List<TourPost> getAllTourPostByDuration(int duration) {
		String hql = "FROM TourPost tp WHERE tp.deleted = ? AND tp.duration = ?";
		return entityManager.createQuery(hql).setParameter(1, 0).setParameter(2, duration).getResultList();
	}

	//Search by Place
	@SuppressWarnings("unchecked")
	@Override
	public List<TourPost> getAllTourPostByPlace(String place1, String place2) {
		
		
		String hql = "Select tp from TourPost tp join tp.startPlace sp join tp.endPlace ep"
										+ " where tp.deleted  = :deleted and (sp.name like :place1 or ep.name like :place2)";
		
		
		//http://localhost:8080/tours/post/place/?place1=H&place2=h
		List list = entityManager.createQuery(hql).setParameter("place1","%" + place1 + "%").
				setParameter("place2","%" + place2 + "%").setParameter("deleted",0).getResultList();
		if(list.isEmpty()) {
			return null;
		}
		return list;
	}

	//Search by title
	@Override
	public List<TourPost> getAllTourPostByTitle(String title) {
		String hql = "FROM TourPost tp WHERE tp.deleted = ? AND tp.tourArticleTitle like ?";
		@SuppressWarnings("unchecked")
		List<TourPost> list = entityManager.createQuery(hql).setParameter(1, 0).setParameter(2,"%" + title +"%").getResultList();
		return list;
	}

	//Search by category
	@Override
	public List<TourPost> getAllTourPostByCategory(String name) {
		String hql = "Select tp from TourPost tp join tp.category  ct where ct.name like :name";
		List list = entityManager.createQuery(hql).setParameter("name","%" + name + "%").getResultList();
		if(list.isEmpty()) {
			return null;
		}
		return list;
	}
}
