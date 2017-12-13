package com.tripnet.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.IMarkingDAO;
import com.tripnet.enties.Marking;

@Transactional
@Repository
public class MarkingDAOImpl implements ICommonDAO<Marking>, IMarkingDAO<Marking> {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Marking getOneById(int objectId) {
		return  entityManager.find(Marking.class, objectId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Marking> getAll() {
		String hql = "FROM Marking AS m WHERE m.deleted = ?";
		return entityManager.createQuery(hql).setParameter(1, 0).getResultList();
	}

	@Override
	public void add(Marking object) {
		entityManager.persist(object);
	}

	@Override
	public void update(Marking object) {
		Marking m = getOneById(object.getId());
		m.setDeleted(object.getDeleted());
		m.setUpdateTime(object.getUpdateTime());
		entityManager.flush();
	}

	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Marking> getAllMarkingByAccount(int accountID) {
		String hql = "FROM Marking AS m WHERE m.deleted = ? AND m.makingByID = ?";
		return entityManager.createQuery(hql).setParameter(1, 0).setParameter(2, accountID).getResultList();
	}

}
