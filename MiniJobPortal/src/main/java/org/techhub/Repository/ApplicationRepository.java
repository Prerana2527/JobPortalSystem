package org.techhub.Repository;

import java.util.List;

import org.techhub.Model.ApplicationModel;

public interface ApplicationRepository {
	public boolean updateStatus(int id);
	
	public List<ApplicationModel> getShortlistedCandidates();
	
	public boolean requestStatus(int id);
	
	public List<ApplicationModel> getRejectedCandidates();
	
	public List<ApplicationModel> getShortlistedApplications(int userId);
	
	public List<ApplicationModel> getRejectedApplications(int userId);
	
}
