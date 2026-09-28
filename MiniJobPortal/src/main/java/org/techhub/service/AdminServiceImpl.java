package org.techhub.service;

import java.util.List;

import org.techhub.Model.AdminModel;
import org.techhub.Model.ApplicationModel;
import org.techhub.Repository.AdminRepoImpl;
import org.techhub.Repository.AdminRepository;

public class AdminServiceImpl implements AdminService {

	AdminRepository adminRepo=new AdminRepoImpl();
	
	public boolean isRegister(AdminModel model) {
		// TODO Auto-generated method stub
		return adminRepo.isRegister(model) ;
	}

	@Override
	public boolean isLogin(AdminModel model) {
		return adminRepo.isLogin(model);
	}

	@Override
	public List<ApplicationModel> getApplications() {
		
		return adminRepo.getApplications();
	}

	
}
