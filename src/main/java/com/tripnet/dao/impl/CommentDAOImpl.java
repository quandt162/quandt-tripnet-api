package com.tripnet.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tripnet.dao.IComment;
import com.tripnet.dao.ICommonDAO;
import com.tripnet.enties.Comment;
import com.tripnet.enties.TourPost;


@Transactional
@Repository
public class CommentDAOImpl implements ICommonDAO<Comment>{
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Comment getOneById(int objectId) {
		return  entityManager.find(Comment.class, objectId);
	}

	@Override
	public List<Comment> getAll() {
		String hql = "FROM Comment AS c WHERE c.deleted = ?";
		return entityManager.createQuery(hql).setParameter(1, 0).getResultList();
	}

	@Override
	public void add(Comment object) {
		entityManager.persist(object);
	}

	@Override
	public void update(Comment object) {
		if(object != null) {
			Comment c = new Comment();
			c.setContent(object.getContent());
			c.setCreateTime(object.getCreateTime());
			c.setDeleted(object.getDeleted());
			entityManager.flush();
		}
	}

	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}

}