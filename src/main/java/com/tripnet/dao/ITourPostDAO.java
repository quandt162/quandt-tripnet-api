package com.tripnet.dao;

import java.util.List;

/*
 * *Author: QuanDT
 */
public interface ITourPostDAO<TourPost> {
	 boolean isExits(String title);
	 
	 public TourPost getTourPostByAccountId(int accountID);
	 
	 public List<TourPost> getAllTourPostByAccountName(String userName);
	 
	 public List<TourPost> getAllTourPostByDuration(int duration);
	 
	 public List<TourPost> getAllTourPostByPlace(String place1, String place2);
	 
	 public List<TourPost> getAllTourPostByTitle(String title);
	 
	 public List<TourPost> getAllTourPostByCategory(String name);
	 
}
