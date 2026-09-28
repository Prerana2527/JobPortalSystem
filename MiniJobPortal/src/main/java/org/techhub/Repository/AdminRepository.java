package org.techhub.Repository;

import java.util.List;

import org.techhub.Model.AdminModel;
import org.techhub.Model.ApplicationModel;

public interface AdminRepository {
	 public boolean isRegister(AdminModel model);
	 public boolean isLogin(AdminModel model);
	
	 public List<ApplicationModel>getApplications();

	 
}
