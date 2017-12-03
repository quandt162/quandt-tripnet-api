package com.tripnet.dao;

import java.util.List;

public interface IMarking<Marking> {
	public Marking getOneById(int accountId, int mId);
	public List<Marking> getAllMarking(int accountId);
}
