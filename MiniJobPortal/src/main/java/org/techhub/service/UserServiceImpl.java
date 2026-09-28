package org.techhub.service;

import java.util.List;
import java.util.Optional;

import org.techhub.Model.ApplicationModel;
import org.techhub.Model.UserModel;
import org.techhub.Repository.UserRepoImpl;
import org.techhub.Repository.UserRepository;

public class UserServiceImpl implements UserService {
	UserRepository userRepo=new UserRepoImpl();
	@Override
	public boolean isAddNewUser(UserModel model) {
		return userRepo.isAddnewUser(model);
	}
	@Override
	public Optional<UserModel> validateUser(UserModel model) {
		
		UserRepository userRepo=new UserRepoImpl();
		return userRepo.validateUser(model);
	}
	@Override
	public boolean isUserExist(String usernamel) {
		// TODO Auto-generated method stub
		return userRepo.isUserExist(usernamel);
	}
	@Override
	public UserModel getProfile(int userId) {
		UserRepository userRepo=new UserRepoImpl();
		return userRepo.getProfile(userId);
	}
	@Override
	public boolean updateProfile(UserModel model) {
		
		return userRepo.updateProfile(model);
	}
	@Override
	public List<ApplicationModel> getAppliedJobs(int userId) {
		// TODO Auto-generated method stub
		return userRepo.getAppliedJobs(userId);
	}

}
