package controllers;

import model.User;
import play.*;
import play.mvc.*;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;


import services.UserServices;
import services.impl.UserServicesImpl;
import views.html.*;

public class Application extends Controller {


    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result login() {
        return ok(
                login.render(
                        Form.form(Login.class)
                )
        );
    }

    public static Result register() {
        return ok(registro.render());
    }

    public static Result datos() {
        return ok(datos.render());

    }

    public static Result obsrv() {
        return ok(observaciones.render());
    }

    public static Result validateUser() {


        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session().clear();
            session("email", loginForm.get().usuario);
            return redirect(
                    routes.Application.index()
            );
        }

    }

    public static class Login {
        public String usuario;
        public String password;

        public String validate() {
            UserServices us = new UserServicesImpl();       // cambiar por una factoria
            User user = us.getUserByID(usuario);
            if (user != null && (user.getPassword() == password)) {
                return null;    //TODO OK
            } else {
                return "Invalid username or password";
            }
        }

    }
}