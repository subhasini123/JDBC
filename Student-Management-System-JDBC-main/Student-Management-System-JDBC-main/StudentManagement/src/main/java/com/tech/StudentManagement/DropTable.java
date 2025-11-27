package com.tech.StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

public class DropTable {
	public static void droptable() throws ClassNotFoundException, SQLException {
		String url= "jdbc:mysql://localhost:3306/Studentmanagement";
		String user="root";
		String pass="MySQLak";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect=DriverManager.getConnection(url,user,pass);
		
		String queryy= "DROP TABLE StudentData";
		Statement stmt = connect.createStatement();
		try {
			stmt.execute(queryy);
			System.out.println("Table sucessfully deleted!");
		}catch(SQLSyntaxErrorException e) {
			System.out.println("Table does not exists thus, can't be deleted.");
		}
		
		connect.close();
		
	}
}
