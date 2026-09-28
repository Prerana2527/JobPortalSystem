package org.techhub.service;

import java.util.List;

import org.techhub.Model.ApplicationModel;
import org.techhub.Model.JobModel;

public interface JobService {
	public List<JobModel> viewJobs(JobModel model);
	public boolean isAddJob(JobModel model);
	public boolean updateJob(JobModel model);
	
	public JobModel getJobById(int jobId);
	
	public boolean applyJob(ApplicationModel model);
}
