package com.jasdhir.student.web;

import com.jasdhir.student.web.controller.StudentController;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {
public static void main(String[] args) {
	 Javalin app = Javalin.create(ctx->{
     	ctx.enableCorsForAllOrigins();
     	ctx.addStaticFiles("web", Location.CLASSPATH);
     }).start(8081);
	 
	app.get("/students", StudentController.getAllStudents);
	app.post("/students", StudentController.addStudent);
}
}
