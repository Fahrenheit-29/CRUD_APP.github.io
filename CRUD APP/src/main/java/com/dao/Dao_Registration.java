package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pojo.Register_User;

public class Dao_Registration {

	public int register(Register_User reg) {
		int success=0;
		Dao_Connect connect=  new Dao_Connect();
		
		Connection con=connect.database();
		try {
			
			String query= "INSERT INTO crud_app.mvc_crud()VALUES (?,?,?)";
			
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1, reg.getUsername());
			ps.setString(2, reg.getPassword());
			ps.setString(3, reg.getConfirmpassword());
			
			success=ps.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Something Went Wrong!!!");
		}
		
		
		
		
		
		return success;
		
	}
}
