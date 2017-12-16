package com.tripnet.services;

import java.util.List;

public interface IMarkingService<T> {
	List<T> getAllMarkingByAccountID(int accountID);
}
