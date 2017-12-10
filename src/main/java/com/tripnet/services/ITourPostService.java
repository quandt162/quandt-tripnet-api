package com.tripnet.services;

import java.util.List;

import com.tripnet.enties.TourPost;
/*
 * *Author: QuanDT
 */
public interface ITourPostService<T	> {
	 public T getOneById(int objectId);
//	List<T> getAll();	
//    boolean add(T object);
//    void update(T object);
//    void delete(int objectId);
	 public TourPost getTourPostByAccountId(int accountID);
	 
	 public List<T> getAllTourPostByAccountName(String userName);
	 
	 public List<T> getAllTourPostByDuration(int duration);
	 
	 public List<T> getAllTourPostByPlace(String place1);
	 
	 public List<T> getAllTourPostByTitle(String title);
}
