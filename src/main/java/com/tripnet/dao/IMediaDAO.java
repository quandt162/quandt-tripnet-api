package com.tripnet.dao;

import java.util.List;

import com.tripnet.enties.Media;

public interface IMediaDAO<T> {
	List<T> getAllMediaByAccount(int accountID);
	List<T> getAllMediaByTourByDayID(int tourByDayID);
	List<T> getAllMediaByTourPostID(int tourByDayID);
}
