
package com.tripnet.services;

import java.util.List;

public interface IMediaService<T> {
	List<T> getAllMediaByAccountID(int accountID);
	List<T> getAllMediaByTourByDayID(int tourPostID);
	List<T> getAllMediaByTourPostID(int tourPostID);
}
