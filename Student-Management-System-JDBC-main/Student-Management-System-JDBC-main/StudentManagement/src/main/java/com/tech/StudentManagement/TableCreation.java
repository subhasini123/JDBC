package com.tech.StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

public class TableCreation {
	
	public static void createTable() throws SQLException, ClassNotFoundException {
		String url= "jdbc:mysql://localhost:3306/Studentmanagement";
		String user="root";
		String pass="MySQLak";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect=DriverManager.getConnection(url,user,pass);
		Statement stmt = connect.createStatement();
		String Table="Create Table StudentData(id int PRIMARY KEY,name varchar(50),course varchar(50),total int, percentage decimal(5,2), grade varchar(10))";
		try {
			stmt.executeUpdate(Table);
			System.out.println("The Table is created");
		}catch(SQLSyntaxErrorException e) {
			System.out.println(e.getMessage());
		}
	
		connect.close();
		stmt.close();
	}
	
}
