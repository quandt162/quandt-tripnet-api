package com.tripnet.dao;

import java.util.List;

import com.tripnet.enties.JoinGroup;

public interface IJoinGroupDAO<T> {
	public List<T> getAllJoinGroupByTourPostID(int tourPostID);
	public JoinGroup getJoinGroup(int tourID, int accountID);
}
