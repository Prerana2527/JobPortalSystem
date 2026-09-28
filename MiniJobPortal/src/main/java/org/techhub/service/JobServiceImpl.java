package org.techhub.service;

import java.util.List;

import org.techhub.Model.ApplicationModel;
import org.techhub.Model.JobModel;
import org.techhub.Repository.JobRepoImpl;
import org.techhub.Repository.JobRepository;

public class JobServiceImpl implements JobService{
	JobRepository jbRepo=new JobRepoImpl();
	@Override
	public List<JobModel> viewJobs(JobModel model) {
		
		return jbRepo.viewJobs(model);
	}
	@Override
	public boolean isAddJob(JobModel model) {
		
		return jbRepo.isAddJob(model);
	}
	@Override
	public boolean updateJob(JobModel model) {
		
		return jbRepo.updateJob(model);
	}
	@Override
	public JobModel getJobById(int jobId) {
		
		return jbRepo.getJobById(jobId);
	}
	public boolean applyJob(ApplicationModel model)
	{
		return jbRepo.applyJob(model);
	}
	

}
