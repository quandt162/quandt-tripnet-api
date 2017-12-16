package com.tripnet.services;

import java.util.List;

import com.tripnet.enties.TourPost;
/*
 * *Author: QuanDT
 */
public interface ITourPostService<TourPost> {

	 public TourPost getTourPostByAccountId(int accountID);
	 
	 public List<TourPost> getAllTourPostByAccountName(String userName);
	 
	 public List<TourPost> getAllTourPostByDuration(int duration);
	 
	 public List<TourPost> getAllTourPostByPlace(String place1, String place2);
	 
	 public List<TourPost> getAllTourPostByTitle(String title);
	 
	 public List<TourPost> getAllTourPostByCategory(String name);
}
