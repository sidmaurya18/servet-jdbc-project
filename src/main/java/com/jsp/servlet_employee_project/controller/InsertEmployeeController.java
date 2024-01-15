package com.jsp.servlet_employee_project.controller;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.servlet_employee_project.dto.Employee;
import com.jsp.servlet_employee_project.service.EmployeeService;

public class InsertEmployeeController extends HttpServlet {
	public static void main(String[] args) {
		
	    Scanner sc=new Scanner(System.in);
		System.out.println("What you want to perform:");
		System.out.println("1.Insert new Employee\n2.Display all Employee\n3.Display Employee by Id");
		System.out.println("4.Update Employee details\n5.Delete Employee Details\n=====================");
		
		EmployeeService service=new EmployeeService();
		int x=sc.nextInt();
		switch(x) {
		case 1:
		{
			System.out.println("For insertion please enter as given below ");
			System.out.println("Enter id");
			int id=sc.nextInt();
			System.out.println("Enter name");
			sc.nextLine();
			String name=sc.next();
			System.out.println("Enter email");
			String email=sc.next();
			System.out.println("Enter address");
			String address=sc.next();
			System.out.println("Enter phone");
			long phone=sc.nextLong();
			System.out.println("Enter salary");
			double salary=sc.nextDouble();
			Employee emp=new Employee(id, name, email, address, phone, salary);
			service.insertEmployeeDetailsService(emp);
			System.out.println("===Employ details inserted===");
			break;
		}
		case 2:
		{
			List<Employee> empList= service.displayAllEmployee();
			int count=1;
			for (Employee employee : empList) 
			{
				System.out.println("Employee "+count+" details\n-----------------");
				System.out.println("Id= "+employee.getId());
				System.out.println("Name= "+employee.getName());
				System.out.println("Email= "+employee.getEmail());
				System.out.println("Address= "+employee.getAddress());
				System.out.println("Phone no= "+employee.getPhone());
				System.out.println("Salary= "+employee.getSalary());
				System.out.println("-------------------------");
				count++;
			}
			break;
		}
		case 3:
		{
			System.out.println("Enter Id to Display details:");
			int id1=sc.nextInt();
			Employee employee = service.getEmployeeByIdService(id1);
			System.out.println("Employee details------");
			System.out.println("Id= "+employee.getId());
			System.out.println("Name= "+employee.getName());
			System.out.println("Email= "+employee.getEmail());
			System.out.println("Address= "+employee.getAddress());
			System.out.println("Phone no= "+employee.getPhone());
			System.out.println("Salary= "+employee.getSalary());
			break;
		}
		case 4:
		{
			System.out.println("Enter id to update salary");
			int id1=sc.nextInt();
			System.out.println("Enter salary that you want to update");
			double sal=sc.nextDouble();
			service.updateEmployeeSalaryByIdService(sal,id1);
			System.out.println("Salary updated-------");
			break;
		}
		case 5:
		{
			System.out.println("Enter id to delete");
			int id1=sc.nextInt();
			service.deleteEmployeeByIdDao(id1);
			System.out.println("Employee details deleted--------");
			break;
		}
		}
		
	}
}
