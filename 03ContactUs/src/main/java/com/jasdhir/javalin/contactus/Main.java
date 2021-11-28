package com.jasdhir.javalin.contactus;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {

public static void main(String[] args) {
	
	Javalin app = Javalin.create(
			config->{
				config.addStaticFiles("web", Location.CLASSPATH);
			}
			).start(7000);
	
	app.post("/contact-us", ctx -> {
        String fullName = ctx.formParam("firstName") + " " + ctx.formParam("lastName");
        String subject = ctx.formParam("subject");
        String message = ctx.formParam("message");
        System.out.println("Message received from " + fullName);
        System.out.println("Subject: " + subject);
        System.out.println(message);
        ctx.redirect("/success.html");
    });


}
}