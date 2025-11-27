package com.tech.StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddResult {
	public static void addResult(int id,int total, double percentage, String grade) throws ClassNotFoundException, SQLException {
		String url= "jdbc:mysql://localhost:3306/Studentmanagement";
		String user="root";
		String pass="MySQLak";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect=DriverManager.getConnection(url,user,pass);
		String add = "Update StudentData set total=?,percentage=?,grade=? where id=?";
		PreparedStatement p = connect.prepareStatement(add);
		p.setInt(1,total);
		p.setDouble(2, percentage);
		p.setString(3, grade);
		p.setInt(4, id);
		p.executeUpdate();
		System.out.println("Result added");
		p.close();
		connect.close();
	}
}
