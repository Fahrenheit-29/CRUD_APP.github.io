package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pojo.POJO;

public class Dao_ChangePass {

	
	
	
	
	public int changepass(POJO change) {
		
		Dao_Connect connect=new Dao_Connect();
		Connection con=connect.database();
		int i=0;
		try {
			String query="UPDATE  crud_app.mvc_crud SET  password=? WHERE username=? ";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, change.getPassword());
			ps.setString(2, change.getUser());
			
			i=ps.executeUpdate();
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage()+"/n Something Wrong");     
			e.printStackTrace();
		}
		
		
		
		
		return i;
		
	}
}
