package com.jsp.servlet_employee_project.service;

import java.util.List;

import com.jsp.servlet_employee_project.dao.EmployeeDao;
import com.jsp.servlet_employee_project.dto.Employee;

public class EmployeeService {
	EmployeeDao dao=new EmployeeDao();
	
	public Employee insertEmployeeDetailsService(Employee employee)
	{
		return dao.insertEmployeeDetailsDao(employee);
	}
	
	public List<Employee> displayAllEmployee()
	{
		return dao.displayAllEmployee();
	} 
	
	public Employee getEmployeeByIdService(int employeeId)
	{
		return dao.getEmployeeByIdDao(employeeId);
	}
	
	public void updateEmployeeSalaryByIdService(double salary, int id )
	{
		dao.updateEmployeeSalaryByIdDao(salary, id);
	}
	
	public void deleteEmployeeByIdDao(int id)
	{
		dao.deleteEmployeeByIdDao(id);
	}
	

}
