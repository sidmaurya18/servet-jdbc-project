package com.jsp.servlet_employee_project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.servlet_employee_project.service.EmployeeService;
@WebServlet(value = "/deleteDetails")
public class DeleteEmployeeController  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		
		new EmployeeService().deleteEmployeeByIdDao(id);
		req.getRequestDispatcher("employeeDetails.jsp").forward(req, resp);
	}

}
