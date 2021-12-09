package com.jasdhir.javalin;

import com.jasdhir.javalin.controller.HelloController;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx->ctx.result("Hello World"));
        app.get("/hello", ctx->ctx.result("Hello World Again"));
        
        app.get("/helloHandler", HelloController.sayHello);
        
        app.get("/helloJSON", HelloController.getJSON);
        
        app.get("/student", HelloController.getStudent);
        
        
        
    }
}
