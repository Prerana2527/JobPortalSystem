package org.techhub.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.techhub.Model.ApplicationModel;
import org.techhub.Model.UserModel;
import org.techhub.dbconfig.DBConfig;

public class UserRepoImpl extends DBConfig implements UserRepository{
	Optional<UserModel> o=null;
	
	
	@Override
	public boolean isAddnewUser(UserModel model) {
		try {
			stmt=conn.prepareStatement("Insert into User values('0',?,?,?,?,?)");
			stmt.setString(1, model.getName());
			stmt.setString(2, model.getEmail());
			stmt.setString(3, model.getContact());
			stmt.setString(4,model.getUsername());
			stmt.setString(5,model.getPassword());
			
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
	public Optional<UserModel> validateUser(UserModel model) {
	    try {
	        stmt = conn.prepareStatement("SELECT * FROM User WHERE Username=? AND Password=?");
	        stmt.setString(1, model.getUsername());
	        stmt.setString(2, model.getPassword());

	        rs = stmt.executeQuery();

	        if(rs.next()) {
	            UserModel user = new UserModel();  // 🔥 create NEW object

	            user.setId(rs.getInt("userId"));   // ✅ VERY IMPORTANT
	            user.setName(rs.getString("name"));
	            user.setEmail(rs.getString("email"));
	            user.setContact(rs.getString("contact"));
	            user.setUsername(rs.getString("Username"));
	            user.setPassword(rs.getString("Password"));

	            return Optional.of(user);  // ✅ return DB object
	        } 
	        else {
	            return Optional.empty();
	        }

	    } catch(Exception ex) {
	        System.out.println("Error is:" + ex);
	        return Optional.empty();
	    }
	}

	@Override
	public boolean isUserExist(String username) {
		
		try {
			UserModel model=new UserModel();
			stmt=conn.prepareStatement("Select *from user where Username=?");
			stmt.setString(1, username);
			rs=stmt.executeQuery();
			if(rs.next())
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
	public UserModel getProfile(int userId) {

	    try {
	        stmt = conn.prepareStatement("SELECT * FROM user WHERE userId=?");
	        stmt.setInt(1, userId);
	        UserModel model=new UserModel();
	        rs = stmt.executeQuery();
	        if(rs.next()) {  
	            
	            model.setName(rs.getString("name"));
	            model.setEmail(rs.getString("email"));
	            model.setContact(rs.getString("contact"));
	            model.setUsername(rs.getString("Username"));
	            model.setPassword(rs.getString("Password"));   
	        }
	        return model;
	    } catch(Exception ex) {
	        System.out.println(ex);
	        return null;
	    }
	   
	}
	public boolean updateProfile(UserModel model) {
		try {
			stmt = conn.prepareStatement("Update user set name=?, email=?, contact=?, Username=?, Password=? where userId=?");
			stmt.setString(1,model.getName());
			stmt.setString(2, model.getEmail());
			stmt.setString(3,model.getContact());
			stmt.setString(4, model.getUsername());
			stmt.setString(5,model.getPassword());
			stmt.setInt(6,model.getId());
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
			return false;
		}
	}
	public List<ApplicationModel>getAppliedJobs(int userId) {
		List<ApplicationModel>list=new ArrayList<>();
		try{
			stmt=conn.prepareStatement("select a.id,j.title,u.Name,u.contact,u.email from Jobs j inner join Applications a on a.jobId=j.jobId "
					+ "inner join User u on u.userId=a.userId where u.userId=?");
			stmt.setInt(1, userId);
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
