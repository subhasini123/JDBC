package com.tech.StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRecord {
	public static void deleteStudent(int id) throws ClassNotFoundException, SQLException {
		String url= "jdbc:mysql://localhost:3306/Studentmanagement";
		String user="root";
		String pass="MySQLak";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect=DriverManager.getConnection(url,user,pass);
		
		String queryy="DELETE FROM StudentData WHERE id = ?";
		PreparedStatement pstmt = connect.prepareStatement(queryy);
		pstmt.setInt(1, id);
		int a=pstmt.executeUpdate();
		if(a>0) {
			System.out.println("Row deleted!");
		}else {
			System.out.println("Student does not exists in the table");
		}
		connect.close();
	}
	public static void deleteResult(int id) throws ClassNotFoundException, SQLException {
		String url= "jdbc:mysql://localhost:3306/Studentmanagement";
		String user="root";
		String pass="MySQLak";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect=DriverManager.getConnection(url,user,pass);
		
		String queryy="UPDATE StudentData SET total = null, percentage=null, grade=null WHERE id = ?";
		PreparedStatement pstmt = connect.prepareStatement(queryy);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		System.out.println("Deleted!");
	}
}
