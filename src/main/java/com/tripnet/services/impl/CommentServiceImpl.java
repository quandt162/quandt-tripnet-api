package com.tripnet.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripnet.dao.ICommonDAO;
import com.tripnet.enties.Comment;
import com.tripnet.services.ICommonService;

/*
 * *Author: QuanDT
 */
@Service
public class CommentServiceImpl implements ICommonService<Comment> {
	@Autowired 
	private ICommonDAO<Comment> commonDAO;
	@Override
	public Comment getOneById(int objectId) {
		return commonDAO.getOneById(objectId);
	}

	@Override
	public List<Comment> getAll() {
		return commonDAO.getAll();
	}

	
	@Override
	public boolean add(Comment object) {
		commonDAO.add(object);
		return true;
	}

	@Override
	public void update(Comment object) {
		if(object != null) {
			commonDAO.update(object);
		}
	}

	@Override
	public void delete(int objectId) {
		// TODO Auto-generated method stub
		
	}

}
