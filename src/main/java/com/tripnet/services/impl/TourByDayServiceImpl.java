package com.tripnet.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.ITourByDayDAO;
import com.tripnet.enties.TourByDay;
import com.tripnet.services.ICommonService;
import com.tripnet.services.ITourByDayService;
/*
 * *Author: QuanDT
 */
@Service
public class TourByDayServiceImpl implements ICommonService<TourByDay>, ITourByDayService<TourByDay> {
	@Autowired
	private ICommonDAO<TourByDay> commonDAO;
	@Autowired
	private ITourByDayDAO<TourByDay> touByDayDAO;
	
	@Override
	public TourByDay getOneById(int objectId) {
		TourByDay obj = commonDAO.getOneById(objectId);
		return obj;
	}

	@Override
	public List<TourByDay> getAll() {
		return commonDAO.getAll();
	}

	@Override
	public boolean add(TourByDay object) {
		if(object != null) {
			commonDAO.add(object);
			return true;
		}else return true;
	}

	@Override
	public void update(TourByDay object) {
		if(object != null) commonDAO.update(object);
	}

	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TourByDay getTourByDayByTourPost(int toutPostID, int day) {
		return touByDayDAO.getTourByDayByTourPost(toutPostID, day);
	}

	@Override
	public List<TourByDay> getAllTourByDayByTourPost(int tourPostID) {
		return touByDayDAO.getAllTourByDayByTourPost(tourPostID);
	}
	
}
