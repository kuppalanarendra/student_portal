package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daos.StudentDAO;
import com.dtos.Student;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		StudentDAO sd = new StudentDAO();
		try {
			List<Student> stddetails=sd.getStudentDetails();
			out.print("<html>");
			out.print("<head>"+
					"<link rel=stylesheet href=https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css>"+"</head>");
			out.print("<body>");
			out.print("<table border='1px solid blue'>");
			out.print("<th>Id</th><th>Firstname</th> <th>Lastname</th> <th>Branch</th> <th>Email</th> <th>Password</th> <th>PhoneNumber</th> <th>Age</th> <th>Gender</th> <th>Address</th> <th>EditData</th> <th>Delete Data</th>");
			for(Student std:stddetails) {
				out.println("<tr>"
						+ "<td>"+std.getId()+"</td>"
						 +"<td>"+std.getFirstname()+"</td>"
						 +"<td>"+std.getLastname()+"</td>"
						 +"<td>"+std.getBranch()+"</td>"
						 +"<td>"+std.getEmail()+"</td>"
						 +"<td>"+std.getPassword()+"</td>"
						 +"<td>"+std.getPhonenumber()+"</td>"
						 +"<td>"+std.getAge()+"</td>"
						 +"<td>"+std.getGender()+"</td>"
						 +"<td>"+std.getAddress()+"</td>"
						 +"<td>"+"<a href='EditServlet?id="+std.getId()+"'><i class=\"fas fa-edit\">Edit</i></a></td>"
						 +"<td>"+"<a href='DeleteServlet?id="+std.getId()+"'> <i class=\"fas fa-trash-alt\">Delete</i> </a></td>"
						+"</tr>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		
	}

}
