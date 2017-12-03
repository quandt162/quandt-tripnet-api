package com.tripnet.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.IPlaceDAO;
import com.tripnet.enties.Place;
import com.tripnet.services.ICommonService;

@Service
public class PlaceServiceImpl implements ICommonService<Place>{
	@Autowired
	private ICommonDAO<Place> commonDAO;
	@Autowired
	private IPlaceDAO<Place> placeDAO;
	@Override
	public Place getOneById(int objectId) {
		return commonDAO.getOneById(objectId);
	}

	@Override
	public List<Place> getAll() {
		return commonDAO.getAll();
	}

	@Override
	public boolean add(Place object) {
		if (placeDAO.isExit(object.getName(), object.getRegion())) {
			return false;
		} else {
			commonDAO.add(object);
			return true;
		}
	}

	@Override
	public void update(Place object) {
		if(object != null) commonDAO.update(object);
	}

	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}

}
