package org.techhub.service;

import org.techhub.model.JobModel;
import org.techhub.repository.JobRepositoryImpl;
import org.techhub.repository.JobRepository;
public class JobServiceImpl implements JobService {
    JobRepository jobRepo=new JobRepositoryImpl();
	@Override
	public boolean isAddJob(JobModel model) {
		// TODO Auto-generated method stub
		return jobRepo.isAddJob(model);
	}

}
