package com.jasdhir.student.crud;



import com.jasdhir.student.crud.controller.StudentController;

import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder;
import io.javalin.http.staticfiles.Location;

public class Main {
	public static void main(String[] args) {

        Javalin app = Javalin.create(ctx->{
        	ctx.enableCorsForAllOrigins();
        	ctx.addStaticFiles("web", Location.CLASSPATH);
        }).start(8081);

        app.routes(() -> ApiBuilder.crud("/students/{student-id}", new StudentController()));
    }
}
