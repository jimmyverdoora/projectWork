package controllers;

import log.Generic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MainController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getRequestURI();
        Generic.log("a", "b", action);
        String[] actions = action.split("/");
        actions[1] = actions[2];
        if (actions.length > 3) {
            actions[2] = actions[3];
        }

        if (actions[1].equals("cliente") && request.getSession().getAttribute("ruolo").equals("cliente")) {
            ClienteZone.execAction(actions[2], request, response);
        }
        else if (actions[1].equals("fornitore") && request.getSession().getAttribute("ruolo").equals("fornitore")) {
            FornitoreZone.execAction(actions[2], request, response);
        }
        else if (actions[1].equals("admin") && request.getSession().getAttribute("ruolo").equals("admin")) {
            AdminZone.execAction(actions[2], request, response);
        }
        else if (actions[1].equals("dologin")) {
            LoginEngine.performLogin(request, response);
        }
        else if (actions[1].equals("doregistration")) {
            RegistrationEngine.performRegistration(request, response);
        }
        else {
            showHome(request, response);
        }

    }

    private static void showHome(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

}
