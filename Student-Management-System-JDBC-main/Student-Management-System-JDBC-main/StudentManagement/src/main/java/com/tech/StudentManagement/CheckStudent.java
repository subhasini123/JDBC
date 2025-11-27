package com.tech.StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckStudent {
	static boolean studentexists(int id) throws ClassNotFoundException, SQLException {
		String url= "jdbc:mysql://localhost:3306/Studentmanagement";
		String user="root";
		String pass="MySQLak";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect=DriverManager.getConnection(url,user,pass);
		
		String queryy=("SELECT * FROM StudentData where id= "+id);
		PreparedStatement p = connect.prepareStatement(queryy);
		ResultSet r = p.executeQuery();
		if(r.next()) {
			return true;
		}else {
			return false;
		}
	}
}
