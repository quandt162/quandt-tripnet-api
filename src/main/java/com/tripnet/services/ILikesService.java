
package com.tripnet.services;

import java.util.List;

public interface ILikesService<Likes> {
	public List<Likes> getAllLikeByTourPostID(int tourPostID);
	public List<Likes> getAll();
}
