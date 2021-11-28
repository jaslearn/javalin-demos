package com.jasdhir.javalin.userproject.controller;

import java.util.Objects;
import com.jasdhir.javalin.userproject.model.User;
import com.jasdhir.javalin.userproject.dao.UserDao;

import io.javalin.http.Handler;

public class UserController {
	 public static Handler fetchAllUsernames = ctx -> {
	        UserDao dao = UserDao.instance();
	        Iterable<String> allUsers = dao.getAllUsernames();
	        ctx.json(allUsers);
	    };
	    
 public static Handler fetchById = ctx -> {
	    	
	        int id = Integer.parseInt(Objects.requireNonNull(ctx.pathParam("id")));
	        UserDao dao = UserDao.instance();
	       User user = dao.getUserById(id).orElseThrow();
	        System.out.print("User " +user);
	        if (user == null) {
	            ctx.html("Not Found");
	        } else {
	            ctx.json(user);
	        }
	    };
}
