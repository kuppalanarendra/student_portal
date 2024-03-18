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
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String id= request.getParameter("id");
		int id1=Integer.parseInt(id);
		StudentDAO sd= new StudentDAO();
		try {
			Student st=sd.getStudent(id1);
			out.print("<html>");
			out.print("<head>"
					+ "<meta charset=\"UTF-8\">"
					+"<style>"
					
			         +"body{"
					+ " display: flex;\r\n "
					+ " align-items:center;\r\n"
					+ " justify-content:center;\r\n"
					+"background-color:red;\r\n;"
					+ "}"
					+ ""
					
					
					+ ".c1{"
					+ "		height: 400px;\r\n"
					+ "		width: 350px;\r\n"
					+ "		border: 1px solid orangered;\r\n"
					+ "		background-color: yellow;\r\n"
					
			
					+ "	}"
					
					+ "</style>"
					+"</head>");
			out.print("<body>");
			out.print("<form action='EditServlet2' method='post'>");
			out.print("<div class='c1'>");
			out.print("<h1>Edit Deatils</h1>");
			out.println("<table>");
			out.println("<tr>"
					+ "<td>ID:</td>"
					+ "<td><input type='text' name='id' value="+st.getId()+"></td>"
					+ "</tr>"
					
					+"<tr>"
					+ "<td>Firstname:</td>"
					+ "<td><input type='text' name='fname' value="+st.getFirstname()+"></td>"
					+ "</tr>"
					
					+"<tr>"
					+ "<td>Lastname:</td>"
					+ "<td><input type='text' name='lname' value="+st.getLastname()+"></td>"
					+ "</tr>"
					
					+"<tr>"
					+ "<td>Branch:</td>"
					+ "<td><input type='text' name='branch' value="+st.getBranch()+"></td>"
					+ "</tr>"
					+"<tr>"
					+ "<td>Email:</td>"
					+ "<td><input type='text' name='email' value="+st.getEmail()+"></td>"
					+ "</tr>"
					+"<tr>"
					+ "<td>Password:</td>"
					+ "<td><input type='text' name='pass' value="+st.getPassword()+"></td>"
					+ "</tr>"
					
					+"<tr>"
					+ "<td>phonenumber:</td>"
					+ "<td><input type='text' name='phone' value="+st.getPhonenumber()+"></td>"
					+ "</tr>"
					+"<tr>"
					
					+ "<td>Age:</td>"
					+ "<td><input type='text' name='age' value="+st.getAge()+"></td>"
					+ "</tr>"
					+"<tr>"
					
					+ "<td>Gender:</td>"
					+ "<td><input type='text' name='gender' value="+st.getGender()+"></td>"
					+ "</tr>"
					
					+"<tr>"
					+ "<td>Address:</td>"
					+ "<td><input type='text' name='addr' value="+st.getAddress()+"></td>"
					
					+"</tr>"
					
					
//					+"<tr>"
//					+"<td></td>"
//					+"<td><button>sign-up</button></td>"
//		
//				+"</tr>"
					
					);
			
			out.print("</table>");
			out.print("<input  type='submit' value='edit&submit'>");
			out.print("</div>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
