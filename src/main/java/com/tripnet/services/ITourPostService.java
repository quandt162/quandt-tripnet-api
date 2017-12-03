package com.tripnet.services;

import java.util.List;

import com.tripnet.enties.TourPost;
/*
 * *Author: QuanDT
 */
public interface ITourPostService<TourPost> {
//	T getOneById(int objectId);
//	List<T> getAll();	
//    boolean add(T object);
//    void update(T object);
//    void delete(int objectId);
	public TourPost getAllTourPostByTitle(String title);
}
