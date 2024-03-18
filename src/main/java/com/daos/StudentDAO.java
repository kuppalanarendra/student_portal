
package com.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dtos.Student;

public class StudentDAO {

	public boolean createStudentAccount(Student s) throws ClassNotFoundException, SQLException {
		boolean status=false;
		// Loading the driver class
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Creation of connection object
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle1");
		String sql="insert into studentinfo1 values(?,?,?,?,?,?,?,?,?,?)";	
		//creation of statement object
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setInt(1, s.getId());
		psmt.setString(2, s.getFirstname());
		psmt.setString(3, s.getLastname());
		psmt.setString(4, s.getBranch());
		psmt.setString(5, s.getEmail());
		psmt.setString(6, s.getPassword());
		psmt.setLong(7, s.getPhonenumber());
		psmt.setInt(8, s.getAge());
		psmt.setString(9, s.getGender());
		psmt.setString(10,s.getAddress());
		int i=psmt.executeUpdate();
		if(i>0) {
			status=true;
		}
		return status;
	}

	public boolean validteStudentDetails(String email, String password) throws ClassNotFoundException, SQLException {
		boolean status=false;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Creation of connection object
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle1");
		String sql="select * from studentinfo1 where email =? and password=?";
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setString(1, email);
		psmt.setString(2, password);
		ResultSet rs=psmt.executeQuery();
		if(rs.next()) {
			   status=true;
		   }
		
		
		return status;
	}

	public List<Student> getStudentDetails() throws ClassNotFoundException, SQLException {
		List<Student> stddetails= new ArrayList<>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Creation of connection object
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle1");
		String sql="select * from studentinfo1";
		PreparedStatement psmt=con.prepareStatement(sql);
		ResultSet rs= psmt.executeQuery();
		while(rs.next()) {
			Student s= new Student();
		s.setId(rs.getInt(1));
		s.setFirstname(rs.getString(2));
		s.setLastname(rs.getString(3));
		s.setBranch(rs.getString(4));
		s.setEmail(rs.getString(5));
		s.setPassword(rs.getString(6));
		s.setPhonenumber(rs.getLong(7));
		s.setAge(rs.getInt(8));
		s.setGender(rs.getString(9));
		s.setAddress(rs.getString(10));
		stddetails.add(s);
		}
		
		return stddetails;
	}

	public Student getStudent(int id1) throws ClassNotFoundException, SQLException {
		Student s= new Student();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Creation of connection object
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle1");
		String sql="select * from studentinfo1 where id=?";
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setInt(1, id1);
		ResultSet rs=psmt.executeQuery();
		while(rs.next()) {
			s.setId(rs.getInt(1));
			s.setFirstname(rs.getString(2));
			s.setLastname(rs.getString(3));
			s.setBranch(rs.getString(4));
			s.setEmail(rs.getString(5));
			s.setPassword(rs.getString(6));
			s.setPhonenumber(rs.getLong(7));
			s.setAge(rs.getInt(8));
			s.setGender(rs.getString(9));
			s.setAddress(rs.getString(10));
		}
		
		
		return s;
	}

	public boolean updateStudent(Student s) throws ClassNotFoundException, SQLException {
		boolean status=false;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Creation of connection object
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle1");
		String sql="update studentinfo1 set firstname=?, lastname=?, branch=?, email=?, password=?, phonenumber=?,age=?, gender=?, address=? where id=?";
	    PreparedStatement psmt=con.prepareStatement(sql);
	    psmt.setString(1, s.getFirstname());
		psmt.setString(2, s.getLastname());
		psmt.setString(3, s.getBranch());
		psmt.setString(4, s.getEmail());
		psmt.setString(5, s.getPassword());
		psmt.setLong(6, s.getPhonenumber());
		psmt.setLong(7, s.getAge());
		psmt.setString(8, s.getGender());
		psmt.setString(9, s.getAddress());
		psmt.setInt(10,s.getId());
		int i=psmt.executeUpdate();
		if(i>0) {
			status=true;
		}
        return status;
	}

	public boolean deleteStudent(int id1) throws ClassNotFoundException, SQLException {
		boolean status=false;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//oracle.jdbc.driver.OracleDriver
		// creation of Connection object
		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle1");
	     String sql="delete from studentinfo1 where id=?";
	    PreparedStatement psmt= con.prepareStatement(sql);
	    psmt.setInt(1, id1);
	    int i=psmt.executeUpdate();
	    if(i>0) {
	    	status=true;
	    }
		return status;
	}

}
