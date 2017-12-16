package com.tripnet.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.tripnet.dao.ICommonDAO;
import com.tripnet.dao.IMediaDAO;
import com.tripnet.enties.Media;
import com.tripnet.services.ICommonService;
import com.tripnet.services.IMediaService;
/*
 * *Author: QuanDT
 */
@Service
public class MediaServiceImpl implements ICommonService<Media>, IMediaService<Media> {
	@Autowired 
	private ICommonDAO<Media> commonDAO;
	@Autowired 
	private IMediaDAO<Media> MediaDAO;
	@Override
	public List<Media> getAllMediaByAccountID(int accountID) {
		return MediaDAO.getAllMediaByAccount(accountID);
	}
	@Override
	public List<Media> getAllMediaByTourByDayID(int tourByDayID) {
		return MediaDAO.getAllMediaByTourByDayID(tourByDayID);
	}
	@Override
	public Media getOneById(int objectId) {
		return commonDAO.getOneById(objectId);
	}
	@Override
	public List<Media> getAll() {
		return commonDAO.getAll();
	}
	@Override
	public boolean add(Media object) {
		commonDAO.add(object);
		return true;
	}
	@Override
	public void update(Media object) {
		if(object!= null) commonDAO.update(object);
	}
	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Media> getAllMediaByTourPostID(int tourPostID) {
		return MediaDAO.getAllMediaByTourPostID(tourPostID);
	}

}
