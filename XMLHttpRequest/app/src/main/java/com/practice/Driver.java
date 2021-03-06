/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.practice;

import com.practice.handlers.LoginHandler;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;


public class Driver {
    public static LoginHandler lh = new LoginHandler();

    public static void main(String[] args) {
        Javalin server = Javalin.create(config -> {
            config.addStaticFiles("/public", Location.CLASSPATH);
            config.enableCorsForAllOrigins();
        });

        server.post("/login", lh.getLogin);
        server.get("/display", lh.retDb);

        server.start(8000);
    }
}
