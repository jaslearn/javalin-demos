package com.jasdhir.javalin.userproject;

import java.io.PrintWriter;
import java.util.NoSuchElementException;

import com.jasdhir.javalin.userproject.controller.UserController;
import com.jasdhir.javalin.userproject.model.User;
import io.javalin.Javalin;

public class JavalinApp {
public static void main(String[] args) {
	Javalin app=Javalin.create().start(7000);
	
	app.get("/users", UserController.fetchAllUsernames);
	  app.get("/users/{id}", UserController.fetchById);
	
	  app.exception(NoSuchElementException.class, (e, ctx) -> {
			  ctx.html("User Not Found"); });
	app.error(404, ctx->{ctx.html("Not Found Error");});
	
	
	app.post("/users" , ctx ->{
        User user = ctx.bodyAsClass(User.class);
//        System.out.println(user);
//        PrintWriter out=ctx.res.getWriter();
//        out.print(user);
      });
}
}
