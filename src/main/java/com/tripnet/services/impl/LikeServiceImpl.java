package com.tripnet.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.ILikeDAO;
import com.tripnet.enties.Likes;
import com.tripnet.services.ICommonService;
import com.tripnet.services.ILikesService;

/*
 * *Author: QuanDT
 */
@Service
public class LikeServiceImpl implements ICommonService<Likes>, ILikesService<Likes> {
	@Autowired 
	private ICommonDAO<Likes> commonDAO;
	@Autowired 
	private ILikeDAO<Likes> likeDAO;
	@Override
	public Likes getOneById(int objectId) {
		return commonDAO.getOneById(objectId);
	}

	@Override
	public List<Likes> getAll() {
		return commonDAO.getAll();
	}

	@Override
	public boolean add(Likes object) {
		commonDAO.add(object);
		return true;
	}

	@Override
	public void update(Likes object) {
		if(object != null) {
			commonDAO.update(object);
		}
	}

	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Likes> getAllLikeByTourPostID(int tourPostID) {
		return likeDAO.getAllLikeByTourPostID(tourPostID);
	}

}
