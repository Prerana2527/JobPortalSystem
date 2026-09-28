package org.techhub.Repository;

import java.util.ArrayList;
import java.util.List;

import org.techhub.Model.ApplicationModel;
import org.techhub.Model.JobModel;
import org.techhub.dbconfig.DBConfig;

public class JobRepoImpl extends DBConfig implements JobRepository {
	List<JobModel> jobList;
	@Override
	public List<JobModel> viewJobs(JobModel model) {
		try {
			jobList=new ArrayList<JobModel>();
			stmt=conn.prepareStatement("select *from Jobs;");
			
			rs=stmt.executeQuery();
			while(rs.next())
			{
				JobModel jm=new JobModel();
				jm.setJobId(rs.getInt(1));
				jm.setTitle(rs.getString(2));
				jm.setCompany(rs.getString(3));
				jm.setLocation(rs.getString(4));
				jm.setDesc(rs.getString(5));
				
				jobList.add(jm);
			}
			return jobList;
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return null;
		}
		
	}
	public JobModel getJobById(int jobId) {

	    JobModel jm = null;

	    try {
	        stmt = conn.prepareStatement("Select *from Jobs where jobId=?");

	        stmt.setInt(1, jobId);
	        rs = stmt.executeQuery();

	        if (rs.next()) {
	            jm = new JobModel();
	            jm.setJobId(rs.getInt(1));
	            jm.setTitle(rs.getString(2));
	            jm.setCompany(rs.getString(3));
	            jm.setLocation(rs.getString(4));
	            jm.setDesc(rs.getString(5));
	        }

	    } catch (Exception ex) {
	        System.out.println(ex);
	    }

	    return jm;
	}
	public boolean isAddJob(JobModel model) {
		try {
			stmt=conn.prepareStatement("insert into jobs(title,company,location,description) values(?,?,?,?)");
			stmt.setString(1,model.getTitle());
			stmt.setString(2,model.getCompany());
			stmt.setString(3,model.getLocation());
			stmt.setString(4,model.getDesc());
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception ex) {
			ex.printStackTrace(); 
			return false;
			
		}
		
	}
	@Override
	public boolean updateJob(JobModel model) {
		try {
			stmt=conn.prepareStatement("Update jobs set title=?,company=?,location=?,description=? where jobId=?");
			stmt.setString(1,model.getTitle());
			stmt.setString(2, model.getCompany());
			stmt.setString(3,model.getLocation());
			stmt.setString(4, model.getDesc());
			stmt.setInt(5, model.getJobId());
			
			int value=stmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return false;
		}
		
	}
	@Override
	public boolean applyJob(ApplicationModel model) {
		  try {

		       
		        stmt = conn.prepareStatement("select * from Applications where userId=? AND jobId=?");

		        stmt.setInt(1, model.getUserId());
		        stmt.setInt(2, model.getJobId());
		       

		        rs = stmt.executeQuery();

		        if (rs.next()) {
		            return false; 
		        }

		       
		        stmt = conn.prepareStatement("insert into Applications values('0',?,?,?)");

		        stmt.setInt(1, model.getUserId());
		        stmt.setInt(2, model.getJobId());
		        stmt.setInt(3, 0); 

		        return stmt.executeUpdate() > 0;

		    } catch (Exception ex) {
		        System.out.println(ex);
		        return false;
		    }
	}

}
