package com.tripnet.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tripnet.dao.ICommentDAO;
import com.tripnet.dao.ICommonDAO;
import com.tripnet.enties.Comment;
import com.tripnet.enties.Marking;

@Transactional
@Repository
public class CommentDAOImpl implements ICommonDAO<Comment>, ICommentDAO<Comment>{
	
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
			Comment c = getOneById(object.getId());
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

	@Override
	public List<Comment> getAllCommentByTour(int tourPostID) {
		String hql = "FROM Comment AS c WHERE c.deleted = ? AND c.tourPostID = ?";
		return entityManager.createQuery(hql).setParameter(1, 0).setParameter(2, tourPostID).getResultList();
	}

	@Override
	public int getNumberCommentOfPost(int postID) {
		String hql = "FROM Comment as c WHERE c.deleted = ? AND c.tourPostID = ?";
		return entityManager.createQuery(hql).setParameter(1, 0).setParameter(2, postID).getResultList().size();
	}

}
