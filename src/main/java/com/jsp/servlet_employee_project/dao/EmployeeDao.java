package com.jsp.servlet_employee_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.servlet_employee_project.connection.EmployeeConnection;
import com.jsp.servlet_employee_project.dto.Employee;
import com.mysql.cj.protocol.Resultset;

public class EmployeeDao {
	Connection con = EmployeeConnection.getEmployeeConnection();
	/*
	 * Insert
	 */
	public Employee insertEmployeeDetailsDao(Employee employee)
	{
		String insertQuery="insert into employee(id,name,email,address,phone,salary) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(insertQuery);
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getEmail());
			ps.setString(4, employee.getAddress());
			ps.setLong(5, employee.getPhone());
			ps.setDouble(6, employee.getSalary());
			
			ps.execute();
			return employee;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * Display All
	 */
	public List<Employee> displayAllEmployee()
	{
		List<Employee> empList=new ArrayList<Employee>();
		String displayQuery="select * from employee";
		try {
		 	PreparedStatement ps= con.prepareStatement(displayQuery);
		 	ResultSet rs= ps.executeQuery();
		 	while(rs.next())
		 	{
		 		int id= rs.getInt("id");
		 		String name= rs.getString("name");
		 		String email= rs.getString("email");
		 		String address= rs.getString("address");
		 		long phone= rs.getLong("phone");
		 		double salary= rs.getDouble("salary");
		 		
		 		Employee emp=new Employee(id, name, email, address, phone, salary);
		 		empList.add(emp);
		 	}
		 	return empList;		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * Display Employee by Id
	 */
	public Employee getEmployeeByIdDao(int employeeId)
	{
		String displayQyery="select * from employee where id=?";
		try {
			PreparedStatement ps= con.prepareStatement(displayQyery);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				int id=rs.getInt("id");
				String name= rs.getString("name");
		 		String email= rs.getString("email");
		 		String address= rs.getString("address");
		 		long phone= rs.getLong("phone");
		 		double salary= rs.getDouble("salary");
		 		
		 		Employee employee=new Employee(id, name, email, address, phone, salary);
		 		return employee;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * Update Employee details
	 */
	public void updateEmployeeSalaryByIdDao(double salary, int id )
	{
		String updateQuery="update employee set salary=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(updateQuery);
			ps.setDouble(1, salary);
			ps.setInt(2, id);
			ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Delete Employee details
	 */
	public void deleteEmployeeByIdDao(int id)
	{
		String deleteQuery = "delete from employee where id=?";
		try {
			PreparedStatement ps= con.prepareStatement(deleteQuery);
			ps.setInt(1, id);
			ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
