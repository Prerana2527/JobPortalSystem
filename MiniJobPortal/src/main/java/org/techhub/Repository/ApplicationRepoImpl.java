package org.techhub.Repository;

import java.util.ArrayList;
import java.util.List;

import org.techhub.Model.ApplicationModel;
import org.techhub.dbconfig.DBConfig;

public class ApplicationRepoImpl extends DBConfig implements ApplicationRepository 
{
	public boolean updateStatus(int id) {
		try {
			stmt=conn.prepareStatement("update Applications set status=1  where id=?");
			stmt.setInt(1, id);
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
			System.out.println("Error is:"+ex);
			return false;
		}
	}
	
	@Override
	public List<ApplicationModel> getShortlistedCandidates() {
		List<ApplicationModel> list=new ArrayList<>();
		try {
			stmt=conn.prepareStatement("select a.id,j.title,u.Name,u.contact,u.email from Jobs j inner join Applications a on a.jobId=j.jobId "
					+ "inner join User u on u.userId=a.userId where a.status=1");
	        rs = stmt.executeQuery();
	        while(rs.next())
	        {
	        	ApplicationModel model=new ApplicationModel();
	        	model.setId(rs.getInt(1));
	        	model.setTitle(rs.getString(2));
	        	model.setName(rs.getString(3));
	        	model.setContact(rs.getString(4));
	        	model.setEmail(rs.getString(5));
	        	list.add(model);
	        	
	        }
	       
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return list;
	}

	@Override
	public boolean requestStatus(int id) {
		try {
			stmt=conn.prepareStatement("update Applications set status=2  where id=?");
			stmt.setInt(1, id);
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
			System.out.println("Error is:"+ex);
			return false;
		}
		
	}

	@Override
	public List<ApplicationModel> getRejectedCandidates() {
		List<ApplicationModel> list=new ArrayList<>();
		try {
			stmt=conn.prepareStatement("select a.id,j.title,u.Name,u.contact,u.email from Jobs j inner join Applications a on a.jobId=j.jobId "
					+ "inner join User u on u.userId=a.userId where a.status=2");
	        rs = stmt.executeQuery();
	        while(rs.next())
	        {
	        	ApplicationModel model=new ApplicationModel();
	        	model.setId(rs.getInt(1));
	        	model.setTitle(rs.getString(2));
	        	model.setName(rs.getString(3));
	        	model.setContact(rs.getString(4));
	        	model.setEmail(rs.getString(5));
	        	list.add(model);
	        	
	        }
	       
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return list;
	}

	@Override
	public List<ApplicationModel> getShortlistedApplications(int userId) {
		List<ApplicationModel> list=new ArrayList<>();
		try {
			stmt=conn.prepareStatement("select a.id,j.jobId,j.title,j.company,J.location,j.description from Jobs j inner join Applications a on a.jobId=j.jobId "
					+ "where a.status=1 and a.userId=?");
			stmt.setInt(1, userId);
	        rs = stmt.executeQuery();
	        while(rs.next())
	        {
	        	ApplicationModel model=new ApplicationModel();
	        	model.setId(rs.getInt(1));
	        	model.setJobId(rs.getInt(2));
	        	model.setTitle(rs.getString(3));
	        	model.setCompany(rs.getString(4));
	        	model.setLocation(rs.getString(5));
	        	model.setDesc(rs.getString(6));
	        	list.add(model);
	        	
	        }
	       
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return list;
	}

	@Override
	public List<ApplicationModel> getRejectedApplications(int userId) {
		List<ApplicationModel> list=new ArrayList<>();
		try {
			stmt=conn.prepareStatement("select a.id,j.jobId,j.title,j.company,J.location,j.description from Jobs j inner join Applications a on a.jobId=j.jobId "
					+ "where a.status=2 and a.userId=?");
			stmt.setInt(1,userId);
	        rs = stmt.executeQuery();
	        while(rs.next())
	        {
	        	ApplicationModel model=new ApplicationModel();
	        	model.setId(rs.getInt(1));
	        	model.setJobId(rs.getInt(2));
	        	model.setTitle(rs.getString(3));
	        	model.setCompany(rs.getString(3));
	        	model.setLocation(rs.getString(5));
	        	model.setDesc(rs.getString(6));
	        	list.add(model);
	        	
	        }
	       
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return list;
	}
}
