package com.tripnet.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.IJoinGroupDAO;
import com.tripnet.enties.JoinGroup;
import com.tripnet.services.ICommonService;
import com.tripnet.services.IJoinGroupService;

/*
 * *Author: QuanDT
 */
@Service
public class JoinGroupServiceImpl implements ICommonService<JoinGroup>, IJoinGroupService<JoinGroup> {
	@Autowired 
	private ICommonDAO<JoinGroup> commonDAO;
	@Autowired 
	private IJoinGroupDAO<JoinGroup> JoinGroupDAO;
	@Override
	public JoinGroup getOneById(int objectId) {
		return commonDAO.getOneById(objectId);
	}

	@Override
	public List<JoinGroup> getAll() {
		return commonDAO.getAll();
	}

	@Override
	public boolean add(JoinGroup object) {
		commonDAO.add(object);
		return true;
	}

	@Override
	public void update(JoinGroup object) {
		if(object != null) {
			commonDAO.update(object);
		}
	}

	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<JoinGroup> getAllJoinGroupByTourPostID(int tourPostID) {
		return JoinGroupDAO.getAllJoinGroupByTourPostID(tourPostID);
	}

}
