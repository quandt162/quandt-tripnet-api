
package com.tripnet.services;

import java.util.List;

public interface IJoinGroupService<JoinGroups> {
	public List<JoinGroups> getAllJoinGroupByTourPostID(int tourPostID);
	public List<JoinGroups> getAll();
}
