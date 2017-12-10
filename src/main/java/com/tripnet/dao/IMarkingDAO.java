package com.tripnet.dao;

import java.util.List;

public interface IMarkingDAO<T>  {
	List<T> getAllMarkingByAccount(int accountID);
	List<T> getAllMarkingByTourPostID(int accountID);
}
