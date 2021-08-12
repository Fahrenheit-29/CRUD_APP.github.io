package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pojo.POJO;

public class Dao_Login {

	
	
	
	public ResultSet form_login(POJO d) {
		Dao_Connect connect= new Dao_Connect();
		Connection conn=connect.database();
		ResultSet rs=null;
		
		try {
			
			String query="SELECT * FROM crud_app.mvc_crud WHERE username=? AND password=?";
			
			PreparedStatement ps= conn.prepareStatement(query);
			ps.setString(1, d.getUser());
			ps.setString(2, d.getPassword());
			
			rs= ps.executeQuery();
		
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
		return rs;
		
		
	}
	
	
	
}
