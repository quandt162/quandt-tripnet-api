package com.tripnet.dao;

import java.util.List;

import com.tripnet.enties.Like;

public interface ILikeDAO<T> {
	public List<T> getAllLikeByTourPostID(int tourPostID);
	public Like getLike(int tourID, int accountID);
}
