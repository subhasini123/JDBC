package com.tech.StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStudent {
	
	public static void add(int id,String name, String course) throws ClassNotFoundException, SQLException {
		String url= "jdbc:mysql://localhost:3306/Studentmanagement";
		String user="root";
		String pass="MySQLak";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect=DriverManager.getConnection(url,user,pass);
		
		String insertt="INSERT INTO StudentData(id,name,course) VALUES(?,?,?)";
		PreparedStatement valuee= connect.prepareStatement(insertt);
		
		valuee.setInt(1, id);
		valuee.setString(2,name);
		valuee.setString(3, course);
		valuee.executeUpdate();
		System.out.println("Row added!");
		connect.close();
	}
	
}
