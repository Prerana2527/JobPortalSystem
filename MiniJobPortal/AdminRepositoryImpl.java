package org.techhub.repository;

import org.techhub.dbconfig.DBConfig;
import org.techhub.model.AdminModel;

public class AdminRepositoryImpl extends DBConfig implements AdminRepository {

	@Override
	public boolean isRegister(AdminModel model) {
		try{
			stmt = conn.prepareStatement("insert into admins(email,password) values(?,?)");
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
			stmt = conn.prepareStatement("select * from admins where email=? and password=?");
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
}
