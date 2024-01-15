package com.jsp.servlet_employee_project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.servlet_employee_project.dto.Employee;
import com.jsp.servlet_employee_project.service.EmployeeService;

@WebServlet("/allEmployee")
public class DisplayAllEmployee extends HttpServlet {
		@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{	
		EmployeeService service= new EmployeeService();
		List<Employee> empList= service.displayAllEmployee();
		PrintWriter out= resp.getWriter();
		resp.setContentType("text/html");
		
		out.println("<table border='2px solid black' cellpadding='4px' cellspacing='0px'>");
		out.println("<tr>");
		out.println("<th>EmpId</th>");
		out.println("<th>EmpName</th>");
		out.println("<th>EmpEmail</th>");
		out.println("<th>EmpAddress</th>");
		out.println("<th>EmpPhone</th>");
		out.println("<th>EmpSalary</th>");
		out.println("<th>Edit</th>");
		out.println("<th>Delete</th>");
		out.println("</tr>");
		for (Employee employee : empList) {
			out.println("<tr>");
			out.println("<td>"+employee.getId()+"</td>");
			out.println("<td>"+employee.getName()+"</td>");
			out.println("<td>"+employee.getEmail()+"</td>");
			out.println("<td>"+employee.getAddress()+"</td>");
			out.println("<td>"+employee.getPhone()+"</td>");
			out.println("<td>"+employee.getSalary()+"</td>");
			out.println("<td>"+"<a href='updateDetails'> Edit </a>"+"</td>");
			out.println("<td>"+"<a href='deleteDetails?id="+employee.getId()+"'> Delete </a>"+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		
		out.println("<a href='employeeDetails.jsp'> Home </a>");
		 
		
		
		
	}

}
