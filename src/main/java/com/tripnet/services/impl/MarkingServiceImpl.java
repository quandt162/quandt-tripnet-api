package com.tripnet.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.IMarkingDAO;
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
	private IMarkingDAO<Marking> markingDAO;
	@Override
	public List<Marking> getAllMarkingByAccountID(int accountID) {
		return markingDAO.getAllMarkingByAccount(accountID);
	}
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
		commonDAO.add(object);
		return true;
	}
	@Override
	public void update(Marking object) {
		if(object!= null) commonDAO.update(object);
	}
	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}
}
