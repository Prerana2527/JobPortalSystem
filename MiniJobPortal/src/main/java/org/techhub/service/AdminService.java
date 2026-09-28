package org.techhub.service;

import java.util.List;

import org.techhub.Model.AdminModel;
import org.techhub.Model.ApplicationModel;

public interface AdminService {
	public boolean isRegister(AdminModel model);
	public boolean isLogin(AdminModel model);
	 public List<ApplicationModel>getApplications();
	
}
