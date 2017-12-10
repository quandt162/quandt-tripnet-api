package com.tripnet.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripnet.dao.ICommentDAO;
import com.tripnet.dao.ICommonDAO;
import com.tripnet.enties.Comment;
import com.tripnet.services.ICommentService;
import com.tripnet.services.ICommonService;

/*
 * *Author: QuanDT
 */
@Service
public class CommentServiceImpl implements ICommonService<Comment>, ICommentService<Comment> {
	@Autowired 
	private ICommonDAO<Comment> commonDAO;
	@Autowired 
	private ICommentDAO<Comment> commentDAO;
	@Override
	public Comment getOneById(int objectId) {
		return commonDAO.getOneById(objectId);
	}

	@Override
	public List<Comment> getAll() {
		return commonDAO.getAll();
	}

	
	@Override
	public boolean add(Comment object) {
		commonDAO.add(object);
		return true;
	}

	@Override
	public void update(Comment object) {
		if(object != null) {
			commonDAO.update(object);
		}
	}

	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comment> getAllCommentByTourPostID(int tourPostID) {
		return commentDAO.getAllCommentByTour(tourPostID);
	}

	@Override
	public int getNumberCommentOfPost(int postID) {
		return commentDAO.getNumberCommentOfPost(postID);
	}

}
