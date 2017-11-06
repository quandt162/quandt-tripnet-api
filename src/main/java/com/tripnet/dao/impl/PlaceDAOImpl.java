package com.tripnet.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.IPlaceDAO;
import com.tripnet.enties.Place;

@Repository
@Transactional
public class PlaceDAOImpl implements ICommonDAO<Place>, IPlaceDAO<Place>{
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Place getOneById(int objectId) {
		return  entityManager.find(Place.class, objectId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Place> getAll() {
		String hql = "FROM Place as p WHERE p.deleted = ?";
		return entityManager.createQuery(hql).setParameter(1, 0).getResultList();
	}

	@Override
	public void add(Place object) {
		entityManager.persist(object);
	}

	@Override
	public void update(Place object) {
		Place p = new Place();
		p.setCreated_Time(object.getCreated_Time());
		p.setDeleted(object.getDeleted());
		p.setDescription(object.getDescription());
		p.setName(object.getName());
		p.setRegion(object.getRegion());
		p.setType(object.getType());
		
		entityManager.flush();
	}

	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isExit(String name, String region) {
		String hql = "FROM Place AS p WHERE p.name = ? and p.region = ?";
		int count = entityManager.createQuery(hql).setParameter(1, name).setParameter(2, region).getResultList().size();
		return count > 0 ? true : false;
		
	}
	
}
