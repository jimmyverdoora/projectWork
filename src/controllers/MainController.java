package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author kishan
 */
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

        try {
            switch (actions[1]) {
                case "cliente":
                    ClienteZone.execAction(actions[2], request, response);
                    break;
                    /*
                case "fornitore":
                    FornitoreZone.execAction(actions[2], request, response);
                    break;
                case "admin":
                    AdminZone.execAction(actions[2], request, response);
                    break;
                     */
                default:
                    ;
            }
        } catch (ServletException | IOException ex) {
            throw new ServletException(ex);
        }

    }

}
