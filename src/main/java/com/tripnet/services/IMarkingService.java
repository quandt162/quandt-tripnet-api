package com.tripnet.services;

import java.util.List;

public interface IMarkingService<Marking> {
	public List<Marking> getAllMarking(int accountID);
}
