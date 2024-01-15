package com.jsp.servlet_employee_project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeConnection {
	public static Connection getEmployeeConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/servlet-employee";
			String user="root";
			String password="root";
			return DriverManager.getConnection(url, user, password);
			
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
