package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daos.StudentDAO;
import com.dtos.Student;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignUpServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// you can get the value from the html to servlet by calling the method
		// getParameter()
		// of interface servletRequest or httpservletrequest using refernece variable

		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		String firstname=request.getParameter("fname");
		String lastname=request.getParameter("lname");
		String branch = request.getParameter("branch");
		String email=request.getParameter("mail");
		String password=request.getParameter("pass");
		String phonenumber = request.getParameter("phn");
	    long phone=Long.parseLong(phonenumber);
		String ages=request.getParameter("age");
		int age=Integer.parseInt(ages);
		String gender=request.getParameter("gender");
		String address=request.getParameter("addr");
		
		Student s= new Student();
		s.setId(id1);
		s.setFirstname(firstname);
		s.setLastname(lastname);
		s.setBranch(branch);
		s.setEmail(email);
		s.setPassword(password);
		s.setPhonenumber(phone);
		s.setAge(age);
		s.setGender(gender);
		s.setAddress(address);
		
		StudentDAO sd= new StudentDAO();
		try {
			boolean status = sd.createStudentAccount(s);
			if(status) {
				out.print("<html><body><b>Account has been crearted succesfully<b><a href='login.html'>Login</a></body></html>");
			}
			else {
				out.print("<html><body><b>Invalid Details<b></body></html>");
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

	}

	

}
