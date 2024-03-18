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
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		int id1=Integer.parseInt(id);
		String firstname=request.getParameter("fname");
		
	    String lastname = request.getParameter("lname");
	    String branch = request.getParameter("branch");
	    String email = request.getParameter("email");
	    String password = request.getParameter("pass");
	    String phonenumber = request.getParameter("phone");
	    long phone=Long.parseLong(phonenumber);
	    String ages= request.getParameter("age");
	    int age= Integer.parseInt(ages);
	    String gender = request.getParameter("gender");
	    String address= request.getParameter("addr");
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
	    StudentDAO sd=new StudentDAO();
	    try {
			boolean status=sd.updateStudent(s);
			if(status) {
				response.sendRedirect("view");
			}
			else {
				out.println("unable to proced");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	}

}
