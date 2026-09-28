package org.techhub.service;

import java.util.List;

import org.techhub.Model.ApplicationModel;

public interface ApplicationService {
	public boolean updateStatus(int id);
	public List<ApplicationModel> getShortlistedCandidates();
	
	public boolean rejectStatus(int id);
	
	public List<ApplicationModel> getRejectedCandidates();
	
	public List<ApplicationModel> getShortlistedApplications(int userId);
	
	public List<ApplicationModel> getRejectedApplications(int userId);
	
}
