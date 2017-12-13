package com.tripnet.dao;

import java.util.List;

import com.tripnet.enties.Comment;

public interface ICommentDAO<Comment> {
	public List <Comment> getAllCommentByTour(int tourPostID);
}
