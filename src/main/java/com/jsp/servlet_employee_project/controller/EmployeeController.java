package com.jsp.servlet_employee_project.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.servlet_employee_project.dto.Employee;
import com.jsp.servlet_employee_project.service.EmployeeService;

@WebServlet("/employeeDetails")
public class EmployeeController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		EmployeeService service=new EmployeeService();
		Employee emp=null;
		
		int id=Integer.parseInt(req.getParameter("empId"));
		String name= req.getParameter("empName");
		String email= req.getParameter("empEmail");
		String address= req.getParameter("empAddress");
		long phone= Long.parseLong(req.getParameter("empPhone"));
		double salary= Double.parseDouble(req.getParameter("empSalary"));
		
		 emp=new Employee(id, name, email, address, phone, salary);
			service.insertEmployeeDetailsService(emp);
			PrintWriter pw = resp.getWriter();
			resp.setContentType("text/html");
			pw.println("<h2 style='color:green'>Details stored Successfully</h2>");
			RequestDispatcher rd= req.getRequestDispatcher("employeeDetails.jsp");
			rd.include(req, resp);
			
			
	}
}
