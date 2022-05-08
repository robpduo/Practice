package com.practice.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.dao.LoginDao;
import com.practice.models.LoginModel;
import io.javalin.http.Handler;
import org.eclipse.jetty.util.log.Log;

public class LoginHandler {
    private ObjectMapper om;
    LoginDao ld = null;

    public LoginHandler () {
        this.om = new ObjectMapper();
    }

    public Handler getLogin = (ctx) -> {
        ld = new LoginDao();

        LoginModel lm = om.readValue(ctx.body(), LoginModel.class);

        ld.createUser(lm);

        System.out.println("Results: " + lm.toString());

        ctx.status(201);
        ctx.result(om.writeValueAsString(lm.toString()));
    };

    public Handler retDb = (ctx) -> {
        ld = new LoginDao();

        ctx.result(om.writeValueAsString(ld.displayAll()));
        ctx.status(200);
    };



}
