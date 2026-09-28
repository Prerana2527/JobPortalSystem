package org.techhub.Repository;

import java.util.ArrayList;
import java.util.List;

import org.techhub.Model.AdminModel;
import org.techhub.Model.ApplicationModel;
import org.techhub.dbconfig.DBConfig;

public class AdminRepoImpl extends DBConfig implements AdminRepository{

	@Override
	public boolean isRegister(AdminModel model) {
		try{
			stmt = conn.prepareStatement("insert into admin(email,password) values(?,?)");
			stmt.setString(1,model.getEmail());
			stmt.setString(2, model.getPassword());
			int value=stmt.executeUpdate();
			if(value>0) {
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception ex) {
			return false;
		}
		
	}
	@Override
	public boolean isLogin(AdminModel model) {
			try{
				stmt = conn.prepareStatement("select * from admin where email=? and password=?");
				stmt.setString(1, model.getEmail());
				stmt.setString(2, model.getPassword());

				rs = stmt.executeQuery();

				if(rs.next()) {
					return true;
				}
				else {
					return false;
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
				return false;
			}
	}
	@Override
	public List<ApplicationModel>getApplications() {
		List<ApplicationModel>list=new ArrayList<>();
		try{
			stmt=conn.prepareStatement("select a.id,j.title,u.Name,u.contact,u.email from Jobs j inner join Applications a on a.jobId=j.jobId "
					+ "inner join User u on u.userId=a.userId");
	        rs = stmt.executeQuery();

	        while(rs.next()) {
	           ApplicationModel model= new ApplicationModel();
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
	
	
}
