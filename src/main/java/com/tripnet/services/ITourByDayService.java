package com.tripnet.services;

import java.util.List;

import com.tripnet.enties.TourByDay;

public interface ITourByDayService<TourByDay> {
//	public List<TourByDay> getTourByDayByTourPost(int toutPostID, int day);
	public List<TourByDay> getAllTourByDayByTourPost(int tourPostID);
	
	public TourByDay getTourByDayByTourPost(int toutPostID, int day);
}
