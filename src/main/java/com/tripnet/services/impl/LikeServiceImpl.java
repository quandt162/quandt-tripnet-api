package com.tripnet.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.ILikeDAO;
import com.tripnet.enties.Like;
import com.tripnet.services.ICommonService;
import com.tripnet.services.ILikesService;

/*
 * *Author: QuanDT
 */
@Service
public class LikeServiceImpl implements ICommonService<Like>, ILikesService<Like> {
	@Autowired 
	private ICommonDAO<Like> commonDAO;
	@Autowired 
	private ILikeDAO<Like> likeDAO;
	@Override
	public Like getOneById(int objectId) {
		return commonDAO.getOneById(objectId);
	}

	@Override
	public List<Like> getAll() {
		return commonDAO.getAll();
	}

	@Override
	public boolean add(Like object) {
		commonDAO.add(object);
		return true;
	}

	@Override
	public void update(Like object) {
		if(object != null) {
			commonDAO.update(object);
		}
	}

	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Like> getAllLikeByTourPostID(int tourPostID) {
		return likeDAO.getAllLikeByTourPostID(tourPostID);
	}

}
