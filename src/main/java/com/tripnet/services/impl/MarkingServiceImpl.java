package com.tripnet.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.IMarking;
import com.tripnet.enties.Marking;
import com.tripnet.services.ICommonService;
import com.tripnet.services.IMarkingService;

/*
 * *Author: QuanDT
 */
@Service
public class MarkingServiceImpl implements ICommonService<Marking>, IMarkingService<Marking> {
	@Autowired 
	private ICommonDAO<Marking> commonDAO;
	@Autowired 
	private IMarkingService<Marking> iMarking;
	
	@Override
	public Marking getOneById(int objectId) {
		return commonDAO.getOneById(objectId);
	}

	@Override
	public List<Marking> getAll() {
		return commonDAO.getAll();
	}

	@Override
	public boolean add(Marking object) {
		if(object != null) {
			commonDAO.add(object);
			return true;
		}
		return false;
	}

	@Override
	public void update(Marking object) {
		if(object != null) {
			commonDAO.update(object);
		}
	}

	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Marking getOneById(int accountId, int mId) {
		return iMarking.getOneById(accountId, mId);
	}

	@Override
	public List<Marking> getAllMarking(int accountId) {
		return iMarking.getAllMarking(accountId);
	}

}
