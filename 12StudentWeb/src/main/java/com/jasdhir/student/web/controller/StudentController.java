package com.jasdhir.student.web.controller;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jasdhir.student.web.model.Student;
import com.jasdhir.student.web.utils.ConnectionUtils;

import io.javalin.http.Handler;

public class StudentController {

	 public static Handler getAllStudents = ctx -> {
		 ArrayList<Student> students=new ArrayList<>();
	     Connection  conn=ConnectionUtils.getConnection();
	       PreparedStatement pstmt=conn.prepareStatement("select * from student");
	       ResultSet rs=pstmt.executeQuery();
	       while(rs.next()) {
	    	   Student s=new Student(rs.getInt(1),rs.getString(2),rs.getInt(3));
	    	   students.add(s);  
	       }
	       ctx.json(students);
	    };
	    
	    public static Handler addStudent = ctx -> {
			 	
	    	Connection conn=ConnectionUtils.getConnection();
			try {
				PreparedStatement pstmt=conn.prepareStatement("insert into student(id,name,age) values (?,?,?)");
				int id=Integer.parseInt(ctx.formParam("sid"));
				String name=ctx.formParam("name");
				int age=Integer.parseInt(ctx.formParam("age"));
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setInt(3, age);
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			ctx.redirect("/displayAllStudent.html");
		    };
}
