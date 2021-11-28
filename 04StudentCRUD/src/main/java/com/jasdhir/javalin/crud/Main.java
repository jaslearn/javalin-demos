package com.jasdhir.javalin.crud;

import io.javalin.Javalin;
import com.jasdhir.javalin.crud.controller.StudentController;
import io.javalin.apibuilder.ApiBuilder;
public class Main {

    public static void main(String[] args) {

        Javalin app = Javalin.create(ctx->{
        	ctx.enableCorsForAllOrigins();
        }).start(8080);

        app.routes(() -> ApiBuilder.crud("/students/{student-id}", new StudentController()));
    }

	
}
