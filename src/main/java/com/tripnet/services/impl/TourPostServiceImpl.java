package com.tripnet.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.ITourPostDAO;
import com.tripnet.enties.TourPost;
import com.tripnet.services.ICommonService;
import com.tripnet.services.ITourPostService;

/*
 * *Author: QuanDT
 */
@Service
public class TourPostServiceImpl implements ICommonService<TourPost>,ITourPostService<TourPost> {
	
	@Autowired 
	private ICommonDAO<TourPost> commonDAO;
	@Autowired
	private ITourPostDAO<TourPost> tourPostDAO;

	
	@Override
	public TourPost getOneById(int objectId) {
		return commonDAO.getOneById(objectId);
	}

	@Override
	public List<TourPost> getAll() {
		return commonDAO.getAll();
	}

	@Override
	public synchronized boolean add(TourPost tourpost) {
		if (tourPostDAO.isExits(tourpost.getTourArticleTitle())) {
			return false;
		} else {
			commonDAO.add(tourpost);
			return true;
		}
	}

	@Override
	public void update(TourPost object) {
		if(object != null) commonDAO.update(object);
	}

	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TourPost> getAllTourPostByTitle(String title) {
		return tourPostDAO.getAllTourPostByTitle(title);
	}

	@Override
	public TourPost getTourPostByAccountId(int accountID) {
		return tourPostDAO.getTourPostByAccountId(accountID);
	}

	@Override
	public List<TourPost> getAllTourPostByAccountName(String userName) {
		return tourPostDAO.getAllTourPostByAccountName(userName);
	}

	@Override
	public List<TourPost> getAllTourPostByDuration(int duration) {
		return tourPostDAO.getAllTourPostByDuration(duration);
	}

	@Override
	public List<TourPost> getAllTourPostByPlace(String place1, String place2) {
		return tourPostDAO.getAllTourPostByPlace(place1,place2);
	}

	@Override
	public List<TourPost> getAllTourPostByCategory(String name) {
		return tourPostDAO.getAllTourPostByCategory(name);
	}

}
