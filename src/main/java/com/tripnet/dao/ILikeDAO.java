package com.tripnet.dao;

import java.util.List;

public interface ILikeDAO<T> {
	public List<T> getAllLikeByTourPostID(int tourPostID);
}
