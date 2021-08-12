package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao_Connect {

	public static void main(String[] args) {
		Dao_Connect connect= new Dao_Connect();
	System.out.println(connect.database());	
	
	}
	

	
	public Connection database(){
		Connection conn=null;
		
		try {
			String user="root";
			String pass="hasterweak123";
			String driver="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/crud_app?useSSL=false";
			
			
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, pass);
			
			
			
		} catch (Exception e) {
			
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
		return conn;
		
	}
}
