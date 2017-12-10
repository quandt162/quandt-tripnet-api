package com.tripnet.services;

import java.util.List;

import com.tripnet.enties.Comment;

public interface ICommentService<Comment> {
	public List<Comment> getAllCommentByTourPostID(int tourPostID);
	int getNumberCommentOfPost(int postID);
}
