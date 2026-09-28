package org.techhub.service;

import java.util.List;
import java.util.Optional;

import org.techhub.Model.ApplicationModel;
import org.techhub.Model.UserModel;

public interface UserService {
	
	public boolean isAddNewUser(UserModel model);
	public Optional<UserModel> validateUser(UserModel model);
	public boolean isUserExist(String username);
	public UserModel getProfile(int userId);
	public boolean updateProfile(UserModel model);
	public List<ApplicationModel>getAppliedJobs(int userId);
}
