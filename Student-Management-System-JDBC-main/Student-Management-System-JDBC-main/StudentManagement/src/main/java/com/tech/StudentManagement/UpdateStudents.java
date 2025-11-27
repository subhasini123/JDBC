package com.tech.StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateStudents {
	public static void updateResult(int id,int total,Double percentage,String grade) throws ClassNotFoundException, SQLException {
	String url= "jdbc:mysql://localhost:3306/Studentmanagement";
	String user="root";
	String pass="MySQLak";
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connect=DriverManager.getConnection(url,user,pass);
	
	String queryy="UPDATE StudentData SET total = ?, percentage=?, grade=? WHERE id = ?";
	PreparedStatement pstmt = connect.prepareStatement(queryy);
	pstmt.setInt(1, total);
	pstmt.setDouble(2, percentage);
	pstmt.setString(3, grade);
	pstmt.setInt(4, id);
	int c=pstmt.executeUpdate();
	if(c>0) {
		System.out.println("Marks updated!");
	}else {
		System.out.println("Student does not exist in the table.");
	}
	
	connect.close();
	}
	public static void updateName(int id,String name) throws ClassNotFoundException, SQLException {
		String url= "jdbc:mysql://localhost:3306/Studentmanagement";
		String user="root";
		String pass="MySQLak";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect=DriverManager.getConnection(url,user,pass);
		
		String queryy="UPDATE StudentData SET name = ? WHERE id = ?";
		PreparedStatement pstmt = connect.prepareStatement(queryy);
		pstmt.setString(1, name);
		pstmt.setInt(2, id);
		int c=pstmt.executeUpdate();
		if(c>0) {
			System.out.println("Name updated!");
		}else {
			System.out.println("Student does not exist in the table.");
		}
		
		connect.close();
		}
	public static void updateCourse(int id,String course) throws ClassNotFoundException, SQLException {
		String url= "jdbc:mysql://localhost:3306/Studentmanagement";
		String user="root";
		String pass="MySQLak";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect=DriverManager.getConnection(url,user,pass);
		
		String queryy="UPDATE StudentData SET course = ? WHERE id = ?";
		PreparedStatement pstmt = connect.prepareStatement(queryy);
		pstmt.setString(1, course);
		pstmt.setInt(2, id);
		int c=pstmt.executeUpdate();
		if(c>0) {
			System.out.println("Name updated!");
		}else {
			System.out.println("Student does not exist in the table.");
		}
		
		connect.close();
		}
}
