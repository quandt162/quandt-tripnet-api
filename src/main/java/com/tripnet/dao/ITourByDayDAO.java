package com.tripnet.dao;

import java.util.List;

import com.tripnet.enties.TourByDay;

public interface ITourByDayDAO<TourByDay> {
//	public List<TourByDay> getTourByDayByTourPost(int toutPostID, int day);
	public List<TourByDay> getAllTourByDayByTourPost(int tourPostID);
	public TourByDay getTourByDayByTourPost(int toutPostID, int day);
}
