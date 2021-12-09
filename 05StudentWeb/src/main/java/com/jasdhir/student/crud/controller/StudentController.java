package com.jasdhir.student.crud.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jasdhir.student.crud.utils.ConnectionUtils;

import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;

public class StudentController implements CrudHandler{

		PreparedStatement pstmt=null;
		ResultSet rs=null;
	
	@Override
	public void create(Context ctx) {
		// TODO Auto-generated method stub
		Connection conn=ConnectionUtils.getConnection();
		try {
			pstmt=conn.prepareStatement("insert into student(id,name,age) values (?,?,?)");
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
		
		
		ctx.redirect("/index.html");
		
		
	}

	@Override
	public void delete(Context arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAll(Context arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getOne(Context arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Context arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

}
