package com.tech.StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewStudents {
	public static void viewStudents() throws ClassNotFoundException, SQLException{
		String url= "jdbc:mysql://localhost:3306/Studentmanagement";
		String user="root";
		String pass="MySQLak";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect=DriverManager.getConnection(url,user,pass);
		
		Statement stmt = connect.createStatement();
		
		String queryy="SELECT * FROM StudentData";
		ResultSet rss= stmt.executeQuery(queryy);
		
		while(rss.next()) {
			System.out.println(rss.getInt("id")+" "
								+rss.getString("name")+" "
								+rss.getString("course"));
		}
		rss.close();
		stmt.close();
		connect.close();
	}
	
	public static void viewSpecificStudents(int id) throws ClassNotFoundException, SQLException{
		String url= "jdbc:mysql://localhost:3306/Studentmanagement";
		String user="root";
		String pass="MySQLak";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect=DriverManager.getConnection(url,user,pass);
		
		String queryy="SELECT total,percentage,grade FROM StudentData where id= ?";
		PreparedStatement pstmt = connect.prepareStatement(queryy);
		pstmt.setInt(1, id);
		ResultSet rss= pstmt.executeQuery();
		
		while(rss.next()) {
			System.out.println(rss.getInt("total")+" "
								+rss.getDouble("percentage")+" "
								+rss.getString("grade"));
		}
		rss.close();
		pstmt.close();
		connect.close();
	}
}
