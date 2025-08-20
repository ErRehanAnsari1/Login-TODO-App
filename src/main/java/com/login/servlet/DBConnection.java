package com.login.servlet;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static final String url="jdbc:mysql://localhost:3306/logininfo";
	private static final String uid="root";
	private static final String password="Rehan@123";
	
	public static Connection getConnection() {
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,uid,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
