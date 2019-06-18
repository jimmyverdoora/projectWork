package controllers;

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

        String action = request.getServletPath();
        String[] actions = action.split("/");

        if (actions.length < 2) {
            showHome(request, response);
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("Homepage.jsp");
        dispatcher.forward(request, response);
    }

}
