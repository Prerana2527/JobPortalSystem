package org.techhub.service;

import java.util.List;

import org.techhub.Model.ApplicationModel;
import org.techhub.Repository.ApplicationRepoImpl;
import org.techhub.Repository.ApplicationRepository;

public class ApplicationServiceImpl implements ApplicationService {
	ApplicationRepository appRepo=new ApplicationRepoImpl();
	@Override
	public boolean updateStatus(int id) {
		return appRepo.updateStatus(id);
	}
	@Override
	public List<ApplicationModel> getShortlistedCandidates() {
	
		return appRepo.getShortlistedCandidates();
	}
	@Override
	public boolean rejectStatus(int id) {
	
		return appRepo.requestStatus(id);
	}
	@Override
	public List<ApplicationModel> getRejectedCandidates() {
		
		return appRepo.getRejectedCandidates();
	}
	@Override
	public List<ApplicationModel> getShortlistedApplications(int userId) {
		return appRepo.getShortlistedApplications(userId);
	}
	@Override
	public List<ApplicationModel> getRejectedApplications(int userId) {
		
		return appRepo.getRejectedApplications(userId);
	}

}
