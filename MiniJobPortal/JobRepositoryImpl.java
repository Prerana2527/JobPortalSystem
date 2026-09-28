package org.techhub.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.techhub.dbconfig.DBConfig;
import org.techhub.model.JobApplicationModel;
import org.techhub.model.JobModel;

public class JobRepositoryImpl extends DBConfig implements JobRepository {

	@Override
	public boolean isAddJob(JobModel model) {
		try {
			stmt=conn.prepareStatement("insert into jobs(title,company,location,description) values(?,?,?,?)");
			stmt.setString(1,model.getTitle());
			stmt.setString(2,model.getCompany());
			stmt.setString(3,model.getLocation());
			stmt.setString(4,model.getDescription());
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception ex) {
			ex.printStackTrace(); 
			return false;
			
		}
		
	}

	@Override
	public List<JobModel> viewJobs(JobModel model) {
		List<JobModel> jobList;
			try {
				jobList=new ArrayList<JobModel>();
				stmt=conn.prepareStatement("select *from Jobs;");
				
				rs=stmt.executeQuery();
				while(rs.next())
				{
					JobModel jm=new JobModel();
					jm.setId(rs.getInt(1));
					jm.setTitle(rs.getString(2));
					jm.setCompany(rs.getString(3));
					jm.setLocation(rs.getString(4));
					jm.setDescription(rs.getString(5));
					
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

	@Override
	public boolean isUpdateJob(JobModel model) {
		try {
			stmt=conn.prepareStatement("Update jobs set title=?,company=?,location=?,description=? where id=?");
			stmt.setString(1,model.getTitle());
			stmt.setString(2,model.getCompany());
			stmt.setString(3,model.getLocation());
			stmt.setString(4,model.getDescription());
			stmt.setInt(5,model.getId());
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception ex) {
	    System.out.println("Error is "+ex);
		}
		return false;
	}

	@Override
	public JobModel getJobById(int id) {
		JobModel model=null;
	
		try {
			stmt=conn.prepareStatement("select *from jobs where id=?");
			stmt.setInt(1,id);
			ResultSet rs=stmt.executeQuery();
			 if (rs.next()) {
	                model = new JobModel();

	                model.setId(rs.getInt("id"));
	                model.setTitle(rs.getString("title"));
	                model.setCompany(rs.getString("company"));
	                model.setLocation(rs.getString("location"));
	                model.setDescription(rs.getString("description"));
	            }
		}

     catch (Exception ex) {
         ex.printStackTrace();
     }

     return model;
 }

	@Override
	public boolean applyJob(JobApplicationModel model) {
		  try {

		        // check duplicate
		        stmt = conn.prepareStatement(
		            "SELECT * FROM job_applications WHERE user_id=? AND job_id=?"
		        );

		        stmt.setInt(1, model.getUserId());
		        stmt.setInt(2, model.getJobId());

		        rs = stmt.executeQuery();

		        if (rs.next()) {
		            return false; // already applied
		        }

		        // insert new application
		        stmt = conn.prepareStatement(
		            "INSERT INTO job_applications(user_id, job_id, status) VALUES (?, ?, 'PENDING')"
		        );

		        stmt.setInt(1, model.getUserId());
		        stmt.setInt(2, model.getJobId());

		        return stmt.executeUpdate() > 0;

		    } catch (Exception e) {
		        System.out.println("Apply error: " + e);
		        return false;
		    }
		}
}
